package p1703;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class CF1703A {
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
        return line.equalsIgnoreCase("YES") ? "YES" : "NO";
    }
}
/*
Codeforces Round #806 (Div. 4)
A. YES or YES?
https://codeforces.com/contest/1703/problem/A

题目大意：
给定字符串 s，判断 s 是否为 YES（不区分大小写）

模拟。
======

input
10
YES
yES
yes
Yes
YeS
Noo
orZ
yEz
Yas
XES

output
YES
YES
YES
YES
YES
NO
NO
NO
NO
NO
 */