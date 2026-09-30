import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionP3949 {
    // https://leetcode.cn/problems/subtree-inversion-sum-ii/solutions/3978969/shu-shang-dpte-pan-29xing-ji-jian-100394-jjjq/
    private static final long NEG_INF = Long.MIN_VALUE / 4;
    private int[] nums;
    private int k;
    private long[][][] memo; // memo[x][parity][d]

    public int subtreeInversionSum(int[][] edges, int[] nums, int k) {
        int n = nums.length;
        this.nums = nums;
        this.k = k;
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, _ -> new ArrayList<>());
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        memo = new long[n][2][k + 1];
        for (long[][] a : memo) {
            for (long[] b : a) {
                Arrays.fill(b, NEG_INF);
            }
        }
        long[] root = dfs(0, -1, 0, g);
        long ans = NEG_INF;
        for (long v : root) {
            ans = Math.max(ans, v);
        }
        return Math.toIntExact(ans);
    }

    /**
     * 返回 ret[d]（d = 0..k）：x 子树的最大贡献和，
     * 且 x 到 x 子树内最近被反转节点的距离恰为 d（d == k 表示子树内没有反转节点）。
     * parity：x 的祖先中被反转的节点个数奇偶（不含 x 自身），决定 x 当前符号。
     */
    private long[] dfs(int x, int fa, int parity, List<Integer>[] g) {
        if (memo[x][parity][k] != NEG_INF) {
            return memo[x][parity];
        }
        long[] ret = new long[k + 1];
        Arrays.fill(ret, NEG_INF);
        int v = nums[x];

        // ---- 分支一：不反转 x ----
        long[] cur = new long[k + 1];
        Arrays.fill(cur, NEG_INF);
        cur[k] = 0; // 尚未合并任何子节点：视为"无反转节点"，距离 k
        for (int y : g[x]) {
            if (y == fa) {
                continue;
            }
            long[] sub = dfs(y, x, parity, g);
            long[] next = new long[k + 1];
            Arrays.fill(next, NEG_INF);
            // 合并：next[min(dy,cd)] = max(cur[cd] + sub[dy])
            // 约束：dy<k 且 cd<k 时要求 dy + cd + 2 >= k
            for (int dy = 0; dy <= k; dy++) {
                if (sub[dy] == NEG_INF) {
                    continue;
                }
                // cd 的有效范围：dy==k 时任意；否则 cd >= max(0, k-dy-2)
                int lo = (dy < k) ? Math.max(0, k - dy - 2) : 0;
                for (int cd = lo; cd <= k; cd++) {
                    if (cur[cd] == NEG_INF) {
                        continue;
                    }
                    int nd = Math.min(dy, cd); // 合并后的最近反转距离
                    long val = cur[cd] + sub[dy];
                    if (val > next[nd]) {
                        next[nd] = val;
                    }
                }
            }
            cur = next;
        }
        for (int d = 0; d <= k; d++) {
            if (cur[d] == NEG_INF) {
                continue;
            }
            // x 自身贡献：符号由祖先反转奇偶决定
            long signV = (parity == 0) ? v : -v;
            int nd = (d < k) ? Math.min(d + 1, k) : k; // 距离加 1（经过边 x-y），超过 k 截断
            ret[nd] = Math.max(ret[nd], cur[d] + signV);
        }

        // ---- 分支二：反转 x ----
        long sum = 0;
        boolean ok = true;
        for (int y : g[x]) {
            if (y == fa) {
                continue;
            }
            // 反转 x 后，y 子树内反转节点到 x 的距离 = dy + 1 >= k，故 dy >= k - 1
            long[] sub = dfs(y, x, parity ^ 1, g);
            long best = NEG_INF;
            for (int dy = k - 1; dy <= k; dy++) {
                best = Math.max(best, sub[dy]);
            }
            if (best == NEG_INF) {
                ok = false;
                break;
            }
            sum += best;
        }
        if (ok) {
            // x 自身符号再翻转一次
            long signV = (parity == 1) ? v : -v;
            ret[0] = Math.max(ret[0], sum + signV); // x 就是最近反转节点，距离 0
        }

        memo[x][parity] = ret;
        return ret;
    }
}
/*
$3949. 子树反转和 II
https://leetcode.cn/problems/subtree-inversion-sum-ii/description/

给你一棵以节点 0 为根节点包含 n 个节点的无向树，节点编号从 0 到 n - 1。该树由长度为 n - 1 的二维整数数组 edges 表示，其中 edges[i] = [ui, vi] 表示节点 ui 和 vi 之间有一条边。
同时给你一个整数 k 和长度为 n 的整数数组 nums，其中 nums[i] 表示节点 i 的值。
你可以对节点的 子集 执行 反转操作 ，该操作需满足以下条件：
- 子树反转操作：
  - 当你反转一个节点时，以该节点为根的 子树 中所有节点的值都乘以 -1。
- 反转之间的距离限制：
  - 你只能在一个节点与其他已反转节点“足够远”的情况下反转它。
  - 如果你反转两个节点 a 和 b，它们之间的距离（它们之间唯一路径上的边数）必须至少为 k。
返回应用 反转操作 后树上节点值的 最大 可能 总和 。
示例 1：
输入：edges = [[0,1],[0,2],[0,3],[1,4],[1,5]], nums = [1,0,-10,3,4,5], k = 2
输出：23
示例 2：
输入：edges = [[0,1],[1,2]], nums = [5,-10,-10], k = 1
输出：25
示例 3：
输入：edges = [[0,1],[0,2]], nums = [1,-5,-6], k = 2
输出：12
示例 4：
输入：edges = [[0,1],[0,2]], nums = [1,-5,-6], k = 3
输出：10
提示：
nums.length == n
edges.length == n - 1
2 <= n <= 5 * 10^4
edges[i].length == 2
0 <= edges[i][0], edges[i][1] < n
-4 * 10^4 <= nums[i] <= 4 * 10^4
1 <= k <= 50
保证 edges 能够形成一棵树。
 */