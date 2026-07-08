package p1413;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class CF1413C {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int[] a = new int[6];
        for (int i = 0; i < 6; i++) a[i] = scanner.nextInt();
        Arrays.sort(a);
        int n = scanner.nextInt();
        int[] b = new int[n];
        for (int i = 0; i < n; i++) b[i] = scanner.nextInt();
        Arrays.sort(b);
        int ans = (int) 1e9;
        for (int v : a) {
            int[] it = new int[5];
            for (int j = 0; j < n; j++) {
                int mn = b[j] - v;
                if (b[0] - a[0] < mn) continue;
                int mx = b[n - 1] - a[5];
                for (int i = 0; i < 5; i++) {
                    while (it[i] < n && b[it[i]] - a[i + 1] < mn) it[i]++;
                    if (it[i] > 0) mx = Math.max(mx, b[it[i] - 1] - a[i]);
                }
                ans = Math.min(ans, mx - mn);
            }
        }
        out.println(ans);
    }
}
/*
C. Perform Easily
https://codeforces.com/contest/1413/problem/C

灵茶の试炼 2026-04-09
题目大意：
输入长为 6 的数组 a(1≤a[i]≤1e9)。
输入 n(1≤n≤1e5) 和长为 n 的数组 b(1≤b[i]≤1e9)。
对于每个 b[j]，选择一个 a[i]，然后把 b[j] 减少 a[i]。
输出 max(b) - min(b) 的最小值。

rating 1900
枚举 a[i] 和 b[j]，把 b[j] - a[i] 作为最小值，记作 mn。
最大值呢？
注意最大值必须 >= mn，这意味着，对于比较小的 b[k]，只能减去 a[0]。
如果把 b 从小到大排序，那么这些只能减去 a[0] 的数一定是 b 的前缀。
找到其中最后一个只能减去 a[0] 的 b[k]，那么 b[k] - a[0] 就可能是一个最大值。
如何判断 b[k] 是不是只能减去 a[0]？如果 b[k] - a[1] < mn，那么 b[k] 只能减去 a[0]。
同样地，找到最后一个只能减去 a[0] 或 a[1] 的 b[k]，用 b[k] - a[1] 更新最大值的最大值。
依此类推。
找 b[k] 可以二分，也可以双指针。
代码 https://codeforces.com/problemset/submission/1413/370261920
代码备份（上面打不开的同学看这个）
======

Input
1 4 100 10 30 5
6
101 104 105 110 130 200
Output
0

Input
1 1 2 2 3 3
7
13 4 11 12 11 13 12
Output
7
 */
