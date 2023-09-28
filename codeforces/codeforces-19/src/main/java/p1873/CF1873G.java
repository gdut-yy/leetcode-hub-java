package p1873;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF1873G {
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            s = scanner.next().toCharArray();
            System.out.println(solve());
        }
    }

    private static String solve() {
        int n = s.length;
        boolean all = s[0] == 'B' || s[n - 1] == 'B';
        for (int i = 0; i + 1 < n; i++) {
            if (s[i] == s[i + 1] && s[i] == 'B') {
                all = true;
                break;
            }
        }
        List<Integer> lens = new ArrayList<>();
        int curr = 0;
        for (char c : s) {
            if (c == 'A') {
                curr++;
            } else {
                if (curr != 0) {
                    lens.add(curr);
                    curr = 0;
                }
            }
        }
        if (curr != 0) {
            lens.add(curr);
        }
        lens.sort(null);

        if (lens.isEmpty()) {
            return "0";
        }

        int tot = 0;
        if (all) {
            tot += lens.get(0);
        }
        for (int i = 1; i < lens.size(); i++) {
            tot += lens.get(i);
        }
        return String.valueOf(tot);
    }
}
/*
G. ABBC or BACB
https://codeforces.com/contest/1873/problem/G

题目大意：
给你一个由字符 A 和 B 组成的字符串。一开始你没有硬币。您可以执行两种类型的操作:
- 选择一个子串†AB，将其改为 BC，得到一枚硬币。
- 选择子字符串†BA，将其更改为 CB，并获得一枚硬币。你最多能获得多少金币?
长度为 2 的子字符串是字符串中两个相邻字符的序列。

https://codeforces.com/blog/entry/120634
"ad-hoc problems" https://www.geeksforgeeks.org/what-are-ad-hoc-problems-in-competitive-programming/
"ad-hoc problems" 是无法通过经过充分研究的解决方案分类到类别中任何其他位置的问题，因为每个问题描述及其相应的解决方案都是唯一的。这些问题不属于标准类别，没有特定或通用的技术来解决它们。许多 Ad Hoc 问题都很简单，但这并不适用于所有 Ad Hoc 问题。
======

input
8
ABBA
ABA
BAABA
ABB
AAAAAAB
BABA
B
AAA
output
2
1
3
1
6
2
0
0
 */
