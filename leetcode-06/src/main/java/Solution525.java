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

时间复杂度 O(n)
空间复杂度 O(n)
 */