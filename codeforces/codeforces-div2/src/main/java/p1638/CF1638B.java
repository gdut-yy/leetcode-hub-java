package p1638;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF1638B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = scanner.nextInt();
            }
            System.out.println(solve(n, a));
        }
    }

    private static String solve(int n, int[] a) {
        List<Integer> oddList = new ArrayList<>();
        List<Integer> evenList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (a[i] % 2 == 1) {
                oddList.add(a[i]);
            } else {
                evenList.add(a[i]);
            }
        }
        for (int i = 1; i < oddList.size(); i++) {
            if (oddList.get(i) < oddList.get(i - 1)) {
                return "No";
            }
        }
        for (int i = 1; i < evenList.size(); i++) {
            if (evenList.get(i) < evenList.get(i - 1)) {
                return "No";
            }
        }
        return "Yes";
    }
}
/*
B. Odd Swap Sort
https://codeforces.com/contest/1638/problem/B

题目大意：
给出整数 n 和长度为 n 的数组 a，规定若 a[i] + a[i+1] 和为奇数，可以交换 a[i], a[i+1] 的位置，问若干次操作后，能否使数组 a 单调递增。

观察出规律，奇偶相同的两个数值，无法交换位置，因此问题等价于判断 奇偶 序列，是否有序。
======

input
4
4
1 6 31 14
2
4 2
5
2 9 6 7 10
3
6 6 6

output
Yes
No
No
Yes
 */