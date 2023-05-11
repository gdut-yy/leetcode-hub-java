package c300;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc300_f {
    private static int n, m;
    private static long k;
    private static String s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextLong();
        s = scanner.next();
        System.out.println(solve());
    }

    // https://atcoder.jp/contests/abc300/editorial/6289
    private static String solve() {
        long[] rw = new long[n + 1];
        for (int i = 0; i < n; i++) {
            rw[i + 1] = rw[i];
            if (s.charAt(i) == 'x') {
                rw[i + 1]++;
            }
        }

        long res = 0L;
        for (int i = 1; i <= n; i++) {
            long fbeg = f(i - 1, rw);

            long left = i;
            long right = (long) n * m + 1;
            while (left < right) {
                long mid = left + (right - left) / 2;
                // 边界二分 F, F,..., F, [T, T,..., T]
                // ----------------------^
                if (f(mid, rw) - fbeg > k) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            res = Math.max(res, left - i);
        }
        return String.valueOf(res);
    }

    private static long f(long x, long[] rw) {
        long res = (x / n) * rw[n];
        int rem = (int) (x % n);
        res += rw[rem];
        return res;
    }
}
/*
F - More Holidays
https://atcoder.jp/contests/abc300/tasks/abc300_f

题目大意：
给定一个长度为 N 的字符串 S，由 0 和 x，以及整数 M 和 K 组成。
S 保证包含至少一个 x。
设 T 为长度为 NM 的字符串，由 s 的 M 个副本串联而成。考虑将 T 中的 K 个 x 恰好替换为 0。
您的目标是在生成的 T 中拥有尽可能长的由 0 组成的连续子字符串。
找出你能得到的由 0 组成的连续子串的最大长度。

如果我们可以尝试 T 中所有连续 0 的初始位置，那么我们就可以得到正确的答案。(然而，不可能检查所有可能的 NM 初始位置。)
我们将展示下面的引理。
> 存在一个最优解，其中最长的连续 0 从 T 的第 n 个或前一个字符开始。
假设最优解具有从(N+1)-th 或之后的字符开始的最长连续 0。然后，对于第 i 个字符的每次修改，我们决定修改第(i−N)个字符(如果它存在)。
那么，现在我们就有了一个最优解其中最长连续 0 比之前开始 N 个字符。重复这个证明了引理。
现在这个问题已归纳如下。
> 求解所有 i=1,2，…，N 的问题。
> 我们想要从 t 的第 i 个字符开始，有尽可能多的连续的 0，求出最大长度。
这个问题的解决方法如下。
- 在最远端进行二分搜索。
  - 二分查找中的条件分支可以通过检查起始字符和最后字符之间的 x 的个数是否小于等于 K 来确定。
在二分查找中，我们需要回答以下问题:“T 的前 i 个字符中有多少个 x ?”这个问题可以在 O(1)时间内利用 T 的周期性和累积和得到答案。有关更多详细信息，请参阅示例代码。
======

Input
10 1 2
ooxxooooox
Output
9

Input
5 3 4
oxxox
Output
8

Input
30 1000000000 9982443530
oxoxooxoxoxooxoxooxxxoxxxooxox
Output
19964887064
 */