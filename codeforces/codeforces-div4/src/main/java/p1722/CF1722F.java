package p1722;

import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CF1722F {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            char[][] chars = new char[n][m];
            for (int j = 0; j < n; j++) {
                chars[j] = scanner.next().toCharArray();
            }
            System.out.println(solve(n, m, chars));
        }
    }

    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private static int M;
    private static int N;
    private static boolean[][] visited;

    private static String solve(int n, int m, char[][] chars) {
        M = n;
        N = m;
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (chars[i][j] == '*' && !visited[i][j]) {
                    if (!check(chars, i, j)) {
                        return "NO";
                    }
                }
            }
        }
        return "YES";
    }

    private static boolean check(char[][] grid, int i, int j) {
        // BFS
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;
        int area = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] cur = queue.remove();
                // 特判 一 型或 | 型
                if (Math.abs(cur[0] - i) >= 2 || Math.abs(cur[1] - j) >= 2) {
                    return false;
                }
                if (cntLive(grid, cur[0], cur[1]) != 3) {
                    return false;
                }
                area++;
                if (area > 3) {
                    return false;
                }

                for (int[] dir : DIRECTIONS) {
                    int nextM = cur[0] + dir[0];
                    int nextN = cur[1] + dir[1];
                    if (nextM >= 0 && nextM < M && nextN >= 0 && nextN < N
                            && grid[nextM][nextN] == '*' && !visited[nextM][nextN]) {
                        visited[nextM][nextN] = true;
                        queue.add(new int[]{nextM, nextN});
                    }
                }
            }
        }
        return area == 3;
    }

    private static int cntLive(char[][] grid, int i, int j) {
        int cnt = 0;
        for (int row = Math.max(0, i - 1); row <= Math.min(M - 1, i + 1); row++) {
            for (int col = Math.max(0, j - 1); col <= Math.min(N - 1, j + 1); col++) {
                if (grid[row][col] == '*') {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
/*
F. L-shapes
https://codeforces.com/contest/1722/problem/F

题目大意：
给定整数 n, m 和 n*m 的矩阵，判断是否仅包含 L 型，且每个 L 型边和角均不接触。

BFS，首先每个 * 型块大小必须为 3，否则不满足，其次不能是 一 型或 | 型，边和角均不接触等价于周围8个格只能出现 2 个 *。
======

input
10
6 10
........**
.**......*
..*..*....
.....**...
...*.....*
..**....**
6 10
....*...**
.**......*
..*..*....
.....**...
...*.....*
..**....**
3 3
...
***
...
4 4
.*..
**..
..**
..*.
5 4
.*..
**..
....
..**
..*.
3 2
.*
**
*.
2 3
*..
.**
3 2
..
**
*.
3 3
.**
*.*
**.
3 3
..*
.**
..*

output
YES
NO
NO
NO
YES
NO
NO
YES
NO
NO
 */
