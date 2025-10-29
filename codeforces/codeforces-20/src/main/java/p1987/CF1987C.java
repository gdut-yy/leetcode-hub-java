package p1987;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF1987C {
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
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        for (int i = n - 2; i >= 0; i--) {
            a[i] = Math.max(a[i], a[i + 1] + 1);
        }
        out.println(a[0]);
    }
}
/*
C. Basil's Garden
https://codeforces.com/contest/1987/problem/C

灵茶の试炼 2025-07-28
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤1e5。
每组数据输入 n(1≤n≤1e5) 和长为 n 的数组 a(1≤a[i]≤1e9)。
下标从 0 开始。
每一秒，我们从左到右遍历数组 a，遍历到 a[i] 时，如果 i=n-1 或者 a[i]>a[i+1]，那么把 a[i] 变成 max(a[i]-1, 0)。
把所有 a[i] 都变成 0，需要多少秒？（或者说需要遍历 a 多少次）

rating 1200
下标从 0 开始。
a[n-1] 每秒都会减一。
想一想，倒数第二个数 a[n-2] 什么时候变成 0？
如果 a[n-2] > a[n-1]，那么 a[n-2] 也每秒减一。
如果 a[n-2] <= a[n-1]，那么必须先等待 a[n-1] 变成 a[n-2]-1，然后才能 a[n-2] 和 a[n-1] 都减一。
所以 a[n-2] 变成 0 需要 max(a[n-2],a[n-1]+1) 秒。
一般地，用 a[i] = max(a[i], a[i+1]+1) 倒着递推，答案为 a[0]。
代码 https://codeforces.com/contest/1987/submission/327718206
代码备份（Ubuntu Pastebin）
======

Input
4
3
1 1 2
2
3 1
1
9
5
7 4 4 3 2
Output
4
3
9
7
 */
