package p547;

import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class CF547B {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int[] left = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        st.push(-1);
        for (int i = 0; i < n; i++) {
            while (st.size() > 1 && a[st.peek()] >= a[i]) {
                st.pop();
            }
            left[i] = st.peek();
            st.push(i);
        }

        st.clear();
        st.push(n);
        int[] right = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (st.size() > 1 && a[st.peek()] >= a[i]) {
                st.pop();
            }
            right[i] = st.peek();
            st.push(i);
        }

        int[] ans = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int size = right[i] - left[i] - 1;
            ans[size] = Math.max(ans[size], a[i]);
        }
        for (int i = n - 1; i > 0; i--) {
            ans[i] = Math.max(ans[i], ans[i + 1]);
        }

        StringBuilder output = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            output.append(ans[i]).append(" ");
        }
        return output.toString();
    }
}
/*
B. Mike and Feet
https://codeforces.com/contest/547/problem/B

灵茶の试炼 2023-01-11
题目大意：
输入 n(n≤2e5) 和长为 n 的数组 a(1≤a[i]≤1e9)。
定义 f(x) 为 a 中「长为 x 的连续子数组的最小值」的最大值。
输出 f(1), f(2), ..., f(n)。

https://codeforces.com/problemset/submission/547/188764909
提示 1：考虑每个数的贡献。
提示 2：用单调栈算出每个数 v 作为最小值的范围最大是多少，设范围最大为 size，那么所有 x <= size 的 f(x) 都应维护下最大值 v。但这样太慢了，除非你用线段树区间更新。
提示 3：实际上没有必要用线段树，只需要更新 f(size) 的最大值，最后再倒着遍历 f，把最大值从右向左推过去就好了（即后缀最大值）。
======

input
10
1 2 3 4 5 4 3 2 1 6
output
6 4 4 3 3 2 2 1 1 1
 */
