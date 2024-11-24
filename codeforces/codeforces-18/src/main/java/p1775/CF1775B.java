package p1775;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CF1775B {
    static int n, k;
    static int[][] a;
    static Map<Integer, Integer> cnt;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n][];
            cnt = new HashMap<>();
            for (int i = 0; i < n; i++) {
                k = scanner.nextInt();
                a[i] = new int[k];
                for (int j = 0; j < k; j++) {
                    a[i][j] = scanner.nextInt();
                    cnt.merge(a[i][j], 1, Integer::sum);
                }
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        nxt:
        for (int[] r : a) {
            for (int v : r) {
                if (cnt.getOrDefault(v, 0) == 1) {
                    continue nxt;
                }
            }
            return "Yes";
        }
        return "No";
    }
}
/*
B. Gardener and the Array
https://codeforces.com/contest/1775/problem/B

灵茶の试炼 2024-04-23
题目大意：
输入 T(≤1e5) 表示 T 组数据。所有数据的 k 之和 ≤1e5。
每组数据输入 n(1≤n≤1e5) 和 n 行，每行输入 k(1≤k≤1e5) 和 k 个不同数字，范围 [1,2e5]。
这 k 个数字表示一个二进制数比特 1 的位置。
例如给你 2,3,5 表示二进制 101100（从右往左读）。
所以，输入相当于给你一个长为 n 的数组，包含 n 个二进制数。
你需要从数组中选择两个不同的子序列，使得这两个子序列的 OR（按位或）相等。
能否做到？输出 Yes 或 No。
注：子序列不要求连续。
注：只要有一个元素的下标不在另一个子序列的元素下标中，两个子序列就算不同的。
例如 [1,1,1] 中有 三个 不同的子序列 [1,1]。

rating 1300
统计每个比特位上有多少个 1，记到 cnt 数组中，cnt[i] 表示第 i 个比特位的 1 的个数。
如果每个二进制数，都有一个独一无二的 1（其它二进制在这个比特位上都是 0），那么本题无解，输出 NO。
否则输出 YES。
构造方案：
第一个子序列就是整个数组。
第二个子序列只需要从整个数组中删除一个二进制数，它满足每个比特值等于的 1 的 cnt[i] 都 >= 2。
https://codeforces.com/problemset/submission/1775/254685492
======

Input
5
3
2 1 5
2 2 4
2 2 3
2
2 1 2
1 2
4
3 1 2 4
2 2 4
4 1 2 5 6
2 2 5
5
3 3 1 2
3 2 5 3
5 7 2 3 1 4
5 1 2 6 3 5
3 2 6 3
2
1 1
1 2
Output
No
Yes
Yes
Yes
No
 */
