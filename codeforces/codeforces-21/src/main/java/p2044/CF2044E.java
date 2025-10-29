package p2044;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF2044E {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int k = scanner.nextInt();
        int lx = scanner.nextInt();
        int rx = scanner.nextInt();
        int ly = scanner.nextInt();
        int ry = scanner.nextInt();

        long ans = 0;
        for (long pk = 1; pk <= ry; pk *= k) {
            long l = Math.max(lx, (ly - 1) / pk + 1);
            long r = Math.min(rx, ry / pk);
            ans += Math.max(r - l + 1, 0);
        }
        out.println(ans);
    }
}
/*
E. Insane Problem
https://codeforces.com/contest/2044/problem/E

灵茶の试炼 2025-08-25
题目大意：
输入 T(≤1e4) 表示 T 组数据。
每组数据输入 k(2≤k≤1e9) l1 r1(1≤l1≤r1≤1e9) l2 r2(1≤l2≤r2≤1e9)。
计算有多少个整数数对 (x,y)，满足 l1≤x≤r1 且 l2≤y≤r2 且 y/x = pow(k,n)，其中 n 是非负整数。

rating 1300
由于 pow(k,n) 是指数增长，n 至多 log(r)。枚举 n，计算有多少个数对。
设 pk = pow(k,n)。由于 y/x = pk，所以 y/pk = x。
l2 ≤ y ≤ r2 两边同时除以 pk，得到 ceil(l2,pk) ≤ x ≤ floor(r2/pk)。
与 l1 ≤ x ≤ r1 联立（计算两个区间的交集），得
max(l1, ceil(l2,pk)) ≤ x ≤ min(r1, floor(r2/pk))。
把满足上式的整数 x 的个数加到答案中。
代码 https://codeforces.com/problemset/submission/2044/333868274
代码备份（上面打不开的同学看这个）
======

Input
5
2 2 6 2 12
2 1 1000000000 1 1000000000
3 5 7 15 63
1000000000 1 5 6 1000000000
15 17 78 2596 20914861
Output
12
1999999987
6
1
197
 */
