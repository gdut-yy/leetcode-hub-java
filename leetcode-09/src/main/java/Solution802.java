import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution802 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        // 拓扑排序
        Map<Integer, Set<Integer>> outGraph = new HashMap<>();
        Map<Integer, Set<Integer>> inGraph = new HashMap<>();
        // 该有向图有 n 个节点，按 0 到 n - 1 编号
        int n = graph.length;
        for (int i = 0; i < n; i++) {
            int[] edges = graph[i];
            for (int cur : edges) {
                Set<Integer> outSet = outGraph.getOrDefault(i, new HashSet<>());
                outSet.add(cur);
                outGraph.put(i, outSet);

                Set<Integer> inSet = inGraph.getOrDefault(cur, new HashSet<>());
                inSet.add(i);
                inGraph.put(cur, inSet);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        // 出度为 0 是安全的
        for (int i = 0; i < n; i++) {
            if (outGraph.getOrDefault(i, new HashSet<>()).size() == 0) {
                queue.add(i);
            }
        }
        List<Integer> resList = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.remove();
                resList.add(cur);
                for (int pre : inGraph.getOrDefault(cur, new HashSet<>())) {
                    outGraph.get(pre).remove(cur);
                    if (outGraph.get(pre).size() == 0) {
                        queue.add(pre);
                    }
                }
            }
        }
        Collections.sort(resList);
        return resList;
    }
}
/*
802. 找到最终的安全状态
https://leetcode-cn.com/problems/find-eventual-safe-states/

在有向图中，以某个节点为起始节点，从该点出发，每一步沿着图中的一条有向边行走。如果到达的节点是终点（即它没有连出的有向边），则停止。
对于一个起始节点，如果从该节点出发，无论每一步选择沿哪条有向边行走，最后必然在有限步内到达终点，则将该起始节点称作是 安全 的。
返回一个由图中所有安全的起始节点组成的数组作为答案。答案数组中的元素应当按 升序 排列。
该有向图有 n 个节点，按 0 到 n - 1 编号，其中 n 是 graph 的节点数。图以下述形式给出：graph[i] 是编号 j 节点的一个列表，满足 (i, j) 是图的一条有向边。
提示：
n == graph.length
1 <= n <= 10^4
0 <= graph[i].length <= n
graph[i] 按严格递增顺序排列。
图中可能包含自环。
图中边的数目在范围 [1, 4 * 10^4] 内。

拓扑排序。
显然出度为 0 的点是安全的，每次入队出度为 0 的点。
 */