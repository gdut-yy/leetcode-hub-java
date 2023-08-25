package c262;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc262_d {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static final int MOD = 998244353;

    private static String solve() {
        long ans = 0;
        long[][] f = new long[n + 1][];
        for (int m = 1; m <= n; m++) {
            for (int i = 0; i <= m; i++) {
                f[i] = new long[m];
            }
            f[0][0] = 1;
            for (int x : a) {
                for (int j = m; j > 0; j--) {
                    for (int k = 0; k < m; k++) {
                        f[j][(k + x) % m] = (f[j][(k + x) % m] + f[j - 1][k]) % MOD;
                    }
                }
            }
            ans += f[m][0];
        }
        return String.valueOf(ans % MOD);
    }
}
/*
D - I Hate Non-integer Number
https://atcoder.jp/contests/abc262/tasks/abc262_d

灵茶の试炼 2023-08-08
题目大意：
输入 n(1≤n≤100) 和长为 n 的数组 a(1≤a[i]≤1e9)。
如果一个非空子序列的平均值是整数，那么称其为漂亮的。
输出 a 的漂亮子序列的个数，模 998244353。
注：子序列不一定连续。

https://atcoder.jp/contests/abc262/submissions/44370034
枚举子序列的长度。
考虑子序列长度固定为 m 时，有多少个平均值为整数的子序列。
相当于子序列的元素和模 m 为 0。
用选或不选来思考。
定义 f[i][j][k] 表示从前 i 个数中选 j 个数，元素和模 m 为 k 的方案数。
为方便计算取模，用刷表法（用查表法的话，需要算 (k-a[i])%m，可能会算出负数）：
f[i][j][(k+a[i])%m] = f[i-1][j][(k+a[i])%m] + f[i-1][j-1][k]
答案为 f[n][m][0]。
代码实现时，第一个维度可以去掉，然后像 0-1 背包那样倒序循环 j。初始值 f[0][0] = 1。
======

Input 1
3
2 6 2
Output 1
6

Input 2
5
5 5 5 5 5
Output 2
31
 */