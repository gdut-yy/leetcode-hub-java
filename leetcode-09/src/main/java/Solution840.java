public class Solution840 {
    public int numMagicSquaresInside(int[][] grid) {
        int gridM = grid.length;
        int gridN = grid[0].length;
        if (gridM < 3 || gridN < 3) {
            return 0;
        }
        int cnt = 0;
        // 枚举 3 x 3 矩阵中心点是否为 5
        for (int i = 1; i < gridM - 1; i++) {
            for (int j = 1; j < gridN - 1; j++) {
                // 矩阵中心不是 5 的就不用看了
                if (grid[i][j] == 5) {
                    int[] nums = {
                            grid[i - 1][j - 1], grid[i - 1][j], grid[i - 1][j + 1],
                            grid[i][j - 1], grid[i][j], grid[i][j + 1],
                            grid[i + 1][j - 1], grid[i + 1][j], grid[i + 1][j + 1]
                    };
                    if (isMagicSquares(nums)) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    /**
     * num0 num1 num2
     * num3 num4 num5
     * num6 num7 num8
     *
     * @param nums 3 x 3 矩阵对应的一维数组
     * @return 是否满足幻方矩阵
     */
    private boolean isMagicSquares(int[] nums) {
        for (int i = 0; i < 9; i++) {
            // 除矩阵中心外不能有 5（9 个 5 的用例）
            if (nums[i] == 5 && i != 4) {
                return false;
            }
            // 从 1 到 9
            if (nums[i] < 1 || nums[i] > 9) {
                return false;
            }
        }
        // 行相等
        boolean equalM = (nums[0] + nums[1] + nums[2] == 15)
                && (nums[3] + nums[4] + nums[5] == 15)
                && (nums[6] + nums[7] + nums[8] == 15);
        // 列相等
        boolean equalN = (nums[0] + nums[3] + nums[6] == 15)
                && (nums[1] + nums[4] + nums[7] == 15)
                && (nums[2] + nums[5] + nums[8] == 15);
        // 对角线相等
        boolean equalDiagonal = (nums[0] + nums[4] + nums[8] == 15)
                && (nums[2] + nums[4] + nums[6] == 15);
        return equalM && equalN && equalDiagonal;
    }
}
/*
840. 矩阵中的幻方
https://leetcode-cn.com/problems/magic-squares-in-grid/

第 86 场周赛签到题。
3 x 3 的幻方是一个填充有从 1 到 9 的不同数字的 3 x 3 矩阵，其中每行，每列以及两条对角线上的各数之和都相等。
易通过数学知识得知 矩阵中心点 数值为 5，需注意剔除不满足的题意用例
 */