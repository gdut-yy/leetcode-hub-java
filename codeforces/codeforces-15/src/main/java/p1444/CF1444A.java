package p1444;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1444A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            long p = scanner.nextLong();
            long q = scanner.nextLong();
            System.out.println(solve(p, q));
        }
    }

    private static String solve(long p, long q) {
        if (p % q != 0) {
            return String.valueOf(p);
        }

        long ans = 0L;

        long q0 = q;
        // 分解质因数
        for (long i = 2; i * i <= q; i++) {
            // 如果 i 能够整除 N，说明 i 为 N 的一个质因子。
            if (q % i == 0) {
                long x = p;
                while (x % q0 == 0) {
                    x /= i;
                }
                ans = Math.max(ans, x);
                while (q % i == 0) {
                    q /= i;
                }
            }
        }
        // 说明再经过操作之后 N 留下了一个素数
        if (q != 1) {
            while (p % q == 0) {
                p /= q;
            }
            ans = Math.max(ans, p);
        }
        return String.valueOf(ans);
    }
}
/*
A. Division
https://codeforces.com/contest/1444/problem/A

灵茶の试炼 2023-04-18
题目大意：
输入 T(≤50) 表示 T 组数据。
每组数据输入 p(1≤p≤1e18) 和 q(2≤q≤1e9)。
输出最大的 x，满足 p 是 x 的倍数，且 x 不是 q 的倍数。

rating 1500
https://codeforces.com/problemset/submission/1444/202556296
如果 p 不是 q 的倍数，那么答案就是 p。
如果 p 是 q 的倍数，那么考虑质因子分解：
例如 p = 2^5 * 3^4，q = 2^3 * 3^4，通过把 p 中 2 的幂次减小到 2，得到 2^2 * 3^4，就可以满足题目要求了（不是 q 的倍数）
也可以把 p 中 3 的幂次减小到 3，得到 2^5 * 3^3，同样不是 q 的倍数。
遍历 q 的每个质因子（必然都是 p 的质因子），幂次减小后的数的最大值即为答案。
怎么实现呢？模拟的做法是质因子分解（之前周赛讲过），计算质因子的幂次。也可以从 p 开始不断除质因子，直到无法被 q 整除时为止。
======

input
3
10 4
12 6
179 822
output
10
4
179
 */
