import java.util.ArrayList;
import java.util.Arrays;

public class Solution3772 {
    private ArrayList<Integer>[] g;
    private int[] good;
    private long[] dp;
    private long[] ans;

    public int[] maxSubgraphScore(int n, int[][] edges, int[] good) {
        this.good = good;
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }

        dp = new long[n];
        ans = new long[n];
        dfs(0, -1);
        reroot(0, -1);
        return Arrays.stream(ans).mapToInt(x -> (int) x).toArray();
    }

    private void dfs(int u, int parent) {
        dp[u] = (good[u] == 1 ? 1 : -1);
        for (int v : g[u]) {
            if (v == parent) continue;
            dfs(v, u);
            if (dp[v] > 0) {
                dp[u] += dp[v];
            }
        }
    }

    private void reroot(int u, int parent) {
        ans[u] = dp[u];
        for (int v : g[u]) {
            if (v == parent) continue;
            long dpU = dp[u];
            long dpV = dp[v];
            if (dp[v] > 0) {
                dp[u] -= dp[v];
            }
            long scoreFromU = dp[u];
            if (scoreFromU > 0) {
                dp[v] += scoreFromU;
            }
            reroot(v, u);
            dp[u] = dpU;
            dp[v] = dpV;
        }
    }
}
/*
3772. 树中子图的最大得分
https://leetcode.cn/problems/maximum-subgraph-score-in-a-tree/description/

第 479 场周赛 T4。

给你一个 无向树 ，它包含 n 个节点，编号从 0 到 n - 1。树由一个长度为 n - 1 的二维整数数组 edges 描述，其中 edges[i] = [ai, bi] 表示在节点 ai 和节点 bi 之间有一条边。
另给你一个长度为 n 的整数数组 good，其中 good[i] 为 1 表示第 i 个节点是好节点，为 0 表示它是坏节点。
定义 子图 的 得分 为子图中好节点的数量减去坏节点的数量。
对于每个节点 i，找到包含节点 i 的所有 连通子图 中可能的最大得分。
返回一个长度为 n 的整数数组，其中第 i 个元素是节点 i 的 最大得分 。
子图 是原图的一个子集，其顶点和边均来自原图。
连通子图 是一个子图，其中每一对顶点都可以通过该子图的边相互到达。
提示：
2 <= n <= 10^5
edges.length == n - 1
edges[i] = [ai, bi]
0 <= ai, bi < n
good.length == n
0 <= good[i] <= 1
输入保证 edges 表示一棵有效树。

换根 DP。
https://chat.deepseek.com/a/chat/s/00ff5131-013f-4cdb-8e2b-2812ab01c9dd
时间复杂度 O(n)。
 */