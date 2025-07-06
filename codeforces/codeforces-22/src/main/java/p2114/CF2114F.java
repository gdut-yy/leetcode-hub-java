package p2114;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF2114F {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    static int x, y, k;

    public static void main(String[] args) {
        int t = scanner.nextInt();
        while (t-- > 0) {
            x = scanner.nextInt();
            y = scanner.nextInt();
            k = scanner.nextInt();
            solve();
        }
        out.flush();
    }

    static final int INF = (int) 1e9;

    private static void solve() {
        int g = (int) getGCD(x, y);
        int ans = calc(x / g, k) + calc(y / g, k);
        if (ans >= INF) {
            ans = -1;
        }
        out.println(ans);
    }

    static int calc(int x, int k) {
        List<Integer> ds = new ArrayList<>();
        for (int d = 1; d * d <= x; d++) {
            if (x % d == 0) {
                ds.add(d);
                if (d * d < x) {
                    ds.add(x / d);
                }
            }
        }
        ds.sort(null);
        int n = ds.size();
        int[] f = new int[n];
        for (int i = 1; i < n; i++) {
            f[i] = INF;
            for (int j = i - 1; j >= 0 && ds.get(i) / ds.get(j) <= k; j--) {
                if (ds.get(i) % ds.get(j) == 0) {
                    f[i] = Math.min(f[i], f[j] + 1);
                }
            }
        }
        return f[n - 1];
    }

    static long getGCD(long num1, long num2) {
        return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
    }
}
/*
F. Small Operations
https://codeforces.com/contest/2114/problem/F

灵茶の试炼 2025-06-19
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 x 之和 ≤1e8，y 之和 ≤1e8。
每组数据输入 x y k (1≤x,y,k≤1e6)。
每次操作，你可以选择一个 [1,k] 中的整数 a，把 x 乘以 a，或者（在 x 能被 a 整除的前提下）把 x 除以 a。
输出把 x 变成 y 的最小操作次数。
如果无法做到，输出 -1。

rating 2000
最优做法是 x -> GCD(x,y) -> y。注：也可以用 LCM 中转，但 GCD 算起来方便。
这等价于 x 和 y 分别变成 g=GCD(x,y) 的最小操作次数之和。
也等价于 x'=x/g 和 y'=y/g 分别变成 1 的最小操作次数之和。
定义 ds 为 x' 的因子列表（从小到大）。
定义 f[i] 表示 ds[i] 变成 1 的最小操作次数。
枚举 j，满足 ds[i]%ds[j]=0 且 ds[i]/ds[j] <= k（即 ds[i] 除以 ds[i]/ds[j] 后变成 ds[j]），那么用 f[j]+1 更新 f[i] 的最小值。
优化：倒着枚举 j，如果 ds[i]/ds[j] > k 则退出内层循环。
初始值 f[0]=0，因子 1 无需操作。
答案为 f[len(ds)-1]。
代码 https://codeforces.com/contest/2114/submission/323205404
代码备份（Ubuntu Pastebin）
======

Input
8
4 6 3
4 5 3
4 6 2
10 45 3
780 23 42
11 270 23
1 982800 13
1 6 2
Output
2
-1
-1
3
3
3
6
-1
 */
