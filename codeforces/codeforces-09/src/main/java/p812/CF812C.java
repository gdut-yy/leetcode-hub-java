package p812;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;

public class CF812C {
    static int n, s;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        s = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        long[] b = new long[n];
        AtomicLong mn = new AtomicLong();
        int ans = sortSearch(n, (k) -> {
            k++;
            for (int i = 0; i < n; i++) {
                b[i] = a[i] + (i + 1L) * k;
            }
            Arrays.sort(b);
            long tot = 0;
            for (int i = 0; i < k; i++) {
                tot += b[i];
            }
            if (tot > s) {
                return true;
            }
            mn.set(tot);
            return false;
        });
        return ans + " " + mn.get();
    }

    // func Search(n int, f func(int) bool) int { ... }
    static int sortSearch(int n, Function<Integer, Boolean> f) {
        int l = 0, r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (f.apply(mid)) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}
/*
C. Sagheer and Nubian Market
https://codeforces.com/contest/812/problem/C

灵茶の试炼 2024-09-24
题目大意：
输入 n(1≤n≤1e5) s(1≤s≤1e9) 和长为 n 的数组 a(1≤a[i]≤1e5)。
有 n 个物品，每个物品至多买一个。假设你买了其中的 k 个，那么对于这 k 个物品，每个物品 a[i] 的花费为 a[i]+i*k 元。
下标从 1 开始。
你有 s 元钱，最多可以买多少个物品？钱不需要恰好花完。
假设你最多买了 k 个，输出 k 以及购买 k 个物品的最小花费。

rating 1500
二分答案 k，计算一个新的数组 b[i] = a[i] + i * k，取 b 的前 k 小元素之和，与 s 比大小。
在二分的过程中，额外记录前 k 小元素之和，这样算出答案后不需要再算一次前 k 小元素之和。
注：C++ 有快速选择，可以做到 O(nlogn) 的复杂度。如果用排序的话就是 O(nlog^2n) 的复杂度。
代码 https://codeforces.com/contest/812/submission/282629248
======

Input
3 11
2 3 5
Output
2 11

Input
4 100
1 2 5 6
Output
4 54

Input
1 7
7
Output
0 0
 */