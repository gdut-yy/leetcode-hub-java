import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution2192 {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        // 预处理
        Map<Integer, Set<Integer>> outGraph = new HashMap<>();
        Map<Integer, Set<Integer>> inGraph = new HashMap<>();
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            Set<Integer> outSet = outGraph.getOrDefault(from, new HashSet<>());
            outSet.add(to);
            outGraph.put(from, outSet);

            Set<Integer> inSet = inGraph.getOrDefault(to, new HashSet<>());
            inSet.add(from);
            inGraph.put(to, inSet);
        }

        Map<Integer, Set<Integer>> nodeMap = new HashMap<>();
        // 入度为 0 进队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inGraph.getOrDefault(i, new HashSet<>()).size() == 0) {
                queue.add(i);
                nodeMap.put(i, new HashSet<>());
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.remove();

                for (int next : outGraph.getOrDefault(cur, new HashSet<>())) {
                    inGraph.get(next).remove(cur);

                    Set<Integer> parents = nodeMap.getOrDefault(next, new HashSet<>());
                    parents.add(cur);
                    parents.addAll(nodeMap.getOrDefault(cur, new HashSet<>()));
                    nodeMap.put(next, parents);

                    if (inGraph.get(next).size() == 0) {
                        queue.add(next);
                    }
                }
            }
        }

        // DFS
        List<List<Integer>> resList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Set<Integer> parentSet = nodeMap.get(i);
            List<Integer> parentList = new ArrayList<>(parentSet);
            Collections.sort(parentList);
            resList.add(parentList);
        }
        return resList;
    }
}
/*
2192. 有向无环图中一个节点的所有祖先
https://leetcode.cn/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph/

第 73 场双周赛 T3。

给你一个正整数 n ，它表示一个 有向无环图 中节点的数目，节点编号为 0 到 n - 1 （包括两者）。
给你一个二维整数数组 edges ，其中 edges[i] = [fromi, toi] 表示图中一条从 fromi 到 toi 的单向边。
请你返回一个数组 answer，其中 answer[i]是第 i 个节点的所有 祖先 ，这些祖先节点 升序 排序。
如果 u 通过一系列边，能够到达 v ，那么我们称节点 u 是节点 v 的 祖先 节点。
提示：
1 <= n <= 1000
0 <= edges.length <= min(2000, n * (n - 1) / 2)
edges[i].length == 2
0 <= fromi, toi <= n - 1
fromi != toi
图中不会有重边。
图是 有向 且 无环 的。

逐个点 DFS 会 TLE（深度过大），需要进行记忆化，每次处理本层与上一层的关系即可。类似拓扑排序。
 */