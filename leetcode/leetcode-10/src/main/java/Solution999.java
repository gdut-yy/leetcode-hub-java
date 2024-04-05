public class Solution999 {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int numRookCaptures(char[][] board) {
        int n = board.length;

        int sx = 0, sy = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'R') {
                    sx = i;
                    sy = j;
                    break;
                }
            }
        }

        int ans = 0;
        for (int[] d : DIRECTIONS) {
            for (int step = 1; ; step++) {
                int nx = sx + d[0] * step;
                int ny = sy + d[1] * step;
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (board[nx][ny] == 'B') {
                        break;
                    } else if (board[nx][ny] == 'p') {
                        ans++;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return ans;
    }
}
/*
999. 可以被一步捕获的棋子数
https://leetcode.cn/problems/available-captures-for-rook/description/

在一个 8 x 8 的棋盘上，有一个白色的车（Rook），用字符 'R' 表示。棋盘上还可能存在空方块，白色的象（Bishop）以及黑色的卒（pawn），分别用字符 '.'，'B' 和 'p' 表示。不难看出，大写字符表示的是白棋，小写字符表示的是黑棋。
车按国际象棋中的规则移动。东，西，南，北四个基本方向任选其一，然后一直向选定的方向移动，直到满足下列四个条件之一：
- 棋手选择主动停下来。
- 棋子因到达棋盘的边缘而停下。
- 棋子移动到某一方格来捕获位于该方格上敌方（黑色）的卒，停在该方格内。
- 车不能进入/越过已经放有其他友方棋子（白色的象）的方格，停在友方棋子前。
你现在可以控制车移动一次，请你统计有多少敌方的卒处于你的捕获范围内（即，可以被一步捕获的棋子数）。
提示：
board.length == board[i].length == 8
board[i][j] 可以是 'R'，'.'，'B' 或 'p'
只有一个格子上存在 board[i][j] == 'R'

枚举。遍历 4 个方向。
时间复杂度 O(n^2)
 */