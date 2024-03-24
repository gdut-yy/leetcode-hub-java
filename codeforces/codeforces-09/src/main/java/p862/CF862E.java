package p862;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF862E {
    static int n, m, q;
    static int[] a, b;
    static int[][] lrv;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        q = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }
        lrv = new int[q][3];
        for (int i = 0; i < q; i++) {
            lrv[i][0] = scanner.nextInt();
            lrv[i][1] = scanner.nextInt();
            lrv[i][2] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    static long sa, sb;
    static long[] f;

    private static String solve() {
        sa = 0;
        sb = 0;

        for (int i = 0; i < n; i++) {
            if ((i & 1) > 0) {
                sa -= a[i];
            } else {
                sa += a[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if ((i & 1) > 0) {
                sb -= b[i];
            } else {
                sb += b[i];
            }
        }

        f = new long[m - n + 1];
        f[0] = sb;
        for (int i = n; i < m; i++) {
            sb = b[i - n] - sb;
            // 这里跟上面反过来
            if ((n & 1) > 0) {
                sb += b[i];
            } else {
                sb -= b[i];
            }
            f[i - n + 1] = sb;
        }
        Arrays.sort(f);

        List<Long> ans = new ArrayList<>();
        ans.add(query());
        for (int i = 0; i < q; i++) {
            int l = lrv[i][0], r = lrv[i][1], v = lrv[i][2];
            if ((l & 1) > 0) {
                if ((r & 1) > 0) {
                    sa += v;
                }
            } else if ((r & 1) == 0) {
                sa -= v;
            }
            ans.add(query());
        }
        return ans.stream().map(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }

    static long query() {
        int i = searchInts(f, sa);
        if (i == f.length || (i > 0 && sa - f[i - 1] < f[i] - sa)) {
            return sa - f[i - 1];
        } else {
            return f[i] - sa;
        }
    }

    private static int searchInts(long[] a, long key) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a[m] >= key) r = m;
            else l = m + 1;
        }
        return l;
    }
}
/*
E. Mahmoud and Ehab and the function
https://codeforces.com/contest/862/problem/E

灵茶の试炼 2022-10-07
题目大意：
输入 n, m (1≤n≤m≤1e5), q(≤1e5) 和长为 n 的数组 a (-1e9≤a[i]≤1e9)，长为 m 的数组 b (-1e9≤a[i]≤1e9)，下标从 1 开始。
定义 f(j) = abs(c1-c2+c3-c4...cn), 其中 ci = a[i]-b[i+j]。
首先，输出 f(0), f(1), ..., f(m-n) 的最小值。
然后输入 q 个询问，每个询问输入 l, r (1≤l≤r≤n), x(-1e9≤x≤1e9)，表示把 a[l], a[l+1], ..., a[r] 都加上 x，之后输出 f(0), f(1), ..., f(m-n) 的最小值。+x 的影响是永久的。

rating 2100
https://codeforces.com/contest/862/submission/174832813
提示 1：对于 f(j)，把 a[i] 和 b[i+j] 分别计算。
设 a[i] 的交替和为 sa，b[i+j] 的交替和为 sb[j]，则 f(j) = abs(sa-sb[j])。
提示 2：用滑动窗口计算 sb[j]。
提示 3：去掉绝对值负号，问题变成离 0 最近的 sa-sb[j]。
由于 sa 是定值，问题又变成离 sa 最近的 sb[j]。
提示 4：把 sb[] 排序，然后二分。
提示 5：对于区间 +x 操作，注意到我们算的是交替和，中间的 +x -x 互相抵消，因此对 sa 的影响只有 +x -x 不变 这三种，根据 l 和 r 的奇偶性分类讨论。
======

input
5 6 3
1 2 3 4 5
1 2 3 4 5 6
1 1 10
1 1 -9
1 5 -1
output
0
9
0
0
 */