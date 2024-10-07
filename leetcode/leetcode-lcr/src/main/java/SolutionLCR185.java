import java.util.Arrays;

public class SolutionLCR185 {
    public double[] statisticsProbability(int num) {
        double[] f = new double[6];
        Arrays.fill(f, 1.0 / 6.0);
        for (int i = 2; i <= num; i++) {
            double[] g = new double[5 * i + 1];
            for (int j = 0; j < f.length; j++) {
                for (int k = 0; k < 6; k++) {
                    g[j + k] += f[j] / 6.0;
                }
            }
            f = g;
        }
        return f;
    }
}
/*
LCR 185. 统计结果概率
https://leetcode.cn/problems/nge-tou-zi-de-dian-shu-lcof/

把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
提示：
1 <= n <= 11

dp[i][j] 代表前 i 个骰子的点数和 j 的概率。
滚动数组优化。
https://leetcode.cn/problems/nge-tou-zi-de-dian-shu-lcof/solutions/637778/jian-zhi-offer-60-n-ge-tou-zi-de-dian-sh-z36d/
 */