package p1624;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class CF1624B {
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

        // 分类讨论

        int diff1 = b - a;
        int c1 = b + diff1;
        if (c1 > 0 && c1 % c == 0) {
            return "YES";
        }

        int diff2 = c - b;
        int a1 = b - diff2;
        if (a1 > 0 && a1 % a == 0) {
            return "YES";
        }

        if ((c - a) % 2 == 0) {
            int diff3 = (c - a) / 2;
            int b1 = a + diff3;
            if (b1 > 0 && b1 % b == 0) {
                return "YES";
            }
        }

        return "NO";
    }
}
/*
B. Make AP
https://codeforces.com/contest/1624/problem/B

题目大意：
给出三个正整数 a,b,c，判断是否存在一个正整数 m，使得 a,b,c 任一数乘 m 后，能形成等差数列。

分类讨论，因为只能改变一个数，最多只有 3 种情况，其余两个数的差值是不会变的，判断能否反推出 m 即可。
======

input
11
10 5 30
30 5 10
1 2 3
1 6 3
2 6 3
1 1 1
1 1 2
1 1 3
1 100000000 1
2 1 1
1 2 2

output
YES
YES
YES
YES
NO
YES
NO
YES
YES
NO
YES
 */