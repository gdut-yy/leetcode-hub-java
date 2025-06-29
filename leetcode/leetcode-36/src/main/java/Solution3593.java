import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3593 {
    private int ans;
    private List<Integer>[] g;
    private long[] longCost;

    public int minIncrease(int n, int[][] edges, int[] cost) {
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        g[0].add(-1); // 关键
        longCost = new long[cost.length];
        for (int i = 0; i < cost.length; i++) longCost[i] = cost[i];

        ans = 0;
        dfs(0, -1);
        return ans;
    }

    private void dfs(int x, int fa) {
        long maxS = 0;
        int maxS_cnt = 0;
        for (Integer y : g[x]) {
            if (y == fa) continue;
            dfs(y, x);
            if (longCost[y] > maxS) {
                maxS = longCost[y];
                maxS_cnt = 1;
            } else if (longCost[y] == maxS) {
                maxS_cnt++;
            }
        }
        ans += g[x].size() - maxS_cnt - 1;
        longCost[x] += maxS;
    }
}
/*
3593. 使叶子路径成本相等的最小增量
https://leetcode.cn/problems/minimum-increments-to-equalize-leaf-paths/description/

第 455 场周赛 T3。

给你一个整数 n，以及一个无向树，该树以节点 0 为根节点，包含 n 个节点，节点编号从 0 到 n - 1。这棵树由一个长度为 n - 1 的二维数组 edges 表示，其中 edges[i] = [ui, vi] 表示节点 ui 和节点 vi 之间存在一条边。
每个节点 i 都有一个关联的成本 cost[i]，表示经过该节点的成本。
路径得分 定义为路径上所有节点成本的总和。
你的目标是通过给任意数量的节点 增加 成本（可以增加任意非负值），使得所有从根节点到叶子节点的路径得分 相等 。
返回需要增加成本的节点数的 最小值 。
提示：
2 <= n <= 10^5
edges.length == n - 1
edges[i] == [ui, vi]
0 <= ui, vi < n
cost.length == n
1 <= cost[i] <= 10^9
输入保证 edges 表示一棵合法的树。

自底向上 贪心。
注意：为避免误把根节点（只有一个邻居的情况）认为是叶子，可以把 0 与 −1 相连，这样可以保证根至少有两个邻居。
时间复杂度 O(n)。
相似题目: 2673. 使二叉树所有路径值相等的最小代价
https://leetcode.cn/problems/make-costs-of-paths-equal-in-a-binary-tree/
 */