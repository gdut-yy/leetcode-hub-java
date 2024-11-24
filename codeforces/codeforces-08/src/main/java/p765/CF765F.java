package p765;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class CF765F {
    static int n;
    static int[] a;
    static int q;
    static int[][] qs;

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        FastReader scanner = new FastReader();
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        q = scanner.nextInt();
        qs = new int[q][3];
        for (int i = 0; i < q; i++) {
            qs[i][0] = scanner.nextInt();
            qs[i][1] = scanner.nextInt();
            qs[i][2] = i;
        }
        System.out.println(solve());
    }

    static int allMin;

    private static String solve() {
        Arrays.sort(qs, Comparator.comparingInt(o -> o[1]));

        int[] ans = new int[q];
        SegTree seg = new SegTree(a);
        int qi = 0;
        for (int r = 2; r <= n; r++) {
            allMin = (int) 2e9;
            seg.update(1, r - 1, a[r - 1]);
            for (; qi < q && qs[qi][1] == r; qi++) {
                ans[qs[qi][2]] = seg.query(1, qs[qi][0]);
            }
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }

    static class SegTree {
        static class Node {
            int l, r, min;
            int[] a;

            public Node(int l, int r, int min) {
                this.l = l;
                this.r = r;
                this.min = min;
            }
        }

        int[] a;
        int n;
        Node[] t;

        public SegTree(int[] a) {
            this.a = a;
            n = a.length;
            t = new Node[4 * n];
            build(a, 1, 1, n);
        }

        void build(int[] a, int o, int l, int r) {
            t[o] = new Node(l, r, (int) 2e9);
            t[o].a = Arrays.copyOfRange(a, l - 1, r);
            Arrays.sort(t[o].a);
            if (l == r) return;
            int m = l + (r - l) / 2;
            build(a, o << 1, l, m);
            build(a, o << 1 | 1, m + 1, r);
        }

        void update(int o, int i, int val) {
            if (t[o].l == t[o].r) {
                t[o].min = Math.min(t[o].min, Math.abs(val - t[o].a[0]));
                allMin = Math.min(allMin, t[o].min);
                return;
            }
            if (t[o].r <= i) {
                int[] a = t[o].a;
                int p = searchInts(a, val);
                if ((p == 0 || val - a[p - 1] >= allMin) && (p == a.length || a[p] - val >= allMin)) {
                    allMin = Math.min(allMin, t[o].min);
                    return;
                }
            }
            int m = t[o].l + (t[o].r - t[o].l) / 2;
            if (i > m) {
                update(o << 1 | 1, i, val);
            }
            update(o << 1, i, val);
            t[o].min = Math.min(t[o << 1].min, t[o << 1 | 1].min);
        }

        int searchInts(int[] a, int key) {
            int l = 0, r = a.length;
            while (l < r) {
                int m = l + (r - l) / 2;
                if (a[m] >= key) r = m;
                else l = m + 1;
            }
            return l;
        }

        int query(int o, int l) {
            if (l <= t[o].l) {
                return t[o].min;
            }
            int m = t[o].l + (t[o].r - t[o].l) / 2;
            if (m < l) {
                return query(o << 1 | 1, l);
            }
            return Math.min(query(o << 1, l), t[o << 1 | 1].min);
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
F. Souvenirs
https://codeforces.com/contest/765/problem/F

题目大意：
Artsem 正在度假，想给他的两个队友买点纪念品。街上有 n 家纪念品商店。在第 i 家商店，Artsem 可以花 ai 美元买到一件纪念品，但他不能在一家商店买多件纪念品。他不想让他的团队羡慕，所以他想买两件差价最小的纪念品。
Artsem 已经去过这条商业街 m 次。由于某些奇怪的原因，在第 i 天，只有编号从 li 到 ri 的商店在营业(奇怪吗？是的，但你有没有试过为范围查询问题想出一个合理的图例？)每次访问时，Artsem 都想知道他能在已开张的商店里买到的两种不同纪念品的最小可能差价。
换句话说，对于 Artsem 的每次访问，您应该找出 |as-at| 其中的 li≤s,t≤ri , s≠t 的最小可能值。
第一行包含一个整数 n ( 2≤n≤10^5 )。
第二行包含 n 空格分隔的整数 a1 , ..., an ( 0≤ai≤10^9 )。
第三行包含查询次数 m ( 1≤m≤3·10^5 )。
接下来的 m 行描述查询。其中第 i 行包含两个空格分隔的整数 li 和 ri ，分别表示 i -天( 1≤li<ri≤n )的商店工作范围。

https://codeforces.com/contest/765/submission/120279828
相似题目: 1906. 查询差绝对值的最小值
https://leetcode.cn/problems/minimum-absolute-difference-queries/description/
======

Input
8
3 1 4 1 5 9 2 6
4
1 8
1 3
4 8
5 7
Output
0
1
1
3
 */
