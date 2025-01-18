package p1416;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CF1416D {
    static int n, m, q;
    static int[] a;
    static ES[] es;
    static QS[] qs;
    static boolean[] del;

    record ES(int v, int w) {
    }

    //    record QS(int tp, int v) {
    //    }
    static class QS {
        int tp, v;

        public QS(int tp, int v) {
            this.tp = tp;
            this.v = v;
        }
    }

    public static void main(String[] args) throws IOException {
        // Time limit exceeded on test 7
//        Scanner scanner = new Scanner(System.in);
        // Time limit exceeded on test 48
//        FastReader scanner = new FastReader();
        Reader scanner = new Reader();
        n = scanner.nextInt();
        m = scanner.nextInt();
        q = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        es = new ES[m];
        for (int i = 0; i < m; i++) {
            int v = scanner.nextInt() - 1;
            int w = scanner.nextInt() - 1;
            es[i] = new ES(v, w);
        }
        qs = new QS[q];
        del = new boolean[m];
        for (int i = 0; i < q; i++) {
            int tp = scanner.nextInt();
            int v = scanner.nextInt() - 1;
            qs[i] = new QS(tp, v);
            if (qs[i].tp == 2) {
                del[qs[i].v] = true;
            }
        }
        System.out.println(solve());
    }

    static List<Integer>[] g;
    static int[] fa;
    static int[][] nodes; // in, out
    static int[] at;
    static int clock;

    private static String solve() {
        g = new ArrayList[n * 2];
        Arrays.setAll(g, e -> new ArrayList<>());
        fa = new int[n * 2];
        for (int i = 0; i < fa.length; i++) {
            fa[i] = i;
        }
        for (int i = 0; i < m; i++) {
            if (!del[i]) {
                merge(es[i].v, es[i].w);
            }
        }
        for (int i = q - 1; i >= 0; i--) {
            QS p = qs[i];
            if (p.tp == 1) {
                p.v = find(p.v);
            } else {
                ES e = es[p.v];
                merge(e.v, e.w);
            }
        }

        nodes = new int[n][2];
        at = new int[n];
        clock = -1;
        for (int i = 0; i < n; i++) {
            if (find(i) == i) { // 根
                dfs(i);
            }
        }

//        String[] output = new String[qs.length];
        StringBuilder output = new StringBuilder();
        SegmentTree seg = new SegmentTree(n);
        seg.build(1, 0, n - 1);
        for (int i = 0; i < qs.length; i++) {
            QS p = qs[i];
            if (p.tp == 2) {
                continue;
            }
            int[] node = nodes[p.v];
            Info res = seg.query(1, node[0], node[1]);
//            output[i] = String.valueOf(res.max);
            output.append(res.max).append("\n");
            if (res.max > 0) {
                seg.set0(1, res.i);
            }
        }
//        return String.join(System.lineSeparator(), output);
        return output.toString();
    }

    static int find(int x) { // 查找
        return x == fa[x] ? fa[x] : (fa[x] = find(fa[x]));
    }

    static void merge(int v, int w) { // 合并
        v = find(v);
        w = find(w);
        if (v == w) return;
        fa[v] = n;
        fa[w] = n;
        g[n].add(v);
        g[n].add(w);
        n++;
    }

    static void dfs(int v) {
        clock++;
        if (v < a.length) {
            at[clock] = a[v];
        }
        nodes[v][0] = clock;
        for (Integer w : g[v]) {
            dfs(w);
        }
        nodes[v][1] = clock;
    }

    //    record info(int max, int i) {
    //    }
    static class Info {
        int max, i;

        public Info(int max, int i) {
            this.max = max;
            this.i = i;
        }
    }

    static class SegmentTree {
        int n;
        Info[] val;

        public SegmentTree(int n) {
            this.n = n;
            val = new Info[4 * n];
        }

        void build(int p, int l, int r) {
            if (l == r) {
                val[p] = new Info(at[l], l);
                return;
            }
            int m = (l + r) >> 1;
            build(p << 1, l, m);
            build(p << 1 | 1, m + 1, r);
            maintain(p);
        }

        void set0(int o, int i) {
            set0(o, 0, n - 1, i);
        }

        void set0(int p, int l, int r, int i) {
            if (l == r) {
                val[p].max = 0;
                return;
            }
            int m = (l + r) >> 1;
            if (i <= m) set0(p << 1, l, m, i);
            else set0(p << 1 | 1, m + 1, r, i);
            maintain(p);
        }

        void maintain(int p) {
            val[p] = mergeInfo(val[p << 1], val[p << 1 | 1]);
        }

        Info mergeInfo(Info a, Info b) {
            return a.max >= b.max ? a : b;
        }

        Info query(int o, int ql, int qr) {
            return query(o, 0, n - 1, ql, qr);
        }

        Info query(int p, int l, int r, int ql, int qr) {
            if (ql <= l && r <= qr) {
                return val[p];
            }
            int m = (l + r) >> 1;
            if (qr <= m) return query(p << 1, l, m, ql, qr);
            if (ql > m) return query(p << 1 | 1, m + 1, r, ql, qr);
            return mergeInfo(query(p << 1, l, m, ql, qr), query(p << 1 | 1, m + 1, r, ql, qr));
        }
    }

    //    static class FastReader {
//        private final BufferedReader bufferedReader;
//        private StringTokenizer stringTokenizer;
//
//        public FastReader() {
//            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        }
//
//        public String next() {
//            while (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
//                try {
//                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            return stringTokenizer.nextToken();
//        }
//
//        public int nextInt() {
//            return Integer.parseInt(next());
//        }
//
//        public long nextLong() {
//            return Long.parseLong(next());
//        }
//
//        public double nextDouble() {
//            return Double.parseDouble(next());
//        }
//
//        public String nextLine() {
//            String str = "";
//            try {
//                if (stringTokenizer.hasMoreTokens()) {
//                    str = stringTokenizer.nextToken("\n");
//                } else {
//                    str = bufferedReader.readLine();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return str;
//        }
//    }
    static class Reader {
        private final int BUFFER_SIZE = 1 << 16;
        private final DataInputStream dataInputStream;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            dataInputStream = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            dataInputStream = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    } else {
                        continue;
                    }
                }
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg) {
                c = read();
            }
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg) {
                return -ret;
            }
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg) {
                c = read();
            }
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg) {
                return -ret;
            }
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg) {
                c = read();
            }
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
            if (neg) {
                return -ret;
            }
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = dataInputStream.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) {
                buffer[0] = -1;
            }
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) {
                fillBuffer();
            }
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            dataInputStream.close();
        }
    }
}
/*
D. Graph and Queries
https://codeforces.com/contest/1416/problem/D

灵茶の试炼 2024-05-03
题目大意：
输入 n(1≤n≤2e5) m(1≤m≤3e5) q(1≤q≤5e5) 和一个 1~n 的排列 p。
有一个 n 个点 m 条边的图，点 v 的点权为 p[v]。
然后输入 m 条边。节点编号从 1 开始，不含重边和自环。
然后输入 q 个询问，格式如下：
"1 v"：输出 v 所在连通块的最大点权，然后把这个点权改成 0。
"2 i"：删除输入的第 i 条边。i 从 1 开始。保证 i 之前没有被删除过。

rating 2600
前置知识
1. 并查集
2. 单点修改区间查询线段树
3. 树的 DFS 时间戳（in out 时间戳）
处理询问的顺序
删边不好做，我们可以倒着处理询问，这样删边变成加边，可以用并查集解决。
注意没有被删除的边，要在倒序处理之前就用并查集合并。
此外，询问 1 会修改点权，必须正着做，没法倒着做。
所以我们得倒着处理一遍，再正着回答询问 1。
如何处理询问
如果能把询问 1 变成区间查询，就可以用线段树解决。
我们知道，子树 DFS 序（根节点的 in out 时间戳）可以对应一个连续区间。
那么在并查集 merge 的同时建树。比如 merge(1,2)，就把 find(1) 和 find(2) 之间连边，比如 find(1) 是 find(2) 的父节点。
此外，倒序处理时，记录询问 1 对应的 find(v)。
那么正序处理时，用 find(v) 子树对应的区间去处理询问 1，是不是就行了呢？
这样做是不对的，find(1) 和 find(2) 之间连边，谁是父亲，谁是儿子？
如果 find(1) 是父亲，那么正序处理询问，把 1-2 的边删除后，子树 find(1) 仍然会包含 find(2)。
我们可以添加一个虚拟节点 u，把 find(1) 和 find(2) 都作为 u 的儿子，删边前回答的是子树 u，删边后回答的就是子树 find(1) 或者 find(2) 了。
按照该规则，在倒序遍历询问，并查集的 merge 中添加一个建树的逻辑。
倒序遍历结束后，从根节点，也就是 find(i) = i 的节点开始 DFS，算出每个节点的 in out 时间戳。
然后正序遍历，利用 in out 时间戳在线段树上处理（线段树需要额外记录最大值的下标）。注意在倒序遍历时我们要计算出询问 1 的节点的 find(v)，这样才能查询子树的 in out 时间戳。
另外本题输入量很大，最好加上快读。
https://codeforces.com/contest/1416/submission/259280417
======

Input
5 4 6
1 2 5 4 3
1 2
2 3
1 3
4 5
1 1
2 1
2 3
1 1
1 2
1 2
Output
5
1
2
0
 */
