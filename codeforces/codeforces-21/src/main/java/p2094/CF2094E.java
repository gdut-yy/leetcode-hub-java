package p2094;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF2094E {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    static int n;
    static int[] a;

    public static void main(String[] args) {
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            solve();
        }
        out.flush();
    }

    private static void solve() {
        int[] cnt = new int[30];
        for (int v : a) {
            for (int m = v; m > 0; m &= m - 1) {
                cnt[Integer.numberOfTrailingZeros(m)]++;
            }
        }
        long ans = 0;
        for (int v : a) {
            long s = 0;
            for (int i = 0; i < 30; i++) {
                int c = cnt[i];
                if ((v >> i & 1) == 0) {
                    s += (long) c << i;
                } else {
                    s += (long) (n - c) << i;
                }
            }
            ans = Math.max(ans, s);
        }
        out.println(ans);
    }
}
/*
E. Boneca Ambalabu
https://codeforces.com/contest/2094/problem/E

灵茶の试炼 2025-06-30
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) 和长为 n 的数组 a(0≤a[i]<2^30)。
下标从 1 开始。
定义 S(k) = (a[k] XOR a[1]) + (a[k] XOR a[2]) + ... + (a[k] XOR a[n])。
输出 S(1),S(2),...,S(n) 中的最大值。

rating 1200
拆位。
统计 0~29 每个比特位有多少个 1，记到长为 30 的 cnt 数组中。
然后枚举 a[i]，计算每个比特位的 1 的个数。
如果 a[i] 第 j 位是 0，那么这一位有 cnt[j] 个 1，否则有 n-cnt[j] 个 1。
代码 https://codeforces.com/contest/2094/submission/325222087
代码备份（Ubuntu Pastebin）
======

Input
5
3
18 18 18
5
1 2 4 8 16
5
8 13 4 5 15
6
625 676 729 784 841 900
1
1
Output
0
79
37
1555
0
 */
