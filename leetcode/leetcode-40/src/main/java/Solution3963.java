public class Solution3963 {
    public String[] createGrid(int m, int n) {
        char[][] mat = new char[m][n];
        String[] ans = new String[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = '#';
                if (i == 0 || j == n - 1) mat[i][j] = '.';
            }
            ans[i] = new String(mat[i]);
        }
        return ans;
    }
}
/*
3963. 构造恰好一条路径的网格
https://leetcode.cn/problems/create-grid-with-exactly-one-path/description/

第 185 场双周赛 T1。

给你两个整数 m 和 n，分别表示网格的行数和列数。
请你构造 任意 一个只包含字符 '.' 和 '#' 的 m x n 网格，其中：
- '.' 表示空单元格。
- '#' 表示障碍物单元格。
有效路径 是满足以下条件的空单元格序列：
- 从左上角单元格 (0, 0) 开始。
- 在右下角单元格 (m - 1, n - 1) 结束。
- 只能向：
  - 右移动，从 (i, j) 到 (i, j + 1)，或者
  - 下移动，从 (i, j) 到 (i + 1, j)。
返回任意一个从左上角到右下角 恰好只有一条有效路径 的网格。
提示：
1 <= m, n <= 25

构造。
时间复杂度 O(mn)。
 */