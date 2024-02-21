package p44;

import java.util.Arrays;
import java.util.Scanner;

public class CF44H {
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.next().toCharArray();
        System.out.println(solve());
    }

    private static String solve() {
        long[] f = new long[10];
        Arrays.fill(f, 1);
        for (int i0 = 1; i0 < s.length; i0++) {
            int c = s[i0] & 15;
            long[] g = new long[10];
            for (int i = 0; i < 10; i++) {
                long v = f[i];

                int j = (i + c) / 2;
                g[j] += v;
                if ((i + c) % 2 > 0) {
                    g[j + 1] += v;
                }
            }
            f = g;
        }

        long ans = Arrays.stream(f).sum();
        for (int i = 1; i < s.length; i++) {
            if (s[i - 1] + 1 < s[i] ||
                    s[i - 1] - 1 > s[i]) {
                return String.valueOf(ans);
            }
        }
        return String.valueOf(ans - 1);
    }
}
/*
H. Phone Number
https://codeforces.com/contest/44/problem/H

灵茶の试炼 2022-07-20
题目大意：
输入一个旧号码 s，长度不超过 50，只包含 0~9。
你可以按照如下规则生成一个长度和 s 相同的新号码 t：
1. t[0] = 任意一个 0~9 的数字；
2. t[i] = (t[i-1]+s[i])/2   注意：如果除 2 余 1，t[i] 必须上取整或下取整，否则不变。
输出你可以生成多少个和旧号码不同的新号码。

rating 1700
https://codeforces.com/contest/44/submission/164897245
定义 f[i][j] 表示 t 的前 i 个数字，末尾为 j 的方案数。
我们采用刷表法来计算：用 f[i-1][j] 去计算其他状态，即 f[i][(j+s[i])/2] += f[i-1][j]。
如果 j+s[i] 是奇数就额外计算 f[i][(j+s[i])/2+1] += f[i-1][j]。
初始 f[0][j] = 1。
答案为 sum(f[n]) 或 sum(f[n])-1，取决于能否构造出和旧号码相同的新号码。
如果 abs(s[i-1]-s[i]) > 1，那么一定不会构造出和旧号码相同的新号码。
另外可以滚动数组优化 f 的计算。
注意开 64 位。的一声哭出来（
思考题：答案的上界是多少？如何构造一个让答案最大的输入？
---
目前算出来的上界是 138015464838
对应的输入为 "201001" + "01"*22
======

input
12345
output
48

input
09
output
15
 */
