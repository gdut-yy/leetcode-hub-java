package p1891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class CF1891F {
    static int q;
    static List<Integer>[] g;
    static int[] addT;
    static List<int[]>[] rec; // t, x
    static int n;

    public static void main(String[] args) {
        // Time limit exceeded on test 2
//        Scanner scanner = new Scanner(System.in);
        FastReader scanner = new FastReader();
        int T = scanner.nextInt();
        while (T-- > 0) {
            q = scanner.nextInt();
            g = new ArrayList[q + 1];
            Arrays.setAll(g, e -> new ArrayList<>());
            addT = new int[q + 1];
            rec = new ArrayList[q + 1];
            Arrays.setAll(rec, e -> new ArrayList<>());

            n = 1;
            for (int t = 0; t < q; t++) {
                int op = scanner.nextInt();
                int v = scanner.nextInt() - 1;
                if (op == 1) {
                    g[v].add(n);
                    addT[n] = t;
                    n++;
                } else {
                    int x = scanner.nextInt();
                    rec[v].add(new int[]{t, x});
                }
            }
            System.out.println(solve());
        }
    }

    static long[] ans;
    static BIT tr;

    private static String solve() {
        ans = new long[n];
        tr = new BIT(q);
        dfs(0);
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }

    static void dfs(int v) {
        for (int[] p : rec[v]) {
            tr.add(q - p[0], p[1]);
        }
        ans[v] = tr.query(q - addT[v]);
        for (Integer w : g[v]) {
            dfs(w);
        }
        for (int[] p : rec[v]) {
            tr.add(q - p[0], -p[1]);
        }
    }

    static class BIT {
        int n;
        long[] tree;

        public BIT(int n) {
            this.n = n;
            tree = new long[n + 1];
        }

        int lb(int x) {
            return x & -x;
        }

        void add(int pos, int val) {
            for (; pos <= n; pos += lb(pos)) tree[pos] += val;
        }

        long query(int pos) {
            long ret = 0;
            for (; pos > 0; pos -= lb(pos)) ret += tree[pos];
            return ret;
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
F. A Growing Tree
https://codeforces.com/contest/1891/problem/F

灵茶の试炼 2024-10-31
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤5e5。
每组数据输入 q(1≤q≤5e5) 和 q 个操作。
有一棵树，一开始只有一个根节点 1，点权为 0。
有两种操作，格式如下：
"1 v"：在节点 v 的下面添加一个编号为 sz+1、点权为 0 的儿子，其中 sz 是当前这棵树的大小。
"2 v x"：把以 v 为根的子树中的所有节点的点权都增加 x(-1e9≤x≤1e9)。
输出所有操作结束后，节点 1,2,3,...,sz 的点权。其中 sz 是最终的树的大小。

rating 2000
横看成岭侧成峰，站在单个节点的角度，去计算这个节点的最终点权。
设添加点 v 的时刻为 T，我们需要计算在 T 之后、发生在 v 的祖先节点（含 v）的操作 2 的 x 值之和。
离线询问：
1. 记录节点 v 添加的时间 T=addT[v]。
2. 记录操作 2，用 rec[v] 保存一个 pair 列表，pair 保存发生在 v 上的操作 2 的时间 t 以及 x。
然后写一个回溯，用树状数组维护从根到 v 这条路径上的所有操作 2 的 x 的前缀和。树状数组的下标表示时间 t。
这样就可以在树状数组上询问发生在 T=addT[v] 之后的祖先节点上的操作 2 的 x 之和了。
下面代码用 q-t 作为下标，而不是 t+1，这样可以转换成计算前缀的元素和。
C++/Java 选手注意用 64 位整数。
代码 https://codeforces.com/contest/1891/submission/288890267
代码备份（洛谷）
======

Input
3
9
2 1 3
1 1
2 2 1
1 1
2 3 2
1 3
2 1 4
1 3
2 3 2
5
2 1 1
1 1
2 1 -1
1 1
2 1 1
5
1 1
1 1
2 1 1
2 1 3
2 2 10
Output
7 5 8 6 2
1 0 1
4 14 4
 */
