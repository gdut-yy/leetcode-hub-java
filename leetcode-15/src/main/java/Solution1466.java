import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution1466 {
    public int minReorder(int n, int[][] connections) {
        // 无向图
        Map<Integer, Set<Integer>> unDirGraph = new HashMap<>();
        // 有向图
        Map<Integer, Set<Integer>> outGraph = new HashMap<>();
        for (int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];

            Set<Integer> outSet = unDirGraph.getOrDefault(from, new HashSet<>());
            outSet.add(to);
            unDirGraph.put(from, outSet);

            Set<Integer> inSet = unDirGraph.getOrDefault(to, new HashSet<>());
            inSet.add(from);
            unDirGraph.put(to, inSet);

            Set<Integer> outSet2 = outGraph.getOrDefault(from, new HashSet<>());
            outSet2.add(to);
            outGraph.put(from, outSet2);
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visitedSet = new HashSet<>();
        queue.add(0);
        visitedSet.add(0);

        // BFS
        int cnt = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.remove();

                for (int next : unDirGraph.getOrDefault(cur, new HashSet<>())) {
                    if (!visitedSet.contains(next)) {
                        visitedSet.add(next);
                        if (!outGraph.getOrDefault(next, new HashSet<>()).contains(cur)) {
                            cnt++;
                        }
                        queue.add(next);
                    }
                }
            }
        }
        return cnt;
    }
}
/*
1466. 重新规划路线
https://leetcode-cn.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/

n 座城市，从 0 到 n-1 编号，其间共有 n-1 条路线。因此，要想在两座不同城市之间旅行只有唯一一条路线可供选择（路线网形成一颗树）。去年，交通运输部决定重新规划路线，以改变交通拥堵的状况。
路线用 connections 表示，其中 connections[i] = [a, b] 表示从城市 a 到 b 的一条有向路线。
今年，城市 0 将会举办一场大型比赛，很多游客都想前往城市 0 。
请你帮助重新规划路线方向，使每个城市都可以访问城市 0 。返回需要变更方向的最小路线数。
题目数据 保证 每个城市在重新规划路线方向后都能到达城市 0 。
提示：
2 <= n <= 5 * 10^4
connections.length == n-1
connections[i].length == 2
0 <= connections[i][0], connections[i][1] <= n-1
connections[i][0] != connections[i][1]

本题限制条件是 n-1 条路线，即在两座不同城市之间旅行只有唯一一条路线可供选择。形状类似链表。
因此复杂度大大降低。建图从 0 开始 BFS 计数需要逆向的边即可。
 */