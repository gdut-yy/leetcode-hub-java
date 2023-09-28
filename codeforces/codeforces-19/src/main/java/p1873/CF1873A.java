package p1873;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1873A {
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            s = scanner.next().toCharArray();
            System.out.println(solve());
        }
    }

    private static String solve() {
        boolean ans = s[0] == 'a' || s[1] == 'b' || s[2] == 'c';
        return ans ? "YES" : "NO";
    }
}
/*
Codeforces Round 898 (Div. 4)
A. Short Sort
https://codeforces.com/contest/1873/problem/A

题目大意：
有三张卡片，上面有字母 a, b, c，按一定顺序排成一行。以下操作最多只能执行一次:
选择两张牌，交换它们。
这个行有没有可能在运算后变成 abc ?如果可能，输出“YES”，否则输出“NO”。

至少有一个下标位置是对的
======

input
6
abc
acb
bac
bca
cab
cba
output
YES
YES
YES
NO
NO
YES
 */
