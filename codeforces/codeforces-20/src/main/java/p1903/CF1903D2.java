package p1903;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF1903D2 {
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
        int q = scanner.nextInt();
        final int w = 20;
        final int u = 1 << w;
        int[] cnt = new int[u];
        long[] f = new long[u * w];
        long total = 0;
        int maxVal = 0;
        for (int i = 0; i < n; i++) {
            int v = scanner.nextInt();
            total += v;
            maxVal = Math.max(maxVal, v);
            cnt[v]++;
            // 遍历 v 的每个 0
            for (int j = (u - 1) ^ v; j > 0; j &= j - 1) {
                int bit = Integer.numberOfTrailingZeros(j);
                f[v * w + bit] += v & ((1 << bit) - 1); // 累加 v 的低 i 位
            }
        }
        // 算完 SOS DP（从超集转移到当前状态）后：
        // 二进制包含 s 的元素，有 cnt[s] 个
        // 对于二进制包含 s 且第 i 位是 0 的元素，累加这些元素的低 i 位之和，即 f[s][i]
        for (int i = 0; i < w; i++) {
            for (int s = 0; s < u; s++) {
                if ((s & (1 << i)) != 0) {
                    cnt[s ^ (1 << i)] += cnt[s];
                    for (int j = 0; j < w; j++) {
                        f[(s ^ (1 << i)) * w + j] += f[s * w + j];
                    }
                }
            }
        }
        for (int i = 0; i < q; i++) {
            long k = scanner.nextLong();
            long avg = (total + k) / n;
            if (avg >= maxVal) {
                out.println(avg);
                continue;
            }
            int ans = 0;
            for (int j = w - 1; j >= 0; j--) {
                // 现在我们要计算，让答案第 i 位是 1，代价是多少。也就是元素要包含 ans|1<<i
                // 对于（在所有操作之前）已经包含 ans|1<<i 的元素，无需操作，代价是 0。设这样的元素有 cnt[ans|1<<i]] 个
                // 其余 n-cnt[ans|1<<i]] 个元素呢？可以分为两类：
                // 第一类是（在所有操作之前）包含 ans，但不包含 1<<i 的元素。这些元素要增大，比如从 001 到 100，需要 +3，而不是 +4
                // 第二类是（在所有操作之前）不包含 ans 的元素。由于我们已经在之前的循环中增加了这些数，这些元素的低 i 位现在都是 0。这些元素要增大，比如从 000 到 100，直接 +4
                // 我们可以先增加 n-cnt 个 2^i，再减去第一类元素多操作的次数，即第一类元素的低 i 位之和，记作 f[ans][i]
                // 综上，预处理 cnt 和 f，就可以 O(1) 求出让答案第 i 位是 1 的代价：(n-cnt[ans|1<<i])<<i - f[ans][i]
                long cost = (long) (n - cnt[ans | (1 << j)]) * (1 << j) - f[ans * w + j];
                if (cost <= k) {
                    k -= cost;
                    ans |= 1 << j;
                }
            }
            out.println(ans);
        }
    }
}
/*
D2. Maximum And Queries (hard version)
https://codeforces.com/contest/1903/problem/D2

灵茶の试炼 2026-01-16
题目大意：
输入 n(1≤n≤1e6) q(1≤q≤1e6) 和长为 n 的数组 a(0≤a[i]≤1e6)。
然后输入 q 个询问，每个询问输入 k(0≤k≤1e18)。
对于每个询问，计算如下问题：
每次操作，把一个 a[i] 增加 1。
输出操作至多 k 次后，所有 a[i] 的 AND 的最大值。
询问之间互相独立。

rating 2500
先把 上场周赛第四题 做了。https://leetcode.cn/problems/maximum-bitwise-and-after-increment-operations/description/
注意本题和周赛那题的区别，那题要选 m 个数，我的做法没有修改 a[i]，每次要重新计算当前位以及高位的代价。
本题所有数都要选，我们可以在计算代价后，把 k 减少代价（如果这一位可以是 1）。这样后面只需关心低位的代价，不再重新计算高位的代价。
现在我们要计算，让答案第 i 位是 1，代价是多少。也就是元素要包含 ans|1<<i。
对于（在所有操作之前）已经包含 ans|1<<i 的元素，无需操作，代价是 0。设这样的元素有 cnt[ans|1<<i]] 个。
其余 n-cnt[ans|1<<i]] 个元素呢？可以分为两类：
第一类是（在所有操作之前）包含 ans，但不包含 1<<i 的元素。这些元素要增大，比如从 001 到 100，需要 +3，而不是 +4。
第二类是（在所有操作之前）不包含 ans 的元素。由于我们已经在之前的循环中增加了这些数，这些元素的低 i 位现在都是 0。这些元素要增大，比如从 000 到 100，直接 +4。
我们可以先增加 n-cnt 个 2^i，再减去第一类元素多操作的次数，即第一类元素的低 i 位之和，记作 f[ans][i]。
综上，预处理 cnt 和 f，就可以 O(1) 求出让答案第 i 位是 1 的代价：((n-cnt[ans|1<<i]) << i) - f[ans][i]。
预处理 cnt。
先统计每个元素（a[i]）的出现次数，作为 cnt 的初始值。现在 cnt[s] 表示恰好等于 s 的元素个数。
然后计算 SOS DP（从超集转移过来），算完后，「恰好」变成「至少」，即包含 s 的元素有 cnt[s] 个。
预处理 f。
先遍历 a[i] 二进制中的每个 0，对于第 j 个 0，把 f[a[i]][j] 增加 a[i] 的低 j 位。
然后计算 SOS DP（从超集转移过来），算完后，「恰好」变成「至少」，f[s][i] 表示：对于包含 s 且第 i 位是 0 的元素，这些元素的低 i 位之和。
特殊情况：如果 k 能够把每个元素都增大到 >= max(a)，那么答案就是平均值 (sum(a) + k) / n。
代码 https://codeforces.com/problemset/submission/1903/357908112
代码备份（上面打不开的同学看这个）
======

Input
4 2
1 3 7 5
2
10
Output
2
6

Input
3 5
4 0 2
9
8
17
1
3
Output
5
4
7
0
1

Input
1 2
10
5
2318381298321
Output
15
2318381298331
 */
