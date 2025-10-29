package p2057;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF2057C {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int l = scanner.nextInt();
        int r = scanner.nextInt();

        int hb = 1 << (bitsLen(l ^ r) - 1);
        // v := l&r&^(hb-1) | hb
        int v = l & r & (-hb) | hb;
        if (v == r) {
            v--;
        }
        out.println((v - 1) + " " + v + " " + (v + 1));
    }

    // bits.Len:
    // Len returns the minimum number of bits required to represent x; the result is 0 for x == 0.
    static int bitsLen(long x) {
        return 64 - Long.numberOfLeadingZeros(x);
    }
}
/*
C. Trip to the Olympiad
https://codeforces.com/contest/2057/problem/C

灵茶の试炼 2025-07-29
题目大意：
输入 T(≤1e4) 表示 T 组数据。
每组数据输入 L R，范围 0 到 2^30 - 1，且 R-L > 1。
从 [L,R] 中找三个不同的整数 a,b,c，最大化 (a XOR b) + (b XOR c) + (a XOR c)。
输出 a,b,c。多解输出任意解。

rating 1500
O(1) 做法。
从高到低考察。从 L 和 R 不同的那一位，即 L XOR R 的最高位开始。
a,b,c 在这一位有四种情况：
三个 0。
三个 1。
一个 0 两个 1。
两个 0 一个 1。
都是 0 或者都是 1 肯定不优，两数异或为 0。
所以只能是一个 0 两个 1，或者两个 0 一个 1。
比如其中两个数是
1000000
0111111
这样异或和是最大的，且都在范围中。
第三个数随意，为了尽量在范围中，可以是
1000001
或者
0111110。
设 highBit = 1 << (w - 1)，其中 w 为 L XOR R 的二进制长度。
那么 v = (L & R & ~(highBit-1)) | highBit，就是上文的 1000000，加上 L 和 R 在更高位的公共部分。
如果 v == R，那么答案为 v-2, v-1, v。
否则答案为 v-1, v, v+1。
代码 https://codeforces.com/problemset/submission/2057/329708231
代码备份（Ubuntu Pastebin）
======

Input
8
0 2
0 8
1 3
6 22
128 137
69 98
115 127
0 1073741823
Output
1 2 0
8 7 1
2 1 3
7 16 11
134 132 137
98 85 76
123 121 118
965321865 375544086 12551794
 */
