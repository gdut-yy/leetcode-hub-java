package p1931;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CF1931D {
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
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        long ans = 0;
        Map<Long, Integer> cnt = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int v = scanner.nextInt();
            ans += cnt.getOrDefault(getHash((x - v % x) % x, v % y), 0);
            cnt.merge(getHash(v % x, v % y), 1, Integer::sum);
        }
        out.println(ans);
    }

    static long getHash(long x, int y) {
        return x << 32 | y;
    }
}
/*
D. Divisible Pairs
https://codeforces.com/contest/1931/problem/D

灵茶の试炼 2025-10-14
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(2≤n≤2e5) x y(1≤x,y≤1e9) 和长为 n 的数组 a(1≤a[i]≤1e9)。
输出有多少个下标对 (i,j) 同时满足：
1. i < j。
2. a[i]+a[j] 是 x 的倍数。
3. a[i]-a[j] 是 y 的倍数。

rating 1300
如果 a[i]+a[j] 是 x 的倍数，即 a[i] - (-a[j]) 是 x 的倍数，那么 a[i] 和 -a[j] 模 x 同余，即 a[i]%x = (-a[j])%x。
如果 a[i]-a[j] 是 y 的倍数，那么 a[i] 和 a[j] 模 y 同余，即 a[i]%y = a[j]%y。
枚举右，维护左。
类似上场周赛的第三题，用 map 维护 (a[i]%x, a[i]%y) 的出现次数。
统计答案时，计算 map 中的 ((-a[j])%x, a[j]%y) 的个数，即 ((x-a[j]%x)%x, a[j]%y) 的个数。这是为了统一负数和非负数，保证 (-a[j])%x 在 [0,x-1] 中。
代码 https://codeforces.com/problemset/submission/1931/343542975
代码备份（上面打不开的同学看这个）
======

Input
7
6 5 2
1 2 7 4 9 6
7 9 5
1 10 15 3 8 12 15
9 4 10
14 10 2 2 11 11 13 5 6
9 5 6
10 7 6 7 9 7 7 10 10
9 6 2
4 9 7 1 2 2 13 3 15
9 2 3
14 6 1 15 12 15 8 2 15
10 5 7
13 3 3 2 12 11 3 7 13 14
Output
2
0
1
3
5
7
0
 */
