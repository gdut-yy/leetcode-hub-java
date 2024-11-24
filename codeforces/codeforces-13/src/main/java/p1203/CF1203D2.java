package p1203;

import java.util.Scanner;

public class CF1203D2 {
    static char[] s, t;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.next().toCharArray();
        t = scanner.next().toCharArray();
        System.out.println(solve());
    }

    private static String solve() {
        int n = s.length, m = t.length;
        int[] suf = new int[m + 1];
        suf[m] = n;
        for (int i = n - 1, j = m - 1; j >= 0; i--) {
            if (s[i] == t[j]) {
                suf[j] = i;
                j--;
            }
        }

        int ans = suf[0];
        for (int i = 0, j = 0; j < m; i++) {
            if (s[i] == t[j]) {
                j++;
                ans = Math.max(ans, suf[j] - i - 1);
            }
        }
        return String.valueOf(ans);
    }
}
/*
D2. Remove the Substring (hard version)
https://codeforces.com/contest/1203/problem/D2

灵茶の试炼 2022-07-22
题目大意：
输入两个字符串 s 和 t，长度均不超过 2e5，且由小写字母组成。保证 t 是 s 的子序列。
请你从 s 中删除一个最长的子串，使得 t 仍然是剩下的 s' 的子序列。
输出这个最长子串的长度。

rating 1700
https://codeforces.com/contest/1203/submission/165288618
前后缀分解。
把 t 分解成左右两部分，枚举所有分割位置 j。
对于左部分，匹配 s 的最短前缀；右部分，匹配 s 的最短后缀。
换句话说，记 pre[j] 为 t[j] 可以匹配到 s 的最小下标，suf[j] 为 t[j] 可以匹配到 s 的最大下标。
那么答案为最大的 suf[j+1]-pre[j]-1。
注意边界上的答案，即 suf[0] 和 len(s)-1-pre[-1]。
代码实现时可以先算 suf，在计算 pre 的同时计算答案，这样可以节省一个数组。
相似题目: 2565. 最少得分子序列
https://leetcode.cn/problems/subsequence-with-the-minimum-score/
======

input
bbaba
bb
output
3

input
baaba
ab
output
2

input
abcde
abcde
output
0

input
asdfasdf
fasd
output
3
 */