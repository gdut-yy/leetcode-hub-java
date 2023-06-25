package p1834;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CF1834E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve(n, a));
        }
    }

    // https://codeforces.com/contest/1834/submission/210047142
    private static String solve(int n, int[] a) {
        Set<Long> s = new HashSet<>();
        Set<Long> f = new HashSet<>();
        for (long ai : a) {
            Set<Long> g = new HashSet<>();
            for (Long fi : f) {
                long lcm = getLCM(fi, ai);
                if (lcm < INF) {
                    g.add(lcm);
                    s.add(lcm);
                }
            }
            g.add(ai);
            s.add(ai);
            f = g;
        }
        long x = 1;
        while (s.contains(x)) {
            x++;
        }
        return String.valueOf(x);
    }

    // <= n^2
    private static final long INF = (long) 1e10;

    private static long getLCM(long num1, long num2) {
        return num1 / getGCD(num1, num2) * num2;
    }

    private static long getGCD(long num1, long num2) {
        return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
    }
}
/*
E. MEX of LCM
https://codeforces.com/contest/1834/problem/E

题目大意：
给定一个长度为 n 的数组 a。如果不可能找到数组的子段†使其所有元素的最小公倍数等于 x，则称为正整数 x。
你需要找到最小的好整数。
数组 A 的子段†是元素 al,al+1,...,ar 的集合，对于 1≤l≤r≤n。我们将这样的子段记为[l,r]。

子数组 LCM/GCD/OR/AND 模板：https://leetcode.cn/problems/smallest-subarrays-with-maximum-bitwise-or/solution/by-endlesscheng-zai1/
相似题目：
https://codeforces.com/problemset/problem/891/A
https://codeforces.com/problemset/problem/475/D
https://codeforces.com/problemset/problem/1632/D
相似题目: 2411. 按位或最大的最小子数组长度
https://leetcode.cn/problems/smallest-subarrays-with-maximum-bitwise-or/
======

input
6
3
1 2 3
5
1 2 3 4 5
2
2 3
1
1000000000
12
1 8 4 2 3 5 7 2 9 10 11 13
12
7 2 5 4 2 1 1 2 3 11 8 9
output
4
7
1
1
16
13
 */
