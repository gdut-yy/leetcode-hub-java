import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
            // 0 => 2
            // 1 => 7
            // 2 => 11
            // 3 => 15
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            // complement => 9 - 2 = 7
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
/*
1. 两数之和
https://leetcode-cn.com/problems/two-sum/

leetcode 的第一题。签到题。
由于只会存在一个有效答案。因此找到一个满足条件的即可返回。
HashMap O(1) 取值
 */