import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution2360 {
    public int longestCycle(int[] edges) {
        int n = edges.length;

        // 拓扑排序 分离出环
        int[] inDegrees = new int[n];
        for (int i = 0; i < n; i++) {
            if (edges[i] != -1) {
                inDegrees[edges[i]]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }
        // 环中的点
        Set<Integer> nodeSet = IntStream.range(0, n).boxed().collect(Collectors.toSet());
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.remove();
                nodeSet.remove(cur);

                int next = edges[cur];
                if (next != -1) {
                    inDegrees[next]--;
                    if (inDegrees[next] == 0) {
                        queue.add(next);
                    }
                }
            }
        }

        // 不存在环
        if (nodeSet.isEmpty()) {
            return -1;
        }

        // solution565
        int max = 0;
        boolean[] visited = new boolean[n];
        for (int i : nodeSet) {
            // 环长
            int cnt = 0;
            while (!visited[i]) {
                visited[i] = true;
                i = edges[i];
                cnt++;
            }
            max = Math.max(max, cnt);
        }
        return max;
    }
}
/*
2360. 图中的最长环
https://leetcode.cn/problems/longest-cycle-in-a-graph/

第 304 场周赛 T4。

给你一个 n 个节点的 有向图 ，节点编号为 0 到 n - 1 ，其中每个节点 至多 有一条出边。
图用一个大小为 n 下标从 0 开始的数组 edges 表示，节点 i 到节点 edges[i] 之间有一条有向边。如果节点 i 没有出边，那么 edges[i] == -1 。
请你返回图中的 最长 环，如果没有任何环，请返回 -1 。
一个环指的是起点和终点是 同一个 节点的路径。
提示：
n == edges.length
2 <= n <= 10^5
-1 <= edges[i] < n
edges[i] != i

基环树求最大环。先用 拓扑排序 分离出环。
相似题目: 565. 数组嵌套
https://leetcode.cn/problems/array-nesting/
 */