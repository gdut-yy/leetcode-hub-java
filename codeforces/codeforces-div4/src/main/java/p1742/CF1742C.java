package p1742;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class CF1742C {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            reader.readLine();
            String[] lines = new String[8];
            for (int j = 0; j < 8; j++) {
                lines[j] = reader.readLine();
            }
            System.out.println(solve(lines));
        }
    }

    private static String solve(String[] lines) {
        for (int i = 0; i < 8; i++) {
            if (lines[i].equals("RRRRRRRR")) {
                return "R";
            }
        }
        return "B";
    }
}
/*
C. Stripes
https://codeforces.com/contest/1742/problem/C

题目大意：
给定 8 行字符串，每行包含 8 个字符。每个字符都是'R'，'B'或'.'。按照一定的顺序，一些水平行被涂成红色，一些垂直列被涂成蓝色。确定最后使用的颜色。

遍历。不是 'R' 就是 'B'。
======

input
4

....B...
....B...
....B...
RRRRRRRR
....B...
....B...
....B...
....B...

RRRRRRRB
B......B
B......B
B......B
B......B
B......B
B......B
RRRRRRRB

RRRRRRBB
.B.B..BB
RRRRRRBB
.B.B..BB
.B.B..BB
RRRRRRBB
.B.B..BB
.B.B..BB

........
........
........
RRRRRRRR
........
........
........
........

output
R
B
B
R
 */