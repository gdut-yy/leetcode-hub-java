package p1674;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class CF1674C {
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
        // t 等于 "a" 换了等于没换
        if (line2.equals("a")) {
            return "1";
        }

        // 如果 t 含 'a' 且不为 "a"，则无限大
        if (line2.contains("a")) {
            return "-1";
        }

        int n = line1.length();
        return String.valueOf((long) Math.pow(2, n));
    }
}
/*
C. Infinite Replacement
https://codeforces.com/contest/1674/problem/C

题目大意：
给定一个只包含 'a' 的字符串 s 和只包含小写字母的字符串 t。一次操作可用 t 替换 s 中的 'a'，可以进行任意（包括 0）次操作。
求可以获得的不同字符串的数量 s。如果数字无限大，则输出-1。

分三种情况：
t = "a" => 1
t 除了 'a' 还有其他字符 => 无穷大
t 只含非 'a' 字符 => 2^n 种可能
======

input
3
aaaa
a
aa
abc
a
b

output
1
-1
2
 */