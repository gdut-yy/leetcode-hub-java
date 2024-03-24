package p1092;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CF1092C {
    static int n;
    static List<Pair>[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new ArrayList[n - 1];
        Arrays.setAll(a, e -> new ArrayList<>());
        for (int i = 0; i < n * 2 - 2; i++) {
            String s = scanner.next();
            int ns = s.length() - 1;
            a[ns].add(new Pair(s, i));
        }
        System.out.println(solve1());
    }

    private static String solve() {
        char[] ans = new char[n * 2 - 2];
        String s = a[n - 2].get(0).s;
        String p = a[n - 2].get(1).s;

        String[] range = {p + s.charAt(s.length() - 1), s + p.charAt(p.length() - 1)};
        next:
        for (String comb : range) {
            for (List<Pair> v : a) {
                if (comb.startsWith(v.get(0).s) && comb.endsWith(v.get(1).s)) {
                    ans[v.get(0).i] = 'P';
                    ans[v.get(1).i] = 'S';
                } else if (comb.startsWith(v.get(1).s) && comb.endsWith(v.get(0).s)) {
                    ans[v.get(0).i] = 'S';
                    ans[v.get(1).i] = 'P';
                } else {
                    continue next;
                }
            }
            return new String(ans);
        }
        return null;
    }

    // 消掉 continue label
    private static String solve1() {
        String s = a[n - 2].get(0).s;
        String p = a[n - 2].get(1).s;
        String ans = getAns(p + s.charAt(s.length() - 1));
        return ans != null ? ans : getAns(s + p.charAt(p.length() - 1));
    }

    static String getAns(String comb) {
        char[] ans = new char[n * 2 - 2];
        for (List<Pair> v : a) {
            if (comb.startsWith(v.get(0).s) && comb.endsWith(v.get(1).s)) {
                ans[v.get(0).i] = 'P';
                ans[v.get(1).i] = 'S';
            } else if (comb.startsWith(v.get(1).s) && comb.endsWith(v.get(0).s)) {
                ans[v.get(0).i] = 'S';
                ans[v.get(1).i] = 'P';
            } else {
                return null;
            }
        }
        return new String(ans);
    }

    static class Pair {
        String s;
        int i;

        public Pair(String s, int i) {
            this.s = s;
            this.i = i;
        }
    }
}
/*
C. Prefixes and Suffixes
https://codeforces.com/contest/1092/problem/C

灵茶の试炼 2022-06-20
题目大意：
给你一个整数 n(2<=n<=100) 和 2n-2 个字符串，这 2n-2 个字符串恰好是某个未知的字符串的所有真前缀和真后缀，即长度从 1 到 n-1 的字符串各有两个。
请按输入顺序回答每个字符串是前缀还是后缀，前缀输出 'P'，后缀输出 'S'，如果答案不止一种，回答任意一种即可。
字符串均由小写字母组成。

rating 1700
https://codeforces.com/contest/1092/submission/161272956
设两个最长的字符串为 p 和 s，那么原串只可能是 p+s[-1] 或者 s+p[-1]。
枚举这两种可能的原串，然后枚举相同长度的输入字符串，判断是否满足一个是前缀另一个是后缀，如果都不满足，则枚举下一个可能的原串。
由于需要按照输入顺序回答，还需要额外记录每个输入对应的下标。
======

input
5
ba
a
abab
a
aba
baba
ab
aba
output
SPPSPSPS

input
3
a
aa
aa
a
output
PPSS

input
2
a
c
output
PS

4
bab
aba
ab
ab
a
b
SPPSPS
 */