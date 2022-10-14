package p1729;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1729D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] x = new int[n];
            int[] y = new int[n];
            for (int j = 0; j < n; j++) {
                x[j] = scanner.nextInt();
            }
            for (int j = 0; j < n; j++) {
                y[j] = scanner.nextInt();
            }
            System.out.println(solve(n, x, y));
        }
    }

    private static String solve(int n, int[] x, int[] y) {
        int[] ySubX = new int[n];
        for (int i = 0; i < n; i++) {
            ySubX[i] = y[i] - x[i];
        }
        Arrays.sort(ySubX);

        int left = 0;
        int right = n - 1;
        int cnt = 0;
        while (left < right) {
            if (ySubX[left] + ySubX[right] >= 0) {
                ySubX[right] -= ySubX[left];
                left++;
                right--;
                cnt++;
            } else {
                left++;
            }
        }
        return String.valueOf(cnt);
    }
}
/*
D. Friends and the Restaurant
https://codeforces.com/contest/1729/problem/D

题目大意：
给定整数 n 和长度为 n 的数组 x,y，其中 x 为花费，y 为预算。每个小组至少有两个朋友，每个小组可以支付账单。要求花费不能高于预算，求最多的分组。

贪心+双指针。令 ySubX[i] = y[i] - x[i]; 排序，尽可以让最有钱朋友和最穷的朋友组成一组，答案即为组数。
======

input
6
6
8 3 9 2 4 5
5 3 1 4 5 10
4
1 2 3 4
1 1 2 2
3
2 3 7
1 3 10
6
2 3 6 9 5 7
3 2 7 10 6 10
6
5 4 2 1 8 100
1 1 1 1 1 200
6
1 4 1 2 4 2
1 3 3 2 3 4

output
2
0
1
3
1
3
 */