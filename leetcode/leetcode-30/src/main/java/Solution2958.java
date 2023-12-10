import java.util.HashMap;
import java.util.Map;

public class Solution2958 {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> cntMap = new HashMap<>();
        int l = 0, r = 0;
        int ans = 0;
        // 频次超过 k 的数目
        int gt_cnt = 0;
        while (r < n) {
            if (cntMap.getOrDefault(nums[r], 0) == k) gt_cnt++;
            cntMap.put(nums[r], cntMap.getOrDefault(nums[r], 0) + 1);

            while (gt_cnt > 0) {
                cntMap.put(nums[l], cntMap.get(nums[l]) - 1);
                if (cntMap.get(nums[l]) == k) gt_cnt--;
                l++;
            }
            ans = Math.max(ans, r - l + 1);

            r++;
        }
        return ans;
    }
}
/*
2958. 最多 K 个重复元素的最长子数组
https://leetcode.cn/problems/length-of-longest-subarray-with-at-most-k-frequency/description/

第 119 场双周赛 T3。

给你一个整数数组 nums 和一个整数 k 。
一个元素 x 在数组中的 频率 指的是它在数组中的出现次数。
如果一个数组中所有元素的频率都 小于等于 k ，那么我们称这个数组是 好 数组。
请你返回 nums 中 最长好 子数组的长度。
子数组 指的是一个数组中一段连续非空的元素序列。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
1 <= k <= nums.length

滑动窗口
时间复杂度 O(n)
 */