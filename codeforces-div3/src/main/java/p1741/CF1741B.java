package p1741;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF1741B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            System.out.println(solve(n));
        }
    }

    private static String solve(int n) {
        if (n == 2) {
            return "2 1";
        } else if (n == 3) {
            return "-1";
        } else {
            List<String> list = new ArrayList<>();
            list.add(String.valueOf(n - 1));
            list.add(String.valueOf(n));
            for (int i = 1; i <= n - 2; i++) {
                list.add(String.valueOf(i));
            }
            return String.join(" ", list);
        }
    }
}
/*
B. Funny Permutation
https://codeforces.com/contest/1741/problem/B

题目大意：
给定整数 n，返回一个排列 p，要求 pi != i 且至少一个相邻的元素(位于pi的左边或右边)必须是 +1 或 -1。
若不存在，返回 -1。

constructive algorithms.
特判 n = 2 和 n = 3 场景，最大数-第二大数-剩余数按升排列即可。
======

input
5
4
3
7
5
2

output
3 4 2 1
-1
6 7 4 5 3 2 1
5 4 1 2 3
2 1
 */