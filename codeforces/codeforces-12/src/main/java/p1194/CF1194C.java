package p1194;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF1194C {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        String s = scanner.next();
        String t = scanner.next();
        String p = scanner.next();

        int[] cnt = new int[26];
        int j = 0;
        for (int i = 0; i < t.length(); i++) {
            char b = t.charAt(i);
            if (s.charAt(j) != b) {
                cnt[b - 'a']++;
                continue;
            }
            j++;
            if (j == s.length()) {
                for (int k = i + 1; k < t.length(); k++) {
                    cnt[t.charAt(k) - 'a']++;
                }
                for (char c : p.toCharArray()) {
                    cnt[c - 'a']--;
                }
                for (int c : cnt) {
                    if (c > 0) {
                        out.println("NO");
                        return;
                    }
                }
                out.println("YES");
                return;
            }
        }
        if (j < s.length()) {
            out.println("NO");
        }
    }
}
/*
C. From S To T
https://codeforces.com/contest/1194/problem/C

灵茶の试炼 2025-09-15
题目大意：
输入 T(≤100) 表示 T 组数据。
每组数据输入三个长度均 ≤100 的字符串 s t p，只包含小写英文字母。
每次操作，你可以选择 p 中的一个字母，将其删除，然后把该字母插入 s 中的任意位置。
至多操作 |p| 次。
能否把 s 变成 t？输出 YES 或 NO。

rating 1300
s 必须是 t 的子序列。判断方法见 392. 判断子序列。
如果是子序列，那么对于每种字母，s 中该字母的个数 + p 中该字母的个数必须 >= t 中该字母的个数。
代码 https://codeforces.com/contest/1194/submission/335231149
代码备份（上面打不开的同学看这个）
======

Input
4
ab
acxb
cax
a
aaaa
aaabbcc
a
aaaa
aabbcc
ab
baaa
aaaaa
Output
YES
YES
NO
NO
 */
