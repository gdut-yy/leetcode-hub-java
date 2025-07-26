public class Solution782 {
    // 宫水三叶：构造分析题 https://leetcode.cn/problems/transform-to-chessboard/solutions/1769277/by-ac_oier-vf1m/
    static class V1 {
        private static final int INF = (int) 1e9;

        public int movesToChessboard(int[][] board) {
            int n = board.length;
            int full = (1 << n) - 1;
            int r1 = -1, r2 = -1, c1 = -1, c2 = -1;
            for (int i = 0; i < n; i++) {
                int a = 0, b = 0;
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 1) a += (1 << j);
                    if (board[j][i] == 1) b += (1 << j);
                }
                if (r1 == -1) r1 = a;
                else if (r2 == -1 && a != r1) r2 = a;
                if (c1 == -1) c1 = b;
                else if (c2 == -1 && b != c1) c2 = b;
                if (a != r1 && a != r2) return -1;
                if (b != c1 && b != c2) return -1;
            }
            if (r2 == -1 || c2 == -1) return -1;
            if ((r1 ^ r2) != full || (c1 ^ c2) != full) return -1;
            int t = 0;
            for (int i = 0; i < n; i += 2) t += (1 << i);
            int ans = Math.min(getCnt(r1, t), getCnt(r2, t)) + Math.min(getCnt(c1, t), getCnt(c2, t));
            return ans >= INF ? -1 : ans;
        }

        private int getCnt(int a, int b) {
            return Integer.bitCount(a) != Integer.bitCount(b) ? INF : Integer.bitCount(a ^ b) / 2;
        }
    }

    // 灵茶山艾府：逆向思维 https://leetcode.cn/problems/transform-to-chessboard/solutions/2997293/tu-jie-ni-xiang-si-wei-pythonjavaccgojsr-mixb/
    static class V2 {
        public int movesToChessboard(int[][] board) {
            int n = board.length;
            int[] firstRow = board[0];
            int[] firstCol = new int[n];
            int[] rowCnt = new int[2];
            int[] colCnt = new int[2];
            for (int i = 0; i < n; i++) {
                rowCnt[firstRow[i]]++; // 统计 0 和 1 的个数
                firstCol[i] = board[i][0];
                colCnt[firstCol[i]]++;
            }
            // 第一行，0 和 1 的个数之差不能超过 1
            // 第一列，0 和 1 的个数之差不能超过 1
            if (Math.abs(rowCnt[0] - rowCnt[1]) > 1 || Math.abs(colCnt[0] - colCnt[1]) > 1) {
                return -1;
            }

            // 每一行和第一行比较，要么完全相同，要么完全不同
            for (int[] row : board) {
                boolean same = row[0] == firstRow[0];
                for (int i = 0; i < n; i++) {
                    if ((row[i] == firstRow[i]) != same) {
                        return -1;
                    }
                }
            }
            return minSwap(firstRow, rowCnt) + minSwap(firstCol, colCnt);
        }

        // 计算最小交换次数
        private int minSwap(int[] s, int[] cnt) {
            int n = s.length;
            int x0 = cnt[1] > cnt[0] ? 1 : 0; // 如果 n 是偶数，x0 是 0
            int diff = 0;
            for (int i = 0; i < n; i++) {
                // 计算规则见题解正文最后一段，这里 t[i] = i % 2 ^ x0
                diff += s[i] ^ i % 2 ^ x0;
            }
            return n % 2 > 0 ? diff / 2 : Math.min(diff, n - diff) / 2;
        }
    }
}
/*
782. 变为棋盘
https://leetcode.cn/problems/transform-to-chessboard/description/

一个 n x n 的二维网络 board 仅由 0 和 1 组成 。每次移动，你能交换任意两列或是两行的位置。
返回 将这个矩阵变为  “棋盘”  所需的最小移动次数 。如果不存在可行的变换，输出 -1。
“棋盘” 是指任意一格的上下左右四个方向的值均与本身不同的矩阵。
提示：
n == board.length
n == board[i].length
2 <= n <= 30
board[i][j] 将只包含 0或 1

时间复杂度 O(n^2)。
 */