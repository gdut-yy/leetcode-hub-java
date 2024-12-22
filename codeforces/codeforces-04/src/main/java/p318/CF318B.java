package p318;

import java.util.Scanner;

public class CF318B {
    static String s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.next();
        System.out.println(solve());
    }

    private static String solve() {
        int n = s.length();
        long ans = 0, cnt = 0;
        for (int i = 5; i <= n; i++) {
            if (s.startsWith("heavy", i - 5)) {
                cnt++;
            } else if (s.startsWith("metal", i - 5)) {
                ans += cnt;
            }
        }
        return String.valueOf(ans);
    }
}
/*
B. Strings of Power
https://codeforces.com/contest/318/problem/B

灵茶の试炼 2024-11-18
题目大意：
输入长度 ≤1e6 的字符串 s，只包含小写英文字母。
输出有多少个子串，以 "heavy" 开头，并以 "metal" 结尾。
进阶：如果给定的开头结尾是更长的字符串呢？

rating 1300
枚举右，维护左。
遍历字符串的同时，维护左边出现过的 "heavy" 的次数 cnt。
每次遇到 "metal"，答案增加 cnt。
代码 https://codeforces.com/contest/318/submission/291720737
代码备份（洛谷）
======

Input
heavymetalisheavymetal
Output
3

Input
heavymetalismetal
Output
2

Input
trueheavymetalissotruewellitisalsosoheavythatyoucanalmostfeeltheweightofmetalonyou
Output
3
 */