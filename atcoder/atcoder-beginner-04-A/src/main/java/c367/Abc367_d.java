package c367;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Abc367_d {
    static int n, m;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        long sl = 0, sr = 0, ans = 0;
        Map<Long, Integer> cnt = new HashMap<>();
        for (int i = 0; i < n * 2 - 1; i++) {
            sr += a[i % n];
            if (i >= n - 1) {
                ans += cnt.getOrDefault(sr % m, 0);
                sl += a[i - n + 1];
                cnt.merge(sl % m, -1, Integer::sum);
            }
            cnt.merge(sr % m, 1, Integer::sum);
        }
        return String.valueOf(ans);
    }
}
/*
D - Pedometer
https://atcoder.jp/contests/abc367/tasks/abc367_d

灵茶の试炼 2025-05-13
题目大意：
输入 n(2≤n≤2e5) m(1≤m≤1e6) 和长为 n 的数组 a(1≤a[i]≤1e9)。下标从 1 开始。
一个环上有 n 个位置，顺时针编号从 1 到 n。
从 i 顺时针移动到 i+1，需要走 a[i] 步。
特别地，从 n 顺时针移动到 1，需要走 a[n] 步。
输出有多少对位置 (s,t)，满足 s≠t，且从 s 顺时针移动到 t 的最小步数是 m 的倍数。

断环为链，把 a 变成一个长为 2n-1 的数组 b。
问题变成求有 b 中有多少个长度 <= n-1 的非空子数组，其元素和是 m 的倍数。
如果你对此没有任何思路，可以做做我的 数据结构题单 中的 §1.2 前缀和与哈希表
计算 b 的前缀和数组。用哈希表统计前缀和的出现次数。
（下标从 0 开始）枚举在 [n-1,2n-2] 中的 t，计算有多少个符合要求的 s。
如何保证长度 <= n-1？可以在枚举 t 的过程中，从哈希表中删除（出现次数减一）距离 t 太远的 s 的前缀和。（类似定长滑窗）
代码 https://atcoder.jp/contests/abc367/submissions/64678165
======

Input 1
4 3
2 1 4 3
Output 1
4

Input 2
2 1000000
1 1
Output 2
0

Input 3
9 5
9 9 8 2 4 4 3 5 3
Output 3
11
 */
