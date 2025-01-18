package p797;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.Scanner;

public class CF797F {
    static int n, m;
    static int[] a;
    static int[][] b; // x, cap

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        b = new int[m][2];
        for (int i = 0; i < m; i++) {
            b[i][0] = scanner.nextInt();
            b[i][1] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    static final long INF = (long) 1e18;

    private static String solve() {
        long sumCap = 0;
        for (int[] p : b) sumCap += p[1];
        if (sumCap < n) return "-1";

        Arrays.sort(a);
        Arrays.sort(b, Comparator.comparingInt(o -> o[0]));

        long[] f = new long[n + 1];
        Arrays.fill(f, INF);
        f[0] = 0;
        long[] s = new long[n + 1];
        for (int[] p : b) {
            for (int j = 0; j < n; j++) {
                s[j + 1] = s[j] + Math.abs(a[j] - p[0]);
            }
            Deque<long[]> dq = new ArrayDeque<>(); // v, i
            dq.add(new long[2]);
            for (int j = 1; j <= n; j++) {
                while (!dq.isEmpty() && f[j] - s[j] <= dq.getFirst()[0]) {
                    dq.removeLast();
                }
                dq.add(new long[]{f[j] - s[j], j});
                if (dq.getFirst()[1] < j - p[1]) {
                    dq.removeFirst();
                }
                f[j] = dq.getFirst()[0] + s[j];
            }
        }
        return String.valueOf(f[n]);
    }
}
/*
F. Mice and Holes
https://codeforces.com/contest/797/problem/F

灵茶の试炼 2024-06-28
题目大意：
输入 n(1≤n≤5000) 和 m(1≤m≤5000)。
然后输入长为 n 的数组 a(-1e9≤a[i]≤1e9)，表示在数轴上有 n 个一样的小球，第 i 个小球的位置是 a[i]。
然后输入 m 行，每行两个数 pi(-1e9≤pi≤1e9) 和 ci(1≤ci≤5000)，表示有 m 个洞，第 i 个洞的位置是 pi，能容纳 ci 个小球。
把所有小球都移入洞中，移动距离之和的最小值是多少？
如果无法满足，输出 -1。

rating 2600
划分型 DP + 单调队列优化。
没做过划分型 DP 的同学可以看看 动态规划题单
不了解单调队列的同学可以看看【基础算法精讲 27】
首先有如下贪心结论：
把小球和洞按照位置从小到大排序，那么最左边的若干个小球（可能 0 个）进第一个洞，接下来的若干小球（可能 0 个）进第二个洞，依此类推。
于是问题变成，把 a 分成若干段，第 i 段的小球（不能超过 ci 个）进第 i 个洞，移动距离之和为
sum(abs(a[j] - pi) for j in 这一段)
按照划分型 DP 的套路，定义：
f[i][j] = a[:j] 进前 i 个洞的距离和
注意这个定义 j=0 表示没有小球，j=1 表示第一个小球，j=n 表示所有小球。
考虑最后一个子数组的小球进第 i 个洞的距离和。
枚举最后一个子数组的左端点 L，从 f[i-1][L] 转移到 f[i][j]，考虑 a[L:j] 对最优解的影响，设 abs(a[j]-pi) 的前缀和数组为 s，那么有
f[i][j] = min{ f[i-1][L] + s[j] - s[L] } = min{ f[i-1][L] - s[L] } + s[j]
其中 L 属于区间 [j-ci,j]。如果 L=j 表示没有小球移动到第 i 个洞。
由于上式随着 j 的变大，L 的最小值也在变大，所以是一个滑动窗口最小值问题，可以用单调队列优化。
单调队列保存 (f[i-1][j] - s[j], j)，注意额外保存下标。由于计算的是最小值，右边遇到更小的可以把左边更大（或者相等）的弹出，所以是单调队列从左到右是严格递增的，队首就是转移来源的最小值。
即 f[i][j] = 队首 + s[j]。
如果队首的下标 < j - ci，那么弹出队首。
初始值 f[0][0] = 0, f[0][j] = inf (j >= 1)。
最后答案为 f[m][n]。
代码实现时，由于队列中保存了 f[i-1][.] 的信息，所以 f 数组的第一个维度可以去掉。
https://codeforces.com/contest/797/submission/266835304
======

Input
4 5
6 2 8 9
3 6
2 1
3 6
4 7
4 7
Output
11

Input
7 2
10 20 30 40 50 45 35
-1000000000 10
1000000000 1
Output
7000000130
 */
