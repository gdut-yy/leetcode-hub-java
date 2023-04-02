package p961;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF961D {
    private static int n;
    private static int[][] xy;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        xy = new int[n][2];
        for (int i = 0; i < n; i++) {
            xy[i][0] = scanner.nextInt();
            xy[i][1] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        if (n <= 4 || f(xy[0], xy[1]) || f(xy[0], xy[2]) || f(xy[1], xy[2])) {
            return "YES";
        }
        return "NO";
    }

    private static boolean f(int[] p1, int[] p2) {
        List<int[]> other = new ArrayList<>();
        for (int[] p : xy) {
            if (!isSameLine(p1, p2, p)) {
                if (other.size() < 2) {
                    other.add(p);
                } else if (!isSameLine(other.get(0), other.get(1), p)) {
                    return false;
                }
            }
        }
        return true;
    }

    // (y2-y1)/(x2-x1) == (y3-y1)/(x3-x1)
    private static boolean isSameLine(int[] p1, int[] p2, int[] p3) {
        return ((long) p2[0] - p1[0]) * (p3[1] - p1[1]) == ((long) p3[0] - p1[0]) * (p2[1] - p1[1]);
    }
}
/*
D. Pair Of Lines
https://codeforces.com/contest/961/problem/D

灵茶の试炼 2023-01-25
题目大意：
输入 n(≤1e5) 和 n 个点 (xi,yi)，范围在 [-1e9,1e9]，所有点都是不同的。
你能否画至多两条直线，覆盖所有点？输出 YES 或 NO。

https://codeforces.com/contest/961/submission/190438603
提示 1：如果可以画，那么任意三点中必然有两个点在所画直线上。
提示 2：枚举前三个点中的两个点，确定一条直线，然后看其余点是否在一条直线上。
======

input
5
0 0
0 1
1 1
1 -1
2 2
output
YES

input
5
0 0
1 0
2 1
1 1
2 3
output
NO

10
536870912 536870912
268435456 368435456
268435456 168435456
1 3
2 4
3 5
4 6
5 7
6 8
7 9
NO
 */
