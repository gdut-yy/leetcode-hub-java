package p2019;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF2019B {
    static Scanner scanner = new Scanner(System.in);
    static int n, q;
    static int[] a;

    public static void main(String[] args) {
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            q = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        Map<Long, Integer> cnt = new HashMap<>();
        cnt.put(n - 1L, 1);
        for (int i = 1; i < n; i++) {
            // cnt[i*(n-i)] += v - pre - 1
            // cnt[(i+1)*(n-i)-1]++
            cnt.merge((long) i * (n - i), a[i] - a[i - 1] - 1, Integer::sum);
            cnt.merge((i + 1L) * (n - i) - 1, 1, Integer::sum);
        }

        long[] ans = new long[q];
        for (int i = 0; i < q; i++) {
            long k = scanner.nextLong();
            ans[i] = cnt.getOrDefault(k, 0);
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
B. All Pairs Segments
https://codeforces.com/contest/2019/problem/B

灵茶の试炼 2025-01-13
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤1e5，q 之和 ≤1e5。
每组数据输入 n(2≤n≤2e5) q(1≤q≤1e5) 和长为 n 的严格递增数组 a(1≤a[i]≤1e9)。
对于每个满足 i<j 的 (i,j)，画一条线段（闭区间）[ai,aj]。一共有 n*(n-1)/2 条线段。
然后输入 q 个询问，每个询问输入 k(1≤k≤1e18)，输出有多少个整数恰好在 k 条线段中。

rating 1200
直接预处理所有答案，即在回答询问之前，预处理 cnt，其中 cnt[k] 表示恰好在 k 条线段中的整数个数。
分类讨论。
对于不在 a 中的整数 x，如果 a[i-1]<x<a[i]，那么线段的左端点有 i 种选择，右端点有 n-i 种选择，所以一共有 i*(n-i) 条线段包含 x。
此外满足 a[i-1]<x<a[i] 的 x 有 a[i]-a[i-1]-1 个，那么 cnt[i*(n-i)] += a[i]-a[i-1]-1。
对于在 a 中的整数 x，如果 x=a[i]，那么左端点有 i+1 种选择，右端点有 n-i 种选择，减去左右端点重合的线段（不符合题目要求），
所以一共有 (i+1)*(n-1)-1 条线段包含 a[i]，那么 cnt[(i+1)*(n-i)-1] += 1。
最后对于每个询问，输出 cnt[k]。
代码 https://codeforces.com/contest/2019/submission/299533817
代码备份（洛谷）
======

Input
3
2 2
101 200
2 1
6 15
1 2 3 5 6 7
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
5 8
254618033 265675151 461318786 557391198 848083778
6 9 15 10 6 9 4 4294967300
Output
0 100
0 0 0 0 2 0 0 0 3 0 2 0 0 0 0
291716045 0 0 0 291716045 0 301749698 0
 */
