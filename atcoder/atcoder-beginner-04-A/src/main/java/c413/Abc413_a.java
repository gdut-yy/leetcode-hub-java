package c413;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Abc413_a {
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
        int m = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        boolean ans = Arrays.stream(a).sum() <= m;
        out.println(ans ? "Yes" : "No");
    }
}
/*
A - Content Too Large
https://atcoder.jp/contests/abc413/tasks/abc413_a

题目大意：
高桥有 N 件物品和一个袋子。
i-(1 <= i <= N) 件物品的大小是 Ai ，袋子的大小是 M 。
如果且只有当他试图放入袋子中的物品的总大小最多为 M 时，他才能同时将所有这些物品放入袋子中。
如果他能同时将所有 N 件物品放入袋子，则打印 "是"；否则打印 "否"。

判断数组 a 的和不超过 m。
======

Input 1
5 15
3 1 4 1 5
Output 1
Yes

Input 2
5 5
3 1 4 1 5
Output 2
No

Input 3
1 10000
100
Output 3
Yes
 */
