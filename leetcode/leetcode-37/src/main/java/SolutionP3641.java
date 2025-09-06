import java.util.Arrays;

public class SolutionP3641 {
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = 0, repeat = 0, ans = 0;
        int[] cnt = new int[Arrays.stream(nums).max().orElseThrow() + 1];
        while (r < n) {
            if (++cnt[nums[r]] == 2) repeat++;
            while (repeat > k) {
                if (--cnt[nums[l]] == 1) repeat--;
                l++;
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
}
/*
$3641. 最长半重复子数组
https://leetcode.cn/problems/longest-semi-repeating-subarray/description/

给定一个长度为 n 的整数数组 nums 和一个整数 k。
半重复 子数组是指最多有 k 个元素重复（即出现超过一次）的连续子数组。
返回 nums 中最长 半重复 子数组的长度。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^5
0 <= k <= nums.length

双指针。
时间复杂度 O(n)。
 */