package tenka1_2019;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Tenka1_2019_d {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static final int MOD = 998244353;

    private static String solve() {
        int s = 0;
        long dup = 0;
        long[] f = new long[90001];
        long[] g = new long[90001];
        f[0] = 3;
        g[0] = 3;
        long pow3 = 1;
        for (int v : a) {
            s += v;
            for (int j = s; j >= 0; j--) {
                // 至少装满
                f[j] = (f[j] * 2 + f[Math.max(j - v, 0)]) % MOD;
                if (j >= v) {
                    // 恰好装满
                    g[j] = (g[j] + g[j - v]) % MOD;
                }
            }
            pow3 = pow3 * 3 % MOD;
        }
        if (s % 2 == 0) {
            // 恰好装满 s/2
            dup = g[s / 2];
        }
        long ans = ((pow3 - (f[(s + 1) / 2] - dup)) % MOD + MOD) % MOD;
        return String.valueOf(ans);
    }
}
/*
D - Three Colors
https://atcoder.jp/contests/tenka1-2019/tasks/tenka1_2019_d

灵茶の试炼 2023-10-06
题目大意：
输入 n(3≤n≤300) 和长为 n 的数组 a(1≤a[i]≤300)。
把每个 a[i] 都涂成红/绿/蓝三种颜色中的一种。（相当于把 a 分成 3 个子序列）
记红色元素和为 R，绿色元素和为 G，蓝色元素和为 B。
问：有多少种涂色方案，使得 R,G,B 组成了一个非退化三角形的三条边。模 998244353。
注：非退化三角形即面积为正的三角形，或者说三顶点不共线的三角形。

rating 2237
请看题解：
https://www.luogu.com.cn/blog/endlesscheng/solution-at-tenka1-2019-d
======

Input 1
4
1
1
1
2
Output 1
18

Input 2
6
1
3
2
3
5
2
Output 2
150

Input 3
20
3
1
4
1
5
9
2
6
5
3
5
8
9
7
9
3
2
3
8
4
Output 3
563038556
 */