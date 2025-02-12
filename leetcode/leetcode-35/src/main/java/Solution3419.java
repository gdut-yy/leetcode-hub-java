import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3419 {
    private int n;
    private List<int[]>[] rg;
    private int[] vis;

    public int minMaxWeight(int n, int[][] edges, int threshold) {
        this.n = n;
        rg = new ArrayList[n]; // 反图
        Arrays.setAll(rg, e -> new ArrayList<>());
        int maxWt = 0;
        for (int[] p : edges) {
            int u = p[0], v = p[1], wt = p[2];
            rg[v].add(new int[]{u, wt});
            maxWt = Math.max(maxWt, wt);
        }

        vis = new int[n];
        int left = 0;
        int right = maxWt + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return (left == maxWt + 1) ? -1 : left;
    }

    private boolean checkMid(int mid) {
        return dfs(0, mid) == n;
    }

    private int dfs(int x, int upper) {
        vis[x] = upper; // 避免每次重新创建 vis 数组
        int cnt = 1;
        for (int[] e : rg[x]) {
            int y = e[0];
            if (e[1] <= upper && vis[y] != upper) {
                cnt += dfs(y, upper);
            }
        }
        return cnt;
    }
}
/*
3419. 图的最大边权的最小值
https://leetcode.cn/problems/minimize-the-maximum-edge-weight-of-graph/description/

第 432 场周赛 T3。

给你两个整数 n 和 threshold ，同时给你一个 n 个节点的 有向 带权图，节点编号为 0 到 n - 1 。这个图用 二维 整数数组 edges 表示，其中 edges[i] = [Ai, Bi, Wi] 表示节点 Ai 到节点 Bi 之间有一条边权为 Wi的有向边。
你需要从这个图中删除一些边（也可能 不 删除任何边），使得这个图满足以下条件：
- 所有其他节点都可以到达节点 0 。
- 图中剩余边的 最大 边权值尽可能小。
- 每个节点都 至多 有 threshold 条出去的边。
请你返回删除必要的边后，最大 边权的 最小值 为多少。如果无法满足所有的条件，请你返回 -1 。
提示：
2 <= n <= 10^5
1 <= threshold <= n - 1
1 <= edges.length <= min(105, n * (n - 1) / 2).
edges[i].length == 3
0 <= Ai, Bi < n
Ai != Bi
1 <= Wi <= 10^6
一对节点之间 可能 会有多条边，但它们的权值互不相同。

二分答案。
threshold 是多余的。请大胆二分。
rating 2249 (clist.by)
 */