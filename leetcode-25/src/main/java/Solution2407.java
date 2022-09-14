public class Solution2407 {
    private static final int N = 100000;

    public int lengthOfLIS(int[] nums, int k) {
        DynamicSegTree dynamicSegTree = new DynamicSegTree();
        for (int num : nums) {
            int max = dynamicSegTree.getMax(num - k, num - 1);
            dynamicSegTree.update(num, num, max + 1);
        }
        return dynamicSegTree.getMax(1, N);
    }

    private static class DynamicSegTree {
        private static class Node {
            // 左子树
            Node ls;
            // 右子树
            Node rs;
            // 区间最大值
            int max;
            // 懒标记
            int lazy;
        }

        private final Node root = new Node();

        // 区间更新 [l,r] 置为 val
        void update(int l, int r, int val) {
            this.update(l, r, val, 0, N, root);
        }

        // 区间查询 [l,r] 最大值
        int getMax(int l, int r) {
            return this.getMax(l, r, 0, N, root);
        }

        private void update(int l, int r, int val, int s, int t, Node node) {
            if (l <= s && t <= r) {
                node.max = val;
                node.lazy = val;
                return;
            }
            int mid = s + (t - s) / 2;
            pushDown(node);
            if (l <= mid) {
                update(l, r, val, s, mid, node.ls);
            }
            if (r > mid) {
                update(l, r, val, mid + 1, t, node.rs);
            }
            pushUp(node);
        }

        private int getMax(int l, int r, int s, int t, Node node) {
            if (l <= s && t <= r) {
                return node.max;
            }
            int mid = s + (t - s) / 2;
            pushDown(node);
            int max = 0;
            if (l <= mid) {
                max = Math.max(max, getMax(l, r, s, mid, node.ls));
            }
            if (r > mid) {
                max = Math.max(max, getMax(l, r, mid + 1, t, node.rs));
            }
            return max;
        }

        private void pushDown(Node node) {
            if (node.ls == null) {
                node.ls = new Node();
            }
            if (node.rs == null) {
                node.rs = new Node();
            }
            if (node.lazy > 0) {
                node.ls.max = node.lazy;
                node.rs.max = node.lazy;
                node.ls.lazy = node.lazy;
                node.rs.lazy = node.lazy;
                node.lazy = 0;
            }
        }

        private void pushUp(Node node) {
            node.max = Math.max(node.ls.max, node.rs.max);
        }
    }
}
/*
2407. 最长递增子序列 II
https://leetcode.cn/problems/longest-increasing-subsequence-ii/

第 310 场周赛 T4。

给你一个整数数组 nums 和一个整数 k 。
找到 nums 中满足以下要求的最长子序列：
- 子序列 严格递增
- 子序列中相邻元素的差值 不超过 k 。
请你返回满足上述要求的 最长子序列 的长度。
子序列 是从一个数组中删除部分元素后，剩余元素不改变顺序得到的数组。
提示：
1 <= nums.length <= 10^5
1 <= nums[i], k <= 10^5

LIS 的线段树做法，比赛时只会 O(nlogn) 的 贪心+二分 的解法。然后发现单调栈无法处理这个 k。。
相似题目: 300. 最长递增子序列
https://leetcode.cn/problems/longest-increasing-subsequence/
 */