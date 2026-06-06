import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Solution3910 {
    public int evenSumSubgraphs(int[] nums, int[][] edges) {
        int n = nums.length;
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            g[u].add(v);
            g[v].add(u);
        }

        int total = 0;
        int allMasks = (1 << n) - 1;
        for (int mask = 1; mask <= allMasks; mask++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if ((mask >> i & 1) == 1) {
                    sum += nums[i];
                }
            }
            if (sum % 2 != 0) continue;

            int start = -1;
            for (int i = 0; i < n; i++) {
                if ((mask >> i & 1) == 1) {
                    start = i;
                    break;
                }
            }

            boolean[] vis = new boolean[n];
            Queue<Integer> q = new ArrayDeque<>();
            q.offer(start);
            vis[start] = true;
            int cnt = 1;
            while (!q.isEmpty()) {
                int u = q.poll();
                for (int v : g[u]) {
                    if (!vis[v] && ((mask >> v & 1) == 1)) {
                        vis[v] = true;
                        q.offer(v);
                        cnt++;
                    }
                }
            }
            if (cnt == Integer.bitCount(mask)) {
                total++;
            }
        }
        return total;
    }
}
/*
3910. 统计节点和为偶数的连通子图
https://leetcode.cn/problems/count-connected-subgraphs-with-even-node-sum/description/

第 181 场双周赛 T3。

给你一个无向图，有 n 个节点，编号从 0 到 n - 1。节点 i 的 值 为 nums[i]，可以是 0 或 1。图的边由一个二维数组 edges 给出，其中 edges[i] = [ui, vi] 表示节点 ui 和节点 vi 之间的一条边。
对于图中节点的 非空子集 s，我们考虑由 s 生成的 诱导子图 如下：
- 我们只保留 s 中的节点。
- 我们只保留两个端点都在 s 中的边。
返回一个整数，表示图中满足以下条件的节点的 非空 子集 s 的数量：
- s 的 诱导子图 是 连通的。
- s 中节点 值 的 总和 是 偶数。
提示：
1 <= n == nums.length <= 13
nums[i] 是 0 或 1。
0 <= edges.length <= n * (n - 1) / 2
edges[i] = [ui, vi]
0 <= ui < vi < n
所有边都是 互不相同 的。

枚举子集 + 位运算 BFS
https://chat.deepseek.com/a/chat/s/65ebb2c9-630a-4314-900a-96bb30020e01
 */