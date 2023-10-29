package p1867;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1867A {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) ids[i] = i;
        Arrays.sort(ids, Comparator.comparingInt(o -> a[o]));

        int[] ans = new int[n];
        int x = n;
        for (Integer id : ids) {
            ans[id] = x--;
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
Codeforces Round 897 (Div. 2)
A. green_gold_dog, array and permutation
https://codeforces.com/contest/1867/problem/A

题目大意：
Green_gold_dog 有一个长度为 n 的数组 a，他想找到一个长度为 n 的排列 b，使数组 a 和排列 b 之间的元素差异中不同的数字的数量最大化。
长度为 n 的排列是由 n 个不同的整数以任意顺序从 1 到 n 组成的数组。例如，[2,3,1,5,4]是一个排列，但[1,2,2]不是一个排列(因为 2 在数组中出现了两次)，[1,3,4]也不是一个排列(因为 n=3，但 4 出现在数组中)。
长度为 n 的两个数组 a 和 b 的元素之差是长度为 n 的数组 c，其中 ci = ai−bi(1≤i≤n)。

贪心，排序即可。
======

input
3
1
100000
2
1 1
3
10 3 3
output
1
2 1
1 3 2
 */
