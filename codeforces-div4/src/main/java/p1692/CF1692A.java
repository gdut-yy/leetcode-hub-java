package p1692;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class CF1692A {
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
        int a = Integer.parseInt(lines[0]);

        int cnt = 0;
        for (int i = 1; i < 4; i++) {
            if (Integer.parseInt(lines[i]) > a) {
                cnt++;
            }
        }
        return String.valueOf(cnt);
    }
}
/*
Codeforces Round #799 (Div. 4)
A. Marathon
https://codeforces.com/contest/1692/problem/A

题目大意：
给定 4 个整数 a,b,c,d，代表马拉松比赛 4 人 跑过的距离，求在 a 前面的人数。

模拟。
======

input
4
2 3 4 1
10000 0 1 2
500 600 400 300
0 9999 10000 9998

output
2
0
1
3
 */