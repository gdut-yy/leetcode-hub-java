import java.util.Arrays;

public class Solution1838 {
    public int maxFrequency(int[] nums, int k) {
        // 升序排列
        Arrays.sort(nums);

        // 前缀和
        int len = nums.length;
        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        // 双指针
        int ans = 0;
        for (int left = 0, right = 0; right < nums.length; ) {
            int between = right - left + 1;
            // 区间满足条件 是否可在 k 次操作后 “抹平”
            boolean isFlat = nums[right] * between - (preSum[right + 1] - preSum[left]) <= k;
            if (isFlat) {
                ans = Math.max(ans, between);
                right++;
            } else {
                left++;
            }
        }
        return ans;
    }
}
/*
1838. 最高频元素的频数
https://leetcode-cn.com/problems/frequency-of-the-most-frequent-element/

滑动窗口+前缀和。滑动窗口又名“双指针”、“尺取法” 英文为 "two pointers"
 */