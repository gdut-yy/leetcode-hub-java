package p1934;

import java.util.Scanner;

public class CF1934D2 {
    static Scanner scanner = new Scanner(System.in);
    static long n, p, q;

    public static void main(String[] args) {
        int T = scanner.nextInt();
        while (T-- > 0) {
            n = scanner.nextLong();
            if (Long.bitCount(n) % 2 > 0) {
                System.out.println("second");
                r();
            } else {
                System.out.println("first");
            }
            while (n > 0) {
                long hb = 1L << (bitsLen(n) - 1);
                System.out.println((n ^ hb) + " " + hb);
                r();
            }
        }
    }

    static void r() {
        p = scanner.nextLong();
        q = scanner.nextLong();
        if (Long.bitCount(p) % 2 == 0) {
            n = p;
        } else {
            n = q;
        }
    }

    // bits.Len:
    // Len returns the minimum number of bits required to represent x; the result is 0 for x == 0.
    static int bitsLen(long x) {
        if (x == 0) return 0;
//        return Long.toBinaryString(x).length();
        return Long.numberOfTrailingZeros(Long.highestOneBit(x)) + 1;
    }
}
/*
D2. XOR Break — Game Version
https://codeforces.com/contest/1934/problem/D2

灵茶の试炼 2024-08-02
题目大意：
输入 T(≤1e3) 表示 T 组数据。
每组数据输入 n(1≤n≤1e18)。
这是一道交互题。你和评测机玩游戏，轮流操作 n。
每回合，当前玩家把 n 分解为 p1 和 p2，满足 0 < p1 < p 且 0 < p2 < p 且 p1 xor p2 = n。
然后对手选择 p1 或者 p2，替换掉 n。
下一回合轮到对手操作。
无法把 n 分解的玩家输掉游戏。
你可以决定扮演先手（先操作 n）还是后手（让评测机先操作 n）。
你需要保证自己获胜。
轮到你操作的回合数必须 ≤ 63。
具体的交互格式见题目。

rating 2400
可以打表看看规律。
提示 1：
如果 n 是 2 的幂，那么无法继续操作。
提示 2：
用 cnt1(x) 表示 x 的二进制中的 1 的个数。
考虑 cnt1(p1) 和 cnt1(p2) 都是奇数的情况。
cnt1(p1 xor p2) 是奇数还是偶数？
从集合的角度理解 xor，相当于计算两个集合的并集，然后去掉交集。
所以 cnt1(p1 xor p2) = cnt1(p1) + cnt1(p2) - 2 * cnt1(p1 and p2) = 奇数 + 奇数 - 偶数 = 偶数。
这意味着，如果 cnt1(n) 是奇数，那么无法分解成两个 cnt1 都是奇数的数，分解出的两个数中，必定有数字的 cnt1 是偶数。
结论：
如果 cnt1(n) 是偶数，那么扮演先手，否则扮演后手。
操作方法：
留给我们的一定是 cnt1(n) 是偶数的局面。
我们把最高位单独分解出来，作为 p1，剩余的作为 p2。
由于 p1 是 2 的幂，所以评测机一定会选 p2。
所以留给评测机的数的 cnt1 一定是奇数。
根据提示 2，评测机去分解，一定可以分解出一个 cnt1 是偶数的数，我们选这个数，然后重复上述过程。
由于每次都会把 n 变成一个小于 n/2 的数，所以操作次数是 O(logn)，符合题目要求。
代码 https://codeforces.com/contest/1934/submission/273724858
======

Input
4
1

0 0
3


0 0
13


3 4

0 0
777777770001


0 0
Output


second


first
2 1


first
10 7

1 2


first
777777770000 1
 */
