package p1619;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CF1619B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            System.out.println(solve(n));
        }
    }

    private static int[] TABLES;

    private static String solve(int n) {
        // 打表
        if (TABLES == null) {
            Set<Integer> hashSet = new HashSet<>();
            // 平方
            for (int i = 1; i <= 31622; i++) {
                hashSet.add(i * i);
            }
            // 立方
            for (int i = 1; i <= 1000; i++) {
                hashSet.add(i * i * i);
            }
            TABLES = hashSet.stream().mapToInt(i -> i).toArray();
            Arrays.sort(TABLES);
        }

        int idx = binarySearchRightBound(TABLES, n);
        return String.valueOf(idx + 1);
    }

    private static int binarySearchRightBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return left - 1;
    }
}
/*
B. Squares and Cubes
https://codeforces.com/contest/1619/problem/B

题目大意：
给出数字 n，问 1 到 n 有多少个平方数和开方数。

打表后二分即可。
31622 * 31622 = 999,950,884 < 10^9
1000 * 1000 * 1000 = 10^9
======

input
6
10
1
25
1000000000
999999999
500000000

output
4
1
6
32591
32590
23125
 */