public class SolutionLCR166 {
    public int jewelleryValue(int[][] frame) {
        int m = frame.length;
        int n = frame[0].length;

        // f[i][j] 表示到达 grid[i][j] 礼物的最大价值
        int[][] f = new int[m][n];

        // 初始状态 第一行 + 第一列
        f[0][0] = frame[0][0];
        for (int i = 1; i < m; i++) {
            f[i][0] = f[i - 1][0] + frame[i][0];
        }
        for (int j = 1; j < n; j++) {
            f[0][j] = f[0][j - 1] + frame[0][j];
        }

        // 状态转移
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]) + frame[i][j];
            }
        }
        return f[m - 1][n - 1];
    }
}
/*
LCR 166. 珠宝的最高价值
https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof/

现有一个记作二维矩阵 frame 的珠宝架，其中 frame[i][j] 为该位置珠宝的价值。拿取珠宝的规则为：
- 只能从架子的左上角开始拿珠宝
- 每次可以移动到右侧或下侧的相邻位置
- 到达珠宝架子的右下角时，停止拿取
注意：珠宝的价值都是大于 0 的。除非这个架子上没有任何珠宝，比如 frame = [[0]]。
提示：
0 < frame.length <= 200
0 < frame[0].length <= 200

注意最大和最小的区别
相似题目: 64. 最小路径和
https://leetcode.cn/problems/minimum-path-sum/
 */