import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution2097 {
    private Map<Integer, Queue<Integer>> outGraph;
    private List<int[]> resList;

    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, Integer> degreeMap = new HashMap<>();
        outGraph = new HashMap<>();
        for (int[] pair : pairs) {
            int pre = pair[0];
            int cur = pair[1];

            Queue<Integer> outQueue = outGraph.getOrDefault(pre, new LinkedList<>());
            outQueue.add(cur);
            outGraph.put(pre, outQueue);

            // 出度 -1 入度 +1
            degreeMap.put(pre, degreeMap.getOrDefault(pre, 0) - 1);
            degreeMap.put(cur, degreeMap.getOrDefault(cur, 0) + 1);
        }
        resList = new ArrayList<>();

        // 欧拉通路
        // 恰有一个顶点 出度 = 入度 + 1（起点） && 恰有一个顶点 入度 = 出度 + 1（终点）
        // dfs 起点
        for (Map.Entry<Integer, Integer> entry : degreeMap.entrySet()) {
            if (entry.getValue() == -1) {
                dfs(entry.getKey());
                Collections.reverse(resList);
                return resList.toArray(int[][]::new);
            }
        }

        // 欧拉回路
        // 每个顶点的入度和出度相同
        // dfs 任意点
        dfs(pairs[0][0]);
        Collections.reverse(resList);
        return resList.toArray(int[][]::new);
    }

    private void dfs(int cur) {
        // 当我们遍历完一个节点所连的所有节点后，我们才将该节点入队（即逆序入队）
        while (outGraph.containsKey(cur) && outGraph.get(cur).size() > 0) {
            int next = outGraph.get(cur).remove();
            dfs(next);
            resList.add(new int[]{cur, next});
        }
    }
}
/*
2097. 合法重新排列数对
https://leetcode.cn/problems/valid-arrangement-of-pairs/

第 270 场周赛 T4。

给你一个下标从 0 开始的二维整数数组 pairs ，其中 pairs[i] = [starti, endi] 。如果 pairs 的一个重新排列，
满足对每一个下标 i （ 1 <= i < pairs.length ）都有 endi-1 == starti ，那么我们就认为这个重新排列是 pairs 的一个 合法重新排列 。
请你返回 任意一个 pairs 的合法重新排列。
注意：数据保证至少存在一个 pairs 的合法重新排列。

Hierholzer 算法。
欧拉路径。“一笔画” 问题。
比赛时咋眼一看以为是 拓扑排序，然后发现示例 2 和示例 3 均有环路，人傻了。

相似题目: 332. 重新安排行程
https://leetcode.cn/problems/reconstruct-itinerary/
 */