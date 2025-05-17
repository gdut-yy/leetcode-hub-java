package c347;

import java.util.Scanner;

public class Abc347_d {
    static long a, b, xor;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextLong();
        b = scanner.nextLong();
        xor = scanner.nextLong();
        System.out.println(solve());
    }

    private static String solve() {
        long x = 0, y = 0, lb;
        for (long t = xor; t > 0; t ^= lb) {
            lb = t & -t;
            if (a > b) {
                x |= lb;
                a--;
            } else {
                y |= lb;
                b--;
            }
        }
        if (a < 0 || a != b) {
            return "-1";
        }

        for (long t = ((1L << 60) - 1) ^ xor; t > 0 && a > 0; t ^= lb) {
            lb = t & -t;
            x |= lb;
            y |= lb;
            a--;
        }
        if (a > 0) {
            return "-1";
        }
        return x + " " + y;
    }
}
/*
D - Popcount and XOR
https://atcoder.jp/contests/abc347/tasks/abc347_d

灵茶の试炼 2025-04-15
题目大意：
输入 a(0≤a≤60) b(0≤b≤60) 和 xor(0≤xor<2^60)。
构造两个在 [0,2^60) 中的整数 x 和 y，满足 x 的二进制中有 a 个 1，y 的二进制中有 b 个 1，且 x 异或 y 等于 xor。
输出 x 和 y。
多解输出任意解。
如果无法构造，输出 -1。

首先，出现在 xor 中的 1，意味着 x 和 y 在这一位上必须恰好有一个是 1。
考虑把这些 1 分配和 x 和 y。
如果 a > b，分给 x，把 a 减一。
否则，分给 y，把 b 减一。
这样可以让 a 和 b 尽量相等。
分配完后必须满足 a = b >= 0，否则输出 -1。
继续，对于 xor 中的 0，x 和 y 在这一位上可以都是 1。
如果 a > 0，就把这些位置也填上 1，然后把 a 减一。
如果全弄完仍然 a > 0，输出 -1。
否则输出 x 和 y。
代码 https://atcoder.jp/contests/abc347/submissions/64848732
======

Input 1
3 4 7
Output 1
28 27

Input 2
34 56 998244353
Output 2
-1

Input 3
39 47 530423800524412070
Output 3
540431255696862041 10008854347644927
 */
