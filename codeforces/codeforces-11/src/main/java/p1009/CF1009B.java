package p1009;

import java.util.Scanner;

public class CF1009B {
    static String s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.next();
        System.out.println(solve());
    }

    private static String solve() {
        int cnt1 = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') cnt1++;
        }
        String s1 = "1".repeat(cnt1);
        s = s.replace("1", "");
        int i = s.indexOf("2");
        if (i < 0) {
            // s 不含 ‘2’
            return s + s1;
        }
        return s.substring(0, i) + s1 + s.substring(i);
    }
}
/*
B. Minimum Ternary String
https://codeforces.com/contest/1009/problem/B

灵茶の试炼 2023-11-27
题目大意：
输入长度 ≤1e5 的字符串 s，只包含字符 012。
一次操作，你可以交换任意一对相邻的 0 和 1，或者相邻的 1 和 2。
你可以操作任意次。
注意你不能交换相邻的 0 和 2。
输出字典序最小的 s。
进阶：包含字符 0~9
牛客练习赛 116 C https://ac.nowcoder.com/acm/contest/65259/C
官方题解 https://ac.nowcoder.com/discuss/1213989

rating 1400
提示 1
1 可以和 0 交换，也可以和 2 交换，这意味着 1 可以在字符串中的任意位置。
把所有的 1 拿出来，剩下的字符可以交换吗？
提示 2
剩下的字符无法交换。
把这些 1 插哪里最合适？
插在第一个 2 之前最合适。
注意 s 中没有 2 的情况。
https://codeforces.com/contest/1009/submission/234230342
======

input
100210
output
001120

input
11222121
output
11112222

input
20
output
20
 */
