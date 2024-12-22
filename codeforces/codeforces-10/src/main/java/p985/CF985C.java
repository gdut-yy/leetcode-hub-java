package p985;

import java.util.Arrays;
import java.util.Scanner;

public class CF985C {
    static int n, k, l;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        l = scanner.nextInt();
        a = new int[n * k];
        for (int i = 0; i < n * k; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        Arrays.sort(a);

        int i = searchInts(a, a[0] + l + 1);
        if (i < n) {
            return "0";
        }

        int x = 0;
        long ans = 0;
        if (k > 1) {
            x = (i - n + k - 2) / (k - 1);
        }
        for (int j = 0; j <= (x - 1) * k; j += k) {
            ans += a[j];
        }
        for (int j = i - n + x; j < i; j++) {
            ans += a[j];
        }
        return String.valueOf(ans);
    }

    static int searchInts(int[] a, int key) {
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
C. Liebig's Barrels
https://codeforces.com/contest/985/problem/C

灵茶の试炼 2024-06-04
题目大意：
输入 n k(1≤n,k≤1e5 且 1≤n*k≤1e5) L(0≤L≤1e9) 和长为 n*k 的数组 a(1≤a[i]≤1e9)，表示 n*k 条木板的长度。
你要制作 n 个木桶，每个木桶需要 k 条木板。
你可以使用任意 k 条木板来组装一个木桶，每条木板必须恰好属于一个木桶。
一个木桶的体积，等于其最短木板的长度。
要求：任意一对木桶的体积差都不能超过 L。
输出所有木桶体积和的最大值。
如果无法满足，输出 0。

rating 1500
https://www.luogu.com.cn/article/qgs72a7m
======

Input
4 2 1
2 2 1 2 3 2 2 3
Output
7

Input
2 1 0
10 10
Output
20

Input
1 2 1
5 2
Output
2

Input
3 2 1
1 2 3 4 5 6
Output
0
 */
