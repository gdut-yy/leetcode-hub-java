public class SolutionLCS03 {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private int m, n;
    private char[][] g;

    public int largestArea(String[] grid) {
        m = grid.length;
        n = grid[0].length();
        g = new char[m][];
        for (int i = 0; i < m; i++) {
            g[i] = grid[i].toCharArray();
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] != '0' && g[i][j] != '6') {
                    int res = dfs(g[i][j], i, j);
                    if (res != -1) ans = Math.max(ans, res);
                }
            }
        }
        return ans;
    }

    private int dfs(char ch, int i, int j) {
        g[i][j] = '6';
        int res = 1;
        for (int[] d : DIRECTIONS) {
            int nx = i + d[0];
            int ny = j + d[1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n || g[nx][ny] == '0') return -1;
            if (g[nx][ny] == ch) {
                int nxt = dfs(ch, nx, ny);
                if (nxt == -1) return -1;
                res += nxt;
            }
        }
        return res;
    }
}
/*
LCS 03. 主题空间
https://leetcode.cn/problems/YesdPw/description/

「以扣会友」线下活动所在场地由若干主题空间与走廊组成，场地的地图记作由一维字符串型数组 grid，字符串中仅包含 "0"～"5" 这 6 个字符。地图上每一个字符代表面积为 1 的区域，其中 "0" 表示走廊，其他字符表示主题空间。相同且连续（连续指上、下、左、右四个方向连接）的字符组成同一个主题空间。
假如整个 grid 区域的外侧均为走廊。请问，不与走廊直接相邻的主题空间的最大面积是多少？如果不存在这样的空间请返回 0。
提示：
1 <= grid.length <= 500
1 <= grid[i].length <= 500
grid[i][j] 仅可能为 "0"～"5"
 */