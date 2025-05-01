package p2065;

import java.util.Arrays;
import java.util.Scanner;

public class CF2065D {
    static int n, m;
    static int[][] a;
    static long ans;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            a = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = scanner.nextInt();
                }
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        ans = 0;
        long[] row_sum = new long[n];
        for (int i = 0; i < n; i++) {
            for (int j = m; j > 0; j--) {
                long v = a[i][m - j];
                ans += v * j;
                row_sum[i] += v;
            }
        }
        Arrays.sort(row_sum);
        for (int i = 0; i < n; i++) {
            long s = row_sum[i];
            ans += s * i * m;
        }
        return String.valueOf(ans);
    }
}
/*
D. Skibidus and Sigma
https://codeforces.com/contest/2065/problem/D

灵茶の试炼 2025-03-24
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n*m 之和 ≤2e5。
每组数据输入 n m(1≤n*m≤2e5) 和 n 个长为 m 的数组，元素范围 [1,1e6]。
把这 n 个数组重新排列（数组内部的元素不能重排），拼接成一个长为 n*m 的数组 A。
设 A 的前缀和数组为 pre。
输出 sum(pre) 的最大值。

rating 1200
对于元素 x 来说，如果它排在最后面，那么它对分数的贡献是 1，排在倒数第二位，贡献是 2，排在倒数第 i 位，贡献是 i。
由于数组中的元素位置是固定的，我们先假设每个数组都排在最后，把贡献加到答案中。
然后，如果数组 a[i] 改成排在倒数第二位，那么 a[i] 中的每个元素的贡献都增加了 m，一共增加了 sum(a[i]) * m。
这个数组排得越靠前，贡献的增量就越大。
根据排序不等式，把 sum(a[i]) 大的排在前面，sum(a[i]) 小的排在后面。
按照 sum(a[i]) 从小到大排序，那么数组 a[i] 额外产生的贡献是 sum(a[i]) * i * m。
代码 https://codeforces.com/problemset/submission/2065/311600653
代码备份（洛谷）
======

Input
3
2 2
4 4
6 1
3 4
2 2 2 2
3 2 1 2
4 1 2 1
2 3
3 4 5
1 1 9
Output
41
162
72
 */
