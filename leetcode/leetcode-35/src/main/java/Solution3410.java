import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution3410 {
    public long maxSubarraySum(int[] nums) {
        int n = nums.length;
        Map<Integer, List<Integer>> posMap = new HashMap<>();
        int negCnt = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                posMap.computeIfAbsent(nums[i], e -> new ArrayList<>()).add(i);
                negCnt++;
            }
        }

        MaxSubArraySegTree seg = new MaxSubArraySegTree(nums);
        long ans = seg.query(1, n);
        if (negCnt == n) {
            return ans;
        }
        for (Map.Entry<Integer, List<Integer>> entry : posMap.entrySet()) {
            Integer val = entry.getKey();
            List<Integer> pos = entry.getValue();

            for (Integer idx : pos) seg.modify(idx + 1, 0); // 操作
            ans = Math.max(ans, seg.query(1, n));
            for (Integer idx : pos) seg.modify(idx + 1, val); // 回退
        }
        return ans;
    }

    static class MaxSubArraySegTree {
        Node[] tree;
        static final long INF = (long) 1e18;

        static class Node {
            // 分别表示 [l,r] 区间：前缀最大子段和，后缀最大子段和，最大子段和，区间和
            long maxL, maxR, maxSum, sum;

            public Node(long maxL, long maxR, long maxSum, long sum) {
                this.maxL = maxL;
                this.maxR = maxR;
                this.maxSum = maxSum;
                this.sum = sum;
            }
        }

        int[] nums;
        int n;

        public MaxSubArraySegTree(int[] nums) {
            this.nums = nums;
            this.n = nums.length;
            tree = new Node[4 * n];
            Arrays.setAll(tree, e -> new Node(-INF, -INF, -INF, -INF));
            build(1, 1, n);
        }

        void build(int p, int l, int r) {
            if (l == r) {
                int val = nums[l - 1];
                tree[p].maxL = tree[p].maxR = tree[p].maxSum = tree[p].sum = val;
                return;
            }
            int mid = l + (r - l) / 2;
            build(p << 1, l, mid);
            build(p << 1 | 1, mid + 1, r);
            tree[p] = pushUp(tree[p << 1], tree[p << 1 | 1]);
        }

        // nums[pos] 修改为 val
        void modify(int pos, int val) {
            modify(1, 1, n, pos, val);
        }

        void modify(int p, int l, int r, int pos, int val) {
            if (l > pos || r < pos) {
                return;
            }
            if (l == pos && r == pos) {
                tree[p].maxL = tree[p].maxR = tree[p].maxSum = tree[p].sum = val;
                return;
            }
            int mid = l + (r - l) / 2;
            modify(p << 1, l, mid, pos, val);
            modify(p << 1 | 1, mid + 1, r, pos, val);
            tree[p] = pushUp(tree[p * 2], tree[p * 2 + 1]);
        }

        // 查询 [l,r] 区间最大子段和
        long query(int ql, int qr) {
            return query(1, 1, n, ql, qr).maxSum;
        }

        Node query(int p, int l, int r, int ql, int qr) {
            if (l > qr || r < ql) {
                return new Node(-INF, -INF, -INF, -INF);
            }
            if (ql <= l && r <= qr) {
                return tree[p];
            }
            int mid = l + (r - l) / 2;
            Node ls = query(p << 1, l, mid, ql, qr);
            Node rs = query(p << 1 | 1, mid + 1, r, ql, qr);
            return pushUp(ls, rs);
        }

        Node pushUp(Node ls, Node rs) {
            long maxL = Math.max(ls.maxL, ls.sum + rs.maxL);
            long maxR = Math.max(rs.maxR, rs.sum + ls.maxR);
            // max(l.maxSum, r.maxSum, l.maxR + r.maxL)
            long maxSum = Math.max(Math.max(ls.maxSum, rs.maxSum), ls.maxR + rs.maxL);
            long sum = ls.sum + rs.sum;
            return new Node(maxL, maxR, maxSum, sum);
        }
    }
}
/*
3410. 删除所有值为某个元素后的最大子数组和
https://leetcode.cn/problems/maximize-subarray-sum-after-removing-all-occurrences-of-one-element/description/

第 147 场双周赛 T4。

给你一个整数数组 nums 。
你可以对数组执行以下操作 至多 一次：
- 选择 nums 中存在的 任意 整数 X ，确保删除所有值为 X 的元素后剩下数组 非空 。
- 将数组中 所有 值为 X 的元素都删除。
请你返回 所有 可能得到的数组中 最大 子数组和为多少。
子数组 指的是一个数组中一段连续 非空 的元素序列。
提示：
1 <= nums.length <= 10^5
-10^6 <= nums[i] <= 10^6

相似题目: 2382. 删除操作后的最大子段和
https://leetcode.cn/problems/maximum-segment-sum-after-removals/
H. Gambling
https://codeforces.com/contest/1692/problem/H
rating ? (clist.by)
 */