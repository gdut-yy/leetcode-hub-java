package p176;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class CF176E {
    // Time limit exceeded on test 20
//    static Scanner scanner = new Scanner(System.in);
    static FastReader scanner = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static ArrayList<int[]>[] g;
    static final int mx = 17;
    static int[][] pa;
    static int[] dep;
    static long[] dis;
    static int[] dfn;
    static int ts;
    static TreapM t;
    static long ans;

    private static void solve() {
        int n = scanner.nextInt();
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 0; i < n - 1; i++) {
            int v = scanner.nextInt() - 1;
            int w = scanner.nextInt() - 1;
            int wt = scanner.nextInt();
            g[v].add(new int[]{w, wt});
            g[w].add(new int[]{v, wt});
        }

        pa = new int[n][mx];
        dep = new int[n];
        dis = new long[n];
        dfn = new int[n];
        ts = 0;
        dfs(0, -1);
        for (int i = 0; i < mx - 1; i++) {
            for (int v = 0; v < pa.length; v++) {
                int p = pa[v][i];
                if (p != -1) {
                    pa[v][i + 1] = pa[p][i];
                } else {
                    pa[v][i + 1] = -1;
                }
            }
        }

        t = new TreapM();
        ans = 0;

        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            String op = scanner.next();
            if (op.equals("?")) {
                out.println(ans / 2);
                continue;
            }
            int v = scanner.nextInt() - 1;
            int d = dfn[v];
            if (op.equals("+")) {
                func_do(d, 1, v);
                t.put(d, v);
            } else {
                t.delete(d);
                func_do(d, -1, v);
            }
        }
    }

    static void dfs(int v, int p) {
        dfn[v] = ++ts;
        pa[v][0] = p;
        for (int[] e : g[v]) {
            int w = e[0];
            if (w == p) continue;
            dep[w] = dep[v] + 1;
            dis[w] = dis[v] + e[1];
            dfs(w, v);
        }
    }

    static int uptoDep(int v, int d) {
        for (int k = dep[v] - d; k > 0; k &= k - 1) {
            v = pa[v][Integer.numberOfTrailingZeros(k)];
        }
        return v;
    }

    static int getLCA(int v, int w) {
        if (dep[v] > dep[w]) {
            int tmp = v;
            v = w;
            w = tmp;
        }
        w = uptoDep(w, dep[v]);
        if (w == v) return v;
        for (int i = mx - 1; i >= 0; i--) {
            if (pa[v][i] != pa[w][i]) {
                v = pa[v][i];
                w = pa[w][i];
            }
        }
        return pa[v][0];
    }

    static long getDis(int v, int w) {
        return dis[v] + dis[w] - dis[getLCA(v, w)] * 2L;
    }

    static void func_do(int d, int mul, int v) {
        if (t.isEmpty()) return;
        NodeM o = t.prev(d);
        int pre;
        if (o == null) {
            o = t.max();
        }
        pre = o.value;
        o = t.next(d);
        int nxt;
        if (o == null) {
            o = t.min();
        }
        nxt = o.value;
        ans += (getDis(pre, v) + getDis(v, nxt) - getDis(pre, nxt)) * mul;
    }

    static class NodeM {
        NodeM[] son = new NodeM[2];
        long priority;
        Integer key;
        Integer value;
        int subSize;

        int size() {
            return subSize;
        }

        void maintain() {
            subSize = 1 + (son[0] != null ? son[0].size() : 0) + (son[1] != null ? son[1].size() : 0);
        }

        NodeM rotate(int d) {
            NodeM x = son[d ^ 1];
            son[d ^ 1] = x.son[d];
            x.son[d] = this;
            maintain();
            x.maintain();
            return x;
        }
    }

    static class TreapM {
        long rd;
        NodeM root;

        TreapM() {
            rd = new Random().nextLong();
        }

        long fastRand() {
            rd ^= rd << 13;
            rd ^= rd >>> 17;
            rd ^= rd << 5;
            return rd;
        }

        int size() {
            return root != null ? root.subSize : 0;
        }

        boolean isEmpty() {
            return size() == 0;
        }

        NodeM _put(NodeM o, Integer key, Integer value) {
            if (o == null) {
                o = new NodeM();
                o.priority = fastRand();
                o.key = key;
                o.value = value;
                o.subSize = 1;
            } else {
                int c = Integer.compare(key, o.key);
                if (c == 0) {
                    o.value = value;
                } else {
                    int d = c > 0 ? 1 : 0;
                    o.son[d] = _put(o.son[d], key, value);
                    if (o.son[d].priority > o.priority) {
                        o = o.rotate(d ^ 1);
                    }
                }
            }
            o.maintain();
            return o;
        }

        void put(Integer key, Integer value) {
            root = _put(root, key, value);
        }

        NodeM _delete(NodeM o, Integer key) {
            if (o == null) return null;
            int c = Integer.compare(key, o.key);
            if (c != 0) {
                int d = c > 0 ? 1 : 0;
                o.son[d] = _delete(o.son[d], key);
            } else {
                if (o.son[1] == null) return o.son[0];
                if (o.son[0] == null) return o.son[1];
                int d = o.son[0].priority > o.son[1].priority ? 1 : 0;
                o = o.rotate(d);
                o.son[d] = _delete(o.son[d], key);
            }
            o.maintain();
            return o;
        }

        void delete(Integer key) {
            root = _delete(root, key);
        }

        NodeM min() {
            return kth(0);
        }

        NodeM max() {
            return kth(size() - 1);
        }

        int lowerBoundIndex(Integer key) {
            int kth = 0;
            NodeM o = root;
            while (o != null) {
                int c = Integer.compare(key, o.key);
                if (c < 0) {
                    o = o.son[0];
                } else if (c > 0) {
                    kth += (o.son[0] != null ? o.son[0].size() : 0) + 1;
                    o = o.son[1];
                } else {
                    kth += (o.son[0] != null ? o.son[0].size() : 0);
                    break;
                }
            }
            return kth;
        }

        int upperBoundIndex(Integer key) {
            int kth = 0;
            NodeM o = root;
            while (o != null) {
                int c = Integer.compare(key, o.key);
                if (c < 0) {
                    o = o.son[0];
                } else if (c > 0) {
                    kth += (o.son[0] != null ? o.son[0].size() : 0) + 1;
                    o = o.son[1];
                } else {
                    kth += (o.son[0] != null ? o.son[0].size() : 0) + 1;
                    break;
                }
            }
            return kth;
        }

        NodeM kth(int k) {
            if (k < 0 || k >= size()) return null;
            NodeM o = root;
            while (o != null) {
                int leftSize = o.son[0] != null ? o.son[0].size() : 0;
                if (k < leftSize) {
                    o = o.son[0];
                } else {
                    k -= leftSize + 1;
                    if (k < 0) break;
                    o = o.son[1];
                }
            }
            return o;
        }

        NodeM prev(Integer key) {
            return kth(lowerBoundIndex(key) - 1);
        }

        NodeM next(Integer key) {
            return kth(upperBoundIndex(key));
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
E. Archaeology
https://codeforces.com/contest/176/problem/E

灵茶の试炼 2025-06-20
题目大意：
输入 n(1≤n≤1e5) 和一棵无向树的 n-1 条边（节点编号从 1 开始），每条边包含 3 个数 x y z(1≤z≤1e9)，表示有一条边权为 z 的边连接 x 和 y。
一开始有一个集合 S，初始为空。
然后输入 q(1≤q≤1e5) 和 q 个询问，格式如下：
"+ v"：把点 v 加到集合 S 中，保证 v 不在 S 中。
"- v"：把点 v 从集合 S 中删除，保证 v 在 S 中。
"?"：输出包含 S 所有点的最小连通块（用最少的边连通 S 中所有点）的边权之和。

rating 3100
在 3553. 包含给定路径的最小带权子树 II 的基础上，我们需要动态增删点。
添加点时，我们需要知道 v 的 DFS 序最近的左右两个点 pre 和 nxt，这可以用平衡树 map 维护，key 是 DFN，value 是节点编号。
总和减去 dis(pre, nxt)，加上 dis(pre, v) 和 dis(v, nxt)。
删除则反过来。
输出答案时要除以 2，因为我们算的是回路。
代码 https://codeforces.com/contest/176/submission/324966249
代码备份（Ubuntu Pastebin）
======

Input
6
1 2 1
1 3 5
4 1 7
4 5 3
6 4 2
10
+ 3
+ 1
?
+ 6
?
+ 5
?
- 6
- 3
?
Output
5
14
17
10

5
2 5 150467345
1 4 366330498
2 3 341836058
2 4 597500157
63
?
+ 1
?
+ 2
?
- 1
?
+ 3
?
+ 1
?
- 2
?
- 1
?
+ 4
?
+ 1
?
+ 2
?
- 1
?
- 3
?
+ 1
?
- 2
?
- 1
?
+ 5
?
+ 1
?
+ 2
?
- 1
?
+ 3
?
+ 1
?
- 2
?
- 1
?
- 4
?
+ 1
?
+ 2
?
- 1
?
- 3
?
+ 1
?
- 2
?
- 1
?
 */
