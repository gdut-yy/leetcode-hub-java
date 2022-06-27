import java.util.HashMap;
import java.util.Map;

public class Solution523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int len = nums.length;
        if (len < 2) {
            return false;
        }
        // 同余定理
        Map<Integer, Integer> remainderIdxMap = new HashMap<>();
        remainderIdxMap.put(0, -1);
        int remainder = 0;
        for (int i = 0; i < len; i++) {
            remainder = (remainder + nums[i]) % k;
            if (!remainderIdxMap.containsKey(remainder)) {
                remainderIdxMap.put(remainder, i);
            } else if (i - remainderIdxMap.get(remainder) > 1) {
                return true;
            }
        }
        return false;
    }
}
/*
523. 连续的子数组和
https://leetcode.cn/problems/continuous-subarray-sum/

给你一个整数数组 nums 和一个整数  k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
子数组大小 至少为 2 ，且
子数组元素总和为 k 的倍数。
如果存在，返回 true ；否则，返回 false 。
如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。0 始终视为 k 的一个倍数。

同余定理。
相似题目: 974. 和可被 K 整除的子数组
https://leetcode.cn/problems/subarray-sums-divisible-by-k/
 */