package c457;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Abc457_g {
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

    private static void solve() {
        int n = scanner.nextInt();
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            a[i][0] = x + y;
            a[i][1] = y - x;
        }
        Arrays.sort(a, (p, q) -> p[0] != q[0] ? p[0] - q[0] : q[1] - p[1]);
        List<Integer> f = new ArrayList<>();
        for (int[] p : a) {
            int v = p[1];
            int j = lowerBound(f, v);
            if (j < f.size()) {
                f.set(j, v);
            } else {
                f.add(v);
            }
        }
        out.println(f.size());
    }

    private static int lowerBound(List<Integer> a, int key) {
        int l = 0, r = a.size();
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a.get(m) >= key) r = m;
            else l = m + 1;
        }
        return l;
    }
}
/*
G - Catch All Apples
https://atcoder.jp/contests/abc457/tasks/abc457_g

灵茶の试炼 2026-05-29
题目大意：
输入 n(1≤n≤3e5) 和一维数轴上的 n 个苹果的信息。
每个苹果输入 t(0≤t≤3e5) 和 x(0≤x≤3e5)，表示在时刻 t，该苹果出现在坐标 x 处。
你想在数轴上放置一些机器人，收集所有苹果。初始位置由你决定。
每个机器人从时刻 0 开始移动，|速度| <= 1。机器人可以重叠。
当且仅当机器人恰好在时间 t 位于坐标 x 时，才能收集到对应的苹果。
最少要多少个机器人，才能收集所有苹果？

rating
把苹果画在平面直角坐标系上，时间为横轴，位置为纵轴。
问题变成：用若干条折线覆盖所有点，要求折线每一段与横轴的夹角不超过 45 度。最少要多少条折线？
这题是 洛谷 P5939 [POI 1998 R3] 折线。
把平面顺时针旋转 45 度，(x,y) 变成 (x+y,y-x)。
「折线每一段与横轴的夹角不超过 45 度」等价于整条折线上的点 x+y 递增（允许相等），y-x 递减（允许相等）。
仿照 LC354. 俄罗斯套娃信封问题 的做法，把旋转后的点按照横坐标升序、纵坐标降序排序，这样只需关注纵坐标，也就是纵坐标最少拆分成多少个递减（允许相等）子序列。
根据 Dilworth 定理，这等价于纵坐标的最长严格递增子序列的长度。
代码 https://atcoder.jp/contests/abc457/submissions/75986403
======

Input 1
4
0 2
1 0
2 1
2 3
Output 1
2

Input 2
5
0 1
0 2
0 3
0 4
0 5
Output 2
5

Input 3
8
10 4
4 2
7 10
5 3
1 9
0 6
3 8
0 9
Output 3
2
 */
