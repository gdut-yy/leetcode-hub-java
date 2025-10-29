package c413;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Abc413_b {
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
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }

        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                set.add(a[i] + a[j]);
            }
        }
        out.println(set.size());
    }
}
/*
B - cat 2
https://atcoder.jp/contests/abc413/tasks/abc413_b

题目大意：
给你 N 种字符串 S1,S2,...,SN 。
请执行一次以下操作：
- 选择不同的整数 i 和 j (1<=i<=N, 1<=j<=N) 并按此顺序连接 Si 和 Sj 。
这一操作可以得到多少个不同的字符串？
如果选择不同的 (i,j) 得到相同的连接字符串，则算作一个字符串。

n <= 100，直接暴力。
======

Input 1
4
at
atco
coder
der
Output 1
11

Input 2
5
a
aa
aaa
aaaa
aaaaa
Output 2
7

Input 3
10
armiearggc
ukupaunpiy
cogzmjmiob
rtwbvmtruq
qapfzsitbl
vhkihnipny
ybonzypnsn
esxvgoudra
usngxmaqpt
yfseonwhgp
Output 3
90
 */
