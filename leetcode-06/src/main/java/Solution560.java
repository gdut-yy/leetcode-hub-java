import java.util.HashMap;
import java.util.Map;

public class Solution560 {
    public int subarraySum2(int[] nums, int k) {
        // 前缀和
        int len = nums.length;
        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        // 枚举连续子数组 时间复杂度 O(n^2)
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if ((preSum[j + 1] - preSum[i]) == k) {
                    res++;
                }
            }
        }
        return res;
    }

    /**
     * 前缀和 + HashMap 优化
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     *
     * @param nums 整数数组
     * @param k    整数 k
     * @return 和为 k 的连续的子数组的个数
     */
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sumToCnt = new HashMap<>();
        sumToCnt.put(0, 1);
        int sum = 0;
        int cnt = 0;
        for (int num : nums) {
            sum += num;
            cnt += sumToCnt.getOrDefault(sum - k, 0);
            sumToCnt.put(sum, sumToCnt.getOrDefault(sum, 0) + 1);
        }
        return cnt;
    }
}
/*
560. 和为K的子数组
https://leetcode-cn.com/problems/subarray-sum-equals-k/

给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。

第 974 题相同题形: https://leetcode-cn.com/problems/subarray-sums-divisible-by-k/
前缀和 + 枚举连续子数组。时间复杂度 O(n^2)
前缀和 + HashMap 优化。时间复杂度 O(n) 空间复杂度 O(n)
 */
