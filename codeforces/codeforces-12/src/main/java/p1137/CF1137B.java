package p1137;

import java.util.Scanner;

public class CF1137B {
    static char[] s, t;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.next().toCharArray();
        t = scanner.next().toCharArray();
        System.out.println(solve());
    }

    private static String solve() {
        int[] cnt = new int[2];
        for (char b : s) {
            cnt[b & 1]++;
        }

        int[] pi = prefix_function(t);

        StringBuilder ans = new StringBuilder();
        int j = 0;
        while (cnt[t[j] & 1] > 0) {
            ans.append(t[j]);
            cnt[t[j] & 1]--;
            j++;
            if (j == t.length) {
                j = pi[j - 1];
            }
        }
        return ans.append("0".repeat(cnt[0])).append("1".repeat(cnt[1])).toString();
    }

    static int[] prefix_function(char[] s) {
        int n = s.length;
        int[] pi = new int[n];
        for (int i = 1; i < n; i++) {
            int j = pi[i - 1];
            while (j > 0 && s[i] != s[j]) j = pi[j - 1];
            if (s[i] == s[j]) j++;
            pi[i] = j;
        }
        return pi;
    }
}
/*
B. Camp Schedule
https://codeforces.com/contest/1137/problem/B

灵茶の试炼 2024-03-27
题目大意：
输入两个长度均 ≤5e5 的字符串 s 和字符串 t，只包含 '0' 和 '1'。
重排 s 中的字符，使得 s 中有尽量多的子串等于 t。
输出重排后的 s。
如果有多个答案，输出任意一个。
思考题：如果有多个答案，输出其中字典序最小的。@lympanda

rating 1600
统计 s 中的 0 和 1 的个数 cnt[0] 和 cnt[1]。
贪心，利用 KMP 去构造答案，因为在子串 t 重叠的时候可以节省尽量多的字符。
把 t 当作模式串，设当前匹配了 j 个，那么只要 cnt[t[j]] > 0，当前这一位就填 t[j]，同时 cnt[t[j]] 减一。
然后 j 加一，如果 j 等于 t 的长度，根据 KMP 匹配的原理，回退到 pi[j-1] 上（见代码）。
如果 cnt[t[j]] = 0，那么后面要填的字母就只有一种了（全 0 或者全 1），直接输出。
https://codeforces.com/problemset/submission/1137/253100167
======

Input
101101
110
Output
110110

Input
10010110
100011
Output
01100011

Input
10
11100
Output
01
 */
