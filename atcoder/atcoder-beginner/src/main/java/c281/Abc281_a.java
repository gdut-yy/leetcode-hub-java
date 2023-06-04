package c281;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc281_a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        for (int i = n; i >= 0; i--) {
            System.out.println(i);
        }
    }
}
/*
A - Count Down
https://atcoder.jp/contests/abc281/tasks/abc281_a

题目大意：
按降序打印小于或等于 N 的所有非负整数。

模拟。
======

Input 1
3
Output 1
3
2
1
0

Input 2
22
Output 2
22
21
20
19
18
17
16
15
14
13
12
11
10
9
8
7
6
5
4
3
2
1
0
 */