package p1667;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CF1667B {
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
        long[] s = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            s[i] = scanner.nextInt();
            s[i] += s[i - 1];
        }

        // Remove duplicates and sort
        Long[] sorted = Arrays.stream(s).boxed().distinct().toArray(Long[]::new);
        Arrays.sort(sorted);

        Map<Long, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < sorted.length; i++) {
            indexMap.put(sorted[i], i);
        }

        int m = sorted.length;
        FenwickTree lessT = new FenwickTree(m);
        FenwickTree grT = new FenwickTree(m);
        FenwickTree maxF = new FenwickTree(m);

        long f = 0;
        for (int r = 0; r <= n; r++) {
            int v = indexMap.get(s[r]);
            if (r > 0) {
                long less = lessT.prefix(v);
                long gr = grT.prefix(m - 1 - v);
                long maxFVal = maxF.tree[v];
                f = max(less + r, gr - r, maxFVal);
            }
            lessT.update(v + 1, f - r);
            grT.update(m - v, f + r);
            maxF.tree[v] = Math.max(maxF.tree[v], f);
        }

        out.println(f);
    }

    static long max(long... values) {
        long maxValue = Long.MIN_VALUE;
        for (long i : values) {
            if (i > maxValue) {
                maxValue = i;
            }
        }
        return maxValue;
    }

    static class FenwickTree {
        long[] tree;
        final long INF = (long) 1e18;

        public FenwickTree(int n) {
            tree = new long[n + 1];
            Arrays.fill(tree, -INF);
        }

        public void update(int i, long v) {
            for (; i < tree.length; i += i & (-i)) {
                tree[i] = Math.max(tree[i], v);
            }
        }

        public long prefix(int i) {
            long res = -INF;
            for (; i > 0; i &= i - 1) {
                res = Math.max(res, tree[i]);
            }
            return res;
        }
    }
}
/*
B. Optimal Partition
https://codeforces.com/contest/1667/problem/B

灵茶の试炼 2025-12-25
题目大意：
输入 T(≤5e5) 表示 T 组数据。所有数据的 n 之和 ≤5e5。
每组数据输入 n(1≤n≤5e5) 和长为 n 的数组 a(-1e9≤a[i]≤1e9)。
你需要把 a 分割成若干个非空连续子数组。注：这一共有 2^(n-1) 种分割方法。
对于子数组 b，设 s = sum(b)。
如果 s > 0，则 b 的价值为 len(b)。
如果 s < 0，则 b 的价值为 -len(b)。
如果 s = 0，则 b 的价值为 0。
哪种划分方法，可以让所有子数组的价值之和最大？
输出这个最大值。

rating 2100
网上有推导过程写得较好的 题解。https://www.luogu.com.cn/article/ymusa3ni
但注意本题求的只是前缀最大值，可以用树状数组。
代码 https://codeforces.com/contest/1667/submission/349042825
代码备份（上面打不开的同学看这个）
注：代码中的 maxF 只是一个普通的列表，不是树状数组。
======

Input
5
3
1 2 -3
4
0 -2 3 -4
5
-1 -2 3 -1 -1
6
-1 2 -3 4 -5 6
7
1 -1 -1 1 -1 -1 1
Output
1
2
1
6
-1
 */
