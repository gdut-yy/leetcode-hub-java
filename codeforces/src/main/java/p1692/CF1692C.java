package p1692;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class CF1692C {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            String line = reader.readLine();
            String[] lines = new String[8];
            for (int j = 0; j < 8; j++) {
                lines[j] = reader.readLine();
            }
            writer.write(solution(lines).concat(System.lineSeparator()));
        }
        writer.close();
        reader.close();
    }

    private static String solution(String[] lines) {
        char[][] chars = new char[8][8];
        for (int i = 0; i < 8; i++) {
            chars[i] = lines[i].toCharArray();
        }

        for (int i = 1; i < 8; i++) {
            for (int j = 1; j < 8; j++) {
                if (chars[i][j] == '#'
                        && chars[i - 1][j - 1] == '#' && chars[i - 1][j + 1] == '#'
                        && chars[i + 1][j - 1] == '#' && chars[i + 1][j + 1] == '#') {
                    return (i + 1) + " " + (j + 1);
                }
            }
        }
        return "";
    }
}
/*
C. Where's the Bishop?
https://codeforces.com/contest/1692/problem/C

题目大意：
给定 8*8 棋盘，主教沿对角线攻击，已知主教的能攻击到的放格，求主教所在的位置。

8*8 暴力模拟。
======

input
3

.....#..
#...#...
.#.#....
..#.....
.#.#....
#...#...
.....#..
......#.

#.#.....
.#......
#.#.....
...#....
....#...
.....#..
......#.
.......#

.#.....#
..#...#.
...#.#..
....#...
...#.#..
..#...#.
.#.....#
#.......

output
4 3
2 2
4 5
 */