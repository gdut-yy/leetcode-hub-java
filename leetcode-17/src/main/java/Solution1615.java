import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution1615 {
    public int maximalNetworkRank(int n, int[][] roads) {
        // 预处理
        Map<Integer, Set<String>> graph = new HashMap<>();
        for (int[] road : roads) {
            int from = road[0];
            int to = road[1];
            String roadStr = from + ":" + to;

            Set<String> outSet = graph.getOrDefault(from, new HashSet<>());
            outSet.add(roadStr);
            graph.put(from, outSet);

            Set<String> inSet = graph.getOrDefault(to, new HashSet<>());
            inSet.add(roadStr);
            graph.put(to, inSet);
        }

        // 枚举
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 副本
                Set<String> set1 = new HashSet<>(graph.getOrDefault(i, new HashSet<>()));
                Set<String> set2 = graph.getOrDefault(j, new HashSet<>());
                set1.addAll(set2);
                max = Math.max(max, set1.size());
            }
        }
        return max;
    }
}
/*
1615. 最大网络秩
https://leetcode-cn.com/problems/maximal-network-rank/

n 座城市和一些连接这些城市的道路 roads 共同组成一个基础设施网络。每个 roads[i] = [ai, bi] 都表示在城市 ai 和 bi 之间有一条双向道路。
两座不同城市构成的 城市对 的 网络秩 定义为：与这两座城市 直接 相连的道路总数。如果存在一条道路直接连接这两座城市，则这条道路只计算 一次 。
整个基础设施网络的 最大网络秩 是所有不同城市对中的 最大网络秩 。
给你整数 n 和数组 roads，返回整个基础设施网络的 最大网络秩 。
提示：
2 <= n <= 100
0 <= roads.length <= n * (n - 1) / 2
roads[i].length == 2
0 <= ai, bi <= n-1
ai != bi
每对城市之间 最多只有一条 道路相连

建图后枚举。
 */