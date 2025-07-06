package p2114;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF2114D {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    static int n;
    static pair[] a;

    record pair(int x, int y) {
    }

    public static void main(String[] args) {
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new pair[n];
            for (int i = 0; i < n; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                a[i] = new pair(x, y);
            }
            solve();
        }
        out.flush();
    }

    private static void solve() {
        int xi = 0, xj = 0, yi = 0, yj = 0;
        for (int i = 0; i < n; i++) {
            if (a[i].x < a[xi].x) {
                xi = i;
            }
            if (a[i].x > a[xj].x) {
                xj = i;
            }
            if (a[i].y < a[yi].y) {
                yi = i;
            }
            if (a[i].y > a[yj].y) {
                yj = i;
            }
        }
        if (n == 1) {
            out.println(1);
            return;
        }
        long ans = min(f(xi), f(xj), f(yi), f(yj));
        out.println(ans);
    }

    static long min(long... values) {
        long mixValue = Long.MAX_VALUE;
        for (long i : values) {
            if (i < mixValue) {
                mixValue = i;
            }
        }
        return mixValue;
    }

    static long f(int ban) {
        int minX = (int) 1e9, maxX = 0, minY = (int) 1e9, maxY = 0;
        for (int i = 0; i < n; i++) {
            pair p = a[i];
            if (i == ban) {
                continue;
            }
            minX = Math.min(minX, p.x);
            maxX = Math.max(maxX, p.x);
            minY = Math.min(minY, p.y);
            maxY = Math.max(maxY, p.y);
        }
        long dx = maxX - minX + 1, dy = maxY - minY + 1;
        if (dx * dy > n - 1) {
            return dx * dy;
        }
        return Math.min((dx + 1) * dy, dx * (dy + 1));
    }
}
/*
D. Come a Little Closer
https://codeforces.com/contest/2114/problem/D

灵茶の试炼 2025-06-10
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) 和 n 个点 (xi,yi)，范围 [1,1e9]。
保证 n 个点互不相同。
有一个 1e9*1e9 的矩阵，矩阵中有 n 个怪物，第 i 个怪物在 (xi,yi) 单元格中。
你最多可以把一个怪物移动到另一个没有怪物的单元格中。
输出包含所有怪物的最小子矩形的面积（即子矩形中的单元格个数）。

rating 1400
移动最左/最右/最上/最下的怪物才是有意义的。
枚举这 4 个怪物。
计算围住剩余 n-1 个怪物的矩形长宽。
如果矩形面积 > n-1 那么，答案就是矩形面积。
否则矩形是满的，移动的怪物必须让矩形长加一或者宽加一，计算这两种情况的面积，取最小值。
特判 n=1 的情况，答案是 1。
代码 https://codeforces.com/problemset/submission/2114/322928294
代码备份（洛谷）
======

Input
7
3
1 1
1 2
2 1
5
1 1
2 6
6 4
3 3
8 2
4
1 1
1 1000000000
1000000000 1
1000000000 1000000000
1
1 1
5
1 2
4 2
4 3
3 1
3 2
3
1 1
2 5
2 2
4
4 3
3 1
4 4
1 2
Output
3
32
1000000000000000000
1
6
4
8
 */
