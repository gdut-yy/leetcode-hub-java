import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SolutionLCP57 {
    public int getMaximumNumber(int[][] moles) {
        List<int[]> A = new ArrayList<>();
        boolean flag = false;
        for (int[] mole : moles) {
            if (mole[0] == 0) {
                if (mole[1] == 1 && mole[2] == 1) {
                    flag = true;
                }
            } else {
                A.add(mole);
            }
        }
        A.add(new int[]{0, 1, 1});

        int n = A.size();
        A.sort(Comparator.comparingInt(o -> o[0]));
        int[] f = new int[n];
        int[] g = new int[n];
        int ans = 0;
        for (int i = 1; i < n; i++) {
            f[i] = (int) -1e8;
            for (int j = i - 1; j >= 0; j--) {
                int t = A.get(i)[0] - A.get(j)[0];
                int d = Math.abs(A.get(i)[1] - A.get(j)[1]) + Math.abs(A.get(i)[2] - A.get(j)[2]);
                // 能从任何位置移过来，用前缀 max 更新答案
                if (t > 4) {
                    f[i] = Math.max(f[i], g[j] + 1);
                    break;
                }
                // 虽然有时间限制，但移过来能来得及，更新答案
                else if (d <= t) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            ans = Math.max(ans, f[i]);
            g[i] = Math.max(g[i - 1], f[i]);
        }
        return ans + (flag ? 1 : 0);
    }
}
/*
LCP 57. 打地鼠
https://leetcode.cn/problems/ZbAuEH/

LCCUP 力扣杯 2022 春季编程大赛战队赛 T3。

欢迎各位勇者来到力扣城，本次试炼主题为「打地鼠」。
勇者面前有一个大小为 3*3 的打地鼠游戏机，地鼠将随机出现在各个位置，moles[i] = [t,x,y] 表示在第 t 秒会有地鼠出现在 (x,y) 位置上，并于第 t+1 秒该地鼠消失。
勇者有一把可敲打地鼠的锤子，初始时刻（即第 0 秒）锤子位于正中间的格子 (1,1)，锤子的使用规则如下：
- 锤子每经过 1 秒可以往上、下、左、右中的一个方向移动一格，也可以不移动
- 锤子只可敲击所在格子的地鼠，敲击不耗时
请返回勇者最多能够敲击多少只地鼠。
注意：
输入用例保证在相同时间相同位置最多仅有一只地鼠
提示：
1 <= moles.length <= 10^5
moles[i].length == 3
0 <= moles[i][0] <= 10^9
0 <= moles[i][1], moles[i][2] < 3

动态规划 https://leetcode.cn/problems/ZbAuEH/solution/by-tsreaper-ey5v/
 */