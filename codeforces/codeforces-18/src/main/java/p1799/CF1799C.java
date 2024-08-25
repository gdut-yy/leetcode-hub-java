package p1799;

import java.util.Arrays;
import java.util.Scanner;

public class CF1799C {
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            s = scanner.next().toCharArray();
            System.out.println(solve());
        }
    }

    private static String solve() {
        Arrays.sort(s);
        StringBuilder pre = new StringBuilder();
        StringBuilder suf = new StringBuilder();
        int i = 0;
        for (int n = s.length; i < n - 1; i += 2) {
            if (s[i] != s[i + 1]) {
                if (s[i + 1] == s[n - 1]) {
                    // s[i], s[(i+n)/2] = s[(i+n)/2], s[i]
                    char tmp = s[i];
                    s[i] = s[(i + n) / 2];
                    s[(i + n) / 2] = tmp;
                } else {
                    suf.append(s[i]);
                    i++;
                }
                break;
            }
            pre.append(s[i]);
            suf.append(s[i]);
        }
        for (int j = 0, n = suf.length(); j < n / 2; j++) {
            // suf[i], suf[n-1-i] = suf[n-1-i], suf[i]
            char tmp = suf.charAt(j);
            suf.setCharAt(j, suf.charAt(n - 1 - j));
            suf.setCharAt(n - 1 - j, tmp);
        }
        // s[i:]
        StringBuilder mid = new StringBuilder();
        for (int j = i; j < s.length; j++) {
            mid.append(s[j]);
        }
        return pre.toString() + mid + suf;
    }
}
/*
C. Double Lexicographically Minimum
https://codeforces.com/contest/1799/problem/C

灵茶の试炼 2023-10-18
题目大意：
输入 T(≤1e5) 表示 T 组数据。所有字符串的长度之和 ≤1e5。
每组数据输入长度 ≤1e5 的字符串 s，只包含小写字母。
你可以重新排列 s 中的字母。
定义 t = max(s, rev(s))，其中 rev(s) 为 s 反转后的字符串。
输出字典序最小的 t。

rating 1700
从小到大遍历字母，根据 t 的定义，在遍历到一个出现奇数次的字母之前，这些应该均匀地排在左右两侧，即 aabb...bbaa。
假设 c 出现了奇数次（比如只有一个 c），看上去其余字母全部排在左边就行，上面的 ... 就是 ddeeeffgc。
除了一种情况：如果后续剩余字母只有一种（例如 c 后面只有 d），上面的 ... 如果排成 dddddc，不如把 c 放中间靠右，即 dddcdd。
https://codeforces.com/contest/1799/submission/228141047
======

input
12
a
aab
abb
abc
aabb
aabbb
aaabb
abbb
abbbb
abbcc
eaga
ffcaba
output
a
aba
bab
bca
abba
abbba
ababa
bbab
bbabb
bbcca
agea
acffba
 */
