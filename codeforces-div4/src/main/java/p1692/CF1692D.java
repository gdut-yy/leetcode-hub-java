package p1692;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CF1692D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            String s = scanner.next();
            int x = scanner.nextInt();
            System.out.println(solve(s, x));
        }
    }

    private static String solve(String s, int x) {
        int t0 = hhmm2int(s);
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