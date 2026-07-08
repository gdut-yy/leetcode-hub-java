package p845;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF845F {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static int n, m;
    static int[] walls;
    static int mod = (int) (1e9 + 7);
    static int[][][][][] dp;

    private static void solve() {
        n = scanner.nextInt();
        m = scanner.nextInt();
        char[][] a = new char[n][m];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next().toCharArray();
        }
        if (n < m) {
            a = transpose(a);
            int tmp = n;
            n = m;
            m = tmp;
        }
        walls = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 'x') {
                    walls[i] |= 1 << j;
                }
            }
        }
        dp = new int[n][m][1 << m][2][2];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                for (int k = 0; k < 1 << m; k++)
                    for (int r = 0; r < 2; r++)
                        for (int mi = 0; mi < 2; mi++)
                            dp[i][j][k][r][mi] = -1;
        out.println(f(0, 0, 0, 0, 0));
    }

    static char[][] transpose(char[][] a) {
        int nn = a.length, mm = a[0].length;
        char[][] b = new char[mm][nn];
        for (int i = 0; i < mm; i++)
            for (int j = 0; j < nn; j++)
                b[i][j] = a[j][i];
        return b;
    }

    static int f(int i, int j, int down, int right, int miss) {
        if (i == n) return 1;
        if (j == m) return f(i + 1, 0, down, 0, miss);
        down &= ~walls[i];
        if (dp[i][j][down][right][miss] >= 0) return dp[i][j][down][right][miss];
        if ((walls[i] >> j & 1) > 0) return dp[i][j][down][right][miss] = f(i, j + 1, down, 0, miss);
        int res = f(i, j + 1, down | (1 << j), 1, miss);
        if (right > 0 || (down >> j & 1) > 0) {
            res = (res + f(i, j + 1, down, right, miss)) % mod;
        } else if (miss == 0) {
            res = (res + f(i, j + 1, down, right, 1)) % mod;
        }
        return dp[i][j][down][right][miss] = res;
    }
}
/*
F. Guards In The Storehouse
https://codeforces.com/contest/845/problem/F

灵茶の试炼 2026-01-09
题目大意：
输入 n m(1≤n*m≤250) 和 n 行 m 列的网格图，只包含 '.' 和 'x'，分别表示空地和墙。
你需要选择一些空地，在这些空地上放置哨兵。
哨兵的视线可以向下、向右发射，直到遇到边界或者墙。
输出使网格图至多有一个空地没被视线覆盖的方案数，模 1e9+7。
注：如果合法，放置 0 个哨兵也算一种方案。

rating 2500
推荐先做做 1.3 的力扣每日 LC1411. 给 N x 3 网格图涂色的方案数。
这种类型的题目叫做轮廓线 DP。
写一个记忆化搜索，从上到下一行一行地考虑，每行从左到右考虑。
我们需要知道：
- 当前位置 (i, j)。
- 这一行的哪些列能被来自上方的哨兵看到。用一个二进制数 down 表示。
- 当前位置是否被来自左边的哨兵看到。用一个布尔值 right 表示。
- 之前是否遗留了一个未被视线覆盖的格子。用一个布尔值 miss 表示。
如果 (i, j) 是墙，那么无法放置哨兵，right 改成 false。然后继续向右递归（下同）。
如果 (i, j) 是空地：
如果当前位置放置哨兵，down 添加 1<<j，right 改成 true。
如果当前位置不放置哨兵，并且有来自左边或者上边的视线，那么 miss 不变。否则，只能在 miss = false 的情况下继续递归，把 miss 改成 true。
如果 j=m，这一行处理完毕，递归下一行。对于 down，把被下一行的墙挡住的视线改成 0（也可以每次递归开始时修改）。
如果 i=n，处理完毕，找到了一个合法方案，返回 1。
初始值：dfs(0, 0, 0, false, false)。
为了保证时间复杂度，我们要保证 n >= m，如果 n < m 则把矩阵转置。
这样 m <= floor(sqrt(250)) = 15。
专题训练：动态规划题单 §9.5 轮廓线 DP。
代码 https://codeforces.com/contest/845/submission/350003986
代码备份（上面打不开的同学看这个）
======

Input
1 3
.x.
Output
3

Input
2 2
xx
xx
Output
1

Input
2 2
..
..
Output
10

Input
3 1
x
.
x
Output
2
 */
