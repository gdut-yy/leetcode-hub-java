public class Solution3901 {
    public int countGoodSubseq(int[] nums, int p, int[][] queries) {
        int n = nums.length;
        int cntP = 0;
        for (int x : nums) {
            if (x % p == 0) {
                cntP++;
            }
        }

        SegmentTree t = new SegmentTree(nums, p);
        int ans = 0;

        for (int[] q : queries) {
            int i = q[0];
            int x = q[1];

            if (nums[i] % p == 0) {
                cntP--;
            }
            if (x % p == 0) {
                cntP++;
            }
            nums[i] = x;
            t.update(i, x);

            if (t.queryAll() == p && (cntP < n || n > 6 || t.check(n))) {
                ans++;
            }
        }

        return ans;
    }

    // 模板来源 https://leetcode.cn/circle/discuss/mOr1u6/
    // 线段树有两个下标，一个是线段树节点的下标，另一个是线段树维护的区间的下标
    // 节点的下标：从 1 开始，如果你想改成从 0 开始，需要把左右儿子下标分别改成 node*2+1 和 node*2+2
    // 区间的下标：从 0 开始
    static class SegmentTree {
        private final int targetGcd;
        private final int n;
        private final int[] tree;

        // 线段树维护数组 a
        public SegmentTree(int[] a, int targetGcd) {
            this.targetGcd = targetGcd;
            n = a.length;
            tree = new int[2 << (32 - Integer.numberOfLeadingZeros(n - 1))];
            build(a, 1, 0, n - 1);
        }

        // 更新 a[i]
        // 时间复杂度 O(log n)
        public void update(int i, int val) {
            update(1, 0, n - 1, i, val);
        }

        // 返回用 gcd 合并所有 a[i] 的计算结果，其中 i 在闭区间 [ql, qr] 中
        // 时间复杂度 O(log n)
        public int query(int ql, int qr) {
            return query(1, 0, n - 1, ql, qr);
        }

        public int queryAll() {
            return tree[1];
        }

        public boolean check(int n) {
            for (int i = 0; i < n; i++) {
                if (gcd(query(0, i - 1), query(i + 1, n - 1)) == targetGcd) {
                    return true;
                }
            }
            return false;
        }

        // 合并左右儿子的 val 到当前节点的 val
        private void maintain(int node) {
            tree[node] = gcd(tree[node * 2], tree[node * 2 + 1]);
        }

        // 用 a 初始化线段树
        // 时间复杂度 O(n)
        private void build(int[] a, int node, int l, int r) {
            if (l == r) { // 叶子
                // 0 和任何数 g 的 GCD 都是 g，所以设置为 0 不影响所有数的 GCD
                tree[node] = a[l] % targetGcd == 0 ? a[l] : 0; // 初始化叶节点的值
                return;
            }
            int m = (l + r) / 2;
            build(a, node * 2, l, m); // 初始化左子树
            build(a, node * 2 + 1, m + 1, r); // 初始化右子树
            maintain(node);
        }

        private void update(int node, int l, int r, int i, int val) {
            if (l == r) { // 叶子（到达目标）
                // 0 和任何数 g 的 GCD 都是 g，所以设置为 0 不影响所有数的 GCD
                tree[node] = val % targetGcd == 0 ? val : 0;
                return;
            }
            int m = (l + r) / 2;
            if (i <= m) { // i 在左子树
                update(node * 2, l, m, i, val);
            } else { // i 在右子树
                update(node * 2 + 1, m + 1, r, i, val);
            }
            maintain(node);
        }

        private int query(int node, int l, int r, int ql, int qr) {
            if (ql > qr) {
                return 0;
            }
            if (ql <= l && r <= qr) { // 当前子树完全在 [ql, qr] 内
                return tree[node];
            }
            int m = (l + r) / 2;
            if (qr <= m) { // [ql, qr] 在左子树
                return query(node * 2, l, m, ql, qr);
            }
            if (ql > m) { // [ql, qr] 在右子树
                return query(node * 2 + 1, m + 1, r, ql, qr);
            }
            int lRes = query(node * 2, l, m, ql, qr);
            int rRes = query(node * 2 + 1, m + 1, r, ql, qr);
            return gcd(lRes, rRes);
        }

        private int gcd(int a, int b) {
            while (a != 0) {
                int tmp = a;
                a = b % a;
                b = tmp;
            }
            return b;
        }
    }
}
/*
3901. 好子序列查询
https://leetcode.cn/problems/good-subsequence-queries/description/

第 497 场周赛 T4。

给你一个长度为 n 的整数数组 nums 和一个整数 p。
如果 nums 的一个 非空子序列 满足以下条件，则称其为 好子序列：
- 其长度 严格小于 n。
- 其所有元素的 最大公约数（GCD）恰好等于 p。
另给定一个长度为 q 的二维整数数组 queries，其中 queries[i] = [indi, vali] 表示你需要将 nums[indi] 更新为 vali。
在每次查询更新后，判断当前数组中是否存在 任意一个好子序列。
返回一个整数，表示使得数组中存在 好子序列 的查询 次数。
子序列 是指通过删除原序列中的某些元素或不删除任何元素，并且不改变剩余元素相对顺序后得到的序列。
gcd(a, b) 表示 a 和 b 的 最大公约数。
提示：
2 <= n == nums.length <= 5 * 10^4
1 <= nums[i] <= 5 * 10^4
1 <= queries.length <= 5 * 10^4
queries[i] = [indi, vali]
1 <= vali, p <= 5 * 10^4
0 <= indi <= n - 1

线段树。
https://leetcode.cn/problems/good-subsequence-queries/solutions/3949925/jie-lun-xian-duan-shu-by-endlesscheng-aihf/
 */