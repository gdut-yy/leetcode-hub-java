package p1857;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1857A {
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
        int sum = Arrays.stream(a).sum();
        if (sum % 2 == 1) {
            return "NO";
        }
        return "YES";
    }
}
/*
Codeforces Round 891 (Div. 3)
A. Array Coloring
https://codeforces.com/contest/1857/problem/A

题目大意：
给定一个由 n 个整数组成的数组。您的任务是确定是否有可能以两种颜色为其所有元素上色，从而使两种颜色的元素的和具有相同的奇偶性，并且每种颜色至少有一个元素上色。
例如，如果数组是[1,2,4,3,2,3,5,4]，我们可以这样给它上色:[1,2,4,3,2,3,5,4]，蓝色元素的和是 6，红色元素的和是 18。
1≤ai≤50

由于a[i] 不为 0，因此判断整个数组的奇偶性即可。
======

input
7
8
1 2 4 3 2 3 5 4
2
4 7
3
3 9 8
2
1 7
5
5 4 3 2 1
4
4 3 4 5
2
50 48
output
YES
NO
YES
YES
NO
YES
YES
 */
