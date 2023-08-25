package c253;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc253_e {
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
        long[] s = new long[m + 1];
        for (int i = 0; i < m + 1; i++) {
            s[i] = i;
        }

        // for ; n > 1; n-- {
        for (int i = 0; i < n - 1; i++) {
            long[] sf = new long[m + 1];
            for (int j = 0; j < m; j++) {
                long fj = s[m];
                if (k > 0) {
                    fj -= s[Math.min(j + k, m)] - s[Math.max(j - k + 1, 0)];
                }
                sf[j + 1] = (sf[j] + fj) % MOD;
            }
            s = sf;
        }
        long ans = (s[m] + MOD) % MOD;
        return String.valueOf(ans);
    }
}
/*
E - Distance Sequence
https://atcoder.jp/contests/abc253/tasks/abc253_e

灵茶の试炼 2023-08-15
题目大意：
输入 n(2≤n≤1000) m k(0≤k<m≤5000)。
输出有多少个长为 n 的数组，满足元素范围为 [1,m] 且 abs(a[i]-a[i+1]) >= k。
模 998244353。

https://atcoder.jp/contests/abc253/submissions/44438512
前缀和优化 DP。
定义 f[i][j] 表示考虑前 i 个数，其中 a[i]=j 的方案数。
根据要求，从所有 abs(j-j') >= k 的 f[i-1][j'] 转移过来，这个和式可以用前缀和优化成 O(1)。
初始值 f[0][j] = 1。
答案为 sum(f[n-1])。
======

Input 1
2 3 1
Output 1
6

Input 2
3 3 2
Output 2
2

Input 3
100 1000 500
Output 3
657064711
 */