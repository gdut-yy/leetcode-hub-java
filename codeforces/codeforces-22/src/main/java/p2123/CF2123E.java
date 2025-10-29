package p2123;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF2123E {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int[] cnt = new int[n + 1];
        for (int v : a) {
            cnt[v]++;
        }
        int[] cc = new int[n + 1];
        int mex = 0;
        while (cnt[mex] > 0) {
            cc[cnt[mex]]++;
            mex++;
        }

        long s = 1;
        for (int i = 0; i < n - mex + 1; i++) {
            s += cc[i];
            out.print(s + " ");
        }
        for (int i = mex; i > 0; i--) {
            out.print(i + " ");
        }
        out.println();
    }
}
/*
E. MEX Count
https://codeforces.com/contest/2123/problem/E

灵茶の试炼 2025-07-22
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) 和长为 n 的数组 a(0≤a[i]≤n)。
定义 mex(A) 为不在数组 A 中的最小非负整数。特别地，mex(空数组)=0。
定义 f(k) 为从 a 中删除恰好 k 个数后，剩余元素的 mex 值的不同个数。
输出 f(0),f(1),f(2),...,f(n)。

rating 1400
O(n) 做法。
如果 k=0，那么答案为 1，即 mex(a)。
如果 k=1 呢？比如 a=[0,0,1,2,2,3,5]，mex(a)=4，其中的 1 和 3 都小于 4，且出现次数只有 1 次。那么删除 1 或者删除 3，都可以让 mex 发生变化。所以 f(1) = 3，即删除 1，删除 3，删除其余数。
如果 k=2，我们可以删除 a 中小于 4 且出现次数为 1 或者 2 的相同元素，每有一种这样的元素，答案就加一。
下文用 mex 表示 mex(a)。
一般地，对于 0 <= k <= n-mex，我们可以：
1. 保留至少 1 个 0~mex-1 中的数，从而让 mex 不变。
2. 删除一组出现次数 <= k 的相同元素，从而让 mex 改变。
所以答案为 1 + (数值 < mex，且出现次数 <= k 的不同数字个数)。
而对于 k > n-mex 的情况，mex 必须改变。
换个角度，考虑保留 0,1,2,... 个元素。
保留 0 个数，答案为 1。即 mex=0
保留 1 个数，答案为 2。即 mex=0 或 1。
依此类推，所以剩余的答案输出 mex, mex-1, mex-2, ..., 1。
代码 https://codeforces.com/contest/2123/submission/329705753
代码备份（Ubuntu Pastebin）
======

Input
5
5
1 0 0 1 2
6
3 2 0 4 5 1
6
1 2 0 1 3 2
4
0 3 4 1
5
0 0 0 0 0
Output
1 2 4 3 2 1
1 6 5 4 3 2 1
1 3 5 4 3 2 1
1 3 3 2 1
1 1 1 1 1 1
 */