package p1362;

import java.util.Scanner;

public class CF1362C {
    static long n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextLong();
            System.out.println(solve());
        }
    }

    // 写法一
    private static String solve() {
        long ans = 0;
        for (; n > 0; n /= 2) {
            ans += n;
        }
        return String.valueOf(ans);
    }

    // 写法二
    private static String solve1() {
        long ans = n * 2 - Long.bitCount(n);
        return String.valueOf(ans);
    }
}
/*
C. Johnny and Another Rating Drop
https://codeforces.com/contest/1362/problem/C

灵茶の试炼 2024-06-11
题目大意：
输入 T(≤1e4) 表示 T 组数据。
每组数据输入 n(1≤n≤1e18)。
定义 popcount(x) 为 x 二进制中的 1 的个数。
输出 popcount(0^1) + popcount(1^2) + popcount(2^3) + ... + popcount((n-1)^n)。
其中 ^ 表示异或。
变形：异或改成【或】怎么做？改成【与】怎么做？

rating 1400
考虑每一位的贡献。
由于任意相邻数字的奇偶性不同，所以 i 和 i-1 的二进制最低位不同，这贡献了 n 个 1。
当且仅当 i 是偶数时，i 和 i-1 的二进制次低位不同，这贡献了 floor(n/2) 个 1。
当且仅当 i 是 4 的倍数（二进制末尾是 00）时，i 和 i-1 的二进制从低到高第三位不同，这贡献了 floor(n/4) 个 1。
依此类推。
所以答案为 n + floor(n/2) + floor(n/4) + ...
考虑到下取整舍去的数字，这也等于 2n - popcount(n)。
写法一 https://codeforces.com/contest/1362/submission/265130910
写法二 https://codeforces.com/problemset/submission/1362/265142699
======

Input
5
5
7
11
1
2000000000000
Output
8
11
19
1
3999999999987
 */
