package p1857;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CF1857G {
    static int n, s;
    static int[][] edges;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            s = scanner.nextInt();
            edges = new int[n - 1][3];
            for (int i = 0; i < n - 1; i++) {
                edges[i][0] = scanner.nextInt();
                edges[i][1] = scanner.nextInt();
                edges[i][2] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static final int MOD = 998244353;

    private static String solve() {
        Arrays.sort(edges, Comparator.comparingInt(o -> o[2]));
        long ans = 1;
        DSU dsu = new DSU(n + 1);
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            int sub_u = dsu.sz[dsu.find(u)];
            int sub_v = dsu.sz[dsu.find(v)];
            ans = ans * quickPow(s - w + 1, (long) sub_u * sub_v - 1) % MOD;
            dsu.union(u, v);
        }
        return String.valueOf(ans);
    }

    static long binpow(long a, long n) {
        if (n == 0) return 1;
        if (n % 2 == 0) return binpow(a * a % MOD, n / 2);
        else return a * binpow(a, n - 1) % MOD;
    }

    // 模下的 a^b
    private static long quickPow(long a, long b) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * a % MOD;
            }
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }

    private static class DSU {
        int[] fa;
        int[] sz;

        public DSU(int n) {
            fa = new int[n];
            sz = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
                sz[i] = 1;
            }
        }

        int find(int x) {
            if (x != fa[x]) {
                fa[x] = find(fa[x]);
            }
            return fa[x];
        }

        void union(int u, int v) {
            u = find(u);
            v = find(v);
            if (u == v) return;
            fa[u] = v;
            sz[v] += sz[u];
        }
    }
}
/*
G. Counting Graphs
https://codeforces.com/contest/1857/problem/G

题目大意：
给定一个由 n 个顶点组成的树。树是无环连通的无向图。树的每条边都有自己的权重，wi。
你的任务是计算满足所有四个条件的不同图的数量:
1. 图没有自环和多条边。
2. 图边的权值为整数，且不超过 S。
3. 这个图只有一个最小生成树。
4. 图的最小生成树就是给定的树。
考虑到边的权重，如果两个图的边集不同，则认为它们是不同的。
答案可以很大，输出它模 998244353。

https://codeforces.com/blog/entry/119134
第一个观察结果是图将由 n 个顶点组成，因为 MST 是固定的。因此，图看起来就像给定的树，其中连接了一些新的顶点。
下一步是确定顶点 u 和 v 之间的新边的可能权重。设 P(u,v)为从 u 到 v 的简单路径上的最大权值。我假设我们可以在顶点 u 和 v 之间添加一条新边它的权值在[P(u,v)+1,S]范围内。当我们考虑一些例子时，这一点就变得清楚了。如果边的权值小于或等于 P(u,v)，则 MST 将通过取新边而不是路径上权值最大的边来改变。
注意，如果我们添加一条新边，并且它不影响 MST，我们可以独立于前一条边添加另一条边。
所以现在的任务是计算 ∏1≤u<v≤n(S−P(u,v)+1)，因为对于每一对顶点，我们可以从范围中分配一个新的权值，这给了我们 S−P(u,v)种情况，或者我们可以选择不添加任何边，这是一种情况。
现在，我们来讨论一下如何有效地计算公式:
1、根据给定边的权值按升序排序:w1≤w2≤...≤wn−1。
2、我们将从没有边的图开始，逐步添加新的边。假设我们已经把所有的边都加到了 ui vi wi 上。现在，我们要加上 i - 1。注意，wi 比之前的任何权重都大，ui 和 vi 来自不同的分量。
3、添加完这条边后，我们需要计算经过这条边的路径数。如果我们知道包含 ui 和 vi 的分量的大小，分别记为 su 和 sv，则在不包含这两个顶点形成的路径的情况下，存在通过 ui,vi 的 su·sv−1 条路径。
4、我们知道路径的数量，在每条路径上，我们可以确定我们可以赋予边的权值。因此，我们需要将答案乘以(S−wi+1)^(su·sv−1)，使用二进制幂。
为了有效地添加边并找到组件的大小，您可以使用 DSU (Disjoint Set Union)。
这种方法的复杂度是 O(nlogn)。
======

input
4
2 5
1 2 4
4 5
1 2 2
2 3 4
3 4 3
5 6
1 2 3
1 3 2
3 4 6
3 5 1
10 200
1 2 3
2 3 33
3 4 200
1 5 132
5 6 1
5 7 29
7 8 187
7 9 20
7 10 4
output
1
8
80
650867886
 */
