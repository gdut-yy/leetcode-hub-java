public class SolutionLCR121 {
    public boolean findTargetIn2DPlants(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;

        // 矩阵左下角开始
        int x = m - 1, y = 0;
        while (x >= 0 && y < n) {
            if (matrix[x][y] > target) {
                x--;
            } else if (matrix[x][y] < target) {
                y++;
            } else {
                return true;
            }
        }
        return false;
    }
}
/*
LCR 121. 寻找目标值 - 二维数组
https://leetcode.cn/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/description/

m*n 的二维数组 plants 记录了园林景观的植物排布情况，具有以下特性：
- 每行中，每棵植物的右侧相邻植物不矮于该植物；
- 每列中，每棵植物的下侧相邻植物不矮于该植物。
请判断 plants 中是否存在目标高度值 target。
提示：
0 <= n <= 1000
0 <= m <= 1000

同: 240. 搜索二维矩阵 II
https://leetcode.cn/problems/search-a-2d-matrix-ii/
 */