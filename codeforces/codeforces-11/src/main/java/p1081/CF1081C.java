package p1081;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1081C {
    static int n, m, k;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();
        System.out.println(solve());
    }

    private static final int MOD = 998244353;

    private static String solve() {
        long[] f = new long[k + 1];
        f[0] = m;
        for (int i = 1; i < n; i++) {
            for (int j = k; j > 0; j--) {
                f[j] = (f[j] + f[j - 1] * (m - 1)) % MOD;
            }
        }
        return String.valueOf(f[k]);
    }
}
/*
C. Colorful Bricks
https://codeforces.com/contest/1081/problem/C

灵茶の试炼 2023-06-27
题目大意：
输入 n m(1≤n,m≤2000) k(0≤k≤n-1)。
n 块砖排成一排，把每块砖涂成 m 种颜色中的一种，要求恰好有 k 块砖的颜色与其左边相邻砖的颜色不同（第一块砖不能在这 k 块砖内）。
输出涂色方案数，模 998244353。

https://codeforces.com/problemset/submission/1081/211192029
定义 f[i][j] 表示前 i 块砖，有 j 块砖的颜色与其左边相邻砖的颜色不同，此时的涂色方案数。
第一块砖随便涂色，f[0][0] = m。
考虑第 i 块砖「选或不选」，也就是：
颜色相同：f[i][j] = f[i-1][j]
颜色不同：f[i][j] = f[i-1][j-1] * (m-1)
相加得 f[i][j] = f[i-1][j] + f[i-1][j-1] * (m-1)
答案为 f[n-1][k]。
代码实现时可以用滚动数组优化。
另一种思路是从 n-1 块砖中选 k 块砖，颜色和左边不一样，
所以方案数是 C(n-1,k) * m * (m-1)^k，预处理阶乘可以做到 O(n)。
======

input
3 3 0
output
3

input
3 2 1
output
4
 */
