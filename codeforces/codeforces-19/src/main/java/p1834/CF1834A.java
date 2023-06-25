package p1834;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1834A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve(n, a));
        }
    }

    private static String solve(int n, int[] a) {
        int neg = 0, pos = 0;
        for (int x : a) {
            if (x > 0) pos++;
            else neg++;
        }
        int ans = 0;
        if (pos < neg) {
            // -1 改 1
            int change = (neg - pos + 1) / 2;
            neg -= change;
            pos += change;
            ans += change;
        }
        // 奇数个 -1
        if (neg % 2 == 1) {
            neg--;
            pos++;
            ans++;
        }
        return String.valueOf(ans);
    }
}
/*
Codeforces Round 879 (Div. 2) https://www.bilibili.com/video/BV1ko4y177qt/
A. Unit Array
https://codeforces.com/contest/1834/problem/A

题目大意：
给定长度为 n 的数组 a，其元素分别为 -1 和 1。如果同时满足以下条件，则称该数组为 good:
a1 + a2 + ... + an ≥ 0;
a1 * a2 * ... * an = 1。
在一个操作中，您可以选择数组 ai 的任意元素并将其值更改为相反的值。换句话说，如果 ai=−1，则可以将该值赋给 ai:=1，如果 ai=1，则将该值赋给 ai:=−1。
确定您需要执行的操作的最小数量，以使数组成为一个好的。可以证明，这总是可能的。

贪心。
======

input
7
4
-1 -1 1 -1
5
-1 -1 -1 1 1
4
-1 1 -1 1
3
-1 -1 -1
5
1 1 1 1 1
1
-1
2
-1 -1
output
1
1
0
3
0
1
2
 */
