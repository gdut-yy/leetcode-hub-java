package p1714;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF1714D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            String t = scanner.next();
            int n = scanner.nextInt();
            String[] s = new String[n];
            for (int j = 0; j < n; j++) {
                s[j] = scanner.next();
            }

            List<String> res = solve(t, n, s);
            if (res.isEmpty()) {
                System.out.println(-1);
            } else {
                System.out.println(res.size());
                for (String re : res) {
                    System.out.println(re);
                }
            }
        }
    }

    private static List<String> solve(String t, int n, String[] s) {
        List<String> match = new ArrayList<>();
        find(0, 0, t, s, match);
        return match;
    }

    static void find(int a, int b, String t, String[] str, List<String> match) {
        int max = 0;
        int id = -1;
        int pos = -1;
        for (int i = a; i <= b; i++) {
            for (int j = 0; j < str.length; j++) {
                String s = str[j];
                if (i + s.length() > t.length() || i + s.length() <= b) {
                    continue;
                }
                if (t.startsWith(s, i)) {
                    if (i + s.length() > max) {
                        max = i + s.length();
                        id = j;
                        pos = i;
                    }
                }
            }
        }
        if (id == -1) {
            match.clear();
        } else {
            match.add((id + 1) + " " + (pos + 1));
            if (max < t.length()) {
                a = Math.max(pos + 1, b + 1);
                b = max;
                find(a, b, t, str, match);
            }
        }
    }
}
/*
D. Color with Occurrences
https://codeforces.com/contest/1714/problem/D

灵茶の试炼 2024-05-08
题目大意：
给定文本 t，整数 n 和 n 行字符串 si，求将所有字母 t 变成红色所需要的最小步骤数 m，并输出 m 行 wj,pj，其中 wj 为索引，pj 为覆盖开始位置。

rating 1600
贪心。参考 Tutorial。
======

input
6
bababa
2
ba
aba
caba
2
bac
acab
abacabaca
3
aba
bac
aca
baca
3
a
c
b
codeforces
4
def
code
efo
forces
aaaabbbbcccceeee
4
eeee
cccc
aaaa
bbbb

output
3
2 2
1 1
2 4
-1
4
1 1
2 6
3 3
3 7
4
3 1
1 2
2 3
1 4
2
4 5
2 1
4
3 1
4 5
2 9
1 13
 */