package c407;

import java.io.PrintWriter;
import java.util.Scanner;

public class Abc407_f {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        int[] st = new int[n + 1];
        int top = 0;
        st[top++] = -1;
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            while (top > 1 && a[st[top - 1]] < a[i]) {
                right[st[top - 1]] = i;
                top--;
            }
            left[i] = st[top - 1];
            st[top++] = i;
        }
        for (int i = 1; i < top; i++) {
            right[st[i]] = n;
        }
        long[] diff = new long[n + 2];
        long[] diff2 = new long[n + 2];
        for (int i = 0; i < n; i++) {
            int v = a[i];
            int l = left[i], r = right[i];
            int mn = Math.min(i - l, r - i);
            int mx = Math.max(i - l, r - i);
            update(diff, diff2, 1, mn - 1, v, v);
            update(diff, diff2, mn, mx - 1, (long) v * mn, 0);
            update(diff, diff2, mx, r - l - 1, (long) v * mn, -v);
        }
        long sd2 = 0, sd = 0;
        for (int i = 1; i <= n; i++) {
            sd2 += diff2[i];
            sd += diff[i] + sd2;
            out.println(sd);
        }
    }

    static void update(long[] diff, long[] diff2, int l, int r, long base, long step) {
        if (l > r) return;
        diff[l] += base;
        diff[r + 1] -= base + step * (r - l);
        diff2[l + 1] += step;
        diff2[r + 1] -= step;
    }
}
/*
F - Sums of Sliding Window Maximum
https://atcoder.jp/contests/abc407/tasks/abc407_f

灵茶の试炼 2026-06-26
题目大意：
输入 n(1≤n≤2e5) 和长为 n 的数组 a(0≤a[i]≤1e7)。
定义 f(k) 如下：
1. a 有 n-k+1 个长为 k 的连续子数组。
2. 分别计算每个子数组的最大值，得到 n-k+1 个数。
3. f(k) = 这 n-k+1 个数的和。
输出 f(1), f(2), ..., f(n)。
要求：做到 O(n) 时间复杂度。

rating
考虑 a[i] 的贡献，用单调栈求出 a[i] 作为最大值的范围 [L,R]。（为避免重复统计，一边是严格大于，另一边是大于等于）
对于 v = a[i]，设 mn = min(i-L+1,R-i+1)，mx = max(i-L+1,R-i+1)。
当子数组长度 k 在 [1, mn-1] 中时，a[i] 作为最大值的长为 k 的子数组有 k 个，对 ans[k] 的贡献为 v * k。我们需要把一个等差数列 v, 2v, 3v, ... v*mn 依次加到答案的子数组 [1, mn] 中。这可以用二阶差分做。除了创建一个差分数组，还需要创建维护这个差分数组的差分数组。具体见后文的解释。
当子数组长度 k 在 [mn, mx-1] 中时，长为 k 的子数组有 mn 个，对 ans[k] 的贡献均为 v * mn。
当子数组长度 k 在 [mx, R-L+1] 中时，长为 k 的子数组有 R-L+1-k+1 个，对 ans[k] 的贡献是一个从 v * mn 开始的，公差为 -v 的等差数列。
当我们对区间 [L,R] 加上一个等差数列 v, v+d, v+2d, ..., v+(R-L)*d 时：
对于差分数组 diff，在左端点 diff[L] += v，右端点 diff[R+1] -= v+(R-L)*d。
对于差分数组的差分数组 diff2，我们需要让 diff 在计算前缀和时，L+1 相比前一项会额外多 d，L+2 相比前一项会额外多 d，……
所以要把 diff2[L+1] += d，diff2[R+1] -= d。
计算 diff2 的前缀和 sd2，加到 diff[i] 中，再计算 diff 的前缀和，即为答案。
代码 https://atcoder.jp/contests/abc407/submissions/76934395
======

Input 1
4
5 3 4 2
Output 1
14
13
9
5

Input 2
8
2 0 2 5 0 5 2 4
Output 2
20
28
27
25
20
15
10
5

Input 3
11
9203973 9141294 9444773 9292472 5507634 9599162 497764 430010 4152216 3574307 430010
Output 3
61273615
68960818
69588453
65590626
61592799
57594972
47995810
38396648
28797486
19198324
9599162
 */
