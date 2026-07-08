package p2108;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF2108B {
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
        int x = scanner.nextInt();
        if (x == 0) {
            if (n == 1) {
                out.println(-1);
            } else {
                out.println(n + n % 2 * 3);
            }
        } else if (x == 1) {
            out.println(n + (1 - n % 2) * 3);
        } else {
            int ones = Integer.bitCount(x);
            int ex = Math.max(n - ones, 0);
            out.println(x + ex + ex % 2);
        }
    }
}
/*
B. SUMdamental Decomposition
https://codeforces.com/contest/2108/problem/B

灵茶の试炼 2026-01-26
题目大意：
输入 T(≤1e4) 表示 T 组数据。
每组数据输入 n(1≤n≤1e9) 和 x(0≤x≤1e9)。
构造一个长为 n 的正整数数组 a，使得 a 的异或和等于 x。
输出 sum(a) 的最小值。
无解输出 -1。

rating 1300
分类讨论。
先处理最特殊的 x = 0：
如果 n = 1，那么无解。
否则：
n 是偶数时，填 n 个 1，总和为 n。
n 是奇数时，填 1,2,3 和 n-3 个 1，总和为 n+3。
一般情况：
设 ones 为 x 中的 1 的个数。
我们可以把 x 拆分成 ones 个正数（2 的幂）。
如果 n <= ones，那么答案为理论最小值 x。
否则还有 n-ones 个位置，必须填正数：
- 如果 n-ones 是偶数，那么额外填 n-ones 个 1，总和为 x+n-ones。
- 如果 n-ones 是奇数，怎么填最好呢？像上面那样填 1,2,3？
  还有更优的方案：如果 x > 1，那么可以在 ones 个数中选一个偶数，加一，这样 n-ones 个位置就可以都填 1 了。总和为 x+n-ones+1。
但 x=1 的情况没法这样做，特判 x=1 的情况：
如果 n 是奇数，那么其余 n-1 个位置填 1，总和为 n。
如果 n 是偶数，那么构造 3,2,1,1,... 总和为 n+3。
代码 https://codeforces.com/problemset/submission/2108/359045504
代码备份（上面打不开的同学看这个）
======

Input
8
2 1
3 6
1 0
2 0
5 0
2 27
15 43
12345678 9101112
Output
5
8
-1
2
8
27
55
21446778
 */
