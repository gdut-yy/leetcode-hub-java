public class Solution45 {
    public int jump(int[] nums) {
        int len = nums.length;
        int max = 0;
        // 贪心
        int end = 0;
        int step = 0;
        for (int i = 0; i < len - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if (i == end) {
                end = max;
                step++;
            }
        }
        return step;
    }
}
/*
45. 跳跃游戏 II
https://leetcode-cn.com/problems/jump-game-ii/

给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
数组中的每个元素代表你在该位置可以跳跃的最大长度。
你的目标是使用最少的跳跃次数到达数组的最后一个位置。
假设你总是可以到达数组的最后一个位置。

贪心。
 */