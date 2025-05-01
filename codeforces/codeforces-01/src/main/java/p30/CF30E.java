package p30;

import java.util.Arrays;
import java.util.Scanner;

public class CF30E {
    static String s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.next();
        System.out.println(solve());
    }

    private static String solve() {
        int n = s.length();

        int[] pi = prefix_function((new StringBuilder(s).reverse() + "#" + s).toCharArray());
        pi = Arrays.copyOfRange(pi, n, pi.length); // 注意 pi[0] 对应 '#'
        int[] preMaxI = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int j = preMaxI[i - 1];
            if (pi[i] > pi[j]) {
                preMaxI[i] = i;
            } else {
                preMaxI[i] = j;
            }
        }

        int maxSum = 0, maxI = 0;
        int[] halfLen = new int[n];
        int boxM = 0, boxR = 0;
        for (int i = 0; i < halfLen.length; i++) {
            int hl = 1;
            if (i < boxR) hl = Math.min(halfLen[boxM * 2 - i], boxR - i);
            while (i >= hl && i + hl < n && s.charAt(i - hl) == s.charAt(i + hl)) {
                hl++;
                boxM = i;
                boxR = i + hl;
            }
            halfLen[i] = hl;

            int l = i - hl + 1, r = i + hl - 1;
            int k = Math.min(pi[preMaxI[l]], n - 1 - r);
            int sum = r - l + 1 + k * 2;
            if (sum > maxSum) {
                maxSum = sum;
                maxI = i;
            }
        }

        int l = maxI - halfLen[maxI] + 1, r = maxI + halfLen[maxI] - 1;
        int k = Math.min(pi[preMaxI[l]], n - 1 - r);
        if (k == 0) {
            return "1\n" +
                    (l + 1) + " " + (r - l + 1);
        } else {
            return "3\n" +
                    (preMaxI[l] - k + 1) + " " + k + "\n" +
                    (l + 1) + " " + (r - l + 1) + "\n" +
                    (n - k + 1) + " " + k;
        }
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
E. Tricky and Clever Password
https://codeforces.com/contest/30/problem/E

灵茶の试炼 2025-03-28
题目大意：
输入长度 ≤1e5 的字符串 s，只包含小写英文字母。
有一个奇回文串 t，设 t = pre + mid + suf，其中 mid 的长度是奇数，pre 和 suf 的长度相等（可以为 0）。
已知 s = A + pre + B + mid + C + suf（A B C 可以为空），求 t 的最大长度。
输出格式：
首先输出 t 有几段。如果 pre 的长度为 0，则输出 1，否则输出 3。
然后输出每段首字母在 s 中的下标（从 1 开始），以及这一段的长度。
多解输出任意解。

rating 2800
本文讨论的下标，从 0 开始。
枚举 mid 的回文中心 i。
首先证明，在固定回文中心 i 的前提下，mid 越长越好。
如果 mid 不是以 i 为中心的最长回文子串，那么把 mid 向左向右各扩展一个字母，pre 和 suf 的长度至多减一（mid 和 pre suf 贴在一起的情况才会减一），所以总长度不会减少。所以在固定回文中心 i 的前提下，mid 越长越好。
由于只需要计算每个回文中心的最长回文子串，所以用 Manacher 算法。
现在问题变成：已知 mid，求 mid 左右两侧的最长 pre 和 suf。
这可以用 KMP + 前缀最大值解决。
为了匹配 pre 和 suf，计算 rev(s) + '#' + s 的 pi 数组，然后去掉 rev(s)，也就是更新 pi 为 pi[n:]。
现在 pi[i+1] 表示以 s[i] 结尾的最长 pre 长度。
由于 pi 数组不是有序的，我们需要计算 pi 数组的前缀最大值数组 preMax。计算完后，preMax[mid 左端点] 就是 pre 的最大长度了。
这个过程中记录 pre + mid + suf 的最大长度及其位置，方便输出。
前缀最大值也可以改成在 pi 数组中的下标，方便输出。
代码（Manacher + KMP） https://codeforces.com/contest/30/submission/311602074
代码备份（洛谷）
注：也可以用 Z 函数做，但需要用单调队列优化。
代码（Manacher + Z 函数） https://codeforces.com/contest/30/submission/311198128
======

Input
abacaba
Output
1
1 7

Input
axbya
Output
3
1 1
2 1
5 1

Input
xabyczba
Output
3
2 2
4 1
7 2
 */
