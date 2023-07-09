package p1845;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1845C {
    static String s, l, r;
    static int m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            s = scanner.next();
            m = scanner.nextInt();
            l = scanner.next();
            r = scanner.next();
            System.out.println(solve());
        }
    }

    // https://codeforces.com/contest/1845/submission/211453965
    private static String solve() {
        int n = s.length();

        // 子序列自动机
        // 预处理 s[i] 下一个 '0'~'9' 出现的位置
        int[][] next = new int[n + 1][10];
        Arrays.fill(next[n], n);
        for (int i = n - 1; i >= 0; i--) {
            next[i] = next[i + 1].clone();
            next[i][s.charAt(i) - '0'] = i;
        }

        int cur = -1;
        for (int i = 0; i < m && cur < n; i++) {
            int nxt = 0;
            for (int j = l.charAt(i) - '0'; j <= r.charAt(i) - '0'; j++) {
                nxt = Math.max(nxt, next[cur + 1][j]);
            }
            cur = nxt;
        }
        return cur == n ? "YES" : "NO";
    }
}
/*
C. Strong Password
https://codeforces.com/contest/1845/problem/C

题目大意：
Monocarp 终于鼓起勇气在 ForceCoders 上注册了。他想出了一个手柄，但还在考虑密码。
他希望自己的密码越强越好，所以他提出了以下标准:
- 密码长度应恰好为 m;
- 密码只能由 0 到 9 的数字组成;
- 密码不应该以子序列(不一定是连续的)的形式出现在密码数据库中(以字符串 s 的形式给出)。
Monocarp 还提出了两个长度为 m 的字符串:l 和 r，它们都只由 0 到 9 的数字组成。他希望他的密码的第 i 位在 li 和 ri 之间，包括 li 和 ri。
是否存在一个符合所有条件的密码?

贪心。
======

input
5
88005553535123456
2
50
56
123412341234
3
111
444
1234
4
4321
4321
459
2
49
59
00010
2
10
11
output
YES
NO
YES
NO
YES

1
0111110010000111100101
10
0010100000
1110111100
 */
