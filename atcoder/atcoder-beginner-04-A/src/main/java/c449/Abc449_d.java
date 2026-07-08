package c449;

import java.io.PrintWriter;
import java.util.Scanner;

public class Abc449_d {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static long f(long x, long y) {
        if (x < 0 || y < 0) return 0;
        if (y > x) {
            long tmp = y;
            y = x;
            x = tmp;
        }
        long k = y / 2 + 1;
        return k * k * 2 - k + (x / 2 - y / 2) * (y + 1);
    }

    static long calc(int x1, int y1, int x2, int y2) {
        if (x2 < 0) {
            int tmp = x1;
            x1 = -x2;
            x2 = -tmp;
        }
        if (y2 < 0) {
            int tmp = y1;
            y1 = -y2;
            y2 = -tmp;
        }
        if (x1 < 0) return calc(1, y1, -x1, y2) + calc(0, y1, x2, y2);
        if (y1 < 0) return calc(x1, 1, x2, -y1) + calc(x1, 0, x2, y2);
        return f(x2, y2) - f(x1 - 1, y2) - f(x2, y1 - 1) + f(x1 - 1, y1 - 1);
    }

    private static void solve() {
        int l = scanner.nextInt(), r = scanner.nextInt(), d = scanner.nextInt(), u = scanner.nextInt();
        out.println(calc(l, d, r, u));
    }
}
/*
D - Make Target 2
https://atcoder.jp/contests/abc449/tasks/abc449_d

灵茶の试炼 2026-06-09
题目大意：
输入 L R D U (-1e6≤L≤R≤1e6, -1e6≤D≤U≤1e6)。
输出有多少个整点 (x,y)，满足 L≤x≤R 且 D≤y≤U 且 max(|x|,|y|) 是偶数。
进阶：做到 O(1) 时间复杂度。

rating
O(1) 时间复杂度的做法。
题目要计算一个矩形区域内的合法整点个数。
首先把问题化简成 L = 0 且 D = 0 的简单情况。
如果 R < 0，把矩形区域按 y 轴翻转。
如果 U < 0，把矩形区域按 x 轴翻转。
如果 L < 0，把矩形区域拆分成 L'=1, R'=-L 的左半部分，以及 L'=0, R'=R 的右半部分。
如果 D < 0，把矩形区域拆分成 D'=1, U'=-D 的下半部分，以及 D'=0, U'=U 的上半部分。
现在只需考虑在第一象限（以及坐标轴）的子矩形区域。用二维容斥，拆成四个左下角为 (0,0) 的子矩形区域。原理见 【图解】一张图秒懂二维前缀和。
计算左下角在 (0,0)，右上角在 (x,y) 的矩形内的合法整点个数。
不失一般性，设 x >= y（不满足则交换 x 和 y）。
拆分成左下角在 (0,0)，右上角在 (y,y) 的正方形，以及左下角在 (y+1,0)，右上角在 (x,y) 的矩形。
左下角在 (0,0)，右上角在 (y,y) 的正方形的合法整点个数，是一个首项为 1，公差为 4 的等差数列之和 1+5+9+...
设 k = y/2 + 1，等差数列之和为 (2k-1)k。
左下角在 (y+1,0)，右上角在 (x,y) 的矩形，有 x/2-y/2 条长为 y+1 的条形合法整点，即 (x/2-y/2) * (y+1) 个合法整点。
代码 https://atcoder.jp/contests/abc449/submissions/76211544
======

Input 1
-4 3 1 3
Output 1
10

Input 2
-14 14 -14 14
Output 2
449
 */
