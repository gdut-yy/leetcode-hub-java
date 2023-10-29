package c325;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc325_c {
    static int h, w;
    static char[][] grid;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        h = scanner.nextInt();
        w = scanner.nextInt();
        grid = new char[h][w];
        for (int i = 0; i < h; i++) {
            grid[i] = scanner.next().toCharArray();
        }
        System.out.println(solve());
    }

    private static final int[][] DIRECTIONS8 = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};

    private static String solve() {
        DSU dsu = new DSU(h * w);
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (grid[i][j] == '#') {
                    dsu.sz++;

                    for (int[] dir : DIRECTIONS8) {
                        int nx = i + dir[0];
                        int ny = j + dir[1];
                        if (nx >= 0 && nx < h && ny >= 0 && ny < w && grid[nx][ny] == '#') {
                            dsu.union(i * w + j, nx * w + ny);
                        }
                    }
                }
            }
        }
        return String.valueOf(dsu.sz);
    }

    private static class DSU {
        int[] fa;
        int sz;

        public DSU(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
        }

        int find(int x) {
            if (x != fa[x]) {
                fa[x] = find(fa[x]);
            }
            return fa[x];
        }

        void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            fa[rootQ] = rootP;
            sz--;
        }
    }
}
/*
C - Sensors
https://atcoder.jp/contests/abc325/tasks/abc325_c

题目大意：
有零个或多个传感器放置在 H 行和 W 列的网格上。令(i,j)表示从上到下第 i 行和从左到第 j 列的正方形。
每个正方形是否包含传感器由字符串 s1, s2,..., SH 给出，每个长度为 w (i,j)包含传感器当且仅当 s1 的第 j 个字符为 #。
这些传感器与在水平、垂直或对角线上相邻的正方形中的其他传感器相互作用，并作为一个传感器工作。这里，当且仅当 max(|x-x'|，|y-y'|)=1 时，一个单元格(x,y)和一个单元格(x'，y')被称为水平、垂直或对角相邻。
请注意，如果传感器 A 与传感器 B 相互作用，传感器 A 与传感器 C 相互作用，则传感器 B 和传感器 C 也相互作用。
将相互作用的传感器视为一个传感器，求出该网格上传感器的个数。

并查集。
相似题目: 200. 岛屿数量
https://leetcode.cn/problems/number-of-islands/
======

Input 1
5 6
.##...
...#..
....##
#.#...
..#...
Output 1
3

Input 2
3 3
#.#
.#.
#.#
Output 2
1

Input 3
4 2
..
..
..
..
Output 3
0

Input 4
5 47
.#..#..#####..#...#..#####..#...#...###...#####
.#.#...#.......#.#...#......##..#..#...#..#....
.##....#####....#....#####..#.#.#..#......#####
.#.#...#........#....#......#..##..#...#..#....
.#..#..#####....#....#####..#...#...###...#####
Output 4
7
 */
