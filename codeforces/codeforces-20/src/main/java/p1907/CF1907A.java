package p1907;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF1907A {
    static String s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            s = scanner.next();
            System.out.println(solve());
        }
    }

    private static String solve() {
        char c1 = s.charAt(0);
        int c2 = s.charAt(1) - '0';
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            if (c2 != i) {
                ans.add("" + c1 + i);
            }
        }
        for (char i = 'a'; i <= 'h'; i++) {
            if (c1 != i) {
                ans.add("" + i + c2);
            }
        }
        return String.join(System.lineSeparator(), ans);
    }
}
/*
Codeforces Round 913 (Div. 3)
A. Rook
https://codeforces.com/contest/1907/problem/A

题目大意：
你可能知道，国际象棋是一种在棋盘上玩的游戏，棋盘上有 64 个方格，排列成 8×8 网格。该板的列用字母 a ~ h 标识，行用数字 1 ~ 8 标识。每个正方形由它所属的行和列来描述。
车是国际象棋中的一个棋子。在它的回合中，它可以水平或垂直移动任意非零个数的方块。你的任务是在一个空的棋盘上找到一辆车的所有可能的走法。

======

input
1
d5
output
d1
d2
b5
g5
h5
d3
e5
f5
d8
a5
d6
d7
c5
d4
 */