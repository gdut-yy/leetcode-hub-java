package p1208;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1208E {
    static int n, w, m;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        w = scanner.nextInt();

        d = new long[w + 1];
        for (int i = 0; i < n; i++) {
            m = scanner.nextInt();
            a = new int[m];
            for (int j = 0; j < m; j++) {
                a[j] = scanner.nextInt();
            }
            solve();
        }
        System.out.println(output());
    }

    static long[] d;

    static void solve() {
        if (m * 2 <= w) {
            long pre = 0, suf = 0;
            for (int i = 0; i < m; i++) {
                int v = a[i];

                pre = Math.max(pre, v);
                d[i] += pre;
                d[i + 1] -= pre;

                suf = Math.max(suf, a[m - 1 - i]);
                d[w - 1 - i] += suf;
                d[w - i] -= suf;
            }
            d[m] += suf;
            d[w - m] -= suf;
        } else {
            int sz = w - m + 1;
            Deque<Integer> q = new ArrayDeque<>();
            for (int i = 0; i < m; i++) {
                int v = a[i];
                while (!q.isEmpty() && v >= a[q.getLast()]) {
                    q.removeLast();
                }
                q.add(i);
                if (q.getFirst() <= i - sz) {
                    q.removeFirst();
                }
                int mx = a[q.getFirst()];
                if (mx < 0 && i < w - m) {
                    mx = 0;
                }
                d[i] += mx;
                d[i + 1] -= mx;
            }
            long suf = 0;
            for (int i = 0; i < w - m; i++) {
                suf = Math.max(suf, a[m - 1 - i]);
                d[w - 1 - i] += suf;
                d[w - i] -= suf;
            }
        }
    }

    private static String output() {
        long[] ans = new long[w];
        ans[0] = d[0];
        for (int i = 1; i < w; i++) {
            ans[i] += ans[i - 1] + d[i];
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
E. Let Them Slide
https://codeforces.com/contest/1208/problem/E

灵茶の试炼 2022-10-19
题目大意：
输入 n(≤1e6) 和 w(≤1e6)，表示一个 n 行 w 列的表格。
然后输入 n 个数组，第 i 个数组放在第 i 行中。
输入的格式为：第一个数字表示数组的长度 m(≤w)，然后输入一个长为 m 的数组，元素范围 [-1e9,1e9]。
保证所有数组的长度之和不超过 1e6。
你可以滑动任意一行的整个数组。
对表格的每一列，输出这一列的元素和的最大值。
注意：每一列是单独计算的，不同列可以有不同的滑动方案。

rating 2200
https://codeforces.com/problemset/submission/1208/176949672
202ms with 读入优化 https://codeforces.com/contest/1208/submission/176961129
考虑每行能给答案带来多少贡献。
如果 2m <= w，那么对于最左边的 m-1 列和最右边的 m-1 列，选择方案是有约束的（前缀最大值/后缀最大值），其余列可以取 max(max(a),0)，这可以用差分数组统计。
如果 2m > w，那么问题变成长为 w-m+1 的滑动窗口最大值。这可以用单调队列实现，做法见力扣 239 题 https://leetcode.cn/problems/sliding-window-maximum/
最后求差分数组的前缀和，即为答案。
======

input
3 3
3 2 4 8
2 2 5
2 6 3
output
10 15 16

input
2 2
2 7 8
1 -8
output
7 8
 */
