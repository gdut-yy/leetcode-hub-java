import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3515 {
    private List<Integer>[] g;
    private int[] in, out, weight;
    private int clock;
    private BIT tr;

    public int[] treeQueries(int n, int[][] edges, int[][] queries) {
        g = new ArrayList[n + 1];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] e : edges) {
            int x = e[0], y = e[1];
            g[x].add(y);
            g[y].add(x);
        }
        in = new int[n + 1];
        out = new int[n + 1];
        dfs(1, 0);

        weight = new int[n + 1];
        tr = new BIT(n);
        for (int[] e : edges) {
            update(e[0], e[1], e[2]);
        }

        List<Integer> ans = new ArrayList<>();
        for (int[] q : queries) {
            if (q[0] == 1) {
                update(q[1], q[2], q[3]);
            } else {
                ans.add(tr.query(in[q[1]]));
            }
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }

    private void dfs(int x, int fa) {
        in[x] = ++clock; // 进来的时间
        for (int y : g[x]) {
            if (y == fa) continue;
            dfs(y, x);
        }
        out[x] = clock; // 离开的时间
    }

    private void update(int x, int y, int w) {
        // 保证 y 是 x 的儿子
        if (in[x] > in[y]) {
            y = x;
        }
        int d = w - weight[y]; // 边权的增量
        weight[y] = w;
        // 把子树 y 中的最短路长度都增加 d（用差分树状数组维护）
        tr.add(in[y], d);
        tr.add(out[y] + 1, -d);
    }

    static class BIT {
        int n;
        int[] tree;

        public BIT(int n) {
            this.n = n;
            tree = new int[n + 1];
        }

        int lb(int x) {
            return x & -x;
        }

        void add(int pos, int val) {
            for (; pos <= n; pos += lb(pos)) tree[pos] += val;
        }

        int query(int pos) {
            int ret = 0;
            for (; pos > 0; pos -= lb(pos)) ret += tree[pos];
            return ret;
        }
    }
}
/*
3515. 带权树中的最短路径
https://leetcode.cn/problems/shortest-path-in-a-weighted-tree/description/

第 154 场双周赛 T4。

给你一个整数 n 和一个以节点 1 为根的无向带权树，该树包含 n 个编号从 1 到 n 的节点。它由一个长度为 n - 1 的二维数组 edges 表示，其中 edges[i] = [ui, vi, wi] 表示一条从节点 ui 到 vi 的无向边，权重为 wi。
同时给你一个二维整数数组 queries，长度为 q，其中每个 queries[i] 为以下两种之一：
- [1, u, v, w'] – 更新 节点 u 和 v 之间边的权重为 w'，其中 (u, v) 保证是 edges 中存在的边。
- [2, x] – 计算 从根节点 1 到节点 x 的 最短 路径距离。
返回一个整数数组 answer，其中 answer[i] 是对于第 i 个 [2, x] 查询，从节点 1 到 x 的最短路径距离。
提示：
1 <= n <= 10^5
edges.length == n - 1
edges[i] == [ui, vi, wi]
1 <= ui, vi <= n
1 <= wi <= 10^4
输入保证 edges 构成一棵合法的树。
1 <= queries.length == q <= 10^5
queries[i].length == 2 或 4
  - queries[i] == [1, u, v, w']，或者
  - queries[i] == [2, x]
  - 1 <= u, v, x <= n
  - (u, v) 一定是 edges 中的一条边。
  - 1 <= w' <= 10^4

DFS 时间戳 + 差分树状数组
https://leetcode.cn/problems/shortest-path-in-a-weighted-tree/solutions/3649372/dfs-shi-jian-chuo-chai-fen-shu-zhuang-sh-h8q3/
rating 2344 (clist.by)
 */