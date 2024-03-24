package p1082;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF1082B {
    static int n;
    static String s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        s = scanner.next();
        System.out.println(solve());
    }

    private static String solve() {
        s = "S" + s;
        List<Integer> a = new ArrayList<>();
        int c = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            c++;
            if (i == n || s.charAt(i) != s.charAt(i + 1)) {
                if (s.charAt(i) == 'G') {
                    ans = Math.max(ans, c);
                }
                a.add(c);
                c = 0;
            }
        }

        int n = a.size();
        for (int i = 3; i < n; i += 2) {
            if (a.get(i - 1) == 1) {
                int s = a.get(i - 2) + a.get(i);
                if (n >= 6) {
                    s++;
                }
                ans = Math.max(ans, s);
            } else {
                ans = Math.max(ans, Math.max(a.get(i), a.get(i - 2)) + 1);
            }
        }
        return String.valueOf(ans);
    }
}
/*
B. Vova and Trophies
https://codeforces.com/contest/1082/problem/B

灵茶の试炼 2022-06-13
题目大意：
【易错题】
给你整数 n(<=1e5) 和一个长度为 n 的字符串 s，只包含 G 和 S。
你可以至多交换一次 s 中的任意两个字符，求最长连续 G 的长度。
输入 n=10, s="GGGSGGGSGG"
输出 7
解释 把第一个 S 和最后一个 G 交换，得到 "GGGGGGGSGS"

rating 1600
https://codeforces.com/contest/1082/submission/160202876
按照 G 和 S 分组，每组是一个由连续相同字符组成的子串。
如果两个 G 组之间只有一个字符 S，并且 G 组的数目大于 2，那么就可以从别的 G 组中拿个 G 把 S 换掉（两个 G 串的长度和+1），否则只能从自己组里面拿个 G 出来换掉 S（两个 G 串的长度和）。
其余情况，可以从别的 G 组里面拿个 G 拼在 G 组的旁边（G 串的长度+1）。
注意有 0 个或 1 个 G 组的特殊情况。
另一种做法：https://codeforces.com/contest/1082/submission/160410421
---
相似题目 https://leetcode.cn/problems/grumpy-bookstore-owner/
扩展：如果交换的是任意不相交的等长两段呢？
idea@可信编程小能手
======

input
10
GGGSGGGSGG
output
7

input
4
GGGG
output
4

input
3
SSS
output
0
 */