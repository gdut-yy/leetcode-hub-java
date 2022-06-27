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
https://leetcode.cn/problems/set-mismatch/

集合 s 包含从 1 到 n 的整数。丢失了一个数字 并且 有一个数字重复。
找出重复出现的整数, 再找到丢失的整数, 将它们以数组的形式返回。

cntMap。时间复杂度 O(n)
 */