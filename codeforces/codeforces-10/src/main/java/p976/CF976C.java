package p976;

import java.util.Arrays;
import java.util.Scanner;

public class CF976C {
    static int n;
    static int[][] a; // l, r, i

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n][3];
        for (int i = 0; i < n; i++) {
            a[i][0] = scanner.nextInt();
            a[i][1] = scanner.nextInt();
            a[i][2] = i;
        }
        System.out.println(solve1());
    }

    // 优化前
    private static String solve() {
        Arrays.sort(a, (o1, o2) -> {
            if (o1[0] == o2[0]) return Integer.compare(o2[1], o1[1]);
            return Integer.compare(o1[0], o2[0]);
        });

        int mxR = 0, mxI = 0;
        for (int[] p : a) {
            if (p[1] <= mxR) {
                return (p[2] + 1) + " " + (mxI + 1);
            }
            // p[1] > mxR
            mxR = p[1];
            mxI = p[2];
        }
        return "-1 -1";
    }

    // 优化后
    private static String solve1() {
        Arrays.sort(a, (o1, o2) -> {
            if (o1[0] == o2[0]) return Integer.compare(o2[1], o1[1]);
            return Integer.compare(o1[0], o2[0]);
        });

        for (int i = 1; i < n; i++) {
            if (a[i][1] <= a[i - 1][1]) {
                return (a[i][2] + 1) + " " + (a[i - 1][2] + 1);
            }
        }
        return "-1 -1";
    }
}
/*
C. Nested Segments
https://codeforces.com/contest/976/problem/C

灵茶の试炼 2024-06-18
题目大意：
输入 n(1≤n≤3e5) 和 n 个闭区间，区间的左右端点在 [1,1e9] 内。
从这 n 个区间中，选出两个区间 [L[i], R[i]] 和 [L[j], R[j]]，
满足 i ≠ j 且 L[j] <= L[i] <= R[i] <= R[j]，也就是区间 j 包含区间 i。
输出 i 和 j（按照输入的顺序，下标从 1 开始）。
如果不存在这样的区间，输出两个 -1。

rating 1500
把区间按照左端点从小到大排序，左端点相同的，按照右端点从大到小排序。
排序后，遍历区间。
对于区间 i，如果区间 i 被区间 j 包含，那么区间 j 一定是我们之前遍历过的区间（因为左端点从小到大排序了）。
所以只要区间 j 的右端点 >= 区间 i 的右端点，那么区间 j 就可以包含区间 i。
那么维护遍历过的区间的右端点的最大值 mxR 即可。
这也说明为什么左端点相同时，要按照右端点从大到小排序。如果有左端点相同的情况，如此排序可以保证先把 mxR 更新成大的，然后遇到右端点小的，找到答案。
代码（优化前） https://codeforces.com/problemset/submission/976/265583528
进一步地，如果没有触发代码中的第一个 if，那么一定会更新 mxR，所以上一个区间的右端点就是 mxR，我们只需要判断当前区间右端点是否 <= 上一个区间的右端点即可。
代码（优化后） https://codeforces.com/contest/976/submission/266254074
======

Input
5
1 10
2 9
3 9
2 3
2 9
Output
2 1

Input
3
1 5
2 6
6 20
Output
-1 -1
 */
