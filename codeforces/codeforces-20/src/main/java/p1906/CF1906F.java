package p1906;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class CF1906F {
    static int n, m, q;
    //    static List<pair>[] ops;
    //    static List<query>[] qs;
    static LinkedForwardStar<pair> OPS;
    static LinkedForwardStar<query> QS;

    static class LinkedForwardStar<E> {
        int n, m, idx;
        int[] he, ne;
        Object[] ed;

        // n:点数 m:边数
        public LinkedForwardStar(int n, int m) {
            n += 5;
            m += 5;
            this.n = n;
            this.m = m;
            he = new int[n];
            Arrays.fill(he, -1);
            ne = new int[m];
            ed = new Object[m];
            idx = 0;
        }

        void add(int u, E v) {
            ed[idx] = v;
            ne[idx] = he[u];
            he[u] = idx;
            idx++;
        }
    }

    record pair(int i, int v) {
    }

    record query(int l, int r, int qi) {
    }

    public static void main(String[] args) {
        // Time limit exceeded on test 4
//        Scanner scanner = new Scanner(System.in);
        FastReader scanner = new FastReader();
        n = scanner.nextInt();
        m = scanner.nextInt();
//        ops = new ArrayList[n + 2];
//        Arrays.setAll(ops, e -> new ArrayList<>());
        OPS = new LinkedForwardStar<>(n, m * 2);
        for (int i = 1; i <= m; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int v = scanner.nextInt();
//            ops[l].add(new pair(i, v));
//            ops[r + 1].add(new pair(i, -v));
            OPS.add(l, new pair(i, v));
            OPS.add(r + 1, new pair(i, -v));
        }
        q = scanner.nextInt();
//        qs = new ArrayList[n + 1];
//        Arrays.setAll(qs, e -> new ArrayList<>());
        QS = new LinkedForwardStar<>(n, q);
        for (int i = 0; i < q; i++) {
            int v = scanner.nextInt();
            int l = scanner.nextInt();
            int r = scanner.nextInt();
//            qs[v].add(new query(l, r, i));
            QS.add(v, new query(l, r, i));
        }
        System.out.println(solve());
    }

    private static String solve() {
        InfoSegmentTree seg = new InfoSegmentTree(m);
        seg.build(1, 1, m);

        long[] ans = new long[q];
        for (int i = 0; i < n + 1; i++) {
//            for (pair p : ops[i]) {
            for (int z = OPS.he[i]; z != -1; z = OPS.ne[z]) {
                pair p = (pair) OPS.ed[z];
                seg.modify(1, 1, m, p.i, p.v);
            }
//            for (query q : qs[i]) {
            for (int z = QS.he[i]; z != -1; z = QS.ne[z]) {
                query q = (query) QS.ed[z];
                ans[q.qi] = seg.query(1, 1, m, q.l, q.r).ans;
            }
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }

    // 线段树模板，只需要实现 mergeInfo 和 _do，其余都是固定的
    static class InfoSegmentTree {
        static class Info {
            long ans, tot, pre, suf;

            public Info(long ans, long tot, long pre, long suf) {
                this.ans = ans;
                this.tot = tot;
                this.pre = pre;
                this.suf = suf;
            }
        }

        Info mergeInfo(Info a, Info b) {
            return new Info(
                    Math.max(Math.max(a.ans, b.ans), a.suf + b.pre),
                    a.tot + b.tot,
                    Math.max(a.pre, a.tot + b.pre),
                    Math.max(b.suf, b.tot + a.suf)
            );
        }

        int n;
        Info[] info;

        public InfoSegmentTree(int n) {
            this.n = n;
//            info = new Info[4 * n];
            info = new Info[1 << (33 - Integer.numberOfLeadingZeros(n - 1))];
        }

        void build(int p, int l, int r) {
            info[p] = new Info(0, 0, 0, 0);
            if (l == r) {
                return;
            }
            int m = (l + r) >> 1;
            build(p << 1, l, m);
            build(p << 1 | 1, m + 1, r);
            maintain(p);
        }

        void maintain(int p) {
//            info[p] = mergeInfo(info[p << 1], info[p << 1 | 1]);
            Info a = info[p << 1];
            Info b = info[p << 1 | 1];
            info[p].ans = Math.max(Math.max(a.ans, b.ans), a.suf + b.pre);
            info[p].tot = a.tot + b.tot;
            info[p].pre = Math.max(a.pre, a.tot + b.pre);
            info[p].suf = Math.max(b.suf, b.tot + a.suf);
        }

        void modify(int p, int l, int r, int i, long v) {
            if (l == r) {
                v += info[p].tot;
                info[p] = new Info(v, v, v, v);
                return;
            }
            int m = (l + r) >> 1;
            if (i <= m) modify(p << 1, l, m, i, v);
            else modify(p << 1 | 1, m + 1, r, i, v);
            maintain(p);
        }

        Info query(int p, int l, int r, int ql, int qr) {
            if (ql <= l && r <= qr) {
                return info[p];
            }
            int m = (l + r) >> 1;
            if (qr <= m) return query(p << 1, l, m, ql, qr);
            if (ql > m) return query(p << 1 | 1, m + 1, r, ql, qr);
            return mergeInfo(query(p << 1, l, m, ql, qr), query(p << 1 | 1, m + 1, r, ql, qr));
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
F. Maximize The Value
https://codeforces.com/contest/1906/problem/F

灵茶の试炼 2024-12-05
题目大意：
输入 n(1≤n≤1e5) m(1≤m≤1e5)。
一开始有一个长为 n 的数组 a，所有 a[i] 都是 0。下标从 1 开始。
然后输入 m 个操作，每个操作输入 l r(1≤l≤r≤n) x(-1e5≤x≤1e5)，表示把 a 的下标 [l,r] 中的元素都增加 x。
然后输入 q(1≤q≤1e5) 和 q 个询问，每个询问输入 k(1≤k≤n) s t(1≤s≤t≤m)。
对于每个询问，你需要选择 l 和 r，满足 s≤l≤r≤t，然后执行第 l,l+1,...,r 个操作。输出最优操作后的 a[k] 的最大值。（每个询问互相独立）

rating 2100
提示 1：最大子数组和。
提示 2：任意区间的最大子数组和，可以用线段树解决。
提示 3：离线。按照 k 分组。在 k 右边的区间，还没有遍历到；在 k 左边的区间，直接从线段树中移除。所以剩下的区间必然都包含 k。直接查询线段树即可。线段树的下标是操作的编号。
代码 https://codeforces.com/problemset/submission/1906/294119970
代码备份（洛谷）
======

Input
2 6
1 1 -50
1 2 -20
2 2 -30
1 1 60
1 2 40
2 2 10
5
1 1 6
2 1 6
1 1 3
2 1 3
1 1 2
Output
100
50
0
0
-20

Input
5 3
1 3 3
2 4 -2
3 5 3
6
1 1 3
2 1 3
3 1 3
3 2 3
2 2 3
2 2 2
Output
3
3
4
3
0
-2
 */

