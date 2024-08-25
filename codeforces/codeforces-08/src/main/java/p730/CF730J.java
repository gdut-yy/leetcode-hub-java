package p730;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF730J {
    static int n;
    static int[] a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static final int INF = (int) 1e9;

    private static String solve() {
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) ids[i] = i;
        Arrays.sort(ids, (o1, o2) -> Integer.compare(b[o2], b[o1]));

        int m = 0;
        int sa = Arrays.stream(a).sum();
        int sb = 0;
        for (int i = 0; i < n; i++) {
            int id = ids[i];
            sb += b[id];
            if (sb >= sa) {
                m = i + 1;
                break;
            }
        }

        int[][] f = new int[m + 1][sb + 1];
        for (int i = 0; i < m + 1; i++) {
            Arrays.fill(f[i], -INF);
        }
        f[0][0] = 0;
        for (int i = 0; i < n; i++) {
            int id = ids[i];
            for (int j = m; j > 0; j--) {
                for (int k = sb; k >= b[id]; k--) {
                    f[j][k] = Math.max(f[j][k], f[j - 1][k - b[id]] + a[id]);
                }
            }
        }

        int maxSave = 0;
        for (int j = sa; j < sb + 1; j++) {
            maxSave = Math.max(maxSave, f[m][j]);
        }
        return m + " " + (sa - maxSave);
    }
}
/*
J. Bottles
https://codeforces.com/contest/730/problem/J

灵茶の试炼 2023-07-06
题目大意：
输入 n(1≤n≤100) 和两个长为 n 的数组 a b (1≤a[i]≤b[i]≤100)。
有 n 个水桶，第 i 个水桶装了 a[i] 单位的水，水桶容量为 b[i]。
花费 1 秒，可以从某个水桶中，转移 1 个单位的水，到另一个水桶。
输出两个数：
把水汇集起来，最少需要多少个桶（换句话说需要倒空尽量多的桶），该情况下至少要多少秒完成？

rating 1900
最少需要多少个桶？这可以贪心地按照 b[i] 从大到小选择，直到选择的 b[i] 之和 >= sum(a) 为止。
假设最少需要 m 个桶。
在 m 个桶的前提下，至少要多少秒完成？
正难则反，考虑最多有多少单位的水是不需要转移的。
把 b[i] 看成物品体积，a[i] 看成物品价值，变成 0-1 背包问题：
定义 f[i][j][k] 表示从前 i 个桶中恰好选 j 个桶，这 j 个桶的容量之和恰好为 k 的情况下，最多有 f[i][j][k] 单位的水是不需要转移的。
状态转移方程为：f[i][j][k] = max(f[i-1][j][k], f[i-1][j-1][k-b[i]]+a[i])。
初始值：f[0][0][0] = 0，其余为负无穷大。
答案为：sum(a)-max(f[n][m][sum(a):])。
（注意这里我是用【恰好】定义的，k 需要从 sum(a) 枚举到 sum(b)。用【至少】定义 k 也是可以的。）
代码实现时，f 的第一个维度可以省略。
https://codeforces.com/contest/730/submission/212163529
优化版本：https://codeforces.com/contest/730/submission/212164117
@hqztrue: O~(n^1.5*u)的做法，其中n是桶数，u是桶大小
https://codeforces.com/contest/730/submission/212319261
======

input
4
3 3 4 3
4 7 6 5
output
2 6

input
2
1 1
100 100
output
1 1

input
5
10 30 5 6 24
10 41 7 8 24
output
3 11
 */
