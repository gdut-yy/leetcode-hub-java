package p1848;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1848D {
    static int s, k;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            s = scanner.nextInt();
            k = scanner.nextInt();
            System.out.println(solve());
        }
    }

    // https://codeforces.com/problemset/submission/1848/214069691
    private static String solve() {
        return String.valueOf(f(s, k));
    }

    static int[] h = {0, 2, 6, 14, 20};

    static long f(long s, long k) {
        if (k == 0) return 0;
        long ans = s * k;
        if (s % 10 == 0) {
            // pass
        } else if (s % 10 != 2) {
            ans = Math.max(ans, f(s + s % 10, k - 1));
        } else {
            // 2 4 8 6
            long m = Math.max((5 * k - s) / 10, 0);
            for (long i = -100; i <= 100; i += 1) {
                if (i + m >= 0 && i + m <= k) {
                    long n = i + m;
                    long g = (s + n / 4 * h[4] + h[(int) (n % 4)]) * (k - n);
                    ans = Math.max(ans, g);
                }
            }
        }
        return ans;
    }
}
/*
D. Vika and Bonuses
https://codeforces.com/contest/1848/problem/D

题目大意：
Vika 最喜欢的化妆品店“金梨”推出了新的奖励制度!
系统的工作原理如下:假设一个客户有 b 笔奖金。在付款之前，客户可以从以下两种选择中选择一种:
- 获得与当前奖金数量相等的折扣，而奖金不会被扣除。
- 累积额外的 x 奖励，其中 x 是数字 b 的最后一个数字。因此，客户的账户将有 b+x 的奖金。
例如，如果客户有 24 个奖金，他可以获得 24 个折扣或累积额外的 4 个奖金，之后他的账户将有 28 个奖金。
目前，Vika 已经积累了 5 笔奖金。
女孩知道，在剩下的时间里，她将在“金梨”门店网络上再购物 k 次。
在熟悉了奖金制度的规则后，Vika 对她能得到的最大总折扣产生了兴趣。
帮助这个女孩回答这个问题。

======

input
6
1 3
11 3
0 179
5 1000000000
723252212 856168102
728598293 145725253
output
4
33
0
9999999990
1252047198518668448
106175170582793129
 */
