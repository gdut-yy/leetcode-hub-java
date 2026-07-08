package p1941;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF1941E {
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
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int d = scanner.nextInt();
        long[] rowRes = new long[n];
        long ans = (long) 1e18, s = 0;
        for (int i = 0; i < n; i++) {
            long v = scanner.nextLong();
            int[] qj = new int[m];
            long[] qf = new long[m];
            int head = 0, tail = 0;
            qj[tail] = 0;
            qf[tail] = 1;
            tail++;
            long f = 0;
            for (int j = 1; j < m; j++) {
                v = scanner.nextLong();
                while (head < tail && qj[head] < j - d - 1) head++;
                f = qf[head] + v + 1;
                while (head < tail && f <= qf[tail - 1]) tail--;
                qj[tail] = j;
                qf[tail] = f;
                tail++;
            }
            rowRes[i] = f;
            s += f;
            if (i >= k - 1) {
                ans = Math.min(ans, s);
                s -= rowRes[i - k + 1];
            }
        }
        out.println(ans);
    }
}
/*
E. Rudolf and k Bridges
https://codeforces.com/contest/1941/problem/E

灵茶の试炼 2026-03-18
题目大意：
输入 T(≤1e3) 表示 T 组数据。所有数据的 n*m 之和 ≤2e5。
每组数据输入 n(1≤n≤100) m(3≤m≤2e5) k(1≤k≤n) d(1≤d≤m) 和 n 行 m 列的网格图 a，元素范围 [0,1e6]。
保证每行第一个数和最后一个数都是 0。
a 表示一片区域的水深。
如果要在 i 行建造一座桥，规则如下：
1. 选择这一行的某些位置，安装桥墩。在水深为 h 的位置安装桥墩，费用为 h+1。
2. 必须在 a[i][0] 和 a[i][m-1] 安装桥墩。
3. 这一行的任意一对相邻桥墩，下标（列号）之差必须 <= d+1。
一座桥的费用是所有桥墩的费用之和。
在连续 k 行上各建造一座桥（每座桥互相独立），最小总费用是多少？

rating 1600
每行独立计算。
相当于从 row 中选一个满足题目要求的子序列，和（每个元素加一）最小。
考虑 DP，定义 f[j] 表示子序列最后一个数是 row[j] 的情况下的最小和。
转移来源下标范围是 [j-d-1, j-1]。
这是一个滑动窗口最小值问题。用单调队列解决。
初始值 f[0] = 0，答案为 f[m-1]。
连续 k 行的最小和，用定长滑动窗口解决。
代码 https://codeforces.com/contest/1941/submission/367043407
代码备份（上面打不开的同学看这个）
======

Input
5
3 11 1 4
0 1 2 3 4 5 4 3 2 1 0
0 1 2 3 2 1 2 3 3 2 0
0 1 2 3 5 5 5 5 5 2 0
4 4 2 1
0 3 3 0
0 2 1 0
0 1 2 0
0 3 3 0
4 5 2 5
0 1 1 1 0
0 2 2 2 0
0 2 1 1 0
0 3 2 1 0
1 8 1 1
0 10 4 8 4 4 2 0
4 5 3 2
0 8 4 4 0
0 3 4 8 0
0 8 1 10 0
0 10 1 5 0
Output
4
8
4
15
14
 */
