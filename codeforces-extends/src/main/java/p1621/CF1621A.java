package p1621;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class CF1621A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            String line = reader.readLine();
            writer.write(solution(line).concat(System.lineSeparator()));
        }
        writer.close();
        reader.close();
    }

    private static String solution(String line) {
        String[] lines = line.split(" ");
        int n = Integer.parseInt(lines[0]);
        int k = Integer.parseInt(lines[1]);
        if (k + k - 1 > n) {
            return "-1";
        } else {
            char[][] chars = new char[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(chars[i], '.');
            }
            for (int i = 0; i < k; i++) {
                chars[i * 2][i * 2] = 'R';
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < n; i++) {
                stringBuilder.append(new String(chars[i]));
                if (i != n - 1) {
                    stringBuilder.append(System.lineSeparator());
                }
            }
            return stringBuilder.toString();
        }
    }
}
/*
Hello 2022
A. Stable Arrangement of Rooks
https://codeforces.com/contest/1621/problem/A

题目大意：
给出整数 n，求在 n*n 矩阵中放置多少个 rook。rook 可以移动到相邻的单元格，且可以打败同行或同列的 rook。

贪心，从左上到右下 沿矩阵的副对角线放置。间隔一行一列即可。
======

input
5
3 2
3 3
1 1
5 2
40 33

output
..R
...
R..
-1
R
.....
R....
.....
....R
.....
-1
 */