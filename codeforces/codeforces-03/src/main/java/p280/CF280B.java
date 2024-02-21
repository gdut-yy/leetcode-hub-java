package p280;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class CF280B {
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
        int ans = 0;
        Deque<Integer> st = new ArrayDeque<>();
        for (int v : a) {
            while (!st.isEmpty() && st.peek() < v) {
                ans = Math.max(ans, st.pop() ^ v);
            }
            if (!st.isEmpty()) {
                ans = Math.max(ans, st.peek() ^ v);
            }
            st.push(v);
        }
        return String.valueOf(ans);
    }
}
/*
B. Maximum Xor Secondary
https://codeforces.com/contest/280/problem/B

灵茶の试炼 2022-08-05
题目大意：
输入 n(2≤n≤1e5) 和长为 n 的数组 a(1≤a[i]≤1e9)，a 不含重复元素。
求 a 的所有长度至少为 2 的子数组 b 中，“b 的最大值异或 b 的次大值”的最大值。
如果改成“b 的最大值异或 b 的最小值”的最大值要怎么做？ @Hush

rating 1800
https://codeforces.com/contest/280/submission/167043237
枚举每个 a[i] 作为次大值，找 a[i] 左边和右边最近的比 a[i] 大的数，作为最大值。
用单调栈来做。
实现的时候只需要一个栈+一次遍历，见代码。
======

input
5
5 2 1 4 3
output
7

input
5
9 8 3 5 7
output
15
 */
