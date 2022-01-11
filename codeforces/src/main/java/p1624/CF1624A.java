package p1624;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class CF1624A {
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
        String[] lines = line.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(lines[i]);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return String.valueOf(max - min);
    }
}
/*
Codeforces Round #764 (Div. 3)
A. Plus One on the Subset
https://codeforces.com/contest/1624/problem/A

题目大意：
给出整数 n 和长度为 n 的数组 a，每次可以选取一些下标 +1，求使数组 a 所有元素相等的最小操作数。

最小操作数等于 最小值 与 最大值 的差值。
===

input
3
6
3 4 2 4 1 2
3
1000 1002 998
2
12 11

output
3
4
1
 */