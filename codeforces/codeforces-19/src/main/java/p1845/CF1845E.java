package p1845;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1845E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve(n, k, a));
    }

    private static final int MOD = (int) (1e9 + 7);

    // https://codeforces.com/contest/1845/submission/211491352
    private static String solve(int n, int k, int[] a) {
        int m = 0;
        int[] b = new int[n + 1];
        int[][] f = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            m += a[i];
        }
        if (m > n >> 1) {
            for (int i = 1; i <= n; i++) {
                a[i] ^= 1;
            }
        }
        m = 0;
        for (int i = 1; i <= n; i++) {
            if (a[i] == 1) b[++m] = i;
        }
        f[0][0] = 1;
        int cur = 0;
        for (int i = 1; i <= n; i++, cur ^= 1) {
            for (int j = Math.min(m, i) - 1; j >= 0; j--) {
                int d = Math.abs(b[j + 1] - i);
                for (int x = 0; x <= k - d; x++) {
                    f[j + 1][x + d] = (f[j + 1][x + d] + f[j][x]) % MOD;
                }
            }
        }
        int ans = 0;
        for (int i = k; i >= 0; i -= 2) {
            ans = (ans + f[m][i]) % MOD;
        }
        return String.valueOf(ans);
    }
}
/*
E. Boxes and Balls
https://codeforces.com/contest/1845/problem/E

题目大意：
有 n 个盒子排成一行。盒子从 1 到 n 编号。有些盒子里只有一个球，其余的都是空的。至少有一个盒子里有球，至少有一个盒子是空的。
在一个动作中，你必须选择一个里面有球的盒子和一个相邻的空盒子，然后把球从一个盒子移到另一个盒子里。框框 i 和 i+1 对于从 1 到 n-1 的所有 i 被认为是彼此相邻的。盒子 1 和 n 不相邻。
在完成 k 步之后，有多少种不同的球排列?如果至少有一个这样的盒子，其中一个盒子里有一个球，而另一个盒子里没有球，那么两种安排就被认为是不同的。
因为答案可能相当大，所以输出余数对 10^9+7 取模。

dp 递推？
======

input
4 1
1 0 1 0
output
3

input
4 2
1 0 1 0
output
2

input
10 6
1 0 0 1 0 0 0 1 1 1
output
69
 */
