import java.util.Arrays;

public class Solution6053 {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        char[][] grid = new char[m][n];
        // 初始状态 置为未被保卫
        for (char[] chars : grid) {
            Arrays.fill(chars, 'F');
        }
        // 警卫
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 'G';
        }
        // 墙
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 'W';
        }

        // 模拟
        for (int[] guard : guards) {
            mock(m, n, grid, guard[0], guard[1]);
        }

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'F') {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private void mock(int m, int n, char[][] grid, int guardX, int guardY) {
        // up
        for (int i = guardX - 1; i >= 0 && grid[i][guardY] != 'W' && grid[i][guardY] != 'G'; i--) {
            if (grid[i][guardY] == 'F') {
                grid[i][guardY] = 'T';
            }
        }
        // down
        for (int i = guardX + 1; i < m && grid[i][guardY] != 'W' && grid[i][guardY] != 'G'; i++) {
            if (grid[i][guardY] == 'F') {
                grid[i][guardY] = 'T';
            }
        }
        // left
        for (int j = guardY - 1; j >= 0 && grid[guardX][j] != 'W' && grid[guardX][j] != 'G'; j--) {
            if (grid[guardX][j] == 'F') {
                grid[guardX][j] = 'T';
            }
        }
        // right
        for (int j = guardY + 1; j < n && grid[guardX][j] != 'W' && grid[guardX][j] != 'G'; j++) {
            if (grid[guardX][j] == 'F') {
                grid[guardX][j] = 'T';
            }
        }
    }
}
/*
6053. 统计网格图中没有被保卫的格子数
https://leetcode-cn.com/problems/count-unguarded-cells-in-the-grid/

第 77 场双周赛 T3。

给你两个整数 m 和 n 表示一个下标从 0 开始的 m x n 网格图。同时给你两个二维整数数组 guards 和 walls ，
其中 guards[i] = [rowi, coli] 且 walls[j] = [rowj, colj] ，分别表示第 i 个警卫和第 j 座墙所在的位置。
一个警卫能看到 4 个坐标轴方向（即东、南、西、北）的 所有 格子，除非他们被一座墙或者另外一个警卫 挡住 了视线。
如果一个格子能被 至少 一个警卫看到，那么我们说这个格子被 保卫 了。
请你返回空格子中，有多少个格子是 没被保卫 的。
提示：
1 <= m, n <= 10^5
2 <= m * n <= 10^5
1 <= guards.length, walls.length <= 5 * 10^4
2 <= guards.length + walls.length <= m * n
guards[i].length == walls[j].length == 2
0 <= rowi, rowj < m
0 <= coli, colj < n
guards 和 walls 中所有位置 互不相同 。

模拟。数据范围 m * n <= 10^5，咋眼一看直接模拟会超时，但注意题目条件 除非他们被一座墙或者另外一个警卫 挡住 了视线，相当于一个幅度很大的剪枝。
时间复杂度约为: O(m * n)，可以过。
 */