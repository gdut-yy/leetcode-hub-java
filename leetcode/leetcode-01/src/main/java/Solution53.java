public class Solution53 {
    /**
     * 动态规划
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        // dp[i] 代表以第 i 个数结尾的「连续子数组的最大和」
        int[] dp = new int[len];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            // 最大值
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * 动态规划（状态压缩）
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public int maxSubArray2(int[] nums) {
        int dp = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp = nums[i] + Math.max(dp, 0);
            max = Math.max(max, dp);
        }
        return max;
    }

    public int maxSubArray3(int[] nums) {
        DynamicMaxSubarraySum segmentTree = new DynamicMaxSubarraySum(nums);
        return segmentTree.query(1, nums.length);
    }

    private static class DynamicMaxSubarraySum {
        private static class Node {
            // 分别表示 [l,r] 区间：前缀最大子段和，后缀最大子段和，最大子段和，区间和
            int maxL, maxR, maxSum, sum;

            public Node(int maxL, int maxR, int maxSum, int sum) {
                this.maxL = maxL;
                this.maxR = maxR;
                this.maxSum = maxSum;
                this.sum = sum;
            }
        }

        private static final int INF = (int) 1e9;
        private final int[] nums;
        private final int N;
        private final Node[] tree;

        // nums[pos] 修改为 val
        public void modify(int pos, int val) {
            modify(1, N, 1, pos, val);
        }

        // 查询 [l,r] 区间最大子段和
        public int query(int l, int r) {
            return query(1, N, 1, l, r).maxSum;
        }

        public DynamicMaxSubarraySum(int[] nums) {
            this.nums = nums;
            N = nums.length;
            tree = new Node[4 * N];
            for (int i = 0; i < 4 * N; i++) {
                tree[i] = new Node(0, 0, 0, 0);
            }
            build(1, N, 1);
        }

        private void build(int s, int t, int p) {
            if (s == t) {
                int val = nums[s - 1];
                tree[p].maxL = tree[p].maxR = tree[p].maxSum = tree[p].sum = val;
                return;
            }
            int mid = s + (t - s) / 2;
            build(s, mid, p * 2);
            build(mid + 1, t, p * 2 + 1);
            tree[p] = pushUp(tree[p * 2], tree[p * 2 + 1]);
        }

        private Node pushUp(Node l, Node r) {
            int maxL = Math.max(l.maxL, l.sum + r.maxL);
            int maxR = Math.max(r.maxR, r.sum + l.maxR);
            // max(l.maxSum, r.maxSum, l.maxR + r.maxL)
            int maxSum = Math.max(Math.max(l.maxSum, r.maxSum), l.maxR + r.maxL);
            int sum = l.sum + r.sum;
            return new Node(maxL, maxR, maxSum, sum);
        }

        private void modify(int s, int t, int p, int pos, int val) {
            if (s > pos || t < pos) {
                return;
            }
            if (s == pos && t == pos) {
                tree[p].maxL = tree[p].maxR = tree[p].maxSum = tree[p].sum = val;
                return;
            }
            int mid = s + (t - s) / 2;
            modify(s, mid, p * 2, pos, val);
            modify(mid + 1, t, p * 2 + 1, pos, val);
            tree[p] = pushUp(tree[p * 2], tree[p * 2 + 1]);
        }

        private Node query(int s, int t, int p, int l, int r) {
            if (s > r || t < l) {
                return new Node(-INF, -INF, -INF, 0);
            }
            if (l <= s && t <= r) {
                return tree[p];
            }
            int mid = s + (t - s) / 2;
            Node lSub = query(s, mid, p * 2, l, r);
            Node rSub = query(mid + 1, t, p * 2 + 1, l, r);
            return pushUp(lSub, rSub);
        }
    }
}
/*
53. 最大子数组和
https://leetcode.cn/problems/maximum-subarray/

给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
子数组 是数组中的一个连续部分。
提示：
1 <= nums.length <= 10^5
-10^4 <= nums[i] <= 10^4
进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。

动态规划
时间复杂度 O(n)
线段树 时间复杂度 O(nlogn)
相似题目: 152. 乘积最大子数组
https://leetcode.cn/problems/maximum-product-subarray/
918. 环形子数组的最大和
https://leetcode.cn/problems/maximum-sum-circular-subarray/
$1746. 经过一次操作后的最大子数组和
https://leetcode.cn/problems/maximum-subarray-sum-after-one-operation/
H. Gambling
https://codeforces.com/contest/1692/problem/H
 */
