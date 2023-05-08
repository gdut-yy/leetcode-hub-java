public class SolutionLCP77 {
    private static final int MAX_N = (int) (1e5 + 5);

    public int runeReserve(int[] runes) {
        int[] cnt = new int[MAX_N];
        for (int x : runes) {
            cnt[x]++;
        }

        int sum = 0, max = 0;
        for (int x = 0; x < MAX_N; x++) {
            if (cnt[x] > 0) {
                sum += cnt[x];
                max = Math.max(max, sum);
            } else {
                sum = 0;
            }
        }
        return max;
    }
}
/*
LCP 77. 符文储备
https://leetcode.cn/problems/W2ZX4X/

LCCUP'23 春季战队赛 T1。

远征队在出发前需要携带一些「符文」，作为后续的冒险储备。runes[i] 表示第 i 枚符文的魔力值。
他们将从中选取若干符文进行携带，并对这些符文进行重新排列，以确保任意相邻的两块符文之间的魔力值相差不超过 1。
请返回他们能够携带的符文 最大数量。
提示：
1 <= runes.length <= 10^4
0 <= runes[i] <= 10^4

遍历。贪心。
时间复杂度 O(n)
 */