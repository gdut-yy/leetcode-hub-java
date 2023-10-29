package c125;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc125_d {
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
        int mn = (int) 1e9;
        int neg = 0;
        long sum = 0;
        for (int v : a) {
            if (v < 0) {
                neg ^= 1;
                v = -v;
            }
            sum += v;
            mn = Math.min(mn, v);
        }
        long ans = sum - (long) mn * neg * 2;
        return String.valueOf(ans);
    }
}
/*
D - Flipping Signs
https://atcoder.jp/contests/abc125/tasks/abc125_d

灵茶の试炼 2023-10-02
题目大意：
输入 n(2≤n≤1e5) 和长为 n 的数组 a(-1e9≤a[i]≤1e9)。
你可以执行如下操作任意多次：
选择 a 中两个相邻数字，把它们俩都乘上 -1。
输出 sum(a) 的最大值。
思考：如果只能选择 a[i] 和 a[i+2] 呢？（间隔一个数）
思考：如果至多操作 k 次呢？

操作不会改变负数个数的奇偶性。
如果有偶数个负数（或者存在 0），那么所有数都可以变成非负数。
如果有奇数个负数，并且没有 0，那么最后会剩下一个负数，我们可以让绝对值最小的那个数是负数。
https://atcoder.jp/contests/abc125/submissions/46144732
如果至多操作 k 次，可以用 DP 思考。
======

Input 1
3
-10 5 -4
Output 1
19

Input 2
5
10 -4 -8 -11 3
Output 2
30

Input 3
11
-1000000000 1000000000 -1000000000 1000000000 -1000000000 0 1000000000 -1000000000 1000000000 -1000000000 1000000000
Output 3
10000000000
 */