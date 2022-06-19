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
        int pre = 0;
        int maxAns = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    // 线段树 时间复杂度 O(n)
    public int maxSubArray3(int[] nums) {
        SegmentTree segmentTree = new SegmentTree(nums);
        return (int) segmentTree.query(0, nums.length - 1).maxSum;
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

        private final int[] a;

        public SegmentTree(int[] nums) {
            a = nums;
        }

        private Node pushUp(Node a, Node b) {
            long lSum = Math.max(a.lSum, a.itSum + b.lSum);
            long rSum = Math.max(b.rSum, b.itSum + a.rSum);
            long maxSum = Math.max(Math.max(a.maxSum, b.maxSum), a.rSum + b.lSum);
            long itSum = a.itSum + b.itSum;
            return new Node(lSum, rSum, maxSum, itSum);
        }

        private Node query(int s, int t) {
            if (s == t) {
                return new Node(a[s], a[s], a[s], a[s]);
            }
            int mid = s + (t - s) / 2;
            Node lSub = query(s, mid);
            Node rSub = query(mid + 1, t);
            return pushUp(lSub, rSub);
        }
    }
}
/*
53. 最大子序和
https://leetcode-cn.com/problems/maximum-subarray/

给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
提示：
1 <= nums.length <= 10^5
-10^4 <= nums[i] <= 10^4
进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。

动态规划
时间复杂度 O(n)
空间复杂度 O(1)
也可以使用线段树，参考官方题解:
https://leetcode-cn.com/problems/maximum-subarray/solution/zui-da-zi-xu-he-by-leetcode-solution/
相似题目: 152. 乘积最大子数组
https://leetcode-cn.com/problems/maximum-product-subarray/
$1746. 经过一次操作后的最大子数组和
https://leetcode-cn.com/problems/maximum-subarray-sum-after-one-operation/
 */
