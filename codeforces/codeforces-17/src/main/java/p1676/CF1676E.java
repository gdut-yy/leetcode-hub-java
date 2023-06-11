package p1676;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CF1676E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int q = scanner.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = scanner.nextInt();
            }
            int[] x = new int[q];
            for (int j = 0; j < q; j++) {
                x[j] = scanner.nextInt();
            }

            List<String> res = solve(n, q, a, x);
            for (String re : res) {
                System.out.println(re);
            }
        }
    }

    private static List<String> solve(int n, int q, int[] a, int[] x) {
        List<Integer> aList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            aList.add(a[i]);
        }
        aList.sort(Comparator.reverseOrder());
        // 前缀和
        long[] preSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + aList.get(i);
        }

        // 二分
        List<String> res = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            long query = x[i];
            if (preSum[n] < query) {
                res.add("-1");
                continue;
            }
            int left = 0;
            int right = n;
            while (left < right) {
                int mid = left + (right - left) / 2;
                // 边界二分 F, F,..., F, [T, T,..., T]
                // ----------------------^
                if (preSum[mid] >= query) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            res.add(String.valueOf(left));
        }
        return res;
    }
}
/*
E. Eating Queries
https://codeforces.com/contest/1676/problem/E

题目大意：
给定长度为 n 的数组 a，及 q 次查询，求每次查询最少吃多少糖才能达到 q 的糖量。

贪心。将糖（数组 a）由大到小排列。
前缀和+二分。计算前缀和，求最小满足 >= q 的下标 +1。
======

input
3
8 7
4 3 3 1 1 4 5 9
1
10
50
14
15
22
30
4 1
1 2 3 4
3
1 2
5
4
6

output
1
2
-1
2
3
4
8
1
1
-1
 */