package p1793;

import java.util.Scanner;

public class CF1793D {
    static int n;
    static int[] a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int v = scanner.nextInt();
            a[v] = i;
        }
        b = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int v = scanner.nextInt();
            b[v] = i;
        }
        System.out.println(solve());
    }

    private static String solve() {
        long i = a[1], j = b[1];
        long l1 = i, r1 = i;
        long l2 = j, r2 = j;
        if (i > j) {
//            i, j = j, i
            long tmp = i;
            i = j;
            j = tmp;
        }
        // 不含 1 的方案数
        // 最后 +1 是指整个数组的方案数
        long ans = i * (i + 1) / 2 + (j - i - 1) * (j - i) / 2 + (n - j - 1) * (n - j) / 2 + 1;
        for (int v = 2; v <= n; v++) {
            // 计算含 v-1 不含 v 的方案数
            i = a[v];
            j = b[v];
            if (!(l1 < i && i < r1 || l2 < j && j < r2)) {
                long l = -1;
                if (i < l1) {
                    l = i;
                }
                if (j < l2) {
                    l = Math.max(l, j);
                }
                long r = n;
                if (i > r1) {
                    r = i;
                }
                if (j > r2) {
                    r = Math.min(r, j);
                }
                ans += Math.max(Math.min(l1, l2) - l, 0) * Math.max(r - Math.max(r1, r2), 0);
            }
            l1 = Math.min(l1, i);
            r1 = Math.max(r1, i);
            l2 = Math.min(l2, j);
            r2 = Math.max(r2, j);
        }
        return String.valueOf(ans);
    }
}
/*
D. Moscow Gorillas
https://codeforces.com/contest/1793/problem/D

灵茶の试炼 2024-11-06
题目大意：
输入 n(1≤n≤2e5) 和两个 1~n 的排列 p 和 q。
定义 mex(a) 为不在 a 中的最小正整数。注意是正整数。
定义 A[i..j] 表示 A 中下标从 i 到 j 的子数组。
输出有多少个下标对 (i,j)，满足 i <= j 且 mex(p[i..j]) = mex(q[i..j])。

rating 1800
思考如下问题：
不含 1 的子数组对有多少个？
含 1 不含 2 的子数组对有多少个？
含 1,2 不含 3 的子数组对有多少个？
……
含 1,2,...,n-1 不含 n 的子数组对有多少个？
以及，包含所有数的子数组对（也就是整个数组，这有 1 个）。
不含 1 的子数组对。
通过 1 在 p 和 q 中的位置可得。分成三段讨论。
含 1 不含 2 的子数组对。以及后续问题。
维护包含 p 中 1,2,...,v-1 的最小子数组的左端点 l1 和右端点 r1。
维护包含 q 中 1,2,...,v-1 的最小子数组的左端点 l2 和右端点 r2。
设 pos1[v] 为 v 在 p 中的下标，pos2[v] 为 v 在 q 中的下标。（下标从 0 开始）
对于不含 v 的方案数：
设 l = -1，如果 pos1[v] < l1，那么 l = pos1[v]，如果 pos2[v] < l2，那么 l 和 pos2[v] 取 max。
设 r = n，如果 pos1[v] > r1，那么 r = pos1[v]，如果 pos2[v] > r2，那么 r 和 pos2[v] 取 min。
子数组的左端点可以从 l+1 到 min(l1,l2)，有 max(min(l1, l2)-l, 0) 个。
子数组的右端点可以从 max(r1,r2) 到 r-1，有 max(r-max(r1, r2), 0) 个。
方案数为 max(min(l1, l2)-l, 0) * max(r-max(r1, r2), 0)。
代码 https://codeforces.com/contest/1793/submission/289846595
代码备份（洛谷）
======

Input
3
1 3 2
2 1 3
Output
2

Input
7
7 3 6 2 1 5 4
6 7 2 5 3 1 4
Output
16

Input
6
1 2 3 4 5 6
6 5 4 3 2 1
Output
11
 */
