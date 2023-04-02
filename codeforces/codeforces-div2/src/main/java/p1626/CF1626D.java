package p1626;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1626D {
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
        int[] cnt = new int[n + 1];
        for (int i = 0; i < n; i++) {
            cnt[a[i]]++;
        }

        for (int i = 0; i < n; i++) {
            cnt[i + 1] += cnt[i];
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            int c = cnt[i];
            for (int k = 1; k < n * 2; k = k << 1) {
                // j := sort.SearchInts(cnt[:i+1], k+1) - 1
                int j = searchInts(cnt, 0, i + 1, k + 1) - 1;

                int c1 = cnt[j];
                int c2 = c - c1;
                int c3 = cnt[n] - c;
                ans = Math.min(ans, f(c1) + f(c2) + f(c3));
            }
        }
        return String.valueOf(ans);
    }

    // Params:
    // a – the array to be searched
    // fromIndex – the index of the first element (inclusive) to be searched
    // toIndex – the index of the last element (exclusive) to be searched
    // key – the value to be searched for
    private static int searchInts(int[] nums, int fromIndex, int toIndex, int key) {
        int left = 0;
        int right = toIndex - fromIndex;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (nums[fromIndex + mid] >= key) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 返回 x 到 2^k 的距离（其中 x <= 2^k, x > 0）
    private static int f(int x) {
        if (x == 0) {
            return 1;
        }
        return Integer.highestOneBit((x << 1) - 1) - x;
    }
}
/*
D. Martial Arts Tournament
https://codeforces.com/contest/1626/problem/D

灵茶の试炼 2023-03-24
题目大意：
输入 t(≤1e4) 表示 t 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(≤2e5) 和长为 n 的数组 a(1≤a[i]≤n)。
你需要选择两个整数 x y (x<y)，把 a 中小于 x 的数分为一组，大于等于 y 的分为一组，其余的分为一组，一共三组。
对每一组，如果组的大小不是 2 的幂次，则增加到最近的 2 的幂次，花费为增量。比如 5 补齐到 8，花费为 8-5=3。如果已经是 2 的幂次，则花费为 0。
计算花费之和的最小值。

https://codeforces.com/contest/1626/submission/198620816
提示 1：如果只有两个组，要如何快速枚举？
提示 2：假设第一个组的大小可以是 3 5 6 9 10，那么只需要枚举 3 6 10 这些离 2^k 最近的数。
反证法：假设选的不是离 2^k 最近的数（比如不选 6 选 5），第一个组的花费会变大，另外一个组的花费要么同等变小，要么越过了 2^k 变得更大。所以只需要贪心枚举离 2^k 最近的数。
提示 3：统计 cnt，求 cnt 的前缀和，然后枚举第三个组的大小，转换成两个组的问题。然后枚举并在前缀和上二分查找 2^k，作为第一个组的大小。
整数回绕 "wrap around" https://go.dev/ref/spec#Integer_literals
======

input
4
4
3 1 2 1
1
1
6
2 2 2 1 1 1
8
6 3 6 3 6 3 6 6
output
0
2
3
2

1
5
1 1 2 2 3
0
 */
