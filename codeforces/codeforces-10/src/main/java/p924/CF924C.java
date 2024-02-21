package p924;

import java.util.Scanner;

public class CF924C {
    static int n;
    static int[] m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = new int[n];
        for (int i = 0; i < n; i++) {
            m[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int[] sufMax = new int[n + 1];
        for (int i = n - 1; i > 0; i--) {
            sufMax[i] = Math.max(sufMax[i + 1] - 1, m[i] + 1);
        }

        long ans = 0;
        int mx = 0;
        for (int i = 1; i < n; i++) {
            mx = Math.max(mx, sufMax[i]);
            ans += mx - m[i] - 1;
        }
        return String.valueOf(ans);
    }
}
/*
C. Riverside Curio
https://codeforces.com/contest/924/problem/C

灵茶の试炼 2022-05-05
题目大意：
有一条河，河的水位会在接下来的 n(<=1e5) 天发生变化。（见右图）
记录员每天会在当天水位处画一条线（如果已经有线就不画），并记录在水位上方的线的数目 m[i] (0<=m[i]<i)。
河水不会把线冲刷掉。第 1 天之前没有画线。
令 d[i] 表示第 i 天在水位下方的线的数目。
求 sum(d) 的最小值。

rating 1700
https://codeforces.com/contest/924/submission/156051485
转换成计算 sum(每天至少有多少条线)
思路类似 5 月 4 号题目的方法一，先倒着遍历 m 计算这一天至少有多少条线，然后正着遍历 m，计算这一天至少有多少条线。
注意答案可能会爆 int。
======

input
6
0 1 0 3 0 2
output
6

input
5
0 1 2 1 2
output
1

input
5
0 1 1 2 2
output
0
 */
