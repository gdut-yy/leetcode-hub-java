package p2074;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CF2074D {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] xs = new int[n];
        for (int i = 0; i < n; i++) {
            xs[i] = scanner.nextInt();
        }
        Map<Integer, Long> maxY2 = new HashMap<>();
        for (int x : xs) {
            int r = scanner.nextInt();
            for (int i = x - r; i <= x + r; i++) {
                maxY2.merge(i, (long) r * r - (long) (i - x) * (i - x), Long::max);
            }
        }
        long ans = 0;
        for (Long y2 : maxY2.values()) {
            ans += 1 + (long) Math.floor(Math.sqrt(y2)) * 2;
        }
        out.println(ans);
    }
}
/*
D. Counting Points
https://codeforces.com/contest/2074/problem/D

灵茶の试炼 2025-09-09
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 m 之和 ≤2e5。
每组数据输入 n m(1≤n≤m≤2e5)，长为 n 的数组 x(-1e9≤x[i]≤1e9)，长为 n 的数组 r(1≤r[i] 且 sum(r)=m)。
在平面直角坐标系上有 n 个圆，第 i 个圆的圆心在 (x[i],0)，半径为 r[i]。
输出有多少个整点在至少一个圆内或者圆边上。

rating 1400
由于 sum(r) 很小，对于每个圆，遍历这个圆中的 x'，计算对应的 y^2 的最大值 maxY2，也就是用 r^2 - (x-x')^2 更新 maxY2 的最大值。
然后遍历每个在圆中的 x，把 1 + floor(sqrt(maxY2)) * 2 加入答案
代码 https://codeforces.com/contest/2074/submission/336811790
代码备份（上面打不开的同学看这个）
======

Input
4
2 3
0 0
1 2
2 3
0 2
1 2
3 3
0 2 5
1 1 1
4 8
0 5 10 15
2 2 2 2
Output
13
16
14
52

1
1 200000
0
200000
125663704421
 */
