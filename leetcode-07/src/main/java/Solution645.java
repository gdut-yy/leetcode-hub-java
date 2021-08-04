import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution645 {
    public int[] findErrorNums(int[] nums) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int num : nums) {
            cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
        }
        int[] ans = new int[2];
        for (int i = 1; i <= nums.length; i++) {
            if (cntMap.getOrDefault(i, 0) == 2) {
                ans[0] = i;
            } else if (cntMap.getOrDefault(i, 0) == 0) {
                ans[1] = i;
            }
        }
        return ans;
    }
}
/*
645. 错误的集合
https://leetcode-cn.com/problems/set-mismatch/

cntMap。时间复杂度 O(n)
 */