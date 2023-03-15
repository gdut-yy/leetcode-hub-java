import java.util.ArrayList;
import java.util.List;

public class SolutionLCP41 {
    private static final int[][] DIRECTIONS8 = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};
    private int M;
    private int N;

    public int flipChess(String[] chessboard) {
        M = chessboard.length;
        N = chessboard[0].length();
        char[][] chars = new char[M][N];
        for (int i = 0; i < M; i++) {
            chars[i] = chessboard[i].toCharArray();
        }

        int max = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (chars[i][j] == '.') {
                    max = Math.max(max, dfs(chars, i, j));
                }
            }
        }
        return max;
    }

    private int dfs(char[][] chars, int ii, int jj) {
        char[][] charsCopy = new char[M][N];
        for (int k = 0; k < M; k++) {
            System.arraycopy(chars[k], 0, charsCopy[k], 0, N);
        }
        charsCopy[ii][jj] = 'X';

        int res = 0;
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (charsCopy[i][j] == 'X') {
                    cnt += getNum(charsCopy, i, j);
                }
            }
        }
        res += cnt;
        while (cnt != 0) {
            cnt = 0;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (charsCopy[i][j] == 'X') {
                        cnt += getNum(charsCopy, i, j);
                    }
                }
            }
            res += cnt;
        }
        return res;
    }


    private int getNum(char[][] chars, int i, int j) {
        List<int[]> list = new ArrayList<>();
        for (int[] dir : DIRECTIONS8) {
            List<int[]> tmp = new ArrayList<>();
            for (int nextM = i + dir[0], nextN = j + dir[1];
                 nextM >= 0 && nextM < M && nextN >= 0 && nextN < N;
                 nextM += dir[0], nextN += dir[1]) {
                if (chars[nextM][nextN] == '.') {
                    break;
                }
                if (chars[nextM][nextN] == 'O') {
                    tmp.add(new int[]{nextM, nextN});
                }
                if (chars[nextM][nextN] == 'X') {
                    list.addAll(tmp);
                    break;
                }
            }
        }
        for (int[] ints : list) {
            chars[ints[0]][ints[1]] = 'X';
        }
        return list.size();
    }
}
/*
LCP 41. 黑白翻转棋
https://leetcode.cn/problems/fHi6rV/

LCCUP 力扣杯 2021 秋季编程大赛个人赛 T3。

在 n*m 大小的棋盘中，有黑白两种棋子，黑棋记作字母 "X", 白棋记作字母 "O"，空余位置记作 "."。
当落下的棋子与其他相同颜色的棋子在行、列或对角线完全包围（中间不存在空白位置）另一种颜色的棋子，则可以翻转这些棋子的颜色。
「力扣挑战赛」黑白翻转棋项目中，将提供给选手一个未形成可翻转棋子的棋盘残局，其状态记作 chessboard。若下一步可放置一枚黑棋，请问选手最多能翻转多少枚白棋。
注意：
若翻转白棋成黑棋后，棋盘上仍存在可以翻转的白棋，将可以 继续 翻转白棋
输入数据保证初始棋盘状态无可以翻转的棋子且存在空余位置
提示：
1 <= chessboard.length, chessboard[i].length <= 8
chessboard[i] 仅包含 "."、"O" 和 "X"
 */