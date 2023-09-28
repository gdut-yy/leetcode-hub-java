package p1873;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1873F {
    static int n, k;
    static int[] a, h;

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
            h = new int[n];
            for (int i = 0; i < n; i++) {
                h[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        int l = 0, r = 0;
        int sum = 0;
        int ans = 0;
        while (r < n) {
            if (r > 0 && h[r - 1] % h[r] != 0) {
                l = r;
                sum = 0;
            }
            sum += a[r];
            while (sum > k) {
                sum -= a[l];
                l++;
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return String.valueOf(ans);
    }
}
/*
F. Money Trees
https://codeforces.com/contest/1873/problem/F

题目大意：
卢卡站在一排 n 棵树的前面。这棵树没有果实，高度很高。
他想要选择数组[hl,hl+1,...,hr]的一个连续子数组，使得对于每一个 i (l≤i<r)， hi 可以被 hi+1 整除。他将收集子数组中每棵树上的所有果实(也就是说，他将收集 al+al+1+...+ar 个果实)。但是，如果他总共收集了超过 k 个水果，他就会被抓住。
卢卡能选择的子数组的最大长度是多少才能不被发现?
如果比值 x/y 是整数，则 x 能被 y 整除。

双指针
======

input
5
5 12
3 2 4 1 8
4 4 2 4 1
4 8
5 4 1 2
6 2 3 1
3 12
7 9 10
2 2 4
1 10
11
1
7 10
2 6 3 1 5 10 6
72 24 24 12 4 4 2
output
3
2
1
0
3

1
4 8
10 3 9 5
1 3 2 3
1
 */
