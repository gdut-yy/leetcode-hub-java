package p1560;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF1560F2 {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        char[] s = scanner.next().toCharArray();
        int k = scanner.nextInt();
        int[] cnt = new int[10];
        int d = 0;
        for (char b : s) {
            if (cnt[b - '0'] == 0) d++;
            cnt[b - '0']++;
        }
        if (d <= k) {
            out.println(new String(s));
            return;
        }
        outer:
        for (int i = s.length - 1; ; i--) {
            cnt[s[i] - '0']--;
            if (cnt[s[i] - '0'] == 0) d--;
            s[i]++;
            while (s[i] <= '9') {
                int c = s[i] - '0';
                if (cnt[c] == 0) d++;
                cnt[c]++;
                if (d <= k) {
                    int v = 0;
                    while (d == k && cnt[v] == 0) v++;
                    for (int j = i + 1; j < s.length; j++) {
                        s[j] = (char) ('0' + v);
                    }
                    break outer;
                }
                cnt[c]--;
                if (cnt[c] == 0) d--;
                s[i]++;
            }
        }
        out.println(new String(s));
    }
}
/*
F2. Nearest Beautiful Number (hard version)
https://codeforces.com/contest/1560/problem/F2

灵茶の试炼 2026-04-24
题目大意：
输入 T(≤1e4) 表示 T 组数据。
每组数据输入 n(1≤n≤1e9) 和 k(1≤k≤10)。
输出最小的 >= n 的整数 x，满足 x 中至多有 k 种不同数字，也就是 len(set(str(x))) <= k。

rating 2100
倒序贪心。
维护 0~9 的出现次数，以及有多少个正出现次数。
倒着遍历 s。设 c = s[i]，枚举 s[i] = c+1,c+2,...,9。
如果正出现次数 < k，那么后面全部填 0。
如果正出现次数 = k，那么后面全部填最小的正出现次数对应的数字。
否则继续循环。
如果一开始的正出现次数 <= k，那么答案就是输入的值。
更多相似题目，见 贪心题单 §3.1 节的「倒序贪心」。
代码 https://codeforces.com/contest/1560/submission/372103485
代码备份（上面打不开的同学看这个）
======

Input
6
2021 3
177890 2
34512 3
724533 4
998244353 1
12345678 10
Output
2021
181111
34533
724542
999999999
12345678
 */
