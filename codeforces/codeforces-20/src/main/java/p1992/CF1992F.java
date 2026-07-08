package p1992;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CF1992F {
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
        long x = scanner.nextLong();
        int ans = 1;
        Set<Long> set = new HashSet<>();
        set.add(1L);
        for (int i = 0; i < n; i++) {
            long v = scanner.nextLong();
            Long[] a = set.toArray(new Long[0]);
            for (long w : a) {
                if (x % (v * w) == 0) {
                    set.add(v * w);
                }
            }
            if (set.contains(x)) {
                ans++;
                set.clear();
                set.add(1L);
                set.add(v);
            }
        }
        out.println(ans);
    }
}
/*
F. Valuable Cards
https://codeforces.com/contest/1992/problem/F

灵茶の试炼 2026-03-19
题目大意：
输入 T(≤1e3) 表示 T 组数据。所有数据的 n 之和 ≤1e5。
每组数据输入 n(1≤n≤1e5) x(2≤x≤1e5) 和长为 n 的数组 a(1≤a[i]≤2e5 且 a[i]≠x)。
把 a 划分成若干段。
要求：对于每一段，无法从中选出一个子序列，元素积恰好等于 x。
输出最少段数。

rating 1900
第一段怎么划分？
第一段越长越好。后面的元素越少，划分数越少。
怎么判断必须要划分了？
直接把从前 i 个数中能得到的所有乘积都算出来，如果包含 x，那就必须划分了。
但这样做，乘积太多了，会超时。
乘积是 x 的那些数，必须是 x 的因子，所以我们只需考虑是 x 的因子的乘积。由于因子个数是 x 的开立方数量级的，这很小，可以用一个 set 维护前 i 个数的乘积（只考虑是 x 的因子的乘积）。
遍历到 a[i] 时，把 a[i] 与 set 中的元素相乘，如果乘积是 x 的因子，那么把乘积加到 set 中。
注意一边遍历 set 一边修改 set 通常是不行的，可以先把 set 中的元素加到一个列表中，遍历这个列表。
时间复杂度 O(n*A)，其中 A<=128 是 x 的因子个数。
代码 https://codeforces.com/contest/1992/submission/367045840
代码备份（上面打不开的同学看这个）
======

Input
8
6 4
2 3 6 2 1 2
9 100000
50000 25000 12500 6250 3125 2 4 8 16
5 2
1 1 1 1 1
8 6
4 3 4 3 4 3 4 3
7 12
6 11 1 3 11 10 2
10 5
2 4 4 2 4 4 4 3 1 1
7 8
4 6 5 1 2 4 1
8 27
3 9 17 26 2 20 9 3
Output
3
2
1
1
2
1
3
3
 */
