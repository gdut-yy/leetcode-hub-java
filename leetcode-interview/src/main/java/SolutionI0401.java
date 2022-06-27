import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class SolutionI0401 {
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        Map<Integer, Set<Integer>> outGraph = new HashMap<>();
        for (int[] edge : graph) {
            Set<Integer> outSet = outGraph.getOrDefault(edge[0], new HashSet<>());
            outSet.add(edge[1]);
            outGraph.put(edge[0], outSet);
        }

        // BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        boolean[] visited = new boolean[n];
        visited[start] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.remove();
                if (cur == target) {
                    return true;
                }
                for (int next : outGraph.getOrDefault(cur, new HashSet<>())) {
                    if (!visited[next]) {
                        queue.add(next);
                        visited[next] = true;
                    }
                }
            }
        }
        return false;
    }
}
/*
面试题 04.01. 节点间通路
https://leetcode.cn/problems/route-between-nodes-lcci/

节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。
提示：
节点数量n在[0, 1e5]范围内。
节点编号大于等于 0 小于 n。
图中可能存在自环和平行边。

BFS。
 */