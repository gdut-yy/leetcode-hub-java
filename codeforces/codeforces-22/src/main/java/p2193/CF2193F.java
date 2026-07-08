package p2193;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class CF2193F {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int sx = scanner.nextInt();
        int sy = scanner.nextInt();
        int tx = scanner.nextInt();
        int ty = scanner.nextInt();
        int[][] a = new int[n + 1][2];
        for (int i = 0; i < n; i++) a[i][0] = scanner.nextInt();
        for (int i = 0; i < n; i++) a[i][1] = scanner.nextInt();
        a[n][0] = tx;
        a[n][1] = ty;
        Arrays.sort(a, (p, q) -> p[0] != q[0] ? p[0] - q[0] : p[1] - q[1]);
        long fl = 0, fr = 0;
        int preL = sy, preR = sy;
        int i = 0;
        while (i <= n) {
            int l = a[i][1];
            int j = i;
            while (j <= n && a[j][0] == a[i][0]) j++;
            int r = a[j - 1][1];
            long nfl = Math.min(fl + Math.abs(preL - r), fr + Math.abs(preR - r)) + r - l;
            long nfr = Math.min(fl + Math.abs(preL - l), fr + Math.abs(preR - l)) + r - l;
            fl = nfl;
            fr = nfr;
            preL = l;
            preR = r;
            i = j;
        }
        out.println(tx - sx + Math.min(fl, fr));
    }
}
/*
F. Pizza Delivery
https://codeforces.com/contest/2193/problem/F

灵茶の试炼 2026-03-25
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5)、起点坐标 (sx,sy)、终点坐标 (tx,ty)。范围 [1,1e9]。
然后输入 n 个横坐标。范围 [sx+1,tx-1]。
然后输入 n 个纵坐标。范围 [1,1e9]。
你从起点出发，每一秒只能从 (x,y) 移动到 (x+1,y)、(x,y+1) 或 (x,y−1) 三个点中的任意一个。
你需要访问 n 个坐标点。
访问完后，再移动到终点。
输出最短用时。

rating 1600
由于只能往右，不能回头，所以从左到右，一列一列地思考。
水平移动耗时就是 tx-sx，因为只能往右。
所以下面只需计算垂直方向的移动时间。
每一列，要么从最下面的点移动到最上面的点，要么从最上面的点移动到最下面的点。其他来来回回的走法都是在浪费时间。
定义 f[i][0] 表示从起点移动到第 i 列最下面的点的最短用时，且第 i 列左边的点都访问过了。
定义 f[i][1] 表示从起点移动到第 i 列最上面的点的最短用时，且第 i 列左边的点都访问过了。
考虑 f[i][0] 是从 f[i-1][0] 还是从 f[i-1][1] 转移过来，取最小值：
如果从 f[i-1][0] 到 f[i][0]，那么得先移动到 i 列最上面，再移动到 i 列最下面，垂直方向的移动时间为：
|(i-1 列最下面的点的纵坐标) - (i 列最上面的点的纵坐标)| + (i 列最上面的点的纵坐标 - i 列最下面的点的纵坐标)
其余同理。
可以把终点也单独算一列，简化计算。
代码 https://codeforces.com/contest/2193/submission/367908959
代码备份（上面打不开的同学看这个）
======

Input
4
1 2 3 5 2
4
4
3 1 3 5 2
3 4 3
5 4 1
6 1 2 7 3
5 2 3 5 5 3
6 4 3 1 4 1
5 6 9 8 6
7 7 7 7 7
3 1 8 8 3
Output
6
13
19
15
 */
