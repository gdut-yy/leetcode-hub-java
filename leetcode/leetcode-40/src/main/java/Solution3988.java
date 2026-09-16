import java.util.Arrays;

public class Solution3988 {
    public String[] createGrid(int m, int n, int k) {
        if (m == 1 || n == 1) {
            if (k == 1) {
                String[] grid = new String[m];
                char[] row = new char[n];
                Arrays.fill(row, '.');
                String s = new String(row);
                Arrays.fill(grid, s);
                return grid;
            }
            return new String[0];
        }

        int maxPaths = binomial(m + n - 2, Math.min(m - 1, n - 1));
        if (k > maxPaths) {
            return new String[0];
        }
        if (m < k && n < k) {
            return new String[]{"..#", "...", "#.."};
        }
        if (n >= k) {
            return createRowBased(m, n, k);
        } else {
            return createColumnBased(m, n, k);
        }
    }

    private String[] createRowBased(int m, int n, int k) {
        String[] grid = new String[m];
        char[] row0 = new char[n];
        Arrays.fill(row0, '.');
        grid[0] = new String(row0);
        char[] row1 = new char[n];
        for (int j = 0; j < n; j++) {
            row1[j] = (j >= n - k) ? '.' : '#';
        }
        grid[1] = new String(row1);
        char[] otherRow = new char[n];
        Arrays.fill(otherRow, '#');
        otherRow[n - 1] = '.';
        String otherStr = new String(otherRow);
        for (int i = 2; i < m; i++) {
            grid[i] = otherStr;
        }
        return grid;
    }

    private String[] createColumnBased(int m, int n, int k) {
        String[] grid = new String[m];
        for (int i = 0; i < m; i++) {
            char[] row = new char[n];
            row[0] = '.';
            if (i >= m - k) {
                row[1] = '.';
            } else {
                row[1] = '#';
            }
            for (int j = 2; j < n; j++) {
                row[j] = (i == m - 1) ? '.' : '#';
            }
            grid[i] = new String(row);
        }
        return grid;
    }

    private int binomial(int n, int k) {
        if (k < 0 || k > n) return 0;
        if (k == 0 || k == n) return 1;
        k = Math.min(k, n - k);
        long res = 1;
        for (int i = 0; i < k; i++) {
            res = res * (n - i) / (i + 1);
        }
        return (int) res;
    }
}
/*
3988. 创建一个恰好有 K 条路径的网格图 I
https://leetcode.cn/problems/create-grid-with-exactly-k-paths-i/description/

第 510 场周赛 T3。

给你三个整数 m、n 和 k。
构造一个大小为 m x n 的网格，该网格仅由字符 '.' 和 '#' 组成，其中：
- '.' 表示空单元格。
- '#' 表示障碍物单元格。
一条 有效路径 是满足以下条件的空单元格序列：
- 从左上角的单元格 (0, 0) 开始。
- 在右下角的单元格 (m - 1, n - 1) 结束。
- 只能：
  - 向右移动，从 (i, j) 移动到 (i, j + 1)，或者
  - 向下移动，从 (i, j) 移动到 (i + 1, j)。
返回 任意 一个网格，使得从左上角单元格到右下角单元格 恰好 有 k 条 有效路径。如果不存在这样的网格，则返回一个空数组。
提示：
1 <= m, n <= 10
1 <= k <= 4

构造题。
 */