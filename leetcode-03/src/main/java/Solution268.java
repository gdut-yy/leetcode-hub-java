import java.util.BitSet;

public class Solution268 {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        BitSet bitSet = new BitSet(len + 1);
        for (int num : nums) {
            bitSet.set(num, true);
        }
        return bitSet.nextClearBit(0);
    }
}
/*
268. 丢失的数字
https://leetcode.cn/problems/missing-number/

给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。

BitSet#nextClearBit() 返回第一个设置为 false 的位的索引，这发生在指定的起始索引或之后的索引上。
 */