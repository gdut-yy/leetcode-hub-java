package p2163;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF2163C {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) a[i] = scanner.nextInt();
        for (int i = 0; i < n; i++) b[i] = scanner.nextInt();
        int[] sufMin = new int[n + 1];
        int[] sufMax = new int[n + 1];
        sufMin[n] = n * 2;
        sufMax[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            sufMin[i] = Math.min(sufMin[i + 1], b[i]);
            sufMax[i] = Math.max(sufMax[i + 1], b[i]);
        }
        int[] r2l = new int[n * 2 + 1];
        int preMax = 0, preMin = n * 2;
        for (int i = 0; i < n; i++) {
            preMax = Math.max(preMax, a[i]);
            preMin = Math.min(preMin, a[i]);
            int l = Math.min(preMin, sufMin[i]);
            int r = Math.max(preMax, sufMax[i]);
            r2l[r] = Math.max(r2l[r], l);
        }
        long ans = 0;
        int maxL = 0;
        for (int l : r2l) {
            maxL = Math.max(maxL, l);
            ans += maxL;
        }
        out.println(ans);
    }
}
/*
C. Monopati
https://codeforces.com/contest/2163/problem/C

灵茶の试炼 2026-04-29
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(2≤n≤2e5) 和一个 2 行 n 列的网格图，元素范围 [1,2n]。
定义 check(L,R) 表示是否存在一条从左上角移动到右下角的路径，其中每个格子的值都在 [L,R] 中。只能向下或向右移动。
输出有多少对 (L,R) 满足 1≤L≤R≤2n 且 check(L,R) 为 true（存在路径）。

rating 1500
只有 2 行的话，路径由第一行的前缀 + 第二行的后缀组成。
前后缀分解。
维护第一行的前缀最小值、前缀最大值，以及第二行的后缀最小值、后缀最大值。
设 mn = min(前缀最小值,后缀最小值)，mx = max(前缀最大值,后缀最大值)。
枚举往下走的位置，我们可以得到 n 对 (mn, mx)，表示当 L <= mn 且 R >= mx 时，check(L,R) 为 true。
如何从这 n 条信息中算出 (L,R) 的个数？
枚举 R，维护 L。
比如有这样两条信息 (mn,mx) = (3,6) 以及 (mn,mx) = (2,8)，那么当 R=8 时，L 最大可以是多少？
L 可以是 1 和 2，可以是 3 吗？可以的，因为 R=8 L=3 也包含 (mn,mx) = (3,6) 的路径。
由此可知，我们需要维护 mx <= R 时，最大的 mn，即为最大的 L。
用一个数组记录 mx 对应的 mn 的最大值。然后计算这个数组的前缀最大值，即为最大的 L。
代码 https://codeforces.com/contest/2163/submission/372683277
代码备份（上面打不开的同学看这个）
======

Input
5
2
1 3
3 1
3
1 2 3
3 2 1
4
1 5 5 5
5 3 1 2
4
8 8 8 8
8 8 8 8
6
6 6 5 7 9 12
1 4 2 8 5 6
Output
2
5
4
8
25
 */
