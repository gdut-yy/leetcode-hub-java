import java.util.HashMap;
import java.util.Map;

public class Solution3381 {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long sum = 0;
        long ans = Long.MIN_VALUE;
        Map<Integer, Long> mp = new HashMap<>();
        mp.put(0, 0L);
        for (int i = 0; i < n; i++) {
            int key = (i + 1) % k;
            sum += nums[i];
            if (mp.containsKey(key)) {
                ans = Math.max(ans, sum - mp.get(key));
            }
            mp.merge(key, sum, Long::min);
        }
        return ans;
    }
}
/*
3381. 长度可被 K 整除的子数组的最大元素和
https://leetcode.cn/problems/maximum-subarray-sum-with-length-divisible-by-k/description/

第 427 场周赛 T3。

给你一个整数数组 nums 和一个整数 k 。
返回 nums 中一个 非空子数组 的 最大 和，要求该子数组的长度可以 被 k 整除。
提示：
1 <= k <= nums.length <= 2 * 10^5
-10^9 <= nums[i] <= 10^9

哈希表。枚举右维护左。
时间复杂度 O(n)。
 */