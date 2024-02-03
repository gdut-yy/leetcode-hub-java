package p962;

import java.util.Scanner;

public class CF962C {
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.next().toCharArray();
        System.out.println(solve());
    }

    private static String solve() {
        int n = s.length;
        int mx = -1;
        for (int i = 1; i < 1 << n; i++) {
            if (s[Integer.numberOfTrailingZeros(i)] == '0') {
                continue;
            }
            int x = 0;
            for (int j = i; j > 0; j &= j - 1) {
                int y = s[Integer.numberOfTrailingZeros(j)] & 15;
                x = x * 10 + y;
            }
            if (isSQ(x)) {
                mx = Math.max(mx, Integer.bitCount(i));
            }
        }
        int ans = mx < 0 ? -1 : n - mx;
        return String.valueOf(ans);
    }

    static boolean isSQ(int x) {
        int sqrt = (int) Math.sqrt(x);
        return sqrt * sqrt == x;
    }
}
/*
C. Make a Square
https://codeforces.com/contest/962/problem/C

灵茶の试炼 2023-12-18
题目大意：
输入 n(1≤n≤2e9)。
每次操作，你可以删除 n 的一个数字。需要保证删除后 n 仍然是一个没有前导零的正整数。
你可以操作任意次。
问：把 n 变成一个完全平方数，至少需要操作几次？
输出操作次数。如果无法做到，输出 -1。

rating 1400
二进制枚举保留哪些数（或者 DFS 选或不选）。注意第一个数不能是 0。
https://codeforces.com/problemset/submission/962/236843853
======

input
8314
output
2

input
625
output
0

input
333
output
-1
 */
