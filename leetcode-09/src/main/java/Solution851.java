import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution851 {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        Map<Integer, Set<Integer>> outGraph = new HashMap<>();
        Map<Integer, Set<Integer>> inGraph = new HashMap<>();
        int n = quiet.length;
        // N 个人（编号为 0, 1, 2, ..., N-1）
        int[] inDegrees = new int[n];
        for (int[] edge : richer) {
            int pre = edge[0];
            int cur = edge[1];
            inDegrees[cur]++;
            // more => less
            Set<Integer> outSet = outGraph.getOrDefault(pre, new HashSet<>());
            outSet.add(cur);
            outGraph.put(pre, outSet);

            Set<Integer> inSet = inGraph.getOrDefault(cur, new HashSet<>());
            inSet.add(pre);
            inGraph.put(cur, inSet);
        }
        // answer[x] = y 的前提是，在所有拥有的钱不少于 person x 的人中，person y 是最安静的人
        int[] dp = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            dp[i] = i;
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.remove();
                // 状态转移
                for (int pre : inGraph.getOrDefault(cur, new HashSet<>())) {
                    if (quiet[dp[pre]] < quiet[dp[cur]]) {
                        dp[cur] = dp[pre];
                    }
                }

                for (int next : outGraph.getOrDefault(cur, new HashSet<>())) {
                    inDegrees[next]--;
                    if (inDegrees[next] == 0) {
                        queue.add(next);
                    }
                }
            }
        }
        return dp;
    }
}
/*
851. 喧闹和富有
https://leetcode-cn.com/problems/loud-and-rich/

第 88 场周赛 T3。

在一组 N 个人（编号为 0, 1, 2, ..., N-1）中，每个人都有不同数目的钱，以及不同程度的安静（quietness）。
为了方便起见，我们将编号为 x 的人简称为 "person x "。
如果能够肯定 person x 比 person y 更有钱的话，我们会说 richer[i] = [x, y] 。注意 richer 可能只是有效观察的一个子集。
另外，如果 person x 的安静程度为 q ，我们会说 quiet[x] = q 。
现在，返回答案 answer ，其中 answer[x] = y 的前提是，在所有拥有的钱不少于 person x 的人中，
person y 是最安静的人（也就是安静值 quiet[y] 最小的人）。

拓扑排序 + 动态规划。
相似题目: 2050. 并行课程 III
https://leetcode-cn.com/problems/parallel-courses-iii/
 */