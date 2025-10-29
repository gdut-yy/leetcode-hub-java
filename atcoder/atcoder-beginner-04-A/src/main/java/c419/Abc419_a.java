package c419;

import java.io.PrintWriter;
import java.util.Scanner;

public class Abc419_a {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        String s = scanner.next();
        if ("red".equals(s)) out.println("SSS");
        else if ("blue".equals(s)) out.println("FFF");
        else if ("green".equals(s)) out.println("MMM");
        else out.println("Unknown");
    }
}
/*
A - AtCoder Language
https://atcoder.jp/contests/abc419/tasks/abc419_a

题目大意：
英语中的 "红"、"蓝 "和 "绿 "分别对应 "SSS"、"FFF "和 "MMM"，他不知道其他单词。
给您一个由小写英文字母组成的字符串 S 。如果 S 等于高桥知道的与单词相对应的英语单词，则输出与 S 相对应的单词；否则，输出字符串 `Unknown` 。

简单判断。
======

Input 1
red
Output 1
SSS

Input 2
atcoder
Output 2
Unknown
 */
