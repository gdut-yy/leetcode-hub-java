package p2140;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF2140E1 {
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
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[k];
        for (int i = 0; i < k; i++) {
            a[i] = scanner.nextInt() - 1; // 模拟Go的a[i]--操作
        }
        if (m == 1) {
            out.println(1);
            return;
        }

        int size = 1 << n;
        byte[] f = new byte[size];
        f[1] = 1;

        for (int sz = 2; sz <= n; sz++) {
            if ((n - sz) % 2 == 0) {
                for (int mask = (1 << sz) - 1; mask > 0; mask--) {
                    boolean found = false;
                    for (int i : a) {
                        if (i >= sz) {
                            break;
                        }
                        int part1 = (mask >> (i + 1)) << i;
                        int part2 = mask & ((1 << i) - 1);
                        int newMask = part1 | part2;
                        if (f[newMask] > 0) {
                            f[mask] = 1;
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        f[mask] = 0;
                    }
                }
            } else {
                for (int mask = (1 << sz) - 1; mask > 0; mask--) {
                    boolean allTrue = true;
                    for (int i : a) {
                        if (i >= sz) {
                            break;
                        }
                        int part1 = (mask >> (i + 1)) << i;
                        int part2 = mask & ((1 << i) - 1);
                        int newMask = part1 | part2;
                        if (f[newMask] == 0) {
                            f[mask] = 0;
                            allTrue = false;
                            break;
                        }
                    }
                    if (allTrue) {
                        f[mask] = 1;
                    }
                }
            }
        }

        int ans = size; // 等价于Go中的 1 << n
        for (byte v : f) {
            ans += v;
        }
        out.println(ans);
    }
}
/*
E1. Prime Gaming (Easy Version)
https://codeforces.com/contest/2140/problem/E1

灵茶の试炼 2025-12-18
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 2^n 之和 ≤2^20，所有数据的 m 之和 ≤1e6。
每组数据输入 n(1≤n≤20) m(1≤m≤2) k(1≤k≤n) 和长为 k 的严格递增数组 c(1≤c[i]≤n)，保证 c 的第一个数是 1。
一开始，有一个长为 n 的数组 a，下标从 1 开始。
Alice 和 Bob 玩游戏，Alice 先手：
每回合，当前玩家从 c 中选择一个 i（不超过 a 的长度），然后从 a 中移除 a[i]。
当 a 中只剩一个数时，游戏结束。
令 x 为最后 a 中剩下的数。Alice 希望最大化最终的 x，Bob 则希望最小化。两名玩家均采取最优策略。
你可以设定一开始的数组 a，要求 1≤a[i]≤m。
这一共有 m^n 种方案，每种方案可以得到一个 x。
输出这 m^n 个 x 之和，模 1e9+7。

rating 2200
如果 m=1，答案只能是 1。
下面计算 m=2。从数据范围可知，考虑状压 DP。
定义 f[i][mask] 表示剩下 i 堆石子，每堆石子的个数为 mask（二进制数中的 0 表示 1 个石子，1 表示 2 个石子）时，最终的石子堆是否为 2 个石子。
根据 n-i 的奇偶性可以知道现在是 Alice 还是 Bob 在操作。
如果是 Alice 的回合：枚举移除的石子，递归到 f[i-1][t]（t 怎么算后面细说），如果有一个 f[i-1][t] == true，那么 f[i][mask] 就是 true（必胜态）。否则是 false（必败态）。
如果是 Bob 的回合：枚举移除的石子，递归到 f[i-1][t]，如果有一个 f[i-1][t] == false，那么 f[i][mask] 就是 false。否则是 true。
初始值：f[1][0] = false, f[1][1] = true。
答案：先初始化答案为 2^n（假设最终剩下的都是 1），然后加上满足 f[n][mask] == true 的个数（true 表示剩下的是 2）。
代码实现时，f 的第一个维度可以去掉，内层倒序枚举 mask。
关于 t 的计算，如果去掉 i 位：
mask 的 0~i-1 位保留：mask & ((1<<i) - 1)。
mask 的大于 i+1 位整体右移 1，低位置 0：mask >> (i+1) << i。
二者拼起来，得到 t = (mask >> (i+1) << i) | (mask & ((1<<i) - 1))。
代码 https://codeforces.com/contest/2140/submission/349515284
代码备份（上面打不开的同学看这个）
======

Input
3
2 2
1
1
3 1
2
1 3
3 2
2
1 2
Output
6
1
11
 */
