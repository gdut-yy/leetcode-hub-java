package p1593;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class CF1593A {
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
        int b = Integer.parseInt(lines[1]);
        int c = Integer.parseInt(lines[2]);
        int max = Math.max(a, Math.max(b, c));
        if (a == b && b == c) {
            return "1 1 1";
        } else if (a == b && a == max) {
            return "1 1 " + (max - c + 1);
        } else if (b == c && b == max) {
            return max - a + 1 + " 1 1";
        } else if (a == c && a == max) {
            return "1 " + (max - b + 1) + " 1";
        } else if (a == max) {
            return "0 " + (max - b + 1) + " " + (max - c + 1);
        } else if (b == max) {
            return max - a + 1 + " 0 " + (max - c + 1);
        } else {
            return (max - a + 1) + " " + (max - b + 1) + " 0";
        }
    }
}
/*
Codeforces Round #748 (Div. 3)
A. Elections
https://codeforces.com/contest/1593/problem/A

题目大意：
给出整数 a,b,c。为三名选举候选人获票数, 问对于每个候选人，最少增加多少选票能赢得选举。

分情况讨论
case1: a == b == c
case2: a == b > c
case3: a < b == c
case4: a == c > b
case5: a == max
case6: b == max
case7: c == max
======

input
5
0 0 0
10 75 15
13 13 17
1000 0 0
0 1000000000 0

output
1 1 1
66 0 61
5 5 0
0 1001 1001
1000000001 0 1000000001
 */