package p1582;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class CF1582A {
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
        int remainA = Integer.parseInt(lines[0]) % 2;
        int remainB = Integer.parseInt(lines[1]) % 2;
        int remainC = Integer.parseInt(lines[2]) % 2;
        // 0-0-0
        // 1-1-1
        int[] input = {remainA, remainB, remainC};
        //
        int[] a000 = {0, 0, 0}; // = 0
        int[] a001 = {0, 0, 1}; // 1-1-2 = 3+1 != 2+1 = 1
        int[] a010 = {0, 1, 0}; // 1-2-1 = 3+1 = 2+2 = 0
        int[] a011 = {0, 1, 1}; // = 1
        int[] a100 = {1, 0, 0}; // = 1
        int[] a101 = {1, 0, 1}; // 2-1-2 = 3+2 = 3+1+1 = 0
        int[] a110 = {1, 1, 0}; // = 1
        int[] a111 = {1, 1, 1}; // = 0
        if (Arrays.equals(input, a000) || Arrays.equals(input, a111)
                || Arrays.equals(input, a101) || Arrays.equals(input, a010)) {
            return "0";
        } else {
            return "1";
        }
    }
}
/*
Codeforces Round #750 (Div. 2)
A. Luntik and Concerts
https://codeforces.com/contest/1582/problem/A

题目大意：
给出正整数 a,b,c。分别代表 a个1，b个2，c个3，要平均分两堆，a,b,c 最少为 1。求这两堆总和的最小差值。

从奇偶角度去判断，因为偶数个 a,b,c 都是能平分的，并不影响结果，最后一共有 2^3=8 种情况需要讨论。
======

input
4
1 1 1
2 1 3
5 5 5
1 1 2

output
0
1
0
1
 */