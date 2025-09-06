public class Solution3664 {
    public int score(String[] cards, char x) {
        // 统计频次
        int[] x_ = new int[10]; // 'a' 到 'j' 之间
        int[] _x = new int[10];
        int xx = 0;
        for (String s : cards) {
            char c0 = s.charAt(0), c1 = s.charAt(1);
            if (c0 == x && c1 == x) {
                xx++;
            } else if (c0 == x) {
                x_[c1 - 'a']++;
            } else if (c1 == x) {
                _x[c0 - 'a']++;
            }
        }

        int[] res1 = getSumAndMax(x_);
        int[] res2 = getSumAndMax(_x);
        int sum1 = res1[0], max1 = res1[1];
        int sum2 = res2[0], max2 = res2[1];

        int ans = 0;
        // 枚举分配 k 个 xx 给第一组，其余的 xx 给第二组
        for (int k = 0; k <= xx; k++) {
            int score1 = calcScore(sum1, max1, k);
            int score2 = calcScore(sum2, max2, xx - k);
            ans = Math.max(ans, score1 + score2);
        }
        return ans;
    }

    // 计算出现次数之和 sum，出现次数最大值 mxC
    private int[] getSumAndMax(int[] cnt) {
        int sum = 0, mxC = 0;
        for (int c : cnt) {
            sum += c;
            mxC = Math.max(mxC, c);
        }
        return new int[]{sum, mxC};
    }

    // 计算这一组在得到 k 个 xx 后的得分
    private int calcScore(int sum, int mx, int k) {
        sum += k;
        mx = Math.max(mx, k);
        return Math.min(sum / 2, sum - mx);
    }
}
/*
3664. 两个字母卡牌游戏
https://leetcode.cn/problems/two-letter-card-game/description/

第 164 场双周赛 T2。

给你一副由字符串数组 cards 表示的牌，每张牌上都显示两个小写字母。
同时给你一个字母 x。你按照以下规则进行游戏：
- 从 0 分开始。
- 在每一轮中，你必须从牌堆中找到两张 兼容的 牌，这两张牌对应的字符串都包含字母 x。
- 移除这对牌并获得 1 分。
- 当你再也找不到兼容的牌对时，游戏结束。
返回在最优策略下你能获得的 最大 分数。
如果两张牌的字符串在 恰好 1 个位置上不同，则它们是兼容的。
提示:
2 <= cards.length <= 10^5
cards[i].length == 2
每个 cards[i] 仅由 'a' 到 'j' 之间的小写英文字母组成。
x 是一个 'a' 到 'j' 之间的小写英文字母。

枚举。
时间复杂度 O(n + C)。其中 C = 10。
 */