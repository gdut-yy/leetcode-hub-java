import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SolutionLCP62 {
    public int transportationHub(int[][] path) {
        Set<Integer> points = new HashSet<>();
        Map<Integer, Integer> inDegrees = new HashMap<>();
        Map<Integer, Integer> outDegrees = new HashMap<>();
        for (int[] tuple : path) {
            int u = tuple[0];
            int v = tuple[1];
            // v入度+1 u出度+1
            inDegrees.put(v, inDegrees.getOrDefault(v, 0) + 1);
            outDegrees.put(u, outDegrees.getOrDefault(u, 0) + 1);
            points.add(u);
            points.add(v);
        }
        int size = points.size();
        for (int x : points) {
            if (inDegrees.getOrDefault(x, 0) == size - 1 && outDegrees.getOrDefault(x, 0) == 0) {
                return x;
            }
        }
        return -1;
    }
}
/*
LCP 62. 交通枢纽
https://leetcode.cn/problems/D9PW8w/

LCCUP 力扣杯 2022 秋季编程大赛个人赛 T2。

为了缓解「力扣嘉年华」期间的人流压力，组委会在活动期间开设了一些交通专线。path[i] = [a, b] 表示有一条从地点 a通往地点 b 的 单向 交通专线。
若存在一个地点，满足以下要求，我们则称之为 交通枢纽：
- 所有地点（除自身外）均有一条 单向 专线 直接 通往该地点；
- 该地点不存在任何 通往其他地点 的单向专线。
请返回交通专线的 交通枢纽。若不存在，则返回 -1。
注意：
- 对于任意一个地点，至少被一条专线连通。
提示：
1 <= path.length <= 1000
0 <= path[i][0], path[i][1] <= 1000
path[i][0] 与 path[i][1] 不相等

有向图统计出度入度
 */