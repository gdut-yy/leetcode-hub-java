import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution3394 {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        return check(rectangles, 0) || check(rectangles, 1);
    }

    // op:0 x坐标 op:1 y坐标
    private boolean check(int[][] rectangles, int op) {
        List<int[]> intervals = new ArrayList<>();
        for (int[] p : rectangles) intervals.add(new int[]{p[op], p[op + 2]});
        intervals.sort(Comparator.comparingInt(o -> o[0]));
        List<int[]> ans = new ArrayList<>();
        for (int[] p : intervals) {
            int l = p[0], r = p[1] - 1;
            if (!ans.isEmpty() && l <= ans.getLast()[1]) {
                ans.getLast()[1] = Math.max(ans.getLast()[1], r);
            } else {
                ans.add(new int[]{l, r});
            }
        }
        return ans.size() >= 3;
    }
}
/*
3394. 判断网格图能否被切割成块
https://leetcode.cn/problems/check-if-grid-can-be-cut-into-sections/description/

第 146 场双周赛 T3。

给你一个整数 n 表示一个 n x n 的网格图，坐标原点是这个网格图的左下角。同时给你一个二维坐标数组 rectangles ，其中 rectangles[i] 的格式为 [startx, starty, endx, endy] ，表示网格图中的一个矩形。每个矩形定义如下：
- (startx, starty)：矩形的左下角。
- (endx, endy)：矩形的右上角。
注意 ，矩形相互之间不会重叠。你的任务是判断是否能找到两条 要么都垂直要么都水平 的 两条切割线 ，满足：
- 切割得到的三个部分分别都 至少 包含一个矩形。
- 每个矩形都 恰好仅 属于一个切割得到的部分。
如果可以得到这样的切割，请你返回 true ，否则返回 false 。
提示：
3 <= n <= 10^9
3 <= rectangles.length <= 10^5
0 <= rectangles[i][0] < rectangles[i][2] <= n
0 <= rectangles[i][1] < rectangles[i][3] <= n
矩形之间两两不会有重叠。

相似题目: 56. 合并区间
https://leetcode.cn/problems/merge-intervals/
 */