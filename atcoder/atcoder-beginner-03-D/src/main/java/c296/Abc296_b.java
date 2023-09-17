package c296;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc296_b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        char[][] gird = new char[8][8];
        for (int i = 0; i < 8; i++) {
            gird[i] = scanner.next().toCharArray();
        }
        System.out.println(solve(gird));
    }

    private static String solve(char[][] grid) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (grid[i][j] == '*') {
                    char c1 = (char) (j + 'a');
                    int c2 = 8 - i;
                    return String.valueOf(c1) + c2;
                }
            }
        }
        return "NA";
    }
}
/*
B - Chessboard
https://atcoder.jp/contests/abc296/tasks/abc296_b

题目大意：
我们有一个 8 行 8 列正方形的网格。每个方块有一个 2 个字符的名称，确定如下。
- 从左数第 1 列的方块名称的第一个字符是 a。同样，从左数第 2、3、…、8 列的方块名称的第一个字符分别是 b、c、d、e、f、g、h。
- 在倒数第 1 行中，正方形名称的第二个字符是 1。同样，从底部算起第 2、3、…、8 行正方形名称的第二个字符分别为 2、3、4、5、6、7、8。
例如，左下方的正方形命名为 a1，右下方的正方形命名为 h1，右上方的正方形命名为 h8。
给定 8 个字符串 s1，…，s8，每个字符串的长度为 8，表示网格的状态。s1 的第 j 个字符是*如果从上到下第 i 行，从左到第 j 列的正方形上有一块，并且。否则。字符*在 s1，…，s8 中只出现一次。找出上面有棋子的方块的名字。

模拟
======

Input
........
........
........
........
........
........
........
*.......
Output
a1

Input
........
........
........
........
........
.*......
........
........
Output
b3
 */