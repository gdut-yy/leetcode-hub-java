package c295;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Abc295_c {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve(n, a));
    }

    private static String solve(int n, int[] a) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int x : a) {
            cntMap.put(x, cntMap.getOrDefault(x, 0) + 1);
        }

        int res = 0;
        for (int c : cntMap.values()) {
            res += c / 2;
        }
        return String.valueOf(res);
    }
}
/*
C - Socks
https://atcoder.jp/contests/abc295/tasks/abc295_c

题目大意：
你有 N 只袜子。第 i 只袜子的颜色是 i。
您需要尽可能多地执行以下操作。它最多可以表演多少次?
选择两只颜色相同但还没有配对的袜子，把它们配对。

HashMap 统计频次。
======

Input
6
4 1 7 4 1 4
Output
2

Input
1
158260522
Output
0

Input
10
295 2 29 295 29 2 29 295 2 29
Output
4
 */