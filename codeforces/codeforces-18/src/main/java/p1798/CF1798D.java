package p1798;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1798D {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
        Arrays.sort(a);
        if (a[0] == 0) return "No";

        long s = 0;
        int i = 0, j = n - 1;
        int[] ans = new int[n];
        int ansI = 0;
        while (i <= j) {
            if (s < 0) {
                s += a[j];
                ans[ansI++] = a[j];
                j--;
            } else {
                s += a[i];
                ans[ansI++] = a[i];
                i++;
            }
        }
        return "Yes" + System.lineSeparator()
                + Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
D. Shocking Arrangement
https://codeforces.com/contest/1798/problem/D

灵茶の试炼 2024-10-22
题目大意：
输入 T(≤5e4) 表示 T 组数据。所有数据的 n 之和 ≤3e5。
每组数据输入 n(1≤n≤3e5) 和长为 n 的数组 a(-1e9≤a[i]≤1e9)。
保证 sum(a) = 0。
重排 a，使得 a 的任意子数组和的绝对值的最大值 < max(a) - min(a)。
如果无法做到，输出 No。
否则输出 Yes 和重排后的 a。

rating 1600
推荐先把 1749. 任意子数组和的绝对值的最大值 做了。
a 的任意子数组和的绝对值的最大值 = max(pre) - min(pre)，其中 pre 是前缀和数组。
如果 a 中只有 0，那么输出 No。
否则一定可以重排，方案如下：
初始化 s = 0，答案 b = 空列表。
如果 s >= 0，那么把剩余元素中的最小值加到 b 的末尾。
如果 s <  0，那么把剩余元素中的最大值加到 b 的末尾。
这可以保证 s 的最小值是 min(a)，s 的最大值严格小于 max(a)，因为我们是在 s<0 的时候才把最大值加到 b 的末尾。
所以有 max(s) - min(s) < max(a) - min(a)。
代码 https://codeforces.com/contest/1798/submission/286538154
======

Input
7
4
3 4 -2 -5
5
2 2 2 -3 -3
8
-3 -3 1 1 1 1 1 1
3
0 1 -1
7
-3 4 3 4 -4 -4 0
1
0
7
-18 13 -18 -17 12 15 13
Output
Yes
-5 -2 3 4
Yes
-3 2 -3 2 2
Yes
1 1 1 -3 1 1 1 -3
Yes
-1 0 1
Yes
4 -4 4 -4 0 3 -3
No
Yes
13 12 -18 15 -18 13 -17
 */
