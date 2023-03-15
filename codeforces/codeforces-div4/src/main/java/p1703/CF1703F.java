package p1703;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CF1703F {
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
        List<Integer> iList = new ArrayList<>();
        List<Integer> ajList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // ai < i
            // aj < j
            if (a[i] < i + 1) {
                iList.add(i + 1);
                ajList.add(a[i]);
            }
        }

        Collections.sort(ajList);
        long sum = 0;
        // 双指针
        int i = 0;
        int j = 0;
        int size = ajList.size();
        while (j < size) {
            while (j < ajList.size() && ajList.get(j) <= iList.get(i)) {
                j++;
            }
            sum += size - j;
            i++;
        }
        return String.valueOf(sum);
    }
}
/*
F. Yet Another Problem About Pairs Satisfying an Inequality
https://codeforces.com/contest/1703/problem/F

题目大意：
给定整数 n 和长度为 n 的数组 a，求 ai < i < aj < j 的索引对。

首先预处理 ai < j，缩小范围，再对每个 i 双指针找符合的 aj
======

input
5
8
1 1 2 3 8 2 1 4
2
1 2
10
0 2 1 6 3 4 1 2 8 3
2
1 1000000000
3
0 1000000000 2

output
3
0
10
0
1
 */