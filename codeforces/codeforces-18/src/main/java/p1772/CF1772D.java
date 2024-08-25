package p1772;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1772D {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int q = scanner.nextInt();
        while (q-- > 0) {
            n = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        int l = 0, r = (int) 1e9;
        int pre = a[0];
        for (int i = 1; i < n; i++) {
            if (pre > a[i]) {
                l = Math.max(l, (pre + a[i] + 1) / 2);
            } else if (pre < a[i]) {
                r = Math.min(r, (pre + a[i]) / 2);
            }
            pre = a[i];
        }
        int ans = l <= r ? l : -1;
        return String.valueOf(ans);
    }
}
/*
D. Absolute Sorting
https://codeforces.com/contest/1772/problem/D

灵茶の试炼 2023-07-24
题目大意：
输入 T(≤2e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(2≤n≤2e5) 和长为 n 的数组 a(1≤a[i]≤1e8)。
选择一个整数 x(0≤x≤1e9)，生成一个序列 b，满足 b[i]=abs(a[i]-x) 且 b[i]≤b[i+1]。
如果不存在这样的 x，输出 -1，否则输出任意一个符合要求的 x。

rating 1400
https://codeforces.com/problemset/submission/1772/214608589
只需保证相邻两项满足 abs(a[i]-x)≤abs(a[i+1]-x)，那么整个 b[i] 就是递增的（充分必要条件）。
分类讨论：
如果 a[i]=a[i+1]，x 取什么数都满足上面的不等式，所以无视这种情况。
如果 a[i]<a[i+1]，解得 x≤(a[i]+a[i+1])/2。（画出 abs(a[i]-x) 和 abs(a[i+1]-x) 的图像即可得到）
如果 a[i]>a[i+1]，解得 x≥(a[i]+a[i+1])/2。注意这里的除法没有下取整，代码中要写成 (a[i]+a[i+1]+1)/2。
用 l 维护 x 的最小值，r 维护 x 的最大值。
如果最后 l>r 就输出 -1，否则输出 [l,r] 内的任意整数，例如 l。注意 a[i] 的范围可以保证 x 在 [0,1e9] 内。
======

input
8
5
5 3 3 3 5
4
5 3 4 5
8
1 2 3 4 5 6 7 8
6
10 5 4 3 2 1
3
3 3 1
3
42 43 42
2
100000000 99999999
6
29613295 52036613 75100585 78027446 81409090 73215
output
4
-1
0
42
2
-1
100000000
40741153
 */
