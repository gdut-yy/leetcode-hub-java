import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution2050 {
    public int minimumTime(int n, int[][] relations, int[] time) {
        // 拓扑排序
        Map<Integer, Set<Integer>> outGraph = new HashMap<>();
        Map<Integer, Set<Integer>> inGraph = new HashMap<>();
        // 二维整数数组 relations ，其中 relations[j] = [prevCoursej, nextCoursej] ，
        // 表示课程 prevCoursej 必须在课程 nextCoursej 之前 完成（先修课的关系）。
        // 入度数组
        int[] inDegrees = new int[n + 1];
        for (int[] relation : relations) {
            int pre = relation[0];
            int cur = relation[1];
            inDegrees[cur]++;

            Set<Integer> outSet = outGraph.getOrDefault(pre, new HashSet<>());
            outSet.add(cur);
            outGraph.put(pre, outSet);

            Set<Integer> inSet = inGraph.getOrDefault(cur, new HashSet<>());
            inSet.add(pre);
            inGraph.put(cur, inSet);
        }

        // 入度为 0 进队列
        Queue<Integer> queue = new LinkedList<>();
        // 有 n 节课，课程编号从 1 到 n
        for (int i = 1; i <= n; i++) {
            if (inGraph.getOrDefault(i, new HashSet<>()).size() == 0) {
                queue.add(i);
            }
        }
        // 动态规划 状态定义：
        // dp[i] 表示完成第 i 门课程需要花费的最少月份数
        int[] dp = new int[n + 1];

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.remove();
                // 状态转移
                // dp[i] = time[i-1] + max(dp[pre])
                int maxPre = 0;
                for (int pre : inGraph.getOrDefault(cur, new HashSet<>())) {
                    maxPre = Math.max(maxPre, dp[pre]);
                }
                dp[cur] = time[cur - 1] + maxPre;

                for (int next : outGraph.getOrDefault(cur, new HashSet<>())) {
                    inDegrees[next]--;
                    if (inDegrees[next] == 0) {
                        queue.add(next);
                    }
                }
            }
        }
        // 最少 月份数 max(dp[i])
        return Arrays.stream(dp).max().getAsInt();
    }
}
/*
2050. 并行课程 III
https://leetcode-cn.com/problems/parallel-courses-iii/

第 264 场周赛 T4。

给你一个整数 n ，表示有 n 节课，课程编号从 1 到 n 。同时给你一个二维整数数组 relations ，
其中 relations[j] = [prevCoursej, nextCoursej] ，表示课程 prevCoursej 必须在课程 nextCoursej 之前 完成（先修课的关系）。
同时给你一个下标从 0 开始的整数数组 time ，其中 time[i] 表示完成第 (i+1) 门课程需要花费的 月份 数。
请你根据以下规则算出完成所有课程所需要的 最少 月份数：
如果一门课的所有先修课都已经完成，你可以在 任意 时间开始这门课程。
你可以 同时 上 任意门课程 。
请你返回完成所有课程所需要的 最少 月份数。
注意：测试数据保证一定可以完成所有课程（也就是先修课的关系构成一个有向无环图）。

拓扑排序 + 动态规划。
值得一提的是，直接拓扑排序求各层最大值是不正确的，因为可以在 任意 时间开始这门课程。如 用例:
9
[[2,7],[2,6],[3,6],[4,6],[7,6],[2,1],[3,1],[4,1],[6,1],[7,1],[3,8],[5,8],[7,8],[1,9],[2,9],[6,9],[7,9]]
[9,5,9,5,8,7,7,8,4]
32
 */