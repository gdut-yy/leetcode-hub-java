import java.util.HashMap;
import java.util.Map;

public class Solution6293 {
    public long countGood(int[] nums, int k) {
        int len = nums.length;
        Map<Integer, Integer> cntMap = new HashMap<>();
        long sum = 0;
        long res = 0;
        int right = 0;
        for (int left : nums) {
            // 右指针右移
            while (sum < k && right < len) {
                // 频次是 x
                int x = cntMap.getOrDefault(nums[right], 0);
                cntMap.put(nums[right], x + 1);
                right++;
                sum += x;
            }
            if (sum < k) {
                break;
            }
            res += len - right + 1;

            // 频次是 y
            int y = cntMap.get(left);
            cntMap.put(left, y - 1);
            sum -= y - 1;
        }
        return res;
    }
}
/*
6293. 统计好子数组的数目
https://leetcode.cn/problems/count-the-number-of-good-subarrays/

第 328 场周赛 T3。

给你一个整数数组 nums 和一个整数 k ，请你返回 nums 中 好 子数组的数目。
一个子数组 arr 如果有 至少 k 对下标 (i, j) 满足 i < j 且 arr[i] == arr[j] ，那么称它是一个 好 子数组。
子数组 是原数组中一段连续 非空 的元素序列。
提示：
1 <= nums.length <= 10^5
1 <= nums[i], k <= 10^9

双指针（滑动窗口）
时间复杂度 O(n)
 */