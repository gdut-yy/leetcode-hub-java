package p1989;

import java.util.Scanner;

public class CF1989B {
    static char[] s, t;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            s = scanner.next().toCharArray();
            t = scanner.next().toCharArray();
            System.out.println(solve());
        }
    }

    private static String solve() {
        int mx = 0;
        for (int i = 0; i < t.length; i++) {
            mx = Math.max(mx, f(s, t, i));
        }
        int ans = s.length + t.length - mx;
        return String.valueOf(ans);
    }

    static int f(char[] s, char[] t, int t_from) {
        int cnt = 0;
        for (char b : s) {
            if (t[t_from + cnt] != b) {
                continue;
            }
            cnt++;
            if (cnt == t.length - t_from) {
                break;
            }
        }
        return cnt;
    }
}
/*
B. Substring and Subsequence
https://codeforces.com/contest/1989/problem/B

灵茶の试炼 2025-05-05
题目大意：
输入 T(≤1e3) 表示 T 组数据。
每组数据输入两个长度 ≤100 的字符串 s 和 t，只包含小写英文字母。
构造一个字符串 a，使得 s 是 a 的子串，且 t 是 a 的子序列。
输出 a 的最短长度。

rating 1200
容斥，答案为 |s| + |t| - 交集长度。
要让答案最小，交集长度要最大。
交集怎么算？
枚举 i，从 t[i] 开始，在 s 中贪心地匹配 t[i:]（类似判断子序列的算法），用最大匹配长度，更新交集长度的最大值。
代码 https://codeforces.com/contest/1989/submission/317520735
代码备份（洛谷）
======

Input
5
aba
cb
er
cf
mmm
mmm
contest
test
cde
abcefg
Output
4
4
3
7
7
 */
