package p1860;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1860A {
    static String s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            s = scanner.next();
            System.out.println(solve());
        }
    }

    private static String solve() {
        int n = s.length();
        StringBuilder sbA = new StringBuilder();
        StringBuilder sbB = new StringBuilder();
        for (int i = 0; i < 2 * n; i++) {
            sbA.append("()".charAt(i & 1));
            sbB.append(")(".charAt(i < n ? 1 : 0));
        }
        String a = sbA.toString();
        String b = sbB.toString();
        if (!a.contains(s)) {
            return "YES" + System.lineSeparator() + a;
        } else if (!b.contains(s)) {
            return "YES" + System.lineSeparator() + b;
        }
        return "NO";
    }
}
/*
Educational Codeforces Round 153 (Rated for Div. 2)
A. Not a Substring
https://codeforces.com/contest/1860/problem/A

题目大意：
括号序列是由字符'('和/或')'组成的字符串。常规括号序列是一种可以通过在序列的原始字符之间插入字符“1”和“+”来转换成正确算术表达式的括号序列。例如:
- 括号序列“()()”和“(())”是正则的(它们可以分别转换为“(1)+(1)”和“(1+1)+1”);
- 括号序列")("，"("和")"是不规则的。
给你一个括号序列 s;我们定义它的长度为 n。你的任务是找到一个长度为 2n 的正则括号序列 t，使得 s 不作为连续子串出现在 t 中，或者报告不存在这样的序列。

构造题？
---
https://codeforces.com/blog/entry/119504
让我们考虑以下两种情况:
字符串 s 包含两个连续相等的字符，例如“)((())”或“())”。在这种情况下，我们可以选择一个形式为"()()()"的字符串 t，因为它不包含两个相等字符的子字符串，因此 s 不是 t 的子字符串;
在字符串 s 中，所有相邻的字符都是不同的，即它是交替的。在这种情况下，我们可以选择“((()))”形式的字符串 t，因为这里最长的交替子字符串的长度是 2。它包含的唯一交替子字符串是"()"，它是每个常规括号序列的一部分。
因此，只要考虑长度为 2n 的“()()()”和“((()))”这两个候选者的答案就足够了。
======

input
4
)(
(()
()
))()
output
YES
(())
YES
()()()
NO
YES
()(()())
 */
