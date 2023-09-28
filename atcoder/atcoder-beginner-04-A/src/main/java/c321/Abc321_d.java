package c321;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Abc321_d {
    static int n, m, p;
    static int[] a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        m = scanner.nextInt();
        p = scanner.nextInt();
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
        Arrays.sort(b);

        // 前缀和
        long[] preSum = new long[m + 1];
        for (int i = 0; i < m; i++) {
            preSum[i + 1] = preSum[i] + b[i];
        }

        long ans = 0;
        for (int v : a) {
            int j = searchInts(b, p - v);
            long left = preSum[j] + (long) j * v;
            long right = (long) (m - j) * p;
            ans += left + right;
        }
        return String.valueOf(ans);
    }

    private static int searchInts(int[] a, int key) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a[m] >= key) r = m;
            else l = m + 1;
        }
        return l;
    }
}
/*
D - Set Menu
https://atcoder.jp/contests/abc321/tasks/abc321_d

题目大意：
AtCoder 自助餐厅提供 N 道主菜和 M 道小菜。第 i 道主菜的价格是 Ai，第 j 道小菜的价格是 Bj。这家自助餐厅正在考虑推出一种新的套餐。套餐包括一个主菜和一个配菜。设 s 为主菜和配菜的价格之和，则套餐的价格为 min(s,P)。这里，P 是输入中给定的常数。
选择套餐的主菜和配菜的方法有很多。找出所有套餐的总价。

排序 + 前缀和 + 二分
======

Input 1
2 2 7
3 5
6 1
Output 1
24

Input 2
1 3 2
1
1 1 1
Output 2
6

Input 3
7 12 25514963
2436426 24979445 61648772 23690081 33933447 76190629 62703497
11047202 71407775 28894325 31963982 22804784 50968417 30302156 82631932 61735902 80895728 23078537 7723857
Output 3
2115597124
 */
