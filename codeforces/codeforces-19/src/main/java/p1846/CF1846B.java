package p1846;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1846B {
    static char[][] board;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            board = new char[3][3];
            for (int i = 0; i < 3; i++) {
                board[i] = scanner.next().toCharArray();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        if (check('X')) return "X";
        if (check('O')) return "O";
        if (check('+')) return "+";
        return "DRAW";
    }

    private static boolean check(char t) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == t && board[i][1] == t && board[i][2] == t) return true;
        }
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == t && board[1][j] == t && board[2][j] == t) return true;
        }
        if (board[0][0] == t && board[1][1] == t && board[2][2] == t) return true;
        if (board[0][2] == t && board[1][1] == t && board[2][0] == t) return true;
        return false;
    }
}
/*
B. Rudolph and Tic-Tac-Toe
https://codeforces.com/contest/1846/problem/B

题目大意：
鲁道夫发明了三人井字游戏。它有经典的规则，除了第三个玩加号的人。鲁道夫有一个 3×3 字段-完成游戏的结果。每个字段单元格要么包含一个叉号，要么包含一个零，要么包含一个加号，要么什么都不包含。玩家在水平、垂直或对角线上排成一行 3 个他们的符号就赢了。
鲁道夫想知道比赛的结果。三名选手中要么只有一人获胜，要么打成平局。保证多个玩家不能同时获胜。

暴力
======

input
5
+X+
OXO
OX.
O+.
+OX
X+O
.XO
OX.
+++
O.+
X.O
+..
.++
X.O
+..
output
X
O
+
DRAW
DRAW
 */