import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionLCP05 {
    private Map<Integer, List<Integer>> adj;
    private int[] in;
    private int[] out;
    private int clock;

    public int[] bonus(int n, int[][] leadership, int[][] operations) {
        adj = new HashMap<>();
        for (int[] tuple : leadership) {
            int from = tuple[0];
            int to = tuple[1];
            adj.computeIfAbsent(from, key -> new ArrayList<>()).add(to);
        }

        // dfs 序
        in = new int[n + 1];
        out = new int[n + 1];
        dfs(1);

        List<Integer> resList = new ArrayList<>();
        SegmentTree dynamicSegTree = new SegmentTree();
        for (int[] operation : operations) {
            if (operation[0] == 1) {
                // 给团队的一个成员（也可以是负责人）发一定数量的LeetCoin；
                dynamicSegTree.update(in[operation[1]], in[operation[1]], operation[2]);
            } else if (operation[0] == 2) {
                // 给团队的一个成员（也可以是负责人），以及他/她管理的所有人（即他/她的下属、他/她下属的下属，……），发一定数量的LeetCoin；
                dynamicSegTree.update(in[operation[1]], out[operation[1]], operation[2]);
            } else {
                // 查询某一个成员（也可以是负责人），以及他/她管理的所有人被发到的LeetCoin之和。
                resList.add(dynamicSegTree.getSum(in[operation[1]], out[operation[1]]));
            }
        }
        return resList.stream().mapToInt(i -> i).toArray();
    }

    // DFS 时间戳
    private void dfs(int x) {
        in[x] = ++clock;
        for (int next : adj.getOrDefault(x, new ArrayList<>())) {
            dfs(next);
        }
        out[x] = clock;
    }

    // 动态开点线段树
    private static class DynamicSegTree {
        private static final int MOD = 1000000007;

        private static class Node {
            // 左子树
            Node ls;
            // 右子树
            Node rs;
            // 区间和
            long sum;
            // 懒标记
            long lazy;
        }

        private static final int N = 50000;
        private final Node root = new Node();

        // 区间更新 [l,r] 置为 val
        void update(int l, int r, int val) {
            this.update(l, r, val, 1, N, root);
        }

        // 区间查询 [l,r] 最大值
        int getSum(int l, int r) {
            return (int) this.getSum(l, r, 1, N, root);
        }

        private void update(int l, int r, int val, int s, int t, Node node) {
            if (l <= s && t <= r) {
                node.sum += (t - s + 1L) * val;
                node.lazy += val;
                return;
            }
            int mid = s + (t - s) / 2;
            pushDown(node, s, t, mid);
            if (l <= mid) {
                update(l, r, val, s, mid, node.ls);
            }
            if (r > mid) {
                update(l, r, val, mid + 1, t, node.rs);
            }
            pushUp(node);
        }

        private long getSum(int l, int r, int s, int t, Node node) {
            if (l <= s && t <= r) {
                return node.sum;
            }
            int mid = s + (t - s) / 2;
            pushDown(node, s, t, mid);
            long sum = 0;
            if (l <= mid) {
                sum = getSum(l, r, s, mid, node.ls) % MOD;
            }
            if (r > mid) {
                sum += getSum(l, r, mid + 1, t, node.rs) % MOD;
            }
            return sum % MOD;
        }

        private void pushDown(Node node, int s, int t, int mid) {
            if (node.ls == null) {
                node.ls = new Node();
            }
            if (node.rs == null) {
                node.rs = new Node();
            }
            if (node.lazy > 0) {
                node.ls.sum += node.lazy * (mid - s + 1);
                node.rs.sum += node.lazy * (t - mid);
                node.ls.lazy += node.lazy;
                node.rs.lazy += node.lazy;
                node.lazy = 0;
            }
        }

        private void pushUp(Node node) {
            node.sum = node.ls.sum + node.rs.sum;
        }
    }

    private static class SegmentTree {
        private static final int MOD = 1000000007;
        private final int N = 50000;
        private final long[] tree;
        private final long[] lazy;

        public SegmentTree() {
            tree = new long[N * 4];
            lazy = new long[N * 4];
        }

        // [l,r] 范围置为 c
        private void update(int l, int r, int val, int s, int t, int p) {
            if (l <= s && t <= r) {
                tree[p] += (t - s + 1L) * val;
                lazy[p] += val;
                return;
            }
            int mid = s + (t - s) / 2;
            if (lazy[p] > 0) {
                tree[p * 2] += lazy[p] * (mid - s + 1);
                tree[p * 2 + 1] += lazy[p] * (t - mid);
                lazy[p * 2] += lazy[p];
                lazy[p * 2 + 1] += lazy[p];
                lazy[p] = 0;
            }
            if (l <= mid) {
                update(l, r, val, s, mid, p * 2);
            }
            if (r > mid) {
                update(l, r, val, mid + 1, t, p * 2 + 1);
            }
            tree[p] = tree[p * 2] + tree[p * 2 + 1];
        }

        private long getSum(int l, int r, int s, int t, int p) {
            if (l <= s && t <= r) {
                return tree[p];
            }
            int mid = s + (t - s) / 2;
            if (lazy[p] > 0) {
                tree[p * 2] += lazy[p] * (mid - s + 1);
                tree[p * 2 + 1] += lazy[p] * (t - mid);
                lazy[p * 2] += lazy[p];
                lazy[p * 2 + 1] += lazy[p];
                lazy[p] = 0;
            }
            long sum = 0;
            if (l <= mid) {
                sum = getSum(l, r, s, mid, p * 2) % MOD;
            }
            if (r > mid) {
                sum += getSum(l, r, mid + 1, t, p * 2 + 1) % MOD;
            }
            return sum % MOD;
        }

        void update(int l, int r, int val) {
            update(l, r, val, 1, N, 1);
        }

        int getSum(int l, int r) {
            return (int) getSum(l, r, 1, N, 1);
        }
    }
}
/*
LCP 05. 发 LeetCoin
https://leetcode.cn/problems/coin-bonus/

力扣决定给一个刷题团队发LeetCoin作为奖励。同时，为了监控给大家发了多少LeetCoin，力扣有时候也会进行查询。
该刷题团队的管理模式可以用一棵树表示：
1.团队只有一个负责人，编号为1。除了该负责人外，每个人有且仅有一个领导（负责人没有领导）；
2.不存在循环管理的情况，如A管理B，B管理C，C管理A。
力扣想进行的操作有以下三种：
1.给团队的一个成员（也可以是负责人）发一定数量的LeetCoin；
2.给团队的一个成员（也可以是负责人），以及他/她管理的所有人（即他/她的下属、他/她下属的下属，……），发一定数量的LeetCoin；
3.查询某一个成员（也可以是负责人），以及他/她管理的所有人被发到的LeetCoin之和。
输入：
1.N表示团队成员的个数（编号为1～N，负责人为1）；
2.leadership是大小为(N - 1) * 2的二维数组，其中每个元素[a, b]代表b是a的下属；
3.operations是一个长度为Q的二维数组，代表以时间排序的操作，格式如下：
 1.operations[i][0] = 1: 代表第一种操作，operations[i][1]代表成员的编号，operations[i][2]代表LeetCoin的数量；
 2.operations[i][0] = 2: 代表第二种操作，operations[i][1]代表成员的编号，operations[i][2]代表LeetCoin的数量；
 3.operations[i][0] = 3: 代表第三种操作，operations[i][1]代表成员的编号；
输出：
返回一个数组，数组里是每次查询的返回值（发LeetCoin的操作不需要任何返回值）。由于发的LeetCoin很多，请把每次查询的结果模1e9+7 (1000000007)。
限制：
1 <= N <= 50000
1 <= Q <= 50000
operations[i][0] != 3 时，1 <= operations[i][2] <= 5000

DFS 时间戳 + 线段树
相似题目: 2322. 从树中删除边的最小分数
https://leetcode.cn/problems/minimum-score-after-removals-on-a-tree/
 */