package p5;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CF5C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = scanner.next();
        System.out.println(solve(s));
    }

    private static String solve(String s) {
        int n = s.length();

        // 左括号数量，右括号数量，最大值
        int cntL = 0, cntR = 0, max = 0;
        // 左端点 集合去重
        Set<Integer> set = new HashSet<>();

        // 从左到右
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') cntL++;
            else cntR++;

            if (cntL == cntR) {
                if (max < cntL + cntR) {
                    max = cntL + cntR;
                    set.clear();
                    set.add(i - cntL - cntR + 1);
                } else if (max == cntL + cntR) {
                    set.add(i - cntL - cntR + 1);
                }
            } else if (cntL < cntR) {
                cntL = cntR = 0;
            }
        }

        cntL = cntR = 0;
        // 右到左
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') cntL++;
            else cntR++;

            if (cntL == cntR) {
                if (max < cntL + cntR) {
                    max = cntL + cntR;
                    set.clear();
                    set.add(i);
                } else if (max == cntL + cntR) {
                    set.add(i);
                }
            } else if (cntL > cntR) {
                cntL = cntR = 0;
            }
        }

        if (max == 0) {
            return "0 1";
        }
        return max + " " + set.size();
    }
}
/*
C. Longest Regular Bracket Sequence
https://codeforces.com/contest/5/problem/C

灵茶の试炼 2023-02-21
题目大意：
输入括号字符串 s，长度不超过 1e6。
输出 s 的最长合法括号子串的长度和数量。
如果不存在，输出 0 1。

rating 1900
https://leetcode.cn/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode-solution/
方法三的基础上额外套一个计数器。
这里用 set 做去重处理
相似题目: 32. 最长有效括号
https://leetcode.cn/problems/longest-valid-parentheses/
======

input
)((())))(()())
output
6 2

input
))(
output
0 1
 */
