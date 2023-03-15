package p1754;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1754A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            String s = scanner.next();
            System.out.println(solve(n, s));
        }
    }

    private static String solve(int n, String s) {
        if (s.endsWith("Q")) {
            return "No";
        }
        int cntA = 0;
        int cntQ = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'A') {
                cntA++;
            } else {
                cntA = Math.min(cntA, cntQ);
                cntQ++;
            }
        }
        return cntA >= cntQ ? "Yes" : "No";
    }
}
/*
Codeforces Round #829 (Div. 2)
A. Technical Support
https://codeforces.com/contest/1754/problem/A

题目大意：
给定整数 n 和长度为 n 的只含 Q/A 的字符串 s。要求每个 Q 后必须有 1 个或多个 A，求字符串是否满足。

计数。当遇到字符 Q 时，重置。
======

input
5
4
QQAA
4
QQAQ
3
QAA
1
Q
14
QAQQAQAAQQQAAA

output
Yes
No
Yes
No
Yes
 */