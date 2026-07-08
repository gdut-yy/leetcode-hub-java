package p1665;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF1665D {
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
        int a = 1;
        for (int i = 0; i < 30; i++) {
            out.println("? " + a + " " + (a + (1 << 30)));
            out.flush();
            int g = scanner.nextInt();
            if (g == (1 << i)) {
                a += (1 << i);
            }
        }
        out.println("! " + ((1 << 30) - a));
    }
}
/*
D. GCD Guess
https://codeforces.com/contest/1665/problem/D

灵茶の试炼 2026-04-16
题目大意：
输入 T(≤1e3) 表示 T 组数据。
这是一道交互题。你需要猜测整数 x(1≤x≤1e9) 的值。
你可以执行如下询问至多 30 次：
输出 "? a b"，然后评测机会告诉你 gcd(x+a,x+b) 的值。(1≤a,b≤2e9 且 a≠b)
当你猜出 x 后，输出 "! x"。

rating 2000
提示：如何判断 x 是奇数还是偶数？
gcd(x+a, x+b) = gcd(x+a, b-a)。
如果固定 b-a = 2^30，能否通过调整 a 的值，确定二进制 x 的每一位？
从 a=1 开始，计算 gcd(x+a, 2^30)。
如果 gcd 结果为 1，说明 x+a 是奇数（所以 x 是偶数）。此时把 a 加 1，那么 x+a 变成偶数。如果 gcd 结果大于 1，那么 x+a 是偶数（所以 x 是奇数）。
再次计算 gcd(x+a, 2^30)，如果 gcd 结果为 2，说明 x+a 是 2 的倍数，但不是 4 的倍数，所以 x+a 的二进制是 ...10。此时把 a 加 2，那么 x+a 变成 4 的倍数。
再次计算 gcd(x+a, 2^30)，如果 gcd 结果为 4，说明 x+a 是 4 的倍数，但不是 8 的倍数，所以 x+a 的二进制是 ..100。此时把 a 加 4，那么 x+a 变成 8 的倍数。
最终，我们可以让 x+a 是 2^30 的倍数。
由于 x <= 1e9，这个范围内只有唯一解 x = 2^30 - a。
代码 https://codeforces.com/contest/1665/submission/371191636
代码备份（上面打不开的同学看这个）
======

Input
2

1

8


1
Output

? 1 2

? 12 4

! 4
? 2000000000 1999999999

! 1000000000
 */
