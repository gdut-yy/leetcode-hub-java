package p1579;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CF1579B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = scanner.nextInt();
            }

            List<String> res = solve(n, a);
            System.out.println(res.size());
            for (String re : res) {
                System.out.println(re);
            }
        }
    }

    private static List<String> solve(int n, int[] a) {
        int[] sorted = a.clone();
        Arrays.sort(sorted);

        List<String> resList = new ArrayList<>();
        // sorted[i]
        for (int i = 0; i < n; i++) {
            // a[j]
            for (int j = i; j < n; j++) {
                if (a[j] == sorted[i]) {
                    if (j != i) {
                        shift(a, i, j, j - i);
                        resList.add((i + 1) + " " + (j + 1) + " " + (j - i));
                    }
                    break;
                }
            }
        }
        return resList;
    }

    private static void shift(int[] a, int l, int r, int d) {
        int len = r - l + 1;
        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = a[l + i];
        }
        for (int i = 0; i < len; i++) {
            a[l + i] = copy[(i + d) % len];
        }
    }
}
/*
B. Shifting Sort
https://codeforces.com/contest/1579/problem/B

题目大意：
给出整数 n 和长度为 n 的数组 a，每次操作可选定 [l,r] 循环左移位，求使数组 a 单调递增的一种方案（不要求最小）

模拟。既然不要求最小，那就中规中矩，每次保证复位 1 个。
======

input
4
2
2 1
3
1 2 1
4
2 4 1 3
5
2 5 1 4 3

output
1
1 2 1
1
1 3 2
3
2 4 1
2 3 1
1 3 2
4
2 4 2
1 5 3
1 2 1
1 3 1
 */