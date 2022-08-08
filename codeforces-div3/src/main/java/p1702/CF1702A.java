package p1702;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1702A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int m = scanner.nextInt();
            System.out.println(solve(m));
        }
    }

    private static final int[] TABLES = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};

    private static String solve(int m) {
        for (int i = TABLES.length - 1; i >= 0; i--) {
            if (m >= TABLES[i]) {
                return String.valueOf(m - TABLES[i]);
            }
        }
        return "";
    }
}
/*
Codeforces Round #805 (Div. 3)
A. Round Down the Price
https://codeforces.com/contest/1702/problem/A

题目大意：
给定整数 m，求减去10的幂数后最大非负整数。

贪心。从 10^9 开始尝试
======

input
7
1
2
178
20
999999999
9000
987654321

output
0
1
78
10
899999999
8000
887654321
 */