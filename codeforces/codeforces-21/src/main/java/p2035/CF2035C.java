package p2035;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF2035C {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        if (n % 2 > 0) {
            out.println(n);
            for (int i = 4; i < n - 1; i++) {
                out.print(i + " ");
            }
            out.println("2 1 3 " + (n - 1) + " " + n);
        } else {
            int w = bitsLen(n);
            out.println((1 << w) - 1);
            int hb = 1 << (w - 1);
            for (int i = 2; i <= n; i++) {
                if (i != 5 && (i < hb - 2 || i > hb)) {
                    out.print(i + " ");
                }
            }
            out.println("1 5 " + (hb - 2) + " " + (hb - 1) + " " + hb);
        }
    }

    // bits.Len:
    // Len returns the minimum number of bits required to represent x; the result is 0 for x == 0.
    static int bitsLen(long x) {
        return 64 - Long.numberOfLeadingZeros(x);
    }
}
/*
C. Alya and Permutation
https://codeforces.com/contest/2035/problem/C

灵茶の试炼 2026-01-27
题目大意：
输入 T(≤500) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(5≤n≤2e5)。
请你构造一个 1~n 的排列 p，最大化下式的值
0 & p1 | p2 & p3 | p4 & p5 | p6 & ...
注意式子中的 & 和 | 的优先级是相同的，你只需从左到右计算。
输出两行：
第一行输出上式的最大值。
第二行输出 p。

rating 1400
答案的理论最大值是多少？
注意到，无论前面是什么数，最后 & x，就至多剩下 x 了。
所以只需考虑最后填的几个数。
如果 n 是奇数，最后运算是 | & | &。
由于最后是 &，所以答案的理论最大值是 n。
例如 n = 10111（二进制）。
那么可以构造最后四个数（二进制）为 1 11 10110 10111，这样最终结果为 1 | 10110 = 10111。
一般地，最后四个数为 1 3 n-1 n。其余元素随意。
注意：由于 n 是奇数，所以 n 的最低位一定是 1，且 n-1 和 n 只有最低位不同。
如果 n 是偶数，最后运算是 | & | & |。
设 w 是 n 的二进制长度，答案可以达到理论最大值 2^w - 1。
例如 n = 10111（二进制）。
那么最后五个数（二进制）为 1 101 1110 1111 10000，这样最终结果为 1 | 1110 | 10000 = 11111。
一般地，设最高位 hb = 1<<(w-1)，最后五个数为 1 5 hb-2 hb-1 hb。其余元素随意。
代码 https://codeforces.com/problemset/submission/2035/359679194
代码备份（上面打不开的同学看这个）
======

Input
6
5
6
7
8
9
10
Output
5
2 1 3 4 5
7
1 2 4 6 5 3
7
2 4 5 1 3 6 7
15
2 4 5 1 3 6 7 8
9
2 4 5 6 7 1 3 8 9
15
1 2 3 4 5 6 8 10 9 7
 */
