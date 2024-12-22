package p1796;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class CF1796D {
    static int n, k, x;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            k = scanner.nextInt();
            x = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        if (x < 0) {
            x = -x;
            k = n - k;
        }

        long ans = 0, pre = 0, pre2 = 0, minS = 0;
        for (int i = 0; i < n; i++) {
            pre += a[i] - x;
            if (i >= k) {
                ans = Math.max(ans, pre - minS + (long) k * x * 2);
                pre2 += a[i - k] - x;
                minS = Math.min(minS, pre2);
            }
        }

        long[] sum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + a[i] + x;
        }
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addLast(0);
        for (int i = 1; i <= n; i++) {
            if (dq.getFirst() < i - k) {
                dq.removeFirst();
            }
            while (!dq.isEmpty() && sum[i] <= sum[dq.getLast()]) {
                dq.removeLast();
            }
            dq.addLast(i);
            ans = Math.max(ans, sum[i] - sum[dq.getFirst()]);
        }
        return String.valueOf(ans);
    }
}
/*
D. Maximum Subarray
https://codeforces.com/contest/1796/problem/D

灵茶の试炼 2024-05-30
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) k(0≤k≤min(20,n)) x(-1e9≤x≤1e9) 和长为 n 的数组 a(-1e9≤a[i]≤1e9)。
你需要把 a 中恰好 k 个数增加 x，其余数减少 x。
该操作必须恰好执行一次。
在最优操作下，a 的最大连续子数组和的最大值是多少？
注意子数组可以是空的，元素和为 0。
进阶：你能做到 O(n) 吗？复杂度和 k 无关。

rating 2000
O(n) 做法。
如果 x<0，那么可以把 x 变成 -x，同时 k 变成 n-k。
下面的讨论满足 x>=0。
为方便计算，先把所有数都减去 x，于是操作变成把 k 个数增加 2x。
分类讨论：
1. 如果子数组长度超过 k，那么子数组内有 k 个数可以增加 2x，总和增加 2kx。我们计算的是长度有下限的最大子数组和。
用前缀和思考，s[right]-s[left] 最大，那么 s[left] 尽量小，且 right-left > k，所以枚举 right 的同时，要维护 s[0] 到 s[right-k-1] 的最小值。
如果你不知道这个做法，可以先看【题解】最大子数组和的前缀和做法
2. 如果子数组长度不超过 k，那么子数组内所有数都可以增加 2x。我们计算的是长度有上限的最大子数组和，这可以用前缀和+单调队列解决。关于单调队列，可以看 【视频】单调队列
总的来说，这题同时考察了最大子数组和的长度下限变体和长度上限变体，是一道不错的综合题目。
https://codeforces.com/contest/1796/submission/263191415
======

Input
4
4 1 2
2 -1 2 3
2 2 3
-1 2
3 0 5
3 2 4
6 2 -8
4 -1 9 -3 7 -8
Output
5
7
0
44
 */
