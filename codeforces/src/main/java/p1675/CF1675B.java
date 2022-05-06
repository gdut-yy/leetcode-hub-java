package p1675;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class CF1675B {
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
        int n = Integer.parseInt(line1);
        String[] line2s = line2.split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(line2s[i]);
        }

        int cnt = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (a[i + 1] == 0) {
                return "-1";
            }
            while (a[i] >= a[i + 1]) {
                a[i] /= 2;
                cnt++;
            }
            if (a[i] == 0 && i != 0) {
                return "-1";
            }
        }
        return String.valueOf(cnt);
    }
}
/*
B. Make It Increasing
https://codeforces.com/contest/1675/problem/B

题目大意：
给定长度为 n 的数组 a，规定一次操作可以使任意数 /2（向下取整），求最小操作次数使数组严格递增，若无法实现，输出 -1。

贪心，从后往前遍历，要使操作次数最少，则越往后的数应越大。当出现 0 时且非 a0 时，返回 -1
======

input
7
3
3 6 5
4
5 3 2 1
5
1 2 3 4 5
1
1000000000
4
2 8 7 5
5
8 26 5 21 10
2
5 14

output
2
-1
0
0
4
11
0
 */