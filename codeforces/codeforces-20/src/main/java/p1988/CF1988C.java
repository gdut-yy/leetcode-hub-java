package p1988;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF1988C {
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
        long n = scanner.nextLong();
        if ((n & (n - 1)) == 0) {
            out.println(1);
            out.println(n);
            return;
        }
        out.println(Long.bitCount(n) + 1);
        for (int i = bitsLen(n) - 1; i >= 0; i--) {
            if ((n >> i & 1) > 0) {
                out.print((n ^ (1L << i)) + " ");
            }
        }
        out.println(n);
    }

    // bits.Len:
    // Len returns the minimum number of bits required to represent x; the result is 0 for x == 0.
    static int bitsLen(long x) {
        return 64 - Long.numberOfLeadingZeros(x);
    }
}
/*
C. Increasing Sequence with Fixed OR
https://codeforces.com/contest/1988/problem/C

灵茶の试炼 2026-01-13
题目大意：
输入 T(≤1e3) 表示 T 组数据。
每组数据输入 n(1≤n≤1e18)。
构造一个满足如下要求的整数数组 a：
1. a 严格递增。
2. a[i] 在 [1, n] 中。
3. a[i] OR a[i+1] = n。
你需要最大化 a 的长度。
输出两行：
第一行输出 a 的长度。
第二行输出 a。多解输出任意解。
题目保证，所有测试数据的 a 的长度之和 ≤5e5。

rating 1300
从特殊到一般，先思考 n = 2^k-1，即全 1 数字的情况。例如 n = 111111。
假设其中一个 a[i] = 110111，那么下一个数 a[i+1] 必须满足什么要求？
a[i+1] 必须是 111... 这样才能大于 a[i] 且满足 a[i] OR a[i+1] = n 的要求。
下一个数 a[i+2] 要大于 a[i+1]，为了让序列尽量长，a[i+1] 取 1110.. 最优。
由于 a[i+2] 必须是 1111.. 所以 a[i+1] 末两位都是 1 也是可以的（即 111011），不会让 a 变短。
为了让答案尽量长，一种构造方案如下（以 n = 111111 为例）：
011111
101111
110111
111011
111101
111111
如果 n 不是 2^k-1，由于 a[i] 都是 n 的子集，在构造时跳过 n 中的比特 0 即可。
或者说，从高到低枚举 n 中的 1，改成 0，就得到了答案。
特判 n=2^k 的情况，a 只能是 [n]。
代码 https://codeforces.com/problemset/submission/1988/357205342
代码备份（上面打不开的同学看这个）
======

Input
4
1
3
14
23
Output
1
1
3
1 2 3
4
4 10 12 14
5
7 18 21 22 23
 */
