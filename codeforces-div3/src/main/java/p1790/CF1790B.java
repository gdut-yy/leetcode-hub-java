package p1790;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1790B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int s = scanner.nextInt();
            int r = scanner.nextInt();
            System.out.println(solve(n, s, r));
        }
    }

    private static String solve(int n, int s, int r) {
        int max = s - r;
        int[] res = new int[n];
        Arrays.fill(res, r / (n - 1));
        res[n - 1] = max;
        for (int i = 0; i < r % (n - 1); i++) {
            res[i]++;
        }
        return Arrays.stream(res).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
B. Taisia and Dice
https://codeforces.com/contest/1790/problem/B

题目大意：
给定整数 n,s,r。骰子掷了 n 次，点数和为 s，除去最大一个点数，其余点数和为 r，求原序列。

p[n-1] = s - r；其余为 r / (n-1)；余数随机散落
======

input
7
2 2 1
2 4 2
4 9 5
5 17 11
3 15 10
4 4 3
5 20 15

output
1 1
2 2
1 2 2 4
6 4 2 3 2
5 5 5
1 1 1 1
1 4 5 5 5
 */