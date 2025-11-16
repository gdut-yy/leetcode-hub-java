import java.util.HashMap;
import java.util.Map;

public class Solution645 {
    public int[] findErrorNums(int[] nums) {
        Map<Integer, Integer> cntMp = new HashMap<>();
        for (int v : nums) {
            cntMp.merge(v, 1, Integer::sum);
        }
        int[] ans = new int[2];
        for (int x = 1; x <= nums.length; x++) {
            Integer c = cntMp.getOrDefault(x, 0);
            if (c == 2) {
                ans[0] = x;
            } else if (c == 0) {
                ans[1] = x;
            }
        }
        return ans;
    }
}
/*
645. 错误的集合
https://leetcode.cn/problems/set-mismatch/

集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
给定一个数组 nums 代表了集合 S 发生错误后的结果。
请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
提示：
2 <= nums.length <= 10^4
1 <= nums[i] <= 10^4

HashMap 统计频次
时间复杂度 O(n)
 */