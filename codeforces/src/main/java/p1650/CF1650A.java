package p1650;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class CF1650A {
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
        char ch = line2.charAt(0);
        int len = line1.length();
        for (int i = 0; i < len; i++) {
            if (line1.charAt(i) == ch) {
                int left = i;
                int right = len - 1 - i;
                if (left % 2 == 0 && right % 2 == 0) {
                    return "YES";
                }
            }
        }
        return "NO";
    }
}
/*
Codeforces Round #776 (Div. 3)
A. Deletions of Two Adjacent Letters
https://codeforces.com/contest/1650/problem/A

题目大意：
给定字符串 s 和字符 c，要求每次可以删除相邻的两个字母，问字符串最终能否变成 c

贪心，找出每个 c，判等其前后字符数量是否为偶数即可。
=======

input
5
abcde
c
abcde
b
x
y
aaaaaaaaaaaaaaa
a
contest
t

output
YES
NO
NO
YES
YES
 */