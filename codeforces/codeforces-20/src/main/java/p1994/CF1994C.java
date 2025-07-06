package p1994;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF1994C {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    static int n, x;
    static int[] a;

    public static void main(String[] args) {
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            x = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            solve();
        }
        out.flush();
    }

    private static void solve() {
        long ans = n * (n + 1L) / 2;
        long[] f = new long[n + 1];
        long s = 0;
        int r = n - 1;
        for (int l = n - 1; l >= 0; l--) {
            s += a[l];
            while (s > x) {
                s -= a[r];
                r--;
            }
            if (r < n - 1) {
                f[l] = f[r + 2] + 1;
                ans -= f[l];
            }
        }
        out.println(ans);
    }
}
/*
C. Hungry Games
https://codeforces.com/contest/1994/problem/C

灵茶の试炼 2025-06-04
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) x(1≤x≤1e9) 和长为 n 的数组 a(1≤a[i]≤1e9)。
对于 a 的一个连续非空子数组 b，执行如下过程：
初始化 s = 0。
从左到右遍历 b：
1. 把 s 增加 b[i]。
2. 如果增加后 s > x，则把 s 重置为 0；否则 s 不变。
3. 继续遍历下一个数。
如果遍历结束后 s > 0，则称 b 为好子数组。
输出 a 中有多少个好子数组。

rating 1600
正难则反，计算有多少个子数组，在遍历结束后 s = 0。
左端点为 i 的子数组，对应的右端点有多少个，使得遍历结束后 s = 0？
如果从 i 开始，遍历到 j 时 s=0，则下一步从 j+1 开始重新计算。连一条从 i 到 j+1 的边，我们会得到一个 DAG。
从 i 开始，每走一步，就说明找到了一个 s=0 的子数组。于是问题变成 DAG 上最长路的长度。
把从 i 开始的最大移动步数记作 f[i]。
倒着 DP，枚举 i，用滑动窗口维护 j，那么 f[i] = f[j+1] + 1。
答案为 n*(n+1)/2 - sum(f)。
注意下面代码 j+1 才是 s=0 的情况，所以是 f[i] = f[j+2] + 1。
代码 https://codeforces.com/contest/1994/submission/322604816
代码备份（洛谷）
======

Input
5
4 2
1 1 1 1
3 2
1 2 3
1 6
10
6 3
1 2 1 4 3 8
5 999999999
999999999 999999998 1000000000 1000000000 500000000
Output
8
2
0
10
7
 */
