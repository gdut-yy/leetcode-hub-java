package p1675;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class CF1675A {
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
        int x = Integer.parseInt(lines[3]);
        int y = Integer.parseInt(lines[4]);

        if (a + c >= x && b + c >= y && a + b + c >= x + y) {
            return "YES";
        }
        return "NO";
    }
}
/*
Codeforces Round #787 (Div. 3)
A. Food for Animals
https://codeforces.com/contest/1675/problem/A

题目大意：
给定 a 袋狗粮，b 袋猫粮，c 袋通用食品（既适合猫又适合狗），x 只狗，y 只猫，问是否每只猫和狗都能够 1 袋粮食

简单判断即可。
======

input
7
1 1 4 2 3
0 0 0 0 0
5 5 0 4 6
1 1 1 1 1
50000000 50000000 100000000 100000000 100000000
0 0 0 100000000 100000000
1 3 2 2 5

output
YES
YES
NO
YES
YES
NO
NO
 */