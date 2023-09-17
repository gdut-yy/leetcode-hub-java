package c318;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Abc318_c {
    static int n, d, p;
    static int[] f;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        d = scanner.nextInt();
        p = scanner.nextInt();
        f = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        Arrays.sort(f);

        long ans = 0;
        for (int i = n - 1; i >= 0; i -= d) {
            long sum = 0;
            for (int j = i; j > i - d && j >= 0; j--) {
                sum += f[j];
            }
            ans += Math.min(p, sum);
        }
        return String.valueOf(ans);
    }
}
/*
C - Blue Spring
https://atcoder.jp/contests/abc318/tasks/abc318_c

题目大意：
高桥正计划一次为期 n 天的火车之旅。
每天，他可以支付常规票价，也可以使用一日通票。
这里，当 1≤i≤N 时，第 i 天的正常票价为 Fi 日元。另一方面，一批 D 日票以 P 日元的价格出售。你可以购买任意数量的通行证，但只能以 D 为单位。
每张购买的通票可以在任何一天使用，在旅行结束时留下一些剩菜也是可以的。
找出 n 天行程的最小可能总成本，即购买一日通票的成本加上一日通票未覆盖的天数的总常规票价。

贪心。
======

Input 1
5 2 10
7 1 6 3 6
Output 1
20

Input 2
3 1 10
1 2 3
Output 2
6

Input 3
8 3 1000000000
1000000000 1000000000 1000000000 1000000000 1000000000 1000000000 1000000000 1000000000
Output 3
3000000000
 */