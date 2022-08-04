package p1669;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Deque;

public class CF1669G {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            String[] line1s = reader.readLine().split(" ");
            int n = Integer.parseInt(line1s[0]);
            int m = Integer.parseInt(line1s[1]);
            String[] lines = new String[n];
            for (int j = 0; j < n; j++) {
                lines[j] = reader.readLine();
            }
            String[] res = solution(n, m, lines);
            // output
            for (String re : res) {
                writer.write(re);
                writer.write(System.lineSeparator());
            }
        }
        writer.close();
        reader.close();
    }

    private static String[] solution(int n, int m, String[] lines) {
        // n * m
        char[][] chars = new char[n][m];
        for (int i = 0; i < n; i++) {
            chars[i] = lines[i].toCharArray();
        }

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
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            res[i] = new String(chars[i]);
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