public class Solution3898 {
    public int[] findDegrees(int[][] matrix) {
        int n = matrix.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            for (int x : matrix[i]) {
                ans[i] += x;
            }
        }
        return ans;
    }
}
/*
3898. 统计每个顶点的度
https://leetcode.cn/problems/find-the-degree-of-each-vertex/description/

第 497 场周赛 T1。

给你一个大小为 n x n 的二维整数数组 matrix，以邻接矩阵形式表示一个 无向图。该图包含 n 个顶点，编号从 0 到 n - 1。
- matrix[i][j] = 1 表示顶点 i 与顶点 j 之间存在一条边。
- matrix[i][j] = 0 表示顶点 i 与顶点 j 之间不存在边。
顶点的 度（degree）定义为与该顶点相连的边的数量。
请返回一个长度为 n 的整数数组 ans，其中 ans[i] 表示顶点 i 的度。
提示：
1 <= n == matrix.length == matrix[i].length <= 100
matrix[i][i] == 0
matrix[i][j] 仅为 0 或 1
matrix[i][j] == matrix[j][i]

中国时间 2026-04-12 周日 10:30
佛山。
统计矩阵每一行的 1 的个数即可。
时间复杂度 O(mn)。
 */