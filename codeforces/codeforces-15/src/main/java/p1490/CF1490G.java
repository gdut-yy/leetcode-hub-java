package p1490;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1490G {
    static int n, q;
    static int[] a, x;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            q = scanner.nextInt();
            a = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = scanner.nextInt();
            }
            x = new int[q];
            for (int i = 0; i < q; i++) {
                x[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    static long[] s;
    static List<Integer> p;

    private static String solve() {
        s = new long[n + 1];
        p = new ArrayList<>();
        p.add(0);
        for (int i = 1; i <= n; i++) {
            s[i] = s[i - 1] + a[i];
            if (s[i] > s[p.get(p.size() - 1)]) {
                p.add(i);
            }
        }

        long[] ans = new long[q];
        for (int i = 0; i < q; i++) {
            if (x[i] <= s[p.get(p.size() - 1)]) {
                // i := sort.Search(len(p), func(i int) bool { return s[p[i]] >= x })
                int j = search(x[i]);
                ans[i] = p.get(j) - 1;
            } else if (s[n] < 1) {
                ans[i] = -1;
            } else {
                long loop = (x[i] - s[p.get(p.size() - 1)] - 1) / s[n] + 1;
                // i := sort.Search(len(p), func(i int) bool { return s[p[i]] >= x })
                int j = search(x[i] - loop * s[n]);
                ans[i] = loop * n + (p.get(j) - 1);
            }
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }

    private static int search(long x) {
        int left = 0;
        int right = p.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (s[p.get(mid)] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
/*
G. Old Floppy Drive
https://codeforces.com/contest/1490/problem/G

灵茶の试炼 2023-01-12
题目大意：
输入 t(≤1e4) 表示 t 组数据，每组数据输入 n(≤2e5) m(≤2e5) 和长为 n 的数组 a(-1e9≤a[i]≤1e9)，表示一个由数组 a 无限重复的序列 b。
然后输入 m 个询问，每个询问输入 x(1≤x≤1e9)。
对每个询问，输出 b 的前缀和中首次 ≥x 的下标（下标从 0 开始），如果不存在，输出 -1。
所有数据的 n 之和、m 之和均不超过 2e5。

rating 1900
https://codeforces.com/contest/1490/submission/108014953
提示 1：计算 a 的前缀和的所有 record 下标 p（record 指比上一个最大值更大的前缀和的下标）。
因为前缀和中任何一个递减或相同的地方都是不重要的。
提示 2：做一些与 x 大小有关的分类讨论，在 p 上二分。
提示 3：至少需要重复多少次？需要保证最后一次是 >= max(前缀和) 的，这类似青蛙跳井问题。
======

input
3
3 3
1 -3 4
1 5 2
2 2
-2 0
1 2
2 2
0 1
1 2
output
0 6 2
-1 -1
1 3
 */
