import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return List.of(0);
        }
        // 无向图
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int pre = edge[0];
            int cur = edge[1];

            Set<Integer> outSet = graph.getOrDefault(pre, new HashSet<>());
            outSet.add(cur);
            graph.put(pre, outSet);

            Set<Integer> inSet = graph.getOrDefault(cur, new HashSet<>());
            inSet.add(pre);
            graph.put(cur, inSet);
        }

        // 度为 1 进队列
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        // n 个节点的树，标记为 0 到 n - 1
        for (int i = 0; i < n; i++) {
            if (graph.getOrDefault(i, new HashSet<>()).size() == 1) {
                queue.add(i);
                visited[i] = true;
            }
        }
        List<Integer> resList = new ArrayList<>();
        while (!queue.isEmpty()) {
            resList.clear();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.remove();
                resList.add(cur);
                for (int next : graph.getOrDefault(cur, new HashSet<>())) {
                    graph.get(next).remove(cur);
                    if (!visited[next] && graph.get(next).size() == 1) {
                        visited[next] = true;
                        queue.add(next);
                    }
                }
            }
        }
        return resList;
    }
}
/*
310. 最小高度树
https://leetcode-cn.com/problems/minimum-height-trees/

树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，一个任何没有简单环路的连通图都是一棵树。
给你一棵包含 n 个节点的树，标记为 0 到 n - 1 。给定数字 n 和一个有 n - 1 条无向边的 edges 列表（每一个边都是一对标签），
其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条无向边。
可选择树中任何一个节点作为根。当选择节点 x 作为根节点时，设结果树的高度为 h 。在所有可能的树中，具有最小高度的树（即，min(h)）被称为 最小高度树 。
请你找到所有的 最小高度树 并按 任意顺序 返回它们的根节点标签列表。
树的 高度 是指根节点和叶子节点之间最长向下路径上边的数量。
提示：
1 <= n <= 2 * 10^4
edges.length == n - 1
0 <= ai, bi < n
ai != bi
所有 (ai, bi) 互不相同
给定的输入 保证 是一棵树，并且 不会有重复的边

拓扑排序。
每次去掉度为 1 的顶点。保留最内层。
 */