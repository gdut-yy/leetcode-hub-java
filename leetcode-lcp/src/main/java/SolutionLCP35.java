import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class SolutionLCP35 {
    // https://leetcode.cn/problems/DFPeFJ/solution/dijkstrasuan-fa-qiu-zui-duan-lu-jing-by-usiix/
    // https://leetcode.cn/problems/DFPeFJ/solution/java-dijkstra-by-feilue-8p14/
    public int electricCarPlan(int[][] paths, int cnt, int start, int end, int[] charge) {
        int n = charge.length;

        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] path : paths) {
            adj.computeIfAbsent(path[0], key -> new ArrayList<>()).add(new int[]{path[1], path[2]});
            adj.computeIfAbsent(path[1], key -> new ArrayList<>()).add(new int[]{path[0], path[2]});
        }

        int[][] res = new int[n][cnt + 1];
        for (int[] i : res) {
            Arrays.fill(i, Integer.MAX_VALUE / 2);
        }
        res[start][0] = 0;

        // TODO
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));
        priorityQueue.offer(new int[]{0, start, 0});

        while (!priorityQueue.isEmpty()) {
            int[] tuple = priorityQueue.remove();
            int time = tuple[0];
            int cur = tuple[1];
            int power = tuple[2];
            if (time > res[cur][power]) {
                continue;
            }
            if (cur == end) {
                return time;
            }

            if (power < cnt) {
                int t = time + charge[cur];
                if (t < res[cur][power + 1]) {
                    res[cur][power + 1] = t;
                    priorityQueue.add(new int[]{t, cur, power + 1});
                }
            }

            for (int[] path : adj.getOrDefault(cur, new ArrayList<>())) {
                int next = path[0];
                int cost = path[1];
                int t = time + cost;
                int p = power - cost;
                if (p >= 0 && t < res[next][p]) {
                    res[next][p] = t;
                    priorityQueue.add(new int[]{t, next, p});
                }
            }
        }

        return -1;
    }

}
/*
LCP 35. 电动车游城市
https://leetcode.cn/problems/DFPeFJ/

小明的电动车电量充满时可行驶距离为 cnt，每行驶 1 单位距离消耗 1 单位电量，且花费 1 单位时间。小明想选择电动车作为代步工具。
地图上共有 N 个景点，景点编号为 0 ~ N-1。他将地图信息以 [城市 A 编号,城市 B 编号,两城市间距离] 格式整理在在二维数组 paths，表示城市 A、B 间存在双向通路。
初始状态，电动车电量为 0。每个城市都设有充电桩，charge[i] 表示第 i 个城市每充 1 单位电量需要花费的单位时间。请返回小明最少需要花费多少单位时间从起点城市 start 抵达终点城市 end。
提示：
1 <= paths.length <= 200
paths[i].length == 3
2 <= charge.length == n <= 100
0 <= path[i][0],path[i][1],start,end < n
1 <= cnt <= 100
1 <= path[i][2] <= cnt
1 <= charge[i] <= 100
题目保证所有城市相互可以到达
 */