package c377;

import java.util.Scanner;

public class Abc377_a {
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.next().toCharArray();
        System.out.println(solve());
    }

    private static String solve() {
        int mask = 0;
        for (char c : s) {
            mask |= 1 << (c - 'A');
        }
        int ans = (mask & 0b111);
        return ans == 0b111 ? "Yes" : "No";
    }
}
/*
A - Rearranging ABC
https://atcoder.jp/contests/abc377/tasks/abc377_a

题目大意：
给你一个长度为 $3$ 的字符串 $S$ ，由大写英文字母组成。
请判断是否有可能重新排列 $S$ 中的字符，使其与字符串 `ABC` 匹配。

bitmask 判断。
======

Input 1
BAC
Output 1
Yes

Input 2
AAC
Output 2
No

Input 3
ABC
Output 3
Yes

Input 4
ARC
Output 4
No
 */
