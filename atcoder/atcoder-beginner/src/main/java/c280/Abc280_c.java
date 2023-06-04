package c280;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc280_c {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = scanner.next();
        String t = scanner.next();
        System.out.println(solve(s, t));
    }

    private static String solve(String s, String t) {
        int n = s.length();
        // 注意不能初始化为 0
        int ans = t.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                ans = i + 1;
                break;
            }
        }
        return String.valueOf(ans);
    }
}
/*
C - Extra Character
https://atcoder.jp/contests/abc280/tasks/abc280_c

题目大意：
给定字符串 S 和 T, S 由小写英文字母组成，T 是通过在 S 中插入一个小写英文字母得到的。
找出插入字符在 T 中的位置。
如果有多个候选人，找到其中任何一个。

枚举。
======

Input 1
atcoder
atcorder
Output 1
5

Input 2
million
milllion
Output 2
5

Input 3
vvwvw
vvvwvw
Output 3
3
 */