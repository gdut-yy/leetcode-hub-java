package p2013;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF2013D {
    static int n;
    static long[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextLong();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        List<long[]> st = new ArrayList<>(); // s, c
        for (long v : a) {
            long s = v, c = 1;
            while (!st.isEmpty()) {
                long[] p = st.getLast();
                if ((p[0] - 1) / p[1] + 1 <= s / c) {
                    break;
                }
                s += p[0];
                c += p[1];
                st.removeLast();
            }
            st.add(new long[]{s, c});
        }
        long[] p = st.getLast();
        long ans = (p[0] - 1) / p[1] + 1 - st.getFirst()[0] / st.getFirst()[1];
        return String.valueOf(ans);
    }
}
/*
D. Minimize the Difference
https://codeforces.com/contest/2013/problem/D

灵茶の试炼 2024-10-24
题目大意：
输入 T(≤1e5) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) 和长为 n 的数组 a(1≤a[i]≤1e12)。
有 n 堆石子，每堆石子的个数是 a[i]。
你可以执行任意次如下操作：
把 a[i] 的一颗石子移动到 a[i+1] 中。
输出 max(a) - min(a) 的最小值。

rating 1900
从左到右遍历 a，如果遇到比之前更小的元素，说明我们可以把之前的比较大的石子堆和当前石子堆「匀一匀」。
而遇到更大的元素，则无法操作。
这启发我们用单调栈模拟这个过程。
单调栈保存 pair：参与匀一匀的石子总数 s，石子堆数 c。
这些石子的最大值为 ceil(s/c)，最小值为 floor(s/c)。
最后答案为栈顶的 ceil(s/c) - 栈底的 floor(s/c)。
代码 https://codeforces.com/problemset/submission/2013/283348425
代码备份（洛谷）
======

Input
5
1
1
3
1 2 3
4
4 1 2 3
4
4 2 3 1
5
5 14 4 10 2
Output
0
2
1
1
3
 */
