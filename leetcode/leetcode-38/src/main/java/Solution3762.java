import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution3762 {
    public long[] minOperations(int[] nums, int k, int[][] queries) {
        int n = nums.length;
        int[] rem = new int[n];
        for (int i = 0; i < n; i++) {
            rem[i] = nums[i] % k;
        }

        SegTree1 seg1 = new SegTree1(rem, n);

        long[] b = new long[n];
        for (int i = 0; i < n; i++) {
            b[i] = (nums[i] - rem[i]) / (long) k;
        }

        long[] sorted = b.clone();
        Arrays.sort(sorted);
        int size = 1;
        for (int i = 1; i < n; i++) {
            if (sorted[i] != sorted[size - 1]) {
                sorted[size++] = sorted[i];
            }
        }
        sorted = Arrays.copyOf(sorted, size);

        Map<Long, Integer> mp = new HashMap<>();
        for (int i = 0; i < size; i++) {
            mp.put(sorted[i], i);
        }

        PersistentSegTree seg2 = new PersistentSegTree(size);
        int[] roots = new int[n + 1];
        roots[0] = seg2.build(0, size - 1);
        for (int i = 0; i < n; i++) {
            int pos = mp.get(b[i]);
            roots[i + 1] = seg2.insert(roots[i], 0, size - 1, pos, b[i]);
        }

        int q = queries.length;
        long[] ans = new long[q];
        for (int i = 0; i < q; i++) {
            int li = queries[i][0], ri = queries[i][1];
            int minRem = seg1.queryMin(li, ri);
            int maxRem = seg1.queryMax(li, ri);
            if (minRem != maxRem) {
                ans[i] = -1;
            } else {
                int len = ri - li + 1;
                int mid = (len + 1) / 2;
                int idx_m = seg2.queryKth(roots[ri + 1], roots[li], mid);
                long m = sorted[idx_m];
                long[] left = seg2.queryRange(roots[ri + 1], roots[li], 0, idx_m - 1);
                long[] right = seg2.queryRange(roots[ri + 1], roots[li], idx_m + 1, size - 1);
                long left_count = left[0];
                long left_sum = left[1];
                long right_count = right[0];
                long right_sum = right[1];
                ans[i] = (m * left_count - left_sum) + (right_sum - m * right_count);
            }
        }
        return ans;
    }

    static class SegTree1 {
        int n;
        int[] min;
        int[] max;
        int[] arr;

        public SegTree1(int[] arr, int n) {
            this.n = n;
            this.arr = arr;
            min = new int[4 * n];
            max = new int[4 * n];
            build(0, n - 1, 0);
        }

        private void build(int l, int r, int idx) {
            if (l == r) {
                min[idx] = arr[l];
                max[idx] = arr[l];
                return;
            }
            int mid = (l + r) / 2;
            build(l, mid, 2 * idx + 1);
            build(mid + 1, r, 2 * idx + 2);
            min[idx] = Math.min(min[2 * idx + 1], min[2 * idx + 2]);
            max[idx] = Math.max(max[2 * idx + 1], max[2 * idx + 2]);
        }

        public int queryMin(int l, int r) {
            return queryMin(0, n - 1, 0, l, r);
        }

        private int queryMin(int segL, int segR, int idx, int l, int r) {
            if (l > segR || r < segL) return Integer.MAX_VALUE;
            if (l <= segL && segR <= r) return min[idx];
            int mid = (segL + segR) / 2;
            int left = queryMin(segL, mid, 2 * idx + 1, l, r);
            int right = queryMin(mid + 1, segR, 2 * idx + 2, l, r);
            return Math.min(left, right);
        }

        public int queryMax(int l, int r) {
            return queryMax(0, n - 1, 0, l, r);
        }

        private int queryMax(int segL, int segR, int idx, int l, int r) {
            if (l > segR || r < segL) return Integer.MIN_VALUE;
            if (l <= segL && segR <= r) return max[idx];
            int mid = (segL + segR) / 2;
            int left = queryMax(segL, mid, 2 * idx + 1, l, r);
            int right = queryMax(mid + 1, segR, 2 * idx + 2, l, r);
            return Math.max(left, right);
        }
    }

    static class PersistentSegTree {
        static class Node {
            int l, r;
            long sum;
            int cnt;
        }

        Node[] nodes;
        int idx;
        int size;

        public PersistentSegTree(int size) {
            this.size = size;
            int maxNode = 20 * 40000;
            nodes = new Node[maxNode];
            idx = 0;
        }

        public int build(int l, int r) {
            int root = newNode();
            if (l == r) {
                return root;
            }
            int mid = (l + r) / 2;
            nodes[root].l = build(l, mid);
            nodes[root].r = build(mid + 1, r);
            return root;
        }

        private int newNode() {
            nodes[idx] = new Node();
            return idx++;
        }

        public int insert(int old, int l, int r, int pos, long val) {
            int root = newNode();
            nodes[root].l = nodes[old].l;
            nodes[root].r = nodes[old].r;
            nodes[root].cnt = nodes[old].cnt + 1;
            nodes[root].sum = nodes[old].sum + val;
            if (l == r) {
                return root;
            }
            int mid = (l + r) / 2;
            if (pos <= mid) {
                nodes[root].l = insert(nodes[old].l, l, mid, pos, val);
            } else {
                nodes[root].r = insert(nodes[old].r, mid + 1, r, pos, val);
            }
            return root;
        }

        public int queryKth(int root1, int root2, int k) {
            return queryKth(root1, root2, 0, size - 1, k);
        }

        private int queryKth(int root1, int root2, int l, int r, int k) {
            if (l == r) return l;
            int mid = (l + r) / 2;
            int leftCnt = nodes[nodes[root1].l].cnt - nodes[nodes[root2].l].cnt;
            if (k <= leftCnt) {
                return queryKth(nodes[root1].l, nodes[root2].l, l, mid, k);
            } else {
                return queryKth(nodes[root1].r, nodes[root2].r, mid + 1, r, k - leftCnt);
            }
        }

        public long[] queryRange(int root1, int root2, int L, int R) {
            return queryRange(root1, root2, 0, size - 1, L, R);
        }

        private long[] queryRange(int root1, int root2, int l, int r, int L, int R) {
            if (L > r || R < l) return new long[]{0, 0};
            if (L <= l && r <= R) {
                return new long[]{
                        nodes[root1].cnt - nodes[root2].cnt,
                        nodes[root1].sum - nodes[root2].sum
                };
            }
            int mid = (l + r) / 2;
            long[] leftRes = queryRange(nodes[root1].l, nodes[root2].l, l, mid, L, R);
            long[] rightRes = queryRange(nodes[root1].r, nodes[root2].r, mid + 1, r, L, R);
            return new long[]{
                    leftRes[0] + rightRes[0],
                    leftRes[1] + rightRes[1]
            };
        }
    }
}
/*
3762. 使数组元素相等的最小操作次数
https://leetcode.cn/problems/minimum-operations-to-equalize-subarrays/description/

第 478 场周赛 T4。

给你一个整数数组 nums 和一个整数 k。
在一次操作中，你可以恰好将 nums 中的某个元素 增加或减少 k 。
还给定一个二维整数数组 queries，其中每个 queries[i] = [li, ri]。
对于每个查询，找到将 子数组 nums[li..ri] 中的 所有 元素变为相等所需的 最小 操作次数。如果无法实现，返回 -1。
返回一个数组 ans，其中 ans[i] 是第 i 个查询的答案。
子数组 是数组中一个连续、非空 的元素序列。
提示：
1 <= n == nums.length <= 4 × 10^4
1 <= nums[i] <= 10^9
1 <= k <= 10^9
1 <= queries.length <= 4 × 10^4
queries[i] = [li, ri]
0 <= li <= ri <= n - 1

持久化线段树。
https://chat.deepseek.com/a/chat/s/c862aa67-0be7-416c-9366-09ff915df41b
问题分析：每次操作只能将元素增加或减少k，因此子数组中的所有元素必须具有相同的模k余数才能通过操作变为相等。否则，无法实现。
关键观察：如果子数组中的所有元素模k余数相同，则问题转化为将每个元素转换为同一值的最小操作次数。这可以通过将每个元素转换为它们的公共值，并计算绝对差之和除以k来实现。
算法选择：
线段树：用于快速查询子数组的最小和最大余数，以检查是否所有元素余数相同。
持久化线段树：用于高效查询子数组中的第k小元素和区间和，以计算最小操作次数。
复杂度分析：
预处理时间为O(n log n)。
每个查询处理时间为O(log n)，适用于大规模数据。
 */