package c423;

import java.io.PrintWriter;
import java.util.Scanner;

public class Abc423_b {
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

        int l = 0, r = n;
        while (l < n && a[l] == 0) l++;
        while (r - 1 >= 0 && a[r - 1] == 0) r--;
        int ans = Math.max(0, r - l - 1);
        out.println(ans);
    }
}
/*
B - Locked Rooms
https://atcoder.jp/contests/abc423/tasks/abc423_b

题目大意：
有 N+1(100) 个房间排成一行，依次编号为 0, 1, ... , N。
房间之间有 N 扇门，编号为 1, 2, ..., N 。门 i 位于房间 i-1 和 i 之间。
每扇门都有一个代表门锁状态的值 Li 。当 Li = 0 时，门 i 未上锁；当 Li = 1 时，门 i 上锁。
有两个人，一个在 0 房间，另一个在 N 房间。只有当门 i 未上锁时，每个人才可以在房间 i-1 和 i 之间移动。
求两人都无法到达的房间数。

双指针。
======

Input 1
5
0 1 0 0 1
Output 1
3

Input 2
3
1 0 1
Output 2
2

Input 3
8
0 0 1 1 0 1 0 0
Output 3
3
 */
