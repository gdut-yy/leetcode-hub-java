import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution2461 {
    public long maximumSubarraySum(int[] nums, int k) {
        int len = nums.length;

        // 前缀和
        long[] preSum = new long[len + 1];
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        long max = 0L;

        Map<Integer, Integer> cntMap = new HashMap<>();
        // >1
        Set<Integer> gt1Set = new HashSet<>();
        // 前 k 个 [0,k-1]
        for (int i = 0; i < k; i++) {
            cntMap.put(nums[i], cntMap.getOrDefault(nums[i], 0) + 1);
            if (cntMap.get(nums[i]) > 1) {
                gt1Set.add(nums[i]);
            }
        }
        if (gt1Set.isEmpty()) {
            max = Math.max(max, preSum[k]);
        }

        // [i-k+1,i]
        for (int i = k; i < len; i++) {
            int add = nums[i];
            cntMap.put(add, cntMap.getOrDefault(add, 0) + 1);
            if (cntMap.get(add) > 1) {
                gt1Set.add(add);
            }

            int del = nums[i - k];
            cntMap.put(del, cntMap.getOrDefault(del, 0) - 1);
            if (cntMap.get(del) <= 1) {
                gt1Set.remove(del);
            }

            if (gt1Set.isEmpty()) {
                max = Math.max(max, preSum[i + 1] - preSum[i - k + 1]);
            }
        }
        return max;
    }
}
/*
2461. 长度为 K 子数组中的最大和
https://leetcode.cn/problems/maximum-sum-of-distinct-subarrays-with-length-k/

第 318 场周赛 T2。

给你一个整数数组 nums 和一个整数 k 。请你从 nums 中满足下述条件的全部子数组中找出最大子数组和：
- 子数组的长度是 k，且
- 子数组中的所有元素 各不相同 。
返回满足题面要求的最大子数组和。如果不存在子数组满足这些条件，返回 0 。
子数组 是数组中一段连续非空的元素序列。
提示：
1 <= k <= nums.length <= 10^5
1 <= nums[i] <= 10^5

滑动窗口。需要做到 O(1) 时间复杂度判断窗口内有无重复元素
时间复杂度 O(n)
 */