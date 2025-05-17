import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3544 {
    private List<Integer>[] g;
    private int[] nums;
    private int k;
    private long[][][] memo;

    public long subtreeInversionSum(int[][] edges, int[] nums, int k) {
        int n = nums.length;
        this.nums = nums;
        this.k = k;
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        memo = new long[n][k + 1][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k + 1; j++) {
                memo[i][j][0] = Long.MIN_VALUE;
                memo[i][j][1] = Long.MAX_VALUE;
            }
        }
        return dfs(0, -1, k)[0];
    }

    private long[] dfs(int x, int fa, int d) {
        long mx = nums[x], mn = nums[x];
        if (memo[x][d][0] != Long.MIN_VALUE) return memo[x][d];
        for (Integer y : g[x]) {
            if (y == fa) continue;
            long[] sub = dfs(y, x, Math.min(d + 1, k));
            mx += sub[0];
            mn += sub[1];
        }
        if (d >= k) {
            long mx2 = -nums[x], mn2 = -nums[x];
            for (Integer y : g[x]) {
                if (y == fa) continue;
                long[] sub = dfs(y, x, 1);
                mx2 -= sub[1];
                mn2 -= sub[0];
            }
            mx = Math.max(mx, mx2);
            mn = Math.min(mn, mn2);
        }
        return memo[x][d] = new long[]{mx, mn};
    }
}
/*
3544. 子树反转和
https://leetcode.cn/problems/subtree-inversion-sum/description/

第 156 场双周赛 T4。

给你一棵以节点 0 为根节点包含 n 个节点的无向树，节点编号从 0 到 n - 1。该树由长度为 n - 1 的二维整数数组 edges 表示，其中 edges[i] = [ui, vi] 表示节点 ui 和 vi 之间有一条边。
同时给你一个整数 k 和长度为 n 的整数数组 nums，其中 nums[i] 表示节点 i 的值。
你可以对部分节点执行 反转操作 ，该操作需满足以下条件：
- 子树反转操作：
  - 当你反转一个节点时，以该节点为根的子树中所有节点的值都乘以 -1。
- 反转之间的距离限制：
  - 你只能在一个节点与其他已反转节点“足够远”的情况下反转它。
  - 具体而言，如果你反转两个节点 a 和 b，并且其中一个是另一个的祖先（即 LCA(a, b) = a 或 LCA(a, b) = b），那么它们之间的距离（它们之间路径上的边数）必须至少为 k。
返回应用 反转操作 后树上节点值的 最大可能 总和 。
在一棵有根树中，某个节点 v 的子树是指所有路径到根节点包含 v 的节点集合。
提示:
2 <= n <= 5 * 10^4
edges.length == n - 1
edges[i] = [ui, vi]
0 <= ui, vi < n
nums.length == n
-5 * 10^4 <= nums[i] <= 5 * 10^4
1 <= k <= 50
输入保证 edges 表示的是一棵合法的树。

树形 DP
时间复杂度 O(nk)。
有 O(n) 的做法。
rating 2551 (clist.by)
 */