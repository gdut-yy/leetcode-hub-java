package c015;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Agc015_d {
    static long low, high;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        low = scanner.nextLong();
        high = scanner.nextLong();
        System.out.println(solve());
    }

    private static String solve() {
        if (low == high) {
            return "1";
        }
        // 首先 [A,B] 范围内的每个数都可以取到，先把 B−A+1 加到答案中。
        long ans = high - low + 1;

        // mask := uint(1)<<(bits.Len(high^low)-1) - 1
        long mask = (1L << bitsLen(low ^ high) - 1) - 1;
        low &= mask;
        high &= mask;
        long nh = bitsLen(high);
        if (bitsLen(low) <= nh) {
            ans += mask - high;
        } else {
            ans += mask - low + (1L << nh) - high;
        }
        return String.valueOf(ans);
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
D - A or...or B Problem
https://atcoder.jp/contests/agc015/tasks/agc015_d

灵茶の试炼 2023-09-29
题目大意：
输入 A B (1≤A≤B<2^60)。
问：有多少个数，可以由 [A,B] 内的一个或多个整数，通过按位或 (OR) 运算得到？
思考：改成 AND 要怎么做？改成 XOR 呢？

请看题解：
https://www.luogu.com.cn/blog/endlesscheng/solution-at-agc015-d
======

Input 1
7
9
Output 1
4

Input 2
65
98
Output 2
63

Input 3
271828182845904523
314159265358979323
Output 3
68833183630578410
 */