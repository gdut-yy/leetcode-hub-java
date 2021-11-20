public class Solution918 {
    public int maxSubarraySumCircular(int[] nums) {
        // 求和
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int len = nums.length;
        // [0:len-1]
        int ans1 = kadane(nums, 0, len - 1, 1);
        // [1:len-1]
        int ans2 = sum + kadane(nums, 1, len - 1, -1);
        // [0:len-2]
        int ans3 = sum + kadane(nums, 0, len - 2, -1);
        return Math.max(ans1, Math.max(ans2, ans3));
    }

    private int kadane(int[] sum, int i, int j, int sign) {
        // The maximum non-empty subarray for array
        // [sign * A[i], sign * A[i+1], ..., sign * A[j]]
        int ans = Integer.MIN_VALUE / 2;
        int cur = Integer.MIN_VALUE / 2;
        for (int k = i; k <= j; k++) {
            cur = sign * sum[k] + Math.max(cur, 0);
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}
/*
918. 环形子数组的最大和
https://leetcode-cn.com/problems/maximum-sum-circular-subarray/

第 105 场周赛 T2。

给定一个由整数数组 A 表示的环形数组 C，求 C 的非空子数组的最大可能和。
在此处，环形数组意味着数组的末端将会与开头相连呈环状。
（形式上，当0 <= i < A.length 时 C[i] = A[i]，且当 i >= 0 时 C[i+A.length] = C[i]）
此外，子数组最多只能包含固定缓冲区 A 中的每个元素一次。
（形式上，对于子数组 C[i], C[i+1], ..., C[j]，不存在 i <= k1, k2 <= j 其中 k1 % A.length = k2 % A.length）

连续子数组最大和。Kanade 算法。
https://leetcode-cn.com/problems/maximum-sum-circular-subarray/solution/huan-xing-zi-shu-zu-de-zui-da-he-by-leetcode/
时间复杂度 O(n)
空间复杂度 O(1)
 */