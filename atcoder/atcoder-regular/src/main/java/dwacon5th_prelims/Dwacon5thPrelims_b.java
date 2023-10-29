package dwacon5th_prelims;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Dwacon5thPrelims_b {
    static int n, k;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        k = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        long sum = 0;
        for (int v : a) {
            sum += v;
        }

        long ans = 0;
        // for i := 1 << (bits.Len(uint(s)) - 1); i > 0; i >>= 1 {
        for (long i = 1L << (bitsLen(sum) - 1); i > 0; i >>= 1) {
            int cnt = 0;
            for (int l = 0; l < n; l++) {
                long s = 0;
                for (int j = l; j < n; j++) {
                    s += a[j];
                    if ((s & i) > 0 && (s & ans) == ans) {
                        cnt++;
                    }
                }
            }
            if (cnt >= k) {
                ans |= i;
            }
        }
        return String.valueOf(ans);
    }

    // bits.Len:
    // Len returns the minimum number of bits required to represent x; the result is 0 for x == 0.
    static int bitsLen(long x) {
        if (x == 0) return 0;
        return Long.toBinaryString(x).length();
//        return Long.numberOfTrailingZeros(Long.highestOneBit(x)) + 1;
    }
}
/*
B - Sum AND Subarrays
https://atcoder.jp/contests/dwacon5th-prelims/tasks/dwacon5th_prelims_b

灵茶の试炼 2023-10-04
题目大意：
输入 n(2≤n≤1000) k(1≤k≤n*(n+1)/2) 和长为 n 的数组 a(1≤a[i]≤1e9)。
a 一共有 n*(n+1)/2 个非空连续子数组，也有对应的 n*(n+1)/2 个子数组元素和。
从这 n*(n+1)/2 个元素和中，选择 k 个，计算这 k 个数的按位与（AND）。
按位与的最大值是多少？
不考虑输入的空间，你能做到 O(1) 额外空间吗？

rating 1381
从高位到低位考虑。
如果所有子数组和的第 x 位有超过 k 个 1，那么答案的第 x 位可以是 1，且后续只需要考虑第 x 位是 1 的子数组和。
如果不足 k 个 1，那么答案的第 x 位只能是 0。
https://atcoder.jp/contests/dwacon5th-prelims/submissions/46029217
======

Input 1
4 2
2 5 2 5
Output 1
12

Input 2
8 4
9 1 8 2 7 5 6 4
Output 2
32
 */