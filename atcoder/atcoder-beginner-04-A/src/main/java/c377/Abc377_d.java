package c377;

import java.util.Arrays;
import java.util.Scanner;

public class Abc377_d {
    static int n, m;
    static int[][] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = scanner.nextInt();
            a[i][1] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int[] f = new int[m];
        Arrays.fill(f, m);
        for (int[] p : a) {
            int l = p[0], r = p[1];
            f[l - 1] = Math.min(f[l - 1], r - 1);
        }
        long ans = (1L + m) * m / 2;
        int R = m;
        for (int i = m - 1; i >= 0; i--) {
            R = Math.min(R, f[i]);
            ans -= m - R;
        }
        return String.valueOf(ans);
    }
}
/*
D - Many Segments 2
https://atcoder.jp/contests/abc377/tasks/abc377_d

题目大意：
给你两个长度分别为 $N$ 、 $L=(L_1,L_2,\ldots,L_N)$ 和 $R=(R_1,R_2,\ldots,R_N)$ 的正整数序列，以及一个整数 $M$ 。
求满足以下两个条件的整数对 $(l,r)$ 的个数：
- $1\le l \le r \le M$
- 对于每一个 $1\le i\le N$ ，区间 $[l,r]$ 并不完全包含区间 $[L_i,R_i]$ 。

yangjl：正难则反，考虑全部组合个数减去至少包含一个的个数
https://atcoder.jp/contests/abc377/submissions/59167967
======

Input 1
2 4
1 2
3 4
Output 1
5

Input 2
6 5
1 1
2 2
3 3
4 4
5 5
1 5
Output 2
0

Input 3
6 20
8 12
14 20
11 13
5 19
4 11
1 6
Output 3
102
 */
