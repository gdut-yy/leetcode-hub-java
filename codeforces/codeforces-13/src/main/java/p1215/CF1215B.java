package p1215;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1215B {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        long[] cnt = new long[]{1, 0};
        long ans0 = 0, ans1 = 0;
        int s = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] < 0) {
                s ^= 1;
            }
            ans0 += cnt[s ^ 1];
            ans1 += cnt[s];
            cnt[s]++;
        }
        return ans0 + " " + ans1;
    }
}
/*
B. The Number of Products
https://codeforces.com/contest/1215/problem/B

灵茶の试炼 2023-07-03
题目大意：
输入 n(1≤n≤2e5) 和长为 n 的数组 a(-1e9≤a[i]≤1e9,a[i]≠0)。
输出两个数：
1. 有多少个非空连续子数组，乘积是负数？
2. 有多少个非空连续子数组，乘积是正数？
思考题：如果数组中有 0 要怎么做？如果要数乘积为 0 的子数组个数呢？
思考题：如果改成子序列呢？

https://codeforces.com/problemset/submission/1215/211779994
用前缀和统计前 i 个数中有多少个负数。
由于偶数个负数的乘积是正数，所以只需要看前缀和的奇偶性。
一边计算前缀和 s[i]，一边计算答案：
负数个数 = 与 s[i] 奇偶性不同的前缀和的个数。
正数个数 = 与 s[i] 奇偶性相同的前缀和的个数。
======

input
5
5 -3 3 -1 1
output
8 7

input
10
4 2 -4 3 1 2 -4 3 2 3
output
28 27

input
5
-1 -2 -3 -4 -5
output
9 6
 */
