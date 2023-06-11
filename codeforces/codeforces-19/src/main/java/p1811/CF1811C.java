package p1811;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1811C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] b = new int[n - 1];
            for (int i = 0; i < n - 1; i++) {
                b[i] = scanner.nextInt();
            }
            System.out.println(solve(n, b));
        }
    }

    private static String solve(int n, int[] b) {
        int[] a = new int[n];
        a[0] = b[0];
        for (int i = 1; i < n - 1; i++) {
            if (b[i - 1] < b[i]) {
                a[i + 1] = b[i];
            } else {
                a[i] = b[i];
            }
        }
        return Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
C. Restore the Array
https://codeforces.com/contest/1811/problem/C

题目大意：
Kristina 有一个长度为 n 的非负整数数组 a。
她建立了一个长度为 n - 1 的新数组 b，使得 bi=max(ai,ai+1)(1≤i≤n - 1)。
例如，假设 Kristina 有一个长度为 5 的数组 a =[3,0,4,0,5]。然后她做了下面的事情:
- 计算 b1 = max (a1, a2) = max (3, 0) = 3;
- 计算 b2 = max (a2, a3) = max (0, 4) = 4;
- 计算 b3 = max (a3, a4) = max (4, 0) = 4;
- 计算 b4 = max (a4, a5) = max(0, 5) = 5。
结果，她得到了一个长度为 4 的数组 b =[3,4,4,5]。
你只知道数组 b。找出克里斯汀娜最初可能拥有的任何匹配数组 a。

constructive algorithms
======

input
11
5
3 4 4 5
4
2 2 1
5
0 0 0 0
6
0 3 4 4 3
2
10
4
3 3 3
5
4 2 5 5
4
3 3 3
4
2 1 0
3
4 4
6
8 1 3 5 10
output
3 0 4 0 5
2 2 1 1
0 0 0 0 0
0 0 3 4 3 3
10 10
3 3 3 1
4 2 2 5 5
3 3 3 3
2 1 0 0
2 4 4
8 1 1 3 5 10
 */
