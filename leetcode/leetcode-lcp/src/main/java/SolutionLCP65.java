import java.util.Arrays;

public class SolutionLCP65 {
    public int unSuitability(int[] operate) {
        int len = operate.length;
        // 答案显然不会超过最大 operate[i] 的 2 倍
        int max = Arrays.stream(operate).max().orElseThrow() * 2 + 1;

        // f[i][j] 表示前 i 个数，最右端点纵坐标与折线图最低端点纵坐标差值为 j 时，折线图最大最小值差值的最小值
        int[][] f = new int[len + 1][max];
        for (int i = 0; i < len + 1; i++) {
            Arrays.fill(f[i], Integer.MAX_VALUE);
        }
        f[0][0] = 0;
        for (int i = 0; i < len; i++) {
            int x = operate[i];
            for (int j = 0; j < max; j++) {
                if (f[i][j] == Integer.MAX_VALUE) {
                    continue;
                }
                if (j + x < max) {
                    f[i + 1][j + x] = Math.min(f[i + 1][j + x], Math.max(f[i][j], j + x));
                }
                if (j >= x) {
                    f[i + 1][j - x] = Math.min(f[i + 1][j - x], f[i][j]);
                } else {
                    f[i + 1][0] = Math.min(f[i + 1][0], f[i][j] - j + x);
                }
            }
        }
        return Arrays.stream(f[len]).min().orElseThrow();
    }
}
/*
LCP 65. 舒适的湿度
https://leetcode.cn/problems/3aqs1c/

LCCUP'22 力扣杯秋季编程大赛个人赛 T5。

力扣嘉年华为了确保更舒适的游览环境条件，在会场的各处设置了湿度调节装置，这些调节装置受控于总控室中的一台控制器。
控制器中已经预设了一些调节指令，整数数组operate[i] 表示第 i 条指令增加空气湿度的大小。现在你可以将任意数量的指令修改为降低湿度（变化的数值不变），以确保湿度尽可能的适宜：
- 控制器会选择 一段连续的指令 ，从而进行湿度调节的操作；
- 这段指令最终对湿度影响的绝对值，即为当前操作的「不适宜度」
- 在控制器所有可能的操作中，最大 的「不适宜度」即为「整体不适宜度」
请返回在所有修改指令的方案中，可以得到的 最小 「整体不适宜度」。
提示：
1 <= operate.length <= 1000
1 <= operate[i] <= 1000

动态规划。
同: https://codeforces.com/contest/1579/problem/G
 */