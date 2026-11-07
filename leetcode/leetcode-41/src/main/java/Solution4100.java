import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution4100 {
    private static final long INF = Long.MAX_VALUE / 4;
    private long ans = INF;

    public int minActivationCost(int[][] edges, int[] values) {
        List<int[]>[] g = new ArrayList[values.length];
        Arrays.setAll(g, _ -> new ArrayList<>());

        for (int[] e : edges) {
            int x = e[0], y = e[1], c = e[2];
            g[x].add(new int[]{y, c});
            g[y].add(new int[]{x, c});
        }

        dfs(0, -1, 0, g, values);
        return ans < INF ? (int) ans : -1;
    }

    // pOnes 为根到 x 的点权异或和的二进制中的 1 的个数的奇偶性
    // 返回从 x 到其后代的最小边权和（按照 pOnes 的奇偶性分别计算）
    private long[] dfs(int x, int fa, int pOnes, List<int[]>[] g, int[] values) {
        int pVal = Integer.bitCount(values[x]) % 2;
        pOnes ^= pVal;
        long[] minSum = {INF, INF};
        minSum[pOnes] = 0; // x 作为路径的端点

        for (int[] e : g[x]) {
            int y = e[0], c = e[1];
            if (y == fa) {
                continue;
            }
            long[] mn = dfs(y, x, pOnes, g, values);
            mn[0] += c;
            mn[1] += c;
            // 现在 mn 是从 x 到子树 y 中节点的最小边权和
            // 拼接从 x 到两棵子树中的路径（拼接后，路径在 x 拐弯）
            ans = Math.min(ans, Math.min(minSum[0] + mn[pVal], minSum[1] + mn[pVal ^ 1]));
            minSum[0] = Math.min(minSum[0], mn[0]);
            minSum[1] = Math.min(minSum[1], mn[1]);
        }

        return minSum;
    }
}
/*
4100. 平衡异或路径的最小开销
https://leetcode.cn/problems/minimum-cost-path-with-even-xor-parity/description/

第 526 场周赛 T4。

给你一棵含有 n 个节点的树，节点编号从 0 到 n - 1，用一个二维整数数组 edges 表示。edges[i] = [ui, vi, ci] 表示节点 ui 和 vi 之间的一条边，其开销为 ci。
同时给你一个长度为 n 的整数数组 values，其中 values[i] 是节点 i 的值。
如果两个 不同 节点之间的路径上所有节点（包括两个端点）的值的按位异或结果在二进制表示中含有 偶数 个置位，则称该路径为 平衡异或 路径。
一条路径的 开销 是其所有边开销的总和。
返回一条平衡异或路径的 最小开销 。如果不存在这样的路径，返回 -1。
置位 是指一个数字的二进制表示中值为 1 的位。数字 0 含有零个置位。
示例 1：
输入： edges = [[0,1,4],[0,2,6],[0,3,3],[3,4,5]], values = [3,1,7,1,3]
输出： 7
示例 2：
输入： edges = [[0,1,5],[1,2,10]], values = [1,7,3]
输出： 5
示例 3：
输入： edges = [[0,1,5],[0,2,7],[0,3,9]], values = [1,3,5,9]
输出： -1
提示：
2 <= n <= 10^5
edges.length == n - 1
edges[i] = [ui, vi, ci]
0 <= ui, vi <= n - 1
1 <= ci <= 10^9
values.length == n
1 <= values[i] <= 10^9
edges 表示一棵合法的树。

位运算恒等式 + 树形DP/脑筋急转弯
https://leetcode.cn/problems/minimum-cost-path-with-even-xor-parity/solutions/4051727/wei-yun-suan-heng-deng-shi-pin-jie-lu-ji-i2he/
 */