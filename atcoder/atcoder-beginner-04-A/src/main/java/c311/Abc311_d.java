package c311;

import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Abc311_d {
    static int n, m;
    static char[][] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new char[n][m];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next().toCharArray();
        }
        System.out.println(solve());
    }

    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private static String solve() {
        // bfs 碰到墙壁才停止
        boolean[][] touch = new boolean[n][m];

        // x,y,dir
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][][] vis = new boolean[n][m][4];
        for (int i = 0; i < 4; i++) {
            vis[1][1][i] = true;
            queue.add(new int[]{1, 1, i});
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] tuple = queue.remove();
                int x = tuple[0], y = tuple[1], di = tuple[2];
                int dx = DIRECTIONS[di][0];
                int dy = DIRECTIONS[di][1];

                int nx = x, ny = y;
                touch[nx][ny] = true;
                while (nx + dx >= 0 && nx + dx < n && ny + dy >= 0 && ny + dy < m
                        && a[nx + dx][ny + dy] == '.') {
                    nx += dx;
                    ny += dy;
                    touch[nx][ny] = true;
                }
                for (int i = 0; i < 4; i++) {
                    if (!vis[nx][ny][i]) {
                        vis[nx][ny][i] = true;
                        queue.add(new int[]{nx, ny, i});
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (touch[i][j]) {
                    ans++;
                }
            }
        }
        return String.valueOf(ans);
    }
}
/*
D - Grid Ice Floor
https://atcoder.jp/contests/abc311/tasks/abc311_d

题目大意：
有一个 N×M 网格和一个站在上面的玩家。
设(i,j)表示这个网格从上到下第 i 行和从左到第 j 列的正方形。
网格中的每个方格都是冰或岩石，用 N 个长度为 M 的字符串 s1, s2,..,sn 表示，如下所示:
- 如果 si 的第 j 个字符是 '.'，则正方形(i,j)是 ice;
- 如果 si 的第 j 个字符是 '#'，则正方形(i,j)是 rock。
这个网格的外围(第 1-st 行，第 n 行，第 1-st 列，第 m 列的所有正方形)是岩石。
最初，玩家停留在方格(2,2)上，这是一个冰。
玩家可以进行 0 次或更多次以下移动。
- 首先，指定移动方向:上、下、左或右。
- 然后，继续朝那个方向移动，直到玩家撞到一块石头。正式的做法是:
  - 如果移动方向上的下一个方块是冰，就去那个方块并继续移动;
  - 如果移动方向的下一个方块是岩石，则停留在当前方块中并停止移动。
找出玩家可以触摸(通过或休息)的冰块数量。

BFS。一走走到底
相似题目: $490. 迷宫
https://leetcode.cn/problems/the-maze/
======

Input 1
6 6
######
#....#
#.#..#
#..#.#
#....#
######
Output 1
12

Input 2
21 25
#########################
#..............###...####
#..............#..#...###
#........###...#...#...##
#........#..#..#........#
#...##...#..#..#...#....#
#..#..#..###...#..#.....#
#..#..#..#..#..###......#
#..####..#..#...........#
#..#..#..###............#
#..#..#.................#
#........##.............#
#.......#..#............#
#..........#....#.......#
#........###...##....#..#
#..........#..#.#...##..#
#.......#..#....#..#.#..#
##.......##.....#....#..#
###.............#....#..#
####.................#..#
#########################
Output 2
215
 */