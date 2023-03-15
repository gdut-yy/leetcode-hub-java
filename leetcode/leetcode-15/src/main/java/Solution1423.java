public class Solution1423 {
    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;
        // 选 k 个相当于去掉 m 个
        int m = len - k;

        int sum = 0;
        int window = 0;
        for (int i = 0; i < m; i++) {
            sum += cardPoints[i];
            window += cardPoints[i];
        }

        int min = window;
        for (int i = m; i < len; i++) {
            sum += cardPoints[i];
            window += cardPoints[i] - cardPoints[i - m];
            min = Math.min(min, window);
        }
        return sum - min;
    }
}
/*
1423. 可获得的最大点数
https://leetcode.cn/problems/maximum-points-you-can-obtain-from-cards/

几张卡牌 排成一行，每张卡牌都有一个对应的点数。点数由整数数组 cardPoints 给出。
每次行动，你可以从行的开头或者末尾拿一张卡牌，最终你必须正好拿 k 张卡牌。
你的点数就是你拿到手中的所有卡牌的点数之和。
给你一个整数数组 cardPoints 和整数 k，请你返回可以获得的最大点数。
提示：
1 <= cardPoints.length <= 10^5
1 <= cardPoints[i] <= 10^4
1 <= k <= cardPoints.length

滑动窗口。由于 "可以从行的开头或者末尾拿一张卡牌"，因此剩下部分是连续的，可以用总和减去这部分，求最大值即可。
 */