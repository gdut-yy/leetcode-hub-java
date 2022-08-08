package p1638;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CF1638A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] p = new int[n];
            for (int j = 0; j < n; j++) {
                p[j] = scanner.nextInt();
            }
            System.out.println(solve(n, p));
        }
    }

    private static String solve(int n, int[] p) {
        Map<Integer, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            idxMap.put(p[i], i);
        }

        for (int i = 0; i < n; i++) {
            if (p[i] > i + 1) {
                int left = i;
                int right = idxMap.get(left + 1);
                swap(p, left, right);
                break;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i : p) {
            stringBuilder.append(i).append(" ");
        }
        return stringBuilder.toString().stripTrailing();
    }

    private static void swap(int[] p, int left, int right) {
        int len = right - left + 1;
        for (int i = 0; i < len / 2; i++) {
            int tmp = p[len - 1 - i + left];
            p[len - 1 - i + left] = p[i + left];
            p[i + left] = tmp;
        }
    }
}
/*
Codeforces Round #771 (Div. 2)
A. Reverse
https://codeforces.com/contest/1638/problem/A

题目大意：
给出整数 n 和长度为 n 的序列 p，求翻转子数组 [l,r] 后，使序列 p 的字典序最小。

贪心，左端点为第一个值不等于下标的下标，右端点为左值所在的下标。
======

input
4
1
1
3
2 1 3
4
1 4 2 3
5
1 2 3 4 5

output
1
1 2 3
1 2 4 3
1 2 3 4 5
 */