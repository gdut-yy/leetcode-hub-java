import java.util.Arrays;

public class SolutionLCP76 {
    // https://www.bilibili.com/video/BV1dg4y1j78A/
    private static final int[][] TRANS = {
            // (填 B 之后的状态，填 R 之后的状态)
            // 0. 空
            // 1. 一个 B
            // 2. 一个 R
            // 3. 连续多个 B
            // 4. 连续多个 R
            // 5. BR 交替，且以 B 结尾
            // 6. BR 交替，且以 R 结尾
            {1, 2},
            {3, 6},
            {5, 4},
            {3, -1},
            {-1, 4},
            {-1, 6},
            {5, -1},
    };

    private int n, m;
    private char[][] board;
    private long[][] memo;

    public long getSchemeCount(int n, int m, String[] chessboard) {
        // 1 <= n*m <= 30 意味着什么？在旋转后，保证列数 m <= 5

        // 用 3 个比特表示 7 个状态
        // 所有列的状态组合起来 pow(7, m) 个状态 => 状态压缩
        // 每一排从左到右增量去构造 ? => 留空/B/R
        this.n = n;
        this.m = m;
        this.board = strings2chars2(chessboard);

        if (n < m) {
            this.n = m;
            this.m = n;
            this.board = rotate(board);
        }

        memo = new long[this.n + 1][1 << (this.m * 3)];
        for (int i = 0; i < this.n + 1; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(0, 0);
    }

    private char[][] strings2chars2(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        char[][] res = new char[n][m];
        for (int i = 0; i < n; i++) {
            res[i] = strs[i].toCharArray();
        }
        return res;
    }

    // 行列转换
    private char[][] rotate(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        char[][] res = new char[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[j][i] = board[i][j];
            }
        }
        return res;
    }

    private long dfs(int r, int mask) {
        if (memo[r][mask] != -1) {
            return memo[r][mask];
        }
        if (r == n) {
            return 1;
        }
        long res = dfs(r, 0, 0, mask);
        memo[r][mask] = res;
        return res;
    }

    private long dfs(int r, int c, int rowMask, int colMask) {
        if (c == m) {
            return dfs(r + 1, colMask);
        }
        char b = board[r][c];
        if (b == 'B') {
            return nxt(r, c, rowMask, colMask, 0);
        } else if (b == 'R') {
            return nxt(r, c, rowMask, colMask, 1);
        } else if (b == '.') {
            return dfs(r, c + 1, rowMask, colMask);
        } else {
            return nxt(r, c, rowMask, colMask, 0)
                    + nxt(r, c, rowMask, colMask, 1)
                    + dfs(r, c + 1, rowMask, colMask);
        }
    }

    // (r,c) 填充颜色 color，判断是否合法
    // 如果合法，就生成新的 rowMask 和 colMask
    private long nxt(int r, int c, int rowMask, int colMask, int color) {
        // 新的 rowMask
        int rm = TRANS[rowMask][color];
        if (rm < 0) {
            return 0;
        }
        int c3 = c * 3;
        // 新的 colMask 的第 c 列
        int cm = TRANS[(colMask >> c3) & 7][color];
        if (cm < 0) {
            return 0;
        }
        // 修改 colMask 的第 c 列
        cm = colMask & ~(7 << c3) | (cm << c3);
        return dfs(r, c + 1, rm, cm);
    }
}
/*
LCP 76. 魔法棋盘
https://leetcode.cn/problems/1ybDKD/

LCCUP'23 春季个人赛 T5。

在大小为 n * m 的棋盘中，有两种不同的棋子：黑色，红色。当两颗颜色不同的棋子同时满足以下两种情况时，将会产生魔法共鸣：
- 两颗异色棋子在同一行或者同一列
- 两颗异色棋子之间恰好只有一颗棋子
注：异色棋子之间可以有空位
由于棋盘上被施加了魔法禁制，棋盘上的部分格子变成问号。chessboard[i][j] 表示棋盘第 i 行 j 列的状态：
- 为 . ，表示当前格子确定为空
- 为 B ，表示当前格子确定为 黑棋
- 为 R ，表示当前格子确定为 红棋
- 为 ? ，表示当前格子待定
现在，探险家小扣的任务是确定所有问号位置的状态（留空/放黑棋/放红棋），使最终的棋盘上，任意两颗棋子间都 无法 产生共鸣。请返回可以满足上述条件的放置方案数量。
提示：
n == chessboard.length
m == chessboard[i].length
1 <= n*m <= 30
chessboard 中仅包含 "."、"B"、"R"、"?"

自动机 + 状态压缩 + 记忆化搜索
https://leetcode.cn/problems/1ybDKD/solution/zhuang-ya-dp-bao-sou-xia-yi-ge-zhuang-ta-9dad/
时间复杂度 O(n·21^m) 在全为 ? 的情况下，dfs 最多调用 5601518 次。
空间复杂度 O(n·8^m)
 */