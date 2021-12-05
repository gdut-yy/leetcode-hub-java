import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution815 {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        Map<Integer, List<Integer>> stopRoutesMap = buildStopRoutesMap(routes);

        // BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        boolean[] visited = new boolean[routes.length];
        int cnt = 0;
        while (!queue.isEmpty()) {
            cnt++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curStop = queue.remove();
                // 当前车站的线路集合
                List<Integer> routesList = stopRoutesMap.get(curStop);
                for (int route : routesList) {
                    if (!visited[route]) {
                        visited[route] = true;
                        // 当前线路的车站 1,2,7
                        int[] stops = routes[route];
                        for (int stop : stops) {
                            // 结束条件
                            if (stop == target) {
                                return cnt;
                            }
                            // 添加当前线路的 "换乘站"
                            if (stopRoutesMap.get(stop).size() > 1) {
                                queue.add(stop);
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }

    private Map<Integer, List<Integer>> buildStopRoutesMap(int[][] routes) {
        Map<Integer, List<Integer>> stopRoutesMap = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            int[] route = routes[i];
            for (int key : route) {
                List<Integer> list = stopRoutesMap.getOrDefault(key, new ArrayList<>());
                list.add(i);
                stopRoutesMap.put(key, list);
            }
        }
        return stopRoutesMap;
    }
}
/*
815. 公交路线
https://leetcode-cn.com/problems/bus-routes/

给你一个数组 routes ，表示一系列公交线路，其中每个 routes[i] 表示一条公交线路，第 i 辆公交车将会在上面循环行驶。
例如，路线 routes[0] = [1, 5, 7] 表示第 0 辆公交车会一直按序列 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... 这样的车站路线行驶。
现在从 source 车站出发（初始时不在公交车上），要前往 target 车站。 期间仅可乘坐公交车。
求出 最少乘坐的公交车数量 。如果不可能到达终点车站，返回 -1 。

routes[i] 中的所有值 互不相同
对于用例 routes = [[1,2,7],[3,6,7]]
构造 map 如下:
1-[0]
2-[0]
7-[0,1]
3-[1]
6-[1]
因 map.get(7).size > 1，因此 7 为换乘站。
对于每个 换乘站，添加进 queue 进行 BFS 即可。
 */