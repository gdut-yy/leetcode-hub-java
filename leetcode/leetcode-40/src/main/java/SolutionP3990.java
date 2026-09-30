import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionP3990 {
    // https://leetcode.cn/problems/create-grid-with-exactly-k-paths-ii/solutions/3995387/gou-zao-ti-by-endlesscheng-r1ve/
    public List<String> createGrid(int k) {
        int w = 32 - Integer.numberOfLeadingZeros(k);
        int m = w * 2;
        int n = w + 3;

        char[][] a = new char[m][n];
        for (char[] row : a) {
            Arrays.fill(row, '#');
            row[n - 1] = '.';
        }

        for (int j = 0; j < w; j++) {
            int i = j * 2;
            a[i][j] = a[i][j + 1] = a[i + 1][j] = a[i + 1][j + 1] = '.';
        }

        for (int i = 0; i < w; i++) {
            if ((k >> i & 1) > 0) {
                for (int j = i + 2; j < n - 1; j++) {
                    a[i * 2][j] = '.';
                }
            }
        }

        List<String> ans = new ArrayList<>(m);
        for (char[] row : a) {
            ans.add(new String(row));
        }
        return ans;
    }
}
/*
$3990. 创建一个恰好有 K 条路径的网格图 II
https://leetcode.cn/problems/create-grid-with-exactly-k-paths-ii/description/

给定一个整数 k。
构建一个仅由字符 '.' 和 '#' 组成的网格，其中：
- '.' 表示一个空闲单元格。
- '#' 表示一个障碍单元格。
网格 最多 包含 25 行和 25 列。
有效路径 是一系列空闲单元格，满足：
- 从左上角单元格 (0, 0) 开始。
- 终点位于右下角单元格 (m - 1, n - 1)，其中 m 和 n 是你构建的网格的尺寸。
- 移动方式只允许：
  - 向右, 从 (i, j) 到 (i, j + 1)，或
  - 向下，从 (i, j) 到 (i + 1, j)。
返回任意一个网格，使得从左上角单元格到右下角单元格 恰好有 k 条有效路径。如果不存在这样的网格，则返回一个空数组。
示例 1：
输入：k = 2
输出：["..#","#..","#.."]
示例 2：
输入：k = 3
输出：["...","#..","#.."]
提示：
1 <= k <= 1000

相似题目: 3988. 创建一个恰好有 K 条路径的网格图 I
https://leetcode.cn/problems/create-grid-with-exactly-k-paths-i/description/
 */