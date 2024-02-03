package p754;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF754D {
    static int n, k;
    static int[][] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        a = new int[n][3];
        for (int i = 0; i < n; i++) {
            a[i][0] = scanner.nextInt();
            a[i][1] = scanner.nextInt();
            a[i][2] = i;
        }
        System.out.println(solve());
    }

    private static String solve() {
        int ans = 0, l = 0;
        Arrays.sort(a, Comparator.comparingInt(o -> o[0]));

        PriorityQueue<Integer> h = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            h.add(a[i][1]);
        }
        int d = h.peek() - a[k - 1][0] + 1;
        if (d > ans) {
            ans = d;
            l = a[k - 1][0];
        }
        for (int i = k; i < n; i++) {
            int[] p = a[i];
            if (p[1] > h.peek()) {
                // h.IntSlice[0] = p.r
                // heap.Fix(&h, 0)
                h.remove();
                h.add(p[1]);

                d = h.peek() - p[0] + 1;
                if (d > ans) {
                    ans = d;
                    l = p[0];
                }
            }
        }

        List<Integer> output = new ArrayList<>();
        for (int[] p : a) {
            if (ans == 0 || p[0] <= l && p[1] >= l + ans - 1) {
                output.add(p[2] + 1);
                if (--k == 0) {
                    break;
                }
            }
        }
        return ans + System.lineSeparator()
                + output.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
D. Fedor and coupons
https://codeforces.com/contest/754/problem/D

灵茶の试炼 2022-10-06
题目大意：
输入 n, k (1≤k≤n≤3e5) 和 n 个闭区间，区间左右端点在 [-1e9,1e9] 内，区间的编号从 1 开始。
请你选择 k 个区间，使得这 k 个区间的交集的大小尽量大（只考虑整数），输出这个最大值，以及对应的区间的编号。
---
思考题：如果改成并集呢？

rating 2100
https://codeforces.com/problemset/submission/754/174797228
Python https://codeforces.com/problemset/submission/754/174840684
提示 1：按照区间左端点排序。
提示 2：遍历区间，考虑把第 i 个区间的左端点当作交集的左端点，那么 i 左边这些区间都是可以选的，贪心来说，选其中第 k 大的右端点当作交集的右端点。
提示 3：用最小堆维护第 k 大的右端点。
提示 4：更新答案时，记录对应的左端点，从而知道并集的左右端点。
最后再次遍历区间，输出 k 个包含并集的区间编号。
======

input
4 2
1 100
40 70
120 130
125 180
output
31
1 2

input
3 2
1 12
15 20
25 30
output
0
1 2

input
5 2
1 10
5 15
14 50
30 70
99 100
output
21
3 4
 */