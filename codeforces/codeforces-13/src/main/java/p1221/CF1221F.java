package p1221;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class CF1221F {
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

    static long[] mx, todo;
    static int[] idx, L, R;

    static void apply(int o, long f) {
        mx[o] += f;
        todo[o] += f;
    }

    static void maintain(int o) {
        if (mx[o << 1] > mx[o << 1 | 1]) {
            mx[o] = mx[o << 1];
            idx[o] = idx[o << 1];
        } else {
            mx[o] = mx[o << 1 | 1];
            idx[o] = idx[o << 1 | 1];
        }
    }

    static void spread(int o) {
        long f = todo[o];
        if (f == 0) return;
        apply(o << 1, f);
        apply(o << 1 | 1, f);
        todo[o] = 0;
    }

    static void build(int[] a, int o, int l, int r) {
        L[o] = l;
        R[o] = r;
        if (l == r) {
            mx[o] = a[l];
            idx[o] = l;
            return;
        }
        int m = (l + r) >> 1;
        build(a, o << 1, l, m);
        build(a, o << 1 | 1, m + 1, r);
        maintain(o);
    }

    static void update(int o, int l, int r, long f) {
        if (l <= L[o] && R[o] <= r) {
            apply(o, f);
            return;
        }
        spread(o);
        int m = (L[o] + R[o]) >> 1;
        if (l <= m) update(o << 1, l, r, f);
        if (m < r) update(o << 1 | 1, l, r, f);
        maintain(o);
    }

    static long[] query(int o, int l, int r) {
        if (l <= L[o] && R[o] <= r) {
            return new long[]{mx[o], idx[o]};
        }
        spread(o);
        int m = (L[o] + R[o]) >> 1;
        if (r <= m) return query(o << 1, l, r);
        if (l > m) return query(o << 1 | 1, l, r);
        long[] left = query(o << 1, l, r);
        long[] right = query(o << 1 | 1, l, r);
        if (left[0] > right[0]) return left;
        return right;
    }

    private static void solve() {
        int n = scanner.nextInt();
        long ans = 0;
        int[][] a = new int[n][3];
        ArrayList<Integer> bList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a[i][0] = scanner.nextInt();
            a[i][1] = scanner.nextInt();
            a[i][2] = scanner.nextInt();
            if (a[i][0] > a[i][1]) {
                int tmp = a[i][0];
                a[i][0] = a[i][1];
                a[i][1] = tmp;
            }
            bList.add(a[i][0]);
            bList.add(a[i][1]);
        }
        Collections.sort(bList);
        int[] b = new int[bList.size()];
        int m = 0;
        for (int i = 0; i < bList.size(); i++) {
            if (i == 0 || !bList.get(i).equals(bList.get(i - 1))) {
                b[m++] = bList.get(i);
            }
        }
        int size = 2 << (32 - Integer.numberOfLeadingZeros(m - 1));
        mx = new long[size];
        todo = new long[size];
        idx = new int[size];
        L = new int[size];
        R = new int[size];
        build(b, 1, 0, m - 1);
        Arrays.sort(a, (p, q) -> p[1] - q[1]);
        int x1 = (int) 2e9, x2 = (int) 2e9;
        for (int i = 0; i < n; ) {
            int y = a[i][1];
            while (i < n && a[i][1] == y) {
                int pos = Arrays.binarySearch(b, 0, m, a[i][0]);
                update(1, 0, pos, a[i][2]);
                i++;
            }
            int pos = Arrays.binarySearch(b, 0, m, y);
            long[] res = query(1, 0, pos);
            if (res[0] - y > ans) {
                ans = res[0] - y;
                x1 = b[(int) res[1]];
                x2 = y;
            }
        }
        out.println(ans);
        out.print(x1 + " " + x1 + " " + x2 + " " + x2);
    }
}
/*
F. Choose a Square
https://codeforces.com/contest/1221/problem/F

灵茶の试炼 2025-09-19
题目大意：
输入 n(1≤n≤5e5)，在平面直角坐标系上有 n 个坐标点。
每个坐标点输入三个整数 x y(0≤x,y≤1e9) c(-1e6≤c≤1e6)，表示横纵坐标，以及这个点的分数。
定义特殊正方形为平行于坐标轴的正方形，且正方形的左下角和右上角都在直线 y=x 上。
你需要用一个特殊正方形去覆盖点。得分为覆盖的点的 c 之和，减去特殊正方形的边长。
特殊正方形的边长可以是 0。
输出两行：
第一行，输出最大得分。
第二行，输出特殊正方形的左下角横纵坐标，右上角横纵坐标，坐标范围必须在 [0,2e9] 中。多解输出任意解。

rating 2400
设正方形左下角为 (a,a)，右上角为 (b,b)。
如果正方形包含点 (x,y)，那么有
a <= x <= b
a <= y <= b
即
a <= min(x,y) <= max(x,y) <= b
定义 x' = min(x,y)，y' = max(x,y)。正方形要包含 (x',y')。
直观的理解方式是，如果 x > y，那么交换 x 和 y。相当于把 y=x 下方的点翻转到 y=x 上方，这不影响答案。
于是判断条件简化成 x >= a 且 y <= b。
分数为 sum(c) - (b - a) = (a + sum(c)) - b。
枚举正方形包含的纵坐标最大的点 y，那么 b 越小越好，所以 b = y。
现在问题变成最大化 a + sum(c)，其中 sum(c) 中的点满足 x >= a。
核心思路：枚举右，维护左。
枚举 b=y，维护每个 a 对应的 a + sum(c)，然后计算 [0,y] 中的这些 a + sum(c) 的最大值。
用线段树维护，线段树中的叶子 a 保存满足 x >= a 且 y <= b 的点的 a + sum(c)。初始值为 a。
当我们遍历到 (x,y) 时，对于包含 (x,y) 的正方形，满足 a <= x，所以把线段树 [0,x] 中的数都增加 c。这需要 Lazy 线段树。
对于所有 y 相同的点，当前正方形都要包含（当前在枚举 b=y 的正方形），所以要先对这些点执行一遍线段树的区间加（[0,x] 中的数都增加 c），然后再求线段树 [0,y] 中的最大值。
为什么不能一个一个处理？注意本题 c 可能是负数，如果有两个负数 c 需要做区间更新，执行第一个区间更新就立刻算区间最大值，会导致答案偏大。
为方便使用线段树，需要把 x 和 y 离散化。
由于需要输出具体方案，线段树还需要维护区间最大值的下标。
代码 https://codeforces.com/contest/1221/submission/335435781
代码备份（上面打不开的同学看这个）
======

Input
6
0 0 2
1 0 -5
1 1 3
2 3 4
1 4 -4
3 1 -1
Output
4
1 1 3 3

Input
5
3 3 0
3 3 -3
0 2 -1
3 1 3
0 0 -2
Output
0
1 1 1 1
 */
