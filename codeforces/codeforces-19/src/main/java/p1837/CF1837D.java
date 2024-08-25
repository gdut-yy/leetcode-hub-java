package p1837;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1837D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            String s = scanner.next();
            System.out.println(solve(n, s));
        }
    }

    private static String solve(int n, String s) {
        char[] cs = s.toCharArray();
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + (cs[i] == '(' ? 1 : -1);
        }
        if (preSum[n] != 0) {
            return "-1";
        }

        // color 只可能为 1,2
        int[] ans = new int[n];
        boolean has1 = false;
        boolean has2 = false;
        for (int i = 0; i < n; i++) {
            if (preSum[i + 1] > 0) {
                ans[i] = 1;
                has1 = true;
            } else if (preSum[i + 1] < 0) {
                ans[i] = 2;
                has2 = true;
            } else {
                ans[i] = ans[i - 1];
            }
        }
        int color = 2;
        // 全为 2 的情况要置为 1
        if (has2 && !has1 || has1 && !has2) {
            color = 1;
            Arrays.fill(ans, 1);
        }
        return color + System.lineSeparator()
                + Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
D. Bracket Coloring
https://codeforces.com/contest/1837/problem/D

灵茶の试炼 2024-01-16
题目大意：
正则括号序列是一种可以通过在序列的原始字符之间插入字符“1”和“+”转换成正确算术表达式的括号序列。例如:
- 括号序列"()()"和"(())"是正则的(结果表达式是:"(1)+(1)"和"((1+1)+1)");
- 括号序列")("，"("和")"则不是。
如果满足以下条件之一，则称为漂亮括号序列:
它是一个规则的括号序列：
- 如果该序列中字符的顺序颠倒，它将变成一个常规的括号序列。
- 例如,括号序列 "()()", "(())", ")))(((", "))()((" 是美丽的。
给你一个括号序列 s。你必须这样给它上色:
- 每个括号都被涂成一种颜色;
- 对于每种颜色，至少有一个括号为该颜色;
- 对于每一种颜色，如果你按照它们出现的顺序写下这种颜色的括号序列，你会得到一个漂亮的括号序列。
根据这些约束，将给定的括号序列 s 涂成最小数量的颜色，或者报告不可能。
---
给定字符串 s，仅包含 '(' 和 ')'
你需要吧 s 拆分成一些子序列，使得每个子序列从左往右读是合法括号序列，或者从右到左读是合法括号序列。
最小化子序列的个数，无法做到输出 -1，否则输出每个 s[i] 所属子序列的编号。

rating 1400
贪心。前缀和。
======

input
4
8
((())))(
4
(())
4
))((
3
(()
output
2
2 2 2 1 2 2 2 1
1
1 1 1 1
1
1 1 1 1
-1
 */
