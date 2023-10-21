package nc60456;

import java.util.Scanner;

public class NC60456A {
    static String s, t;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.next();
        t = scanner.next();
        System.out.println(solve());
    }

    private static String solve() {
        int n = s.length();
        s = s + s;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (s.startsWith(t, i)) {
                ans++;
            }
        }
        return String.valueOf(ans);
    }
}
/*
牛客周赛 Round 2
小红的环形字符串
https://ac.nowcoder.com/acm/contest/60456/A

题目描述
小红拿到了一个环形字符串 s。所谓环形字符串，指首尾相接的字符串。
小红想顺时针截取其中一段连续子串正好等于 t，一共有多少种截法？
输入描述:
第一行输入字符串 s。
第二行输入字符串 t。
1≤len(t)≤len(s)≤1000
输出描述:
环形字符串 s 截取一段连续子串等于字符串 t 的方案数。

枚举
======

示例1
输入
ababab
aba
输出
3
 */