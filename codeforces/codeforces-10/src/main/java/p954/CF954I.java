package p954;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF954I {
    static char[] s, t;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.next().toCharArray();
        t = scanner.next().toCharArray();
        System.out.println(solve());
    }

    static int m;
    static int[] ans, mp;

    private static String solve() {
        m = t.length;
        ans = new int[s.length - m + 1];
        mp = new int['g'];
        dfs('a', 0);
        return Arrays.stream(ans).map(v -> 6 - v).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }

    static void dfs(int c, int sz) {
        if (c == 'g') {
            int[] pi = new int[m];
            int j = 0;
            for (int i = 1; i < m; i++) {
                int v = mp[t[i]];
                while (j > 0 && mp[t[j]] != v) {
                    j = pi[j - 1];
                }
                if (mp[t[j]] == v) {
                    j++;
                }
                pi[i] = j;
            }

            j = 0;
            for (int i = 0; i < s.length; i++) {
                int v = mp[s[i]];
                while (j > 0 && mp[t[j]] != v) {
                    j = pi[j - 1];
                }
                if (mp[t[j]] == v) {
                    j++;
                }
                if (j == m) {
                    int st = i - m + 1;
                    ans[st] = Math.max(ans[st], sz);
                    j = pi[j - 1];
                }
            }
            return;
        }
        mp[c] = sz;
        dfs(c + 1, sz + 1);
        for (int j = 0; j < sz; j++) {
            mp[c] = j;
            dfs(c + 1, sz);
        }
    }
}
/*
I. Yet Another String Matching Problem
https://codeforces.com/contest/954/problem/I

灵茶の试炼 2024-12-06
题目大意：
输入长度 ≤125000 的字符串 s，和长度 ≤|s| 的字符串 t，只包含前六个小写英文字母。
定义 f(S,T) 为使 S=T 的最小操作次数。
其中每次操作，你可以选择一个字母 x 和另一个字母 y，然后把 S 和 T 中的所有字母 x 替换成字母 y。
对于 s 中的每个长为 |t| 的子串 s'，输出 f(s',t)。

rating 2200
本质上来说，我们需要把 a~f 划分成若干个集合，每个集合中的字母都变成同一个。比如 {a,b,e},{d},{c,f}。
这一共有 203 种不同的划分方式。
每种划分方式（字母到字母的映射）跑一个字符串匹配，可以用 KMP/Z函数/字符串哈希等。
划分的集合越多，不变的字母越多，操作次数就越少。
这个回溯怎么写呢？
递归的时候额外传参 sz，表示当前划分出了 sz 个集合。
枚举当前字母是形成一个新的集合（当前字母不变），还是加到前面的集合中（当前字母改变）。
代码 https://codeforces.com/contest/954/submission/294281446
代码备份（洛谷）
======

Input
abcdefa
ddcb
Output
2 3 3 3
 */
