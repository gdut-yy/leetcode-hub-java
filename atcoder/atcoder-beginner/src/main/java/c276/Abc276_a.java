package c276;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc276_a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = scanner.next();
        System.out.println(solve(s));
    }

    private static String solve(String s) {
        int ans = -2;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                ans = i;
            }
        }
        // 找不到时 -2 + 1 = -1
        return String.valueOf(ans + 1);
    }
}
/*
A - Rightmost
https://atcoder.jp/contests/abc276/tasks/abc276_a

题目大意：
给你一个由小写英文字母组成的字符串 S。
如果 a 出现在 S 中，打印它出现的最后一个索引;否则，打印 −1。(指数从 1 开始。)

遍历。
======

Input 1
abcdaxayz
Output 1
7

Input 2
bcbbbz
Output 2
-1

Input 3
aaaaa
Output 3
5
 */