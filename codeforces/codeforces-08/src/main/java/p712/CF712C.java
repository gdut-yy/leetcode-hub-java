package p712;

import java.util.Scanner;

public class CF712C {
    static int t, x;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        t = scanner.nextInt();
        x = scanner.nextInt();
        System.out.println(solve());
    }

    private static String solve() {
        int ans = 0;
        int y = x, z = x;
        while (x < t) {
            // x, y, z = y, z, y+z-1
            int new_z = y + z - 1;

            x = y;
            y = z;
            z = new_z;

            ans++;
        }
        return String.valueOf(ans);
    }
}
/*
C. Memory and De-Evolution
https://codeforces.com/contest/712/problem/C

灵茶の试炼 2022-05-27
题目大意：
给你两个整数 x 和 y，满足 3<=y<x<=1e5。
从边长为 x 的等边三角形出发，每次操作你可以将其中一条边的长度修改为某个整数，要求修改后的三条边仍能组成一个三角形。
将三角形修改成边长为 y 的等边三角形，最少需要操作多少次？

rating 1600
https://codeforces.com/contest/712/submission/158586227
正难则反。
从边长为 y 的等边三角形出发，每次将最短的边修改为另外两条边的和减一，直到最短的边不低于 x。
https://leetcode.cn/problems/reaching-points/
======

input
6 3
output
4

input
8 5
output
3

input
22 4
output
6
 */
