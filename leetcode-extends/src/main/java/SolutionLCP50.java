public class SolutionLCP50 {
    public int giveGem(int[] gem, int[][] operations) {
        for (int[] operation : operations) {
            int from = operation[0];
            int to = operation[1];

            int half = gem[from]/2;
            gem[from] -= half;
            gem[to] += half;
        }
        int min = gem[0];
        int max = gem[0];
        for (int i : gem) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        return max - min;
    }
}
/*
LCP 50. 宝石补给
https://leetcode-cn.com/problems/WHnhjV/

LCCUP 力扣杯 2022 春季编程大赛个人赛 T1。

欢迎各位勇者来到力扣新手村，在开始试炼之前，请各位勇者先进行「宝石补给」。
每位勇者初始都拥有一些能量宝石， gem[i] 表示第 i 位勇者的宝石数量。现在这些勇者们进行了一系列的赠送，
operations[j] = [x, y] 表示在第 j 次的赠送中 第 x 位勇者将自己一半的宝石（需向下取整）赠送给第 y 位勇者。
在完成所有的赠送后，请找到拥有最多宝石的勇者和拥有最少宝石的勇者，并返回他们二者的宝石数量之差。
注意：
赠送将按顺序逐步进行。
提示：
2 <= gem.length <= 10^3
0 <= gem[i] <= 10^3
0 <= operations.length <= 10^4
operations[i].length == 2
0 <= operations[i][0], operations[i][1] < gem.length

简单模拟。
 */