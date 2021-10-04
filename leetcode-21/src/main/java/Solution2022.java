public class Solution2022 {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[][]{};
        }
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = original[i * n + j];
            }
        }
        return res;
    }
}
/*
2022. 将一维数组转变成二维数组
https://leetcode-cn.com/problems/convert-1d-array-into-2d-array/

输入：original = [1,2,3,4], m = 2, n = 2
输出：[[1,2],[3,4]]

第 62 场双周赛 T1。
 */