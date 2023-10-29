package c325;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc325_a {
    static String s, t;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        s = scanner.next();
        t = scanner.next();
        System.out.println(solve());
    }

    private static String solve() {
        return s.split(" ")[0] + " san";
    }
}
/*
A - Takahashi san
https://atcoder.jp/contests/abc325/tasks/abc325_a

题目大意：
基恩斯的文化是称呼每个人都要尊称“先生”，无论他们的角色、年龄或职位如何。即使是新员工也会称总裁为“中田先生”。[译者注:这在日本不太常见。]
您将分别以字符串 S 和 T 的形式获得一个人的姓和名。
按此顺序打印姓氏、空格()和敬语(san)的连接。

模拟
======

Input 1
Takahashi Chokudai
Output 1
Takahashi san

Input 2
K Eyence
Output 2
K san
 */
