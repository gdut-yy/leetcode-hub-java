package p762;

import java.util.Scanner;

public class CF762C {
    static String s, t;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.next();
        t = scanner.next();
        System.out.println(solve());
    }

    // 2565
    private static String solve() {
        int n = s.length();
        int m = t.length();

        int[] suf = new int[n + 1];
        suf[n] = m;
        for (int i = n - 1, j = m - 1; i >= 0; i--) {
            if (s.charAt(i) == t.charAt(j)) j--;
            if (j < 0) return t; // t 是 s 的子序列
            suf[i] = j + 1;
        }

//        int ans = suf[0]; // 删除 t[:suf[0]]
        int ansL = 0, ansR = suf[0];
        for (int i = 0, j = 0; i < n; i++) {
            if (s.charAt(i) == t.charAt(j)) { // 注意上面判断了 t 是 s 子序列的情况，这里 j 不会越界
                j++;
//                ans = Math.min(ans, suf[i + 1] - j); // 删除 t[j:suf[i+1]]
                if (ansR - ansL > suf[i + 1] - j) {
                    ansL = j;
                    ansR = suf[i + 1];
                }
            }
        }
        if (ansR - ansL == t.length()) return "-";
        return t.substring(0, ansL) + t.substring(ansR);
    }
}
/*
C. Two strings
https://codeforces.com/contest/762/problem/C

灵茶の试炼 2024-09-26
题目大意：
输入两个长度 ≤1e5 的字符串 s 和 t，只包含小写英文字母。
删除 t 的一个最短的连续子串，使得 t 是 s 的子序列。
输出删除子串后的 t。
如果必须把 t 全部删除，输出 -（减号）。
变形：删除 s 中的最长子串，使得 t 仍然是 s 的子序列。
https://codeforces.com/problemset/problem/1203/D2

rating 2100
相似题目: 2565. 最少得分子序列
https://leetcode.cn/problems/subsequence-with-the-minimum-score/
======

Input
hi
bob
Output
-

Input
abca
accepted
Output
ac

Input
abacaba
abcdcba
Output
abcba

abacaba
aa
aa
 */
