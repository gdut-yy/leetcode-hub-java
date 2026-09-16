import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution4015 {
    public long weightedSum(int[] parent, int[] nums) {
        int n = parent.length;
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 1; i < n; i++) {
            g[parent[i]].add(i);
        }
        int[] depth = new int[n];
        int h = dfs(0, g, depth);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += (long) nums[i] * (h - depth[i]);
        }
        return ans;
    }

    private int dfs(int x, List<Integer>[] g, int[] depth) {
        int h = 0;
        for (int y : g[x]) {
            depth[y] = depth[x] + 1;
            h = Math.max(h, dfs(y, g, depth));
        }
        return h + 1;
    }
}
/*
4015. 树的加权和
https://leetcode.cn/problems/weighted-sum-of-a-tree/description/

第 514 场周赛 T2。

给你一个长度为 n 的整数数组 parent，它表示一棵根节点编号为 0、节点编号范围为 0 到 n - 1 的有根树。
该树以节点 0 为 根节点，因此 parent[0] = -1。对于每个满足 1 <= i <= n - 1 的节点 i，parent[i] 表示节点 i 的父节点。
另给定一个长度为 n 的整数数组 nums，其中 nums[i] 表示节点 i 的值。
对于深度为 d 的节点 i，其 权重 定义为 nums[i] * (h - d + 1)，其中 h 表示树的高度。
返回树中所有节点的 权重之和 。
节点的 深度 定义为从根节点到该节点的路径上包含的节点数量，其中根节点的深度为 1。
树的 高度 定义为所有节点深度的最大值。
提示：
1 <= n <= 10^5
n == parent.length == nums.length
parent[0] == -1
对于所有 i，其中 i 位于 [1, n - 1]，均有 0 <= parent[i] <= n - 1
1 <= nums[i] <= 10^6
保证输入数组 parent 表示一棵以节点 0 为根节点的有效树。

一次 DFS。先求出每个节点的深度，保存到数组 depth 中。第二次 DFS 可以用简单的循环代替。
时间复杂度 O(n)。
 */