package p1838;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1838E {
    static int n, m, k;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            k = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static final int MOD = (int) (1e9 + 7);

    // https://codeforces.com/contest/1838/submission/208556018
    private static String solve() {
        long ans = quickPow(k, m);
        long c = 1;
        for (int i = 0; i < n; i++) {
            ans -= c * quickPow(k - 1, m - i) % MOD;
            c = c * (m - i) % MOD * quickPow(i + 1, MOD - 2) % MOD;
        }
        ans = (ans % MOD + MOD) % MOD;
        return String.valueOf(ans);
    }

    // 模下的 a^b
    private static long quickPow(long a, long b) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * a % MOD;
            }
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }
}
/*
E. Count Supersequences
https://codeforces.com/contest/1838/problem/E

题目大意：
给定一个包含 n 个整数的数组 a，其中所有元素都在[1,k]范围内。有多少个包含 m 个整数的数组 b，其中所有元素 bi 都在[1,k]范围内，包含 a 作为子序列?如果两个数组至少有一个位置不同，则认为它们是不同的。
如果 x 可以通过删除几个(可能是零或全部)元素从 y 中获得，则序列 x 是序列 y 的子序列。
因为答案可能很大，所以以 10^9+7 为模打印出来。

正难则反，组合数学
k^m - ∑C(m,i)(k-1)^(m-i) (0<=i<=n-1)
======

input
7
1 1000000 1
1
3 4 3
1 2 2
5 7 8
1 2 3 4 1
6 6 18
18 2 2 5 2 16
1 10 2
1
8 10 1234567
1 1 2 1 2 2 2 1
5 1000000000 1000000000
525785549 816356460 108064697 194447117 725595511
output
1
9
1079
1
1023
906241579
232432822
 */
