package c145;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Arc145_a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        String s = scanner.next();
        System.out.println(solve(n, s));
    }

    private static String solve(int n, String s) {
        if (s.equals("BA") || s.charAt(0) == 'A' && s.charAt(n - 1) == 'B') {
            return "No";
        }
        return "Yes";
    }
}
/*
A - AB Palindrome
https://atcoder.jp/contests/arc145/tasks/arc145_a

灵茶の试炼 2023-01-26
题目大意：
输入 n(2≤n≤2e5) 和长为 n 的字符串 s，仅包含 'A' 和 'B'。
你可以执行如下操作任意多次：
选择两个相邻字符 s[i] 和 s[i+1]，把 s[i] 替换成 'A'，s[i+1] 替换成 'B'。
能否使 s 变成回文串？输出 Yes 或 No。

https://atcoder.jp/contests/arc145/submissions/38323634
手玩。
操作方法如下：
如果 s[0]='B'，从 s[1] 开始，左到右替换，得到 BAA...AAB。
如果 s[n-1]='A'，从 s[n-2] 开始，右到左替换，得到 ABB...BBA。
那么，只有两种情况无法操作：
s="BA"。
s[0]='A' 且 s[n-1]='B'。
======

Input
3
BBA
Output
Yes

Input
4
ABAB
Output
No
 */