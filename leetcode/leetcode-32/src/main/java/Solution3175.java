public class Solution3175 {
    public int findWinningPlayer(int[] skills, int k) {
        int n = skills.length;
        int ansI = 0, cnt = 0;
        for (int i = 1; i < n; i++) {
            if (skills[ansI] < skills[i]) {
                cnt = 1;
                ansI = i;
            } else {
                cnt++;
            }
            if (cnt == k) break;
        }
        return ansI;
    }
}
/*
3175. 找到连续赢 K 场比赛的第一位玩家
https://leetcode.cn/problems/find-the-first-player-to-win-k-games-in-a-row/description/

第 132 场双周赛 T2。

有 n 位玩家在进行比赛，玩家编号依次为 0 到 n - 1 。
给你一个长度为 n 的整数数组 skills 和一个 正 整数 k ，其中 skills[i] 是第 i 位玩家的技能等级。skills 中所有整数 互不相同 。
所有玩家从编号 0 到 n - 1 排成一列。
比赛进行方式如下：
- 队列中最前面两名玩家进行一场比赛，技能等级 更高 的玩家胜出。
- 比赛后，获胜者保持在队列的开头，而失败者排到队列的末尾。
这个比赛的赢家是 第一位连续 赢下 k 场比赛的玩家。
请你返回这个比赛的赢家编号。
提示：
n == skills.length
2 <= n <= 10^5
1 <= k <= 10^9
1 <= skills[i] <= 10^6
skills 中的整数互不相同。

时间复杂度 O(n)。
相似题目: 1535. 找出数组游戏的赢家
https://leetcode.cn/problems/find-the-winner-of-an-array-game/
 */