package p1579;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class MainA {
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
        int cntAC = 0;
        int cntB = 0;
        for (char ch : line.toCharArray()) {
            if (ch == 'B') {
                cntB++;
            } else {
                cntAC++;
            }
        }
        return cntB == cntAC ? "YES" : "NO";
    }
}
/*
Codeforces Round #744 (Div. 3)
A - Casimir's String Solitaire
https://codeforces.com/contest/1579/problem/A

题目大意：
给出字符串 s。s 只包含 'A','B','C' 三种字符，每次操作可去除 1个'A'和 1个'B'，或去除 1个'B'和 1个'C'，问最后能否成为空串。

统计字符频次，判断 'B'的频次是否等于 'A','C'频次之和即可。
======

input
6
ABACAB
ABBA
AC
ABC
CABCBB
BCBCBCBCBCBCBCBC

output
NO
YES
NO
NO
YES
YES
 */