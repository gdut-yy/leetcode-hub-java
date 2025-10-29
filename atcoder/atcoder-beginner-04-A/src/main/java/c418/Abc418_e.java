package c418;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Abc418_e {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    record Point(int x, int y) {
    }

    private static void solve() {
        int n = scanner.nextInt();
        int[][] points = new int[n][2];
        for (int i = 0; i < n; i++) {
            points[i][0] = scanner.nextInt();
            points[i][1] = scanner.nextInt();
        }

        Map<Point, Integer> slopeCount = new HashMap<>();
        Map<Point, Integer> midCount = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int x1 = points[i][0], y1 = points[i][1];
            for (int j = i + 1; j < n; j++) {
                int x2 = points[j][0], y2 = points[j][1];
                int dx = x2 - x1;
                int dy = y2 - y1;

                Point slope;
                if (dx == 0) {
                    slope = new Point(0, 1);
                } else {
                    if (dx < 0) {
                        dx = -dx;
                        dy = -dy;
                    }
                    int g = getGCD(dx, Math.abs(dy));
                    dx /= g;
                    dy /= g;
                    slope = new Point(dx, dy);
                }

                slopeCount.merge(slope, 1, Integer::sum);
                Point mid = new Point(x1 + x2, y1 + y2);
                midCount.merge(mid, 1, Integer::sum);
            }
        }

        long T = 0;
        for (int cnt : slopeCount.values()) {
            T += (long) cnt * (cnt - 1) / 2;
        }
        long P = 0;
        for (int cnt : midCount.values()) {
            P += (long) cnt * (cnt - 1) / 2;
        }

        long ans = T - P;
        out.println(ans);
    }

    private static int getGCD(int num1, int num2) {
        return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
    }
}
/*
E - Trapezium
https://atcoder.jp/contests/abc418/tasks/abc418_e

题目大意：
在一个二维平面上有 N 个点，其中第 i 个点的坐标为 (X_i, Y_i) 。保证没有两个点在同一位置，也没有三个点是相交的。
在这些点的四点组合中，以这四点为顶点能组成梯形多边形的组合有多少种？

https://chat.deepseek.com/a/chat/s/f0b06824-1b85-42aa-a0c8-db8cfc436dee
======

Input 1
5
0 2
0 5
1 0
2 1
2 4
Output 1
3

Input 2
8
0 1
1 3
2 3
3 1
0 2
1 0
2 0
3 2
Output 2
22
 */
