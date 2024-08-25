package p1358;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1358D {
    static int n;
    static long x;
    static int[] d;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        x = scanner.nextLong();
        d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        long ans = 0;
        long s = 0, s2 = 0;

        int l = 0;
        for (int i = 0; i < n * 2; i++) {
            int v = d[i % n];
            s += v;
            s2 += (v + 1L) * v / 2;
            while (s > x) {
                s -= d[l % n];
                s2 -= (d[l % n] + 1L) * d[l % n] / 2;
                l++;
            }
            if (l > 0) {
                long c = x - s;
                ans = Math.max(ans, s2 + (d[(l - 1) % n] * 2L - c + 1) * c / 2);
            } else {
                ans = Math.max(ans, s2);
            }
        }
        return String.valueOf(ans);
    }
}
/*
D. The Best Vacation
https://codeforces.com/contest/1358/problem/D

灵茶の试炼 2023-01-10
题目大意：
输入 n(n≤2e5) x 和长为 n 的数组 d(1≤d[i]≤1e6 且 1≤x≤sum(d))。
在某地，一年有 n 月，其中第 i 月有 d[i] 天，天数从 1 到 d[i]，在第 j 天你可以得到 j 元。
问在该地连续呆 x 天你最多能得到多少元。
注意：从当年最后一月呆到下一年的第一月是可以的。

rating 1900
https://codeforces.com/problemset/submission/1358/188648522
提示 1：看成是环形数组，那么数组复制一份接在后面，就变成非环形的了（注意 x 不超过 sum(d)）。
提示 2：这是个窗口大小为 x 的滑窗问题，但是 x 太大了，如何优化？
提示 3：窗口的开头或者末尾只需要在某些关键的 day 就行了，是什么样的 day 呢？
提示 4：月末收益最大。
提示 5：窗口末尾只需要在月末就行。可以用反证法证明：
假设窗口末尾不在月末是最优的，设窗口末尾在第 k 天是最优的，那么右边一定是第 k+1 天。
如果窗口向右滑，由于我们假设不在月末更优，因此窗口的元素和减少，所以从左边出去的元素必然大于 k+1，出去的元素的左边那个元素必然大于 k。那么把窗口改为向左滑，窗口左边进来一个大于 k 的数，右边出去一个等于 k 的数，窗口元素和变大，矛盾，因此窗口末尾一定在月末是最优的。
那么在 d 数组上双指针模拟就好了。
======

input
3 2
1 3 1
output
5

input
3 6
3 3 3
output
12

input
5 6
4 2 3 1 3
output
15
 */
