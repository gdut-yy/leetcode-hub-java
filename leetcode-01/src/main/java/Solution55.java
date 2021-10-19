public class Solution55 {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int max = 0;
        for (int i = 0; i < len; i++) {
            if (i <= max) {
                max = Math.max(max, i + nums[i]);
                if (max >= len - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
/*
55. 跳跃游戏
https://leetcode-cn.com/problems/jump-game/

给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
数组中的每个元素代表你在该位置可以跳跃的最大长度。
判断你是否能够到达最后一个下标。

贪心。
 */