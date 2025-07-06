package p1884;

import java.util.Scanner;
import java.util.TreeMap;

public class CF1884C {
    static int n, m;
    static pair[] a;

    record pair(int l, int r) {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            a = new pair[n];
            for (int i = 0; i < n; i++) {
                int l = scanner.nextInt();
                int r = scanner.nextInt();
                a[i] = new pair(l, r);
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        int ans = Math.max(f(1), f(m));
        return String.valueOf(ans);
    }

    static int f(int ban) {
        // d := map[int]int{}
        // for _, p := range a {
        //   if p.l > ban || p.r < ban {
        //     d[p.l]++
        //     d[p.r+1]--
        //   }
        // }
        //
        // xs := make([]int, 0, len(d))
        // for k := range d {
        //   xs = append(xs, k)
        // }
        // slices.Sort(xs)
        //
        // s := 0
        // for _, x := range xs {
        //   s += d[x]
        //   res = max(res, s)
        // }
        // return
        int res = 0;
        TreeMap<Integer, Integer> d = new TreeMap<>();
        for (pair p : a) {
            if (p.l > ban || p.r < ban) {
                d.merge(p.l, 1, Integer::sum);
                d.merge(p.r + 1, -1, Integer::sum);
            }
        }

        int s = 0;
        for (Integer x : d.values()) {
            s += x;
            res = Math.max(res, s);
        }
        return res;
    }
}
/*
C. Medium Design
https://codeforces.com/contest/1884/problem/C

灵茶の试炼 2025-05-21
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤1e5) m(1≤m≤1e9) 和 n 个闭区间 (1≤l≤r≤m)。
你有一个长为 m 的全 0 数组 a。
从输入的 n 个区间中，选择一些区间（每个区间至多选一次），执行区间 +1 操作。
输出 max(a) - min(a) 的最大值。

rating 1700
假设最大值的位置是 i，那么只需考虑包含 i 的区间。（不含 i 的区间只会让最小值增大）
（用差分）可以证明，如果这些区间都选，那么数组 a 会先递增再递减，所以最小值一定在 1 或者 m 处取到。
假设最小值在 1。
对于包含 1 和 i 的区间，如果不选，那么最大值和最小值都减少了 1，答案不变。
那么干脆不选，这样最小值一定等于 0，我们只需计算最大值。
现在问题变成：
选择所有不含 1 的区间，计算 max(a)。
这可以用差分 map 解决。
对于最小值在 m 的情况也同理。可以写个函数 f(ban) 计算 f(1) 和 f(m)，表示区间不含 ban 时的最大值。
答案为 max(f(1), f(m))。
代码 https://codeforces.com/problemset/submission/1884/320295584
代码备份（洛谷）
======

Input
6
1 3
2 2
3 8
2 4
3 5
4 6
6 3
1 1
1 2
1 3
2 2
2 3
3 3
7 6
2 2
1 6
1 2
5 6
1 5
4 4
3 6
6 27
6 26
5 17
2 3
20 21
1 22
12 24
4 1000000000
2 999999999
3 1000000000
123456789 987654321
9274 123456789
Output
1
3
2
3
4
4
 */
