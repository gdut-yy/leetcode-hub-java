package p1831;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1831A {
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
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = n + 1 - a[i];
        }
        return Arrays.stream(b).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
Codeforces Round 875 (Div. 2) https://www.bilibili.com/video/BV1E8411f7Mu/
A. Twin Permutations
https://codeforces.com/contest/1831/problem/A

题目大意：
给你一个长度为 n 的排列 a。
求任意长度为 n 的排列 b，使 a1+b1 ≤ a2+b2 ≤ a3+b3 ≤...≤ an+bn。
可以证明满足上述条件的排列 b 总是存在的。
长度为 n 的排列是由 n 个不同的整数以任意顺序从 1 到 n 组成的数组。例如，[2,3,1,5,4]是一个排列，但[1,2,2]不是一个排列(2 在数组中出现两次)，[1,3,4]也不是一个排列(n=3，但数组中有 4)。

脑筋急转弯
======

input
5
5
1 2 4 5 3
2
1 2
1
1
3
3 2 1
4
1 4 3 2
output
1 2 4 3 5
2 1
1
1 2 3
1 2 3 4
 */

