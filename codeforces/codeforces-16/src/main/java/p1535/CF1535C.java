package p1535;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1535C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            String s = scanner.next();
            System.out.println(solve(s));
        }
    }

    private static String solve(String s) {
        int n = s.length();
        long ans = 0L;

        int[] pos = {-1, -1};
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != '?') {
                int digit = s.charAt(i) - '0';
                pos[(i & 1) ^ (digit & 1)] = i;
            }
            ans += i - Math.min(pos[0], pos[1]);
        }
        return String.valueOf(ans);
    }
}
/*
C. Unstable String
https://codeforces.com/contest/1535/problem/C

灵茶の试炼 2023-03-27
题目大意：
输入 t(≤1e4) 表示 t 组数据。所有数据的字符串长度之和 ≤2e5。
每组数据输入一个长度不超过 2e5 的字符串 s，仅包含 '0' '1' '?' 三种字符。
定义灵茶字符串为：把字符串中的每个 ? 都改成 0 或者 1（每个 ? 怎么改是独立的），可以使字符串变成 0101... 或者 1010... 这样的 01 交替字符串。
例如 0，0??10，??? 都是灵茶字符串，而 00，?1??1 不是。
输出 s 中有多少个子串是灵茶字符串。
注：子串是连续的。

https://codeforces.com/problemset/submission/1535/199246246
提示 1：
从左到右遍历 s。
由于 ? 怎么变都可以，重点应该放在值为 0 或 1 的 s[i] 上。
你也可以思考在没有 ? 的情况下，这题要怎么做。
提示 2：
假设 s[i] 是灵茶子串的末尾字符，那么灵茶子串的起始位置最远能到哪？
例如 s = "01101"，如果 s[4] 是灵茶子串的末尾字符，起始位置最远可以到 s[2]。
那么 s[2]~s[4], s[3]~s[4], s[4]~s[4] 这三个都是灵茶子串。
如何记录这样的起始位置呢？
提示 3：
如果没有 ?，上一个 s[i] == s[i-1] 的 i 就是起始位置。
但是由于 ? 的存在，无法判断相邻字符。如何解决？
尝试从 i 和 s[i] 的自身关系去思考，不再依赖其余位置。
提示 4：
定义 pos[0] 为上一个 i 和 s[i] 奇偶性相同的 i，
定义 pos[1] 为上一个 i 和 s[i] 奇偶性不同的 i。
（这里 s[i] != '?'）
例如 s = "01101"，遍历到 s[4] 时，pos[0] = 1，pos[1] = 4
按照 pos 的定义，min(pos[0], pos[1]) + 1 就是起始位置了。
i-min(pos[0], pos[1]) 就是末尾字符为 s[i] 的灵茶子串个数了。
累加 i-min(pos[0], pos[1]) 就是答案。
为方便计算，初始化 pos[0] = pos[1] = -1
======

input
3
0?10
???
?10??1100
output
8
6
25
 */
