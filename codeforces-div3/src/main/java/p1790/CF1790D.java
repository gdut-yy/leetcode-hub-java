package p1790;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.TreeMap;

public class CF1790D {
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
        TreeMap<Integer, Integer> cntMap = new TreeMap<>();
        for (int ai : a) {
            cntMap.put(ai, cntMap.getOrDefault(ai, 0) + 1);
        }

        int res = 0;
        while (cntMap.size() > 0) {
            int first = cntMap.firstKey();
            // 连续取
            for (int doll = first; cntMap.containsKey(doll); doll++) {
                int cnt = cntMap.get(doll);
                if (cnt == 1) {
                    cntMap.remove(doll);
                } else {
                    cntMap.put(doll, cnt - 1);
                }
            }
            res++;
        }
        return String.valueOf(res);
    }
}
/*
D. Matryoshkas
https://codeforces.com/contest/1790/problem/D

题目大意：
给定整数 n 和长度为 n 的数组 a。俄罗斯套娃每次+1，求至少有多少套

相似题目: 846. 一手顺子
https://leetcode.cn/problems/hand-of-straights/
======

input
10
6
2 2 3 4 3 1
5
11 8 7 10 9
6
1000000000 1000000000 1000000000 1000000000 1000000000 1000000000
8
1 1 4 4 2 3 2 3
6
1 2 3 2 3 4
7
10 11 11 12 12 13 13
7
8 8 9 9 10 10 11
8
4 14 5 15 6 16 7 17
8
5 15 6 14 8 12 9 11
5
4 2 2 3 4

output
2
1
6
2
2
2
2
2
4
3
 */