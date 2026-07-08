package p2165;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CF2165C {
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
        int q = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = scanner.nextInt();
        Arrays.sort(a);
        int start = Math.max(n - 30, 0);
        int[] trimmed = Arrays.copyOfRange(a, start, n);
        for (int i = 0; i < q; i++) {
            int c = scanner.nextInt();
            List<Integer> b = new ArrayList<>();
            for (int v : trimmed) b.add(v);
            int ans = 0;
            while (!b.isEmpty() && b.get(b.size() - 1) < c) {
                int v = b.remove(b.size() - 1);
                int m = bitsLen(c);
                int hb = 1 << (m - 1);
                if (bitsLen(v) == m) {
                    c ^= hb;
                    v ^= hb;
                    int j = searchInts(b, v);
                    b.add(j, v);
                } else {
                    if (b.isEmpty()) {
                        ans += c - v;
                        break;
                    }
                    ans += hb - v;
                    c ^= hb;
                }
            }
            out.println(ans);
        }
    }

    // bits.Len:
    // Len returns the minimum number of bits required to represent x; the result is 0 for x == 0.
    static int bitsLen(long x) {
        return 64 - Long.numberOfLeadingZeros(x);
    }

    static int searchInts(List<Integer> a, int key) {
        int l = 0, r = a.size();
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a.get(m) >= key) r = m;
            else l = m + 1;
        }
        return l;
    }

//    static int searchInts(List<Integer> a, int key) {
//        int j = Collections.binarySearch(a, key);
//        if (j < 0) j = -(j + 1);
//        return j;
//    }
}
/*
C. Binary Wine
https://codeforces.com/contest/2165/problem/C

灵茶の试炼 2026-03-26
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤5e5，q 之和 ≤5e4。
每组数据输入 n(1≤n≤5e5) q(1≤q≤5e4) 和长为 n 的数组 a(0≤a[i]<2^30)。
然后输入 q 个询问，每个询问输入一个 c(0≤c<2^30)。
对于每个询问：
首先，你可以增大某些 a[i]。把 a[i] 增加 x 的花费为 x。
然后，构造一个非负整数数组 b，满足 b[i] <= a[i]，且 b 的异或和恰好等于 c。
输出最小总花费。注：增大 a[i] 相当于增大了 b[i] 的上界。
询问互相独立。

rating 2000
同一个比特位填 k 个 1 等价于填 k%2 个 1，由于 b[i] 越小越好，所以每个比特位至多填 1 个 1 是最优的。
换句话说，本题的 XOR，其实就是 OR。
每个比特位至多填 1 个 1，所以至多需要 30 个数。
所以只需要 a 最大的 30 个数。设这 30 个数（从小到大排序）为数组 A。
倒着遍历 A，分类讨论：
如果 A[i] >= c，那么构造 b[i] = c 即可满足要求，其余 b[j] (j<i) 均为 0。
否则，如果 A[i] 的二进制长度小于 c 的二进制长度，那么把 A[i] 直接增大到 c 是最优的吗？这不是最优的。比如 c = 10100，我们先把 A[i] 增大到 10000，然后把更小的 A[i-1] 增大到 100（或者 A[i-1] >= 100 已经满足要求），这比把 A[i] 直接增大到 10100 更优。然后把 c 的最高位去掉，继续循环。
否则，如果 A[i] 的二进制长度等于 c 的二进制长度，那么是否要增大 A[i]？现在还不确定。比如 A[i] = 10110，拆分成 10000 + 110，把 c 的最高位去掉，把剩下的 110 插到 A 的前面（仍然保持 A 是递增的）。如何处理 110？是否要增大？交给后续循环去判断。万一 A[i-1] 是 1111 呢？那样就不需要增大任何数了。
特殊情况：如果遍历到 i=0，那么把 A[i] 增大到 c（如果需要增大）即可。
代码 https://codeforces.com/problemset/submission/2165/368154747
代码备份（上面打不开的同学看这个）
======

Input
4
2 1
5 7
9
3 1
9 9 8
24
6 4
1 1 4 5 1 4
10
20
30
40
1 1
0
0
Output
1
7
3
11
16
31
0
 */
