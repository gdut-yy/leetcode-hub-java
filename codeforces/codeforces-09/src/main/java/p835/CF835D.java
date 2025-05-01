package p835;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF835D {
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.next().toCharArray();
        System.out.println(solve());
    }

    private static String solve() {
        int n = s.length;
        boolean[][] isPal = new boolean[n][n];
        int[][] f = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(isPal[i], true);
        }

        int[] ans = new int[n + 1];
        ans[1] = n;
        for (int l = n - 2; l >= 0; l--) {
            f[l][l] = 1;
            for (int r = l + 1; r < n; r++) {
                isPal[l][r] = (s[l] == s[r] && isPal[l + 1][r - 1]);
                if (isPal[l][r]) {
                    f[l][r] = f[l][(l + r - 1) / 2] + 1;
                    ans[f[l][r]]++;
                }
            }
        }
        for (int i = n; i > 1; i--) {
            ans[i - 1] += ans[i];
        }
        return Arrays.stream(ans).skip(1).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
D. Palindromic characteristics
https://codeforces.com/contest/835/problem/D

灵茶の试炼 2025-03-06
题目大意：
输入长度 ≤5000 的字符串 s，只包含小写英文字母。
如果字符串 s 是回文串，我们称 s 为 1 阶回文串。
如果字符串 s 的左半部分等于 s 的右半部分，且左半部分和右半部分都是 k-1 阶回文串，我们称 s 为 k 阶回文串（k > 1）。
注：设 m = floor(len(s)/2)，「左半部分」指 s 的长为 m 的前缀，「右半部分」指 s 的长为 m 的后缀。
输出 n 个数，分别表示 s 的 1,2,3,...,n 阶非空回文子串的个数。

rating 1900
根据题目定义，一个 k 阶字符串一定是回文串，且一定也是 k-1 阶回文串。这可以用数学归纳法证明。
定义 isPal[l][r] 表示 s[l] 到 s[r] 是否为回文串，这可以写个区间 DP（或者中心扩展法）预处理。具体见 力扣 132. 分割回文串 II。
定义 f[l][r]，表示 s[l] 到 s[r] 最大是 f[l][r] 阶回文串。如果不是回文串则 f[l][r]=0。
根据题目的定义，如果 s[l] 到 s[r] 是回文串，那么有
f[l][r] = f[l][(l+r-1)/2] + 1，即左半部分的阶数加一。
初始值 f[i][i] = 1，其余为 0。
统计 f[l][r] 的出现次数，记作 ans。
注意 ans[k] 统计的是最大为 k 阶的回文子串个数。
由于 k 阶回文串一定是 k-1 阶回文串，所以计算 ans 的后缀和，就是题目要算的东西了。
代码 https://codeforces.com/contest/835/submission/308889054
代码备份（洛谷）
======

Input
abba
Output
6 1 0 0

Input
abacaba
Output
12 4 1 0 0 0 0
 */
