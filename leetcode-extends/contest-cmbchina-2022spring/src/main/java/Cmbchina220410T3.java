import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Cmbchina220410T3 {
    public int[] lightSticks(int height, int width, int[] indices) {
        // 端点总数
        int V = (height + 1) * (width + 1);
        // 取走的木棒编号
        Set<Integer> removed = new HashSet<>();
        for (int idx : indices) removed.add(idx);

        // 每层木棒数量：width 根水平 + (width+1) 根垂直 = 2*width+1
        int period = 2 * width + 1;
        // 木棒总数
        int totalSticks = (height + 1) * width + height * (width + 1);

        // 剩余木棒的边列表和邻接表
        List<int[]> edges = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // 遍历所有木棒编号，跳过被取走的
        for (int stick = 0; stick < totalSticks; stick++) {
            if (removed.contains(stick)) continue;

            int layer = stick / period;
            int eOrigin = stick % period;
            int v1, v2;

            if (eOrigin < width) {
                // 水平木棒：连接 (layer, eOrigin) 和 (layer, eOrigin+1)
                int r = layer;
                int c = eOrigin;
                v1 = r * (width + 1) + c;
                v2 = v1 + 1;
            } else {
                // 垂直木棒：连接 (layer, eOrigin-width) 和 (layer+1, eOrigin-width)
                int r = layer;
                int c = eOrigin - width;
                v1 = r * (width + 1) + c;
                v2 = v1 + (width + 1);
            }

            edges.add(new int[]{v1, v2});
            adj.get(v1).add(v2);
            adj.get(v2).add(v1);
        }

        // 如果没有剩余木棒，所有端点都满足
        if (edges.isEmpty()) {
            int[] ans = new int[V];
            for (int i = 0; i < V; i++) ans[i] = i;
            return ans;
        }

        // ---------- 连通性检查 ----------
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        int start = edges.get(0)[0];
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : adj.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.offer(v);
                }
            }
        }

        // 只要有一条剩余木棒的端点没被访问到，说明图不连通
        for (int[] e : edges) {
            if (!visited[e[0]] || !visited[e[1]]) {
                return new int[0];
            }
        }

        // ---------- 对每个连通分量内的端点做 BFS ----------
        int[] best = new int[V];                // 每个端点的最大 2*t
        Arrays.fill(best, Integer.MAX_VALUE);
        int minMax2t = Integer.MAX_VALUE;

        for (int s = 0; s < V; s++) {
            if (!visited[s]) continue;          // 不在木棒连通分量中，无法燃烧任何木棒

            // BFS 求最短距离
            int[] dist = new int[V];
            Arrays.fill(dist, -1);
            Queue<Integer> q = new LinkedList<>();
            dist[s] = 0;
            q.offer(s);

            while (!q.isEmpty()) {
                int u = q.poll();
                for (int v : adj.get(u)) {
                    if (dist[v] == -1) {
                        dist[v] = dist[u] + 1;
                        q.offer(v);
                    }
                }
            }

            // 计算该点燃方案下所有木棒燃尽时间的最大值（用 2*t 避免浮点）
            int max2t = 0;
            for (int[] e : edges) {
                int u = e[0], v = e[1];
                // 边 (u,v) 燃尽时间 t = (dist[u] + dist[v] + 1) / 2
                int t2 = dist[u] + dist[v] + 1;
                if (t2 > max2t) max2t = t2;
            }

            best[s] = max2t;
            if (max2t < minMax2t) minMax2t = max2t;
        }

        // ---------- 收集答案 ----------
        List<Integer> ansList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (visited[i] && best[i] == minMax2t) {
                ansList.add(i);
            }
        }

        int[] ans = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) ans[i] = ansList.get(i);
        return ans;
    }
}
/*
招商银行-03. 点燃木棒
https://leetcode.cn/contest/cmbchina-2022spring/problems/Dk2Ytp/

有一个的木棒摆成的长方形网格，各个木棒，各个端点按照如下左图所示的方式编号。
在其中取走部分木棒，取走的木棒的编号记录于整数数组 indices。取完之后木棒网格一种可能的形式例如上右图所示。在 0 时刻，在网格中点燃某个端点。
- 一根木棒的一端被点燃，或者其他木棒燃烧到了相邻接的端点，则自此端点开始向另一端均匀地燃烧。
- 每根木棒从一端均匀地燃烧到另一端花费时间 1。
给定网格的高 height、宽 width 以及 indices。请问在 0 时刻点燃哪一个端点，可以使得在最短的时间内全体木棒都燃尽。返回一个升序排序的数组记录所有满足要求的端点编号。如果不存在这样的端点，返回空数组。
注意：
输入用例保证，indices 中的木棒编号都是合法的。
示例 1：
输入：
height = 1, width = 2, indices = [3]
输出：[0,1,2,3,4,5]
解释：如图所示，点燃所有端点，燃尽时间均为 3。
示例 2：
输入：
height = 2, width = 2, indices = [2,5,6,7,8,10,11]
输出：[2]
解释：如下图所示。点燃端点 [2] 燃尽时间为 2，是最小燃尽时间。
示例 3：
输入：
height = 1, width = 1, indices = [0,3]
输出：[]
解释：点燃任何一个端点，都无法燃尽所有木棒。因此返回空数组。
提示：
1 <= height, width <= 50
0 <= indices.length <= (height+1)*width+height*(width+1)
indices 中的值两两不同
0 <= indices[i] < (height+1)*width+height*(width+1)
 */