package p1771;

import java.util.Scanner;

public class CF1771B {
    static int n, m;
    static int[][] xy;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            xy = new int[m][2];
            for (int i = 0; i < m; i++) {
                xy[i][0] = scanner.nextInt();
                xy[i][1] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        int[] L = new int[n + 1];
        for (int[] p : xy) {
            int x = Math.min(p[0], p[1]);
            int y = Math.max(p[0], p[1]);
            L[y] = Math.max(L[y], x);
        }

        long ans = 0, maxL = 0;
        for (int i = 0; i < n + 1; i++) {
            maxL = Math.max(maxL, L[i]);
            ans += i - maxL;
        }
        return String.valueOf(ans);
    }
}
/*
B. Hossam and Friends
https://codeforces.com/contest/1771/problem/B

灵茶の试炼 2024-02-06
题目大意：
输入 T(≤2e4) 表示 T 组数据。所有数据的 n 之和 ≤1e5。
每组数据输入 n(2≤n≤1e5) m(0≤m≤1e5) 和 m 对数字 (xi,yi)，范围 [1,n] 且 xi≠yi。
有 n 个人，编号从 1 到 n。
输入的 m 对数字表示 xi 和 yi 互相不认识。
不在这 m 对数字中的任何数对，都互相是朋友关系。
注：从图论角度来说，就是一个 m 条边的无向图的补图上的边，都表示朋友关系。
问：序列 [1,2,...,n] 有多少个非空连续子数组 b，满足 b 中的人两两都是朋友？
注意长度为 1 的 b 一定符合要求。

rating 1400
不妨设 x < y（如果 x > y 则交换 x 和 y）。
对于每个 (x,y) 中的 y，记录 x 的最大值，记到列表 L[y] 中。
从 1 到 n 枚举 i，维护 L[i] 的最大值 maxL。
那么从 maxL+1 到 i 两两都是朋友，换句话说，当子数组右端点为 i 时，子数组左端点的范围为 [maxL+1,i]，这有 i-maxL 个，加到答案中。
https://codeforces.com/contest/1771/submission/244275529
======

input
2
3 2
1 3
2 3
4 2
1 2
2 3
output
4
5
 */
