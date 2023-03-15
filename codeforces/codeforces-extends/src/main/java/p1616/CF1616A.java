package p1616;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CF1616A {
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
        for (int i = 0; i < n; i++) {
            int abs = Math.abs(a[i]);
            cntMap.put(abs, cntMap.getOrDefault(abs, 0) + 1);
        }

        int cnt = 0;
        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            if (entry.getKey() != 0 && entry.getValue() > 1) {
                cnt += 2;
            } else {
                cnt += 1;
            }
        }
        return String.valueOf(cnt);
    }
}
/*
Good Bye 2021: 2022 is NEAR
A. Integer Diversity
https://codeforces.com/contest/1616/problem/A

题目大意：
给出整数 n 和长度为 n 的数组，可以将任意元素 x 取反，求不同元素的最大数量是多少

统计每个元素对应的绝对值的频次，正整数均能表示成 x 和 -x 两个不同的元素，求和即可。
======

input
3
4
1 1 2 2
3
1 2 3
2
0 0

output
4
3
1
 */