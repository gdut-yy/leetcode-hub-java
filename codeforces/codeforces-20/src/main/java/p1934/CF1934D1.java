package p1934;

import java.util.Scanner;

public class CF1934D1 {
    static long n, m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextLong();
            m = scanner.nextLong();
            System.out.println(solve());
        }
    }

    private static String solve() {
        if ((n ^ m) < n) {
            return "1\n" + +n + " " + m;
        }
        long hb = 1L << (bitsLen(n) - 1);
        long x = (1L << bitsLen(n ^ hb)) - 1;
        if (x < m) {
            return "-1";
        } else {
            return "2\n" + n + " " + x + " " + m;
        }
    }

    // bits.Len:
    // Len returns the minimum number of bits required to represent x; the result is 0 for x == 0.
    static int bitsLen(long x) {
        return 64 - Long.numberOfLeadingZeros(x);
    }
}
/*
D1. XOR Break — Solo Version
https://codeforces.com/contest/1934/problem/D1

灵茶の试炼 2024-08-01
题目大意：
输入 T(≤1e4) 表示 T 组数据。
每组数据输入 n m(1≤m<n≤1e18)。
你需要把 n 变成 m。
有如下操作，至多执行 63 次：
选择一个数 x，满足 0<x<n 且 0<(n xor x)<n，然后把 n 变成 x 或者变成 n xor x。
如果无法把 n 变成 m，输出 -1。
否则，设操作次数为 k，首先输出 k，然后输出 k+1 个数，第一个数是初始 n，其余 k 个数是每次操作后的 n。
注意：你无需最小化操作次数。

rating 2100
初步分析：
首先，如果 n xor m < n，那么操作一次就可以变成 m。
否则 n xor m > n，那么 n 的最高位是 1，m 的这一位一定是 0。
下面讨论至少操作两次的情况（或者无法操作）。
请你手玩一下（或者打表），操作若干次后，n 可以是哪些数，n 不能是哪些数？什么情况下输出 -1？
例如 n=1000110，那么 n 不能变成 x=0010110 这种，因为 n xor x > n。
一般地，在 n 的最高位和次高位之间的 0，不能在 n 去掉最高位后变成 1。
如果只操作一次，在去掉 n 的最高位（hb）后，可以得到的最大值是多少？
例如 n=1000110 去掉最高位后，从次高位到最低位可以全部变成 1，即 n 变成 x=0000111。
如果 x < m，无解，输出 -1。
否则 x > m，再操作一次就一定可以得到 m。
代码 https://codeforces.com/problemset/submission/1934/273701650
======

Input
3
7 3
4 2
481885160128643072 45035996273704960
Output
1
7 3
-1
3
481885160128643072 337769972052787200 49539595901075456 45035996273704960
 */
