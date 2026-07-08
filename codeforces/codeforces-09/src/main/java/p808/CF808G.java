package p808;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF808G {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        String s = scanner.next();
        String t = scanner.next();
        int n = s.length();
        int m = t.length();
        int[] pi = new int[m];
        int match = 0;
        for (int i = 1; i < m; i++) {
            char v = t.charAt(i);
            while (match > 0 && t.charAt(match) != v) {
                match = pi[match - 1];
            }
            if (t.charAt(match) == v) {
                match++;
            }
            pi[i] = match;
        }
        int[] preMax = new int[n + 1];
        int[] f = new int[n + 1];
        outer:
        for (int i = m; i <= n; i++) {
            preMax[i] = preMax[i - 1];
            for (int j = 0; j < m; j++) {
                char b = s.charAt(i - m + j);
                if (b != '?' && b != t.charAt(j)) {
                    continue outer;
                }
            }
            f[i] = preMax[i - m] + 1;
            for (int j = pi[m - 1]; j > 0; j = pi[j - 1]) {
                f[i] = Math.max(f[i], f[i - m + j] + 1);
            }
            preMax[i] = Math.max(preMax[i], f[i]);
        }
        out.println(preMax[n]);
    }
}
/*
G. Anthem of Berland
https://codeforces.com/contest/808/problem/G

灵茶の试炼 2026-04-10
题目大意：
输入长度 ≤1e5 的字符串 s，只包含小写英文字母和问号。
输入长度 ≤1e5 的字符串 t，只包含小写英文字母。
此外，s 和 t 的长度乘积 ≤1e7。
把 s 中的 '?' 替换成小写英文字母，使得 t 在 s 中的出现次数（可以重叠）最多。
输出最大出现次数。

rating 2300
设 t 的长度为 m。
如果 s 的长为 m 的后缀无法等于 t，那么问题变成 s 去掉最后一个字符后，剩余内容最多包含多少个 t。
如果 s 的长为 m 的后缀可以等于 t 呢？由于 t 在 s 中可以重叠出现，我们需要知道 s 中的上一个 t 的位置。
具体地，如果 t 的长为 L 的前后缀相等，那么根据 KMP 算法，「上一个 t 的位置」可以是去掉 s 末尾的 m-L 个字符后，剩余内容的末尾 m 个字符。
根据上述讨论，定义 f[i] 表示在「s 的 [0,i-1] 的末尾 m 个字符等于 t」的前提下，s 的 [0,i-1] 最多包含多少个 t。特别地，如果 s 的 [0,i-1] 的末尾 m 个字符无法等于 t，则 f[i] = 0。
如果 s 的长为 m 的后缀可以等于 t：
1. 如果 t 的长为 L 的前后缀相等，那么去掉 s 末尾的 m-L 个字符，计算剩余内容最多包含多少个 t，即 f[i-m+L]。至于剩余内容的末尾 m 个字符是否真的等于 t，交给子问题 f[i-m+L] 去计算。
2. 直接去掉 s 末尾的 m 个字符，计算剩余内容最多包含多少个 t，即 f 的 [0,i-m] 中的最大值。我们可以额外维护 f 的前缀最大值数组。
最终答案为 max(f)。
如何知道有哪些 L？这可以用 KMP 算法（预处理 t 的 pi 数组）计算 t 的所有 border。
代码 https://codeforces.com/problemset/submission/808/370286540
代码备份（上面打不开的同学看这个）
======

Input
winlose???winl???w??
win
Output
5

Input
glo?yto?e??an?
or
Output
3

Input
??c?????
abcab
Output
2
 */
