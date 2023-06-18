package p1832;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1832A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            String s = scanner.next();
            System.out.println(solve(s));
        }
    }

    private static String solve(String s) {
        int n = s.length();

        int[] cntArr = new int[26];
        for (int i = 0; i < n / 2; i++) {
            int l = s.charAt(i) - 'a';
            int r = s.charAt(n - 1 - i) - 'a';
            cntArr[l]++;
            cntArr[r]++;
        }

        int even = 0;
        for (int cnt : cntArr) {
            if (cnt > 0) {
                even++;
            }
        }
        return even > 1 ? "YES" : "NO";
    }
}
/*
Educational Codeforces Round 148 (Rated for Div. 2) https://www.bilibili.com/video/BV16o4y1V7oo/
A. New Palindrome
https://codeforces.com/contest/1832/problem/A

题目大意：
回文是一个从左到右和从右到左读起来一样的字符串。例如，abacaba, aaaa, abba, racecar 都是回文。
给定一个由小写拉丁字母组成的字符串 s。字符串 s 是一个回文。
您必须检查是否有可能重新排列其中的字母以获得另一个回文(不等于给定字符串 s)。

分类讨论，去掉中央字符后，需要偶数频次字符数 > 1
======

input
3
codedoc
gg
aabaa
output
YES
NO
NO

1
ababa
YES
 */
