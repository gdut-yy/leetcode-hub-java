package p2042;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF2042D {
    static int n;
    static int[][] a;
    static int[] ls;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n][3]; // l, r, i
            ls = new int[n];
            for (int i = 0; i < n; i++) {
                a[i][0] = scanner.nextInt();
                a[i][1] = scanner.nextInt();
                a[i][2] = i;
                ls[i] = a[i][0];
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        Arrays.sort(a, (a, b) -> {
            if (a[1] == b[1]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(b[1], a[1]);
        });
        Arrays.sort(ls);

        int[] ans = new int[n];
        Fenwick tr = new Fenwick(n);
        for (int i = 0; i < n; i++) {
            int[] p = a[i];
            int l = searchInts(ls, p[0]) + 1;
            if (!(i < n - 1 && a[i + 1][1] == p[1] && a[i + 1][0] == p[0])) {
                int res = tr.pre(l);
                if (res < 2e9) {
                    ans[p[2]] = res - (p[1] - p[0]);
                }
            }
            tr.update(l, p[0], p[1]);
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }

    static int searchInts(int[] a, int key) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a[m] >= key) r = m;
            else l = m + 1;
        }
        return l;
    }

    static class Fenwick {
        static class Info {
            int maxL, minR = (int) 2e9;
        }

        int n;
        Info[] f;

        public Fenwick(int n) {
            this.n = n;
            f = new Info[n + 1];
            Arrays.setAll(f, e -> new Info());
        }

        int lb(int x) {
            return x & -x;
        }

        void update(int i, int l, int r) {
            for (; i <= n; i += lb(i)) {
                f[i].maxL = Math.max(f[i].maxL, l);
                f[i].minR = Math.min(f[i].minR, r);
            }
        }

        int pre(int i) {
            int maxL = 0, minR = Integer.MAX_VALUE;
            for (; i > 0; i -= lb(i)) {
                maxL = Math.max(maxL, f[i].maxL);
                minR = Math.min(minR, f[i].minR);
            }
            return minR - maxL;
        }
    }
}
/*
D. Recommendations
https://codeforces.com/contest/2042/problem/D

灵茶の试炼 2024-12-19
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) 和 n 个闭区间，每个闭区间输入两个数 L 和 R (1≤L≤R≤1e9)。
对于每个区间 [L,R]，设包含 [L,R] 的其他区间的交集为 S，输出 S 中的整数的个数减去 [L,R] 中的整数的个数。
如果没有包含 [L,R] 的其他区间，输出 0。

rating 1900
按照右端点从大到小排序。右端点相同的，按照左端点从小到大排序。
如此一来，对于每个区间，包含它的区间都在之前遍历过的区间中。（特判相邻区间完全一样的情况，答案是 0）
开一个树状数组，维护左端点 <= i 的区间中，最大的左端点 maxL，以及最小的右端点 minR。（树状数组每个下标维护两个值）。
遍历到区间 [L,R] 时，在树状数组中查询前缀 [1,L]（其中 L 需要离散化）中的 minR-maxL+1，即为包含 [L,R] 的区间的交集的大小。
那么区间 [L,R] 的答案就是 (minR-maxL+1) - (R-L+1) = (minR-maxL) - (R-L)。
如果 minR-maxL=无穷大，那么区间 [L,R] 没有超集，答案是 0。
然后更新树状数组，下标为 L 离散化后的值，值为 L 和 R（用来更新 maxL 和 minR）。
代码 https://codeforces.com/problemset/submission/2042/297102506
代码备份（洛谷）
======

Input
4
3
3 8
2 5
4 5
2
42 42
1 1000000000
3
42 42
1 1000000000
42 42
6
1 10
3 10
3 7
5 7
4 4
1 2
Output
0
0
1
999999999
0
0
0
0
0
2
3
2
4
8
 */
