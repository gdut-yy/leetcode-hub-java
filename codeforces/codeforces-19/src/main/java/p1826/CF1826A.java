package p1826;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1826A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve(n, a));
        }
    }

    private static String solve(int n, int[] a) {
        Arrays.sort(a);

        // x：说谎者的数量
        for (int x = 0; x <= n; x++) {
            int left = 0;
            int right = n;
            while (left < right) {
                int mid = left + (right - left) / 2;
                // 边界二分 F, F,..., F, [T, T,..., T]
                // ----------------------^
                if (a[mid] > x) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            // left 个人真，n-left 个人假
            if (n - left == x) {
                return String.valueOf(x);
            }
        }
        return "-1";
    }
}
/*
Codeforces Round 870 (Div. 2) https://www.bilibili.com/video/BV1aM4y1b7L9/
A. Trust Nobody
https://codeforces.com/contest/1826/problem/A

题目大意：
有一群 n 人。他们中的一些人可能是骗子，他们总是说谎。其他人总是说真话。这个人说:“我们当中至少有几个骗子。”
确定人们所说的是矛盾的，还是可能的。如果可能，输出组中说谎者的数量。如果有多个可能的答案，输出其中任何一个。
---
对于每个测试用例输出一个整数。如果人们所说的是矛盾的，输出 −1。否则，输出组中说谎者的数量。如果有多个可能的答案，输出其中任何一个。

枚举说谎人数 + 二分判断是否成立
======

input
7
2
1 2
2
2 2
2
0 0
1
1
1
0
5
5 5 3 3 5
6
5 3 6 6 3 5
output
1
-1
0
-1
0
3
4
 */