package p2010;

import java.util.Scanner;

public class CF2010C2 {
    static String S;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        S = scanner.next();
        System.out.println(solve1());
    }

    private static String solve() {
        int n = S.length();
        char[] s = S.toCharArray();
        int[] z = new int[n];
        int boxL = 0, boxR = 0;
        for (int i = 1; i < (n + 1) / 2; i++) {
            if (i <= boxR) {
                z[i] = Math.min(z[i - boxL], boxR - i + 1);
            }
            while (i + z[i] < n && s[z[i]] == s[i + z[i]]) {
                boxL = i;
                boxR = i + z[i];
                z[i]++;
            }
            if (i + z[i] >= n) {
                return "YES\n" + S.substring(i);
            }
        }
        return "NO";
    }

    private static String solve1() {
        int n = S.length();
        int[] z = z_function(n, S.toCharArray());
        for (int i = 1; i < (n + 1) / 2; i++) {
            if (i + z[i] >= n) {
                return "YES\n" + S.substring(i);
            }
        }
        return "NO";
    }

    static int[] z_function(int n, char[] s) {
        int[] z = new int[n];
        for (int i = 1, l = 0, r = 0; i < n; ++i) {
            if (i <= r && z[i - l] < r - i + 1) {
                z[i] = z[i - l];
            } else {
                z[i] = Math.max(0, r - i + 1);
                while (i + z[i] < n && s[z[i]] == s[i + z[i]]) ++z[i];
            }
            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }
        return z;
    }
}
/*
C2. Message Transmission Error (hard version)
https://codeforces.com/contest/2010/problem/C2

灵茶の试炼 2024-11-27
题目大意：
输入长度 ≤4e5 的字符串 s，只包含小写英文字母。
s 是由两个字符串 x 合并得到的。
如果字符串 x 存在相同的真前缀和真后缀，则可以合并。例如 abca + abca = abcabca。
是否存在这样的字符串 x？
如果不存在，输出 NO。
如果存在，输出 YES 和字符串 x。

rating 1700
答案一定是 s 的一个后缀 s[i:]。
输入的 s 是由两个 s[i:] 合并得到的。
也就是在 s[i:] 的前面，加上一个 s[i:] 的真前缀，这个真前缀的长度等于 n-i。（n 是 s 的长度）
是否存在这样的真前缀？如果 LCP(s, s[i:]) >= n-i，则存在。
计算 LCP(s, s[i:]) 可以用 Z 函数（扩展 KMP）。
注意 i < ceil(n/2)。
代码 https://codeforces.com/contest/2010/submission/293289127
代码备份（洛谷）
也可以计算 s 的最长公共前后缀，只要超过 n/2 就行，这可以用 KMP 解决。
======

Input
abrakadabrabrakadabra
Output
YES
abrakadabra

Input
acacacaca
Output
YES
acacaca

Input
abcabc
Output
NO

Input
abababab
Output
YES
ababab

Input
tatbt
Output
NO
 */
