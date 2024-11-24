package p1749;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1749E {
    static int n, m;
    static char[][] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            a = new char[n][];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.next().toCharArray();
            }
            System.out.println(solve());
        }
    }

    static final int INF = (int) 1e9;
    static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static final int[][] dirR = {{1, 1}, {-1, 1}, {-1, -1}, {1, -1}};
    static int[][] dis;
    static int[][][] from;

    private static String solve() {
        dis = new int[n][m];
        from = new int[n][m][2]; // x,y
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dis[i][j] = INF;
                from[i][j][0] = -1;
            }
        }

        List<int[]> ql = new ArrayList<>();
        List<int[]> qr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (a[i][0] == '#') {
                dis[i][0] = 0;
                ql.add(new int[]{i, 0});
            } else if (ok(i, 0)) {
                dis[i][0] = 1;
                qr.add(new int[]{i, 0});
            }
        }

        while (!ql.isEmpty() || !qr.isEmpty()) {
            int[] p;
            if (!ql.isEmpty()) {
                p = ql.removeLast();
            } else {
                p = qr.removeFirst();
            }
            if (p[1] == m - 1) {
                int x = p[0], y = p[1];
                while (x >= 0) {
                    a[x][y] = '#';
                    int[] q = from[x][y];
                    x = q[0];
                    y = q[1];
                }
                return "YES" + System.lineSeparator()
                        + Arrays.stream(a).map(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
            }

            for (int[] di : dirR) {
                int x = p[0] + di[0];
                int y = p[1] + di[1];
                if (x >= 0 && x < n && y >= 0 && y < m && ok(x, y)) {
                    int d = 0;
                    if (a[x][y] == '.') {
                        d = 1;
                    }
                    int newD = dis[p[0]][p[1]] + d;
                    if (newD < dis[x][y]) {
                        dis[x][y] = newD;
                        from[x][y] = p;
                        if (d == 0) {
                            ql.add(new int[]{x, y});
                        } else {
                            qr.add(new int[]{x, y});
                        }
                    }
                }
            }
        }
        return "NO";
    }

    static boolean ok(int i, int j) {
        for (int[] d : dir) {
            int x = i + d[0];
            int y = j + d[1];
            if (x >= 0 && x < n && y >= 0 && y < m && a[x][y] == '#') {
                return false;
            }
        }
        return true;
    }
}
/*
E. Cactus Wall
https://codeforces.com/contest/1749/problem/E

灵茶の试炼 2023-12-15
题目大意：
输入 T(≤1e3) 表示 T 组数据。所有数据的 n*m 之和 ≤4e5。
每组数据输入 n m(2≤n,m≤2e5 且 n*m≤4e5) 和 n 行 m 列的网格图，其中 '#' 表示仙人掌，'.' 表示空地。
你需要在空地上种植仙人掌，使得不存在一条从第一行到最后一行的只包含空地的路径（只能上下左右走）。
种植仙人掌时，不能种在已有仙人掌的旁边（上下左右）。注：输入的网格图保证不存在上下左右相邻的仙人掌。
你不能移除仙人掌。
请种植最少数量的仙人掌以满足要求。
如果可以做到，输出 YES 和具体方案；如果无法做到，输出 NO。

rating 2400
提示 1
如果从左到右制造一堵仙人掌墙，那么就无法从上到下了。（类比网络流中的「割」）
提示 2
由于不能种在相邻的仙人掌旁，这堵墙只能走斜着的四个方向。
提示 3
如果是 '#' 则可以直接走（边权=0），否则需要种仙人掌（边权=1），种之前还需要确认上下左右四个格子没有仙人掌。
由于边权只有 0 和 1，可以用 0-1 BFS 解决（或者 Dijkstra）。
提示 4
只要出队的点在最后一列，就立刻输出方案。
为了知道经过哪些点，可以记录每个点的转移来源。
https://codeforces.com/contest/1749/submission/236959594
======

input
4
2 4
.#..
..#.
3 3
#.#
...
.#.
5 5
.....
.....
.....
.....
.....
4 3
#..
.#.
#.#
...
output
YES
.#.#
#.#.
NO
YES
....#
...#.
..#..
.#...
#....
YES
#..
.#.
#.#
...
 */
