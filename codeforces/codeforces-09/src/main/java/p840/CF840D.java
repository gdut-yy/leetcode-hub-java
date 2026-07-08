package p840;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CF840D {
    // Time limit exceeded on test 5
//    static Scanner scanner;
    static FastReader scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new FastReader();
        out = new PrintWriter(System.out);
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static int[] lo, ro, cnt;
    static int nodeCnt;
    static int[] qRes = new int[2];

    static int build(int l, int r) {
        int o = ++nodeCnt;
        if (l == r) return o;
        int m = (l + r) >> 1;
        lo[o] = build(l, m);
        ro[o] = build(m + 1, r);
        return o;
    }

    static int update(int o, int l, int r, int i) {
        int n = ++nodeCnt;
        lo[n] = lo[o];
        ro[n] = ro[o];
        cnt[n] = cnt[o];
        if (l == r) {
            cnt[n]++;
            return n;
        }
        int m = (l + r) >> 1;
        if (i <= m) lo[n] = update(lo[o], l, m, i);
        else ro[n] = update(ro[o], m + 1, r, i);
        cnt[n] = cnt[lo[n]] + cnt[ro[n]];
        return n;
    }

    static void query(int o, int old, int l, int r, int k) {
        if (l == r) {
            qRes[0] = cnt[o] - cnt[old];
            qRes[1] = l;
            return;
        }
        int m = (l + r) >> 1;
        int cntL = cnt[lo[o]] - cnt[lo[old]];
        if (k <= cntL) query(lo[o], lo[old], l, m, k);
        else query(ro[o], ro[old], m + 1, r, k - cntL);
    }

    private static void solve() {
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int maxNodes = n * 24 + 5;
        lo = new int[maxNodes];
        ro = new int[maxNodes];
        cnt = new int[maxNodes];
        nodeCnt = 0;
        int[] root = new int[n + 1];
        root[0] = build(1, n);
        for (int i = 0; i < n; i++) {
            int v = scanner.nextInt();
            root[i + 1] = update(root[i], 1, n, v);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int k = scanner.nextInt();
            l--;
            int d = (r - l) / k + 1;
            int ans = -1;
            for (int j = d; j <= r - l; j += d) {
                query(root[r], root[l], 1, n, j);
                if (qRes[0] >= d) {
                    ans = qRes[1];
                    break;
                }
            }
            sb.append(ans).append('\n');
        }
        out.print(sb);
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
D. Destiny
https://codeforces.com/contest/840/problem/D

灵茶の试炼 2025-12-05
题目大意：
输入 n q(1≤n,q≤3e5) 和长为 n 的数组 a(1≤a[i]≤n)。下标从 1 开始。
然后输入 q 个询问，每个询问输入 L R(1≤L≤R≤n) 和 k(2≤k≤5)。
对于每个询问，输出 a 的子数组 [L,R] 中出现次数严格大于 floor((R-L+1)/k) 的最小元素值。如果不存在这样的数，输出 -1。

rating 2500
前置题目：LC1287. 有序数组中出现次数超过 25% 的元素。请先阅读我的题解，理解「用网捕鱼」这个概念。
设 d = floor((R-L+1)/k) + 1。
注意本题 k 很小，我们可以枚举子数组 [L,R] 中的第 d, 2d, 3d, ...（不超过 R-L+1）小的数 x，如果 x 的出现次数 >= d，那么答案为 x。由于我们是从小到大枚举的，所以答案是最小的。
用可持久化线段树可以 O(log n) 求出子数组中的第 kth 小的数，以及这个数的出现次数。
时间复杂度：O((n + qk) * log n)。
代码 https://codeforces.com/problemset/submission/840/351540470
代码备份（上面打不开的同学看这个）
======

Input
4 2
1 1 2 2
1 3 2
1 4 2
Output
1
-1

Input
5 3
1 2 1 3 2
2 5 3
1 2 3
5 5 2
Output
2
1
2
 */
