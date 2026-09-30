import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionP3973 {
    // https://leetcode.cn/problems/distinct-gate-paths-to-lca/solutions/3988304/bei-zeng-ju-zhen-cheng-fa-by-smilences-65dd/
    private static final long MOD = (long) (1e9 + 7);
    private int[][] pa;
    private long[][][] val; // val[i][x] = {bb, br, rb, rr}
    private int[] depth;

    public int distinctPaths(int n, int[] parent, int[][] gates, int[][] queries) {
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, _ -> new ArrayList<>());
        for (int i = 1; i < n; i++) {
            g[parent[i]].add(i);
        }

        int m = 32 - Integer.numberOfLeadingZeros(Math.max(n, 1)); // n.bit_length()
        depth = new int[n];
        pa = new int[m][n];
        val = new long[m][n][4];
        for (int i = 0; i < n; i++) {
            int r = gates[i][0], b = gates[i][1], w = gates[i][2];
            val[0][i][0] = b;
            val[0][i][1] = w;
            val[0][i][2] = w;
            val[0][i][3] = r;
        }

        dfs(0, -1, g);

        for (int i = 0; i < m - 1; i++) {
            for (int x = 0; x < n; x++) {
                int p = pa[i][x];
                if (p != -1) {
                    pa[i + 1][x] = pa[i][p];
                    val[i + 1][x] = mul(val[i][p], val[i][x]);
                } else {
                    pa[i + 1][x] = -1;
                }
            }
        }

        long ans = 0;
        for (int[] q : queries) {
            int a = q[0], ac = q[1], b = q[2], bc = q[3];
            int c = lca(a, b);
            long wa = getWays(a, c, ac);
            long wb = getWays(b, c, bc);
            ans ^= (wa * wb) % MOD;
        }
        return (int) ans;
    }

    private void dfs(int x, int fa, List<Integer>[] g) {
        pa[0][x] = fa;
        for (int y : g[x]) {
            depth[y] = depth[x] + 1;
            dfs(y, x, g);
        }
    }

    // mul(x, y) = x @ y（2x2 矩阵乘法）
    private long[] mul(long[] x, long[] y) {
        long xbb = x[0], xbr = x[1], xrb = x[2], xrr = x[3];
        long ybb = y[0], ybr = y[1], yrb = y[2], yrr = y[3];
        return new long[]{
                (xbb * ybb + xbr * yrb) % MOD,
                (xbb * ybr + xbr * yrr) % MOD,
                (xrb * ybb + xrr * yrb) % MOD,
                (xrb * ybr + xrr * yrr) % MOD
        };
    }

    private int getKthAncestor(int node, int k) {
        for (int i = 0; k > 0; i++, k >>= 1) {
            if ((k & 1) == 1) {
                node = pa[i][node];
                if (node < 0) {
                    return -1;
                }
            }
        }
        return node;
    }

    private int lca(int x, int y) {
        if (depth[x] > depth[y]) {
            int t = x;
            x = y;
            y = t;
        }
        y = getKthAncestor(y, depth[y] - depth[x]);
        if (x == y) {
            return x;
        }
        for (int i = pa.length - 1; i >= 0; i--) {
            int px = pa[i][x], py = pa[i][y];
            if (px != py) {
                x = px;
                y = py;
            }
        }
        return pa[0][x];
    }

    // 从 x 向上走到祖先 a（含 x 不含 a 上方），统计经过门后的矩阵，再按 card 取列和
    private long getWays(int x, int a, int card) {
        long bb = 1, br = 0, rb = 0, rr = 1; // 单位矩阵
        int d = depth[x] - depth[a];
        for (int i = 0; d > 0; i++, d >>= 1) {
            if ((d & 1) == 1) {
                long[] m = val[i][x];
                long nbb = (m[0] * bb + m[1] * rb) % MOD;
                long nbr = (m[0] * br + m[1] * rr) % MOD;
                long nrb = (m[2] * bb + m[3] * rb) % MOD;
                long nrr = (m[2] * br + m[3] * rr) % MOD;
                bb = nbb;
                br = nbr;
                rb = nrb;
                rr = nrr;
                x = pa[i][x];
            }
        }
        return (card == 0) ? (bb + rb) % MOD : (br + rr) % MOD;
    }
}
/*
$3973. 通往最近公共祖先的不同门径
https://leetcode.cn/problems/distinct-gate-paths-to-lca/description/

给定一棵以节点 0 为根的无向树，共有 n 个节点，编号为 0 到 n - 1。树由数组 parent 表示，其中 parent[i] 表示节点 i 的父节点。
每个节点 i 都拥有三种类型的门，由二维数组 gates 给出，其中 gates[i] = [redi, bluei, whitei] 分别表示节点 i 上 红门、蓝门 和 白门 的数量。
- 红门（Red）：只能使用 红卡 通过。
- 蓝门（Blue）：只能使用 蓝卡 通过。
- 白门（White）：可以使用 任意颜色 的卡通过，但通过后会 翻转 卡片颜色。
Alice 和 Bob 分别从给定节点出发，初始持有一张红卡或蓝卡（1 表示红卡，0 表示蓝卡）。两人需要 独立地 沿着树 向上移动，直到到达他们的 最近公共祖先（LCA）。
对于每一步移动，只有当当前节点存在至少一个能够被当前卡片使用的门时，才能从该节点移动到父节点。白门可以被使用任意次，每次都会翻转卡片颜色。
移动规则（一次移动指从 u 移动到 parent[u]）：
- 只能沿树向上朝根节点移动。
- 在节点 u，必须选择 恰好一个 具体的门实例。即使多个门类型相同，它们也视为 不同的门实例，分别计数。
- 若当前持有 红卡：可以使用一个红门并保持红卡；或使用一个白门，并将卡片变为蓝卡。
- 若当前持有 蓝卡：可以使用一个蓝门并保持蓝卡；或使用一个白门，并将卡片变为红卡。
- 若当前节点不存在可使用的门，则移动序列立即终止。
同时给定一个二维数组 queries，其中 queries[i] = [aNodei, aCardi, bNodei, bCardi]：
- aNodei、aCardi：表示 Alice 的起始节点及初始卡片。
- bNodei、bCardi：表示 Bob 的起始节点及初始卡片。
对于每个查询，计算 Alice 和 Bob 分别成功到达其 最近公共祖先（LCA）的不同合法方案数，结果对 109 + 7 取模。
所有查询计算完成后，返回这些结果的 按位异或（bitwise XOR）值。
注意：
- 若 Alice 或 Bob 任意一人的门使用方案不同，则认为两种方案不同。
- 若某人起始时已经位于 LCA，则该人的方案数记为 1。
- 最近公共祖先（LCA）定义为：节点 a 与节点 b 的最低公共祖先（节点本身也视为自己的祖先）。
示例 1：
输入： n = 3, parent = [-1,0,0], gates = [[1,0,1],[0,1,1],[1,1,0]], queries = [[1,0,2,0],[1,1,2,0],[1,0,2,1]]
输出： 1
示例 2：
输入： n = 3, parent = [-1,0,1], gates = [[0,1,2],[1,0,1],[0,0,3]], queries = [[2,0,1,0],[2,1,0,0],[1,1,2,1]]
输出： 3
提示：
2 <= n <= 2 * 10^4
n == parent.length == gates.length
parent[0] == -1
对于 [1, n - 1] 中的 i，0 <= parent[i] < n
gates[i] == [redi, bluei, whitei]
0 <= redi, bluei, whitei <= 10
1 <= queries.length <= 2 * 10^4
queries[i] = [aNodei, aCardi, bNodei, bCardi]
0 <= aNodei, bNodei <= n - 1
0 <= aCardi, bCardi <= 1
输入保证数组 parent 表示一棵合法的树。
 */