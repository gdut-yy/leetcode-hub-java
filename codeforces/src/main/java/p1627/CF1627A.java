package p1627;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class CF1627A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            String line1 = reader.readLine();
            String[] line1s = line1.split(" ");
            int n = Integer.parseInt(line1s[0]);
            int m = Integer.parseInt(line1s[1]);
            int r = Integer.parseInt(line1s[2]);
            int c = Integer.parseInt(line1s[3]);
            char[][] chars = new char[n][m];
            for (int j = 0; j < n; j++) {
                chars[j] = reader.readLine().toCharArray();
            }
            writer.write(solution(n, m, r, c, chars).concat(System.lineSeparator()));
        }
        writer.close();
        reader.close();
    }

    private static String solution(int n, int m, int r, int c, char[][] chars) {
        // BFS
        if (chars[r - 1][c - 1] == 'B') {
            return "0";
        }
        for (int i = 0; i < n; i++) {
            if (chars[i][c - 1] == 'B') {
                return "1";
            }
        }
        for (int j = 0; j < m; j++) {
            if (chars[r - 1][j] == 'B') {
                return "1";
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (chars[i][j] == 'B') {
                    return "2";
                }
            }
        }
        return "-1";
    }
}
/*
Codeforces Round #766 (Div. 2)
A. Not Shading
https://codeforces.com/contest/1627/problem/A

题目大意：
给出整数 n, m, r, c。以及 n 行表示的 n * m 矩阵。规定一次操作可以选一个黑色单元格，使其所在行涂成黑色或者其所在列涂成黑色，求 r 行 c 列变黑色的最小操作数。

贪心，分三种情况讨论：
1、(r, c) 为黑色 => 最小操作数 0
2、不满足 1，(r, c) 所在行或所在列为黑色 => 最小操作数 1
3、不满足 2，矩阵中存在黑色 => 最小操作数 2
4、不满足 3，无解 -1
======

input
9
3 5 1 4
WBWWW
BBBWB
WWBBB
4 3 2 1
BWW
BBW
WBB
WWB
2 3 2 2
WWW
WWW
2 2 1 1
WW
WB
5 9 5 9
WWWWWWWWW
WBWBWBBBW
WBBBWWBWW
WBWBWBBBW
WWWWWWWWW
1 1 1 1
B
1 1 1 1
W
1 2 1 1
WB
2 1 1 1
W
B

output
1
0
-1
2
2
0
-1
1
1
 */