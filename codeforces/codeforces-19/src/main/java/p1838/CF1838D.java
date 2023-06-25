package p1838;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.TreeSet;

public class CF1838D {
    static int n, q;
    static String s;
    static int[] x;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        q = scanner.nextInt();
        s = scanner.next();
        x = new int[q];
        for (int i = 0; i < q; i++) {
            x[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static final char[] LR = "()".toCharArray();

    // https://codeforces.com/contest/1838/submission/208514429
    private static String solve() {
        char[] cs = s.toCharArray();
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            if (cs[i] != LR[i % 2]) {
                set.add(i);
            }
        }

        String[] ans = new String[q];
        for (int i = 0; i < q; i++) {
            int xi = x[i] - 1;
            // '(' 00101000 40
            // ')' 00101000 41
            cs[xi] ^= 1;
            if (cs[xi] != LR[xi % 2]) {
                set.add(xi);
            } else {
                set.remove(xi);
            }

            // 奇数长度不可能成立
            if (n % 2 == 1) {
                ans[i] = "NO";
            } else if (set.isEmpty()) {
                ans[i] = "YES";
            } else {
                ans[i] = set.first() % 2 > set.last() % 2 ? "YES" : "NO";
            }
        }
        return String.join(System.lineSeparator(), ans);
    }
}
/*
D. Bracket Walk
https://codeforces.com/contest/1838/problem/D

题目大意：
有一个长度为 n 的字符串 s，由字符'('和')'组成。你在这条绳子上行走。你从 s 的第一个字符开始，你想要做一系列的移动，这样你就可以在第 n 个字符结束。在一个步骤中，您可以向左移动一个空格(如果您没有站在第一个字符上)，或者向右移动一个空格(如果您没有站在最后一个字符上)。你可能不会停留在同一个地方，但是你可以访问任何字符，包括第一个和最后一个字符，任意次数。
在每个时间点，你写下你目前站在的角色。如果存在从第一个字符到最后一个字符的移动序列，那么我们就说字符串是可遍历的，这样您写下的字符串就是一个常规的括号序列。
常规括号序列是一种可以通过在序列的原始字符之间插入字符“1”和“+”来转换成正确算术表达式的括号序列。例如,括号序列 "()()", "(())" 定期(结果表达式:“(1)+(1)”、“((1 + 1)+ 1)”),和“)”和“(”。
给你 q 个查询。每次查询都会将字符的值从'('到')'翻转，反之亦然。每次查询后，确定字符串是否可遍历。
查询是累积的，因此每个查询的影响会延续到以后的查询。
---
给定括号字符串 s 和 q 个操作。
每次操作会把某个 s[i] 修改成相反的括号。
每次操作后，回答如下问题：
从 s[1] 走到 s[n]（允许往返走），
路径是否为一个合法括号字符串？
注：修改操作是永久的。

分类讨论
======

input
10 9
(())()()))
9
7
2
6
3
6
7
4
8
output
YES
YES
NO
NO
YES
NO
YES
NO
NO

input
3 2
(()
2
3
output
NO
NO
 */
