package p1626;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class CF1626A {
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
        char[] chars = line.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
/*
Educational Codeforces Round 121 (Rated for Div. 2)
A. Equidistant Letters
https://codeforces.com/contest/1626/problem/A

题目大意：
给出字符串 s，s 中每个字母出现次数不超过 2 次，要求输出一种排列，使 s 中出现两次的字母之间的距离相同。

直接排序即可。
======

input
3
oelhl
abcdcba
ac

output
hello
ababcdc
ac
 */
