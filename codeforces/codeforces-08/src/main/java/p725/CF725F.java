package p725;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CF725F {
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
        int n = scanner.nextInt();
        List<Integer> a = new ArrayList<>();
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int a1 = scanner.nextInt(), b1 = scanner.nextInt();
            int a2 = scanner.nextInt(), b2 = scanner.nextInt();
            if (a1 + b1 >= a2 + b2) {
                a.add(a1 + b1);
                a.add(a2 + b2);
                ans += a1 + a2;
            } else if (a1 > b2) {
                ans += a1 - b2;
            } else if (a2 < b1) {
                ans += a2 - b1;
            }
        }
        Collections.sort(a);
        for (int i = 0; i < a.size(); i += 2) {
            ans -= a.get(i);
        }
        out.println(ans);
    }
}
/*
F. Family Photos
https://codeforces.com/contest/725/problem/F

灵茶の试炼 2026-03-06
题目大意：
输入 n(1≤n≤1e5)，表示有 n 堆照片，每堆照片恰好有上下 2 张。
然后输入 n 行，每行 4 个整数 a1 b1 a2 b2，范围 [0,1e9]，分别表示上面的照片对 Alice 和 Bonnie 的幸福值，下面的照片对 Alice 和 Bonnie 的幸福值。
两个人轮流挑选照片，Alice 先手。
每一轮，玩家从某一堆的顶部拿走一张照片，或者选择停一手（什么也不做）。
当所有照片都被取走，或者连续两位玩家都停一手时，游戏结束。
设 Alice 的最终幸福值总和为 x，Bonnie 的最终幸福值总和为 y。Alice 希望让 x-y 尽量大，Bonnie 希望让 y-x 尽量大（也就是让 x-y 尽量小）。
假设两位玩家都采取最优策略，输出 x-y 的最大值。
前置题目：LC1686. 石子游戏 VI

rating 2900
对于两张在不同堆的照片（幸福值为 a1 b1 a2 b1）：
如果 A 拿第一张，B 拿第二张，那么 x-y = a1-b2。
如果 A 拿第二张，B 拿第一张，那么 x-y = a2-b1。
如果 a1-b2 > a2-b1，移项得 a1+b1 > a2+b2。
由此可知，A 和 B 会争夺 a+b 更大的照片。a+b 可以视作一张照片的「综合价值」。
在没有任何约束的情况下，最佳策略是把 a+b 从大到小排序，然后两人依次拿照片。
对于两张在同一堆的照片（上面的幸福值为 a1 b1，下面的幸福值为 a2 b1），分类讨论：
1. a1+b1 >= a2+b2 的情况。
由于两人本来就会按照 a+b 从大到小的顺序拿，所以这和无约束的情况是一样的。
2. a1+b1 < a2+b2 的情况。
如果 A 拿上面的，B 拿下面的，那么 x-y = a1-b2。
如果 B 拿上面的，A 拿下面的，那么 x-y = a2-b1。
由于 a1+b1 < a2+b2，所以 a1-b2 < a2-b1。
对于 A 来说，如果让 B 先拿，x-y 更大（相比 A 先拿）。
对于 B 来说，如果自己先拿了，x-y 更大（相比 A 先拿），这不是自己希望看到的。
所以两个人都不希望自己先拿。在这种情况下，x-y 不变，或者说对于 x-y 的收益是 0。
但如果 a1-b2 > 0，那么 A 最终还是会先拿上面的，毕竟这可以让 x-y 变大。
但如果 a2-b1 < 0，那么 B 最终还是会先拿上面的，毕竟这可以让 x-y 变小。
否则，两人都不会动这一堆的照片。
所以对于 a1+b1 < a2+b2 的情况，两人的策略是直接确定的，（这两张照片）无需参与排序。
相似题目：LC1686. 石子游戏 VI
代码 https://codeforces.com/contest/725/submission/362734279
代码备份（上面打不开的同学看这个）
======

Input
2
12 3 4 7
1 15 9 1
Output
1

Input
2
5 4 8 8
4 12 14 0
Output
4

Input
1
0 10 0 10
Output
-10
 */
