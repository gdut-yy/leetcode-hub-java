package p1674;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class CF1674A {
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
        int x = Integer.parseInt(lines[0]);
        int y = Integer.parseInt(lines[1]);

        // y = x * b^a
        for (int a = 1; a <= 100; a++) {
            for (int b = 1; b <= 100; b++) {
                if ((int) (x * Math.pow(b, a)) == y) {
                    return a + " " + b;
                } else if ((int) (x * Math.pow(b, a)) > y) {
                    break;
                }
            }
        }
        return "0 0";
    }
}
/*
Codeforces Round #786 (Div. 3)
A. Number Transformation
https://codeforces.com/contest/1674/problem/A

题目大意：
给定正整数 x 和 y，求是否存在 a,b 使得 y = x * b^a，若存在，输出任意 a,b，若不存在，输出两次整数 0。

(1≤x,y≤100) 直接暴力枚举即可。
======

input
3
3 75
100 100
42 13

output
2 5
3 1
0 0
 */