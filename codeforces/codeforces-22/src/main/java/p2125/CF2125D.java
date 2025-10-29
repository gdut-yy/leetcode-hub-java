package p2125;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CF2125D {
    // Time limit exceeded on test
//    static Scanner scanner = new Scanner(System.in);
    static FastReader scanner = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    private static final int MOD = 998244353;

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    record pair(int l, long p) {
    }

    private static void solve() {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<pair>[] g = new ArrayList[m + 1];
        Arrays.setAll(g, e -> new ArrayList<>());
        long notP = 1;
        for (int i = 0; i < n; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            long p = scanner.nextInt();
            int q = scanner.nextInt();

            p = p * quickPow(q, MOD - 2) % MOD;
            g[r].add(new pair(l, p));
            notP = notP * (1 - p) % MOD;
        }

        long[] f = new long[m + 1];
        f[0] = notP;
        for (int i = 0; i < m + 1; i++) {
            for (pair p : g[i]) {
                f[i] = (f[i] + f[p.l - 1] * p.p % MOD * quickPow(1 - p.p, MOD - 2)) % MOD;
            }
        }
        long ans = (f[m] + MOD) % MOD;
        out.println(ans);
    }

    // 快速幂 res = a^b % mod
    static long quickPow(long a, long b) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) != 0) res = res * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
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
D. Segments Covering
https://codeforces.com/contest/2125/problem/D

灵茶の试炼 2025-08-27
题目大意：
输入 n(1≤n≤2e5) m(1≤m≤2e5)。
然后输入 n 个闭区间，每个区间输入 l r(1≤l≤r≤m) p q(1≤p<q<998244353)，表示这个区间存在的概率为 p/q。
有 m 个点，编号从 1 到 m。
输出每个点都恰好被一个区间覆盖的概率。
设答案为最简分数 x/y，你需要输出 x*pow(y,mod-2)%mod，其中 mod=998244353。

rating 1600
为方便计算，首先假设所有区间都不选，概率 np 为所有区间的 1-P 的乘积，其中 P = p/q。
然后「撤销」其中部分区间，表示选择该区间，那么 np 要除以不选该区间的概率 1-P，再乘以选择该区间的概率 P。
考虑包含 m 的区间 [L,m]，如果选择该区间，那么问题变成 [1,L-1] 的子问题，这启发我们用记忆化搜索/递推计算。
定义 f[i] 表示恰好覆盖 [1,i] 的概率，那么有 f[i] += f[L-1] * P / (1-P)。
其中 += 是因为如果有多个包含 m 的区间，把这些概率加起来（这些区间互斥）。
初始值 f[0] = np。
答案为 f[m]。
注意 1-P 可能导致计算结果为负数，输出的时候调整一下。
代码 https://codeforces.com/contest/2125/submission/333871306
代码备份（上面打不开的同学看这个）
======

Input
3 3
1 2 1 3
3 3 1 2
1 3 2 3
Output
610038216

Input
2 3
1 2 1 2
2 3 1 2
Output
0

Input
8 5
1 3 1 2
1 5 1 6
1 4 4 5
5 5 1 7
4 5 1 2
4 5 2 5
3 3 2 7
1 2 1 3
Output
94391813
 */
