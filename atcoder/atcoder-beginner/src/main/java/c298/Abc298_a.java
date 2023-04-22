package c298;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc298_a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        String s = scanner.next();
        System.out.println(solve(n, s));
    }

    private static String solve(int n, String s) {
        if (s.contains("o") && !s.contains("x")) {
            return "Yes";
        }
        return "No";
    }
}
/*
A - Job Interview
https://atcoder.jp/contests/abc298/tasks/abc298_a

题目大意：
高桥有一个工作面试。
给定面试官的数量 N，以及一个长度为 N 的字符串 S，表示面试官对他的评价。对于每一个 i=1,2，…，N, S 的第 i 个字符对应第 i 个采访者的评价;0 表示好，-表示公平，x 表示差。
如果满足以下两个条件，高桥将通过，否则将失败。
- 至少有一个面试官的评价是好的。
- 没有面试官的评价是差的。
确定高桥是否通过。

模拟
======

Input
4
oo--
Output
Yes

Input
3
---
Output
No

Input
1
o
Output
Yes

Input
100
ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooox
Output
No
 */