package p1828;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1828C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextInt();
            }
            System.out.println(solve(n, a, b));
        }
    }

    private static final int MOD = (int) (1e9 + 7);

    private static String solve(int n, int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        long ans = 1;
        // 已被选取的数量
        int used = 0;
        for (int i = n - 1; i >= 0; i--) {
            // 比 b[i] 大的数量
            int remain = n - 1 - upperBound(a, b[i]);
            ans *= remain - used;
            ans %= MOD;
            used++;
        }
        return String.valueOf(ans);
    }

    private static int upperBound(int[] nums, int key) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (nums[mid] > key) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }
}
/*
C. Counting Orders
https://codeforces.com/contest/1828/problem/C

题目大意：
给定两个数组 a 和 b，每个数组由 n 个整数组成。a 的所有元素都是两两不同的。
求对所有 1≤i≤n，模 10^9+7，使 a 重排序使 ai>bi 的方法个数。
如果结果数组不同，则认为两种重新排序的方法不同。

排序 + 二分
======

input
5
6
9 6 8 4 5 2
4 1 5 6 3 1
3
4 3 2
3 4 9
1
2
1
3
2 3 4
1 3 3
12
2 3 7 10 23 28 29 50 69 135 420 1000
1 1 2 3 5 8 13 21 34 55 89 144
output
32
0
1
0
13824
 */
