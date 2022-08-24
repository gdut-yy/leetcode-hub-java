public class Solution2382 {
    private static final long INF = 100000L * 1000000000L + 10L;

    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        SegmentTree segmentTree = new SegmentTree(nums.length);
        for (int i = 0; i < nums.length; i++) {
            segmentTree.modify(i + 1, nums[i]);
        }

        int len = removeQueries.length;
        long[] res = new long[len];
        for (int i = 0; i < len - 1; i++) {
            segmentTree.modify(removeQueries[i] + 1, -INF);
            res[i] = segmentTree.query().maxSum;
        }
        return res;
    }

    private static class SegmentTree {
        private static class Node {
            // lSum 表示 [l,r] 内以 l 为左端点的最大子段和
            long lSum;
            // rSum 表示 [l,r] 内以 r 为右端点的最大子段和
            long rSum;
            // maxSum 表示 [l,r] 内的最大子段和
            long maxSum;
            // itSum 表示 [l,r] 的区间和
            long itSum;

            public Node(long lSum, long rSum, long maxSum, long itSum) {
                this.lSum = lSum;
                this.rSum = rSum;
                this.maxSum = maxSum;
                this.itSum = itSum;
            }
        }

        private final int N;
        private final Node[] tree;

        public SegmentTree(int n) {
            N = n;
            tree = new Node[4 * N];
            for (int i = 0; i < 4 * N; i++) {
                tree[i] = new Node(0, 0, 0, 0);
            }
            build(1, N, 1);
        }

        private void build(int s, int t, int p) {
            if (s == t) {
                tree[p].lSum = -1;
                tree[p].rSum = -1;
                tree[p].maxSum = -1;
                tree[p].itSum = -1;
                return;
            }
            int mid = s + (t - s) / 2;
            build(s, mid, p * 2);
            build(mid + 1, t, p * 2 + 1);
            tree[p] = pushUp(tree[p * 2], tree[p * 2 + 1]);
        }

        private Node pushUp(Node a, Node b) {
            long lSum = Math.max(a.lSum, a.itSum + b.lSum);
            long rSum = Math.max(b.rSum, b.itSum + a.rSum);
            long maxSum = Math.max(Math.max(a.maxSum, b.maxSum), a.rSum + b.lSum);
            long itSum = a.itSum + b.itSum;
            return new Node(lSum, rSum, maxSum, itSum);
        }

        private void modify(int s, int t, int p, int pos, long val) {
            if (s > pos || t < pos) {
                return;
            }
            if (s == pos && t == pos) {
                tree[p].lSum = val;
                tree[p].rSum = val;
                tree[p].maxSum = val;
                tree[p].itSum = val;
                return;
            }
            int mid = s + (t - s) / 2;
            modify(s, mid, p * 2, pos, val);
            modify(mid + 1, t, p * 2 + 1, pos, val);
            tree[p] = pushUp(tree[p * 2], tree[p * 2 + 1]);
        }

        private Node query(int s, int t, int p, int l, int r) {
            if (s > r || t < l) {
                return new Node(0, 0, 0, 0);
            }
            if (s >= l && t <= r) {
                return tree[p];
            }
            int mid = s + (t - s) / 2;
            Node lSub = query(s, mid, p * 2, l, r);
            Node rSub = query(mid + 1, t, p * 2 + 1, l, r);
            return pushUp(lSub, rSub);
        }

        private void modify(int pos, long val) {
            modify(1, N, 1, pos, val);
        }

        private Node query() {
            return query(1, N, 1, 1, N);
        }
    }
}
/*
2382. 删除操作后的最大子段和
https://leetcode.cn/problems/maximum-segment-sum-after-removals/

给你两个下标从 0 开始的整数数组 nums 和 removeQueries ，两者长度都为 n 。对于第 i 个查询，nums 中位于下标 removeQueries[i] 处的元素被删除，将 nums 分割成更小的子段。
一个 子段 是 nums 中连续 正 整数形成的序列。子段和 是子段中所有元素的和。
请你返回一个长度为 n 的整数数组 answer ，其中 answer[i]是第 i 次删除操作以后的 最大 子段和。
注意：一个下标至多只会被删除一次。
提示：
n == nums.length == removeQueries.length
1 <= n <= 10^5
1 <= nums[i] <= 10^9
0 <= removeQueries[i] < n
removeQueries 中所有数字 互不相同 。

线段树
时间复杂度 O(nlogn)
 */