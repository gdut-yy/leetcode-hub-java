package c456;

import java.io.PrintWriter;
import java.util.Scanner;

public class Abc456_d {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static final int MOD = 998244353;

    private static void solve() {
        String s = scanner.next();
        long[] f = new long[3];
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            f[c] = (f[0] + f[1] + f[2] + 1) % MOD;
        }
        out.println((f[0] + f[1] + f[2]) % MOD);
    }
}
/*
D - Not Adjacent 2
https://atcoder.jp/contests/abc456/tasks/abc456_d

灵茶の试炼 2026-06-01
题目大意：
输入长度 ≤3e5 的字符串 s，只包含 'a' 'b' 'c'。
输出 s 中的相邻字母均不相同的非空子序列个数，模 998244353。
完全一样但位置不同的子序列，算作不同的子序列。

rating
定义 f[i][j] 表示 s 前 i 个字母中的以字母 j 结尾的子序列个数。
对于 s[i]，例如 s[i]='b'：
如果不选，那么 f[i][1] = f[i-1][1]。
如果选，那么拼在上一个字母的末尾，或者单个字母形成一个子序列，即 f[i][1] = (f[i-1][0] + f[i-1][2] + 1)。
合起来就是 f[i][1] = (f[i-1][0] + f[i-1][1] + f[i-1][2] + 1)。
另外两个状态不变，即 f[i][0] = f[i-1][0]，f[i][2] = f[i-1][2]。
一般地，f[i][s[i]] = (f[i-1][0] + f[i-1][1] + f[i-1][2] + 1)，另外两个状态不变。
代码实现时，f 的第一个维度可以优化掉。
代码 https://atcoder.jp/contests/abc456/submissions/76158825
======

Input 1
abbc
Output 1
11

Input 2
cabcabcbcaccacbcbcaabacbacaabccacbccbcacbacbacabcacabcaccaaaaabababcbabacaccabbcacbcbcbcababcbcbabca
Output 2
378217423
 */
