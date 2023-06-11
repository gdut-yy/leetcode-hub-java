package p1628;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CF1628B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            String[] a = new String[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.next();
            }
            System.out.println(solve(n, a));
        }
    }

    private static String solve(int n, String[] a) {
        // 全长
        Set<String> set = new HashSet<>();
        // abc 存 ab
        Set<String> prefixSet = new HashSet<>();

        for (String s : a) {
            if (s.length() == 1 || s.charAt(0) == s.charAt(s.length() - 1)) {
                // a / aa / aba
                return "YES";
            } else if (s.length() == 2) {
                // 长度为 2 非回文串
                String find = String.valueOf(s.charAt(1)) + s.charAt(0);
                if (set.contains(find) || prefixSet.contains(find)) return "YES";
            } else {
                // 长度为 3 非回文串
                String find1 = String.valueOf(s.charAt(2)) + s.charAt(1);
                String find2 = find1 + s.charAt(0);
                if (set.contains(find1)) return "YES";
                if (set.contains(find2)) return "YES";
                prefixSet.add(s.substring(0, 2));
            }
            set.add(s);
        }
        return "NO";
    }
}
/*
B. Peculiar Movie Preferences
https://codeforces.com/contest/1628/problem/B

灵茶の试炼 2023-04-06
题目大意：
输入 t(≤100) 表示 t 组数据。所有数据的 n 之和 ≤1e5。
每组数据输入 n(≤1e5) 和长为 n 的字符串数组 a，每个 a[i] 长度都不超过 3，由小写字母组成。
能否从 a 中找到一个非空子序列 b，使得按顺序连接 b 中的字符串，得到的是一个回文串。
输出 YES 或 NO。
注：子序列不要求连续。

https://codeforces.com/contest/1628/submission/157119596
从 a[i] 的长度不超过 3 入手。
如果 a[i] 已经是回文串，那么输出 YES。
剩下是长度为 2 和 3 的非回文串。
如果子序列有超过 2 个字符串，那么首尾必然可以组成回文串。
（思考 2+2, 2+3, 3+2, 3+3，比如 "ab" + ... + "cba" 是回文串，但是 "ab" + "cba" 就已经是回文串了）
所以子序列的长度不会超过 2。
所以问题变成：a 中是否有回文串，或者 a[i] + a[j] 是否为回文串。
后者可以用类似两数之和的做法搞定（哈希表）。
你也可以想想只用数组怎么做。（见代码）
======

input
6
5
zx
ab
cc
zx
ba
2
ab
bad
4
co
def
orc
es
3
a
b
c
3
ab
cd
cba
2
ab
ab
output
YES
NO
NO
YES
YES
NO

3
2
xyy
yx
2
xy
yyx
2
xyz
ayx
YES
YES
NO
 */
