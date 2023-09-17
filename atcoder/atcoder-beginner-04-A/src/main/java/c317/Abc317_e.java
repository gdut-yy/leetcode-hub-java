package c317;

import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Abc317_e {
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

    // v, >, ^, <
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static boolean[][] vis;
    static int sx, sy, tx, ty;

    private static String solve() {
        vis = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == '#') {
                    vis[i][j] = true;
                } else if (a[i][j] == 'v') {
                    vis[i][j] = true;
                    dfs(i, j, 0);
                } else if (a[i][j] == '>') {
                    vis[i][j] = true;
                    dfs(i, j, 1);
                } else if (a[i][j] == '^') {
                    vis[i][j] = true;
                    dfs(i, j, 2);
                } else if (a[i][j] == '<') {
                    vis[i][j] = true;
                    dfs(i, j, 3);
                } else if (a[i][j] == 'S') {
                    sx = i;
                    sy = j;
                } else if (a[i][j] == 'G') {
                    tx = i;
                    ty = j;
                }
            }
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{sx, sy, 0});
        vis[sx][sy] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] tuple = queue.remove();
                int cx = tuple[0], cy = tuple[1], cstep = tuple[2];
                if (cx == tx && cy == ty) {
                    return String.valueOf(cstep);
                }

                for (int[] dir : DIRECTIONS) {
                    int nx = cx + dir[0];
                    int ny = cy + dir[1];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && !vis[nx][ny]) {
                        vis[nx][ny] = true;
                        queue.add(new int[]{nx, ny, cstep + 1});
                    }
                }
            }
        }
        return "-1";
    }

    private static void dfs(int x, int y, int i) {
        x += DIRECTIONS[i][0];
        y += DIRECTIONS[i][1];
        if (x >= 0 && x < n && y >= 0 && y < m
                && a[x][y] == '.') {
            vis[x][y] = true;
            dfs(x, y, i);
        }
    }

}
/*
E - Avoid Eye Contact
https://atcoder.jp/contests/abc317/tasks/abc317_e

题目大意：
这是一个被分成网格的场
H 行 W 列。从北开始的第 i 行(上)和从西开始的第 j 列(左)的正方形用字符 ai,j 表示。每个字符表示以下内容。
- '.' :一个空的方块。通行的。
- '#' :障碍。无法通行。
- '>', 'v', '<', '^' :一个人分别面向东，南，西，北的正方形。无法通行。这个人的视线是一个正方形宽，并直接向他面对的方向延伸，并被障碍物或另一个人阻挡。(请参见示例输入/输出 1 中的描述。)
- 'S' :起点。通行的。只有一个起点。它保证不会在人的视线内。
- 'G' :目标。通行的。只有一个目标。它保证不会在人的视线内。
Naohiro 处于起点，可以随心所欲地将一个方块移动到东、西、南、北。但是，他不能进入不可通过的方格或离开场地。
确定他是否可以在不进入对方视线的情况下达到目标，如果可以，找出达到目标所需的最小移动次数。

BFS
======

Input 1
5 7
....Sv.
.>.....
.......
>..<.#<
^G....>
Output 1
15

Input 2
4 3
S..
.<.
.>.
..G
Output 2
-1
 */