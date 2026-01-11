package p226;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF226C {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static int MOD;

    private static void solve() {
        MOD = scanner.nextInt();
        long l = scanner.nextLong();
        long r = scanner.nextLong();
        long k = scanner.nextLong();

        l--;
        long n = 0;
        for (long i = 1; i * i <= r; i++) {
            long j = r / i;
            if (r / j - l / j >= k) {
                n = j;
                break;
            }
            if (r / i - l / i >= k) {
                n = i;
            }
        }

        long[][] m = {{1, 1}, {1, 0}};
        long[][] f1 = {{1}, {0}};
        m = matQuickPow(m, n - 1);
        long[][] fn = matMulti(m, f1);
        out.println(fn[0][0] % MOD);
    }

    // 矩阵快速幂 res = a^n
    static long[][] matQuickPow(long[][] a, long n) {
        int m = a.length;
        long[][] c = new long[m][m];
        for (int i = 0; i < m; i++) c[i][i] = 1;
        while (n > 0) {
            if ((n & 1) == 1) c = matMulti(c, a);
            n >>= 1;
            a = matMulti(a, a);
        }
        return c;
    }

    // 矩阵快速幂 res = a * b
    static long[][] matMulti(long[][] a, long[][] b) {
        int n = a.length, p = b.length, m = b[0].length;
        long[][] c = new long[n][m];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < p; k++) {
                for (int j = 0; j < m; j++) {
                    c[i][j] = (c[i][j] + a[i][k] * b[k][j] % MOD) % MOD;
                }
            }
        }
        return c;
    }
}
/*
C. Anniversary
https://codeforces.com/contest/226/problem/C

灵茶の试炼 2025-10-03
题目大意：
输入 mod(1≤mod≤1e9) L R(1≤L<R≤1e12) k(2≤k≤r-l+1)。
定义斐波那契数列 F(1)=F(2)=1，F(n)=F(n-1)+F(n-2) (n≥3)。
从 [L,R] 中选择恰好 k 个不同整数，计算这 k 个数的 F(i) 的 GCD。
比如选择 2,4,5，那么计算的是 GCD(F(2), F(4), F(5))。
输出 GCD 的最大值，模 mod。
注意：先满足 GCD 最大，再算 mod。

rating 2400
斐波那契数列有如下性质：
gcd(F(i),F(j)) = F(gcd(i,j))
证明可以搜索相关资料。
这个性质可以推广到 k 个数的情况。
由于 gcd 越大答案越大，所以问题变成：
找一个最大的整数 g，满足 [l,r] 中有至少 k 个整数是 g 的倍数。
最暴力的想法是，枚举 i=1,2,3,...,r。这里用 i 表示 g。判断倍数个数 r/i - (l-1)/i >= k 是否成立，求满足该不等式的最大 i。
这显然会超时，如何减少枚举次数？
下面的除法自带下取整。
以 r=11 为例。
检查 i=1,2,3，对于 i*i > r 的情况无需检查，为什么？
因为 r/i 的对称性。
i = 1 时，r/6 到 r/11 都是 1。
i = 2 时，r/4 到 r/5 都是 2。其中 5 是怎么算的？r/2。其中 4 是怎么算的？r/3+1。
这样就把 i=4,5,...,11 的情况都覆盖了。
设 j=r/i，在 r/j 不变的情况下，由于 j 越大，r/j - (l-1)/j 越大（因为 (l-1)/j 越小），
所以我们只需检查 i*i<=n 的 i 和 r/i。
求出满足要求的最大整数 g 后，计算 F(g)。
这可以用矩阵快速幂。
注意 mod=1 的情况。
代码 https://codeforces.com/contest/226/submission/341317004
代码备份（上面打不开的同学看这个）
======

Input
10 1 8 2
Output
3

Input
10 1 8 3
Output
1

1000000000 999000000000 1000000000000 1000000001
 */
