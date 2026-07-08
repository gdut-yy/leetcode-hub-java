package p1991;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF1991C {
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
        int[] a = new int[n];
        boolean ok = true;
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            if ((a[i] - a[0]) % 2 != 0) {
                ok = false;
            }
        }
        if (!ok) {
            out.println(-1);
            return;
        }
        List<Integer> ans = new ArrayList<>();
        while (true) {
            int mn = a[0], mx = a[0];
            for (int v : a) {
                if (v < mn) mn = v;
                if (v > mx) mx = v;
            }
            if (mn == mx) {
                ans.add(mn);
                break;
            }
            int x = (mn + mx) / 2;
            ans.add(x);
            for (int i = 0; i < n; i++) {
                a[i] = Math.abs(a[i] - x);
            }
        }
        out.println(ans.size());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ans.size(); i++) {
            if (i > 0) sb.append(' ');
            sb.append(ans.get(i));
        }
        out.println(sb);
    }
}
/*
C. Absolute Zero
https://codeforces.com/contest/1991/problem/C

灵茶の试炼 2026-02-24
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) 和长为 n 的数组 a(0≤a[i]≤1e9)。
你可以执行如下操作至多 40 次：
选择一个 [0,1e9] 中的整数 x，把每个 a[i] 变成 |a[i]-x|。
目标是把所有 a[i] 都变成 0。
如果无法做到，输出 -1。
否则输出两行，第一行输出操作次数，第二行输出每次操作的 x。
注意，你不需要最小化操作次数。

rating 1300
首先注意到，如果 a 中有两个数相差 1，那么操作后，这两个数仍然相差 1。
进一步地，如果 a 中有两个数相差奇数，那么操作后，这两个数仍然相差奇数。注：如果 x 选在两数之间，那么奇数 = 偶数 + 奇数（操作后），但是偶数 - 奇数 = 奇数，所以两数相差仍然是奇数。
这意味着，a 中任意两数相差必须是偶数。
如果 x 选在两数之间，那么偶数 = 偶数 + 偶数，或者奇数 + 奇数，无论是何种情况，两数相差仍然是偶数。这是个循环不变量！
所以只需每次选择 x = (min + max) / 2。
由于每次操作都会让极差减半，所以操作 O(log n) 次即可全变成 0，满足题目至多操作 40 次的要求。
代码 https://codeforces.com/contest/1991/submission/363519054
代码备份（上面打不开的同学看这个）
======

Input
5
1
5
2
0 0
3
4 6 8
4
80 40 20 10
5
1 2 3 4 5
Output
1
5
0

3
6 1 1
7
60 40 20 10 30 25 5
-1
 */
