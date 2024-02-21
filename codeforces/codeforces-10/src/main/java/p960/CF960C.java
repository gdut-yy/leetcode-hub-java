package p960;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF960C {
    static int x, d;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        x = scanner.nextInt();
        d = scanner.nextInt();
        System.out.println(solve());
    }

    private static String solve() {
        List<Long> ans = new ArrayList<>();
        for (long v = 1; x > 0; v += d) {
            int n = bitsLen(x);
            if ((1 << n) - 1 > x) {
                n--;
            }
            x -= (1 << n) - 1;
            while (n > 0) {
                ans.add(v);
                n--;
            }
        }
        return ans.size() + System.lineSeparator()
                + ans.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }

    // bits.Len:
    // Len returns the minimum number of bits required to represent x; the result is 0 for x == 0.
    static int bitsLen(long x) {
        if (x == 0) return 0;
        return Long.toBinaryString(x).length();
    }
}
/*
C. Subsequence Counting
https://codeforces.com/contest/960/problem/C

灵茶の试炼 2022-05-25
题目大意：
给你两个数 x 和 d，范围在 [1,1e9] 内。
定义一个非空子序列 b 是好的，需满足 max(b)-min(b) < d
请你构造任意一个满足要求的整数数组 a，要求 a 的长度不超过 1e4，a[i] 均在 [1,1e18] 范围内，且满足：
a 恰好有 x 个非空好子序列。（子序列不要求是连续的）
如果无法构造，输出 -1；否则输出 a 的长度和 a 的元素。

rating 1700
https://codeforces.com/contest/960/submission/158360849
提示 1：对于一段长为 k 且元素均相同的段，这一段包含了 2^k-1 个好子序列。
提示 2：我们总是可以将 x 拆分成若干个 2^k-1（注意 2^k-1 最小是 1，所以一定可以拆分）。
提示 3：可以贪心地构造，每次选最大的不超过 x 的 2^k-1，组成连续 k 个 v，这算一组。
对于 v 的选择，需要满足任意两组之间的 v 不能小于 d，那么 v 可以从 1 开始每次增加 d。
======

input
10 5
output
6
5 50 7 15 6 100

input
4 2
output
4
10 100 1000 10000
 */
