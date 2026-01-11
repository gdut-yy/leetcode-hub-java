package p2034;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class CF2034C {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    // 方向映射，对应 Go 代码中的 dirC
    private static final int[][] dirC = new int[128][];

    static {
        dirC['L'] = new int[]{0, -1};
        dirC['R'] = new int[]{0, 1};
        dirC['U'] = new int[]{-1, 0};
        dirC['D'] = new int[]{1, 0};
    }

    // 四个方向，对应 Go 代码中的 dir4
    private static final int[][] dir4 = {
            {0, -1}, {0, 1}, {-1, 0}, {1, 0}
    };

    private static void solve() {
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }

        // dp 数组，对应 Go 中的 int8，这里用 byte
        byte[][] dp = new byte[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], (byte) -1);
        }

        // 递归函数
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans += f(i, j, n, m, a, dp);
            }
        }
        out.println(ans);
    }

    static byte f(int i, int j, int n, int m, String[] a, byte[][] dp) {
        if (i < 0 || i >= n || j < 0 || j >= m) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // 标记为正在处理（防止循环依赖）
        dp[i][j] = 1;

        char ch = a[i].charAt(j);
        if (ch != '?') {
            int[] d = dirC[ch];
            byte res = f(i + d[0], j + d[1], n, m, a, dp);
            dp[i][j] = res;
            return res;
        }

        // 处理 '?' 的情况
        for (int[] d : dir4) {
            int x = i + d[0];
            int y = j + d[1];
            if (x >= 0 && x < n && y >= 0 && y < m) {
                char nextChar = a[x].charAt(y);
                if (nextChar == '?' || f(x, y, n, m, a, dp) > 0) {
                    dp[i][j] = 1;
                    return 1;
                }
            }
        }

        dp[i][j] = 0;
        return 0;
    }
}
/*
C. Trapped in the Witch's Labyrinth
https://codeforces.com/contest/2034/problem/C

灵茶の试炼 2025-08-19
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n*m 之和 ≤1e6。
每组数据输入 n(1≤n≤1e3) m(1≤m≤1e3) 和 n 行 m 列的网格图，只包含 UDLR? 五种字符，分别表示上、下、左、右和待定。
你需要对每个 ? 格子指定具体方向，即改成 UDLR 中的一种。
有 n*m 个格子可以作为移动的起点。每次移动必须遵循所在格子的方向，移动到相邻格子，或者出界。
最大化无法离开网格图（出界）的起点个数。输出这个最大值。

rating 1400
什么情况下，无法离开网格图？
1. 当前格子在环中。
2. 当前格子可以到达环。
3. 我们从一个格子移动到了问号格子。把这个问号格子改成反方向，就可以来回横跳了，无法离开网格图。
考虑子问题：
1. 如果起点不是问号，那么问题变成：把下一步的那个格子当作起点，能否离开网格图？这是一个子问题。
2. 如果起点是问号，那么上下左右要有无法离开网格图的格子；或者上下左右有问号，把起点及其邻居这两个问号改成相向的，就可以来回横跳了。
考虑用记忆化搜索 dfs(i,j) 实现：
1. 如果出界，返回 0。
2. 如果之前计算过，返回之前计算的值。
3. 首先，把 memo[i][j] 标记为 1，暂定这个格子是无法走出去的。这样可以避免 dfs 遇到环导致无限递归。
4. 如果当前格子不是问号，那么继续递归 dfs(x,y)。
5. 否则，看看上下左右有没有问号，或者无法走出去的格子。如果有，返回 1。
6. 否则返回 0。
答案为所有 dfs(i,j) 之和。
代码 https://codeforces.com/contest/2034/submission/333210995
代码备份（上面打不开的同学看这个）
======

Input
3
3 3
UUU
L?R
DDD
2 3
???
???
3 3
?U?
R?L
RDL
Output
0
6
5
 */
