import java.util.Arrays;

public class Ccbft211029T2 {
    public int[] analysisHistogram(int[] heights, int cnt) {
        int len = heights.length;
        Arrays.sort(heights);
        int diff = Integer.MAX_VALUE;
        int[] res = new int[cnt];
        for (int i = 0; i <= len - cnt; i++) {
            if (heights[i + cnt - 1] - heights[i] < diff) {
                System.arraycopy(heights, i, res, 0, cnt);
                diff = heights[i + cnt - 1] - heights[i];
            }
        }
        return res;
    }
}
/*
建信02. 柱状图分析
https://leetcode.cn/contest/ccbft-2021fall/problems/9Rs2aO/

某柱状图上共有 N 个柱形，数组 heights 中按照排列顺序记录了每个柱形的高度。假定任选 cnt 个柱形可组成一个柱形组，
请在所有可能的柱形组中，找出最大高度与最小高度的差值为最小的柱形组，按高度升序返回该柱形组。若存在多个柱形组满足条件，则返回第一个元素最小的柱形组。

示例 1：
输入：heights = [3,2,7,6,1,8], cnt = 3
输出：[1,2,3]
解释：[1,2,3] 与 [6,7,8] 都符合在所有的柱形组中，最大高度与最小高度的差值为最小的条件，选择第一个元素最小的 [1,2,3] 返回。

示例 2：
输入：heights = [4,6,1,8,4,10], cnt = 4
输出：[4,4,6,8]
解释：柱形组 [4,4,6,8] 满足最大高度与最小高度的差值为最小条件。

提示：
2 <= cnt < heights.length <= 10^5
0 <= heights[i] <= 10^6
 */