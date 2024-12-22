package p1863;

import java.util.Scanner;

public class CF1863F {
    static int n;
    static long[] sum;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            sum = new long[n + 1];
            for (int i = 1; i <= n; i++) {
                sum[i] = scanner.nextLong();
                sum[i] ^= sum[i - 1];
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        StringBuilder output = new StringBuilder();
        long[] leftBits = new long[n];
        for (int i = 0; i < n; i++) {
            long rightBits = 0;
            for (int j = n - 1; j >= i; j--) {
                long s2 = sum[j + 1] ^ sum[i];
                boolean ok = (i == 0 && j == n - 1) || // 递归入口
                        (rightBits < 0 || (rightBits & s2) != 0) ||  // 能从 f(i,R) 递归到 f(i,j)
                        (leftBits[j] < 0 || (leftBits[j] & s2) != 0); // 能从 f(L,j) 递归到 f(i,j)
                if (ok) {
                    if (s2 == 0) {
                        leftBits[j] = -1;
                        rightBits = -1;
                    } else {
                        long high = 1L << (bitsLen(s2) - 1);
                        leftBits[j] |= high;
                        rightBits |= high;
                    }
                }
                if (j == i) {
                    output.append(ok ? "1" : "0");
                }
            }
        }
        return output.toString();
    }

    // bits.Len:
    // Len returns the minimum number of bits required to represent x; the result is 0 for x == 0.
    static int bitsLen(long x) {
        if (x == 0) return 0;
        // Time limit exceeded on test 5
//        return Long.toBinaryString(x).length();
        return Long.numberOfTrailingZeros(Long.highestOneBit(x)) + 1;
    }
}
/*
F. Divide, XOR, and Conquer
https://codeforces.com/contest/1863/problem/F

灵茶の试炼 2024-07-26
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤1e4。
每组数据输入 n(1≤n≤1e4) 和长为 n 的数组 a(0≤a[i]<2^60)。
不断执行如下操作，直到 a 中只有一个元素：
把 a 分成左右两段，丢弃其中异或和小的那段。如果两段异或和相同，丢弃哪个都可以。
对于每个 a[i]，回答：最终剩下的数能否是 a[i]？
输出一个长为 n 的 01 字符串，其中第 i 个字符表示 a[i] 的答案（0 表示不能，1 表示能）。

rating 2600
https://www.luogu.com.cn/article/2ehhrzmk
======

Input
6
6
3 2 1 3 7 4
5
1 1 1 1 1
10
1 2 4 8 4 1 2 3 4 5
5
0 0 0 0 0
5
1 2 3 0 1
1
100500
Output
111111
10101
0001000000
11111
11001
1
 */
