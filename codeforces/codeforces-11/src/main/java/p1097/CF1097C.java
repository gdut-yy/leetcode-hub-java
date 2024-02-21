package p1097;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CF1097C {
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
        int ans = 0;
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
                if (cnt.getOrDefault(-c, 0) > 0) {
                    cnt.put(-c, cnt.get(-c) - 1);
                    ans++;
                } else {
                    cnt.put(c, cnt.getOrDefault(c, 0) + 1);
                }
            }
        }
        return String.valueOf(ans);
    }
}
/*
C. Yuhao and a Parenthesis
https://codeforces.com/contest/1097/problem/C

灵茶の试炼 2024-01-08
题目大意：
输入 n(1≤n≤1e5) 和 n 个括号字符串，字符串长度之和 ≤5e5。
你需要从中选出 2m 个括号，两两一对，拼接成 m 个合法括号字符串。
输出 m 的最大值。

rating 1400
处理括号字符串 s 的通用方法：
遍历 s，用一个变量 cnt 记录 s 前缀的左括号的个数减去右括号的个数。
如果 s 是合法括号字符串，那么在遍历的过程中 cnt >= 0，且遍历结束后 cnt = 0。
把拼接的字符串分别记作 S 和 T，即 S+T 是合法括号字符串。
设 S 的 cnt 值为 cntS，要求遍历过程中的 cntS 的最小值 >= 0。
设 T 的 cnt 值为 cntT，要求遍历过程中的 cntT 的最小值等于遍历结束后的 cntT。
如果 S+T 是合法括号字符串，那么 cntS + cntT = 0。
用数组/哈希表维护 cnt 的出现次数。
设 mn 为 cnt 的最小值。如果 mn = 0 或者 mn = cnt，先看 -cnt 是否有，如果有，就找到了一对，答案加一，同时把 -cnt 的出现次数减一；如果没有，就把 cnt 的出现次数加一。
https://codeforces.com/problemset/submission/1097/240418430
======

input
7
)())
)
((
((
(
)
)
output
2

input
4
(
((
(((
(())
output
0

input
2
(())
()
output
1
 */