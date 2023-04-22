package p1201;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1201C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve(n, k, a));
    }

    private static String solve(int n, int k, int[] a) {
        Arrays.sort(a);
        int offset = n / 2;
        int i = offset + 1;
        for (; i < n; i++) {
            int d = a[i] - a[i - 1];
            if (d == 0) continue;
            if (d > k / (i - offset)) {
                break;
            }
            k -= (i - offset) * d;
        }
        return String.valueOf(a[i - 1] + k / (i - offset));
    }
}
/*
C. Maximum Median
https://codeforces.com/contest/1201/problem/C

灵茶の试炼 2023-04-10
题目大意：
输入 n(1≤n≤2e5 且是奇数) k(1≤k≤1e9) 和长为 n 的数组 a(1≤a[i]≤1e9)。
每次操作你可以把 a 中的一个数加一。
至多操作 k 次。
输出 a 的中位数的最大值。

https://codeforces.com/contest/1201/submission/201600969
首先排序，下标小于 n/2 的都不用变。或者说，中位数至少为 a[n/2]。（注意 n 是奇数）
方法一：二分答案 mid，统计 a[n/2:] 中有多少个小于 mid 的数要变成 mid，比较操作次数与 k。
方法二：贪心，从 a[n/2] 开始增加，如果和后面的数一样就一起加，具体见代码。
======

input
5
4 5 6 0 8
1 2
1 3
1 4
4 5
output
42

input
7
0 2 3 0 0 0 0
1 2
1 3
2 4
2 5
3 6
3 7
output
30
 */
