package p1095;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1095E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        String s = scanner.next();
        System.out.println(solve(n, s));
    }

    private static String solve(int n, String s) {
        // d 为平衡度，'(' 时 +1，')' 时 -1
        int d = 0;
        // j 表示 d == -1 时第一个 ')' 下标位置
        int j = -1;
        boolean negative = false;
        for (int i = 0; i < n; i++) {
            d += (s.charAt(i) == '(') ? 1 : -1;
            if (d < -2) {
                return "0";
            }
            if (d == -1 && j == -1) {
                j = i;
            }
            if (d < 0) {
                negative = true;
            }
        }

        // d = -2 时，只能修改 [0, j] 区间的 ')'
        if (d == -2) {
            int res = 0;
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == ')') res++;
            }
            return String.valueOf(res);
        }

        // d = 2 时，d 任何时候都不能 < 0
        // 倒着遍历 s，修改 d > 1 的 '('
        if (d == 2 && !negative) {
            int res = 0;
            for (int i = n - 1; i >= 0 && d > 1; i--) {
                if (s.charAt(i) == '(') {
                    d--;
                    res++;
                } else {
                    d++;
                }
            }
            return String.valueOf(res);
        }

        return "0";
    }
}
/*
E. Almost Regular Bracket Sequence
https://codeforces.com/contest/1095/problem/E

灵茶の试炼 2023-02-16
题目大意：
输入 n(≤1e6) 和长为 n 的括号字符串 s。
你必须执行如下操作恰好一次：
选择一个下标 i，如果 s[i] 是 ')'，则修改为 '('，反之亦然。
有多少个不同的 i，可以使 s 是一个合法的括号字符串？
思考：如果可以改两个 s[i] 呢？

rating 1900
https://codeforces.com/contest/1095/submission/193708110
记 c 为 s 的平衡度，遇到 '(' 就 +1，遇到 ')' 就 -1。
中途 c 不能小于 -2。最后 abs(c) 必须为 2。
分类讨论：
如果 c 为 -2，那么要改 ')'，且只能修改从开头到第一次 c=-1 这一段的 )。
如果 c 为 2，那么要改 '('，那么 c 在任何时候都不能小于 0。倒着遍历 s，统计 c > 1 时的 '('，因为一旦 c<=1 了，改成 ')' 肯定不能得到合法括号字符串了。（其实示例一是一个挺好的提示）
======

input
6
(((())
output
3

input
6
()()()
output
0

input
1
)
output
0

input
8
)))(((((
output
0
 */
