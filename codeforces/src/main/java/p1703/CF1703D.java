package p1703;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CF1703D {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(reader.readLine());
            String[] lineN = new String[n];
            for (int j = 0; j < n; j++) {
                lineN[j] = reader.readLine();
            }
            writer.write(solution(n, lineN).concat(System.lineSeparator()));
        }
        writer.close();
        reader.close();
    }

    private static String solution(int n, String[] lineN) {
        Set<String> hashSet = new HashSet<>();
        Collections.addAll(hashSet, lineN);

        char[] chars = new char[n];
        Arrays.fill(chars, '0');
        for (int i = 0; i < n; i++) {
            String si = lineN[i];
            for (int j = 1; j < si.length(); j++) {
                String sj = si.substring(0, j);
                String sk = si.substring(j);
                if (hashSet.contains(sj) && hashSet.contains(sk)) {
                    chars[i] = '1';
                    break;
                }
            }
        }
        return new String(chars);
    }
}
/*
D. Double Strings
https://codeforces.com/contest/1703/problem/D

题目大意：
给定整数 n 和 n 行字符串 s，对于每个字符串si，判断是否存在两个字符串sj和sk，使si=sj+sk。即si是sj和sk的串联，注意j可以等于k。

HashMap 暴力模拟。
======

input
3
5
abab
ab
abc
abacb
c
3
x
xx
xxx
8
codeforc
es
codes
cod
forc
forces
e
code

output
10100
011
10100101
 */