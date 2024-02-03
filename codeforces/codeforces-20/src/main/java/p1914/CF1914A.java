package p1914;

import java.util.Scanner;

public class CF1914A {
    static int n;
    static String s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            s = scanner.next();
            System.out.println(solve());
        }
    }

    private static String solve() {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'A']++;
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] >= i + 1) {
                ans++;
            }
        }
        return String.valueOf(ans);
    }
}
/*
Codeforces Round 916 (Div. 3)
A. Problemsolving Log
https://codeforces.com/contest/1914/problem/A

题目大意：
Monocarp 正在参加一个编程竞赛，共有 26 个问题，从“A”到“Z”命名。这些问题是按难度排序的。此外，已知 Monocarp 可以在 1 分钟内解决问题 A，在 2 分钟内解决问题 B，……26 分钟后再做第 Z 题。
比赛结束后，你发现了他的比赛日志——一个由大写拉丁字母组成的字符串，第 i 个字母告诉你 Monocarp 在比赛的第 i 分钟在解决哪个问题。如果独果花了足够的时间去解决一个问题，他就会解决它。注意，Monocarp 可能在解决问题后还在思考问题。
给定 Monocarp 的比赛日志，计算他在比赛中解决的问题数量。

模拟，计数
======

input
3
6
ACBCBC
7
AAAAFPC
22
FEADBBDFFEDFFFDHHHADCC
output
3
1
4
 */
