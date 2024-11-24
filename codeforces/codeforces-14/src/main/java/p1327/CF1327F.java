package p1327;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CF1327F {
    static int n, k, m;
    static int[][] cons; // l,r,x

    public static void main(String[] args) {
        // Time limit exceeded on test 46
//        Scanner scanner = new Scanner(System.in);
        FastReader scanner = new FastReader();
        n = scanner.nextInt();
        k = scanner.nextInt();
        m = scanner.nextInt();
        cons = new int[m][3];
        for (int i = 0; i < m; i++) {
            cons[i][0] = scanner.nextInt();
            cons[i][1] = scanner.nextInt();
            cons[i][2] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static final int mod = 998244353;

    private static String solve() {
        long ans = 1;
        long[] f = new long[n + 2];
        f[0] = 1;
        for (int b = 0; b < k; b++) {
            int[] maxL = new int[n + 1];
            int[] d = new int[n + 2];
            for (int[] p : cons) {
                if ((p[2] >> b & 1) == 0) {
                    maxL[p[1]] = Math.max(maxL[p[1]], p[0]);
                } else {
                    d[p[0]]++;
                    d[p[1] + 1]--;
                }
            }

            long sumF = 1;
            long sumD = 0;
            int left = 0;
            for (int i = 1; i <= n + 1; i++) {
                while (left < maxL[i - 1]) {
                    sumF -= f[left];
                    left++;
                }
                sumD += d[i];
                if (sumD > 0) {
                    f[i] = 0;
                    continue;
                }
                sumF %= mod;
                f[i] = sumF;
                sumF *= 2;
            }
            // f[n+1] 相当于枚举最后一个 0 的下标，计算这些 f[i] 之和
            ans = ans * f[n + 1] % mod;
        }
        ans = (ans + mod) % mod;
        return String.valueOf(ans); // 保证答案非负
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
F. AND Segments
https://codeforces.com/contest/1327/problem/F

灵茶の试炼 2023-12-08
题目大意：
输入 n(1≤n≤5e5) k(1≤k≤30) m(0≤m≤5e5)。
然后输入 m 行，
每行输入三个数 L R(1≤L≤R≤n) x(0≤x<2^k)，表示一个约束：
a[L] AND a[L+1] AND ... AND a[R] = x
其中 AND 表示按位与。
输出有多少个长为 n 的数组 a，满足上述这 m 个约束，且元素值在 [0, 2^k) 内。注意数组下标从 1 开始。
答案模 998244353。

rating 2500
https://www.luogu.com/article/a91m8j3o
======

input
4 3 2
1 3 3
3 4 6
output
3

input
5 2 3
1 3 2
2 5 0
3 3 3
output
33
 */
