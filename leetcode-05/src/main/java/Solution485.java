public class Solution485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int cnt = 0;
        for (int num : nums) {
            if (num == 1) {
                cnt++;
                max = Math.max(max, cnt);
            } else {
                cnt = 0;
            }
        }
        return max;
    }
}
/*
485. 最大连续 1 的个数
https://leetcode.cn/problems/max-consecutive-ones/

给定一个二进制数组， 计算其中最大连续 1 的个数。
 */