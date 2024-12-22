package p1922;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1922C {
    static Scanner scanner = new Scanner(System.in);
    static int n;
    static int[] a;

    public static void main(String[] args) {
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        int[] l = new int[n];
        int[] r = new int[n];
        r[1] = 1;
        for (int i = 1; i < n - 1; i++) {
            if (a[i] - a[i - 1] < a[i + 1] - a[i]) {
                l[i] = l[i - 1] + 1;
                r[i + 1] = r[i] + a[i + 1] - a[i];
            } else {
                l[i] = l[i - 1] + a[i] - a[i - 1];
                r[i + 1] = r[i] + 1;
            }
        }
        l[n - 1] = l[n - 2] + 1;

        int m = scanner.nextInt();
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            ans[i] = x < y ? r[y - 1] - r[x - 1] : l[x - 1] - l[y - 1];
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }
}
/*
C. Closest Cities
https://codeforces.com/contest/1922/problem/C

灵茶の试炼 2024-07-15
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤1e5，m 之和 ≤1e5。
每组数据输入 n(2≤n≤1e5) 和长为 n 的严格递增数组 a(0≤a[i]≤1e9)。
然后输入 m(1≤m≤1e5) 和 m 个询问，每个询问输入两个数 x 和 y，范围 [1,n] 且 x≠y。
数轴上有 n 个点，点 i 的坐标为 a[i]。
有两种移动方式：
1. 从点 i 移动到离它最近的点，花费是 1。保证每个点只有唯一的离它最近的点。
2. 从点 i 移动到点 j，花费是 |a[i]-a[j]|。
对于每个询问，输出从点 x 移动到点 y 的最小花费。

rating 1300
前缀和。
定义 R[i] 表示从 1 到 i 的花费，则有
R[i+1] = R[i] + (a[i]-a[i-1] < a[i+1]-a[i] ? a[i+1]-a[i] : 1)
初始值 R[2] = 1。
同理可得 L[i]，表示从 i 到 1 的花费。
对于每个询问，如果 x < y 则用 R 计算，否则用 L 计算。
代码下标从 0 开始。
代码 https://codeforces.com/contest/1922/submission/269639183
======

Input
1
5
0 8 12 15 20
5
1 4
1 5
3 4
3 2
5 1
Output
3
8
1
4
14
 */