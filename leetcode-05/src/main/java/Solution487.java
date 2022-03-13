public class Solution487 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int left = 0;
        int leftSum = 0;
        int rightSum = 0;
        int ans = 0;
        for (int right = 0; right < n; right++) {
            rightSum += 1 - nums[right];
            while (leftSum < rightSum - 1) {
                leftSum += 1 - nums[left];
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
/*
$487. 最大连续1的个数 II
https://leetcode-cn.com/problems/max-consecutive-ones-ii/

给定一个二进制数组，你可以最多将 1 个 0 翻转为 1，找出其中最大连续 1 的个数。
提示:
1 <= nums.length <= 10^5
nums[i] 不是 0 就是 1.
进阶：如果输入的数字是作为 无限流 逐个输入如何处理？换句话说，内存不能存储下所有从流中输入的数字。您可以有效地解决吗？
 */