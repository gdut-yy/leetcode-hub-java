package p1744;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF1744C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            char c = scanner.next().charAt(0);
            String s = scanner.next();
            System.out.println(solve(n, c, s));
        }
    }

    private static String solve(int n, char c, String s) {
        List<Integer> idxList = new ArrayList<>();
        for (int i = 0; i < n * 2; i++) {
            if (s.charAt(i % n) == 'g') {
                idxList.add(i);
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                int g = binarySearch(idxList, i);
                max = Math.max(max, g - i);
            }
        }
        return String.valueOf(max);
    }

    private static int binarySearch(List<Integer> idxList, int start) {
        int left = 0;
        int right = idxList.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (idxList.get(mid) >= start) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return idxList.get(left);
    }
}
/*
C. Traffic Light
https://codeforces.com/contest/1744/problem/C

题目大意：
给定整数 n 和字符 c（r/y/g 字符），长度为 n 的字符串 s（由 r/y/g 字符组成）。字符串是循环数组。求到下一个 g 的最大距离。

预处理出字符为 g 的所有下标，对于每个等于字符串 c 的下标右侧查找最近一个 g，求所有距离的最大值。
======

input
6
5 r
rggry
1 g
g
3 r
rrg
5 y
yrrgy
7 r
rgrgyrg
9 y
rrrgyyygy

output
3
0
2
4
1
4
 */