package p1364;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1364B {
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
        List<Integer> ans = new ArrayList<>();
        ans.add(a[0]);
        for (int i = 1; i < n - 1; i++) {
            if (a[i - 1] < a[i] == (a[i] > a[i + 1])) {
                ans.add(a[i]);
            }
        }
        ans.add(a[n - 1]);

        return ans.size() + System.lineSeparator()
                + ans.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
B. Most socially-distanced subsequence
https://codeforces.com/contest/1364/problem/B

灵茶の试炼 2024-06-10
题目大意：
输入 T(≤2e4) 表示 T 组数据。所有数据的 n 之和 ≤1e5。
每组数据输入 n(2≤n≤1e5) 和一个 1~n 的排列 p。
选一个 p 的长度至少为 2 的子序列 b，最大化 b 的所有相邻元素的绝对差的和。
即 S=|b1-b2|+|b2-b3|+...
在 S 最大的前提下，b 的长度尽量小。
输出任意一个符合要求的 b。
注：子序列不一定连续。

rating 1300
上升段和下降段只需要考虑首尾元素，例如 p=[1,3,5,4,2] 选 b=[1,5,2]。
选上升段/下降段中间的元素，不会影响 S，所以不选。
结论：选择所有的峰顶峰谷，以及第一个数和最后一个数。
注：在本题的约束下，其实 b 是唯一的。
https://codeforces.com/problemset/submission/1364/264605021
======

Input
2
3
3 2 1
4
1 3 4 2
Output
2
3 1
3
1 4 2
 */
