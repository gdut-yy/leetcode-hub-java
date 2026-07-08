package p858;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF858C {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
//        final int VOWEL_MASK = (1 << ('a' - 'a')) | (1 << ('e' - 'a')) | (1 << ('i' - 'a')) | (1 << ('o' - 'a')) | (1 << ('u' - 'a'));
//        System.out.println(Integer.toHexString(VOWEL_MASK << 1));
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        String s = scanner.next();
        int st = 0, cnt = 0;
        boolean diff = false;
        for (int i = 0; i < s.length(); i++) {
            char b = s.charAt(i);
            if (((0x208222 >> (b & 31)) & 1) > 0) {
                cnt = 0;
                diff = false;
                continue;
            }
            cnt++;
            if (cnt > 1 && s.charAt(i) != s.charAt(i - 1)) {
                diff = true;
            }
            if (diff && cnt > 2) {
                out.print(s.substring(st, i) + " ");
                st = i;
                cnt = 1;
                diff = false;
            }
        }
        out.println(s.substring(st));
    }
}
/*
C. Did you mean...
https://codeforces.com/contest/858/problem/C

灵茶の试炼 2026-05-05
题目大意：
输入长度 ≤3000 的字符串 s，只包含小写英文字母。
把 s 划分成尽量少的合法子串。对于一个子串，如果其中有一段连续的长度 >= 3 的辅音段，并且这个辅音段包含不同的字母，那么这个子串不合法。
例如 hellno 不是合法子串，其中的辅音段 lln 长度 >= 3 且包含不同的字母。

rating 1500
第一段越长越好，这样后面需要分出的子串越少。
所以贪心地，只在必须分割的时候才分割，即连续辅音段有不同辅音且辅音个数 >= 3 时分割。
代码 https://codeforces.com/contest/858/submission/373377446
代码备份（上面打不开的同学看这个）
======

Input
hellno
Output
hell no

Input
abacaba
Output
abacaba

Input
asdfasdf
Output
asd fasd f
 */
