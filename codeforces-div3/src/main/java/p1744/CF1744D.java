package p1744;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CF1744D {
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
        int cnt2 = 0;
        for (int ai : a) {
            while (ai % 2 == 0) {
                ai /= 2;
                cnt2++;
            }
        }
        // 还需多少个 2
        int need = n - cnt2;
        if (need <= 0) {
            return "0";
        }

        List<Integer> list2 = new ArrayList<>();
        for (int i = 2; i <= n; i += 2) {
            int num = i;
            int cnt = 0;
            while (num % 2 == 0) {
                num /= 2;
                cnt++;
            }
            list2.add(cnt);
        }
        list2.sort(Comparator.reverseOrder());
        for (int i = 0; i < list2.size(); i++) {
            need -= list2.get(i);
            if (need <= 0) {
                return String.valueOf(i + 1);
            }
        }
        return "-1";
    }
}
/*
D. Divisibility by 2^n
https://codeforces.com/contest/1744/problem/D

题目大意：
给定整数 n 和长度为 n 的数组 a。每次操作可以将 ai = ai * i（不能对单个索引重复应用该操作），求使数组中所有元素的乘积能被 2^n 整除所需要的最小操作。

问题等价于：乘积中至少包含 n 个 2。统计因数 2 的个数。缺少的部分，从大到小找补。
======

input
6
1
2
2
3 2
3
10 6 11
4
13 17 1 1
5
1 1 12 1 1
6
20 7 14 18 3 5

output
0
1
1
-1
2
1
 */