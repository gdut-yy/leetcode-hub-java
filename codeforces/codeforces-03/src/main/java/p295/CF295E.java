package p295;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CF295E {
    // Time limit exceeded on test 12
//    static Scanner scanner;
    static FastReader scanner = new FastReader();
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new FastReader();
        out = new PrintWriter(System.out);
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static int[] segL, segR, segC;
    static long[] segS, segRes;

    static void build(int o, int l, int r) {
        segL[o] = l;
        segR[o] = r;
        if (l == r) return;
        int m = (l + r) >> 1;
        build(o << 1, l, m);
        build(o << 1 | 1, m + 1, r);
    }

    static void update(int o, int i, int c, long v) {
        if (segL[o] == segR[o]) {
            segC[o] += c;
            segS[o] += v;
            return;
        }
        int m = (segL[o] + segR[o]) >> 1;
        if (i <= m) update(o << 1, i, c, v);
        else update(o << 1 | 1, i, c, v);
        segC[o] = segC[o << 1] + segC[o << 1 | 1];
        segS[o] = segS[o << 1] + segS[o << 1 | 1];
        segRes[o] = segRes[o << 1] + segRes[o << 1 | 1]
                + segS[o << 1 | 1] * segC[o << 1]
                - segS[o << 1] * segC[o << 1 | 1];
    }

    static long[] query(int o, int l, int r) {
        if (l <= segL[o] && segR[o] <= r) {
            return new long[]{segC[o], segS[o], segRes[o]};
        }
        int m = (segL[o] + segR[o]) >> 1;
        if (r <= m) return query(o << 1, l, r);
        if (m < l) return query(o << 1 | 1, l, r);
        long[] L = query(o << 1, l, r);
        long[] R = query(o << 1 | 1, l, r);
        return new long[]{
                L[0] + R[0],
                L[1] + R[1],
                L[2] + R[2] + R[1] * L[0] - L[1] * R[0]
        };
    }

    private static void solve() {
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = scanner.nextInt();
        int[] b = a.clone();
        List<Integer> xs = new ArrayList<>();
        for (int v : a) xs.add(v);
        int k = scanner.nextInt();
        int[][] qs = new int[k][3];
        for (int i = 0; i < k; i++) {
            qs[i][0] = scanner.nextInt();
            qs[i][1] = scanner.nextInt();
            qs[i][2] = scanner.nextInt();
            if (qs[i][0] == 1) {
                int j = qs[i][1] - 1;
                b[j] += qs[i][2];
                xs.add(b[j]);
            }
        }
        int[] xArr = new int[xs.size()];
        for (int i = 0; i < xs.size(); i++) xArr[i] = xs.get(i);
        Arrays.sort(xArr);
        int m = 1;
        for (int i = 1; i < xArr.length; i++) {
            if (xArr[i] != xArr[m - 1]) xArr[m++] = xArr[i];
        }
        int size = 2 << (32 - Integer.numberOfLeadingZeros(m - 1));
        segL = new int[size];
        segR = new int[size];
        segC = new int[size];
        segS = new long[size];
        segRes = new long[size];
        build(1, 0, m - 1);
        for (int v : a) {
            update(1, lowerBound(xArr, m, v), 1, v);
        }
        for (int[] q : qs) {
            if (q[0] == 1) {
                int i = q[1] - 1;
                update(1, lowerBound(xArr, m, a[i]), -1, -a[i]);
                a[i] += q[2];
                update(1, lowerBound(xArr, m, a[i]), 1, a[i]);
            } else {
                int l = lowerBound(xArr, m, q[1]);
                int r = lowerBound(xArr, m, q[2] + 1) - 1;
                if (l > r) {
                    out.println(0);
                } else {
                    out.println(query(1, l, r)[2]);
                }
            }
        }
    }

    static int lowerBound(int[] a, int len, int key) {
        int lo = 0, hi = len;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (a[mid] < key) lo = mid + 1;
            else hi = mid;
        }
        return lo;
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
E. Yaroslav and Points
https://codeforces.com/contest/295/problem/E

灵茶の试炼 2025-07-18
题目大意：
输入 n(1≤n≤1e5) 和长为 n 的数组 a(-1e9≤a[i]≤1e9)。
然后输入 m(1≤m≤1e5) 和 m 个询问，格式如下：
"1 i x"：把 a[i] 增加 x。(1≤i≤n，-1e3≤x≤1e3)
"2 L R"：输出所有满足 L ≤ a[i] ≤ a[j] ≤ R 的 a[j] - a[i] 之和。(-1e9≤L≤R≤1e9)
保证任意时刻 a 中都没有重复元素。

rating 2500
单点修改线段树。
每个询问可以分治解决：左半中的答案 + 右半中的答案 + 左半和右半的答案。
左半和右半的答案考虑贡献法：
右半中的每个点，贡献是左半的点的个数。
左半中的每个点，贡献是右半的点的个数（取相反数）。
所以线段树除了维护子树的答案，还要额外维护子树的点的个数，以及坐标之和。
可以写离散化，或者动态开点。
写离散化，注意离散化后的询问 L > R 的情况。
写动态开点，注意 a[i] 可能超过 [-1e9,1e9] 的范围，此时无需更新线段树。
注意用 long long 保存答案。
离散化（更快，但是代码长） https://codeforces.com/contest/295/submission/328591269
动态开点（慢一点，但是代码短） https://codeforces.com/contest/295/submission/328591917
代码备份（Ubuntu Pastebin）
======

Input
8
36 50 28 -75 40 -60 -95 -48
20
2 -61 29
1 5 -53
1 1 429
1 5 130
2 -101 -71
2 -69 53
1 1 404
1 5 518
2 -101 53
2 50 872
1 1 -207
2 -99 -40
1 7 -389
1 6 -171
1 2 464
1 7 -707
1 1 -730
1 1 560
2 635 644
1 7 -677
Output
176
20
406
1046
1638
156
0
 */
