public class Solution289 {
    private static final int[][] DIRECTIONS8 = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] origin = new int[m][n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(board[i], 0, origin[i], 0, n);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cntLive = 0;
                for (int[] d : DIRECTIONS8) {
                    int nx = i + d[0];
                    int ny = j + d[1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                        if (origin[nx][ny] == 1) cntLive++;
                    }
                }
                if (board[i][j] == 1) {
                    // 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
                    board[i][j] = (cntLive == 2 || cntLive == 3) ? 1 : 0;
                } else {
                    // 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
                    board[i][j] = (cntLive == 3) ? 1 : 0;
                }
            }
        }
    }
}
/*
289. 生命游戏
https://leetcode.cn/problems/game-of-life/

根据 百度百科 ， 生命游戏 ，简称为 生命 ，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。
每个细胞都具有一个初始状态： 1 即为 活细胞 （live），或 0 即为 死细胞 （dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
1.如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
2.如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
3.如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
4.如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。给你 m x n 网格面板 board 的当前状态，返回下一个状态。
提示：
m == board.length
n == board[i].length
1 <= m, n <= 25
board[i][j] 为 0 或 1
进阶：
你可以使用原地算法解决本题吗？请注意，面板上所有格子需要同时被更新：你不能先更新某些格子，然后使用它们的更新后的值再更新其他格子。
本题中，我们使用二维数组来表示面板。原则上，面板是无限的，但当活细胞侵占了面板边界时会造成问题。你将如何解决这些问题？

拷贝数组，模拟。
 */