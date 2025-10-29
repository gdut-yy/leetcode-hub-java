package p2014;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF2014D {
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
        int d = scanner.nextInt();
        int k = scanner.nextInt();
        int[] diff = new int[n + d + 1];
        for (int i = 0; i < k; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            diff[l]++;
            diff[r + d]--;
        }

        int mx = -1, mxI = 0;
        int mn = k + 1, mnI = 0;
        int s = 0;
        for (int i = 1; i <= n; i++) {
            s += diff[i];
            int l = i + 1 - d;
            if (l <= 0) {
                continue;
            }
            if (s > mx) {
                mx = s;
                mxI = l;
            }
            if (s < mn) {
                mn = s;
                mnI = l;
            }
        }
        out.println(mxI + " " + mnI);
    }
}
/*
D. Robert Hood and Mrs Hood
https://codeforces.com/contest/2014/problem/D

灵茶の试炼 2025-08-05
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤1e5) d(1≤d≤n) k(1≤k≤n) 和 k 个闭区间，左右端点范围在 [1,n] 中。
输出两个数：
选一个长为 d 的范围 [i,i+d-1]（左右端点必须是 [1,n] 中的整数），这个范围与尽量多的闭区间有交集（只有一个点也可以），输出满足该要求的最小 i。
选一个长为 d 的范围 [i,i+d-1]（左右端点必须是 [1,n] 中的整数），这个范围与尽量少的闭区间有交集（只有一个点也可以），输出满足该要求的最小 i。
注：最大化/最小化与范围相交的区间个数，而非长度。

rating 1400
对于区间 [L,R]，与区间有交集的范围的右端点可以是 [L,R+d-1]。
用差分数组把这个区间加一。
求差分数组的前缀和，计算最大值和最小值，及其对应的左端点。
注：也可以用定长滑动窗口，和差分是等价的。
代码（差分） https://codeforces.com/problemset/submission/2014/332325155
代码（滑动窗口） https://codeforces.com/problemset/submission/2014/332322020
代码备份（Ubuntu Pastebin）
======

Input
6
2 1 1
1 2
4 1 2
1 2
2 4
7 2 3
1 2
1 3
6 7
5 1 2
1 2
3 5
9 2 1
2 8
9 2 4
7 9
4 8
1 3
2 3
Output
1 1
2 1
1 4
1 1
1 1
3 4
 */