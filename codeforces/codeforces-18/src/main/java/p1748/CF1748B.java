package p1748;

import java.util.Scanner;

public class CF1748B {
    static int n;
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            s = scanner.next().toCharArray();
            System.out.println(solve());
        }
    }

    private static String solve() {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int[] cnt = new int[10];
            int k = 0, maxC = 0;
            for (int j = i; j < n; j++) {
                int v = s[j] - '0';

                if (cnt[v] == 10) break;
                if (cnt[v] == 0) k++;
                cnt[v]++;
                maxC = Math.max(maxC, cnt[v]);
                if (maxC <= k) ans++;
            }
        }
        return String.valueOf(ans);
    }
}
/*
B. Diverse Substrings
https://codeforces.com/contest/1748/problem/B

灵茶の试炼 2024-01-22
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤1e5。
每组数据输入 n(1≤n≤1e5) 和长为 n 字符串 s，只包含字符 '0' 到 '9'。
输出 s 有多少个连续子串 t，满足 t 中每个字符的出现次数，都不超过 t 中的字符种类数。

rating 1400
每种数字至多 10 个，所以子串的长度至多 100。
暴力枚举所有长度至多为 100 的子串即可。
优化：维护字符最大出现次数和字符种类数。
https://codeforces.com/problemset/submission/1748/242085912
======

input
7
1
7
2
77
4
1010
5
01100
6
399996
5
23456
18
789987887987998798
output
1
2
10
12
10
15
106
 */
