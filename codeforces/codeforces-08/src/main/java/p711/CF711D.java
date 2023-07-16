package p711;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF711D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt() - 1;
        }
        System.out.println(solve(n, a));
    }

    private static final int MOD = (int) (1e9 + 7);

    private static String solve(int n, int[] to) {
        long ans = 1;

        int[] time = new int[n];
        int clock = 1;
        int n0 = n;
        for (int i = 0; i < n; i++) {
            if (time[i] > 0) {
                continue;
            }
            // for x, t := range time { ... }
            // 注意 go 的 x 不会在循环内部变化
            for (int x = i, t0 = clock; x >= 0; x = to[x]) {
                if (time[x] > 0) {
                    if (time[x] >= t0) {
                        int sz = clock - time[x];
                        n0 -= sz;
                        ans = ans * (quickPow(2, sz) - 2) % MOD;
                    }
                    break;
                } else {
                    time[x] = clock;
                    clock++;
                }
            }
        }
        ans = (ans * quickPow(2, n0) % MOD + MOD) % MOD;
        return String.valueOf(ans);
    }

    // 模下的 a^b
    private static long quickPow(long a, long b) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * a % MOD;
            }
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }
}
/*
D. Directed Roads
https://codeforces.com/contest/711/problem/D

灵茶の试炼 2023-05-25
题目大意：
输入 n(2≤n≤2e5) 和长为 n 的数组 a(1≤a[i]≤n,a[i]≠i)，表示一个 n 点 n 边的无向图（节点编号从 1 开始），点 i 和 a[i] 相连。
你需要给每条边定向（无向变有向），这一共有 2^n 种方案。
其中有多少种方案，可以使图中没有环？
模 1e9+7。

https://codeforces.com/contest/711/submission/207047798
前置题目：
遍历每个环，这个环的贡献为 2^环长 - 2。
不在环上的边可以随意取，贡献为 2^边数。
这些贡献相乘即为答案。
相似题目: 2550. 猴子碰撞的方法数
https://leetcode.cn/problems/count-collisions-of-monkeys-on-a-polygon/
2360. 图中的最长环
https://leetcode.cn/problems/longest-cycle-in-a-graph/
======

input
3
2 3 1
output
6

input
4
2 1 1 1
output
8

input
5
2 4 2 5 3
output
28

4
2 1 4 3
4
 */
