import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution4108 {
    public long minCost(int n, String colors, int[][] edges) {
        List<Integer>[] g = new List[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        int[] parent = new int[n];
        Arrays.fill(parent, -2);
        int[] order = new int[n];
        parent[0] = -1;
        int front = 0, back = 0;
        order[back++] = 0;
        while (front < back) {
            int u = order[front++];
            for (int v : g[u]) {
                if (parent[v] == -2) {
                    parent[v] = u;
                    order[back++] = v;
                }
            }
        }
        long[] size = new long[n];
        Arrays.fill(size, 1);
        for (int idx = n - 1; idx > 0; idx--) {
            int u = order[idx];
            size[parent[u]] += size[u];
        }
        long base = 0;
        for (int u = 0; u < n; u++) {
            if (colors.charAt(u) == 'R') {
                base += size[u];
            }
        }
        long[] f = new long[n];
        for (int idx = n - 1; idx >= 0; idx--) {
            int u = order[idx];
            long delta = colors.charAt(u) == 'B' ? size[u] : -size[u];
            long bestChild = 0;
            for (int v : g[u]) {
                if (parent[v] == u && f[v] < 0) {
                    bestChild += f[v];
                }
            }
            f[u] = delta + bestChild;
        }
        long bestConn = 0;
        for (int u = 0; u < n; u++) {
            bestConn = Math.min(bestConn, f[u]);
        }
        return base + bestConn;
    }
}
/*
4108. 使红色节点连通的最小代价
https://leetcode.cn/problems/minimum-cost-to-make-red-nodes-connected/description/

第 527 场周赛 T3。

给你一个整数 n，表示一棵有 n 个节点的树，节点编号从 0 到 n - 1，并且树以节点 0 为 根节点。这棵树由一个长度为 n - 1 的二维数组 edges 表示，其中 edges[i] = [ui, vi] 表示节点 ui 和 vi 之间存在一条 无向 边。
另给你一个长度为 n 的字符串 colors，其中 colors[i] 表示节点 i 的颜色：'R' 表示红色，'B' 表示蓝色。
你可以 翻转 任意节点的颜色：从 'R' 变为 'B'，或从 'B' 变为 'R'。翻转节点 u 的代价等于以节点 u 为根的子树的大小。
你的目标是通过翻转颜色，使所有 红色 节点在树中形成 一个连通分量 。蓝色节点可以不连通。没有红色节点的配置也视为有效。
返回实现这一目标所需的 最小总代价 。
在有根树中，节点 v 的子树是由所有到根节点的路径经过 v 的节点组成的集合。
示例 1：
输入： n = 3, colors = "RBR", edges = [[0,1],[1,2]]
输出： 1
示例 2：
输入： n = 3, colors = "RBR", edges = [[0,1],[0,2]]
输出： 0
示例 3：
输入： n = 4, colors = "BRRR", edges = [[0,1],[0,2],[0,3]]
输出： 2
示例 4：
输入： n = 3, colors = "BBB", edges = [[0,1],[1,2]]
输出： 0
提示：
1 <= n <= 10^5
n == colors.length
colors[i] 为 'R' 或 'B'。
edges.length == n - 1
edges[i] = [ui, vi]
0 <= ui, vi <= n - 1
输入保证 edges 表示一棵有效的树。

树上 DP 求最小权非空连通子树，同时允许全蓝的空集情况。
时间复杂度 O(n)。
 */