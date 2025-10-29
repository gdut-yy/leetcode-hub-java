package c423;

import java.io.PrintWriter;
import java.util.Scanner;

public class Abc423_c {
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
        int R = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int[] ps = new int[n + 1];
        for (int i = 0; i < n; i++) {
            ps[i + 1] = ps[i] + a[i];
        }

        Integer leftMin = null;
        for (int i = 1; i < R; i++) {
            if (a[i - 1] == 0) {
                leftMin = i;
                break;
            }
        }

        Integer rightMax = null;
        for (int i = n; i > R; i--) {
            if (a[i - 1] == 0) {
                rightMax = i;
                break;
            }
        }

        int leftLocked = 0;
        if (leftMin != null) {
            leftLocked = ps[R] - ps[leftMin];
        }

        int rightLocked = 0;
        if (rightMax != null) {
            rightLocked = ps[rightMax] - ps[R];
        }

        int U = 0;
        for (int x : a) {
            if (x == 0) U++;
        }
        int ans = U + 2 * (leftLocked + rightLocked);
        out.println(ans);
    }
}
/*
C - Lock All Doors
https://atcoder.jp/contests/abc423/tasks/abc423_c

题目大意：
有 N+1(2e5) 个房间排成一行，依次编号为 0, 1, ..., N。
房间之间有 N 扇门，编号为 1, 2, ..., N 。门 i 位于房间 i-1 和 i 之间。
每扇门都有一个代表门锁状态的值 Li 。当 Li = 0 时，门 i 未上锁；当 Li = 1 时，门 i 上锁。
高桥最初在 R 房间，只有当 i 门被打开时，他才能在 i-1 和 i 房间之间移动。此外，只有当他在 i-1 房间或 i 房间时，才能对 i 门进行切换操作。
求使所有门都上锁所需的最少开关操作次数。

前缀和。
https://chat.deepseek.com/a/chat/s/a3e51e2b-6c4a-4d30-b3a0-26011fb04bb5
======

Input 1
6 3
1 0 0 1 0 0
Output 1
6

Input 2
2 1
0 0
Output 2
2

Input 3
8 2
0 1 0 0 1 0 1 1
Output 3
8
 */
