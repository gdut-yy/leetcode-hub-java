package p60;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CF60E {
    // Stuck in sleigh traffic on flight 21
//    static Scanner scanner = new Scanner(System.in);
    static FastReader scanner = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        long x = scanner.nextLong();
        long y = scanner.nextLong();
        MOD = scanner.nextInt();

        int[] a = new int[n];
        int s0 = 0;
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            s0 = (s0 + a[i]) % MOD;
        }

        if (n == 1) {
            out.println(s0);
            return;
        }

        long[][] m = {{1, 1}, {1, 0}};
        long[][] f0 = {{a[n - 1]}, {a[n - 2]}};
        m = matQuickPow(m, x);
        long big = matMulti(m, f0)[0][0];

        long sx = f(s0, -a[0] - a[n - 1], x);
        long result = (f(sx, -a[0] - big, y) + MOD) % MOD;
        out.println(result);
    }

    // 模拟函数 f(s0, c, x)
    static long f(long s0, long c, long x) {
        long[][] m2 = {{3, 1}, {0, 1}};
        long[][] f0_2 = {{s0}, {c}};
        m2 = matQuickPow(m2, x);
        return matMulti(m2, f0_2)[0][0];
    }

    private static int MOD = (int) (1e9 + 7);

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

    static class FastReader {
        private final BufferedReader bufferedReader;
        private StringTokenizer stringTokenizer;

        public FastReader() {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringTokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            String str = "";
            try {
                if (stringTokenizer.hasMoreTokens()) {
                    str = stringTokenizer.nextToken("\n");
                } else {
                    str = bufferedReader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
/*
E. Mushroom Gnomes
https://codeforces.com/contest/60/problem/E

灵茶の试炼 2025-10-10
题目大意：
输入 n(1≤n≤1e6) x y(0≤x,y≤1e18, x+y>0) mod(2≤mod≤1e9) 和长为 n 的递增数组 a(0≤a[i]≤1e9)。
有 n 个蘑菇排成一行，重量 a[i] 从左到右依次递增。
每过一分钟，在每一对相邻蘑菇 (p,q) 之间，会长出一个重量为 p+q 的蘑菇。
x 分钟后，把所有蘑菇重新排列，重量从左到右依次递增。
然后再过 y 分钟，输出此时所有蘑菇的重量之和，模 mod。

rating 2600
先算 x 分钟后的总重量。
设当前总重量为 S，一分钟后，总重量变成多少了？
newS = S + (a1+a2) + (a2+a3) + ... + (a_{n-1}+an)
     = S + 2S - (a1+an)
     = 3S - (a1+an)
设 C = -(a1+an)，则递推式为
S[i] = 3*S[i-1] + C
这是一个包含常系数的递推式，用矩阵乘法表示为
[S[i],C]^T = [[3,1],[0,1]] * [S[i-1],C]^T
用矩阵快速幂优化。
初始值 S[0] = sum(a)。
答案为 S[x]。
在此基础上，算 y 分钟后的总重量。
推导过程和上面是一样的，唯一的区别是 an。最小蘑菇 a1 是不变的，最大蘑菇变成多少了？
考虑最后两个蘑菇 p=a_{n-1}, q=an。
一分钟后，最大蘑菇是 p+q，原来的最大蘑菇 q 变成次大蘑菇，并且最大和次大仍然是相邻的，所以再过一分钟，新产生的最大蘑菇是原来的最大+次大，新的次大蘑菇是原来的最大蘑菇。
这和斐波那契数列的 O(1) 空间算法是一样的。
对于斐波那契数列，我们可以用矩阵快速幂计算，见 LC70. 爬楼梯 我的题解。
细节：
1. 注意 C 是负数，输出答案的时候要调整成非负数。
2. 特判 n=1 的情况。
代码 https://codeforces.com/contest/60/submission/342666398
代码+快读
代码备份（上面打不开的同学看这个）
======

Input
2 1 0 657276545
1 2
Output
6

Input
2 1 1 888450282
1 2
Output
14

Input
4 5 0 10000
1 2 3 4
Output
1825
 */
