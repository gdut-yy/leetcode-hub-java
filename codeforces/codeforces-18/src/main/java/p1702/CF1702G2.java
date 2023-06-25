package p1702;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CF1702G2 {
    static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        // 建图
        adj = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt() - 1;
            int v = scanner.nextInt() - 1;
            adj.computeIfAbsent(u, key -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, key -> new ArrayList<>()).add(u);
        }
        // 预处理
        pretreatment();

        int q = scanner.nextInt();
        while (q-- > 0) {
            int k = scanner.nextInt();
            Integer[] p = new Integer[k];
            for (int i = 0; i < k; i++) {
                p[i] = scanner.nextInt() - 1;
            }
            System.out.println(solve(k, p));
        }
    }

    // 2^18 = 262,144 > 2e5
    private static final int K = 19;
    private static int[] depth;
    private static int[][] pa;
    private static Map<Integer, List<Integer>> adj;

    private static void pretreatment() {
        depth = new int[n];
        pa = new int[n][K];
        dfs(0, 0);
    }

    private static String solve(int k, Integer[] p) {
        // 深度由大到小
        Arrays.sort(p, (o1, o2) -> Integer.compare(depth[o2], depth[o1]));

        boolean[] used = new boolean[k];
        for (int i = 0; i < k; i++) {
            if (lca(p[0], p[i]) == p[i]) {
                used[i] = true;
            }
        }

        int f = 0;
        while (f < k && used[f]) {
            f++;
        }
        if (f == k) {
            return "YES";
        }

        boolean ans = true;
        for (int i = f; i < k; i++) {
            if (lca(p[f], p[i]) == p[i]) {
                used[i] = true;
            }
        }
        for (boolean e : used) {
            ans &= e;
        }
        ans &= depth[lca(p[0], p[f])] <= depth[p[k - 1]];
        return ans ? "YES" : "NO";
    }

    private static void dfs(int x, int fa) {
        depth[x] = depth[fa] + 1;
        pa[x][0] = fa;
        for (int i = 1; i < K; ++i) {
            pa[x][i] = pa[pa[x][i - 1]][i - 1];
        }
        for (int y : adj.getOrDefault(x, new ArrayList<>())) {
            if (y == fa) continue;
            dfs(y, x);
        }
    }

    private static int lca(int x, int y) {
        if (depth[x] > depth[y]) {
            int tmp = x;
            x = y;
            y = tmp;
        }
        for (int i = K - 1; i >= 0; i--) {
            if (depth[y] - depth[x] >= 1 << i) {
                y = pa[y][i];
            }
        }
        for (int i = K - 1; i >= 0; i--) {
            if (pa[x][i] != pa[y][i]) {
                x = pa[x][i];
                y = pa[y][i];
            }
        }
        return x == y ? x : pa[x][0];
    }
}
/*
G2. Passable Paths (hard version)
https://codeforces.com/contest/1702/problem/G2

题目大意：
这是这个问题的一个难解版本。简单版本和困难版本之间的唯一区别是查询的数量。（G1 1≤q≤5 1≤q≤10^5）
Polycarp 从 n 个顶点长成一棵树。我们提醒你，有 n 个顶点的树是一个有 n 个顶点和 n - 1 条边的无向连通图，它不包含环。
他称一组顶点为可通过的前提是树中存在这样一条路径，该路径通过集合中的每个顶点而不经过任何边两次。路径可以访问其他顶点(不是来自这个集合)。
换句话说，如果有一条简单的路径经过这个集合的所有顶点(也可能是其他顶点)，那么这个顶点集就被称为可通过的。
例如，对于下面的树集{3,2,5}，{1,5,4}，{1,4}是可传递的，而{1,3,5}，{1,2,3,4,5}是不可传递的。
波利卡普要求你回答 q 个问题。每个查询都是一组顶点。对于每个查询，您需要确定相应的顶点集是否可以传递。
---
给定整数 n，n-1 行表示边，形成无向联通图，整数 q，q 行查询，每行为若干节点集合，求是否存在简单路径经过这些节点。

倍增法求 LCA
回想一下，根树中的路径——从一端上升到端点的最小共同祖先(lca)，然后下降到另一端(可能是 0)。然后我们的集合被分为两种简单的方式。
要检查这一点，您只需要计算 lca。
为了解决这个问题的一个简单版本，我们将首先计算深度。我们将根据深度的不增长来沿着顶点走，如果最深顶点和当前顶点的 lca 等于当前顶点，那么它就是最深顶点的祖先，我们将它标记出来。接下来，我们将找到最深的未标记顶点并做同样的事情，如果没有这样的顶点，那么整个路径向下，答案是肯定的。
如果有未标记的顶点，那么在这两个上升点之外就会有顶点，答案是否定的。现在我们需要检查这两个顶点是否相交或者只相交于 lca 端点，为此我们只需确保 lca 不深于集合中最浅的顶点。
======

input
5
1 2
2 3
2 4
4 5
5
3
3 2 5
5
1 2 3 4 5
2
1 4
3
1 3 5
3
1 5 4
output
YES
NO
YES
NO
YES

input
5
1 2
3 2
2 4
5 2
4
2
3 1
3
3 4 5
3
2 3 5
1
1
output
YES
NO
YES
YES
 */