package p911;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF911D {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int[] a = new int[n];
        int inv = 0;
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            for (int j = 0; j < i; j++) {
                if (a[j] > a[i]) {
                    inv ^= 1;
                }
            }
        }
        int m = scanner.nextInt();
        while (m-- > 0) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int sz = r - l + 1;
            inv ^= sz * (sz - 1) / 2 % 2;
            out.println(inv == 0 ? "even" : "odd");
        }
    }
}
/*
D. Inversion Counting
https://codeforces.com/contest/911/problem/D

灵茶の试炼 2025-09-17
题目大意：
输入 n(1≤n≤1500) 和 1~n 的排列 p。下标从 1 开始。
然后输入 m(1≤m≤2e5) 和 m 个操作。
每个操作输入 L R(1≤L≤R≤n)，表示反转 p 的子数组 [L,R]。
操作是永久的。
输出每次操作后，p 的逆序对个数的奇偶性。
偶数输出 even，奇数输出 odd。

rating 1800
考虑每次操作后，逆序对的个数增加了多少（增量思维）。
设 sz = R-L+1。
设操作前，子数组的逆序对个数为 x。那么操作后的逆序对个数为 sz*(sz-1)/2 - x。
所以逆序对个数增加了 sz*(sz-1)/2 - x*2。
由于 x*2 是偶数，所以增量的奇偶性只与 sz*(sz-1)/2 的奇偶性有关。
如果 sz*(sz-1)/2 是偶数，那么整个排列的逆序对个数的奇偶性不变。
如果 sz*(sz-1)/2 是奇数，那么整个排列的逆序对个数的奇偶性改变。奇数变成偶数，偶数变成奇数。
所以（暴力/归并排序/树状数组）算出原始排列的逆序对个数的奇偶性 inv 后，只需根据每次操作的 sz*(sz-1)/2 的奇偶性修改 inv。
如果 inv 是偶数，输出 even；否则输出 odd。
代码 https://codeforces.com/contest/911/submission/338280571
代码备份（上面打不开的同学看这个）
======

Input
3
1 2 3
2
1 2
2 3
Output
odd
even

Input
4
1 2 4 3
4
1 1
1 4
1 4
2 3
Output
odd
odd
odd
even
 */