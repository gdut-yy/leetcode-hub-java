import java.util.Arrays;

public class Solution3531 {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int[] rowMin = new int[n + 1];
        int[] rowMax = new int[n + 1];
        int[] colMin = new int[n + 1];
        int[] colMax = new int[n + 1];
        Arrays.fill(rowMin, n + 1);
        Arrays.fill(colMin, n + 1);

        for (int[] p : buildings) {
            int x = p[0], y = p[1];
            rowMin[y] = Math.min(rowMin[y], x);
            rowMax[y] = Math.max(rowMax[y], x);
            colMin[x] = Math.min(colMin[x], y);
            colMax[x] = Math.max(colMax[x], y);
        }

        int ans = 0;
        for (int[] p : buildings) {
            int x = p[0], y = p[1];
            if (rowMin[y] < x && x < rowMax[y] && colMin[x] < y && y < colMax[x]) {
                ans++;
            }
        }
        return ans;
    }
}
/*
3531. 统计被覆盖的建筑
https://leetcode.cn/problems/count-covered-buildings/description/

第 447 场周赛 T1。

给你一个正整数 n，表示一个 n x n 的城市，同时给定一个二维数组 buildings，其中 buildings[i] = [x, y] 表示位于坐标 [x, y] 的一个 唯一 建筑。
如果一个建筑在四个方向（左、右、上、下）中每个方向上都至少存在一个建筑，则称该建筑 被覆盖 。
返回 被覆盖 的建筑数量。
提示：
2 <= n <= 10^5
1 <= buildings.length <= 10^5
buildings[i] = [x, y]
1 <= x, y <= n
buildings 中所有坐标均 唯一 。

中国时间 2025-04-27 周日 10:30
广州·中肿。术后第3天。五一前的调休工作日。
统计行列的最小值和最大值。
时间复杂度 O(n + m)。
 */