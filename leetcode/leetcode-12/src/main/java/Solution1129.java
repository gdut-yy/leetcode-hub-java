import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution1129 {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        // 预处理 图
        Map<Integer, Set<Integer>> redGraph = new HashMap<>();
        Map<Integer, Set<Integer>> blueGraph = new HashMap<>();
        for (int[] redEdge : redEdges) {
            Set<Integer> outSet = redGraph.getOrDefault(redEdge[0], new HashSet<>());
            outSet.add(redEdge[1]);
            redGraph.put(redEdge[0], outSet);
        }
        for (int[] blueEdge : blueEdges) {
            Set<Integer> outSet = blueGraph.getOrDefault(blueEdge[0], new HashSet<>());
            outSet.add(blueEdge[1]);
            blueGraph.put(blueEdge[0], outSet);
        }

        // BFS
        Queue<int[]> queue = new LinkedList<>();
        // 0:红色 1:蓝色
        queue.add(new int[]{0, 0});
        queue.add(new int[]{0, 1});

        boolean[] redVisited = new boolean[n];
        boolean[] blueVisited = new boolean[n];

        int[] res = new int[n];
        Arrays.fill(res, -1);
        res[0] = 0;
        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            distance++;

            for (int i = 0; i < size; i++) {
                int[] cur = queue.remove();
                int node = cur[0];
                int color = cur[1];

                if (color == 0) {
                    for (int next : blueGraph.getOrDefault(node, new HashSet<>())) {
                        if (blueVisited[next]) {
                            continue;
                        }
                        blueVisited[next] = true;
                        if (res[next] == -1) {
                            res[next] = distance;
                        }
                        queue.add(new int[]{next, 1});
                    }
                } else {
                    for (int next : redGraph.getOrDefault(node, new HashSet<>())) {
                        if (redVisited[next]) {
                            continue;
                        }
                        redVisited[next] = true;
                        if (res[next] == -1) {
                            res[next] = distance;
                        }
                        queue.add(new int[]{next, 0});
                    }
                }
            }
        }
        return res;
    }
}
/*
1129. 颜色交替的最短路径
https://leetcode.cn/problems/shortest-path-with-alternating-colors/

在一个有向图中，节点分别标记为 0, 1, ..., n-1。图中每条边为红色或者蓝色，且存在自环或平行边。
red_edges 中的每一个 [i, j] 对表示从节点 i 到节点 j 的红色有向边。类似地，blue_edges 中的每一个 [i, j] 对表示从节点 i 到节点 j 的蓝色有向边。
返回长度为 n 的数组 answer，其中 answer[X] 是从节点 0 到节点 X 的红色边和蓝色边交替出现的最短路径的长度。如果不存在这样的路径，那么 answer[x] = -1。
提示：
1 <= n <= 100
red_edges.length <= 400
blue_edges.length <= 400
red_edges[i].length == blue_edges[i].length == 2
0 <= red_edges[i][j], blue_edges[i][j] < n

最短路首先想到 BFS，本题限制条件是颜色交替，模拟完事。
 */