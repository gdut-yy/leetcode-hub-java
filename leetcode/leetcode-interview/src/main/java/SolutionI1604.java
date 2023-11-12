public class SolutionI1604 {
    private int n;

    public String tictactoe(String[] board) {
        n = board.length;
        int cntSpace = 0;
        // 主对角线, 次对角线
        int priDiag = 0, auxDiag = 0;
        for (int i = 0; i < n; i++) {
            // 水平, 垂直
            int horizontal = 0, vertical = 0;
            for (int j = 0; j < n; j++) {
                horizontal += getVal(board[i].charAt(j));
                vertical += getVal(board[j].charAt(i));
                if (board[i].charAt(j) == ' ') cntSpace++;
            }
            String ans = getAns(horizontal, vertical);
            if (ans != null) return ans;
            // 主对角线, 次对角线
            priDiag += getVal(board[i].charAt(i));
            auxDiag += getVal(board[i].charAt(n - 1 - i));
        }
        String ans = getAns(priDiag, auxDiag);
        if (ans != null) return ans;

        return cntSpace == 0 ? "Draw" : "Pending";
    }

    private String getAns(int cnt1, int cnt2) {
        if (cnt1 == n || cnt2 == n) return "X";
        if (cnt1 == -n || cnt2 == -n) return "O";
        return null;
    }

    private int getVal(char c) {
        if (c == ' ') return 0;
        return c == 'X' ? 1 : -1;
    }
}
/*
面试题 16.04. 井字游戏
https://leetcode.cn/problems/tic-tac-toe-lcci/description/

设计一个算法，判断玩家是否赢了井字游戏。输入是一个 N x N 的数组棋盘，由字符" "，"X"和"O"组成，其中字符" "代表一个空位。
以下是井字游戏的规则：
- 玩家轮流将字符放入空位（" "）中。
- 第一个玩家总是放字符"O"，且第二个玩家总是放字符"X"。
- "X"和"O"只允许放置在空位中，不允许对已放有字符的位置进行填充。
- 当有N个相同（且非空）的字符填充任何行、列或对角线时，游戏结束，对应该字符的玩家获胜。
- 当所有位置非空时，也算为游戏结束。
- 如果游戏结束，玩家不允许再放置字符。
如果游戏存在获胜者，就返回该游戏的获胜者使用的字符（"X"或"O"）；如果游戏以平局结束，则返回 "Draw"；如果仍会有行动（游戏未结束），则返回 "Pending"。
提示：
1 <= board.length == board[i].length <= 100
输入一定遵循井字棋规则
 */