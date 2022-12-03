package p1759;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class CF1759B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int m = scanner.nextInt();
            int s = scanner.nextInt();
            int[] b = new int[m];
            for (int j = 0; j < m; j++) {
                b[j] = scanner.nextInt();
            }
            System.out.println(solve(m, s, b));
        }
    }

    private static String solve(int m, int s, int[] b) {
        int max = Arrays.stream(b).max().orElseThrow();
        Set<Integer> hashSet = Arrays.stream(b).boxed().collect(Collectors.toSet());
        int i = 1;
        for (; s > 0; i++) {
            if (hashSet.contains(i)) {
                continue;
            }
            s -= i;
            hashSet.add(i);
        }
        return (s == 0 && hashSet.size() >= max) ? "YES" : "NO";
    }
}
/*
B. Lost Permutation
https://codeforces.com/contest/1759/problem/B

题目大意：
给定整数 m 和 s，长度为 m 的数组 b。s 为被遗忘的数字之和。判断是否可以将一个或多个数字追加到给定的序列 b 使所添加的数字之和等于 s，并且得到的新数组是一个排列。

贪心，从小到大枚举。
======

input
5
3 13
3 1 4
1 1
1
3 3
1 4 2
2 1
4 3
5 6
1 2 3 4 5

output
YES
NO
YES
NO
YES
 */
