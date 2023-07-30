package c312;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc312_c {
    static int n, m;
    static int[] a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int left = 0;
        int right = Integer.MAX_VALUE;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return String.valueOf(left);
    }

    private static boolean checkMid(int mid) {
        int sell = 0, buy = 0;
        for (int x : a) {
            if (x <= mid) sell++;
        }
        for (int x : b) {
            if (x >= mid) buy++;
        }
        return sell >= buy;
    }
}
/*
C - Invisible Hand
https://atcoder.jp/contests/abc312/tasks/abc312_c

题目大意：
苹果市场上有 N 个卖家和 M 个买家。
第 i 个卖家可以以 ai 日元或更高的价格出售苹果(日元是日本的货币)。
第 1 个买家可以用 bi 日元或更少的钱买一个苹果。
求满足下列条件的最小整数 X。
条件:可能以 X 日元出售苹果的人数大于或等于可能以 X 日元购买苹果的人数。
---
1 号店和 2 号店的苹果售价为 110 日元;3 号和 4 号两个买家可能会以 110 日元的价格购买一个苹果。因此，110 满足条件。
因为小于 110 的整数不满足条件，所以这就是答案。

二分答案
======

Input 1
3 4
110 90 120
100 80 120 10000
Output 1
110

Input 2
5 2
100000 100000 100000 100000 100000
100 200
Output 2
201

Input 3
3 2
100 100 100
80 120
Output 3
100
 */