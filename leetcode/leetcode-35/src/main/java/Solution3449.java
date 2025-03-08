public class Solution3449 {
    private int[] points;
    private int m, n;

    public long maxScore(int[] points, int m) {
        this.points = points;
        this.m = m;
        n = points.length;

        long left = 0;
        long right = (long) 1e16;
        while (left < right) {
            long mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (!checkMid(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    private boolean checkMid(long lim) {
        long[] A = new long[n];
        long step = 0;
        for (int i = 0; i < n; i++) {
            if (lim > A[i]) {
                // 第 i 个游戏需要继续加分
                // 在它和第 (i + 1) 个游戏之间反复移动
                long t = lim - A[i];
                t = (t + points[i] - 1) / points[i];
                step += t * 2 - 1;
                // 步数超出限制就即刻退出
                // 否则数据范围可能超出 long long
                if (step > m) return false;
                if (i + 1 < n) A[i + 1] += points[i + 1] * (t - 1);
            } else {
                // 第 i 个游戏不需要继续加分
                // 直接路过，但步数还要算
                // 这里步数可能会超过限制
                // 但是只要右边没有其它需要加分的游戏，就不会返回 false
                step++;
            }
        }
        return true;
    }
}
/*
3449. 最大化游戏分数的最小值
https://leetcode.cn/problems/maximize-the-minimum-game-score/description/

第 436 场周赛 T4。

给你一个长度为 n 的数组 points 和一个整数 m 。同时有另外一个长度为 n 的数组 gameScore ，其中 gameScore[i] 表示第 i 个游戏得到的分数。一开始对于所有的 i 都有 gameScore[i] == 0 。
你开始于下标 -1 处，该下标在数组以外（在下标 0 前面一个位置）。你可以执行 至多 m 次操作，每一次操作中，你可以执行以下两个操作之一：
- 将下标增加 1 ，同时将 points[i] 添加到 gameScore[i] 。
- 将下标减少 1 ，同时将 points[i] 添加到 gameScore[i] 。
注意，在第一次移动以后，下标必须始终保持在数组范围以内。
请你返回 至多 m 次操作以后，gameScore 里面最小值 最大 为多少。
提示：
2 <= n == points.length <= 5 * 10^4
1 <= points[i] <= 10^6
1 <= m <= 10^9

二分答案 + 贪心。
https://leetcode.cn/problems/maximize-the-minimum-game-score/solutions/3068716/er-fen-tan-xin-han-tan-xin-de-zheng-ming-nr32/
时间复杂度 O(nlogU)。
rating 2754 (clist.by)
 */