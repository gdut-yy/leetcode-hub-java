package p628;

import java.util.Scanner;

public class CF628B {
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.next().toCharArray();
        System.out.println(solve());
    }

    private static String solve() {
        long ans = 0;
        for (int i = 0; i < s.length; i++) {
            char c = s[i];
            if (c % 4 == 0) {
                ans++;
            }
            if (i > 0 && (s[i - 1] * 2 + c) % 4 == 0) {
                ans += i;
            }
        }
        return String.valueOf(ans);
    }
}
/*
B. New Skateboard
https://codeforces.com/contest/628/problem/B

灵茶の试炼 2024-09-16
题目大意：
输入一个长度 ≤3e5 的数字字符串 s。
输出 s 有多少个连续且非空的子串是 4 的倍数。
允许子串有前导零。

rating 1300
如果一个数的最低两位能被 4 整除，那么这个数就能被 4 整除。
枚举所有长为 2 的子串即可。
单独计算长为 1 的子串。
注意，由于 '0' 的 ASCII 值恰好是 4 的倍数，所以不需要写 s[i] - '0'。
(s[i-1] * 10 + s[i]) % 4 可以进一步简化为 (s[i-1] * 2 + s[i]) % 4，这样 byte 不会溢出。
代码 https://codeforces.com/contest/628/submission/280383056
======

Input
124
Output
4

Input
04
Output
3

Input
5810438174
Output
9
 */