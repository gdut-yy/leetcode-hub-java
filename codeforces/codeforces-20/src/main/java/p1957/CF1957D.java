package p1957;

import java.util.Scanner;

public class CF1957D {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        int[][] suf = new int[30][2];
        int s = 0;
        for (int i = 0; i < n; i++) {
            s ^= a[i];
            for (int j = 0; j < 30; j++) {
                suf[j][s >> j & 1]++;
            }
        }

        long ans = 0;
        int[][] pre = new int[30][2];
        s = 0;
        for (int i = 0; i < n; i++) {
            int v = a[i];

            for (int j = 0; j < 30; j++) {
                pre[j][s >> j & 1]++;
            }
            int hb = bitsLen(v) - 1;
            ans += (long) pre[hb][0] * suf[hb][0] + (long) pre[hb][1] * suf[hb][1];
            s ^= v;
            for (int j = 0; j < 30; j++) {
                suf[j][s >> j & 1]--;
            }
        }
        return String.valueOf(ans);
    }

    // bits.Len:
    // Len returns the minimum number of bits required to represent x; the result is 0 for x == 0.
    static int bitsLen(long x) {
        if (x == 0) return 0;
        return Long.toBinaryString(x).length();
    }
}
/*
D. A BIT of an Inequality
https://codeforces.com/contest/1957/problem/D

灵茶の试炼 2024-11-21
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤1e5。
每组数据输入 n(1≤n≤1e5) 和长为 n 的数组 a(1≤a[i]≤1e9)。
定义 S(i,j) 为 a[i]^a[i+1]^...^a[j]，即子数组的异或和。
输出有多少个 i,j,k 满足 i≤j≤k 且 S(i,j)^S(j,k) > S(i,k)。

rating 1900
用前缀和，转换成 s[k+1] ^ s[i] ^ a[j] > s[k+1] ^ s[i]。
考虑枚举中间的 a[j]。
既然要比大小，从高位思考。
0 不影响不等式，所以不考虑。
1 一定会影响不等式，所以只需考虑 a[j] 的最高位。
左边的 s[i] 和右边的 s[k+1]，在 a[j] 的最高位处，要么都是 0，要么都是 1，这样异或 1 之后才能变大。
所以用前后缀分解，统计左右两边每个比特位的 0 和 1 的个数。
左边指 s 中的下标 <= i 的数，右边指 s 中的下标 > i 的数。
根据乘法原理，把左边 0 的个数 * 右边 0 的个数 + 左边 1 的个数 * 右边 1 的个数加入答案。
前缀和数组可以省略。
代码 https://codeforces.com/problemset/submission/1957/292402150
代码备份（洛谷）
======

Input
3
3
6 2 4
1
3
5
7 3 7 2 1
Output
4
0
16
 */
