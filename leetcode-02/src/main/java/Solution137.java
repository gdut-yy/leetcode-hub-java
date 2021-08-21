import java.util.HashMap;
import java.util.Map;

public class Solution137 {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int num : nums) {
            cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
/*
137. 只出现一次的数字 II
https://leetcode-cn.com/problems/single-number-ii/
 */