package c278;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Abc278_d {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int q = scanner.nextInt();

        int lazy = -1;
        Set<Integer> lazySet = new HashSet<>();
        while (q-- > 0) {
            int op = scanner.nextInt();
            if (op == 1) {
                int x = scanner.nextInt();
                lazy = x;
                lazySet.clear();
//                Arrays.fill(A, x);
            } else if (op == 2) {
                int i = scanner.nextInt() - 1;
                int x = scanner.nextInt();
                if (lazy > -1 && !lazySet.contains(i)) {
                    lazySet.add(i);
                    a[i] = lazy;
                }
                a[i] += x;
            } else {
                int i = scanner.nextInt() - 1;
                if (lazy > -1 && !lazySet.contains(i)) {
                    lazySet.add(i);
                    a[i] = lazy;
                }
                System.out.println(a[i]);
            }
        }
    }
}
/*
D - All Assign Point Add
https://atcoder.jp/contests/abc278/tasks/abc278_d

题目大意：
给定长度为 N 的序列 a =(a1, a2，…，a N)。
给定 Q 个查询，按顺序处理它们。第 q(1≤q≤q)条查询有以下三种格式，分别表示以下查询:
- 1 xq: 将 xq 赋给 A 的每个元素。
- 2 iq xq: 将 xq 加到 Aiq。
- 3 iq: 打印 Aiq 的值。

类似线段树懒标记 下推。
======

Input 1
5
3 1 4 1 5
6
3 2
2 3 4
3 3
1 1
2 3 4
3 3
Output 1
1
8
5

Input 2
1
1000000000
8
2 1 1000000000
2 1 1000000000
2 1 1000000000
2 1 1000000000
2 1 1000000000
2 1 1000000000
2 1 1000000000
3 1
Output 2
8000000000

Input 3
10
1 8 4 15 7 5 7 5 8 0
20
2 7 0
3 7
3 8
1 7
3 3
2 4 4
2 4 9
2 10 5
1 10
2 4 2
1 10
2 3 1
2 8 11
2 3 14
2 1 9
3 8
3 8
3 1
2 6 5
3 7
Output 3
7
5
7
21
21
19
10
 */