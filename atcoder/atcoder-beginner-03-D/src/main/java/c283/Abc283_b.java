package c283;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc283_b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int q = scanner.nextInt();
        while (q-- > 0) {
            int op = scanner.nextInt();
            if (op == 1) {
                int k = scanner.nextInt();
                int x = scanner.nextInt();
                a[k - 1] = x;
            } else {
                int k = scanner.nextInt();
                System.out.println(a[k - 1]);
            }
        }
    }
}
/*
B - First Query Problem
https://atcoder.jp/contests/abc283/tasks/abc283_b

题目大意：
给定一个整数 N 和长度为 N 的序列 a =(a 1, a 2，…，a N)，给定 Q 个查询，按给定顺序处理它们。每个查询都是以下两种查询中的一种:
1 k x: 设置 Ak 为 x。
2 k: 打印数值 Ak。

模拟。
======

Input 1
3
1 3 5
7
2 2
2 3
1 3 0
2 3
1 2 8
2 2
2 1
Output 1
3
5
0
8
1

Input 2
5
22 2 16 7 30
10
1 4 0
1 5 0
2 2
2 3
2 4
2 5
1 4 100
1 5 100
2 3
2 4
Output 2
2
16
0
0
16
100

Input 3
7
478 369 466 343 541 42 165
20
2 1
1 7 729
1 6 61
1 6 838
1 3 319
1 4 317
2 4
1 1 673
1 3 176
1 5 250
1 1 468
2 6
1 7 478
1 5 595
2 6
1 6 599
1 6 505
2 3
2 5
2 1
Output 3
478
317
838
838
176
595
468
 */