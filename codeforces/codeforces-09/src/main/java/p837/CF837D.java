package p837;

import java.util.Arrays;
import java.util.Scanner;

public class CF837D {
    static int n, k;
    static long[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }
        System.out.println(solve());
    }

    private static String solve() {
        long[][] f = new long[k + 1][k * 25 + 1];
        for (int i = 0; i < k + 1; i++) {
            Arrays.fill(f[i], -1);
        }
        f[0][0] = 0;
        for (long v : a) {
            int cnt2 = cntX(v, 2);
            int cnt5 = cntX(v, 5);
            for (int i = k; i >= 1; i--) {
                for (int j = k * 25; j >= cnt5; j--) {
                    if (f[i - 1][j - cnt5] >= 0) {
                        f[i][j] = Math.max(f[i][j], f[i - 1][j - cnt5] + cnt2);
                    }
                }
            }
        }

        long ans = 0;
        for (int i = 0; i < f[k].length; i++) {
            ans = Math.max(ans, Math.min(i, f[k][i]));
        }
        return String.valueOf(ans);
    }

    // cnt2 := bits.TrailingZeros64(v)
    static int cntX(long v, int x) {
        int cnt = 0;
        while (v % x == 0) {
            v /= x;
            cnt++;
        }
        return cnt;
    }
}
/*
D. Round Subset
https://codeforces.com/contest/837/problem/D

灵茶の试炼 2022-09-15
题目大意：
输入 n k (1≤k≤n≤200) 和一个长为 n 的数组 a (1≤a[i]≤1e18)。
从 a 中选择一个长为 k 的子序列，设这 k 个数的乘积为 m。
输出 m 的末尾 0 的个数的最大值。
子序列不一定连续。

rating 2100
https://codeforces.com/contest/837/submission/172210710
循环优化 https://codeforces.com/contest/837/submission/172219030
提示 1：转换成二维费用的 0-1 背包。
提示 2：物品可以看成「个数=1个，体积=因子5的个数，价值=因子2的个数」。
提示 3：定义 f[i][j][p] 表示前 i 个数字，选 j 个，因子 5 的个数等于 p 时，因子 2 的个数的最大值。
根据 01 背包，有 f[i][j][p] = max(f[i-1][j][p], f[i-1][j-1][p-cnt5[i]] + cnt2[i])。其中 cnt2[i] 和 cnt5[i] 为 a[i] 的因子 2 和因子 5 的个数。
初始项 f[0][0][0] = 0，其余为 -∞。
答案为 max{min(i, f[n][k][i])}。
代码实现时，第一个维度可以优化掉。(倒序循环）
注：对于每个数，因子 5 的个数至多有 25 个。
======

input
3 2
50 4 20
output
3

input
5 3
15 16 3 25 9
output
3

input
3 3
9 77 13
output
0
 */