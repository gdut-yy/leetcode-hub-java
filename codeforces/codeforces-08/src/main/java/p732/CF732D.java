package p732;

import java.util.Scanner;

public class CF732D {
    static int n, m;
    static int[] d, a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = scanner.nextInt();
        }
        a = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int left = 0;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        int ans = left + 1;
        if (ans > n) ans = -1;
        return String.valueOf(ans);
    }

    static boolean checkMid(int mx) {
        int[] pos = new int[m];
        for (int i = 0; i < mx + 1; i++) {
            if (d[i] > 0) {
                pos[d[i] - 1] = i + 1;
            }
        }
        for (int p : pos) {
            if (p == 0) return false;
        }
        int cnt = 0;
        for (int i = 0; i < mx + 1; i++) {
            int v = d[i];
            if (v > 0 && i + 1 == pos[v - 1]) {
                if (cnt < a[v - 1]) {
                    return false;
                }
                cnt -= a[v - 1];
            } else {
                cnt++;
            }
        }
        return true;
    }
}
/*
D. Exams
https://codeforces.com/contest/732/problem/D

灵茶の试炼 2022-06-08
题目大意：
接下来的 n(<=1e5) 天你需要参加 m(<=1e5) 门课程的考试。
给你一个长度为 n 的数组 d，d[i]=0 表示第 i 天没有考试，否则表示第 i 天有第 d[i](1<=d[i]<=m) 门课程的考试。
还有一个长度为 m 的数组 a，表示第 i 门考试需要花费 a[i](1<=a[i]<=1e5) 天的时间备考，才能通过。
如果你在某一天参加了考试，那么你当天不能备考。
备考同一门课程的时间不需要连续。
请输出参加并通过这 m 门考试的最小天数（天数从 1 开始）。若无法做到，输出 -1。

rating 1700
https://codeforces.com/contest/732/submission/159901481
二分答案。
对于二分的 check 函数，从前往后遍历 d（i 不超过二分值），同时维护可以备考的天数 cnt，如果 d[i] 是当前课程的最后一次考试机会，那么 a[i] > cnt 则无法通过第 i 门课程，返回 false，否则 cnt -= a[i] 继续遍历。如果可以通过所有课程则返回 true。
======

input
7 2
0 1 0 2 1 0 2
2 1
output
5

input
10 3
0 0 1 2 3 0 2 0 1 2
1 1 4
output
9

input
5 1
1 1 1 1 1
5
output
-1
 */
