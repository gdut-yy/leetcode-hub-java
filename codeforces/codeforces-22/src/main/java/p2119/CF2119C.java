package p2119;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF2119C {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        long n = scanner.nextLong(), l = scanner.nextLong(), r = scanner.nextLong(), k = scanner.nextLong();
        if (n % 2 > 0) {
            out.println(l);
        } else if (n == 2 || (1L << bitsLen(l)) > r) {
            out.println(-1);
        } else if (k < n - 1) {
            out.println(l);
        } else {
            out.println(1L << bitsLen(l));
        }
    }

    // bits.Len:
    // Len returns the minimum number of bits required to represent x; the result is 0 for x == 0.
    static int bitsLen(long x) {
        return 64 - Long.numberOfLeadingZeros(x);
    }
}
/*
C. A Good Problem
https://codeforces.com/contest/2119/problem/C

灵茶の试炼 2026-04-28
题目大意：
输入 T(≤1e4) 表示 T 组数据。
每组数据输入 n(1≤n≤1e18) L R(1≤L≤R≤1e18) k(1≤k≤n)。
构造一个长为 n 的整数数组 a，满足如下要求：
1. 元素值在 [L, R] 中。
2. AND(a) = XOR(a)，即 a 的所有元素的按位与等于所有元素的异或和。
3. 在满足 1 和 2 的前提下，a 的字典序尽量小。
无解输出 -1，有解输出 a[k]。

rating 1300
如果 n 是奇数，那么 n 个 L 满足要求。
如果 n 是偶数呢？如果某个比特位全是 1，那么 AND = 1 而 XOR = 0，不符合要求。
所以每个比特位至少有一个 0，所以 AND = 0。由于 AND = XOR，所以 XOR 也是 0。
先判断无解的情况。
如果 n = 2，那么只有 a[1] = a[2] 才能让 XOR = 0。但由于 L > 0，所以此时 AND > 0，不满足 AND = 0，无解。
如果 L 和 R 的二进制长度相同，那么最高位的 AND 一定是 1，不满足 AND = 0，无解。
否则，一定有解吗？
整理一下目前的已知条件：
1. n 是偶数且 n >= 4。
2. L 和 R 的二进制长度不同。
由于 n 个 L 的 AND 等于 L，这大于 0，所以这 n 个数不能都相同。
如果只有 a[n] 不是 L，其余数均为 L，那么 XOR = L xor a[n] > 0，不满足 XOR = 0。
所以 a[n-1] 和 a[n] 都不能是 L。如果其余 n-2 个数都是 L，那么其余 n-2 个数的 XOR 等于 0，由于所有数的 XOR 也是 0，那么只能让 a[n-1] = a[n]。
在 L 和 R 的二进制长度不同的情况下，这是有解的，字典序最小的解为 a[n-1] = a[n] = 1 << (L 的二进制长度)，其余 n-2 个数均为 L。
代码 https://codeforces.com/problemset/submission/2119/372189443
代码备份（上面打不开的同学看这个）
======

Input
9
1 4 4 1
3 1 3 3
4 6 9 2
4 6 9 3
4 6 7 4
2 5 5 1
2 3 6 2
999999999999999999 1000000000000000000 1000000000000000000 999999999999999999
1000000000000000000 1 999999999999999999 1000000000000000000
Output
4
1
6
8
-1
-1
-1
1000000000000000000
2
 */
