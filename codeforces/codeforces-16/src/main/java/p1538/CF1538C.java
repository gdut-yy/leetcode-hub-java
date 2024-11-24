package p1538;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class CF1538C {
    static int n, L, R;
    static int[] a;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            L = scanner.nextInt();
            R = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        return String.valueOf(countFairPairs(a, L, R));
    }

    // 2563
    static long countFairPairs(int[] nums, int lower, int upper) {
        long ans = 0;
        Arrays.sort(nums);
        int left = nums.length;
        int right = nums.length;
        for (int j = 0; j < nums.length; j++) {
            while (right - 1 >= 0 && nums[right - 1] > upper - nums[j]) {
                right--;
            }
            while (left - 1 >= 0 && nums[left - 1] >= lower - nums[j]) {
                left--;
            }
            ans += Math.min(right, j) - Math.min(left, j);
        }
        return ans;
    }
}
/*
C. Number of Pairs
https://codeforces.com/contest/1538/problem/C

灵茶の试炼 2024-04-01
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) L R(1≤L≤R≤1e9) 和长为 n 的数组 a(1≤a[i]≤1e9)。
输出有多少对 (i, j) 满足 i < j 且 L <= a[i] + a[j] <= R。

rating 1300
相似题目: 2563. 统计公平数对的数目
https://leetcode.cn/problems/count-the-number-of-fair-pairs/
======

Input
4
3 4 7
5 1 2
5 5 8
5 1 2 4 3
4 100 1000
1 1 1 1
5 9 13
2 5 5 1 1
Output
2
7
0
1
 */
