package p2004;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class CF2004C {
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
        int n = scanner.nextInt(), k = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = scanner.nextInt();
        Arrays.sort(a);
        int s = 0;
        for (int i = n - 1; i > 0; i -= 2) {
            s += a[i] - a[i - 1];
        }
        out.println(Math.max(s - k, 0) + n % 2 * a[0]);
    }
}
/*
C. Splitting Items
https://codeforces.com/contest/2004/problem/C

灵茶の试炼 2026-05-18
题目大意：
输入 T(≤5e3) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(2≤n≤2e5) k(0≤k≤1e9) 和长为 n 的数组 a(1≤a[i]≤1e9)。
Alice 和 Bob 玩游戏。Alice 先手。
游戏一共 n 个回合。每回合，当前玩家从 a 中取走一个数。
设 Alice 取走的元素和为 A，Bob 取走的元素和为 B。
Alice 希望最大化 (A-B)，鲍勃希望最小化 (A-B)。
双方都采取最优策略。
在开始游戏前，Bob 可以执行如下操作至多 k 次：
把一个 a[i] 增加 1。
输出 A-B 的最小值。

rating 1100
两人如何操作？
Alice 取最大值，Bob 取次大值，交替取。
把 a 从大到小排序。
Bob 为了最小化 A-B，可以让 a[1] 尽量接近 a[0]，但不超过 a[0]（否则 Alice 就取 a[1] 了，这种情况下分数差为 a[1]-a[0]，再把 a[0] 增加白白浪费操作次数）。
其余数对同理。
设 s = a[0]-a[1] + a[2]-a[3] + ...
答案为 max(s-k, 0)，如果 n 是奇数再额外加上 min(a)。
注：增大 min(a) 没有意义，这会导致额外加上的数变得更大。
代码 https://codeforces.com/contest/2004/submission/374475096
代码备份（上面打不开的同学看这个）
======

Input
4
2 5
1 10
3 0
10 15 12
4 6
3 1 2 4
2 4
6 9
Output
4
13
0
0
 */
