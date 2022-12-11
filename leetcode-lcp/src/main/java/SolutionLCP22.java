public class SolutionLCP22 {
    public int paintingPlan(int n, int k) {
        int[] cnt = new int[n * n + 1];
        if (k == n * n) {
            return 1;
        }
        for (int i = 0; i < (1 << n); i++) {
            int row = Integer.bitCount(i);
            for (int j = 0; j < (1 << n); j++) {
                int col = Integer.bitCount(j);
                int sum = row * n + col * n - row * col;
                cnt[sum]++;
            }
        }
        return cnt[k];
    }
}
/*
LCP 22. 黑白方格画
https://leetcode.cn/problems/ccw6C7/

小扣注意到秋日市集上有一个创作黑白方格画的摊位。摊主给每个顾客提供一个固定在墙上的白色画板，画板不能转动。
画板上有 n * n 的网格。绘画规则为，小扣可以选择任意多行以及任意多列的格子涂成黑色（选择的整行、整列均需涂成黑色），所选行数、列数均可为 0。
小扣希望最终的成品上需要有 k 个黑色格子，请返回小扣共有多少种涂色方案。
注意：两个方案中任意一个相同位置的格子颜色不同，就视为不同的方案。
限制：
1 <= n <= 6
0 <= k <= n * n
 */