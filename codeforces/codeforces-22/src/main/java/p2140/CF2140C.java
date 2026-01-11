package p2140;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF2140C {
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
        long s = 0, mx = n - 2 + n % 2;
        long pos = (long) 1e18, neg = (long) 1e18;

        for (int i = 0; i < n; i++) {
            int v = scanner.nextInt();
            if (i % 2 > 0) {
                s -= v;
                mx = Math.max(mx, i + v * 2L - pos);
                neg = Math.min(neg, i - v * 2L);
            } else {
                s += v;
                mx = Math.max(mx, i - v * 2L - neg);
                pos = Math.min(pos, i + v * 2L);
            }
        }
        out.println(s + mx);
    }
}
/*
C. Ultimate Value
https://codeforces.com/contest/2140/problem/C

灵茶の试炼 2025-10-15
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) 和长为 n 的数组 a(1≤a[i]≤1e9)。
定义 f(a) = cost + (a1-a2+a3-a4...an)，cost 初始值为 0。
Alice 和 Bob 玩游戏，Alice 先手。
每回合，玩家可以结束整个游戏，或者交换 a 中的两个数 a[i] 和 a[j]，并将 cost 增大 |i-j|。
Alice 的目标是最大化 f(a)，Bob 的目标是最小化 f(a)。
假设双方都采取最优策略。输出最终 f(a) 的值。

rating 1500
Bob 操作后，Alice 可以把 Bob 交换的两个数再换回来，这只会让 f(a) 变得更大。
所以 Bob 的最优决策是立刻结束游戏。我是来结束游戏的
所以只有一次交换。
考虑计算 f(a) 交换后的增量的最大值。
如果交换的两个数前面的正负号相同，那么这两个数越远越好，最远距离为 n-2+n%2。
如果交换的两个数前面的正负号不同，我们可以枚举右维护左。
如果 a[i] 前面是负号，那么和一个前面是正号的 a[j] 交换，f(a) 增加了 i-j+2*a[i]-2*a[j]，所以维护左边的 j+2*a[j] 的最小值。
如果 a[i] 前面是正号，那么和一个前面是负号的 a[j] 交换，f(a) 增加了 i-j-2*a[i]+2*a[j]，所以维护左边的 j-2*a[j] 的最小值。
代码 https://codeforces.com/problemset/submission/2140/342707540
代码备份（上面打不开的同学看这个）
======

Input
5
2
1000 1
5
9 9 9 9 9
4
7 1 8 4
6
1 14 1 14 1 15
9
31 12 14 22 89 6 78 25 91
Output
999
13
12
-7
265
 */
