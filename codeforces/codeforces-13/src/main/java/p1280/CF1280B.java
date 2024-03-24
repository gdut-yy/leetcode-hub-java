package p1280;

import java.util.Scanner;

public class CF1280B {
    static int n, m;
    static char[][] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            a = new char[n][m];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.next().toCharArray();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        int tot = 0;
        int[] col = new int[m];
        boolean fullR = false;
        for (char[] row : a) {
            int r = 0;
            for (int j = 0; j < m; j++) {
                if (row[j] == 'A') {
                    r++;
                    col[j]++;
                }
            }
            tot += r;
            if (r == m) {
                fullR = true;
            }
        }
        boolean fullC = false;
        for (int c : col) {
            if (c == n) {
                fullC = true;
                break;
            }
        }

        int r = 0, rr = 0;
        for (char c : a[0]) {
            if (c == 'A') r++;
        }
        for (char c : a[n - 1]) {
            if (c == 'A') rr++;
        }

        if (tot == 0) {
            return "MORTAL";
        }
        if (tot == n * m) {
            return "0";
        }
        if (r == m || rr == m || col[0] == n || col[m - 1] == n) {
            return "1";
        }
        if (fullR || fullC || a[0][0] == 'A' || a[0][m - 1] == 'A' || a[n - 1][0] == 'A' || a[n - 1][m - 1] == 'A') {
            return "2";
        }
        if (r > 0 || rr > 0 || col[0] > 0 || col[m - 1] > 0) {
            return "3";
        }
        return "4";
    }
}
/*
B. Beingawesomeism
https://codeforces.com/contest/1280/problem/B

灵茶の试炼 2022-06-17
题目大意：
给你 T(<=2e4) 表示有 T 组数据。
每组数据给你 r(<=60) 和 c(<=60)，保证所有数据的 r*c 之和不超过 3e6。
然后给你 r 行字符串，每行长度为 c，组成了一个只有 'A' 和 'P' 的网格图。
每次操作，你可以选择某一行的某一段，假设这一段是一把颜料刷，将其向上或者向下移动任意长度，每次移动都会用颜料刷替换对应的段（具体见图）。
你也可以选择某一列的某一段，将其向左或者向右移动任意长度，每次移动都会用颜料刷替换对应的段。
输出最少需要操作几次可以让整个网格图全为 'A'，若无法做到则输出 "MORTAL"。

rating 1800
https://codeforces.com/problemset/submission/1280/160912594
分类讨论：
全为 P："MORTAL"
全为 A：0 次
四周某条边全为 A：1 次
四角有 A：2 次（花费一次操作可以变为四周某条边全为 A 的情况）
中间某一行或某一列全为 A：2 次
四周某条边有 A：3 次（花费两次操作可以变为四周某条边全为 A 的情况）
其余：4 次（花费两次操作变为中间某一行或某一列全为 A 的情况）
======

input
4
7 8
AAPAAAAA
PPPPAAAA
PPPPAAAA
APAAPPPP
APAPPAPP
AAAAPPAP
AAAAPPAA
6 5
AAAAA
AAAAA
AAPAA
AAPAP
AAAPP
AAAPP
4 4
PPPP
PPPP
PPPP
PPPP
3 4
PPPP
PAAP
PPPP
output
2
1
MORTAL
4
 */
