package p1626;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1626B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            String x = scanner.next();
            System.out.println(solve(x));
        }
    }

    private static String solve(String x) {
        int len = x.length();

        // 预处理
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = x.charAt(i) - '0';
        }

        for (int i = len - 2; i >= 0; i--) {
            int sum = nums[i] + nums[i + 1];
            if (sum >= 10) {
                // case1: 存在长度不减少的方案
                return x.substring(0, i) + sum + x.substring(i + 2);
            }
        }

        // case2: 长度-1
        return nums[0] + nums[1] + x.substring(2);
    }
}
/*
B. Minor Reduction
https://codeforces.com/contest/1626/problem/B

题目大意：
给出一个整数 x，x 不包含前导 0。定义一种简化运算，取两个相邻的数字，并将它们替换为不带前导零的和，求所有简化结果的最大值。

两种情况：长度不变或长度-1
长度不变：选取最后一组，越晚越好
长度变化，选取第一组即可
======

input
2
10057
90

output
10012
9
 */
