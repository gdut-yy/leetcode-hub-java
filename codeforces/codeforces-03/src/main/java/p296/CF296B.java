package p296;

import java.util.Scanner;

public class CF296B {
    static int n;
    static char[] s, t;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        s = scanner.next().toCharArray();
        t = scanner.next().toCharArray();
        System.out.println(solve());
    }

    static final int MOD = (int) (1e9 + 7);

    private static String solve() {
        long same = 1;
        boolean le = false, gr = false;

        for (int i = 0; i < n; i++) {
            char v = s[i], w = t[i];
            if (v == '?' && w == '?') {
                same = same * 10 % MOD;
            } else if (v != '?' && w != '?') {
                if (v < w) {
                    le = true;
                } else if (v > w) {
                    gr = true;
                }
            }
        }

        long ans = 1;
        int q = 0;
        for (char c : s) if (c == '?') q++;
        for (char c : t) if (c == '?') q++;
        while (q-- > 0) {
            ans = ans * 10 % MOD;
        }
        if (le && gr) {
            return String.valueOf(ans);
        }

        long res1 = 1, res2 = 1;
        for (int i = 0; i < n; i++) {
            char v = s[i], w = t[i];
            if (v == '?') {
                if (w == '?') {
                    res1 = res1 * 55 % MOD;
                    res2 = res2 * 55 % MOD;
                } else {
                    res1 = res1 * (w - '0' + 1) % MOD;
                    res2 = res2 * ('9' - w + 1) % MOD;
                }
            } else if (w == '?') {
                res1 = res1 * ('9' - v + 1) % MOD;
                res2 = res2 * (v - '0' + 1) % MOD;
            }
        }
        if (!gr) ans -= res1;
        if (!le) ans -= res2;
        if (!le && !gr) ans += same;
        ans = (ans % MOD + MOD) % MOD;
        return String.valueOf(ans);
    }
}
/*
B. Yaroslav and Two Strings
https://codeforces.com/contest/296/problem/B

灵茶の试炼 2024-04-11
题目大意：
输入 n(1≤n≤1e5) 和两个长为 n 的字符串 s 和 t，只包含 '0' 到 '9' 以及 '?'。
你需要把所有 '?' 都替换成 '0' 到 '9' 中的数字字符。
替换后，如果存在 i 和 j 使得 s[i] > t[i] 和 s[j] < t[j] 同时成立，则称 s 和 t 不可比。
有多少种替换 '?' 的方法，可以使 s 和 t 不可比？模 1e9+7。

rating 2000
正难则反。
用所有方案数减去可比方案数，即为答案。
设 '?' 的总个数为 q，则所有方案数为 10^q。
对于可比方案数，分为 s <= t 和 s >= t 讨论。
对于 s <= t，相当于每个 s[i] <= t[i]，由于每一位都是独立的，可以根据乘法原理，计算处每一位的方案数再相乘。
对于 s >= t 也同理。
注意如果同时统计 s <= t 和 s >= t，要减去重复统计的 s = t 的情况。
https://codeforces.com/problemset/submission/296/255937023
======

Input
2
90
09
Output
1

Input
2
11
55
Output
0

Input
5
?????
?????
Output
993531194

10
104?3?1??3
?1755?1??7

91015750
 */
