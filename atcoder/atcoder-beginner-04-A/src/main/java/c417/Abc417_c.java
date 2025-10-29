package c417;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Abc417_c {
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
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        Map<Integer, Integer> cnt = new HashMap<>();
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += cnt.getOrDefault(i - a[i], 0);
            cnt.merge(i + a[i], 1, Integer::sum);
        }
        out.println(ans);
    }
}
/*
C - Distance Indicators
https://atcoder.jp/contests/abc417/tasks/abc417_c

题目大意：
给你一个长度为 N 的整数序列 A=(A1,A2,...,AN) 。
求满足 j-i=Ai+Aj 的整数 (i,j) (1 <= i < j <= N) 有多少对。
- 1 <= N <= 2e5
- 1 <= Ai <= 2e5 (1 <= i <= N)
- 所有输入值均为整数。

移项，枚举右维护左。
i + ai = j - aj
======

Input 1
9
3 1 4 1 5 9 2 6 5
Output 1
3

Input 2
3
123456 123456 123456
Output 2
0

Input 3
30
8 3 6 4 9 6 5 6 5 6 3 4 7 3 7 4 9 8 5 8 3 6 8 8 4 5 5 5 6 5
Output 3
17
 */
