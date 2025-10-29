package p2117;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF2117D {
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

        int d = a[1] - a[0];
        for (int i = 2; i < n; i++) {
            if (a[i] - a[i - 1] != d) {
                out.println("NO");
                return;
            }
        }
        int v = a[0] - d;
        if (d < 0) {
            v = a[n - 1] + d;
        }
        if (v >= 0 && v % (n + 1) == 0) {
            out.println("YES");
        } else {
            out.println("NO");
        }
    }
}
/*
D. Retaliation
https://codeforces.com/contest/2117/problem/D

灵茶の试炼 2025-07-14
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(2≤n≤2e5) 和长为 n 的数组 a(1≤a[i]≤1e9)。
a 的下标从 1 开始。
每次操作，你可以：
对于所有 a[i]，执行 a[i] -= i。
或者，对于所有 a[i]，执行 a[i] -= n-i+1。
能否把 a 变成全 0 数组？
输出 YES 或 NO。

rating 1200
从全 0 数组开始倒着想，减法变加法。
核心观察：如果执行了一次操作一和一次操作二，我们会把每个数都增加 n+1。
在此基础上，如果只有操作一或者操作二，我们得到的是个等差数列，知道这个数列的公差 d=a[2]-a[1]，就可以知道额外执行了多少次操作一和操作二。
去掉额外执行的操作，剩余的元素必须非负且是 n+1 的倍数。
代码 https://codeforces.com/contest/2117/submission/328512829
代码备份（Ubuntu Pastebin）
======

Input
6
4
3 6 6 3
5
21 18 15 12 9
10
2 6 10 2 5 5 1 2 4 10
7
10 2 16 12 8 20 4
2
52 101
2
10 2
Output
NO
YES
NO
NO
YES
NO
 */
