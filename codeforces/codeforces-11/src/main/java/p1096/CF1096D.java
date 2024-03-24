package p1096;

import java.util.Scanner;

public class CF1096D {
    static int n;
    static String s;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        s = scanner.next();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        long[] dp = new long[4];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int v = a[i];
            if (c == 'h') dp[0] += v;
            if (c == 'a') dp[1] = Math.min(dp[0], dp[1] + v);
            if (c == 'r') dp[2] = Math.min(dp[1], dp[2] + v);
            if (c == 'd') dp[3] = Math.min(dp[2], dp[3] + v);
        }
        return String.valueOf(dp[3]);
    }
}
/*
D. Easy Problem
https://codeforces.com/contest/1096/problem/D

灵茶の试炼 2022-06-23
题目大意：
给你一个 n(<=1e5)，一个长为 n 的字符串 s 和一个长为 n 的数组 a(1<=a[i]<=998244353)。
表示每个 s[i] 都有一个对应的删除代价 a[i]。
请你删除 s 中的某些字符，使得 s 不包含 "hard" 子序列。
输出被删除字母的代价之和的最小值。
子序列不要求连续。s 仅包含小写字母。

rating 1800
写法一：https://codeforces.com/contest/1096/submission/161528827
写法二：https://codeforces.com/contest/1096/submission/161524065
看到子序列就要往 DP 上想。
先来讨论不包含 hard 子序列需要怎么删。
对于第 i 个字符：
不删：那么前 i-1 个字符不能包含 har 子序列（否则就构成 hard 子序列了）。
删：那么前 i-1 个字符可以包含 har 子序列，但不能包含 hard 子序列。
这样思考一番后，定义 dp[i][j=1/2/3/4] 表示删除 s 的前 i 个字符中的某些字符，使得结果不包含 "hard"[:j] 子序列的最小代价（"hard"[:j] 表示 "hard" 的长为 j 的前缀）。
如果 s[i] 是 "hard" 的第 j 个字符，那么有
dp[i][j] = min(dp[i-1][j-1], dp[i-1][j]+a[i])
表示不删 or 删，取二者最小值。
注意对于 dp[i][1] 来说，在遇到 "h" 时必须删除，因此可以把 dp[i][0] 初始化成 inf 从而简化逻辑。
如果 s[i] 不在 "hard" 中，转移就是 dp[i] = dp[i-1]
答案为 dp[n][4]。
实现时可以用滚动数组优化掉第一维。
---
dp[i][1/2/3/4] 分别表示
不能有 h
不能有 ha（可以有 h）
不能有 har（可以有 ha）
不能有 hard（可以有 har）
======

input
6
hhardh
3 2 9 11 7 1
output
5

input
8
hhzarwde
3 2 6 9 4 8 7 1
output
4

input
6
hhaarr
1 2 3 4 5 6
output
0
 */