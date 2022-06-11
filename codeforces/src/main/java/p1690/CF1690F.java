package p1690;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class CF1690F {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            String line1 = reader.readLine();
            String line2 = reader.readLine();
            String line3 = reader.readLine();
            writer.write(solution2(line1, line2, line3).concat(System.lineSeparator()));
        }
        writer.close();
        reader.close();
    }

    private static String solution2(String line1, String line2, String line3) {
        int n = Integer.parseInt(line1);
        String s = line2;
        String[] line3s = line3.split(" ");
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(line3s[i]) - 1;
        }

        long lcm = 1L;
        boolean[] visited = new boolean[n];
        int idx = 0;
        while (idx < n) {
            StringBuilder stringBuilder = new StringBuilder();
            while (!visited[idx]) {
                stringBuilder.append(s.charAt(idx));
                visited[idx] = true;
                idx = p[idx];
            }
            idx++;

            // .isEmpty() since 15
            if (stringBuilder.length() == 0) {
                continue;
            }

            long len = shift(stringBuilder);
            // 最小公倍数
            lcm = lcm / getGCD(lcm, len) * len;
        }
        return String.valueOf(lcm);
    }

    private static int shift(StringBuilder stringBuilder) {
        int len = stringBuilder.length();
        for (int i = 1; i <= len; i++) {
            String s0 = stringBuilder.toString();
            String s1 = s0.substring(i, len) + s0.substring(0, i);
            if (s0.equals(s1)) {
                return i;
            }
        }
        return -1;
    }

    private static long getGCD(long num1, long num2) {
        if (num1 == 0) {
            return num2;
        }
        return getGCD(num2 % num1, num1);
    }

//    private static String solution(String line1, String line2, String line3) {
//        int n = Integer.parseInt(line1);
//        String[] line3s = line3.split(" ");
//        int[] p = new int[n];
//        for (int i = 0; i < n; i++) {
//            p[i] = Integer.parseInt(line3s[i]);
//        }
//
//        String s = line2;
//        for (int k = 1; ; k++) {
//            char[] chars = s.toCharArray();
//            char[] newChars = new char[n];
//            for (int i = 0; i < n; i++) {
//                newChars[i] = chars[p[i] - 1];
//            }
//            String newStr = new String(newChars);
//            if (newStr.equals(line2)) {
//                return String.valueOf(k);
//            }
//            s = newStr;
//        }
//    }
}
/*
F. Shifting String
https://codeforces.com/contest/1690/problem/F

题目大意：
给定整数 n，长度为 n 的字符串 s 和数组 p，p 为长度为 n 的排列，其中 1 到 n 的每个整数只出现一次，可以用 p 排列置换 s，
求在多少次操作后字符串会第一次等于它的初始值。

贪心 + 最小公倍数。
======

input
3
5
ababa
3 4 5 2 1
5
ababa
2 1 4 5 3
10
codeforces
8 6 1 7 5 2 9 3 10 4

output
1
6
12
 */