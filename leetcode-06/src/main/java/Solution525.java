import java.util.HashMap;
import java.util.Map;

public class Solution525 {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> sumToIndex = new HashMap<>();
        sumToIndex.put(0, -1);
        int sum = 0;
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                sum += -1;
            } else {
                sum += 1;
            }
            if (sumToIndex.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - sumToIndex.get(sum));
            } else {
                sumToIndex.put(sum, i);
            }
        }
        return maxLen;
    }
}
/*
525. 连续数组
https://leetcode-cn.com/problems/contiguous-array/

给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
将 0 看成 -1，等价于求最长和为 0 的连续子数组。参考第 560 题实现思路。

时间复杂度 O(n)
空间复杂度 O(n)
 */