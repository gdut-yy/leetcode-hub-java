package p1935;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class CF1935C {
    static int n, lim;
    static int[][] a; // a, b

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            lim = scanner.nextInt();
            a = new int[n][2];
            for (int i = 0; i < n; i++) {
                a[i][0] = scanner.nextInt();
                a[i][1] = scanner.nextInt();
            }
            System.out.println(solve1());
        }
    }

    // 方法一：暴力枚举+最大堆
    private static String solve() {
        Arrays.sort(a, Comparator.comparingInt(o -> o[1]));

        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (a[i][0] <= lim) {
                ans = Math.max(ans, 1);
                PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
                long s = 0;
                for (int j = i - 1; j >= 0 && a[i][0] + a[i][1] - a[j][1] < lim; j--) {
                    int[] q = a[j];
                    pq.add(q[0]);
                    s += q[0];
                    while (!pq.isEmpty() && a[i][0] + a[i][1] - q[1] + s > lim) {
                        s -= pq.remove();
                    }
                    ans = Math.max(ans, 1 + pq.size());
                }
            }
        }
        return String.valueOf(ans);
    }

    // 方法二：DP
    static final long INF = (long) 1e18;

    private static String solve1() {
        Arrays.sort(a, Comparator.comparingInt(o -> o[1]));

        long[][] f = new long[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], INF);
        }
        long ans = 0;
        for (int j = 0; j < n; j++) {
            f[0][j] = a[j][0] - a[j][1];
            if (a[j][0] <= lim) {
                ans = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            long mn = f[i - 1][i - 1];
            for (int j = i; j < n; j++) {
                f[i][j] = mn + a[j][0];
                if (f[i][j] + a[j][1] <= lim) {
                    ans = i + 1;
                }
                mn = Math.min(mn, f[i - 1][j]);
            }
        }
        return String.valueOf(ans);
    }
}
/*
C. Messenger in MAC
https://codeforces.com/contest/1935/problem/C

灵茶の试炼 2024-07-24
题目大意：
输入 T(≤5e4) 表示 T 组数据。所有数据的 n^2 之和 ≤4e6。
每组数据输入 n(1≤n≤2000) lim(1≤lim≤1e9) 和长为 n 的数组，其中第 i 个元素是数对 (ai, bi)，范围 [1,1e9]。
你可以打乱这 n 个元素的顺序。
选出数组中的一个子序列（不一定连续），要求满足
sum(子序列中的 a) + sum(子序列中相邻两个 b 的绝对差) ≤ lim
输出子序列长度的最大值。
注：本题有两种不同的做法。

rating 1800
方法一：暴力枚举+最大堆
如果存在 a <= lim，那么答案至少是 1。
下面讨论更大的答案。
按照 b 从小到大排序，那么和式变成 sum(子序列中的 a) + b[i] - b[j]，其中 b[i] 和 b[j] 分别是所选子序列中的最大 b 和最小 b。
枚举 i，然后 j 从 i-1 开始倒着枚举。
此时只需要考虑 sum(子序列中的 a) 的最小值。
做法类似力扣上的维护子数组前 k 小问题（见我的力扣数据结构题单中的堆），
用最大堆维护从 a[j] 到 a[i-1] 中的元素，如果 a[i] + 堆中元素和 + b[i] - b[j] > lim，则弹出堆顶，直到 <= lim。
然后用 (1+堆大小) 更新答案的最大值。
你可能会问：如果出堆时，恰好把 a[j] 出堆了，上面这个不等式不就错了吗？
如果出现这种情况，那么上面这个不等式比我们先前在 j+1 时的不等式的要求更加严格，所以堆的大小不会比先前在 j+1 时的堆的大小更大，所以不会算错。
堆代码 https://codeforces.com/problemset/submission/1935/271457320
方法二：DP
首先按照 b 从小到大排序。
考虑在前 j 个数对中选 i 个数，且第 j 个数必选。
那么问题变成求 sum(a) + b[j] - b[k] 的最小值，其中 b[k] 是第一个选的数。
由于 b[j] 是固定的，单独提出来，问题变成求 sum(a) - b[k] 的最小值，把它当作 f[i][j] 的值。
初始值：f[1][j] = a[j] - b[j]。
转移：f[i][j] = min{f[i-1][k] + a[j]}，其中 k < j。
这可以用前缀最小值优化。
答案：如果在 f[i] 中，存在 j 满足 f[i][j] + b[j] <= lim，则更新答案为 i。
下面代码中的 i 从 0 开始。
DP 代码（优化前） https://codeforces.com/contest/1935/submission/272078233
进一步地，f 的第一个维度可以优化掉。
DP 代码（优化后） https://codeforces.com/problemset/submission/1935/272079355
======

Input
5
5 8
4 3
1 5
2 4
4 3
2 3
1 6
4 10
3 12
4 8
2 1
2 12
5 26
24 7
8 28
30 22
3 8
17 17
5 14
15 3
1000000000 998244353
179 239
228 1337
993 1007
Output
3
1
2
1
0
 */
