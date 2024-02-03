package p1730;

import java.util.Scanner;

public class CF1730B {
    static int n;
    static int[] a, t;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            n = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            t = new int[n];
            for (int i = 0; i < n; i++) {
                t[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        double mn = 1e8, mx = 0;
        for (int i = 0; i < n; i++) {
            mn = Math.min(mn, a[i] - t[i]);
            mx = Math.max(mx, a[i] + t[i]);
        }
        double ans = (mn + mx) / 2;
        return String.format("%.1f", ans);
    }
}
/*
B. Meeting on the Line
https://codeforces.com/contest/1730/problem/B

灵茶の试炼 2023-12-20
题目大意：
输入 T(≤1e3) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤1e5) 和长为 n 的数组 x(0≤x[i]≤1e8) 和长为 n 的数组 t(0≤t[i]≤1e8)。
你需要计算一个 x0，使得 t[i] + abs(x[i]-x0) 的最大值最小。
输出 x0。
x0 可以是浮点数。

rating 1600
方法一：二分最短时间
二分时间，可以知道每个人的活动范围。
如果这些范围的交集不为空，那么集合地点可以取交集中任意一点。
在二分的同时，记录交集左端点即可。
https://codeforces.com/contest/1730/submission/236868467
方法二
想一想，所有 t[i] 都为 0，应该选在哪里集合？
我们可以把一个人拆成两个人，分别在 x[i]-t[i] 和 x[i]+t[i]，且这两个人的 t 值均为 0。
那么答案就是这些数的 (最小值+最大值)/2
https://codeforces.com/contest/1730/submission/236875311
======

input
7
1
0
3
2
3 1
0 0
2
1 4
0 0
3
1 2 3
0 0 0
3
1 2 3
4 1 2
3
3 3 3
5 3 3
6
5 4 7 2 10 4
3 2 5 1 4 6
output
0
2
2.5
2
1
3
6
 */
