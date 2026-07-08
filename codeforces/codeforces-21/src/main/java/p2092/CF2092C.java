package p2092;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF2092C {
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
        long s = 0, mx = 0;
        int c1 = 0;
        for (int i = 0; i < n; i++) {
            long v = scanner.nextLong();
            s += v;
            mx = Math.max(mx, v);
            c1 += (int) (v & 1);
        }
        if (c1 == 0 || c1 == n) {
            out.println(mx);
        } else {
            out.println(s - c1 + 1);
        }
    }
}
/*
C. Asuna and the Mosquitoes
https://codeforces.com/contest/2092/problem/C

灵茶の试炼 2026-03-23
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) 和长为 n 的数组 a(1≤a[i]≤1e9)。
你可以执行如下操作任意次：
选择两个下标 i 和 j (i≠j)，满足 a[i] + a[j] 是奇数，且 a[i] > 0。
然后把 a[i] 减少 1，把 a[j] 增加 1。
输出 max(a) 的最大值。

rating 1200
给你两把解题钥匙：
1. 从特殊到一般，n=2 的时候答案是多少？
2. 操作不会改变什么？「找不变量」是解题的关键。
一增一减，操作不会改变 sum(a)，这是个不变量。
还有别的不变量吗？
a[i] + a[j] 是奇数，意味着两个数的奇偶性一定不同。
把 a 分成偶数集合和奇数集合（或者想象一个二分图），操作相当于：
从偶数集合选一个数，从奇数集合选一个数。操作后，这两个数交换了各自所在集合。
换句话说，偶数个数始终不变，奇数个数始终不变。
只有这两个不变量。
要让 max(a) 尽量大，把元素值聚集在一个数中是最优的。那么答案是 sum(a) 吗？
注意偶数最小是 0，奇数最小是 1，我们还得分配「奇数个数减一」个 1 给其余的奇数。
所以答案为 sum(a) - 奇数个数 + 1。
特判没有偶数或者没有奇数的情况，无法操作，答案为 max(a)。
代码 https://codeforces.com/problemset/submission/2092/367475281
代码备份（上面打不开的同学看这个）
======

Input
4
3
5 3 9
2
3 2
4
1 2 2 1
5
5 4 3 2 9
Output
9
5
5
21
 */
