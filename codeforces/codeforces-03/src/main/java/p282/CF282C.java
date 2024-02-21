package p282;

import java.util.Scanner;

public class CF282C {
    static String s, t;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.next();
        t = scanner.next();
        System.out.println(solve());
    }

    private static String solve() {
        if (s.length() == t.length() && s.contains("1") == t.contains("1")) {
            return "YES";
        }
        return "NO";
    }
}
/*
C. XOR and OR
https://codeforces.com/contest/282/problem/C

灵茶の试炼 2022-05-10
题目大意：
给你两个 01 串 s 和 t，长度均不超过 1e6，你可以对 s 执行任意次如下操作：
选择两个相邻的数字 x 和 y，计算出 p=x^y (xor) 和 q=x|y (or)，
然后替换 x 为 p，y 为 q；或者替换 x 为 q，y 为 p。
判断能否将 s 变为 t。
2023.1.22 押题成功！
2546. 执行逐位运算使字符串相等
https://leetcode.cn/problems/apply-bitwise-operations-to-make-strings-equal/

rating 1500
https://codeforces.com/contest/282/submission/156568861
首先长度不同肯定不行。
然后发现 00 是不变的，10 和 01 可以变 11，11可以变 10 或 01。
那么全 0 无法变出 1，包含 1 无法变为全 0。由此猜想只要 s 和 t 均包含 1 或均不包含 1，那么 s 就能变为 t。
简单证明一下：
由于操作是可逆的（10 和 11 可以互相转化），所以只要 s 和 t 都能变成全 1 的字符串那么 s 就能变全 1，然后变成 t。
能变成全 1 只需要包含至少一个 1 就行了（每次把 10 或 01 变 11，直到没有 0）。
======

input
11
10
output
YES

input
1
01
output
NO

input
000
101
output
NO
 */
