package p193;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF193A {
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
    static int[][] vis;
    static int t, cnt;

    private static String solve() {
        int tot = 0;
        for (char[] row : a) {
            for (char c : row) {
                if (c == '#') tot++;
            }
        }
        if (tot < 3) {
            return "-1";
        }

        vis = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] != '#') continue;
                a[i][j] = '.';
                t++;
                cnt = 0;
                for (int[] dir : DIRECTIONS) {
                    if (dfs(i + dir[0], j + dir[1])) {
                        break;
                    }
                }
                if (cnt < tot - 1) {
                    return "1";
                }
                a[i][j] = '#';
            }
        }
        return "2";
    }

    static boolean dfs(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m || vis[x][y] == t || a[x][y] != '#') {
            return false;
        }
        vis[x][y] = t;
        cnt++;
        for (int[] dir : DIRECTIONS) {
            dfs(x + dir[0], y + dir[1]);
        }
        return true;
    }
}
/*
A. Cutting Figure
https://codeforces.com/contest/193/problem/A

灵茶の试炼 2023-07-26
题目大意：
输入 n m(1≤n,m≤50) 和一个 n 行 m 列的网格图，仅包含 '#' 和 '.'。
输入保证图中任意两个 '#' 都可以通过四方向移动互相到达（连通图）。
输入保证至少有一个 '#'。
你需要把尽量少的 '#' 修改成 '.'，使得网格图不连通。
如果无法做到，输出 -1，否则输出最少修改次数。
注：规定空集（没有 '#'）视作连通图，只有一个 '#' 也视作连通图。

rating 1700
https://codeforces.com/contest/193/submission/215507875
脑筋急转弯。
如果 # 个数小于 3，那么无法分成多个连通块，输出 -1。
否则有解（注意原图是连通的）。
对于角落的 #，可以把相邻的两个 # 改成 . 使得图不连通，所以至多操作 2 次。
如果角落没有 #，一定存在一个边上的 # 至多有两个 . 邻居，所以也至多操作 2 次。
那么只需要判断能否操作 1 次使图不连通。
代码写的是 O(n^2m^2) 的暴力，可以用 Tarjan 割点做到 O(nm)。
相似题目: 2556. 二进制矩阵中翻转最多一次使路径不连通
https://leetcode.cn/problems/disconnect-path-in-a-binary-matrix-by-at-most-one-flip/
======

input
5 4
####
#..#
#..#
#..#
####
output
2

input
5 5
#####
#...#
#####
#...#
#####
output
2
 */
