package c276;

import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Abc276_e {
    private static int h, w;
    private static char[][] c;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        h = scanner.nextInt();
        w = scanner.nextInt();
        c = new char[h][w];
        for (int i = 0; i < h; i++) {
            c[i] = scanner.next().toCharArray();
        }
        System.out.println(solve());
    }

    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private static String solve() {
        int sx = -1;
        int sy = -1;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (c[i][j] == 'S') {
                    sx = i;
                    sy = j;
                    break;
                }
            }
            if (sx != -1) {
                break;
            }
        }

        for (int[] dir : DIRECTIONS) {
            int nx = sx + dir[0];
            int ny = sy + dir[1];
            if (nx >= 0 && nx < h && ny >= 0 && ny < w && c[nx][ny] == '.') {
                if (check(nx, ny, sx, sy)) {
                    return "Yes";
                }
            }
        }
        return "No";
    }

    private static boolean check(int sx, int sy, int tx, int ty) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{sx, sy});
        boolean[][] vis = new boolean[h][w];
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] tuple = queue.remove();
                int cx = tuple[0], cy = tuple[1];

                if (cx == tx && cy == ty) {
                    return true;
                }

                for (int[] dir : DIRECTIONS) {
                    int nx = cx + dir[0];
                    int ny = cy + dir[1];
                    if (nx >= 0 && nx < h && ny >= 0 && ny < w
                            && c[nx][ny] != '#' && !vis[nx][ny]
                            // 不能原路返回
                            && !(cx == sx && cy == sy && nx == tx && ny == ty)
                    ) {
                        vis[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
        return false;
    }
}
/*
E - Round Trip
https://atcoder.jp/contests/abc276/tasks/abc276_e

题目大意：
我们有一个网格，从上到下有 H 行，从左到右有 W 列。设(i,j)表示从上到下的第 i 行(1≤i≤H)，从左到第 j 列(1≤j≤W)。
每个方块都是以下内容之一:初始点、道路和障碍。
正方形(i,j)由字符 ci,j 表示。正方形是初始点，如果 ci,j = S，如果 ci,j = .，如果 ci,j = #，则为道路，如果 ci,j = #，则为障碍物。只有一个初始点。
确定是否存在长度为 4 或更大的路径，从初始点开始，重复垂直或水平移动到相邻的正方形，然后返回到初始点，而不经过障碍物或多次访问相同的正方形(除了开始和结束)。
更正式地说，确定是否存在一个整数 n 和一个平方序列(x 0,y 0)，(x 1,y 1)，…，(x n,y n)满足以下条件。

BFS
======

Input 1
4 4
....
#.#.
.S..
.##.
Output 1
Yes

Input 2
2 2
S.
.#
Output 2
No

Input 3
5 7
.#...#.
..#.#..
...S...
..#.#..
.#...#.
Output 3
No
 */