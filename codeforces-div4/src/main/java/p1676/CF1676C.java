package p1676;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class CF1676C {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            String[] line1 = reader.readLine().split(" ");
            int n = Integer.parseInt(line1[0]);
            int m = Integer.parseInt(line1[1]);
            String[] lineN = new String[n];
            for (int j = 0; j < n; j++) {
                lineN[j] = reader.readLine();
            }
            writer.write(solution(n, m, lineN).concat(System.lineSeparator()));
        }
        writer.close();
        reader.close();
    }

    private static String solution(int n, int m, String[] lineN) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                String s1 = lineN[i];
                String s2 = lineN[j];
                int sum = 0;
                for (int k = 0; k < m; k++) {
                    sum += Math.abs(s1.charAt(k) - s2.charAt(k));
                }
                min = Math.min(min, sum);
            }
        }
        return String.valueOf(min);
    }
}
/*
C. Most Similar Words
https://codeforces.com/contest/1676/problem/C

题目大意：
给定 n 个长度为 m 的字符串，求所有可能的 n 个单词对的最小差值。

暴力枚举。时间复杂度 O(n^2)
======

intput
6
2 4
best
cost
6 3
abb
zba
bef
cdu
ooo
zzz
2 7
aaabbbc
bbaezfe
3 2
ab
ab
ab
2 8
aaaaaaaa
zzzzzzzz
3 1
a
u
y

output
11
8
35
0
200
4
 */