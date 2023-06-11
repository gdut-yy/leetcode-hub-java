package p1669;

import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class CF1669G {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            char[][] chars = new char[n][m];
            for (int j = 0; j < n; j++) {
                chars[j] = scanner.next().toCharArray();
            }

            List<String> res = solve(n, m, chars);
            for (String re : res) {
                System.out.println(re);
            }
        }
    }

    private static List<String> solve(int n, int m, char[][] chars) {
        // 每一列
        for (int j = 0; j < m; j++) {
            Deque<Integer> deque = new ArrayDeque<>();
            int cntStone = 0;
            // 由下往上
            for (int i = n - 1; i >= 0; i--) {
                if (chars[i][j] == 'o') {
                    deque.addLast(cntStone);
                    cntStone = 0;
                    continue;
                }
                if (chars[i][j] == '*') {
                    cntStone++;
                }
            }
            deque.addLast(cntStone);

            int stones = deque.removeFirst();
            for (int i = n - 1; i >= 0; i--) {
                if (chars[i][j] == 'o') {
                    stones = deque.removeFirst();
                    continue;
                }

                if (stones > 0) {
                    chars[i][j] = '*';
                } else {
                    chars[i][j] = '.';
                }
                stones--;
            }
        }

        // res
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(new String(chars[i]));
        }
        return res;
    }
}
/*
G. Fall Down
https://codeforces.com/contest/1669/problem/G

题目大意：
An empty cell, denoted with '.'.
A stone, denoted with '*'.
An obstacle, denoted with the lowercase Latin letter 'o'.
给定矩阵，字符分别代表空格、石头、障碍，求石头下落后的最终状态。

纯模拟。
======

input
3
6 10
.*.*....*.
.*.......*
...o....o.
.*.*....*.
..........
.o......o*
2 9
...***ooo
.*o.*o.*o
5 5
*****
*....
*****
....*
*****

output
..........
...*....*.
.*.o....o.
.*........
.*......**
.o.*....o*
....**ooo
.*o**o.*o
.....
*...*
*****
*****
*****
 */