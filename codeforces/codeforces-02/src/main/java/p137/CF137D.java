package p137;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CF137D {
    static char[] s;
    static int k;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.next().toCharArray();
        k = scanner.nextInt();
        System.out.println(solve());
    }

    private static String solve() {
        int n = s.length;
        int[][] mc = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                mc[i][j] = mc[i + 1][j - 1];
                if (s[i] != s[j]) {
                    mc[i][j]++;
                }
            }
        }

        int[][] fr = new int[k][n];
        int[] f = mc[0];
        int minF = f[n - 1], minK = 0;
        for (int i = 1; i < k; i++) {
            for (int r = n - 1; r >= i; r--) {
                f[r] = (int) 1e9;
                for (int l = i; l <= r; l++) {
                    int v = f[l - 1] + mc[l][r];
                    if (v < f[r]) {
                        f[r] = v;
                        fr[i][r] = l;
                    }
                }
            }
            if (f[n - 1] < minF) {
                minF = f[n - 1];
                minK = i;
            }
        }

        List<String> path = new ArrayList<>();
        for (int i = minK, r = n - 1; i >= 0; i--) {
            int l = fr[i][r];
            // t := s[l : r+1]
            char[] t = Arrays.copyOfRange(s, l, r + 1);
            for (int j = 0, m = t.length; j < m / 2; j++) {
                char c = t[m - 1 - j];
                if (t[j] != c) {
                    t[j] = c;
                }
            }
            path.add(new String(t));
            r = l - 1;
        }
        Collections.reverse(path);

        return minF + System.lineSeparator() +
                String.join("+", path);
    }
}
/*
D. Palindromes
https://codeforces.com/contest/137/problem/D

灵茶の试炼 2025-03-05
题目大意：
输入长度 ≤500 的字符串 s，包含大小写英文字母。
输入 k(1≤k≤|s|)。
每次操作，你可以把一个 s[i] 改成任意字符。
把 s 分割为至多 k 个非空子串，要求每个子串都是回文串，最少要修改多少次？
第一行，输出最少修改次数。
第二行，输出修改后的字符串，并用 '+' 表示分割位置，详见样例。
如果有多种分割方案，输出其中任意一种。

rating 1900
本题是 力扣 1278. 分割回文串 III 的变形题，改成【至多】，并要求输出具体方案。
状态定义见我的力扣题解。
把【恰好】改成【至多】，并没有太大区别。在计算 DP 的过程中，每个 f[i][n-1] 都可以是答案，取其中的最小值。
此外，DP 的过程中记录转移来源 from，方便输出具体方案。
算完 DP 后，从终点出发，顺着 from 走到起点（i=0），过程中记录分割出了哪些子串（改成回文串）。
注：这里的终点指对应着最小 f[i][n-1] 的 (i,n-1)。
代码 https://codeforces.com/problemset/submission/137/309000409
代码备份（洛谷）
======

Input
abacaba
1
Output
0
abacaba

Input
abdcaba
2
Output
1
abdcdba

Input
abdcaba
5
Output
0
a+b+d+c+aba

Input
abacababababbcbabcd
3
Output
1
abacaba+babab+bcbabcb
 */
