package p1974;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CF1974C {
    // Time limit exceeded on test 14
//    static Scanner scanner = new Scanner(System.in);
    static FastReader scanner = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static int n;
    static int[] a;

    public static void main(String[] args) {
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            solve();
        }
        out.flush();
    }

//    private static void solve() {
//        long ans = 0;
//        Map<pair2, Integer> c12 = new HashMap<>();
//        Map<pair2, Integer> c13 = new HashMap<>();
//        Map<pair2, Integer> c23 = new HashMap<>();
//        Map<pair3, Integer> c3 = new HashMap<>();
//        int x = a[0], y = a[1];
//        for (int i = 2; i < n; i++) {
//            int z = a[i];
//            pair2 pxy = new pair2(x, y);
//            pair2 pxz = new pair2(x, z);
//            pair2 pyz = new pair2(y, z);
//            pair3 pxyz = new pair3(x, y, z);
//
//            ans += c12.getOrDefault(pxy, 0) +
//                    c13.getOrDefault(pxz, 0) +
//                    c23.getOrDefault(pyz, 0) -
//                    c3.getOrDefault(pxyz, 0) * 3L;
//            c12.merge(pxy, 1, Integer::sum);
//            c13.merge(pxz, 1, Integer::sum);
//            c23.merge(pyz, 1, Integer::sum);
//            c3.merge(pxyz, 1, Integer::sum);
//            // x, y = y, z
//            x = y;
//            y = z;
//        }
//        out.println(ans);
//    }
//
//    record pair2(int x, int y) {
//    }
//
//    record pair3(int x, int y, int z) {
//    }

    private static void solve() {
        long ans = 0;
        Map<Long, Integer> c12 = new HashMap<>();
        Map<Long, Integer> c13 = new HashMap<>();
        Map<Long, Integer> c23 = new HashMap<>();
        Map<Long, Integer> c3 = new HashMap<>();
        int x = a[0], y = a[1];
        for (int i = 2; i < n; i++) {
            int z = a[i];
            long pxy = pair2(x, y);
            long pxz = pair2(x, z);
            long pyz = pair2(y, z);
            long pxyz = pair3(x, y, z);

            ans += c12.getOrDefault(pxy, 0) +
                    c13.getOrDefault(pxz, 0) +
                    c23.getOrDefault(pyz, 0) -
                    c3.getOrDefault(pxyz, 0) * 3L;
            c12.merge(pxy, 1, Integer::sum);
            c13.merge(pxz, 1, Integer::sum);
            c23.merge(pyz, 1, Integer::sum);
            c3.merge(pxyz, 1, Integer::sum);
            // x, y = y, z
            x = y;
            y = z;
        }
        out.println(ans);
    }

    static long pair2(long x, long y) {
        return x << 20 | y;
    }

    static long pair3(long x, long y, long z) {
        return x << 40 | y << 20 | z;
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
C. Beautiful Triple Pairs
https://codeforces.com/contest/1974/problem/C

灵茶の试炼 2025-06-03
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(3≤n≤2e5) 和长为 n 的数组 a(1≤a[i]≤1e6)。
a 中有 n-2 个长为 3 的连续子数组，称作三元组。
有多少个三元组对 (P,Q)，满足 P 和 Q 恰好有一个 i 满足 P[i]≠Q[i]？
比如 P=(1,2,3)，Q=(1,2,4) 的前两个数相同但第三个数不同，满足要求。

rating 1400
枚举右维护左。
比如，计算第三个数不同的三元组对，可以考虑容斥，用前两个数相同的 pair 出现次数，减去三个数都相同的三元组个数，就得到第三个数一定不同的情况。
其他情况同理。
需要 4 个 map 统计。
代码 https://codeforces.com/problemset/submission/1974/321867862
代码备份（洛谷）
======

Input
8
5
3 2 2 2 3
5
1 2 1 2 1
8
1 2 3 2 2 3 4 2
4
2 1 1 1
8
2 1 1 2 1 1 1 1
7
2 1 1 1 1 1 1
6
2 1 1 1 1 1
5
2 1 1 1 1
Output
2
0
3
1
8
4
3
2
 */
