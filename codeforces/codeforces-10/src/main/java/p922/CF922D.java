package p922;

import java.util.Arrays;
import java.util.Scanner;

public class CF922D {
    static int n;
    static String[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(solve());
    }

    private static String solve() {
        Arrays.sort(a, (s, t) -> {
            long cnt1 = 0, cnt2 = 0;
            for (char c : s.toCharArray()) {
                if (c == 's') cnt1++;
            }
            for (char c : t.toCharArray()) {
                if (c == 's') cnt2++;
            }
            long x1 = cnt1 * t.length();
            long x2 = cnt2 * s.length();
            return Long.compare(x2, x1);
        });

        long ans = 0;
        int cntS = 0;
        for (String s : a) {
            for (char c : s.toCharArray()) {
                if (c == 's') {
                    cntS++;
                } else {
                    ans += cntS;
                }
            }
        }
        return String.valueOf(ans);
    }
}
/*
D. Robot Vacuum Cleaner
https://codeforces.com/contest/922/problem/D

灵茶の试炼 2022-06-14
题目大意：
给你整数 n(<=1e5)，以及 n 个仅由字符 s 和 h 组成的字符串，且这 n 个字符串的长度之和不超过 1e5。
请你重新排列这 n 个字符串，然后拼成一个长字符串，使得 "sh" 子序列的出现次数最多。输出这个最大值。
注：子序列不要求连续。

rating 1800
https://codeforces.com/contest/922/submission/160482721
参考我在 https://www.bilibili.com/video/BV18t4y1p736 中提到的邻项交换法，对于两个字符串 x 和 y，如果
x.count('s') * y.count('h') > y.count('s') * x.count('h')
那么 x 就应该排在 y 的前面。
因此自定义排序后即可得到最优解，然后扫描一遍统计 sh 子序列的个数。
相似题目：https://leetcode.cn/problems/largest-number/
---
疑问：为什么直接在自定义排序里面求 count('s') 也能很快通过？是数据太弱还是快排保证了不会对一个很长的字符串做很多次 count('s')？
======

input
4
ssh
hs
s
hhhs
output
18

input
2
h
s
output
1
 */