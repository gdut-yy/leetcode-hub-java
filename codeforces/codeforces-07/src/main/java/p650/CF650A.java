package p650;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CF650A {
    static int n;
    static int[][] xy;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        xy = new int[n][2];
        for (int i = 0; i < n; i++) {
            xy[i][0] = scanner.nextInt();
            xy[i][1] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        Map<Integer, Integer> cx = new HashMap<>();
        Map<Integer, Integer> cy = new HashMap<>();
        Map<Long, Integer> cp = new HashMap<>();
        long ans = 0;
        for (int[] p : xy) {
            int x = p[0], y = p[1];
            long pair = ((long) x << 31) + y;
            ans += cx.getOrDefault(x, 0) + cy.getOrDefault(y, 0) - cp.getOrDefault(pair, 0);
            cx.merge(x, 1, Integer::sum);
            cy.merge(y, 1, Integer::sum);
            cp.merge(pair, 1, Integer::sum);
        }
        return String.valueOf(ans);
    }
}
/*
https://codeforces.com/contest/650/problem/A

灵茶の试炼 2024-03-04
题目大意：
输入 n(1≤n≤2e5) 和平面直角坐标系上的 n 个点，横纵坐标范围 [-1e9,1e9]。
有多少个 (i,j) 满足 i<j 且点 i 到点 j 的曼哈顿距离和欧式距离相等？
注意：可能有重复的点。

rating 1400
点对的横坐标或者纵坐标必须相同。
遍历点的同时，维护相同 x 的点的个数 cx，相同 y 的点的个数 cy，以及同一坐标的点的个数 cp。
对于点 (x,y) 来说，把答案增加 cx+cy-cp，因为同一坐标的点统计了两次。
https://codeforces.com/problemset/submission/650/248176454
======

Input
3
1 1
7 5
1 5
Output
2

Input
6
0 0
0 1
0 2
-1 1
0 1
1 1
Output
11
 */
