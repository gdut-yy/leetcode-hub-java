package p1675;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1675A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.println(solve(a, b, c, x, y));
        }
    }

    private static String solve(int a, int b, int c, int x, int y) {
        if (a + c >= x && b + c >= y && a + b + c >= x + y) {
            return "YES";
        }
        return "NO";
    }
}
/*
Codeforces Round #787 (Div. 3)
A. Food for Animals
https://codeforces.com/contest/1675/problem/A

题目大意：
给定 a 袋狗粮，b 袋猫粮，c 袋通用食品（既适合猫又适合狗），x 只狗，y 只猫，问是否每只猫和狗都能够 1 袋粮食

简单判断即可。
======

input
7
1 1 4 2 3
0 0 0 0 0
5 5 0 4 6
1 1 1 1 1
50000000 50000000 100000000 100000000 100000000
0 0 0 100000000 100000000
1 3 2 2 5

output
YES
YES
NO
YES
YES
NO
NO
 */