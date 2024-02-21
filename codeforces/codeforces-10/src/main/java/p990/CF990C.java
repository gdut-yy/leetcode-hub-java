package p990;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CF990C {
    static int n;
    static String[] ss;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        ss = new String[n];
        for (int i = 0; i < n; i++) {
            ss[i] = scanner.next();
        }
        System.out.println(solve());
    }

    private static String solve() {
        long ans = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (String v : ss) {
            char[] s = v.toCharArray();
            int c = 0, mn = 0;
            for (char b : s) {
                if (b == '(') {
                    c++;
                } else {
                    c--;
                    mn = Math.min(mn, c);
                }
            }
            if (mn == 0 || mn == c) {
                if (c == 0) {
                    ans += cnt.getOrDefault(c, 0) * 2 + 1;
                } else {
                    ans += cnt.getOrDefault(-c, 0);
                }
                cnt.put(c, cnt.getOrDefault(c, 0) + 1);
            }
        }
        return String.valueOf(ans);
    }
}
/*
C. Bracket Sequences Concatenation Problem
https://codeforces.com/contest/990/problem/C

灵茶の试炼 2024-01-09
题目大意：
输入 n(1≤n≤3e5) 长为 n 的括号字符串数组 s，字符串长度之和 ≤3e5。
输出有多少个 (i,j) 使得 s[i]+s[j] 是合法括号字符串。
注意 i 可以等于 j，也可以大于 j。

rating 1500
思路和昨天的一样。
如果 mn = 0 或者 mn = cnt，分类讨论：
1. cnt != 0，那么把答案增加 -cnt 的出现次数。
2. cnt = 0，那么当前字符串既可以拼接在左边，也可以拼接在右边，把答案增加 0 的出现次数 * 2 + 1，加一是因为自己和自己可以是一对。
https://codeforces.com/problemset/submission/990/240418223
======

input
3
)
()
(
output
2

input
2
()
()
output
4
 */