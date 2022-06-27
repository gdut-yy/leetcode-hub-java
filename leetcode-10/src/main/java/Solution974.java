import java.util.HashMap;
import java.util.Map;

public class Solution974 {
    public int subarraysDivByK(int[] nums, int k) {
        // 根据同余定理，只需 preSum[j + 1] % k == preSum[i] % k 即可，时间复杂度降低为 O(n)
        Map<Integer, Integer> modCntMap = new HashMap<>();
        // 前缀和
        int len = nums.length;
        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        modCntMap.put(0, 1);
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
            // 避免负数
            int mod = (preSum[i + 1] % k + k) % k;
            modCntMap.put(mod, modCntMap.getOrDefault(mod, 0) + 1);
        }
        // 根据排列组合公式进行统计
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : modCntMap.entrySet()) {
            ans += entry.getValue() * (entry.getValue() - 1) / 2;
        }
        return ans;
    }
}
/*
974. 和可被 K 整除的子数组
https://leetcode.cn/problems/subarray-sums-divisible-by-k/

第 119 场周赛 T3。

给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。

与第 560 题如出一辙: https://leetcode.cn/problems/subarray-sum-equals-k/
很自然想到 前缀和 + 枚举连续子数组的方法，但其时间复杂度 O(n^2) 方法本题会超时
可根据数论同余定理，只需 preSum[j + 1] % k == preSum[i] % k 即可，时间复杂度降低为 O(n)
根据排列组合公式统计组合数
 */