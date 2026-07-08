package p2202;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF2202B {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        String s = scanner.next();
        if (n % 2 > 0) {
            s = "b" + s;
        }
        for (int i = 1; i < s.length(); i += 2) {
            if (s.charAt(i) != '?' && s.charAt(i) == s.charAt(i - 1)) {
                out.println("NO");
                return;
            }
        }
        out.println("YES");
    }
}
/*
B. ABAB Construction
https://codeforces.com/contest/2202/problem/B

灵茶の试炼 2026-04-13
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) 和长为 n 的字符串 s，只包含 'a'、'b' 和 '?'。
还有一个长为 n 的字符串 t = ababab...
从 t 的两端取字符，直到 t 为空，可以生成一个长为 n 的字符串。
例如 t = ababa，按照下标 1,2,5,3,4 的顺序取字符，得到 abaab。
你需要把每个是 '?' 的 s[i] 替换成 'a' 或者 'b'，得到字符串 s'。
能否从 t 生成 s'？输出 YES 或 NO。

rating 1200
如果 n 是偶数，那么：
- 如果第一个字符取 a，那么 t 剩下 bab..ab，下一个字符只能取 b。
- 如果第一个字符取 b，那么 t 剩下 aba..ba，下一个字符只能取 a。
所以 s 的前两个字符一定是不同的。
然后问题变成规模为 n-2 的子问题，继续判断 s[2:] 的前两个字符是否不同。
如果两个字符都不是 '?' 且相等，则输出 NO。
如果 n 是奇数，那么 t = aba..ba，第一个字符只能取 a。
然后 n-1 是偶数，变成上面的情况。
代码实现时，可以在 n 是奇数时，令 s = "b" + s，从而把奇偶统一起来。
代码 https://codeforces.com/problemset/submission/2202/370831289
代码备份（上面打不开的同学看这个）
======

Input
4
5
ababa
5
baaba
5
?b?ab
6
aa?b?b
Output
YES
NO
YES
NO
 */
