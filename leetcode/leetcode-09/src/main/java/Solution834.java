import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution834 {
    private Map<Integer, List<Integer>> adj;
    private int[] sz, dp, ans;

    // https://leetcode.cn/problems/sum-of-distances-in-tree/solution/shu-zhong-ju-chi-zhi-he-by-leetcode-solution/
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        adj = new HashMap<>();
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
        }
        // dp[u] 表示以 u 为根的子树，它的所有子节点到它的距离之和
        // sz[u] 表示以 u 为根的子树的节点数量
        sz = new int[n];
        dp = new int[n];
        ans = new int[n];

        dfs1(0, -1);
        dfs2(0, -1);
        return ans;
    }

    private void dfs1(int u, int fa) {
        sz[u] = 1;
        dp[u] = 0;
        for (int v : adj.getOrDefault(u, new ArrayList<>())) {
            if (v == fa) {
                continue;
            }
            dfs1(v, u);
            dp[u] += dp[v] + sz[v];
            sz[u] += sz[v];
        }
    }

    private void dfs2(int u, int fa) {
        ans[u] = dp[u];
        for (int v : adj.getOrDefault(u, new ArrayList<>())) {
            if (v == fa) {
                continue;
            }
            // 让 v 换到根的位置，u 变为其孩子节点，同时维护原有的 dp 信息
            int pu = dp[u], pv = dp[v];
            int su = sz[u], sv = sz[v];

            dp[u] -= dp[v] + sz[v];
            sz[u] -= sz[v];
            dp[v] += dp[u] + sz[u];
            sz[v] += sz[u];

            dfs2(v, u);

            dp[u] = pu;
            dp[v] = pv;
            sz[u] = su;
            sz[v] = sv;
        }
    }
}
/*
834. 树中距离之和
https://leetcode.cn/problems/sum-of-distances-in-tree/

给定一个无向、连通的树。树中有 n 个标记为 0...n-1 的节点以及 n-1 条边 。
给定整数 n 和数组 edges ， edges[i] = [ai, bi]表示树中的节点 ai 和 bi 之间有一条边。
返回长度为 n 的数组 answer ，其中 answer[i] 是树中第 i 个节点与所有其他节点之间的距离之和。
提示:
1 <= n <= 3 * 10^4
edges.length == n - 1
edges[i].length == 2
0 <= ai, bi < n
ai != bi
给定的输入保证为有效的树

树形 DP
官方题解: https://leetcode.cn/problems/sum-of-distances-in-tree/solution/shu-zhong-ju-chi-zhi-he-by-leetcode-solution/
 */