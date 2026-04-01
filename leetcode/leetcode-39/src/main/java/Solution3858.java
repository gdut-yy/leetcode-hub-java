public class Solution3858 {
    public int minimumOR(int[][] grid) {
        int mask = 0;
        int ans = 0;
        for (int bit = 16; bit >= 0; bit--) {
            boolean possible = true;
            for (int[] row : grid) {
                boolean found = false;
                for (int num : row) {
                    if ((num & mask) == 0 && ((num >> bit) & 1) == 0) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    possible = false;
                    break;
                }
            }
            if (possible) {
                mask |= (1 << bit);
            } else {
                ans |= (1 << bit);
            }
        }
        return ans;
    }
}
/*
3858. 按位或的最小值
https://leetcode.cn/problems/minimum-bitwise-or-from-grid/description/

第 491 场周赛 T3。

给你一个大小为 m x n 的二维整数数组 grid。
你必须从 grid 的每一行中 选择恰好一个整数。
返回一个整数，表示从每行中选出的整数的 按位或（bitwise OR）的 最小可能值。
提示：
1 <= m == grid.length <= 10^5
1 <= n == grid[i].length <= 10^5
m * n <= 10^5
1 <= grid[i][j] <= 10^5

试填法。
时间复杂度 O(mnlogU)，其中 m 和 n 分别是 grid 的行数和列数，U 是所有 grid[i][j] 中的最大值。
 */