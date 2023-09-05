package c168;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Abc168_e {
    static int n;
    static long[][] ab;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        ab = new long[n][2];
        for (int i = 0; i < n; i++) {
            ab[i][0] = scanner.nextLong();
            ab[i][1] = scanner.nextLong();
        }
        System.out.println(solve());
    }

    private static final int MOD = (int) (1e9 + 7);

    private static String solve() {
        Map<String, Integer> cnt = new HashMap<>();
        Map<String, Integer> cnt2 = new HashMap<>();
        int cnt0 = 0;
        int left = 0;
        for (long[] p : ab) {
            long x = p[0], y = p[1];
            if (x == 0 && y == 0) {
                cnt0++;
                continue;
            }

            // 标准化
            if (y < 0) {
                x = -x;
                y = -y;
            } else if (y == 0) {
                x = Math.abs(x);
            }

            long g = getGCD(Math.abs(x), y);
            x /= g;
            y /= g;

            if (x > 0) {
                // 在第一象限或 x 正半轴的向量
                String key = x + ":" + y;
                cnt.put(key, cnt.getOrDefault(key, 0) + 1);
            } else {
                // 在第二象限或 y 正半轴的向量 => 有可能与 cnt 中的向量垂直
                String key = y + ":" + -x;
                cnt2.put(key, cnt2.getOrDefault(key, 0) + 1);
                left++;
            }
        }

        long ans = 1;
        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            String p = entry.getKey();
            int c = entry.getValue();
            Integer c2 = cnt2.getOrDefault(p, 0);
            ans = ans * (quickPow(2, c) + quickPow(2, c2) - 1) % MOD;
            left -= c2;
        }
        ans = (ans * quickPow(2, left) + cnt0 - 1 + MOD) % MOD;
        return String.valueOf(ans);
    }

    private static long getGCD(long num1, long num2) {
        return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
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
E - ∙ (Bullet)
https://atcoder.jp/contests/abc168/tasks/abc168_e

灵茶の试炼 2022-11-09
题目大意：
输入 n(≤2e5) 和 n 个点 (xi, yi)，范围 [-1e18,1e18]。
你需要从这 n 个点中选出一个非空子集，满足子集中任意两点都有 xi*xj+yi*yj ≠ 0。
子集的大小可以为 1。
输出有多少种不同的选法，模 1e9+7。
注意：可能有重复的点。

https://atcoder.jp/contests/abc168/submissions/36333766
把点看成向量，公式看成向量不能垂直。
根据对称性，可以把在 x 轴下方或 y 轴负半轴的向量，按原点对称。
然后分别统计在坐标原点的、在第一象限或 x 正半轴的（集合 P）、在第二象限或 y 正半轴的（集合 Q)，
其中 P 和 Q 是有可能垂直的，而 P Q 内部的向量是不会垂直的。
P 中的每个向量和其在 Q 中垂直的向量是不能同时选的，把这些找出来，当成一组，计算方案数。
具体见代码。
根据乘法原理。每组的方案数可以相乘。
最后统计 Q 中剩余向量的方案数；以及零向量的方案数，由于零向量只能选一个，所以方案数是 cnt0；别忘了去掉一个都不选的方案。
======

Input 1
3
1 2
-1 1
2 -1
Output 1
5

Input 2
10
3 2
3 2
-1 1
2 -1
-3 -9
-8 12
7 7
8 1
8 2
8 4
Output 2
479
 */