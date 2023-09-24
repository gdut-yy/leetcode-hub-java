package p1650;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1650D {
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
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            linkedList.add(a[i]);
        }

        // 模拟
        int[] res = new int[n];
        for (int i = n - 1; i > 0; i--) {
            while (linkedList.get(i) != i + 1) {
                int first = linkedList.removeFirst();
                linkedList.addLast(first);
                res[i]++;
            }
            linkedList.removeLast();
        }

        // int[] => String
        return Arrays.stream(res).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
D. Twist the Permutation
https://codeforces.com/contest/1650/problem/D

题目大意：
首行给定整数 n 和 n 个数的数组 a，第 i 次操作可以选择前 i 个元素循环右移，可以进行若干次。问从 1 到 n 变成目标数组 a 需要的最少操作次数。

贪心，从结果进行反推模拟。
开始1 2 3 4 5 6
1: 1 2 3 4 5 6
2: 2 1 3 4 5 6
3: 3 2 1 4 5 6
4: 4 3 2 1 5 6
4: 1 4 3 2 5 6
6: 6 1 4 3 2 5
6: 5 6 1 4 3 2
6: 2 5 6 1 4 3
6: 3 2 5 6 1 4
======

input
3
6
3 2 5 6 1 4
3
3 1 2
8
5 8 1 3 2 6 4 7

output
0 1 1 2 0 4
0 0 1
0 1 2 0 2 5 6 2
 */