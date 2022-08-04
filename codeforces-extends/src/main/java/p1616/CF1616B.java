package p1616;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class CF1616B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(reader.readLine());
            String line = reader.readLine();
            writer.write(solution(n, line).concat(System.lineSeparator()));
        }
        writer.close();
        reader.close();
    }

    private static String solution(int n, String line) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(line.charAt(0));
        for (int i = 1; i < n; i++) {
            if (i == 1) {
                if (line.charAt(1) < line.charAt(0)) {
                    stringBuilder.append(line.charAt(i));
                } else {
                    break;
                }
            } else {
                if (line.charAt(i) <= line.charAt(i - 1)) {
                    stringBuilder.append(line.charAt(i));
                } else {
                    break;
                }
            }

        }
        String left = stringBuilder.toString();
        String right = stringBuilder.reverse().toString();
        return left + right;
    }
}
/*
B. Mirror in the String
https://codeforces.com/contest/1616/problem/B

题目大意：
给出字符串 s，从左往右看，在第 i 个字母后放置一面镜子，求看到的字符串中字典序最小的字符串。

如 s="codeforces"，镜像字符串有 "cc", "cooc", "coddoc", ... 显然 cc 字典序最小
贪心。字符的值不能大于前一位字符的值
注意陷阱：
cbb => "cbbbbc" not "cbbc"
ccc => "cc"
======

input
4
10
codeforces
9
cbacbacba
3
aaa
4
bbaa

output
cc
cbaabc
aa
bb
 */
