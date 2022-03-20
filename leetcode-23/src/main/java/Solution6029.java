public class Solution6029 {
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int maxScore = 0;
        int[] res = new int[12];

        // 状态压缩 2^12 = 4096
        for (int state = 0; state < (1 << 12); state++) {
            // bob
            int score = 0;
            int arrows = numArrows;
            int[] bobArrows = new int[12];

            // 贪心，从分值高的开始
            for (int k = 11; k >= 0; k--) {
                // 第 k 位被选中
                if (((state >> k) & 1) == 1) {
                    int needArrows = aliceArrows[k] + 1;
                    // can
                    if (arrows - needArrows >= 0 && k != 0) {
                        arrows -= needArrows;
                        score += k;
                        bobArrows[k] = needArrows;
                    } else {
                        bobArrows[k] = arrows;
                        arrows = 0;
                    }
                }
                if (score >= maxScore) {
                    maxScore = score;
                    res = bobArrows;
                }
            }
        }
        return res;
    }
}
/*
6029. 射箭比赛中的最大得分
https://leetcode-cn.com/problems/maximum-points-in-an-archery-competition/

第 285 场周赛 T3。

Alice 和 Bob 是一场射箭比赛中的对手。比赛规则如下：
1.Alice 先射 numArrows 支箭，然后 Bob 也射 numArrows 支箭。
2.分数按下述规则计算：
 1.箭靶有若干整数计分区域，范围从 0 到 11 （含 0 和 11）。
 2.箭靶上每个区域都对应一个得分 k（范围是 0 到 11），Alice 和 Bob 分别在得分 k 区域射中 ak 和 bk 支箭。
 如果 ak >= bk ，那么 Alice 得 k 分。如果 ak < bk ，则 Bob 得 k 分
 3.如果 ak == bk == 0 ，那么无人得到 k 分。
- 例如，Alice 和 Bob 都向计分为 11 的区域射 2 支箭，那么 Alice 得 11 分。如果 Alice 向计分为 11 的区域射 0 支箭，但 Bob 向同一个区域射 2 支箭，那么 Bob 得 11 分。
给你整数 numArrows 和一个长度为 12 的整数数组 aliceArrows ，该数组表示 Alice 射中 0 到 11 每个计分区域的箭数量。现在，Bob 想要尽可能 最大化 他所能获得的总分。
返回数组 bobArrows ，该数组表示 Bob 射中 0 到 11 每个 计分区域的箭数量。且 bobArrows 的总和应当等于 numArrows 。
如果存在多种方法都可以使 Bob 获得最大总分，返回其中 任意一种 即可。
提示：
1 <= numArrows <= 10^5
aliceArrows.length == bobArrows.length == 12
0 <= aliceArrows[i], bobArrows[i] <= numArrows
sum(aliceArrows[i]) == numArrows

状态压缩，bob 得分组合只有 2^12 = 4096 种可能，全部枚举一次即可。
 */