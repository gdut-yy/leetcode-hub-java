package p2064;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF2064C {
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
        long negS = 0;
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            if (a[i] < 0) {
                negS -= a[i];
            }
        }

        long ans = negS;
        long posS = 0;
        for (int v : a) {
            if (v < 0) {
                negS += v;
            } else {
                posS += v;
            }
            ans = Math.max(ans, posS + negS);
        }
        out.println(ans);
    }
}
/*
C. Remove the Ends
https://codeforces.com/contest/2064/problem/C

灵茶の试炼 2025-10-20
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) 和长为 n 的数组 a(-1e9≤a[i]≤1e9, a[i]≠0)。
每次操作，你可以选择 a 中的一个数 a[i]，得到 |a[i]| 分。
然后：
如果 a[i] < 0，移除 a[i] 及其右边的所有元素。
否则，移除 a[i] 及其左边的所有元素。
操作直到数组为空。
输出最大总得分。

rating 1300
我们选的是 a 的一个子序列。这个子序列满足什么性质？什么情况是一定不会发生的？
根据题意，不可能左边选了一个负数，右边选了一个正数。所以正负数的位置很重要！
这个性质意味着什么？子序列中的元素，正数在哪边，负数在哪边？
正数必须在负数的左边。
枚举分割线的位置，左边只能选正数，右边只能选负数。
前后缀分解。
代码 https://codeforces.com/contest/2064/submission/343953477
代码备份（上面打不开的同学看这个）
======

Input
3
6
3 1 4 -1 -5 -9
6
-10 -3 -17 1 19 20
1
1
Output
23
40
1
 */
