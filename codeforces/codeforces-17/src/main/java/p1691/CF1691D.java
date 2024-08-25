package p1691;

import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class CF1691D {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
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
        // v, s
        Deque<long[]> st = new ArrayDeque<>();
        long s = 0;
        for (int v : a) {
            while (!st.isEmpty() && st.peek()[0] <= v) {
                if (st.peek()[1] < s) {
                    return "NO";
                }
                st.pop();
            }
            st.push(new long[]{v, s});
            s += v;
        }

        st.clear();
        s = 0;
        for (int i = n - 1; i >= 0; i--) {
            long v = a[i];
            while (!st.isEmpty() && st.peek()[0] <= v) {
                if (st.peek()[1] < s) {
                    return "NO";
                }
                st.pop();
            }
            st.push(new long[]{v, s});
            s += v;
        }
        return "YES";
    }
}
/*
D. Max GEQ Sum
https://codeforces.com/contest/1691/problem/D

灵茶の试炼 2023-01-16
题目大意：
输入 t(≤1e5) 表示 t 组数据，每组数据输入 n(≤2e5) 和长为 n 的数组 a (-1e9≤a[i]≤1e9)。所有数据的 n 之和不超过 2e5。
请你判断，对数组 a 的每个非空子数组 b，是否都有 max(b) >= sum(b)？
如果是，输出 YES，否则输出 NO。
注：子数组是连续的。
进阶：做到 O(n) 时间复杂度。

rating 1800
https://codeforces.com/contest/1691/submission/189346222
提示 1：看到子数组+min/max，就要想单调栈。
对于本题，假设把 a[i] 当作最大值，那么需要得到能把 a[i] 当作最大值的区间左端点的最小值 L，和右端点的最大值 R。这就需要单调栈了。
提示 2：用前缀和思考。
需要在 L 到 i 之间选一个最小的前缀和，i 到 R 之间选一个最大的前缀和。这样子数组和才最大。
如果子数组和 > a[i]，那么输出 NO。
这可以用 ST 表或者线段树实现。
还有更快的做法吗？
提示 3：继续研究，如果从 i-1 向左走，累加元素和，会得到一个 >0 的元素和的话，那么它 + a[i] > a[i]，就要输出 NO 了。
可以在单调栈出栈的时候，去判断是否有这样的情况。
为什么只需要考虑单调栈的元素？
因为其他的下标已经被之前的元素弹出去了，这个下标到 i-1 的元素和必然是 <= 0 的。
对于从 i+1 向右走的情况也一样，倒序单调栈的同时去判断。
======

input
3
4
-1 1 -1 2
5
-1 2 -3 2 -1
3
2 3 -1
output
YES
YES
NO
 */