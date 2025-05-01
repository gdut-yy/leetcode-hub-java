package p2009;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF2009F {
    static Scanner scanner = new Scanner(System.in);
    static int n, q;
    static int[] a;

    public static void main(String[] args) {
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            q = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    static long[] s;

    private static String solve() {
        s = new long[n + 1];
        for (int i = 0; i < n; i++) {
            s[i + 1] = s[i] + a[i];
        }

        long[] ans = new long[q];
        for (int i = 0; i < q; i++) {
            long l = scanner.nextLong();
            long r = scanner.nextLong();
            ans[i] = f(r) - f(l - 1);
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }

    static long f(long r) {
        int k = (int) (r / n), i = (int) (r % n);
        if (i <= n - k) {
            return k * s[n] + s[k + i] - s[k];
        }
        return (k + 1L) * s[n] - s[k] + s[i - (n - k)];
    }
}
/*
F. Firefly's Queries
https://codeforces.com/contest/2009/problem/F

灵茶の试炼 2025-01-01
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5，q 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) q(1≤q≤2e5) 和长为 n 的数组 a(1≤a[i]≤1e6)。
定义：
c1 = a，
c2 = a 循环左移一次后的数组，
c3 = a 循环左移两次后的数组，
依此类推。
把这 n 个长为 n 的数组串连起来，得到长为 n^2 的数组 b = c1 + c2 + ... + cn。下标从 1 开始。
然后输入 q 个询问，每个询问输入两个数 L 和 R (1≤L≤R≤n^2)。
输出 b[L] + b[L+1] + ... + b[R]。

rating 1700
对于每个询问，拆分成 f(r) - f(l-1)。
对于 f(r)，设 k=r/n, i=r%n。
那么有 k 个完整的 sum(a)，再加上第 k 个数组的前 i 个元素。这里讨论的下标均从 0 开始。
利用前缀和计算。
代码 https://codeforces.com/contest/2009/submission/298609644
代码备份（洛谷）
======

Input
5
3 3
1 2 3
1 9
3 5
8 8
5 5
4 8 3 2 4
1 14
3 7
7 10
2 11
1 25
1 1
6
1 1
5 7
3 1 6 10 4
3 21
6 17
2 2
1 5
1 14
9 15
12 13
5 3
4 9 10 10 1
20 25
3 11
20 22
Output
18
8
1
55
20
13
41
105
6
96
62
1
24
71
31
14
44
65
15
 */
