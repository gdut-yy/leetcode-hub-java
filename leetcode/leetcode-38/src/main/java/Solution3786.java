import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3786 {
    public long interactionCosts(int n, int[][] edges, int[] group) {
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            g[u].add(v);
            g[v].add(u);
        }

        final int MX = 20;
        int[] tot = new int[MX + 1];
        for (int x : group) tot[x]++;

        int[] pa = new int[n];
        Arrays.fill(pa, -2);
        pa[0] = -1;
        int[] stack = new int[n];
        int sp = 0;
        stack[sp++] = 0;
        int[] order = new int[n];
        int ord = 0;
        while (sp > 0) {
            int u = stack[--sp];
            order[ord++] = u;
            for (Integer v : g[u]) {
                if (v == pa[u]) continue;
                pa[v] = u;
                stack[sp++] = v;
            }
        }
//        dfs(0, -1);
        int[][] cnt = new int[n][MX + 1];
        for (int i = 0; i < n; i++) {
            cnt[i][group[i]] = 1;
        }
        for (int i = n - 1; i >= 0; i--) {
            int u = order[i];
            for (Integer v : g[u]) {
                if (pa[v] == u) {
                    for (int g1 = 1; g1 <= MX; g1++) {
                        cnt[u][g1] += cnt[v][g1];
                    }
                }
            }
        }
        long ans = 0L;
        for (int v = 1; v < n; v++) {
            for (int g1 = 1; g1 <= MX; g1++) {
                long c = cnt[v][g1];
                ans += c * (tot[g1] - c);
            }
        }
        return ans;
    }
}
/*
3786. 树组的交互代价总和
https://leetcode.cn/problems/total-sum-of-interaction-cost-in-tree-groups/description/

第 481 场周赛 T4。

给你一个整数 n 和一棵包含 n 个节点、编号从 0 到 n - 1 的无向树。树由一个长度为 n - 1 的二维数组 edges 表示，其中 edges[i] = [ui, vi] 表示节点 ui 和 vi 之间存在一条无向边。
同时给定一个长度为 n 的整数数组 group，其中 group[i] 表示分配给节点 i 的组标签。
- 如果 group[u] == group[v]，则认为节点 u 和 v 属于同一组。
- 交互代价 定义为节点 u 和 v 之间的唯一路径上的边数。
返回所有满足条件的 无序 节点对 (u, v) （其中 u != v 且 group[u] == group[v]）的交互代价之和。如果没有这样的节点对，返回 0。
提示：
1 <= n <= 10^5
edges.length == n - 1
edges[i] = [ui, vi]
0 <= ui, vi <= n - 1
group.length == n
1 <= group[i] <= 20
输入保证 edges 表示一棵有效的树。

贡献法，附 O(nlogn) 虚树做法 https://leetcode.cn/problems/total-sum-of-interaction-cost-in-tree-groups/solutions/3862088/gong-xian-fa-pythonjavacgo-by-endlessche-4nxs/
时间复杂度 O(nU)。其中 U = 20.
 */