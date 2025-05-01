package p159;

import java.util.Arrays;
import java.util.Scanner;

public class CF159D {
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.next().toCharArray();
        System.out.println(solve1());
    }

    private static String solve() {
        int n = s.length;
        long[] sum = new long[n];
        for (int i = 0; i < 2 * n - 1; i++) {
            int l = i / 2, r = (i + 1) / 2;
            while (l >= 0 && r < n && s[l] == s[r]) {
                sum[r]++;
                l--;
                r++;
            }
        }

        for (int i = 1; i < n; i++) {
            sum[i] += sum[i - 1];
        }

        long ans = 0;
        for (int i = 0; i < 2 * n - 1; i++) {
            int l = i / 2, r = (i + 1) / 2;
            while (l > 0 && r < n && s[l] == s[r]) {
                ans += sum[l - 1];
                l--;
                r++;
            }
        }
        return String.valueOf(ans);
    }

    // CF17E
    private static String solve1() {
        int n = s.length;
        StringBuilder t = new StringBuilder("^");
        for (char c : s) t.append("#").append(c);
        t.append("#$");
        int[] halfLen = new int[t.length() - 2];
        halfLen[1] = 1;
        int boxM = 0, boxR = 0;
        for (int i = 2; i < halfLen.length; i++) {
            int hl = 1;
            if (i < boxR) hl = Math.min(halfLen[boxM * 2 - i], boxR - i);
            while (t.charAt(i - hl) == t.charAt(i + hl)) {
                hl++;
                boxM = i;
                boxR = i + hl;
            }
            halfLen[i] = hl;
        }

        long[] diff = new long[n + 1];
        for (int i = 0; i < halfLen.length; i++) {
            int hl = halfLen[i];
            int l = (i - hl) / 2, r = (i + hl) / 2 - 2;
            if (l <= r) {
                diff[(l + r + 1) / 2]++;
                diff[r + 1]--;
            }
        }
        // cntEnd := diff[:n]
        long[] cntEnd = Arrays.copyOfRange(diff, 0, n);
        for (int i = 1; i < n; i++) {
            cntEnd[i] += cntEnd[i - 1];
        }
        for (int i = 1; i < n; i++) {
            cntEnd[i] += cntEnd[i - 1];
        }

        long[] sum = new long[n + 1];
        for (int i = 0; i < cntEnd.length; i++) {
            sum[i + 1] = sum[i] + cntEnd[i];
        }
        long ans = 0;
        for (int i = 0; i < halfLen.length; i++) {
            int hl = halfLen[i];
            int l = (i - hl) / 2, r = (i + hl) / 2 - 2;
            if (l <= r) {
                ans += sum[(l + r) / 2] - sum[Math.max(l - 1, 0)];
            }
        }
        return String.valueOf(ans);
    }
}
/*
D. Palindrome pairs
https://codeforces.com/contest/159/problem/D

灵茶の试炼 2025-03-04
题目大意：
输入长度 ≤2000 的字符串 s，只包含小写英文字母。
从 s 中选两个不重叠的非空回文子串，有多少种选法？
正式地，计算四元组 (i,j,p,q) 的个数，其中 1≤i≤j<p≤q≤n 且 s[i..j] 和 s[p..q] 都是回文串。
进阶：做到 O(n)。
进阶：改成选三个呢？选四个呢？选 k 个呢？

rating 1500
枚举右维护左。
首先，预处理右端点为 i 的回文子串的个数 cnt。这可以用中心扩展法（或者区间 DP）。
然后计算 cnt 的前缀和 sum，其中 sum[i] 表示右端点 <= i 的回文子串个数。
然后枚举右边的回文子串（再次用中心扩展法）s[p..q]，那么左边就有 sum[p-1] 个回文子串，加入答案。
代码 https://codeforces.com/problemset/submission/159/308862420
代码备份（洛谷）
Manacher O(n) 做法 https://codeforces.com/problemset/submission/159/308870031
======

Input
aa
Output
1

Input
aaa
Output
5

Input
abacaba
Output
36
 */
