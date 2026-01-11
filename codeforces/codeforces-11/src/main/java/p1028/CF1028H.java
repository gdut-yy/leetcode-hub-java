package p1028;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class CF1028H {
    // Time limit exceeded on test 10
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
        final int mx = 5032108;
        // 预处理每个数的最小质因子，用于质因子分解
        int[] lpf = new int[mx];
        for (int i = 2; i < mx; i++) {
            if (lpf[i] == 0) {
                for (int j = i; j < mx; j += i) {
                    if (lpf[j] == 0) {
                        lpf[j] = i;
                    }
                }
            }
        }

        int n = scanner.nextInt();
        int q = scanner.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        // 离线询问，按照右端点分组
        List<List<Query>> qs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            qs.add(new ArrayList<>());
        }
        for (int i = 0; i < q; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            qs.get(r - 1).add(new Query(l, i));
        }

        int[] ans = new int[q];
        final int mxW = 7;
        int[] opToI = new int[mxW * 2 + 1];

        int[][] maxI = new int[mx][mxW + 1];
        for (int i = 0; i < mx; i++) {
            Arrays.fill(maxI[i], 0);
        }

        for (int i = 0; i < n; i++) {
            // 计算 core(a[i]) 的所有质因子集合（计算元素积），作为交集
            int v = a[i];
            List<Integer> primes = new ArrayList<>();
            int temp = v;
            while (temp > 1) {
                int p = lpf[temp];
                int count = 0;
                while (temp % p == 0) {
                    temp /= p;
                    count ^= 1;
                }
                if (count == 1) {
                    primes.add(p);
                }
            }
            int w = primes.size(); // core(a[i]) 的质因子个数

            int[] mul = new int[1 << w];
            mul[0] = 1;
            for (int j = 0; j < w; j++) {
                for (int k = 0; k < (1 << j); k++) {
                    mul[k | (1 << j)] = mul[k] * primes.get(j);
                }
            }

            // 枚举交集
            for (int mask = 0; mask < (1 << w); mask++) {
                int m = mul[mask];
                int common = Integer.bitCount(mask); // 交集大小
                // 枚举左边的 core(a[j]) 的质因子个数 w2
                for (int w2 = common; w2 <= mxW; w2++) {
                    int op = w + w2 - 2 * common;
                    if (op < opToI.length) {
                        // 维护当操作次数等于 op 时，最大的 j 的下标
                        opToI[op] = Math.max(opToI[op], maxI[m][w2]);
                    }
                }
                maxI[m][w] = i + 1;
            }

            for (Query query : qs.get(i)) {
                for (int op = 0; op < opToI.length; op++) {
                    if (opToI[op] >= query.l) { // 左边的 a[j] 在询问范围内
                        ans[query.i] = op;
                        break;
                    }
                }
            }
        }

        for (int value : ans) {
            out.println(value);
        }
    }

    static class Query {
        int l, i;

        Query(int l, int i) {
            this.l = l;
            this.i = i;
        }
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
H. Make Square
https://codeforces.com/contest/1028/problem/H

灵茶の试炼 2025-10-17
题目大意：
输入 n(2≤n≤194598) q(1≤q≤1049658) 和长为 n 的数组 a(1≤a[i]≤5032107)，下标从 1 开始。
然后输入 q 个询问，每个询问输入 L R(1≤L<R≤n)，表示 a 的一个子数组 b，下标范围 [L,R]。
对于子数组 b，如果 b 中存在一对下标不同的数 x 和 y，满足 x*y 是完全平方数，那么称 b 为好子数组。
每次操作，你可以：
选择 b 中的一个数 b[i]，执行 b[i] *= p，其中 p 是任意一个质数。
或者，选择 b 中的一个数 b[i]，以及 b[i] 的一个质因子 p，执行 b[i] /= p。
输出把 b 变成子好数组的最小操作次数。
所有询问互相独立。

rating 2900
https://www.luogu.com.cn/article/kdouydty
======

Input
10 10
34 37 28 16 44 36 43 50 22 13
1 3
4 8
6 10
9 10
3 10
8 9
5 6
1 4
1 7
2 6
Output
2
0
1
3
0
1
1
1
0
0
 */
