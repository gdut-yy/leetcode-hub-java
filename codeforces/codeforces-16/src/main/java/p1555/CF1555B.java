package p1555;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF1555B {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static final int INF = (int) 1e9;

    private static void solve() {
        int W = scanner.nextInt(), H = scanner.nextInt();
        int x1 = scanner.nextInt(), y1 = scanner.nextInt(), x2 = scanner.nextInt(), y2 = scanner.nextInt();
        int w = scanner.nextInt(), h = scanner.nextInt();

        int ans = INF;
        if (w + x2 - x1 <= W) {
            ans = Math.max(w - Math.max(x1, W - x2), 0);
        }
        if (h + y2 - y1 <= H) {
            ans = Math.min(ans, Math.max(h - Math.max(y1, H - y2), 0));
        }
        if (ans == INF) {
            ans = -1;
        }
        out.println(ans);
    }
}
/*
B. Two Tables
https://codeforces.com/contest/1555/problem/B

灵茶の试炼 2025-09-01
题目大意：
输入 T(≤1e4) 表示 T 组数据。
每组数据输入 W H(1≤W,H≤1e8)，表示房间的宽和高。
然后输入房间内的一张桌子的左下角和右上角坐标。这张桌子与房间的墙壁平行。
然后输入 w(1≤w≤W) h(1≤h≤H)，你需要在房间内再放一张宽 w 高 h 的桌子，也与墙壁平行。
你可以移动第一张桌子，使得有足够的空间放第二张桌子。
输出最小移动距离，即桌子左下角在移动前后的欧氏距离。与正确答案的误差必须 <= 1e-6。
如果无法做到，输出 -1。

rating 1300
由于只有两个桌子，新桌子要么放在旧桌子的左右，要么放在旧桌子的上下，所以旧桌子只需水平或者垂直移动。
以水平移动为例说明。
首先必须满足 w+x2-x1 <= W，这样才能有足够的空间。
旧桌子离墙的最远距离为 d = max(x1,W-x2)。
如果 d >= w，那么无需移动。
否则需要移动 w-d。
代码 https://codeforces.com/contest/1555/submission/335006293
代码备份（上面打不开的同学看这个）
======

Input
5
8 5
2 1 7 4
4 2
5 4
2 2 5 4
3 3
1 8
0 3 1 6
1 5
8 1
3 0 6 1
5 1
8 10
4 5 7 8
8 5
Output
1.000000000
-1
2.000000000
2.000000000
0.000000000
 */
