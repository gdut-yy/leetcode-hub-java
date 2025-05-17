package p1141;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class CF1141C {
    static int n;
    static long[] d;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        d = new long[n];
        for (int i = 1; i < n; i++) {
            d[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        Set<Long> seen = new HashSet<>();
        seen.add(0L);
        long minS = 0; // minS 可以不取 INT_MAX
        long maxS = 0;
        for (int i = 1; i < n; i++) {
            d[i] += d[i - 1];
            long v = d[i];
            if (seen.contains(v)) {
                return "-1";
            }
            seen.add(v);
            minS = Math.min(minS, v);
            maxS = Math.max(maxS, v);
        }
        if (maxS - minS != n - 1) {
            return "-1";
        }
        long finalMinS = minS;
        return Arrays.stream(d).map(v -> v + (1 - finalMinS)).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
C. Polycarp Restores Permutation
https://codeforces.com/contest/1141/problem/C

灵茶の试炼 2025-04-29
题目大意：
输入 n(2≤n≤2e5) 和长为 n-1 的数组 d(-n<d[i]<n)。
这个长为 n-1 的 d 数组，是某个 1~n 的排列 p 的差分数组。
输出 p 数组。
如果不存在 p，输出 -1。

rating 1500
本题和 2145. 统计隐藏数组数目 类似。
计算 d 的前缀和数组 s。
如果答案存在，那么把 s 平移，也就是每个元素都增大 1-min(s)，就可以得到 1~n 的排列。
下面两种情况只要有一种成立，就输出 -1：
1. s 中有重复元素。
2. max(s) - min(s) 不等于 n-1。
代码 https://codeforces.com/problemset/submission/1141/316755635
代码备份（洛谷）
======

Input
3
-2 1
Output
3 1 2

Input
5
1 1 1 1
Output
1 2 3 4 5

Input
4
-1 2 2
Output
-1
 */
