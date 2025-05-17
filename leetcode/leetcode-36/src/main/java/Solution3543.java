import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution3543 {
    private List<int[]>[] g;
    private int k, t, ans;
    private Set<String> memo;

    public int maxWeight(int n, int[][] edges, int k, int t) {
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] e : edges) {
            g[e[0]].add(new int[]{e[1], e[2]}); // y, wt
        }
        this.k = k;
        this.t = t;

        memo = new HashSet<>();
        ans = -1;
        for (int x = 0; x < n; x++) {
            dfs(x, 0, 0);
        }
        return ans;
    }

    private void dfs(int x, int i, int s) {
        String key = x + ":" + i + ":" + s;
        if (!memo.add(key)) return;
        if (i == k) {
            ans = Math.max(ans, s);
            return;
        }
        for (int[] p : g[x]) {
            int y = p[0], wt = p[1];
            if (s + wt < t) {
                dfs(y, i + 1, s + wt);
            }
        }
    }
}
/*
3543. K 条边路径的最大边权和
https://leetcode.cn/problems/maximum-weighted-k-edge-path/description/

第 156 场双周赛 T3。

给你一个整数 n 和一个包含 n 个节点（编号从 0 到 n - 1）的 有向无环图（DAG）。该图由二维数组 edges 表示，其中 edges[i] = [ui, vi, wi] 表示一条从节点 ui 到 vi 的有向边，边的权值为 wi。
同时给你两个整数 k 和 t。
你的任务是确定在图中边权和 尽可能大的 路径，该路径需满足以下两个条件：
- 路径包含 恰好 k 条边；
- 路径上的边权值之和 严格小于 t。
返回满足条件的一个路径的 最大 边权和。如果不存在这样的路径，则返回 -1。
提示:
1 <= n <= 300
0 <= edges.length <= 300
edges[i] = [ui, vi, wi]
0 <= ui, vi < n
ui != vi
1 <= wi <= 10
0 <= k <= 300
1 <= t <= 600
输入图是 有向无环图（DAG）。
不存在重复的边。

DFS
https://leetcode.cn/problems/maximum-weighted-k-edge-path/solutions/3673824/liang-chong-fang-fa-dfs-tuo-bu-xu-dppyth-vnva/
时间复杂度 O((n+m)kt)。其中 m 是 edges 的长度。
相似题目: 3509. 最大化交错和为 K 的子序列乘积
https://leetcode.cn/problems/maximum-product-of-subsequences-with-an-alternating-sum-equal-to-k/description/
rating 2092 (clist.by)
 */