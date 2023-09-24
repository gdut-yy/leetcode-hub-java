package diverta2019;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Diverta2019_c {
    static int n;
    static String[] ss;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        ss = new String[n];
        for (int i = 0; i < n; i++) {
            ss[i] = scanner.next();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int ans = 0;
        int ba = 0, a = 0, b = 0;
        for (String s : ss) {
            // ans += strings.Count(s, "AB")
            ans += count(s, "AB");
            if (s.charAt(0) == 'B' && s.charAt(s.length() - 1) == 'A') {
                ba++;
            } else if (s.charAt(s.length() - 1) == 'A') {
                a++;
            } else if (s.charAt(0) == 'B') {
                b++;
            }
        }
        if (ba > 0 && a == 0 && b == 0) {
            ans--;
        }
        ans += ba + Math.min(a, b);
        return String.valueOf(ans);
    }

    // Count counts the number of non-overlapping instances of substr in s.
    private static int count(String txt, String pat) {
        int cnt = 0;
        int idx = txt.indexOf(pat);
        while (idx != -1) {
            cnt++;
            idx = txt.indexOf(pat, idx + pat.length());
        }
        return cnt;
    }
}
/*
C - AB Substrings
https://atcoder.jp/contests/diverta2019/tasks/diverta2019_c

灵茶の试炼 2023-09-04
题目大意：
输入 n(1≤n≤1e4) 和 n 个字符串，每个字符串只包含大写字母，长度在 [2,10] 中。
将这些字符串按照某种顺序相连，得到字符串 s。
问：s 中最多可以有多少个连续子串是 "AB"？
进阶：子串长度为 3
https://codeforces.com/gym/102431/problem/H

首先把每个字符串中的 AB 个数加到答案中。
接着，如果只考虑以 A 结尾的字符串（个数记作 a），或者以 B 开头的字符串（个数记作 b），每一对拼起来可以得到一个 AB，那么答案额外加上 min(a,b)。
然后，考虑以 B 开头且以 A 结尾的字符串（个数记作 ba），这些字符串可以「插入」到上面拼起来的 AB 之间，那么答案额外加上 ba+min(a,b)。
除了一种特殊情况：ba > 0 且 a = 0 且 b = 0，此时答案只能加上 ba-1。
https://atcoder.jp/contests/diverta2019/submissions/45086403
======

Input 1
3
ABCA
XBAZ
BAD
Output 1
2

Input 2
9
BEWPVCRWH
ZZNQYIJX
BAVREA
PA
HJMYITEOX
BCJHMRMNK
BP
QVFABZ
PRGKSPUNA
Output 2
4

Input 3
7
RABYBBE
JOZ
BMHQUVA
BPA
ISU
MCMABAOBHZ
SZMEHMA
Output 3
4
 */