package p1436;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1436C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int pos = scanner.nextInt();
        System.out.println(solve(n, x, pos));
    }

    private static final int MOD = (int) 1e9 + 7;
    private static int lt, gt;

    private static String solve(int n, int x, int pos) {
        // 	sort.Search(n, func(m int) bool {
        //		if m < p {
        //			l++
        //		} else if m > p {
        //			g++
        //		}
        //		return m > p
        //	})
        lt = 0;
        gt = 0;

        int left = 0;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (checkMid(pos, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        int m = n - 1 - lt - gt;
        long res = arrangement(x - 1, lt) * arrangement(n - x, gt) % MOD * arrangement(m, m) % MOD;
        return String.valueOf(res);
    }

    private static boolean checkMid(int pos, int mid) {
        if (mid < pos) {
            lt++;
        } else if (mid > pos) {
            gt++;
        }
        return mid > pos;
    }

    // Arrangement / Permutation 排列 A(n, m) = n! / (n-m)! （n 为下标）
    private static long arrangement(int n, int m) {
        if (m > n) {
            return 0;
        }
        long x = 1L;
        for (int i = 0; i < m; i++) {
            x = x * (n - i) % MOD;
        }
        return x;
    }
}
/*
C. Binary Search
https://codeforces.com/contest/1436/problem/C

灵茶の试炼 2023-04-04
题目大意：
输入 n x(1≤x≤n≤1e3) pos(0≤pos≤n-1)。
输出满足以下条件的数组 a 的个数：
1. a 是一个 1~n 的排列，且 a[pos] = x（下标从 0 开始）
2. 调用 BinarySearch(a, x) 的结果是 true。
答案模 1e9+7。

https://codeforces.com/contest/1436/submission/96620271
要能二分查找到正确的 x，只需要每一步的 a[middle] 和 x 的大小关系是正确的。
因此统计二分中会遇到几次 middle < pos 的和几次 middle > pos 的。
middle < pos 的情况，a[middle] 一定要 <x；
middle > pos 的情况，a[middle] 一定要 >x。
这相当于统计 a 中有几个位置上的数一定比 x 小，有几个位置上的数一定比 x 大（注意 a 是一个排列）。
设有 L 个比 x 小的数，有 g 个比 x 大的数，那么：
需要从 x-1 个数中选出 L 个数，填到这 L 个二分中的位置上，且可以随意排列，即 A(x-1,L) 种方案；
需要从 n-x 个数中选出 g 个数，填到这 g 个二分中的位置上，且可以随意排列，即 A(n-x,g) 种方案；
其余的 n-1-L-g 个数任意排列，即 (n-1-L-g)! 种方案。
这三个方案数相乘，即为答案（乘法原理）。
======

input
4 1 2
output
6

input
123 42 24
output
824071958
 */
