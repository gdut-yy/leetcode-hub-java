package p1682;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF1682B {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int and = -1;
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            if (a != i) {
                and &= a;
            }
        }
        out.println(and);
    }
}
/*
B. AND Sorting
https://codeforces.com/contest/1682/problem/B

灵茶の试炼 2026-02-02
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(2≤n≤2e5) 和一个 0~n-1 的排列 p。保证 p 不是升序。
对于某个非负整数 X，如果可以通过以下操作若干次将排列 p 排成升序，则称排列 p 是 X-可排序的：
- 选择两个下标 i 和 j，满足 p[i] AND p[j] = X。
- 交换 p[i] 和 p[j]。
输出最大的 X，使得排列 p 是 X-可排序的。
可以证明，存在这样的 X。

rating 1100
先把所有需要排序的数找出来，也就是 p[i] ≠ i 的数。这里 p 的下标从 0 开始。
考虑 X 的每个比特位是 0 还是 1，如果某个需要排序的数 p[i] 的某个比特位是 0，那么 X 的这个比特位不能是 1，否则 p[i] 无法参与排序。（0 AND 任何数都是 0，不能是 1）
这意味着，X 至多为所有需要排序的数的 AND。
下面说明，这个上界是可以取到的。
先找到下标为 AND 的那个数。
如果它不在自己的位置上，比如 AND = 3，但是下标 3 上面是 7，那么就先把 7 和 3 交换，使得下标 3 上面是 3。注意 3 是所有需要排序的数的 AND，所以这里交换的两个数的 AND 一定是 3。这里 3 上面是 7，所以 7 也不在正确的位置上。
然后可以通过如下顺序，交换任意两个需要排序的数。
AND a b
a AND b // 交换 a 和 AND
a b AND // 交换 b 和 AND
AND b a // 交换 a 和 AND（注意最终 AND 的位置没变）
代码 https://codeforces.com/problemset/submission/1682/361066552
代码备份（上面打不开的同学看这个）
======

Input
4
4
0 1 3 2
2
1 0
7
0 1 2 3 5 6 4
5
0 3 2 1 4
Output
2
0
4
1
 */
