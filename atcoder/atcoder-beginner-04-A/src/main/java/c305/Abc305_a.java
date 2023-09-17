package c305;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc305_a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        System.out.println(solve(n));
    }

    private static String solve(int n) {
        int i = n / 5;
        int l = i * 5;
        int r = i * 5 + 5;
        return n - l < r - n ? String.valueOf(l) : String.valueOf(r);
    }
}
/*
A - Water Station
https://atcoder.jp/contests/abc305/tasks/abc305_a

题目大意：
有一条总长 100 公里的超级马拉松赛道。从起点到终点，全程每隔 5 公里设置一个水站，共计 21 个。
高桥在这条赛道的 Nkm 处。找到离他最近的水站。
在此问题的约束下，可以证明最近水站是唯一确定的。

数学。
======

Input 1
53
Output 1
55

Input 2
21
Output 2
20

Input 3
100
Output 3
100
 */