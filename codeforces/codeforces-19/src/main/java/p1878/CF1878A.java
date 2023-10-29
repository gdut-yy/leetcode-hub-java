package p1878;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1878A {
    static int n, k;
    static int[] a;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            k = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        for (int i = 0; i < n; i++) {
            if (a[i] == k) return "YES";
        }
        return "NO";
    }
}
/*
Codeforces Round 900 (Div. 3)
A. How Much Does Daytona Cost?
https://codeforces.com/contest/1878/problem/A

题目大意：
我们定义一个整数为子段上最常见的整数，如果它在该子段上出现的次数大于该子段上任何其他整数的出现次数。数组的子段是数组 A 中元素的连续段。
给定大小为 n 的数组 a 和整数 k，确定是否存在 a 的非空子段，其中 k 是最常见的元素。

脑筋急转弯
======

input
7
5 4
1 4 3 4 1
4 1
2 3 4 4
5 6
43 5 60 4 2
2 5
1 5
4 1
5 3 3 1
1 3
3
5 3
3 4 1 5 5
output
YES
NO
NO
YES
YES
YES
YES
 */
