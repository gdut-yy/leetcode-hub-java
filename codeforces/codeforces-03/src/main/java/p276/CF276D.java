package p276;

import java.util.Scanner;

public class CF276D {
    static long l, r;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        l = scanner.nextLong();
        r = scanner.nextLong();
        System.out.println(solve());
    }

    private static String solve() {
        long ans = (1L << bitsLen(r ^ l)) - 1;
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
D. Little Girl and Maximum XOR
https://codeforces.com/contest/276/problem/D

灵茶の试炼 2022-10-03
题目大意：
输入 L 和 R (1≤L≤R≤1e18)。
输出区间 [L,R] 内任意两个数的异或的最大值。
---
思考题：如果还要求异或不超过某个 limit 呢？

https://codeforces.com/contest/276/submission/118793107
如果 L 和 R 的二进制长度不一样，例如 L=2，R=9，那么我们可以用 7^8 得到最大的异或和 15。
推广，如果 L 和 R 的二进制长度一样，那么我们可以从高到低找到第一个二进制不同的位置，转换到长度不一样的情况。
总之，答案为 (1 << bit_length(L ^ R)) - 1。
思考题代码 https://github.com/EndlessCheng/codeforces-go/blob/master/copypasta/bits.go#L632
======

input
1 2
output
3

input
8 16
output
31

input
1 1
output
0
 */