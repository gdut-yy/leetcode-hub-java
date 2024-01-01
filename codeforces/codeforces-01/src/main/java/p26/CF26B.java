package p26;

import java.util.Scanner;

public class CF26B {
    static String s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.next();
        System.out.println(solve());
    }

    private static String solve() {
        int cnt = 0, ans = s.length();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                cnt++;
            } else if (cnt > 0) {
                cnt--;
            } else {
                ans--;
            }
        }
        return String.valueOf(ans - cnt);
    }
}
/*
B. Regular Bracket Sequence
https://codeforces.com/contest/26/problem/B

灵茶の试炼 2023-10-30
题目大意：
输入一个长度 ≤1e6 的括号字符串 s。
输出 s 的最长合法括号子序列的长度。
注：子序列不一定连续。

初始化答案为 s 的长度。
用栈模拟（实际只需要一个变量），遇到左括号入栈，遇到右括号把栈顶弹出。如果栈为空则把答案减一。
最后输出答案减去栈的大小（因为栈中剩余元素不算）。
https://codeforces.com/problemset/submission/26/230000559
相似题目: 32. 最长有效括号
https://leetcode.cn/problems/longest-valid-parentheses/
======

input
(()))(
output
4

input
((()())
output
6
 */
