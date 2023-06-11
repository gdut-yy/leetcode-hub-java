package c302;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc302_a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long res = (a + b - 1) / b;
        System.out.println(res);
    }
}
/*
A - Attack
https://atcoder.jp/contests/abc302/tasks/abc302_a

题目大意：
有一个敌人的耐力是 a，你每攻击一个敌人，他的耐力就减少 B。
至少你需要攻击敌人多少次才能使其耐力为 0 或更少?

ans = ceil(a / b)
数论向上取模。
======

Input 1
7 3
Output 1
3

Input 2
123456789123456789 987654321
Output 2
124999999

Input 3
999999999999999998 2
Output 3
499999999999999999
 */