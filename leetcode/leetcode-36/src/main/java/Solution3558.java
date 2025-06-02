import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3558 {
    private List<Integer>[] g;

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;
        g = new ArrayList[n + 1];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] e : edges) {
            int x = e[0], y = e[1];
            g[x].add(y);
            g[y].add(x);
        }
        int k = dfs(1, 0);
        return (int) quickPow(2, k - 1);
    }

    private int dfs(int x, int fa) {
        int d = 0;
        for (int y : g[x]) {
            if (y != fa) { // 不递归到父节点
                d = Math.max(d, dfs(y, x) + 1);
            }
        }
        return d;
    }

    static final int MOD = (int) (1e9 + 7);

    // 快速幂 res = a^b % mod
    private long quickPow(long a, long b) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) != 0) res = res * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }
}
/*
3558. 给边赋权值的方案数 I
https://leetcode.cn/problems/number-of-ways-to-assign-edge-weights-i/description/

第 157 场双周赛 T3。

给你一棵 n 个节点的无向树，节点从 1 到 n 编号，树以节点 1 为根。树由一个长度为 n - 1 的二维整数数组 edges 表示，其中 edges[i] = [ui, vi] 表示在节点 ui 和 vi 之间有一条边。
一开始，所有边的权重为 0。你可以将每条边的权重设为 1 或 2。
两个节点 u 和 v 之间路径的 代价 是连接它们路径上所有边的权重之和。
选择任意一个 深度最大 的节点 x。返回从节点 1 到 x 的路径中，边权重之和为 奇数 的赋值方式数量。
由于答案可能很大，返回它对 10^9 + 7 取模的结果。
注意： 忽略从节点 1 到节点 x 的路径外的所有边。
提示：
2 <= n <= 10^5
edges.length == n - 1
edges[i] == [ui, vi]
1 <= ui, vi <= n
edges 表示一棵合法的树。

从 k 个数中选奇数个数的方案数。
答案为 2^{k-1} % mod。
相似题目: 3559. 给边赋权值的方案数 II
https://leetcode.cn/problems/number-of-ways-to-assign-edge-weights-ii/description/
 */