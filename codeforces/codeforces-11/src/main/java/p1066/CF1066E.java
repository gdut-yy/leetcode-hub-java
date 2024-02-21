package p1066;

import java.util.Scanner;

public class CF1066E {
    static int n, m;
    static char[] s, t;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        s = scanner.next().toCharArray();
        t = scanner.next().toCharArray();
        System.out.println(solve());
    }

    static final int MOD = 998244353;

    private static String solve() {
        long c1 = 0;
        for (char c : t) {
            if (c == '1') c1++;
        }

        long ans = 0;
        long p2 = 1;
        for (int i = 0; i < n && c1 > 0; i++) {
            ans = (ans + (s[n - 1 - i] & 1) * c1 * p2) % MOD;
            c1 -= t[m - 1 - i] & 1;
            p2 = p2 * 2 % MOD;
        }
        return String.valueOf(ans);
    }
}
/*
E. Binary Numbers AND Sum
https://codeforces.com/contest/1066/problem/E

灵茶の试炼 2022-08-19
题目大意：
输入 n (≤2e5) 和 m (≤2e5)，以及两个长度分别为 n 和 m 的二进制数 a 和 b。
然后执行如下计算：
ans = 0
while b > 0:
    ans += a & b
    b >>= 1
输出 ans % 998244353 的结果。

rating 1700
https://codeforces.com/contest/1066/submission/168906109
考虑 a 的每个 1，对答案的贡献是多少？
======

input
4 4
1010
1101
output
12

input
4 5
1001
10101
output
11
 */
