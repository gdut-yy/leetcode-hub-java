package c205;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Arc205_e {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static final int INF = 1 << 10;
    private static final int MOD = 998244353;

    private static void solve() {
        int n = scanner.nextInt();
        int[] d = new int[1 << 20];
        Arrays.fill(d, 1);
        int[] ans = new int[n];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int x1 = x >> 10;
            int x2 = x & (INF - 1);

            for (int j = 0; j < INF; j++) {
                if ((x1 & j) == x1) {
                    int index = (j << 10) | x2;
                    long temp = (long) d[index] * x % MOD;
                    d[index] = (int) temp;
                }
            }

            long res = 1;
            for (int j = 0; j < INF; j++) {
                if ((x2 & j) == j) {
                    int index = (x1 << 10) | j;
                    res = res * d[index] % MOD;
                }
            }
            ans[cnt] = (int) res;
            cnt++;
        }

        for (int num : ans) {
            out.println(num);
        }
    }
}
/*
E - Subset Product Problem
https://atcoder.jp/contests/arc205/tasks/arc205_e

题目大意：
给你一个长度为 N(4e5) 的非负整数序列 A=(A_1,A_2,...,A_N) 。
对于 k=1,2,...,N ，求解下面的问题。
- 求 1 和 k 之间所有整数 i 的 A_i 的 积，取模 998244353 ，使得 A_i 和 A_k 的位运算 OR 等于 A_k 。

https://atcoder.jp/contests/arc205/editorial/13829
https://yuanbao.tencent.com/chat/naQivTmsDa/ad308c30-862c-490a-b812-dcd5d4abb073
======

Input 1
4
1 2 3 5
Output 1
1
2
6
5

Input 2
9
3 1 4 1 5 9 2 6 5
Output 2
3
1
4
1
20
9
2
48
100

Input 3
12
437926 528156 284664 1038330 692060 720863 602077 1027766 868190 532252 982711 876446
Output 3
437926
528156
284664
94842632
158208162
985930968
548875758
875494466
345599613
605424119
111381243
768586512
 */
