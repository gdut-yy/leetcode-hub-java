package p2075;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class CF2075B {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        if (k > 1) {
            Arrays.sort(a);
            long s = 0;
            for (int i = n - k - 1; i < n; i++) {
                int v = a[i];
                s += v;
            }
            out.println(s);
        } else if (n == 2) {
            out.println(a[0] + a[n - 1]);
        } else {
            // Fprintln(out, max(a[0]+a[n-1], slices.Max(a[1:n-1])+max(a[0], a[n-1])))
            int res1 = a[0] + a[n - 1];
            int res2 = Integer.MIN_VALUE;
            for (int i = 1; i < n - 1; i++) res2 = Math.max(res2, a[i]);
            res2 += Math.max(a[0], a[n - 1]);
            int ans = Math.max(res1, res2);
            out.println(ans);
        }
    }
}
/*
B. Array Recoloring
https://codeforces.com/contest/2075/problem/B

灵茶の试炼 2025-09-29
题目大意：
输入 T(≤1e3) 表示 T 组数据。所有数据的 n 之和 ≤5000。
每组数据输入 n(2≤n≤5000) k(1≤k≤n-1) 和长为 n 的数组 a(1≤a[i]≤1e9)。
一开始，所有数都是红色的。
首先，选择 a 中的 k 个元素，涂成蓝色。
然后每次操作，选择一个有蓝色邻居的红色元素，把红色元素涂成蓝色。直到所有元素都是蓝色。
设 S = 一开始选的 k 个元素之和 + 最后一个涂成蓝色的元素值。
输出 S 的最大值。

rating 1300
分类讨论：
如果 k>=2，那么我们可以取到前 k+1 大。具体来说，选择前 k+1 大的最左元素和最右元素，就能保证选了 k 个数后，可以选到前 k+1 大中剩下的那个没选的数。
如果 k=1，有两种情况：
- 选 a[0] 或者 a[n-1]，然后选 a[n-1] 或 a[0]。
- 选除去首尾的中间元素的最大值，然后选 max(a[0],a[n-1])。
两种情况取最大值。
代码 https://codeforces.com/problemset/submission/2075/338143181
代码备份（上面打不开的同学看这个）
======

Input
3
3 1
1 2 3
5 2
4 2 3 1 3
4 3
2 2 2 2
Output
5
10
8
 */
