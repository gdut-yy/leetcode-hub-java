package c419;

import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Abc419_f {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static final int MOD = 998244353;

    private static void solve() {
        int n = scanner.nextInt();
        int L = scanner.nextInt();
        scanner.nextLine(); // consume newline
        String[] patterns = new String[n];
        for (int i = 0; i < n; i++) {
            patterns[i] = scanner.nextLine();
        }

        int total_length = 0;
        for (String p : patterns) {
            total_length += p.length();
        }

        int ns = 1;
        int[][] next_arr = new int[total_length + 1][26];
        int[] output_mask = new int[total_length + 1];
        int[] fail = new int[total_length + 1];

        // Build trie
        for (int idx = 0; idx < n; idx++) {
            String p = patterns[idx];
            int cur = 0;
            for (int j = 0; j < p.length(); j++) {
                char c = p.charAt(j);
                int c_index = c - 'a';
                if (next_arr[cur][c_index] == 0) {
                    next_arr[cur][c_index] = ns;
                    ns++;
                }
                cur = next_arr[cur][c_index];
            }
            output_mask[cur] |= (1 << idx);
        }

        // Build fail pointers
        Queue<Integer> q = new ArrayDeque<>();
        for (int c = 0; c < 26; c++) {
            if (next_arr[0][c] != 0) {
                q.add(next_arr[0][c]);
                fail[next_arr[0][c]] = 0;
            }
        }

        while (!q.isEmpty()) {
            int r = q.poll();
            for (int c = 0; c < 26; c++) {
                int s = next_arr[r][c];
                if (s != 0) {
                    q.add(s);
                    int f = fail[r];
                    while (f != 0 && next_arr[f][c] == 0) {
                        f = fail[f];
                    }
                    fail[s] = next_arr[f][c];
                    if (fail[s] == s) {
                        fail[s] = 0; // avoid self-loop
                    }
                    output_mask[s] |= output_mask[fail[s]];
                } else {
                    int f = fail[r];
                    while (f != 0 && next_arr[f][c] == 0) {
                        f = fail[f];
                    }
                    next_arr[r][c] = next_arr[f][c];
                }
            }
        }

        int nstates = ns;
        int fullMask = (1 << n) - 1;
        long[][] dp = new long[nstates][1 << n];
        dp[0][0] = 1;

        for (int i = 0; i < L; i++) {
            long[][] new_dp = new long[nstates][1 << n];
            for (int state = 0; state < nstates; state++) {
                for (int mask = 0; mask < (1 << n); mask++) {
                    if (dp[state][mask] == 0) continue;
                    for (int c = 0; c < 26; c++) {
                        int next_state = next_arr[state][c];
                        int new_mask = mask | output_mask[next_state];
                        new_dp[next_state][new_mask] =
                                (new_dp[next_state][new_mask] + dp[state][mask]) % MOD;
                    }
                }
            }
            dp = new_dp;
        }

        long ans = 0;
        for (int state = 0; state < nstates; state++) {
            ans = (ans + dp[state][fullMask]) % MOD;
        }
        out.println(ans);
    }
}
/*
F - All Included
https://atcoder.jp/contests/abc419/tasks/abc419_f

题目大意：
给你 N 个小写英文字符串 S1, S2,...,SN 和一个整数 L 。
求长度为 L 的小写英文字符串中，包含所有 S1,S2,...,SN 作为子串的长度为 998244353 的个数。

https://chat.deepseek.com/a/chat/s/52f60d58-d80f-41a9-bee9-395888e254d1
======

Input 1
2 4
ab
c
Output 1
153

Input 2
2 6
abc
cde
Output 2
54

Input 3
5 50
bbfogggj
zkbach
eedirhyc
ffgd
oemmswj
Output 3
689020583
 */
