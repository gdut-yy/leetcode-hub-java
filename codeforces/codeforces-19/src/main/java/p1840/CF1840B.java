package p1840;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1840B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            System.out.println(solve(n, k));
        }
    }

    private static String solve(int n, int k) {
        // min(n+1, 2^k)
        int ans = k <= 30 ? Math.min(n + 1, (int) Math.pow(2, k)) : n + 1;
        return String.valueOf(ans);
    }
}
/*
B. Binary Cafe
https://codeforces.com/contest/1840/problem/B

题目大意：
很久以前，托马发现自己在一家二元咖啡厅里。这是一个非常受欢迎和不寻常的地方。
这家咖啡馆为游客提供各种美味的甜点。甜品的编号从 0 到 k−1。第 i 个甜点的成本是 2i 个硬币，因为它是一个二元咖啡厅!托马不愿意花超过 n 个硬币来品尝甜点。与此同时，他对任何甜点都不感兴趣，因为一次就足够评价它的味道了。
他可以用多少种不同的方式买到几种甜点(可能没有)来品尝?

数学
======

input
5
1 2
2 1
2 2
10 2
179 100
output
2
2
3
4
180
 */
