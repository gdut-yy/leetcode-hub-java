package p1829;

import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class CF1829E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[][] a = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = scanner.nextInt();
                }
            }
            System.out.println(solve(n, m, a));
        }
    }

    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private static String solve(int n, int m, int[][] a) {
        boolean[][] visited = new boolean[n][m];

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] > 0) {
                    Queue<int[]> queue = new ArrayDeque<>();
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                    int area = 0;
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        for (int i1 = 0; i1 < size; i1++) {
                            int[] tuple = queue.remove();
                            int cx = tuple[0], cy = tuple[1];
                            area += a[cx][cy];

                            for (int[] dir : DIRECTIONS) {
                                int nx = cx + dir[0];
                                int ny = cy + dir[1];
                                if (nx >= 0 && nx < n && ny >= 0 && ny < m
                                        && a[nx][ny] > 0 && !visited[nx][ny]) {
                                    visited[nx][ny] = true;
                                    queue.add(new int[]{nx, ny});
                                }
                            }
                        }
                    }
                    max = Math.max(max, area);
                }
            }
        }
        return String.valueOf(max);
    }
}
/*
E. The Lakes
https://codeforces.com/contest/1829/problem/E

题目大意：
给你一个 n×m 网格 a，它是一个非负整数。值 ai,j 表示第 i 行和第 j 列处的水深。
湖是一组细胞，这样:
- 集合中的每个单元格有 ai,j>0，和
- 湖中任意一对细胞之间存在一条路径，只要向上、向下、向左或向右移动若干次，且不踩到 ai,j=0 的细胞。
湖泊的体积是湖中所有细胞深度的总和。
在网格中找到一个湖泊的最大体积。

BFS
相似题目: 2658. 网格图中鱼的最大数目
https://leetcode.cn/problems/maximum-number-of-fish-in-a-grid/
======

input
5
3 3
1 2 0
3 4 0
0 0 5
1 1
0
3 3
0 1 1
1 0 1
1 1 1
5 5
1 1 1 1 1
1 0 0 0 1
1 0 5 0 1
1 0 0 0 1
1 1 1 1 1
5 5
1 1 1 1 1
1 0 0 0 1
1 1 4 0 1
1 0 0 0 1
1 1 1 1 1
output
10
0
7
16
21
 */

