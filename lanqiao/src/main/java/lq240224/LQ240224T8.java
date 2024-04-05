package lq240224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class LQ240224T8 {
    static int n, q;
    static int[] a;
    static int[][] lr;
    static int m;

    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        n = scanner.nextInt();
        q = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        lr = new int[q][2];
        for (int i = 0; i < q; i++) {
            lr[i][0] = scanner.nextInt();
            lr[i][1] = scanner.nextInt();
        }
        m = scanner.nextInt();
        System.out.println(solve());
    }

    private static String solve() {
        SegmentTree seg = new SegmentTree(n);
        seg.build(a, 1, 1, n);

        long ans = 0;
        for (int[] p : lr) {
            int l = p[0], r = p[1];
            int[] b = seg.query(1, 1, n, l, r);
            ans += b[0] + b[1];
        }

        boolean blue = ans % (m + 1) == 0;
        return ans + System.lineSeparator() + (blue ? "blue" : "red");
    }

    private static class SegmentTree {
        int n;
        Node[] t;

        static class Node {
            int[] arr = new int[0];
        }

        public SegmentTree(int n) {
            this.n = n;
            this.t = new Node[4 * n];
            Arrays.setAll(t, e -> new Node());
        }

        // 合并两个有序数组（递减），保留前 k 个数
        int[] merge(int[] a, int[] b) {
            int i = 0, n = a.length;
            int j = 0, m = b.length;
            int k = Math.min(2, n + m);
            int[] res = new int[k];
            int id = 0;
            while (id < k) {
                if (i == n) {
                    while (id < k && j < m) res[id++] = b[j++];
                    break;
                }
                if (j == m) {
                    while (id < k && i < n) res[id++] = a[i++];
                    break;
                }
                if (a[i] >= b[j]) res[id++] = a[i++];
                else res[id++] = b[j++];
            }
            return res;
        }

        void build(int[] a, int p, int l, int r) {
            if (l == r) {
                t[p].arr = Arrays.copyOfRange(a, l - 1, l);
                return;
            }
            int mid = l + (r - l) / 2;
            build(a, p << 1, l, mid);
            build(a, p << 1 | 1, mid + 1, r);
            t[p].arr = merge(t[p << 1].arr, t[p << 1 | 1].arr);
        }

        int[] query(int p, int l, int r, int ql, int qr) {
            if (ql <= l && r <= qr) {
                return t[p].arr;
            }
            int mid = l + (r - l) / 2;
            // ?
            if (qr <= mid) return query(p << 1, l, mid, ql, qr);
            if (ql > mid) return query(p << 1 | 1, mid + 1, r, ql, qr);
            return merge(query(p << 1, l, mid, ql, qr), query(p << 1 | 1, mid + 1, r, ql, qr));
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
源石开采【算法赛】

线段树维护 top 2。然后 巴什博弈。
相似题目: E. MinimizOR
https://codeforces.com/contest/1665/problem/E
 */