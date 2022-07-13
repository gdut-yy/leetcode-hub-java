package p1703;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CF1703C {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(reader.readLine());
            String lineA = reader.readLine();
            String[] lineN = new String[n];
            for (int j = 0; j < n; j++) {
                lineN[j] = reader.readLine();
            }
            writer.write(solution(n, lineA, lineN).concat(System.lineSeparator()));
        }
        writer.close();
        reader.close();
    }

    private static String solution(int n, String lineA, String[] lineN) {
        String[] lineAs = lineA.split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(lineAs[i]);
        }
        List<String> resList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String b = lineN[i].split(" ")[1];
            int cnt = 0;
            for (char ch : b.toCharArray()) {
                if (ch == 'U') {
                    cnt--;
                } else {
                    cnt++;
                }
            }
            a[i] = ((a[i] + cnt) % 10 + 10) % 10;
            resList.add(String.valueOf(a[i]));
        }
        return String.join(" ", resList);
    }
}
/*
C. Cypher
https://codeforces.com/contest/1703/problem/C

题目大意：
给定整数 n 和长为 n 的数组 a，以及 n 行对第 i 个轮子操作，U和D分别表示上升和下降。求密码锁的初始序列。

模拟，取模。
======

input
3
3
9 3 1
3 DDD
4 UDUU
2 DU
2
0 9
9 DDDDDDDDD
9 UUUUUUUUU
5
0 5 9 8 3
10 UUUUUUUUUU
3 UUD
8 UUDUUDDD
10 UUDUUDUDDU
4 UUUU

output
2 1 1
9 0
0 4 9 6 9
 */