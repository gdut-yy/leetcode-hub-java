package p1101;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CF1101C {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    record tuple(int l, int r, int i) {
    }

    private static void solve() {
        int n = scanner.nextInt();
        tuple[] a = new tuple[n];
        for (int i = 0; i < n; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            a[i] = new tuple(l, r, i);
        }
        Arrays.sort(a, Comparator.comparingInt(x -> x.l));

        int maxR = a[0].r;
        boolean flag = true;
        for (int i = 1; i < n; i++) {
            if (a[i].l > maxR) {
                // 找到分割点，可以分成两组
                int[] ans = new int[n];
                Arrays.fill(ans, 1);
                for (int j = 0; j < i; j++) {
                    ans[a[j].i] = 2;
                }
                for (int num : ans) {
                    out.print(num + " ");
                }
                out.println();
                flag = false;
                break;
            }
            maxR = Math.max(maxR, a[i].r);
        }
        if(flag) {
            out.println(-1);
        }
    }
}
/*
C. Division and Union
https://codeforces.com/contest/1101/problem/C

灵茶の试炼 2025-09-02
题目大意：
输入 T(≤5e4) 表示 T 组数据。所有数据的 n 之和 ≤1e5。
每组数据输入 n(2≤n≤1e5) 和 n 个闭区间的左右端点，范围 [1,2e5]。
把这 n 个区间分成两个不相交的非空组，即：从两组中各选一个区间，无论怎么选，两个区间一定不相交。
（每组内部的区间是否相交无要求）
输出每个区间分到第 1 组还是第 2 组。
如果无法做到，输出 -1。

rating 1500
合并相交的区间，我们可以得到若干个大区间。每个大区间叫做一组，对应原始输入的若干个小区间。
从每组中选一个小区间，这些小区间互相没有交集。
所以这题不仅可以求划分方案，还可以求出最多分组数。
不妨把第一组内的区间记作 1，其余记作 2。（或者反过来）
如果只有一组，输出 -1。
做法见 LC56. 合并区间
代码 https://codeforces.com/problemset/submission/1101/335102697
代码备份（上面打不开的同学看这个）
======

Input
3
2
5 5
2 3
3
3 5
2 3
2 3
3
3 3
4 4
5 5
Output
2 1
-1
1 1 2
 */
