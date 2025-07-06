public class Solution3608 {
    public int minTime(int n, int[][] edges, int k) {
        int maxTime = 0;
        for (int[] edge : edges) {
            if (edge[2] > maxTime) {
                maxTime = edge[2];
            }
        }

        int left = 0;
        int right = maxTime;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (check(mid, n, edges, k)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int mid, int n, int[][] edges, int k) {
        DSU dsu = new DSU(n);
        for (int[] edge : edges) {
            int time = edge[2];
            if (time > mid) {
                int u = edge[0], v = edge[1];
                dsu.union(u, v);
            }
        }
        return dsu.sz >= k;
    }

    static class DSU {
        int[] fa;
        int sz;

        public DSU(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) fa[i] = i;
            sz = n;
        }

        int find(int x) { // 查找
            return x == fa[x] ? fa[x] : (fa[x] = find(fa[x]));
        }

        void union(int p, int q) { // 合并
            p = find(p);
            q = find(q);
            if (p == q) return;
            fa[q] = p;
            sz--;
        }
    }
}
/*
3608. 包含 K 个连通分量需要的最小时间
https://leetcode.cn/problems/minimum-time-for-k-connected-components/description/

第 457 场周赛 T3。

给你一个整数 n，表示一个包含 n 个节点（从 0 到 n - 1 编号）的无向图。该图由一个二维数组 edges 表示，其中 edges[i] = [ui, vi, timei] 表示一条连接节点 ui 和节点 vi 的无向边，该边会在时间 timei 被移除。
同时，另给你一个整数 k。
最初，图可能是连通的，也可能是非连通的。你的任务是找到一个 最小 的时间 t，使得在移除所有满足条件 time <= t 的边之后，该图包含 至少 k 个连通分量。
返回这个 最小 时间 t。
连通分量 是图的一个子图，其中任意两个顶点之间都存在路径，且子图中的任意顶点均不与子图外的顶点共享边。
提示：
1 <= n <= 10^5
0 <= edges.length <= 10^5
edges[i] = [ui, vi, timei]
0 <= ui, vi < n
ui != vi
1 <= timei <= 10^9
1 <= k <= n
不存在重复的边。

二分答案 + 并查集。
 */