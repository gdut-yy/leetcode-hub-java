public class Solution485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int i = 0, ans = 0;
        while (i < n) {
            // 分组循环
            int st = i;
            for (i++; i < n && nums[i] == nums[i - 1]; i++) {
            }
            if (nums[st] == 1) ans = Math.max(ans, i - st);
        }
        return ans;
    }
}
/*
485. 最大连续 1 的个数
https://leetcode.cn/problems/max-consecutive-ones/

给定一个二进制数组， 计算其中最大连续 1 的个数。
提示：
1 <= nums.length <= 10^5
nums[i] 不是 0 就是 1.

相似题目: $487. 最大连续1的个数 II
https://leetcode.cn/problems/max-consecutive-ones-ii/
1004. 最大连续1的个数 III
https://leetcode.cn/problems/max-consecutive-ones-iii/
 */