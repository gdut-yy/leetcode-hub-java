package p739;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF739A {
    static int n, m;
    static int[][] lr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        lr = new int[m][2];
        for (int i = 0; i < m; i++) {
            lr[i][0] = scanner.nextInt();
            lr[i][1] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int mi = n;
        for (int[] p : lr) {
            int l = p[0], r = p[1];
            if (mi > r - l + 1) {
                mi = r - l + 1;
            }
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = i % mi;
        }
        return mi + System.lineSeparator()
                + Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
A. Alyona and mex
https://codeforces.com/contest/739/problem/A

灵茶の试炼 2022-06-27
题目大意：
定义 mex(S) 表示不在数组 S 中的最小的非负整数。
输入 n(<=1e5) 和 m(<=1e5)，以及 m 个区间左右端点 l[i] 和 r[i]（下标从 1 开始）。
请你构造一个长为 n 的数组 a，使得 min(mex(a[l[i]..r[i]])) 最大，即最大化这 m 个子数组的 mex 的最小值。
输出最大化的值，以及数组 a。
数组 a 的元素值需要在 [0,1e9] 内。

rating 1700
https://codeforces.com/contest/739/submission/108662174
提示 1：答案至多是多少？
至多是最短的那个子数组的长度。
设这个长度为 L。
提示 2：能不能让所有长度为 L 的子数组，其 mex 都为 L？
可以，构造一个 0, 1, 2, ... L-1, 0, 1, 2, ..., L-1, 0, 1, 2, ... 的周期序列即可。
======

input
5 3
1 3
2 5
4 5
output
2
1 0 2 1 0

input
4 2
1 4
2 4
output
3
5 2 0 1
 */
