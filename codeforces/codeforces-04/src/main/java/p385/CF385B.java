package p385;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF385B {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    static String s;

    public static void main(String[] args) {
        s = scanner.next();
        solve();
        out.flush();
    }

    private static void solve() {
        int n = s.length();
        long ans = 0;
        int pre = -1;
        for (int i = 0; i < n - 3; i++) {
            if (s.startsWith("bear", i)) {
                ans += (long) (i - pre) * (n - 3 - i);
                pre = i;
            }
        }
        out.println(ans);
    }
}
/*
B. Bear and Strings
https://codeforces.com/contest/385/problem/B

灵茶の试炼 2025-06-02
题目大意：
输入长度 ≤5000 的字符串 s，只包含小写英文字母。
输出 s 有多少个子串 t，满足 t 中有子串 "bear"。
要求：O(n)。

rating 1200
贡献法。
如果 s[i] 到 s[i+3] 是 "bear"，那么 t 的左端点范围为 [0,i]，右端点范围为 [i+3,n-1]。
但是，这会算重复，比如样例 2。
解决办法：改成 s[i] 到 s[i+3] 是 t 的第一个 "bear"，统计这样的 t 的个数，从而保证不会重复。
需要维护上一次遇到 "bear" 的下标 pre，那么左端点范围为 [pre+1,i]。
初始值 pre = -1。
答案为所有 (i-pre) * (n-3-i) 之和。
代码 https://codeforces.com/problemset/submission/385/321983932
代码备份（洛谷）
======

Input
bearbtear
Output
6

Input
bearaabearc
Output
20
 */
