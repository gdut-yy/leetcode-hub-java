package c137;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Arc137_b {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int inc = 0, maxInc = 0, dec = 0, maxDec = 0;
        for (int i = 0; i < n; i++) {
            inc = Math.max(inc, 0) + 1 - a[i] * 2;
            maxInc = Math.max(maxInc, inc);
            dec = Math.max(dec, 0) + a[i] * 2 - 1;
            maxDec = Math.max(maxDec, dec);
        }
        return String.valueOf(maxInc + maxDec + 1);
    }
}
/*
B - Count 1's
https://atcoder.jp/contests/arc137/tasks/arc137_b

灵茶の试炼 2023-09-12
题目大意：
输入 n(1≤n≤2e5) 和长为 n 的数组 a(0≤a[i]≤1)。
你需要执行如下操作恰好一次：
选择 a 的一个连续子数组（可以为空），把子数组内的 0 变成 1，1 变成 0。
设新数组为 a'。
问：你可以得到多少个不同的 sum(a')？

提示 1：sum(a') 最大是多少？最小是多少？
提示 2-1：sum(a') 在原来的 sum(a) 的基础上，最多可以增加多少？
提示 2-2：把子数组内的 0 视作 1，1 视作 -1。
最大子数组和就是最大增量 maxInc。
提示 2-3：把子数组内的 0 视作 -1，1 视作 1。
最大子数组和就是最大减少量 maxDec。
注：也可以在提示 2-2 的基础上计算最小子数组和。
提示 3：答案就是 maxInc+maxDec+1。
证明：我们可以在任意子数组的基础上「微调」，也就将子数组的长度加一或者减一。例如把 0 包含入子数组，那么变化量仅会 +1。同理，把 0 移出子数组，那么变化量仅会 -1。对于把 1 包含入/移出子数组的情况同理。
因此可以把变化量从 -maxDec 不断微调到 maxInc，所以变化量可以取到 [-maxDec, maxInc] 中的任意整数，这一共有 maxInc+maxDec+1 个数。
https://atcoder.jp/contests/arc137/submissions/45319475
相似题目: C. Zero Path
https://codeforces.com/contest/1695/problem/C
======

Input 1
4
0 1 1 0
Output 1
4

Input 2
5
0 0 0 0 0
Output 2
6

Input 3
6
0 1 0 1 0 1
Output 3
3
 */