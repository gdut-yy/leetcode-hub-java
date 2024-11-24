package p1178;

import java.util.Scanner;

public class CF1178B {
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.next().toCharArray();
        System.out.println(solve());
    }

    // 方法一：前后缀分解（两次遍历）
    private static String solve() {
        int n = s.length;
        long pre = 0, suf = 0, ans = 0;

        for (int i = 1; i < n - 1; i++) {
            if (s[i] == 'v' && s[i + 1] == 'v') {
                suf++;
            }
        }
        for (int i = 1; i < n - 2; i++) {
            if (s[i] == 'o') {
                ans += pre * suf;
            } else {
                if (s[i - 1] == 'v') pre++;
                if (s[i + 1] == 'v') suf--;
            }
        }
        return String.valueOf(ans);
    }

    // 方法二：状态机 DP（一次遍历）
    private static String solve1() {
        long f0 = 0, f1 = 0, f2 = 0;
        for (int i = 1; i < s.length; i++) {
            if (s[i] == 'o') {
                f1 += f0;
            } else if (s[i - 1] == 'v') {
                f2 += f1;
                f0++;
            }
        }
        return String.valueOf(f2);
    }
}
/*
B. WOW Factor
https://codeforces.com/contest/1178/problem/B

灵茶の试炼 2024-02-26
题目大意：
输入一个长度 ≤1e6 的字符串 s，只包含小写字母 'v' 和 'o'。
把 s 中的两个相邻的 v 视作一个 w。
输出有多少个 wow 子序列。
注意：子序列不一定连续。子序列中的 w 必须由 s 中的相邻 v 组成。

rating 1300
https://www.luogu.com.cn/blog/endlesscheng/solution-cf1178b
======

input
vvvovvv
output
4

input
vvovooovovvovoovoovvvvovovvvov
output
100
 */
