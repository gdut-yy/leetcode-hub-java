public class Solution3847 {
    public int scoreDifference(int[] nums) {
        int[] score = new int[2];
        int active = 0; // 主动玩家一开始是第一位玩家
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            active ^= x % 2; // 如果 x 是奇数，主动玩家换人
            if (i % 6 == 5) {
                active ^= 1; // 主动玩家换人
            }
            score[active] += x;
        }
        return score[0] - score[1];
    }
}
/*
3847. 计算比赛分数差
https://leetcode.cn/problems/find-the-score-difference-in-a-game/description/

第 490 场周赛 T1。

给你一个整数数组 nums，其中 nums[i] 表示在第 i 场比赛中获得的分数。
恰好 有两位玩家。初始时，第一位玩家为 主动玩家，第二位玩家为 被动玩家。
按顺序 将下述规则应用于每场比赛 i：
- 如果 nums[i] 是奇数，主动玩家和被动玩家互换角色。
- 在每第 6 场比赛（即比赛索引为 5, 11, 17, ... 的比赛中），主动玩家和被动玩家互换角色。
- 主动玩家参与第 i 场比赛，并获得 nums[i] 分。
返回 分数差，即第一位玩家的 总分 减去第二位玩家的 总分 。
提示：
1 <= nums.length <= 1000
1 <= nums[i] <= 1000

中国时间 2026-02-22 周日 10:30
佛山。春节假期倒数第二天。
模拟。
时间复杂度 O(n)。
 */