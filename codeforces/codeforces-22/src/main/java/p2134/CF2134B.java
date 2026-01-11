package p2134;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF2134B {
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
        int k = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        long[] ans = new long[n];
        for (int i = 0; i < n; i++) {
            long v = a[i];
            ans[i] = v + v % (k + 1) * k;
        }
        out.println(Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }
}
/*
B. Add 0 or K
https://codeforces.com/contest/2134/problem/B

灵茶の试炼 2025-12-29
题目大意：
输入 T(≤1e3) 表示 T 组数据。所有数据的 n 之和 ≤1e5。
每组数据输入 n(1≤n≤1e5) k(1≤k≤1e9) 和长为 n 的数组 a(1≤a[i]≤1e9)。
你可以执行如下操作至多 k 次：
选择 a 的一个子序列，把其中元素都增加 k（直接修改 a）。
注：子序列不一定连续。
目标是让 gcd(a) > 1。可以证明，这一定可以做到。
输出最终的 a。多解输出任意解。

rating 1200
从特殊到一般，k=1 怎么做？k=2 怎么做？k=3 怎么做？k=4 怎么做？
例如 a[i]=3，k=4。
把 3 增加 3 次 k，我们可以得到 3+3k = 3(k+1)，这是 k+1 的倍数。
又例如 a[i]=7，k=4。
把 7 增加 7%(k+1)=2 次 k，我们可以得到 7+2k = 5 + 2(k+1) = k+1 + 2(k+1) = 3(k+1)，这是 k+1 的倍数。
一般地，把 a[i] 增加 a[i]%(k+1) 次 k，我们可以得到 k+1 的倍数。这样 GCD 就是 k+1 > 1 了。
由于 a[i]%(k+1) <= k，所以这个构造方案满足要求。
代码 https://codeforces.com/contest/2134/submission/342856033
代码备份（上面打不开的同学看这个）
======

Input
8
3 3
2 7 1
4 5
2 9 16 14
4 1
1 2 3 4
5 2
5 6 7 8 9
2 10
7 9
1 1000000000
1
1 371
1000000000
3 6
1 3 5
Output
8 10 10
7 14 21 14
2 2 4 4
9 6 9 12 9
77 99
1000000000000000001
1000000000
25 15 5
 */
