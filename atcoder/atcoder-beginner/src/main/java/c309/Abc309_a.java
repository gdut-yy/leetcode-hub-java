package c309;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc309_a {
    static int a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        a = scanner.nextInt();
        b = scanner.nextInt();
        System.out.println(solve());
    }

    private static String solve() {
        boolean ans = b - a == 1 && b != 4 && b != 7;
        return ans ? "Yes" : "No";
    }
}
/*
A - Nine
https://atcoder.jp/contests/abc309/tasks/abc309_a

题目大意：
我们有如下 3×3 板，上面写着从 1 到 9 的整数。
给定两个 1 到 9 之间的整数 A 和 B，其中 A<B。
判断写有 A 和 B 的两个正方形在水平上是否相邻。

特判 4 和 7
======

Input 1
7 8
Output 1
Yes

Input 2
1 9
Output 2
No

Input 3
3 4
Output 3
No
 */