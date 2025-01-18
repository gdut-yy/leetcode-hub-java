package c377;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Abc377_g {
    static int n;
    static String[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(solve());
    }

    static Trie root;

    private static String solve() {
        root = new Trie();

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            String s = a[i];
            ans[i] = queryPre(s);
            insert(s);
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }

    static class Trie {
        Trie[] child = new Trie[26];
        int f = (int) 1e9;
    }

    static void insert(String s) {
        Trie o = root;
        for (char c : s.toCharArray()) {
            int i = c - 'a';
            if (o.child[i] == null) {
                o.child[i] = new Trie();
            }
            o = o.child[i];
            o.f = Math.min(o.f, s.length());
        }
    }

    static int queryPre(String s) {
        int ans = s.length();
        int dep = 0;
        Trie o = root;
        for (char c : s.toCharArray()) {
            dep++;
            int i = c - 'a';
            if (o.child[i] == null) {
                return ans;
            }
            o = o.child[i];
            ans = Math.min(ans, s.length() + o.f - 2 * dep);
        }
        return ans;
    }
}
/*
G - Edit to Match
https://atcoder.jp/contests/abc377/tasks/abc377_g

题目大意：
给你 $N$ 个字符串 $S_1,S_2,\ldots,S_N$ 。每个字符串都由小写英文字母组成。
请为每个 $k=1,2,\ldots,N$ 解决下面的问题。
> 让 $T=S_k$ 并考虑以任意顺序执行以下两种类型的操作任意多次：
> - 花费 $1$ 删除 $T$ 的最后一个字符。当 $T$ 不为空时，可以执行此操作。
> - 支付 $1$ 的代价，在 $T$ 的末尾添加任何小写英文字母。
> 求使 $T$ 要么为空，要么与 $S_1,S_2,\ldots,S_{k-1}$ 中的一个匹配所需的最小总成本。

yangjl：跟我们 hackathon 初赛的字典树那题很相似。
https://atcoder.jp/contests/abc377/submissions/59182600
======

Input 1
3
snuke
snuki
snuuk
Output 1
5
2
4

Input 2
3
abc
arc
agc
Output 2
3
3
3

Input 3
8
at
atatat
attat
aatatatt
attattat
ttatta
tta
tt
Output 3
2
4
3
8
3
6
3
1
 */
