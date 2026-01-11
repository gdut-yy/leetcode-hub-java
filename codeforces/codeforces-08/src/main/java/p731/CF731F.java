package p731;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF731F {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        final int mx = 200001;
        long[] s = new long[mx];
        long ans = 0;

        for (int i = 0; i < n; i++) {
            int v = scanner.nextInt();
            s[v]++;
        }

        for (int i = 2; i < mx; i++) {
            s[i] += s[i - 1];
        }

        for (int x = 1; x < mx; x++) {
            if (s[x] == s[x - 1]) {
                continue;
            }
            long res = 0;
            for (int j = x; j < mx; j += x) {
                res += (s[Math.min(j + x, mx) - 1] - s[j - 1]) * j;
            }
            ans = Math.max(ans, res);
        }

        out.println(ans );
    }
}
/*
F. Video Cards
https://codeforces.com/contest/731/problem/F

灵茶の试炼 2025-11-19
题目大意：
输入 n(1≤n≤2e5) 和长为 n 的数组 a(1≤a[i]≤2e5)。
选择 a 中的一个数 x = a[i]，然后把其余元素 a[j] 都修改为 <= a[j] 且是 x 的倍数的数。
输出修改后的 sum(a) 的最大值。

rating 1900
例如 x=3，那么在 [0,3) 中的数都要变成 0，在 [3,6) 中的数都要变成 3，在 [6,9) 中的数都要变成 6，依此类推。
枚举 x，用前缀和计算区间 [x,2x), [2x,3x), ... 中的元素个数，乘以相应的 kx，即为修改后的 sum(a)。
根据调和级数，时间复杂度为 O(n + U log U)，其中 U=max(a)<=2e5。
代码 https://codeforces.com/contest/731/submission/349354594
代码备份（上面打不开的同学看这个）
======

Input
4
3 2 15 9
Output
27

Input
4
8 2 2 7
Output
18
 */
