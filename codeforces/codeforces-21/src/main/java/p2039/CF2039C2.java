package p2039;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF2039C2 {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int x = scanner.nextInt();
        long m = scanner.nextLong();

        long ans = 0;
        int l = bitsLen(x);
        int mask = (1 << l) - 1;
        for (int y = 1; y <= Math.min(mask, m); y++) {
            if ((x ^ y) % x == 0 || (x ^ y) % y == 0) {
                ans++;
            }
        }
        if (m > mask) {
            for (long k = (m | mask) / x; ; k--) {
                long y = k * x ^ x;
                if (y >> l < m >> l) {
                    ans += k - 1;
                    break;
                }
                if (y <= m) {
                    ans++;
                }
            }
        }
        out.println(ans);
    }

    // bits.Len:
    // Len returns the minimum number of bits required to represent x; the result is 0 for x == 0.
    static int bitsLen(long x) {
        return 64 - Long.numberOfLeadingZeros(x);
    }
}
/*
C2. Shohag Loves XOR (Hard Version)
https://codeforces.com/contest/2039/problem/C2

灵茶の试炼 2025-07-16
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 x 之和 ≤1e7。
每组数据输入 x(1≤x≤1e6) 和 m(1≤m≤1e18)。
输出有多少个在 [1,m] 中的 y，满足 x XOR y 能被 x 或者 y 整除（也可以同时被 x 和 y 整除）。

rating 1800
设 x 的二进制长度为 L。
对于 1 到 min(2^L-1, m) 中的 y，没什么性质，直接暴力枚举。
下面讨论 y >= 2^L 的情况。
此时 x XOR y 的二进制长度和 y 的二进制长度是一样的。如果 x XOR y 能被 y 整除，那么 y 必须 <= (x XOR y) / 2，但此时 y 的二进制长度小于 x XOR y 的二进制长度，矛盾。
所以只能是 x XOR y 被 x 整除。
设 x XOR y = k * x。
两边同时异或 x，得到 y = (k * x) XOR x。
由于 y <= m，那么有 (k * x) XOR x <= m，你能算出 k 的最大值吗？
比如 m = 1001001，x = 110，异或 x 只能改变后三位，所以 y 的前四位必须 <= 1001，换句话说 k * x 最大是 1001111。
令 MASK = (1 << L) - 1。
一般地，我们有 k * x <= m | MASK，解得 k <= (m | MASK) / x（下取整）。
从 k = (m | MASK) / x 开始，倒着枚举 k，判断 y = (k * x) XOR x 是否 <= m。
k 需要枚举多少次呢？
还是用上面的例子，减去两个 x，就能影响 y 的前四位，就能把 y 的前四位变成 < 1001，所以我们至多枚举两次 k（减去两个 x）。
后面更小的 k 一定满足要求，无需枚举。
k 最小是 2（注意 k=1 的时候 y=0，且 k=2 的时候 y >= 2^L），所以当 (y >> L) < (m >> L) 时，把 k-1 加入答案。
注意运算符的优先级，如果你不确定的话，可以多加括号。
代码 https://codeforces.com/contest/2039/submission/328721756
代码备份（Ubuntu Pastebin）
======

Input
5
7 10
2 3
6 4
1 6
4 1
Output
3
2
2
6
1
 */
