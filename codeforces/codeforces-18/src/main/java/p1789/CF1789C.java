package p1789;

import java.util.Scanner;

public class CF1789C {
    static Scanner scanner = new Scanner(System.in);
    static int n, m;
    static int[] a;

    public static void main(String[] args) {
//        n = (int) 2e5;
//        m = (int) 2e5;
//        long ans1 = n * m * (m + 1L);
//        System.out.println(ans1);
//        long ans2 = (long) n * m * (m + 1);
//        System.out.println(ans2);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        long[] sumLen = new long[n + m + 1];
        for (int v : a) {
            sumLen[v] = m + 1;
        }
        for (int i = 1; i <= m; i++) {
            int p = scanner.nextInt() - 1;
            int v = scanner.nextInt();
            sumLen[a[p]] -= m + 1 - i;
            a[p] = v;
            sumLen[v] += m + 1 - i;
        }

        long ans = (long) n * m * (m + 1);
        for (long k : sumLen) {
            ans -= k * (k - 1) / 2;
        }
        return String.valueOf(ans);
    }
}
/*
C. Serval and Toxel's Arrays
https://codeforces.com/contest/1789/problem/C

灵茶の试炼 2025-01-07
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5，m 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) m(1≤m≤2e5) 和长为 n 的数组 a(1≤a[i]≤n+m)，下标从 1 开始。
然后输入 m 个修改操作，每个操作输入 p(1≤p≤n) 和 v(1≤v≤n+m)，表示把 a[p] 改成 v。修改操作是永久的。
保证初始数组，以及每次修改后的数组，都不包含重复元素。
定义如下 m+1 个数组：
A0 = a。
A1 = 第一次修改后的数组 a。
A2 = 第二次修改后的数组 a。
……
Am = 第 m 次修改后的数组 a。
定义 f(i,j) 为 Ai + Aj（这是一个长为 2n 的数组）中的不同元素个数。
输出所有 f(i,j) 之和，其中 0≤i<j≤m。

rating 1500
整体求和的题目，横看成岭侧成峰，考虑单个元素的贡献。
正难则反，先计算所有数组对的长度之和 2n * C(m+1,2) = n * m * (m + 1)，
然后减去包含重复元素的情况。
设元素 x 在 sumLen[x] 个数组中出现过，那么就有 C(sumLen[x],2) 个元素是重复的，要减去。
如何计算 sumLen[x]？可以在读数据的过程中，记录元素上次修改的时间（第几次操作）。
也可以像代码那样，如果 x 在时刻 i 添加到 a 中，假设 x 后面不会被改掉，那么 sumLen[x] 增加 m+1-i。
如果 x 在时刻 i 被替换掉，那么 sumLen[x] 减少 m+1-i。
这样就不需要记录元素上次修改的时间了。
代码 https://codeforces.com/problemset/submission/1789/298480086
代码备份（洛谷）
======

Input
3
3 2
1 2 3
1 4
2 5
1 1
1
1 1
10 10
4 6 9 12 16 20 2 10 19 7
1 3
5 4
2 17
2 18
6 11
7 1
8 17
5 5
5 5
2 2
Output
13
1
705
 */
