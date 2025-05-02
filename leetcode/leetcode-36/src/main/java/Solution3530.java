import java.util.Arrays;

public class Solution3530 {
    private int[] score, pre, memo;
    private int full;

    public int maxProfit(int n, int[][] edges, int[] score) {
        this.score = score;
        pre = new int[n];
        for (int[] e : edges) {
            // r[1] 的先修课程集合
            pre[e[1]] |= 1 << e[0];
        }

        full = (1 << n) - 1;
        memo = new int[1 << n];
        Arrays.fill(memo, -1);
        return dfs(full);
    }

    private int dfs(int msk) {
        if (msk == 0) return 0; // 空集
        if (memo[msk] != -1) return memo[msk]; // 之前算过了
        int ci = full ^ msk; // i 的补集 complementary set
        int res = 0;
        int i = Integer.bitCount(ci);
        for (int j = 0; j < pre.length; j++) {
            // pre1[j] 在 i 的补集中，可以学（否则这学期一定不能学）
            if ((msk >> j & 1) == 1 && (pre[j] | ci) == ci) {
                res = Math.max(res,
                        dfs(msk ^ (1 << j)) + score[j] * (i + 1));
            }
        }
        return memo[msk] = res;
    }
}
/*
3530. 有向无环图中合法拓扑排序的最大利润
https://leetcode.cn/problems/maximum-profit-from-valid-topological-order-in-dag/description/

第 155 场双周赛 T4。

给你一个由 n 个节点组成的有向无环图（DAG），节点编号从 0 到 n - 1，通过二维数组 edges 表示，其中 edges[i] = [ui, vi] 表示一条从节点 ui 指向节点 vi 的有向边。每个节点都有一个对应的 得分 ，由数组 score 给出，其中 score[i] 表示节点 i 的得分。
你需要以 有效的拓扑排序 顺序处理这些节点。每个节点在处理顺序中被分配一个编号从 1 开始的位置。
将每个节点的得分乘以其在拓扑排序中的位置，然后求和，得到的值称为 利润。
请返回在所有合法拓扑排序中可获得的 最大利润 。
拓扑排序 是一个对 DAG 中所有节点的线性排序，使得每条有向边 u → v 中，节点 u 都出现在 v 之前。
提示：
1 <= n == score.length <= 22
1 <= score[i] <= 10^5
0 <= edges.length <= n * (n - 1) / 2
edges[i] == [ui, vi] 表示一条从 ui 到 vi 的有向边。
0 <= ui, vi < n
ui != vi
输入图 保证 是一个 DAG。
不存在重复的边。

排列型状压 DP。
时间复杂度 O(m+n2^n)。
相似题目: 1494. 并行课程 II
https://leetcode.cn/problems/parallel-courses-ii/description/
rating 2374 (clist.by)
 */