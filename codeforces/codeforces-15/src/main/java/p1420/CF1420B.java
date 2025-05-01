package p1420;

import java.util.Scanner;

public class CF1420B {
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
        long ans = 0;
        int[] cnt = new int[30];
        for (int v : a) {
            int b = bitsLen(v) - 1;
            ans += cnt[b];
            cnt[b]++;
        }
        return String.valueOf(ans);
    }

    // bits.Len:
    // Len returns the minimum number of bits required to represent x; the result is 0 for x == 0.
    static int bitsLen(long x) {
        if (x == 0) return 0;
//        return Long.toBinaryString(x).length();
        return Long.numberOfTrailingZeros(Long.highestOneBit(x)) + 1;
    }
}
/*
B. Rock and Lever
https://codeforces.com/contest/1420/problem/B

灵茶の试炼 2025-03-03
题目大意：
输入 T(≤10) 表示 T 组数据。所有数据的 n 之和 ≤1e5。
每组数据输入 n(1≤n≤1e5) 和长为 n 的数组 a(1≤a[i]≤1e9)。
输出有多少对 (i, j)，满足 i < j 且 (a[i] & a[j]) >= (a[i] ^ a[j])。

rating 1200
考虑 a[i] 和 a[j] 最高的不都为 0 的比特位。
如果都是 1，那么 a[i] & a[j] 严格大于 a[i] ^ a[j]，满足要求。
如果一个是 1 另一个是 0，那么 a[i] & a[j] 严格小于 a[i] ^ a[j]，不满足要求。
所以问题相当于统计和 a[j] 最高位相同的 a[i] 的个数。
用「枚举右维护左」解决。
代码 https://codeforces.com/contest/1420/submission/306944657
代码备份（洛谷）
======

Input
5
5
1 4 3 7 10
3
1 1 1
4
6 2 5 3
2
2 4
1
1
Output
1
3
2
0
0
 */
