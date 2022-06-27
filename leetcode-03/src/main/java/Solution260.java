import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution260 {
    /**
     * HashMap
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int num : nums) {
            cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (cntMap.get(num) == 1) {
                list.add(num);
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    /**
     * 位运算
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     */
    public int[] singleNumber2(int[] nums) {
        int xorsum = 0;
        for (int num : nums) {
            xorsum ^= num;
        }
        // 防止溢出
        int lsb = (xorsum == Integer.MIN_VALUE ? xorsum : xorsum & (-xorsum));
        int type1 = 0;
        int type2 = 0;
        for (int num : nums) {
            if ((num & lsb) != 0) {
                type1 ^= num;
            } else {
                type2 ^= num;
            }
        }
        return new int[]{type1, type2};
    }
}
/*
260. 只出现一次的数字 III
https://leetcode.cn/problems/single-number-iii/

给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 */