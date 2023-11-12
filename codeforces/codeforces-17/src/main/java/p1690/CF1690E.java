package p1690;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CF1690E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = scanner.nextInt();
            }
            System.out.println(solve(n, k, a));
        }
    }

    private static String solve(int n, int k, int[] a) {
        long sum = 0L;
        List<Integer> remainList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            remainList.add(a[i] % k);
            sum += a[i] / k;
        }
        Collections.sort(remainList);

        // 双指针
        int left = 0;
        int right = n - 1;
        while (left < right) {
            if (remainList.get(left) + remainList.get(right) >= k) {
                sum++;
                left++;
                right--;
            } else {
                left++;
            }
        }
        return String.valueOf(sum);
    }
}
/*
E. Price Maximization
https://codeforces.com/contest/1690/problem/E

灵茶の试炼 2023-10-10
题目大意：
给定整数 n,k 和长度为 n 的数组 a，n 为偶数，将 a 分为 n/2 组，每组包含 2 个 a，记和为 s，求所有 sum/k 的最大和。

贪心，求余然后双指针组成最小大于等于 k 的组。
======

input
6
6 3
3 2 7 1 4 8
4 3
2 1 5 6
4 12
0 0 0 0
2 1
1 1
6 10
2 0 0 5 9 4
6 5
5 3 8 6 3 2

output
8
4
0
2
1
5
 */