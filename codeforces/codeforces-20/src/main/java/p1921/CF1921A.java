package p1921;

import java.util.Arrays;
import java.util.Scanner;

public class CF1921A {
    static int[] x;
    static int y;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            x = new int[4];
            for (int i = 0; i < 4; i++) {
                x[i] = scanner.nextInt();
                y = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        int mx = Arrays.stream(x).max().orElseThrow();
        int mn = Arrays.stream(x).min().orElseThrow();
        int ans = (mx - mn) * (mx - mn);
        return String.valueOf(ans);
    }
}
/*
Codeforces Round 920 (Div. 3)
A. Square
https://codeforces.com/contest/1921/problem/A

题目大意：
正(严格大于 0)面积的正方形位于坐标平面上，其边平行于坐标轴。你得到了它的角的坐标，以随机的顺序。你的任务是求出正方形的面积。

简单判断。
======

input
3
1 2
4 5
1 5
4 2
-1 1
1 -1
1 1
-1 -1
45 11
45 39
17 11
17 39
output
9
4
784
 */
