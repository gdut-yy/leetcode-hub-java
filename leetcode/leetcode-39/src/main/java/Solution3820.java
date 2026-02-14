import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Solution3820 {
    public int specialNodes(int n, int[][] edges, int x, int y, int z) {
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        int[] distX = bfs(g, x, n);
        int[] distY = bfs(g, y, n);
        int[] distZ = bfs(g, z, n);

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int a = distX[i], b = distY[i], c = distZ[i];
            int[] arr = {a, b, c};
            Arrays.sort(arr);
            if (arr[0] * arr[0] + arr[1] * arr[1] == arr[2] * arr[2]) {
                ans++;
            }
        }
        return ans;
    }

    private int[] bfs(List<Integer>[] g, int start, int n) {
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new ArrayDeque<>();
        dist[start] = 0;
        q.offer(start);
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : g[u]) {
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    q.offer(v);
                }
            }
        }
        return dist;
    }
}
/*
3820. 树上的勾股距离节点
https://leetcode.cn/problems/pythagorean-distance-nodes-in-a-tree/description/

第 486 场周赛 T3。

给你一个整数 n 和一棵包含 n 个节点的无向树，节点编号从 0 到 n - 1。该树由一个长度为 n - 1 的二维数组 edges 表示，其中 edges[i] = [ui, vi] 表示 ui 和 vi 之间存在一条无向边。
另给你三个 互不相同 的目标节点 x、y 和 z。
对于树中的任意节点 u：
- 令 dx 为 u 到节点 x 的距离
- 令 dy 为 u 到节点 y 的距离
- 令 dz 为 u 到节点 z 的距离
如果这三个距离形成一个 勾股数元组 ，则称节点 u 为 特殊 节点。
返回一个整数，表示树中特殊节点的数量。
勾股数元组 由三个整数 a、b 和 c 组成，当它们按 升序 排列时，满足 a^2 + b^2 = c^2。
树中两个节点之间的 距离 是它们之间唯一路径上的边数。
提示：
4 <= n <= 10^5
edges.length == n - 1
edges[i] = [ui, vi]
0 <= ui, vi, x, y, z <= n - 1
x, y 和 z 互不相同。
输入生成的 edges 表示一棵有效的树。

跑三次 BFS。
时间复杂度 O(n)。
 */