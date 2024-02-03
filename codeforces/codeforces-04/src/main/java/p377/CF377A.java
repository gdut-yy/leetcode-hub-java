package p377;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF377A {
    static int n, m, k;
    static char[][] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();
        a = new char[n][m];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next().toCharArray();
        }
        System.out.println(solve());
    }

    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static boolean[][] vis;

    private static String solve() {
        vis = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == '.') {
                    dfs(i, j);
                }
            }
        }
        return Arrays.stream(a).map(String::new).collect(Collectors.joining(System.lineSeparator()));
    }

    static void dfs(int i, int j) {
        vis[i][j] = true;
        for (int[] d : DIRECTIONS) {
            int nx = i + d[0];
            int ny = j + d[1];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && !vis[nx][ny] && a[nx][ny] == '.') {
                dfs(nx, ny);
            }
        }
        if (k > 0) {
            k--;
            a[i][j] = 'X';
        }
    }
}
/*
A. Maze
https://codeforces.com/contest/377/problem/A

灵茶の试炼 2022-09-20
题目大意：
输入 n(≤500) m(≤500) k 和一个 n 行 m 列的网格图，'#' 表示墙，'.' 表示平地。
保证所有 '.' 可以互相到达（四方向连通）。保证 k 小于 '.' 的个数。
你需要把恰好 k 个 '.' 修改成 'X'，使得剩余的所有 '.' 仍然是可以互相到达的。
输出修改后的网格图。

rating 1600
https://codeforces.com/contest/377/submission/172785787
考察对 DFS 的理解程度。
提示 1：从任意一个 '.' 出发，DFS 连续访问过的位置是连通的。
提示 2：设总共有 s 个 '.'，连续访问 s-k 个 '.'，剩余没有访问过的 '.' 就可以修改成 '#' 了。
注：也可以用 BFS 做。
======

input
3 4 2
#..#
..#.
#...
output
#.X#
X.#.
#...

input
5 4 5
#...
#.#.
.#..
...#
.#.#
output
#XXX
#X#.
X#..
...#
.#.#
 */
