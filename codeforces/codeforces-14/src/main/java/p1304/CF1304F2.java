package p1304;

import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class CF1304F2 {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        int[] s = new int[m + 1];
        int[] f = new int[m - k + 1];
        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            Arrays.fill(s, 0);
            for (int j = 1; j <= m; j++) {
                s[j] = scanner.nextInt() + s[j - 1];
            }

            if (i == 0) {
                for (int j = 0; j < f.length; j++) {
                    f[j] = s[j + k] - s[j];
                }
                continue;
            }

            int[] nf = new int[f.length];
            int mx = 0;
            q.clear();

            // 从左到右扫描
            for (int j = 0; j < f.length; j++) {
                if (j >= k) {
                    mx = Math.max(mx, f[j - k] + s[j] - s[j - k]);
                }

                while (!q.isEmpty() && f[q.getLast()] - s[q.getLast()] <= f[j] - s[j]) {
                    q.pollLast();
                }
                q.addLast(j);
                if (q.getFirst() <= j - k) {
                    q.pollFirst();
                }

                nf[j] = Math.max(mx - s[j], f[q.getFirst()] - s[q.getFirst()]) + s[j + k];
            }

            mx = 0;
            q.clear();

            // 从右到左扫描
            for (int j = f.length - 1; j >= 0; j--) {
                if (j <= f.length - 1 - k) {
                    mx = Math.max(mx, f[j + k] + s[j + 2 * k] - s[j + k]);
                }

                while (!q.isEmpty() && f[q.getLast()] + s[q.getLast() + k] <= f[j] + s[j + k]) {
                    q.pollLast();
                }
                q.addLast(j);
                if (!q.isEmpty() && q.getFirst() >= j + k) {
                    q.pollFirst();
                }

                nf[j] = Math.max(nf[j], Math.max(mx + s[j + k], f[q.getFirst()] + s[q.getFirst() + k]) - s[j]);
            }

            f = nf;
        }

        int maxVal = Arrays.stream(f).max().orElseThrow();
        out.println(maxVal);
    }
}
/*
F2. Animal Observation (hard version)
https://codeforces.com/contest/1304/problem/F2

灵茶の试炼 2025-09-26
题目大意：
输入 n(1≤n≤50) m(1≤m≤2e4) k(1≤k≤m) 和 n 行 m 列的矩阵，元素范围 [0,1e3]。
用 n 个 2 行 k 列的矩形覆盖矩阵。
要求每行恰好包含一个矩形的第一行，不能有两个矩形的第一行都在同一行。
特别地，第 n 行的矩形出界了，出界的部分不算。相当于一个 1 行 k 列的矩形。
输出被至少一个矩形覆盖的元素之和的最大值。

rating 2400
最优覆盖问题，考虑 DP。
考虑 [0,i] 行，且行 i 的矩形左上角在 (i,j)。这里的 i 和 j 都是从 0 开始的。
把该约束下的 [0,i] 行覆盖元素和的最大值，记作 f[i][j]。
设行 i-1 的矩形，左上角在 (i-1,p)。
下面讨论 p <= j 的情况。
情况一：p <= j-k。
两个矩形无交集，我们需要知道 f[i-1][p] + s[i][p+k] - s[i][p] 的最大值，其中 s[i] 是行 i 的前缀和。
注意这里的下标，行 i-1 的那个矩形，我们只算了它的第一行，没有算它的第二行，这里 s[i][p+k] - s[i][p] 就是补上这个矩形的第二行。
把 f[i-1][p] + s[i][p+k] - s[i][p] 的最大值，加上 s[i][j+k] - s[i][j]，就是在 (i,j) 这里放矩形的最大元素和 f[i][j]。注意 (i,j) 处的矩形目前只算第一行，第二行留到循环到 i+1 时再计算。
可以用一个变量 mx 维护 p <= j-k 的 f[i-1][p] + s[i][p+k] - s[i][p] 的最大值。
情况二：p > j-k。
两个矩形有交集，那么 [0,i-1] 行的最大元素和是 f[i-1][p]，行 i 的元素和是区间 [p,p+k-1] 和 [j,j+k-1] 的并集 [p,j+k-1]，即 s[i][j+k] - s[i][p]。
我们算的是 f[i-1][p] + s[i][j+k] - s[i][p] 的最大值。
其中 s[i][j+k] 是常量（现在固定 i 和 j），所以计算的是 f[i-1][p] - s[i][p] 的最大值，其中 j-k < p <= j。
这是标准的滑动窗口最大值，用单调队列维护。
用 f[i-1][p] + s[i][j+k] - s[i][p] 更新 f[i][j] 的最大值。
对于 p >= j 的情况，同理。倒序计算。
初始值：f[0][j] = s[0][j+k] - s[0][j]。矩形第二行的元素和会在后面累加。
答案：max(f[n-1])。
代码实现时，s 的第一个维度可以去掉，f 可以用滚动数组。
代码 https://codeforces.com/contest/1304/submission/339969447
代码备份（上面打不开的同学看这个）
======

Input
4 5 2
0 2 1 1 0
0 0 3 1 2
1 0 4 3 1
3 3 0 0 4
Output
25

Input
3 3 1
1 2 3
4 5 6
7 8 9
Output
31

Input
3 3 2
1 2 3
4 5 6
7 8 9
Output
44

Input
3 3 3
1 2 3
4 5 6
7 8 9
Output
45
 */
