import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SolutionLCP16 {
    // https://leetcode.cn/problems/you-le-yuan-de-you-lan-ji-hua/solutions/228897/tu-jie-si-lu-xiang-xi-zheng-ming-by-newhar
    public int maxWeight(int[][] edges, int[] value) {
        int n = value.length, m = edges.length;
        int[] deg = new int[n];

        // 对边按权值和排序，以便之后对每个点，直接获得按权值和排序的边
        Arrays.sort(edges, Comparator.comparingInt(o -> -(value[o[0]] + value[o[1]])));

        // 统计各个点的度数（出边数量）
        for (int[] p : edges) {
            deg[p[0]]++;
            deg[p[1]]++;
        }

        // 将无向图重建为有向图
        List<int[]>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int x = edges[i][0], y = edges[i][1];
            if (deg[x] < deg[y] || (deg[x] == deg[y] && x < y)) {
                g[x].add(new int[]{y, i});
            } else {
                g[y].add(new int[]{x, i});
            }
        }

        // 求所有的三元环，并按边归类
        List<Integer>[] nodes = new ArrayList[m];
        Arrays.setAll(nodes, e -> new ArrayList<>());
        int[] vis = new int[n], idxs = new int[n];
        Arrays.fill(vis, -1);
        for (int i = 0; i < m; i++) {
            int x = edges[i][0], y = edges[i][1];
            for (int[] ne : g[x]) {
                vis[ne[0]] = i;
                idxs[ne[0]] = ne[1];
            }
            for (int[] ne : g[y]) {
                if (vis[ne[0]] == i) {
                    nodes[ne[1]].add(x);
                    nodes[idxs[ne[0]]].add(y);
                    nodes[i].add(ne[0]);
                }
            }
        }

        // 将三元环按顶点归类，每个顶点自动获得按权值和排序的边
        List<Integer>[] C = new ArrayList[n];
        Arrays.setAll(C, e -> new ArrayList<>());
        for (int i = 0; i < m; i++) {
            for (int n0 : nodes[i]) {
                C[n0].add(i);
            }
        }

        // 求出结果
        int res = 0;
        for (int i = 0; i < n; i++) {
            int bound = C[i].size() - 1;
            for (int a = 0; a < Math.min(3, C[i].size()) && bound >= a; ++a) {
                for (int b = a; b <= bound; ++b) {
                    int[] ea = edges[C[i].get(a)], eb = edges[C[i].get(b)];
                    int cur = value[i] + value[ea[0]] + value[ea[1]], cnt = 0;
                    if (eb[0] != ea[0] && eb[0] != ea[1]) {
                        cur += value[eb[0]];
                        ++cnt;
                    }
                    if (eb[1] != ea[0] && eb[1] != ea[1]) {
                        cur += value[eb[1]];
                        ++cnt;
                    }
                    res = Math.max(res, cur);
                    if (cnt == 2) {
                        bound = b - 1;
                        break;
                    }
                }
            }
        }
        return res;
    }
}
/*
LCP 16. 游乐园的游览计划
https://leetcode.cn/problems/you-le-yuan-de-you-lan-ji-hua/description/

又到了一年一度的春游时间，小吴计划去游乐场游玩 1 天，游乐场总共有 N 个游乐项目，编号从 0 到 N-1。小吴给每个游乐项目定义了一个非负整数值 value[i] 表示自己的喜爱值。
两个游乐项目之间会有双向路径相连，整个游乐场总共有 M 条双向路径，保存在二维数组 edges中。 小吴计划选择一个游乐项目 A 作为这一天游玩的重点项目。
上午小吴准备游玩重点项目 A 以及与项目 A 相邻的两个项目 B、C （项目A、B与C要求是不同的项目，且项目B与项目C要求相邻），并返回 A ，即存在一条 A-B-C-A 的路径。
下午，小吴决定再游玩重点项目 A以及与A相邻的两个项目 B'、C'，（项目A、B'与C'要求是不同的项目，且项目B'与项目C'要求相邻），并返回 A ，即存在一条 A-B'-C'-A 的路径。
下午游玩项目 B'、C' 可与上午游玩项目B、C存在重复项目。 小吴希望提前安排好游玩路径，使得喜爱值之和最大。
请你返回满足游玩路径选取条件的最大喜爱值之和，如果没有这样的路径，返回 0。 注意：一天中重复游玩同一个项目并不能重复增加喜爱值了。
例如：上下午游玩路径分别是 A-B-C-A与A-C-D-A 那么只能获得 value[A] + value[B] + value[C] + value[D] 的总和。
限制：
3 <= value.length <= 10000
1 <= edges.length <= 10000
0 <= edges[i][0],edges[i][1] < value.length
0 <= value[i] <= 10000
edges中没有重复的边
edges[i][0] != edges[i][1]

改进的暴力法
时间复杂度 O(M * sqrt(M))
 */