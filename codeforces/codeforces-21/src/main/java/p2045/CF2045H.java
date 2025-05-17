package p2045;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CF2045H {
    static PrintWriter out = new PrintWriter(System.out);
    static String S;
    static char[] s;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        S = scanner.next();
        s = S.toCharArray();
        solve();
        out.close();
    }

    static int[][] lcp;

    private static void solve() {
        int n = s.length;
        lcp = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (s[i] == s[j]) {
                    lcp[i][j] = lcp[i + 1][j + 1] + 1;
                }
            }
        }

        int[][] f = new int[n][n];
        int[][] sufMaxK = new int[n][n];
        int[][] next = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            f[i][n - 1] = 1;
            next[i][n - 1] = n;
            int k = n - 1;
            for (int j = n - 1; j >= i; j--) {
                if (less(i, j + 1, j + 1, n)) {
                    int l = Math.min(lcp[i][j + 1], j - i + 1);
                    int k2 = sufMaxK[j + 1][j + 1 + l];
                    next[i][j] = k2;
                    f[i][j] = f[j + 1][k2] + 1;
                    if (f[i][j] > f[i][k]) {
                        k = j;
                    }
                }
                sufMaxK[i][j] = k;
            }
        }

//        StringBuilder output = new StringBuilder(n * 2);
//        output.append(f[0][sufMaxK[0][0]]);
        out.println(f[0][sufMaxK[0][0]]);
        for (int i = 0, j = sufMaxK[0][0]; i < n; ) {
            // s[i:j+1]
//            output.append("\n").append(s, i, j + 1 - i);
            out.println(S.substring(i, j + 1));
            // i, j = j+1, int(next[i][j]
            int nj = next[i][j];
            i = j + 1;
            j = nj;
        }
    }

    static boolean less(int l1, int r1, int l2, int r2) {
        int len1 = r1 - l1, len2 = r2 - l2;
        int l = lcp[l1][l2];
        if (l >= Math.min(len1, len2)) {
            return len1 < len2;
        }
        return s[l1 + l] < s[l2 + l];
    }
}
/*
H. Missing Separators
https://codeforces.com/contest/2045/problem/H

灵茶の试炼 2024-12-20
题目大意：
输入一个长度 ≤5000 的字符串 s，只包含大写英文字母。
把 s 划分成若干段（子串），这些子串从左到右，字典序必须是严格递增的（不能相同）。
输出最多能划分成多少段，以及具体划分方案。
如果划分方案不止一种，输出任意一种。

rating 2200
下面的区间均为闭区间。
性质：左端点固定时，字符串越长，字典序越大，即 s[i,j] < s[i,j+1] < s[i,j+2] < ... < s[i,n-1]。
推论：如果 i<=j<=k 且 s[i,j] < s[j+1,k]，那么 s[i,j] 必然 < s[j+1,n-1]。
反过来说，如果 s[i,j] < s[j+1,n-1]，那么一定存在一个 k，使得 s[j+1,k-1] <= s[i,j] < s[j+1,k]。
用 LCP 数组，可以 O(1) 比较 s[i,j] 和 s[j+1,n-1] 的大小关系，然后 O(1) 找到这样的 k，即 j+1+min(lcp[i][j+1],j-i+1)。因为从 j+1 往后数 lcp[i][j+1] 个位置，正好就是 s[i,j] 和 s[j+1,n-1] 不同的那个位置，由于 s[i,j] < s[j+1,n-1]，所以 s[i,j] < s[j+1,k]。
关于 LCP 数组的定义及计算方法，见上周周赛第三题我的题解。
上面考验你的字符串能力，下面考验你的 DP 能力。
定义 f[i][j] 表示拆分 s[0,j]，且最后一个单词是 s[i,j] 的最大拆分个数。
枚举 k，如果 s[i][j] < s[j+1][k]，那么 f[i][j] = f[j+1][k] + 1。
但这样时间复杂度是 O(n^3)，需要优化。
根据上面的推论，可以维护 f[i] 数组的后缀最大值的下标，即定义 sufMaxK[i][j] 表示 f[i] 的后缀 [j,n-1] 中的最大值的下标。这样就能 O(1) 找到 f[j+1] 中的最大的转移来源 f[j+1][k] 是多少，以及 k 具体是多少。
但注意 k 不能太小，k 的最小值就是上面的 j+1+min(lcp[i][j+1],j-i+1)。
为了输出具体方案，还需要用一个 next 数组，其中 next[i][j] 表示 f[i][j] 的转移来源是 f[j+1][next[i][j]]。
代码 https://codeforces.com/problemset/submission/2045/297174942
代码备份（洛谷）
======

Input
ABACUS
Output
4
A
BA
C
US

Input
AAAAAA
Output
3
A
AA
AAA

Input
EDCBA
Output
1
EDCBA
 */
