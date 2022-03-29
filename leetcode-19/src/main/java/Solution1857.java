import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution1857 {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();

        // 拓扑排序
        Map<Integer, Set<Integer>> inGraph = new HashMap<>();
        Map<Integer, Set<Integer>> outGraph = new HashMap<>();
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            Set<Integer> inSet = inGraph.getOrDefault(to, new HashSet<>());
            inSet.add(from);
            inGraph.put(to, inSet);

            Set<Integer> outSet = outGraph.getOrDefault(from, new HashSet<>());
            outSet.add(to);
            outGraph.put(from, outSet);
        }

        // 入度为 0 进队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inGraph.getOrDefault(i, new HashSet<>()).size() == 0) {
                queue.add(i);
            }
        }
        int cnt = 0;
        // 动态规划
        int[][] dp = new int[n][26];
        while (!queue.isEmpty()) {
            cnt++;
            int cur = queue.remove();

            dp[cur][colors.charAt(cur) - 'a'] += 1;
            for (int next : outGraph.getOrDefault(cur, new HashSet<>())) {
                inGraph.get(next).remove(cur);
                for (int ch = 0; ch < 26; ch++) {
                    dp[next][ch] = Math.max(dp[next][ch], dp[cur][ch]);
                }
                if (inGraph.getOrDefault(next, new HashSet<>()).size() == 0) {
                    queue.add(next);
                }
            }
        }

        // 如果 cnt 不等于 n，说明图中存在环
        if (cnt != n) {
            return -1;
        }

        // 求 最大值
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int c = 0; c < 26; c++) {
                max = Math.max(max, dp[i][c]);
            }
        }
        return max;
    }
}
/*
1857. 有向图中最大颜色值
https://leetcode-cn.com/problems/largest-color-value-in-a-directed-graph/

给你一个 有向图 ，它含有 n 个节点和 m 条边。节点编号从 0 到 n - 1 。
给你一个字符串 colors ，其中 colors[i] 是小写英文字母，表示图中第 i 个节点的 颜色 （下标从 0 开始）。
同时给你一个二维数组 edges ，其中 edges[j] = [aj, bj] 表示从节点 aj 到节点 bj 有一条 有向边 。
图中一条有效 路径 是一个点序列 x1 -> x2 -> x3 -> ... -> xk ，对于所有 1 <= i < k ，从 xi 到 xi+1 在图中有一条有向边。
路径的 颜色值 是路径中 出现次数最多 颜色的节点数目。
请你返回给定图中有效路径里面的 最大颜色值 。如果图中含有环，请返回 -1 。
提示：
n == colors.length
m == edges.length
1 <= n <= 10^5
0 <= m <= 10^5
colors 只含有小写英文字母。
0 <= aj, bj < n

拓扑排序 + 动态规划。
 */