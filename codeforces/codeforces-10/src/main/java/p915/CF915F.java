package p915;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class CF915F {
    public static void main(String[] args) {
        // Time limit exceeded on test 11
        FastReader scanner = new FastReader();
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[][] edges = new int[n - 1][2];
        for (int i = 0; i < n - 1; i++) {
            edges[i][0] = scanner.nextInt() - 1;
            edges[i][1] = scanner.nextInt() - 1;
        }
        System.out.println(solve(n, a, edges));
    }

    private static String solve(int n, int[] a, int[][] edges) {
        for (int[] edge : edges) {
            int v = edge[0], w = edge[1];
            if (a[v] > a[w]) {
                edge[0] = w;
                edge[1] = v;
            }
        }

        Arrays.sort(edges, Comparator.comparingInt(o -> a[o[1]]));
        long ans = 0L;
        DSU dsu = new DSU(n);
        for (int[] edge : edges) {
            int v = dsu.find(edge[0]), w = dsu.find(edge[1]);
            ans += (long) dsu.sz[v] * dsu.sz[w] * a[edge[1]];
            dsu.fa[v] = w;
            dsu.sz[w] += dsu.sz[v];
        }

        Arrays.sort(edges, (o1, o2) -> Integer.compare(a[o2[0]], a[o1[0]]));
        dsu = new DSU(n);
        for (int[] edge : edges) {
            int v = dsu.find(edge[0]), w = dsu.find(edge[1]);
            ans -= (long) dsu.sz[v] * dsu.sz[w] * a[edge[0]];
            dsu.fa[v] = w;
            dsu.sz[w] += dsu.sz[v];
        }
        return String.valueOf(ans);
    }

    private static class DSU {
        int[] fa;
        int[] sz;

        public DSU(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
            sz = new int[n];
            Arrays.fill(sz, 1);
        }

        int find(int x) {
            if (x != fa[x]) {
                fa[x] = find(fa[x]);
            }
            return fa[x];
        }
    }

    private static class FastReader {
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
F. Imbalance Value of a Tree
https://codeforces.com/contest/915/problem/F

灵茶の试炼 2023-05-05
题目大意：
输入 n (1≤n≤1e6) 和长为 n 的数组 a(1≤a[i]≤1e6)，下标从 1 开始。
然后输入一棵树的 n-1 条边，节点编号从 1 开始。
定义 Δ(x,y) 表示从 x 到 y 的简单路径上的 a[i] 的最大值与最小值的差。
输出所有 Δ(i,j) 的和，其中 1≤i≤j≤n。

rating 2400
https://codeforces.com/problemset/submission/915/203430331
贡献法。
最大值和最小值分别计算贡献。
先算最大值的贡献。
随着 a[i] 不断变大，以 a[i] 为最大值的连通块的大小也在变大，这可以用并查集维护。
但是并查集一般是维护边的，怎么维护点呢？
把边 u-v 的边权当作 max(a[u],a[v]) 即可。
所以实际上是按照 max(a[u],a[v]) 对边排序，然后再并查集计算。
合并 u 和 v 的时候，计算 max(a[u],a[v]) 产生的贡献。根据乘法原理，这是 max(a[u],a[v]) * size[u] * size[v]，其中 size[i] 是合并前 i 所处连通块的大小。
最小值的贡献同理，按照 a[i] 从大到小计算。
代码实现时，可以让每条边的第二个端点的 a[i] 值更大，这样排序的时候就不需要求 max 了，效率更高。
相似题目: 2421. 好路径的数目
https://leetcode.cn/problems/number-of-good-paths/
======

input
4
2 2 3 1
1 2
1 3
1 4
output
6
 */
