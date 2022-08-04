package p1703;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class CF1703B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            String line1 = reader.readLine();
            String line2 = reader.readLine();
            writer.write(solution(line1, line2).concat(System.lineSeparator()));
        }
        writer.close();
        reader.close();
    }

    private static String solution(String line1, String line2) {
        boolean[] visited = new boolean[26];
        int cnt = 0;
        for (char ch : line2.toCharArray()) {
            int idx = ch - 'A';
            if (!visited[idx]) {
                visited[idx] = true;
                cnt += 2;
            } else {
                cnt += 1;
            }
        }
        return String.valueOf(cnt);
    }
}
/*
B. ICPC Balloons
https://codeforces.com/contest/1703/problem/B

题目大意：
给定整数 n 和长为 n 的字符串 s，第一个解决问题的团队会得到另外一个气球。问这队收到气球的数量。

模拟，如果是第一次出现的字符 +2，否则 +1，求和。
======

input
6
3
ABA
1
A
3
ORZ
5
BAAAA
4
BKPT
10
CODEFORCES

output
5
2
6
7
8
17
 */