package p1927;

import java.util.Scanner;

public class CF1927D {
    static Scanner scanner = new Scanner(System.in);
    static int n, pre, v;
    static int[] left;

    public static void main(String[] args) {
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            left = new int[n + 1];
            pre = scanner.nextInt();
            for (int i = 2; i <= n; i++) {
                v = scanner.nextInt();
                if (v == pre) {
                    left[i] = left[i - 1];
                } else {
                    left[i] = i - 1;
                }
                pre = v;
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        int q = scanner.nextInt();
        String[] output = new String[q];
        for (int i = 0; i < q; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            if (left[r] < l) {
                output[i] = "-1 -1";
            } else {
                output[i] = left[r] + " " + r;
            }
        }
        return String.join(System.lineSeparator(), output);
    }
}
/*
D. Find the Different Ones!
https://codeforces.com/contest/1927/problem/D

灵茶の试炼 2024-07-08
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5，q 之和 ≤2e5。
每组数据输入 n(2≤n≤2e5) 和长为 n 的数组 a(1≤a[i]≤1e6)，下标从 1 开始。
然后输入 q(1≤q≤2e5) 和 q 个询问，每个询问输入两个数 L R(1≤L<R≤n)。
对于每个询问，输出在 [L,R] 内的两个下标 i 和 j，满足 a[i] ≠ a[j]。
如果不存在，输出 "-1 -1"。
变形：询问区间内的数是否互不相同。
P3901 数列找不同
进阶：每个询问额外输入 k，判断区间内是否有至少 k 个不同数字。
P1972 [SDOI2009] HH的项链

rating 1300
定义 left[i] 表示在 a[i] 左侧的不等于 a[i] 的最近元素下标。
递推：如果 a[i] = a[i-1] 则 left[i] = left[i-1]，否则 left[i] = i-1。
回答询问时，如果 left[R] < L 则输出 -1 -1，否则输出 left[R] 和 R。
代码 https://codeforces.com/contest/1927/submission/268932351
======

Input
5
5
1 1 2 1 1
3
1 5
1 2
1 3
6
30 20 20 10 10 20
5
1 2
2 3
2 4
2 6
3 5
4
5 2 3 4
4
1 2
1 4
2 3
2 4
5
1 4 3 2 4
5
1 5
2 4
3 4
3 5
4 5
5
2 3 1 4 2
7
1 2
1 4
1 5
2 4
2 5
3 5
4 5
Output
2 3
-1 -1
1 3

2 1
-1 -1
4 2
4 6
5 3

1 2
1 2
2 3
3 2

1 3
2 4
3 4
5 3
5 4

1 2
4 2
1 3
2 3
3 2
5 4
5 4
 */