import java.util.ArrayList;
import java.util.List;

public class Solution3417 {
    public List<Integer> zigzagTraversal(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        List<Integer> ans = new ArrayList<>();
        boolean add = true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (add) {
                    if (i % 2 == 0) ans.add(grid[i][j]);
                    else ans.add(grid[i][n - 1 - j]);
                }
                add = !add;
            }
        }
        return ans;
    }
}
/*
3417. 跳过交替单元格的之字形遍历
https://leetcode.cn/problems/zigzag-grid-traversal-with-skip/description/

第 432 场周赛 T1。

给你一个 m x n 的二维数组 grid，数组由 正整数 组成。
你的任务是以 之字形 遍历 grid，同时跳过每个 交替 的单元格。
之字形遍历的定义如下：
- 从左上角的单元格 (0, 0) 开始。
- 在当前行中向 右 移动，直到到达该行的末尾。
- 下移到下一行，然后在该行中向 左 移动，直到到达该行的开头。
- 继续在行间交替向右和向左移动，直到所有行都被遍历完。
注意：在遍历过程中，必须跳过每个 交替 的单元格。
返回一个整数数组 result，其中包含按 顺序 记录的、且跳过交替单元格后的之字形遍历中访问到的单元格值。
提示：
2 <= n == grid.length <= 50
2 <= m == grid[i].length <= 50
1 <= grid[i][j] <= 2500

模拟。
 */