package p1623;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1623C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] h = new int[n];
            for (int j = 0; j < n; j++) {
                h[j] = scanner.nextInt();
            }
            System.out.println(solve(n, h));
        }
    }

    private static String solve(int n, int[] h) {
        // 二分
        int left = 1;
        int right = 1000000000;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (!checkMid(n, h, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return String.valueOf(left - 1);
    }

    private static boolean checkMid(int n, int[] h, int mid) {
        long[] hLong = new long[n];
        for (int i = 0; i < n; i++) {
            hLong[i] = h[i];
        }
        // 贪心
        for (int i = n - 1; i - 2 >= 0; i--) {
            if (hLong[i] < mid) {
                return false;
            }
            long d = Math.min(h[i], hLong[i] - mid) / 3;
            hLong[i - 2] += d * 2;
            hLong[i - 1] += d;
            hLong[i] -= d * 3;
        }
        return hLong[0] >= mid && hLong[1] >= mid;
    }
}
/*
C. Balanced Stone Heaps
https://codeforces.com/contest/1623/problem/C

灵茶の试炼 2024-04-03
题目大意：
给出整数 n, 以及长度为 n 的数组。规定从 3 ~ n 方向且只能操作一次。每次从第 i 堆石子拿 3d 颗石子，d 颗放到第 i-1 堆，2d 颗放到第 i-2 堆。
问最后组成的数组最小值最大可以是多少。

rating 1600
看起来跟 1619D 一样的套路，可以套用二分。可惜比赛时方向错了，一直从左往右推。
实际上应该采用贪心，从右往左推。但有个陷进，3d 不能超过该堆石子原有的石子数目。
因此 d = min(hi, hi'-target)/3
======

input
4
4
1 2 10 100
4
100 100 100 1
5
5 1 1 1 8
6
1 2 3 4 5 6

output
7
1
1
3
 */