package p1669;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CF1669B {
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
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int ai : a) {
            cntMap.put(ai, cntMap.getOrDefault(ai, 0) + 1);
            if (cntMap.get(ai) == 3) {
                return String.valueOf(ai);
            }
        }
        return "-1";
    }
}
/*
B. Triple
https://codeforces.com/contest/1669/problem/B

题目大意：
给定长度为 n 的数组 a，求出现次数最少为 3 次的数，如果没有，返回 -1

HashMap 统计频次即可
======

input
7
1
1
3
2 2 2
7
2 2 3 3 4 2 2
8
1 4 3 4 3 2 4 1
9
1 1 1 2 2 2 3 3 3
5
1 5 2 4 3
4
4 4 4 4

output
-1
2
2
4
3
-1
4
 */