package p1831;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CF1831D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextInt();
            }
            System.out.println(solve(n, a, b));
        }
    }

    // https://codeforces.com/contest/1830/submission/207591556
    private static String solve(int n, int[] a, int[] b) {
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) ids[i] = i;
        Arrays.sort(ids, Comparator.comparingInt(o -> a[o]));

        // 放缩法
        long ans = 0;
        for (int s = 1; s * s <= 2 * n; s++) {
            int[] cnt = new int[n + 1];
            for (Integer id : ids) {
                int ai = a[id], bi = b[id];
                int v = ai * s - bi;
                if (1 <= v && v <= n) {
                    ans += cnt[v];
                }
                if (ai == s) {
                    cnt[bi]++;
                }
            }
        }
        return String.valueOf(ans);
    }
}
/*
D. The BOSS Can Count Pairs
https://codeforces.com/contest/1831/problem/D

题目大意：
给定两个数组 a 和 b，长度都是 n。
你的任务是计算有多少对整数(i,j)满足 1≤i<j≤n 且 ai·aj=bi+bj。

转换 + 枚举
值域放缩法
ai·aj = bi+bj
ai·aj <= 2n
ai·ai <= 2n
ai <= sqrt(2n)
枚举 ai 的值 s
======

input
3
3
2 3 2
3 3 1
8
4 2 8 2 1 2 7 5
3 5 8 8 1 1 6 5
8
4 4 8 8 8 8 8 8
8 8 8 8 8 8 8 8
output
2
7
1
 */
