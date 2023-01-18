import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> resList = new ArrayList<>();
        if (n == 1) {
            resList.add(0);
            return resList;
        }

        // 无向图
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            adj.computeIfAbsent(from, key -> new HashSet<>()).add(to);
            adj.computeIfAbsent(to, key -> new HashSet<>()).add(from);
        }

        // 度为 1 进队列
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        // n 个节点的树，标记为 0 到 n - 1
        for (int i = 0; i < n; i++) {
            if (adj.getOrDefault(i, new HashSet<>()).size() == 1) {
                queue.add(i);
                visited[i] = true;
            }
        }
        while (!queue.isEmpty()) {
            resList.clear();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.remove();
                resList.add(cur);

                for (int next : adj.getOrDefault(cur, new HashSet<>())) {
                    adj.get(next).remove(cur);
                    if (!visited[next] && adj.get(next).size() == 1) {
                        visited[next] = true;
                        queue.add(next);
                    }
                }
            }
        }
        return resList;
    }

    private Map<Integer, List<Integer>> adj;
    private int[] f1, f2, g, p;

    // 树形 DP
    // https://leetcode.cn/problems/minimum-height-trees/solution/by-ac_oier-7xio/
    public List<Integer> findMinHeightTrees2(int n, int[][] edges) {
        adj = new HashMap<>();
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
        }
        // f[u] 代表在以 0 号点为根节点的树中，以 u 节点为子树根节点时，往下的最大高度
        // g[u] 代表在以 0 号点为根节点的树中，以 u 节点为子节点时，往上的最大高度
        // f1 最大值，f2 次大值
        f1 = new int[n];
        f2 = new int[n];
        g = new int[n];
        // p 数组记录下取得 f1[u] 时 u 的子节点 j 为何值。
        p = new int[n];

        dfs1(0, -1);
        dfs2(0, -1);
        List<Integer> ans = new ArrayList<>();
        int min = n;
        for (int i = 0; i < n; i++) {
            int cur = Math.max(f1[i], g[i]);
            if (cur < min) {
                min = cur;
                ans.clear();
                ans.add(i);
            } else if (cur == min) {
                ans.add(i);
            }
        }
        return ans;
    }

    private int dfs1(int u, int fa) {
        for (int v : adj.getOrDefault(u, new ArrayList<>())) {
            if (v == fa) {
                continue;
            }
            int sub = dfs1(v, u) + 1;
            if (sub > f1[u]) {
                f2[u] = f1[u];
                f1[u] = sub;
                p[u] = v;
            } else if (sub > f2[u]) {
                f2[u] = sub;
            }
        }
        return f1[u];
    }

    private void dfs2(int u, int fa) {
        for (int v : adj.getOrDefault(u, new ArrayList<>())) {
            if (v == fa) {
                continue;
            }
            if (p[u] != v) {
                g[v] = Math.max(g[v], f1[u] + 1);
            } else {
                g[v] = Math.max(g[v], f2[u] + 1);
            }
            g[v] = Math.max(g[v], g[u] + 1);
            dfs2(v, u);
        }
    }
}
/*
310. 最小高度树
https://leetcode.cn/problems/minimum-height-trees/

树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，一个任何没有简单环路的连通图都是一棵树。
给你一棵包含 n 个节点的树，标记为 0 到 n - 1 。给定数字 n 和一个有 n - 1 条无向边的 edges 列表（每一个边都是一对标签），
其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条无向边。
可选择树中任何一个节点作为根。当选择节点 x 作为根节点时，设结果树的高度为 h 。在所有可能的树中，具有最小高度的树（即，min(h)）被称为 最小高度树 。
请你找到所有的 最小高度树 并按 任意顺序 返回它们的根节点标签列表。
树的 高度 是指根节点和叶子节点之间最长向下路径上边的数量。
提示：
1 <= n <= 2 * 10^4
edges.length == n - 1
0 <= ai, bi < n
ai != bi
所有 (ai, bi) 互不相同
给定的输入 保证 是一棵树，并且 不会有重复的边

拓扑排序。
每次去掉度为 1 的顶点。保留最内层。
 */