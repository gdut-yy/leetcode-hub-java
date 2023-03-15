import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Cmbchina220410T2 {
    public int numFlowers(int[][] roads) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        Set<Integer> nodeSet = new HashSet<>();
        for (int[] road : roads) {
            int from = road[0];
            int to = road[1];
            nodeSet.add(from);
            nodeSet.add(to);

            graph.computeIfAbsent(from, key -> new HashSet<>()).add(to);
            graph.computeIfAbsent(to, key -> new HashSet<>()).add(from);
        }

        int max = 0;
        for (Integer integer : nodeSet) {
            int size = graph.get(integer).size();
            max = Math.max(max, size + 1);
        }
        return max;
    }
}
/*
招商银行-02. 公园规划
https://leetcode.cn/contest/cmbchina-2022spring/problems/ReWLAw/

公园规划小组为了让公园景观层次丰富，决定按以下方案对各花坛内的植物进行统一规划：
- 一条小路两端的花坛不能栽种同一种花
- 与同一花坛相连的两个花坛也不能栽种同一种花。
已知公园内有编号为 0 ~ num-1的若干花坛，任意两个花坛均可通过小路直接或间接到达。
公园中共有 num-1 条双向小路连接花坛，roads[i] = [x, y] 表示花坛 x 和花坛 y 之间存在小路将二者相连。
请返回这些花坛最少需要几种花。
示例 1：
输入：roads = [[0,1],[1,3],[1,2]]
输出：4
解释：4 个花坛中编号为 1 的花坛与其余花坛均相连，因此至少需要栽种 4 种的花。
示例 2：
输入：roads = [[0,1],[0,2],[1,3],[2,5],[3,6],[5,4]]
输出：3
提示：
1 <= roads.length <= 10^5
0 <= roads[i][0],roads[i][1] <= roads.length
 */