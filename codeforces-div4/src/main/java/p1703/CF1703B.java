package p1703;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1703B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            String s = scanner.next();
            System.out.println(solve(n, s));
        }
    }

    private static String solve(int n, String s) {
        boolean[] visited = new boolean[26];
        int cnt = 0;
        for (char ch : s.toCharArray()) {
            int idx = ch - 'A';
            if (!visited[idx]) {
                visited[idx] = true;
                cnt += 2;
            } else {
                cnt += 1;
            }
        }
        return String.valueOf(cnt);
    }
}
/*
B. ICPC Balloons
https://codeforces.com/contest/1703/problem/B

题目大意：
给定整数 n 和长为 n 的字符串 s，第一个解决问题的团队会得到另外一个气球。问这队收到气球的数量。

模拟，如果是第一次出现的字符 +2，否则 +1，求和。
======

input
6
3
ABA
1
A
3
ORZ
5
BAAAA
4
BKPT
10
CODEFORCES

output
5
2
6
7
8
17
 */