package c218;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Abc218_b {
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

    static int[] a;
    static int n;

    static boolean f() {
        int pre = 0;
        for (int i = 0; i < n; i++) {
            int v = a[i];
            if (v - pre > 1) return a[0] > 0;
            if (i == n - 1 || v == a[i + 1]) return a[0] == 0;
            pre = v;
        }
        throw new RuntimeException();
    }

    private static void solve() {
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) a[i] = scanner.nextInt();
        Arrays.sort(a);
        out.println(f() ? "Alice" : "Bob");
    }
}
/*
B - All Minus
https://atcoder.jp/contests/arc218/tasks/arc218_b

灵茶の试炼 2026-05-14
题目大意：
输入 T(≤2e5) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) 和长为 n 的数组 a(0≤a[i]≤1e9)。
Alice 和 Bob 玩游戏。Alice 先手。
每回合：
如果 min(a) > 0，当前玩家选择一个正整数 k，满足 k <= min(a)，然后把所有 a[i] 都减少 k。
如果 min(a) = 0，当前玩家从 a 中删除一个或多个 0。
如果操作之后 a 是空的，当前玩家获胜。
如果双方都采取最优策略，谁会赢？
输出 Alice 或 Bob。

rating
请先完成本周二（前天）的题。（CF1965A）
如果 a[0] >= 2 或者 a[0] = a[1] = 0，那么结论和周二一样，Alice 有多种操作方式，必胜。
否则 Alice 只有一种操作方式。
如果 a[0] = 1，那么下回合 Bob 也只有一种操作方式（删除一个 0），问题变成 n-1 个数的子问题，且 Alice 先手。
如果 a[0] = 0，那么问题变成 n-1 个数的子问题，且 Bob 先手。
如果只剩下一个数，那么这个数不等于 1 时 Alice 获胜。（上面的讨论已经包含这种情况了）
代码 https://atcoder.jp/contests/arc218/submissions/75756918
======

Input 1
5
1
2
3
1 1 1
4
1 2 3 4
7
3 1 4 1 5 9 2
3
218 503 2026
Output 1
Alice
Bob
Bob
Bob
Alice
 */
