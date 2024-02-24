package p439;

import java.util.Arrays;
import java.util.Scanner;

public class CF439D {
    static int n, m;
    static int[] a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
        Arrays.sort(a);
        Arrays.sort(b);
        int min = a[0], max = b[m - 1];
        if (min >= max) {
            return "0";
        }

        long ans = ternarySearch_u(min, max);
        return String.valueOf(ans);
    }

    private static long ternarySearch_u(int min, int max) {
        long l = min, r = max;
        while (r - l > 2) {
            long m1 = l + (r - l) / 3;
            long m2 = r - (r - l) / 3;
            if (f(m1) > f(m2)) {
                l = m1;
            } else {
                r = m2;
            }
        }
        long res = f(l);
        for (long i = l + 1; i <= r; i++) {
            res = Math.min(res, f(i));
        }
        return res;
    }

    static long f(long tar) {
        long cnt = 0;
        for (int v : a) {
            if (v >= tar) break;
            cnt += tar - v;
        }
        for (int i = m - 1; i >= 0; i--) {
            if (b[i] <= tar) break;
            cnt += b[i] - tar;
        }
        return cnt;
    }
}
/*
D. Devu and his Brother
https://codeforces.com/contest/439/problem/D

灵茶の试炼 2022-05-06
题目大意：
给两个数组 a 和 b，长度均不超过 1e5，元素范围为 [1,1e9]。
每次操作可以使 a 或 b 中的任意元素 +1 或 -1，求使 min(a) >= max(b) 的最小操作次数。

rating 1700
https://codeforces.com/contest/439/submission/124942692
三分 x，然后执行操作使得 min(a)>=x>=max(b) ，可以发现随着 x 的变大，操作次数从大到小再到大
三分的知识见 https://oi-wiki.org/basic/binary/#_10
======

input
2 2
2 3
3 5
output
3

input
3 2
1 2 3
3 4
output
4

input
3 2
4 5 6
1 2
output
0
 */
