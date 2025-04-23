package c360;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Abc360_g {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int k = 1;
        List<Integer>[] f = new ArrayList[k + 1];
        for (int i = 0; i < f.length; i++) {
            f[i] = new ArrayList<>();
            f[i].add((int) -2e9);
        }
        for (int v : a) {
            for (int i = k; i >= 0; i--) {
                int j = searchInts(f[i], v);
                if (j < f[i].size()) {
                    f[i].set(j, v);
                } else {
                    f[i].add(v);
                }
                if (i > 0) {
                    List<Integer> g = f[i - 1];
                    j = g.size();
                    int w = g.get(g.size() - 1) + 1;
                    if (j < f[i].size()) {
                        if (f[i].get(j) > w) {
                            f[i].set(j, w);
                        }
                    } else {
                        f[i].add(w);
                    }
                }
            }
        }

        int ans = 0;
        for (List<Integer> g : f) {
            ans = Math.max(ans, g.size() - 1);
        }
        return String.valueOf(ans);
    }

    static int searchInts(List<Integer> a, int key) {
        int l = 0, r = a.size();
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a.get(m) >= key) r = m;
            else l = m + 1;
        }
        return l;
    }
}
/*
G - Suitable Edit for LIS
https://atcoder.jp/contests/abc360/tasks/abc360_g

灵茶の试炼 2025-03-21
题目大意：
输入 n(1≤n≤2e5) 和长为 n 的数组 a(1≤a[i]≤1e9)。
你可以修改 a 中恰好一个数（修改成任意整数）。
输出 a 的最长严格递增子序列（LIS）的长度。
注：子序列不一定连续。
进阶：如果可以改 2 个数呢？改 k 个数呢？改连续 k 个数呢？

下面的做法，可以直接推广到到修改 k 个数。
下标从 0 开始。
同 LIS 的二分做法：
定义 f0[i] 表示长为 i 的上升子序列的末尾元素的最小值。
定义 f1[i] 表示长为 i 的上升子序列的末尾元素的最小值，其中至多修改了 1 个数。
初始值 f0[0] = f1[0] = -inf。
f1 怎么算？分类讨论：
不改 a[i]，和正常 LIS 一样，用二分计算。
改 a[i]，最优做法是在 f0 的最后一个数的基础上 +1，设 +1 后的数为 w。
此时我们可以得到长为 j = len(f0) 的上升子序列，根据 f1 的定义，用 w 更新 f1[j] 的最小值（如果下标越界则在 f1 末尾添加 w）。
注意：改 a[i] 不需要二分，否则不符合 f1 的定义（长度不对）。
由于 f1 依赖上一轮循环的 f0，要先计算 f1 再计算 f0。
代码 https://atcoder.jp/contests/abc360/submissions/63719720
改连续 k 个数：蓝桥杯 2022 省赛 - 最长不下降子序列 https://www.lanqiao.cn/problems/2088/learning/
======

Input 1
4
3 2 2 4
Output 1
3

Input 2
5
4 5 3 6 7
Output 2
4
 */
