package p1714;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1714A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int H = scanner.nextInt();
            int M = scanner.nextInt();
            int HM = H * 60 + M;
            int[] hm = new int[n];
            for (int j = 0; j < n; j++) {
                int hi = scanner.nextInt();
                int mi = scanner.nextInt();
                hm[j] = hi * 60 + mi;
            }
            System.out.println(solve(HM, hm));
        }
    }

    private static String solve(int HM, int[] hm) {
        int min = Integer.MAX_VALUE;
        for (int i : hm) {
            if (i < HM) {
                i += 24 * 60;
            }
            min = Math.min(min, i - HM);
        }
        return (min / 60) + " " + (min % 60);
    }
}
/*
Codeforces Round #811 (Div. 3)
A. Everyone Loves to Sleep
https://codeforces.com/contest/1714/problem/A

题目大意：
给定整数 n,H,M 报警次数和睡觉时间，n 行 hi,mi 闹钟时间，问下一次闹钟响前能睡多久

模拟，枚举每个闹钟，找最小间隔。
======

input
3
1 6 13
8 0
3 6 0
12 30
14 45
6 0
2 23 35
20 15
10 30

output
1 47
0 0
10 55
 */