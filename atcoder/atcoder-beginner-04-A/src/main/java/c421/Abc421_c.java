package c421;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Abc421_c {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        char[] s = scanner.next().toCharArray();

        List<Integer> posA = new ArrayList<>();
        List<Integer> posB = new ArrayList<>();
        for (int i = 0; i < n * 2; i++) {
            if (s[i] == 'A') posA.add(i);
            else posB.add(i);
        }
        long ans = Math.min(getAns(posA), getAns(posB));
        out.println(ans);
    }

    static long getAns(List<Integer> posA) {
        int idx = 0;
        long ans = 0;
        for (Integer v : posA) {
            ans += Math.abs(v - idx);
            idx += 2;
        }
        return ans;
    }
}
/*
C - Alternated
https://atcoder.jp/contests/abc421/tasks/abc421_c

题目大意：
给你一个长度为 2N 的字符串 S 。其中 S 恰好包含 N 次的 `A` 和 N 次的 `B`。
求使 S 中没有相邻的相同字符所需的最少操作次数（可能为零），其中一个操作包括交换 S 中相邻的两个字符。

分类讨论。
======

Input 1
3
AABBBA
Output 1
2

Input 2
3
AAABBB
Output 2
3

Input 3
17
AAABABABBBABABBABABABABBAAABABABBA
Output 3
15
 */
