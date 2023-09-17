package c305;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc305_b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        char p = scanner.next().charAt(0);
        char q = scanner.next().charAt(0);
        System.out.println(solve(p, q));
    }

    private static String solve(char p, char q) {
        int[] pre = new int[7];
        pre[1] = pre[0] + 3;
        pre[2] = pre[1] + 1;
        pre[3] = pre[2] + 4;
        pre[4] = pre[3] + 1;
        pre[5] = pre[4] + 5;
        pre[6] = pre[5] + 9;
        int ans = Math.abs(pre[p - 'A'] - pre[q - 'A']);
        return String.valueOf(ans);
    }
}
/*
B - ABCDEFG
https://atcoder.jp/contests/abc305/tasks/abc305_b

题目大意：
A, B, C, D, E, F, G 在一条直线上，按这个顺序有 7 个点。(参见下图。)相邻点之间的距离如下所示。
- Between A and B: 3
- Between B and C: 1
- Between C and D: 4
- Between D and E: 1
- Between E and F: 5
- Between F and G: 9
给你两个大写的英文字母 p 和 q, p 和 q 分别代表 A、B、C、D、E、F 或 G，并且 p != q。
求点 p 和点 q 之间的距离。

转化为 前缀和
======

Input 1
A C
Output 1
4

Input 2
G B
Output 2
20

Input 3
C F
Output 3
10
 */