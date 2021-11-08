import java.util.HashMap;
import java.util.Map;

public class Solution2065 {
    // dfs 全局变量
    private int[] values;
    private int maxTime;
    private Map<Integer, Map<Integer, Integer>> neighbour;

    // 合法路径的 最大 价值
    private int max;

    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        this.neighbour = new HashMap<>();
        for (int[] edge : edges) {
            Map<Integer, Integer> uvMap = neighbour.getOrDefault(edge[0], new HashMap<>());
            uvMap.put(edge[1], edge[2]);
            neighbour.put(edge[0], uvMap);

            Map<Integer, Integer> vuMap = neighbour.getOrDefault(edge[1], new HashMap<>());
            vuMap.put(edge[0], edge[2]);
            neighbour.put(edge[1], vuMap);
        }
        this.values = values;
        this.maxTime = maxTime;
        int[] visited = new int[values.length];
        dfs(0, visited, 0, 0);
        return max;
    }

    private void dfs(int curTime, int[] visited, int curValue, int idx) {
        // 花费的总时间 不超过 maxTime 秒
        if (curTime > maxTime) {
            return;
        }
        // 每个节点的价值 至多 算入价值总和中一次
        if (visited[idx] == 0) {
            curValue += values[idx];
        }
        visited[idx]++;

        if (idx == 0) {
            max = Math.max(max, curValue);
        }
        if (neighbour.containsKey(idx)) {
            Map<Integer, Integer> map = neighbour.get(idx);
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                dfs(curTime + entry.getValue(), visited, curValue, entry.getKey());
            }
        }
        visited[idx]--;
    }
}
/*
2065. 最大化一张图中的路径价值
https://leetcode-cn.com/problems/maximum-path-quality-of-a-graph/

第 266 场周赛 T4。

给你一张 无向 图，图中有 n 个节点，节点编号从 0 到 n - 1 （都包括）。同时给你一个下标从 0 开始的整数数组 values ，
其中 values[i] 是第 i 个节点的 价值 。同时给你一个下标从 0 开始的二维整数数组 edges ，
其中 edges[j] = [uj, vj, timej] 表示节点 uj 和 vj 之间有一条需要 timej 秒才能通过的无向边。最后，给你一个整数 maxTime 。
合法路径 指的是图中任意一条从节点 0 开始，最终回到节点 0 ，且花费的总时间 不超过 maxTime 秒的一条路径。
你可以访问一个节点任意次。一条合法路径的 价值 定义为路径中 不同节点 的价值 之和 （每个节点的价值 至多 算入价值总和中一次）。
请你返回一条合法路径的 最大 价值。
注意：每个节点 至多 有 四条 边与之相连。

提示：
n == values.length
1 <= n <= 1000
0 <= values[i] <= 10^8
0 <= edges.length <= 2000
edges[j].length == 3
0 <= uj < vj <= n - 1
10 <= timej, maxTime <= 100
[uj, vj] 所有节点对 互不相同 。
每个节点 至多有四条 边。
图可能不连通。

由于 10 <= timej, maxTime <= 100 且 每个节点 至多 有 四条 边与之相连
因此路径上的节点数不会超 10，至多 4 条边，即 数量级 4^10 <= 1,048,576
DFS 暴力搜索即可。
 */