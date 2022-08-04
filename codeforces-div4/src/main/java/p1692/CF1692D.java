package p1692;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

public class CF1692D {
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

        int t0 = hhmm2int(lines[0]);
        int x = Integer.parseInt(lines[1]);

        int cnt = 0;
        Set<String> hashSet = new HashSet<>();
        for (int t = t0; ; t += x) {
            String hhmm = int2hhmm(t % 1440);
            if (!hashSet.contains(hhmm)) {
                hashSet.add(hhmm);
                if (isPal(hhmm)) {
                    cnt++;
                }
            } else {
                break;
            }
        }
        return String.valueOf(cnt);
    }

    private static int hhmm2int(String hhmm) {
        return Integer.parseInt(hhmm.substring(0, 2)) * 60 + Integer.parseInt(hhmm.substring(3, 5));
    }

    private static String int2hhmm(int time) {
        int h = time / 60;
        int m = time % 60;
        String hh = h >= 10 ? h + "" : "0" + h;
        String mm = m >= 10 ? m + "" : "0" + m;
        return hh + ":" + mm;
    }

    private static boolean isPal(String s) {
        return new StringBuilder(s).reverse().toString().equals(s);
    }
}
/*
D. The Clock
https://codeforces.com/contest/1692/problem/D

题目大意：
给定 "HH:MM" 格式的字符串 s 和整数 x，s 代表时间，x 代表间隔，求能看到多少不重复的回文。

模拟。
======

input
6
03:12 360
00:00 1
13:22 2
15:15 10
11:11 1440
22:30 27

output
1
16
10
0
1
1
 */