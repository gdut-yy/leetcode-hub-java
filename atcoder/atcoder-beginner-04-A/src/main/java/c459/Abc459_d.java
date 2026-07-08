package c459;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Abc459_d {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        String s = scanner.next();
        String ans = reorganizeString(s);
        if (ans.isEmpty()) {
            out.println("No");
        } else {
            out.println("Yes");
            out.println(ans);
        }
    }

    private static String reorganizeString(String s) {
        int n = s.length();
        Map<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) {
            count.merge(c, 1, Integer::sum);
        }

        List<Map.Entry<Character, Integer>> a = new ArrayList<>(count.entrySet());
        // 按出现次数从大到小排序
        a.sort((p, q) -> q.getValue() - p.getValue());
        int m = a.get(0).getValue();
        if (m > n - m + 1) {
            return "";
        }

        char[] ans = new char[n];
        int i = 0;
        for (Map.Entry<Character, Integer> entry : a) {
            char ch = entry.getKey();
            int cnt = entry.getValue();
            while (cnt-- > 0) {
                ans[i] = ch;
                i += 2;
                if (i >= n) {
                    i = 1; // 填完偶数填奇数
                }
            }
        }
        return new String(ans);
    }
}
/*
D - Adjacent Distinct String
https://atcoder.jp/contests/abc459/tasks/abc459_d

灵茶の试炼 2026-06-08
题目大意：
输入 T(≤3e5) 表示 T 组数据。所有数据的字符串长度之和 ≤1e6。
每组数据输入长度 ≤1e6 的字符串 s，只包含小写英文字母。
重新排列 s，使得 s 中的相邻字母均不同。
如果无法做到，输出 No；否则输出 Yes 和重排后的 s。多解输出任意解。

rating
同 LC767. 重构字符串
我的题解
======

Input 1
3
aiiw
doodoo
aabbababcacababaaba
Output 1
Yes
iwai
No
Yes
ababacabababacababa
 */
