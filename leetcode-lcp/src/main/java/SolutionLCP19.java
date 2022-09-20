public class SolutionLCP19 {
    public int minimumOperations(String leaves) {
        int len = leaves.length();

        // 状态定义
        // f[i][0] 表示将 i y=>r (只能由 f[i-1][0] 转移)
        // f[i][1] 表示将 i r=>y (由 f[i-1][0], f[i-1][1] 转移)
        // f[i][2] 表示将 i y=>r (由 f[i-1][1], f[i-1][2] 转移)
        int[][] f = new int[len][3];
        // 初始状态
        f[0][0] = leaves.charAt(0) == 'r' ? 0 : 1;
        f[0][1] = Integer.MAX_VALUE;
        f[0][2] = Integer.MAX_VALUE;
        f[1][2] = Integer.MAX_VALUE;
        // 状态转移
        for (int i = 1; i < len; i++) {
            int isRed = leaves.charAt(i) == 'r' ? 1 : 0;
            int isYellow = leaves.charAt(i) == 'y' ? 1 : 0;
            f[i][0] = f[i - 1][0] + isYellow;
            f[i][1] = Math.min(f[i - 1][0], f[i - 1][1]) + isRed;
            if (i >= 2) {
                // ryr
                f[i][2] = Math.min(f[i - 1][1], f[i - 1][2]) + isYellow;
            }
        }
        return f[len - 1][2];
    }
}
/*
LCP 19. 秋叶收藏集
https://leetcode.cn/problems/UlBDOe/

小扣出去秋游，途中收集了一些红叶和黄叶，他利用这些叶子初步整理了一份秋叶收藏集 leaves，
字符串 leaves 仅包含小写字符 r 和 y， 其中字符 r 表示一片红叶，字符 y 表示一片黄叶。
出于美观整齐的考虑，小扣想要将收藏集中树叶的排列调整成「红、黄、红」三部分。每部分树叶数量可以不相等，但均需大于等于 1。
每次调整操作，小扣可以将一片红叶替换成黄叶或者将一片黄叶替换成红叶。请问小扣最少需要多少次调整操作才能将秋叶收藏集调整完毕。
提示：
3 <= leaves.length <= 10^5
leaves 中只包含字符 'r' 和字符 'y'

动态规划。
 */