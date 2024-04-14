import java.util.Arrays;

public class SolutionLCP38 {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private static final int INF = (int) 1e9;
    private int[][][] f;

    // https://leetcode.cn/problems/7rLGCR/solutions/714128/lcp-38-shou-wei-cheng-bao-by-zerotrac2-kgv2/
    public int guardCastle(String[] grid) {
        int n = grid[0].length();
        int ans = INF;

        // mark every portal as castle
        char[][] g1 = toGrid(grid);
        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < n; ++j) {
                if (g1[i][j] == 'P') {
                    g1[i][j] = 'C';
                }
            }
        }
        ans = Math.min(ans, check(g1));

        // mark every portal as demon
        char[][] g2 = toGrid(grid);
        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < n; ++j) {
                if (g2[i][j] == 'P') {
                    g2[i][j] = 'S';
                }
            }
        }
        ans = Math.min(ans, check(g2));

        return ans == INF ? -1 : ans;
    }

    private char[][] toGrid(String[] grid) {
        char[][] res = new char[grid.length][grid[0].length()];
        res[0] = grid[0].toCharArray();
        res[1] = grid[1].toCharArray();
        return res;
    }

    public int check(char[][] grid) {
        int n = grid[0].length;
        // check if no (castle, demon) neighbor pair exists
        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int[] d : DIRECTIONS) {
                    int ni = i + d[0];
                    int nj = j + d[1];
                    if (ni >= 0 && ni < 2 && nj >= 0 && nj < n) {
                        if (grid[i][j] == 'C' && grid[ni][nj] == 'S') {
                            return INF;
                        }
                        if (grid[i][j] == 'S' && grid[ni][nj] == 'C') {
                            return INF;
                        }
                    }
                }
            }
        }

        // f[i][s1][s2] = ith column, s1, s2, minimum barriers to put
        // s1, s2 = (0=empty, 1=castle, 2=demon, 3=stone)
        f = new int[n + 1][4][4];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < 4; j++) {
                Arrays.fill(f[i][j], INF);
            }
        }
        f[0][0][0] = 0;

        for (int i = 1; i <= n; ++i) {
            int t1 = rep(grid[0][i - 1]);
            int t2 = rep(grid[1][i - 1]);
            for (int s1 = 0; s1 < 4; ++s1) {
                for (int s2 = 0; s2 < 4; ++s2) {
                    update(i, s1, s2, t1, t2, 0);
                    if (grid[0][i - 1] == '.') {
                        update(i, s1, s2, 3, t2, 1);
                    }
                    if (grid[1][i - 1] == '.') {
                        update(i, s1, s2, t1, 3, 1);
                    }
                    if (grid[0][i - 1] == '.' && grid[1][i - 1] == '.') {
                        update(i, s1, s2, 3, 3, 2);
                    }
                }
            }
        }

        int ans = INF;
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                ans = Math.min(ans, f[n][i][j]);
            }
        }
        return ans;
    }

    private int rep(char c) {
        if (c == '.') return 0;
        if (c == 'C') return 1;
        if (c == 'S') return 2;
        if (c == '#') return 3;
        return 0;
    }

    private void update(int i, int s1, int s2, int t1, int t2, int extra) {
        if (s1 == 1 || s1 == 2) {
            if (s1 + t1 == 3) {
                return;
            }
            if (t1 == 0) {
                t1 = s1;
            }
        }
        if (s2 == 1 || s2 == 2) {
            if (s2 + t2 == 3) {
                return;
            }
            if (t2 == 0) {
                t2 = s2;
            }
        }
        if ((t1 == 1 || t1 == 2) && (t1 + t2 == 3)) {
            return;
        }
        if ((t1 == 1 || t1 == 2) && t2 == 0) {
            t2 = t1;
        }
        if ((t2 == 1 || t2 == 2) && t1 == 0) {
            t1 = t2;
        }
        f[i][t1][t2] = Math.min(f[i][t1][t2], f[i - 1][s1][s2] + extra);
    }
}
/*
LCP 38. 守卫城堡
https://leetcode.cn/problems/7rLGCR/description/

城堡守卫游戏的胜利条件为使恶魔无法从出生点到达城堡。游戏地图可视作 2*N 的方格图，记作字符串数组 grid，其中：
- "." 表示恶魔可随意通行的平地；
- "#" 表示恶魔不可通过的障碍物，玩家可通过在 平地 上设置障碍物，即将 "." 变为 "#" 以阻挡恶魔前进；
- "S" 表示恶魔出生点，将有大量的恶魔该点生成，恶魔可向上/向下/向左/向右移动，且无法移动至地图外；
- "P" 表示瞬移点，移动到 "P" 点的恶魔可被传送至任意一个 "P" 点，也可选择不传送；
- "C" 表示城堡。
然而在游戏中用于建造障碍物的金钱是有限的，请返回玩家最少需要放置几个障碍物才能获得胜利。若无论怎样放置障碍物均无法获胜，请返回 -1。
注意：
- 地图上可能有一个或多个出生点
- 地图上有且只有一个城堡
提示：
grid.length == 2
2 <= grid[0].length == grid[1].length <= 10^4
grid[i][j] 仅包含字符 "."、"#"、"C"、"P"、"S"

动态规划。
如果「恶魔」能够走到「传送门」，那么「恶魔」就会支配所有的「传送门」。
因此，我们可以考虑两种情况：即允许「恶魔」走到「传送门」，或者不允许「恶魔」走到「传送门」。
- 对于第一种情况，我们可以将所有的「传送门」全部看成「恶魔」；
- 对于第二种情况，我们可以将所有的「传送门」全部看成「城堡」。
此时，网格中就只有「城堡」「恶魔」「空地」「障碍物」了，我们需要做的就是把「城堡」和「恶魔」之间互相分开。
使用两次动态规划解决上述问题，每一次动态规划考虑一种情况。
@zerotrac
 */