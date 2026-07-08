package p1965;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class CF1965A {
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
        for (int i = 0; i < n; i++) a[i] = scanner.nextInt();
        Arrays.sort(a);
        int m = 1;
        for (int i = 1; i < n; i++) {
            if (a[i] != a[i - 1]) a[m++] = a[i];
        }
        int pre = 0;
        for (int i = 0; i < m; i++) {
            int v = a[i];
            if (i == m - 1 || v - pre > 1) {
                if (i % 2 == 0) out.println("Alice");
                else out.println("Bob");
                break;
            }
            pre = v;
        }
    }
}
/*
A. Everything Nim
https://codeforces.com/contest/1965/problem/A

灵茶の试炼 2026-05-12
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) 和长为 n 的数组 a(1≤a[i]≤1e9)。
Alice 和 Bob 玩游戏。Alice 先手。
每回合，当前玩家选择一个正整数 k，满足 k <= min(a)。先把所有 a[i] 都减少 k，然后从 a 中移除所有等于 0 的数。
如果操作之后 a 是空的，当前玩家获胜。
如果双方都采取最优策略，谁会赢？
输出 Alice 或 Bob。

rating 1400
多个重复的 x 和一个 x 是一样的，所以先把 a 排序去重。
如果 a[0] >= 2：
- 如果 Alice 选择 k=a[0] 后必胜，那么选 k=a[0]。
- 如果 Alice 选择 k=a[0] 后必败，那么改成选 k=a[0]-1，留给 Bob 的就是必败态了，Alice 必胜。
- 所以 a[0] >= 2 时 Alice 必胜。
如果 a[0] = 1，那么 Alice 只能选 k=1，问题变成规模为 n-1 的子问题。如果子问题必胜，那么 Alice 必败；如果子问题必败，那么 Alice 必胜。
代码 https://codeforces.com/contest/1965/submission/374143037
代码备份（上面打不开的同学看这个）
======

Input
7
5
3 3 3 3 3
2
1 7
7
1 3 9 7 4 2 100
3
1 2 3
6
2 1 3 4 2 4
8
5 7 2 9 6 3 3 2
1
1000000000
Output
Alice
Bob
Alice
Alice
Bob
Alice
Alice
 */
