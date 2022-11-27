package p1760;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1760F {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            long c = scanner.nextLong();
            int d = scanner.nextInt();
            long[] a = new long[n];
            for (int j = 0; j < n; j++) {
                a[j] = scanner.nextInt();
            }
            System.out.println(solve(n, c, d, a));
        }
    }

    private static String solve(int n, long c, int d, long[] a) {
        Arrays.sort(a);
        // 在 d 天内至少能获得 c 个硬币
        if (d * a[n - 1] < c) {
            return "Impossible";
        }
        long sum = 0L;
        for (int i = 0; i < d && i < n; i++) {
            sum += a[n - 1 - i];
        }
        if (sum >= c) {
            return "Infinity";
        }

        int left = 2;
        int right = d + 2;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (!checkMid(n, c, d, a, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return String.valueOf(left - 1 - 1);
    }

    private static boolean checkMid(int n, long c, long d, long[] a, int k) {
        long sum = 0L;
        for (int i = 0; i < k && i < n; i++) {
            sum += a[n - 1 - i];
        }
        sum = sum * (d / k);
        for (int i = 0; i < d % k && i < n; i++) {
            sum += a[n - 1 - i];
        }
        return sum >= c;
    }
}
/*
F. Quests
https://codeforces.com/contest/1760/problem/F

题目大意：
给定整数 n,c,d 和长度为 n 的数组 a。有 n 个任务。如果你完成第 i 个任务，你将获得 ai 金币。你每天最多只能完成一个任务。
然而，一旦你完成了一个任务，你就不能在 k 天内再做同样的任务。求 k 的最大值，使你在 d 天内至少能获得 c 个硬币。
如果不存在这样的 k，则输出 Impossible。如果 k 可以任意大，输出 Infinity。

特判边界条件判断是否输出 Impossible/Infinity.
其余情况，二分找 k 的最大值。
======

input
6
2 5 4
1 2
2 20 10
100 10
3 100 3
7 2 6
4 20 3
4 5 6 7
4 100000000000 2022
8217734 927368 26389746 627896974
2 20 4
5 1

output
2
Infinity
Impossible
1
12
0
 */