package p2175;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF2175B {
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

    static int l, r;

    static int get(int i) {
        if (i == r) return l - 1;
        return i;
    }

    private static void solve() {
        int n = scanner.nextInt();
        l = scanner.nextInt();
        r = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(get(i) ^ get(i + 1)).append(" ");
        }
        out.println(sb);
    }
}
/*
B. XOR Array
https://codeforces.com/contest/2175/problem/B

灵茶の试炼 2026-05-04
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤5e5。
每组数据输入 n(2≤n≤4e5) L R(1≤L<R≤n)。
构造一个长为 n 的数组 a(1≤a[i]≤1e9)，满足只有子数组 [L,R] 的异或和等于 0，其余非空子数组的异或和均不为 0。

rating 1300
考察 a 的前缀异或和 s，相当于只有 s[r] ^ s[l-1] = 0，即 s[r] = s[l-1]，其余 s[i] 互不相同。
构造 s[i] = i，然后把 s[r] 改成 l-1。
计算 s 的差分，即为 a。
代码 https://codeforces.com/contest/2175/submission/373376610
代码备份（上面打不开的同学看这个）
======

Input
4
3 1 3
4 1 3
8 2 4
4 3 4
Output
9 8 1
2 7 5 4
9 1 9 8 10 5 4 9
85484 130377 6031 6031
 */
