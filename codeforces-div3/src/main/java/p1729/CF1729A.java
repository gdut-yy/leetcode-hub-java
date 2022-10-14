package p1729;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1729A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            System.out.println(solve(a, b, c));
        }
    }

    private static String solve(int a, int b, int c) {
        int t1 = a - 1;
        int t2 = Math.abs(c - b) + c - 1;
        if (t1 == t2) {
            return "3";
        } else if (t1 < t2) {
            return "1";
        } else {
            return "2";
        }
    }
}
/*
Codeforces Round #820 (Div. 3)
A. Two Elevators
https://codeforces.com/contest/1729/problem/A

题目大意：
给定整数 a,b,c。第一部电梯目前在 a 层(它目前静止不动)，第二部电梯在 b 层，直达 c 层(b != c)。请注意，如果 b = 1，那么电梯已经离开 1 层，Vlad 没有时间进入。
Vlad 在 1 楼。如果电梯 1 先到，返回 1；如果电梯 2 先到，返回 2；若同时抵达，返回 3。

模拟。分别计算两个电梯到 1 楼所花的时间。
======

input
3
1 2 3
3 1 2
3 2 1

output
1
3
2
 */