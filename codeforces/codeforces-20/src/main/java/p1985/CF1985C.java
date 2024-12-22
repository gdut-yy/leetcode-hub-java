package p1985;

import java.util.Scanner;

public class CF1985C {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        long sum = 0;
        int mx = 0, ans = 0;
        for (int v : a) {
            sum += Math.min(v, mx);
            mx = Math.max(v, mx);
            if (sum == mx) ans++;
        }
        return String.valueOf(ans);
    }
}
/*
C. Good Prefixes
https://codeforces.com/contest/1985/problem/C

题目大意：
亚历克斯认为，如果存在某个元素可以表示为所有其他***元素之和（如果没有其他元素，所有其他元素之和为 $0$ ），那么这个数组就是好数组。例如，数组 $[1,6,3,2]$ 是好数组，因为 $1+3+2=6$ 。此外，数组 $[0]$ 也是好数组。然而，数组 $[1,2,3,4]$ 和 $[1]$ 却不是好数组。
亚历克斯有一个数组 $a_1,a_2,\ldots,a_n$ 。帮他计算数组 $a$ 的非空前缀的个数。换句话说，数出有多少个整数 $i$ ( $1 \le i \le n$ )，长度为 $i$ 的前缀（即 $a_1,a_2,\ldots,a_i$ ）是好的。

贪心。
======

Input
7
1
0
1
1
4
1 1 2 0
5
0 1 2 1 4
7
1 1 0 3 5 2 12
7
1000000000 1000000000 1000000000 1000000000 1000000000 1000000000 294967296
10
0 1000000000 1000000000 1000000000 1000000000 1000000000 1000000000 1000000000 1000000000 589934592
Output
1
0
3
3
4
1
2
 */
