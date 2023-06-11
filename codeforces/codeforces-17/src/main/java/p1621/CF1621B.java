package p1621;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF1621B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] l = new int[n];
            int[] r = new int[n];
            int[] c = new int[n];
            for (int j = 0; j < n; j++) {
                l[j] = scanner.nextInt();
                r[j] = scanner.nextInt();
                c[j] = scanner.nextInt();
            }

            List<String> res = solve(n, l, r, c);
            for (String re : res) {
                System.out.println(re);
            }
        }
    }

    private static List<String> solve(int n, int[] l, int[] r, int[] c) {
        // 三指针
        // left 指向最小花费的最小 l 所在的 idx
        // right 指向最小花费的最大 r 所在的 idx
        // longest 指向最小花费的最长 r-l 所在的 idx
        int left = 0;
        int right = 0;
        int longest = 0;

        List<String> resList = new ArrayList<>();
        resList.add(String.valueOf(c[0]));
        for (int i = 1; i < n; i++) {
            // 更新 left
            if (l[i] < l[left] || (l[i] == l[left] && c[i] < c[left])) {
                left = i;
            }

            // 更新 right
            if (r[i] > r[right] || (r[i] == r[right] && c[i] < c[right])) {
                right = i;
            }

            int maxLen = r[longest] - l[longest];
            // 更新 longest
            if (r[i] - l[i] > maxLen || (r[i] - l[i] == maxLen && c[i] < c[longest])) {
                longest = i;
            }

            // 最左和最右行是同一行还是不同行
            int res = (left == right) ? c[left] : c[left] + c[right];
            // 是否考虑 longest 行
            if (r[right] - l[left] == r[longest] - l[longest]) {
                res = Math.min(res, c[longest]);
            }
            resList.add(String.valueOf(res));
        }
        return resList;
    }
}
/*
B. Integers Shop
https://codeforces.com/contest/1621/problem/B

题目大意：
给出整数 n 和 n 行，第 ni 行给出整数 li,ri,ci，表示 [li,ri] 耗费 ci。求从 1 到 n 行，组成最大区间的最小花费

贪心。顺序遍历，记录当前 最小的 l，最大的  r，以及最长段 r-l 及对应的最小花费。结果可能由 1~2 段组成。
======

input
3
2
2 4 20
7 8 22
2
5 11 42
5 11 42
6
1 4 4
5 8 9
7 8 7
2 10 252
1 11 271
1 10 1

output
20
42
42
42
4
13
11
256
271
271
 */