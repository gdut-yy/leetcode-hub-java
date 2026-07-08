package p2085;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF2085C {
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
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        if (x == y) {
            out.println(-1);
        } else {
            out.println((1 << 30) - Math.max(x, y));
        }
    }
}
/*
C. Serval and The Formula
https://codeforces.com/contest/2085/problem/C

灵茶の试炼 2026-02-25
题目大意：
输入 T(≤1e4) 表示 T 组数据。
每组数据输入 x y (1≤x,y≤1e9)。
找到一个在 [0,1e18] 中的整数 k，使得如下等式成立
(x+k) + (y+k) = (x+k) XOR (y+k)
如果无解，输出 -1。
否则输出任意符合要求的 k。

rating 1600
题意相当于 (x+k) AND (y+k) = 0。
如果 x = y，那么 x+k = y+k，所以 (x+k) AND (y+k) = x+k > 0，无解。（注意 x 和 y 均为正整数）
如果 x ≠ y 呢？
不妨设 x > y。
例如
x = 10010
y = 01011
我们可以先把 x 中的 0 都变成 1，即
x = 10010 + 1101 = 11111
y = 01011 + 1101 = 11000
现在，只要再把二者都加一，就可以得到
x = 100000
y = 011001
满足要求。
一般地，当 x > y 时，把 x 增大到 100..0，由于 y 小于 x，所以 y 增大后的二进制长度必然比 100..0 短，所以 AND 结果一定是 0。
对于本题的数据范围，增大到 1<<30 即可，答案为 (1<<30) - max(x, y)。
代码 https://codeforces.com/contest/2085/submission/364143034
代码备份（上面打不开的同学看这个）
======

Input
5
2 5
6 6
19 10
1024 4096
1198372 599188
Output
0
-1
1
1024
28
 */
