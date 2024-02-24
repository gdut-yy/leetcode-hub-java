package p1898;

import java.util.Scanner;

public class CF1898B {
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
        long ans = 0L;
        int max = a[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            if (a[i] <= max) {
                max = a[i];
                continue;
            }
            // 拆成 k 个数，需要 k-1 次拆分
            int k = (a[i] + max - 1) / max;
            ans += k - 1;
            max = a[i] / k;
        }
        return String.valueOf(ans);
    }
}
/*
B. Milena and Admirer
https://codeforces.com/contest/1898/problem/B

灵茶の试炼 2023-11-28
题目大意：
输入 T(≤2e5) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) 和长为 n 的数组 a(1≤a[i]≤1e9)。
每次操作，你可以选择一个大于 1 的 a[i]，删除它，然后在它的位置上插入 x 和 a[i]-x，其中 x 是一个小于 a[i] 的正整数。
例如 a=[1,10,9]，把 10 分成 3 和 7，数组变成 [1,3,7,9]。
你需要把 a 变成非递减的，即 a[i] <= a[i+1]。
输出最少操作次数。

rating 1500
同: 2366. 将数组排序的最少替换次数
https://leetcode.cn/problems/minimum-replacements-to-sort-the-array/
======

input
4
3
1 3 2
4
1 2 3 4
3
3 2 1
7
1 4 4 3 5 7 6
output
1
0
3
9
 */
