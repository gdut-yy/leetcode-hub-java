package p1669;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class CF1669D {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            String line1 = reader.readLine();
            String line2 = reader.readLine();
            writer.write(solution(line2).concat(System.lineSeparator()));
        }
        writer.close();
        reader.close();
    }

    private static String solution(String line) {
        String[] lines = line.split("W");
        for (String s : lines) {
            if (s.length() > 0) {
                int cntB = 0;
                int cntR = 0;
                for (char ch : s.toCharArray()) {
                    if (ch == 'B') {
                        cntB++;
                    } else {
                        cntR++;
                    }
                }
                if (cntB == 0 || cntR == 0) {
                    return "NO";
                }
            }
        }
        return "YES";
    }
}
/*
D. Colorful Stamp
https://codeforces.com/contest/1669/problem/D

题目大意：
给定长度为 n 的字符串，问是否能基于长为 n 的全 'W' 字符串 + 'BR'/'RB' 拼接而成。

奇偶性可知，任意长度 BR 片段，至少含有一个 B 和一个 R。
======

input
12
5
BRBBW
1
B
2
WB
2
RW
3
BRB
3
RBB
7
WWWWWWW
9
RBWBWRRBW
10
BRBRBRBRRB
12
BBBRWWRRRWBR
10
BRBRBRBRBW
5
RBWBW

output
YES
NO
NO
NO
YES
YES
YES
NO
YES
NO
YES
NO
 */