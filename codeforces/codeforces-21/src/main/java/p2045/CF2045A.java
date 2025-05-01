package p2045;

import java.util.Scanner;

public class CF2045A {
    static String s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.next();
        System.out.println(solve());
    }

    private static String solve() {
        int n = s.length();
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'A']++;
        }

        int a = cnt['A' - 'A'] + cnt['E' - 'A'] + cnt['I' - 'A'] + cnt['O' - 'A'] + cnt['U' - 'A'];
        int y = cnt['Y' - 'A'];
        int b = n - a - y;
        int ng = Math.min(cnt['N' - 'A'], cnt['G' - 'A']);

        int ans;
        if ((a + y) * 2 <= ng) { // 元音少，甚至比 NG 还少
            ans = (a + y) * 5; // 只用 NG 辅音
        } else if ((a + y) * 2 <= b - ng) { // 元音少，即使把 NG 合并（减少辅音个数）仍然少
            ans = (a + y) * 3 + ng; // 所有 NG 全部用上
        } else if ((b + y) / 2 <= a) { // 辅音少
            ans = (b + y) / 2 * 3;
            if ((b + y) % 2 > 0 && ng > 0) {
                ans++; // 多出的一个辅音可以是 N 或者 G，合并到 NG 中
            }
        } else {
            // 如果没有 NG，那么答案一定是 3 的倍数
            // 如果只有一个 NG，那么当 n 是 3k+2 时，一定会多出一个字母，例如 AYNGG
            // 其余情况可以用 NG 和 Y 灵活调整，答案是 n
            ans = n - Math.max(n % 3 - ng, 0);
        }
        return String.valueOf(ans);
    }
}
/*
A. Scrambled Scrabble
https://codeforces.com/contest/2045/problem/A

灵茶の试炼 2025-01-08
题目大意：
输入长度 ≤5000 的字符串 s，只包含大写英文字母。
字母 AEIOU 是元音。Y 可以是元音也可以是辅音。
其余字母为辅音。特别地，可以把 NG 连在一起，当作一个辅音。
定义音节为一个辅音 + 一个元音 + 一个辅音。例如 CAR，KING 等等。
定义单词为由一个或多个音节串联得到的字符串。例如 KINGDOM 是由 KING + DOM 两个音节组成。
从 s 中删除零个或多个字母，然后重新排列剩余的字母，组成单词。
输出最长单词长度。
如果无法组成单词，输出 0。
进阶：做到 O(n)。
进阶：在已知每种字母个数的情况下，做到 O(1)。

rating 1700
在已知每种字母个数的情况下，做到 O(1)。
分类讨论三种情况：元音很少、辅音很少、其他情况。
由于本质是一堆 if-else，所以直接看代码，我写了详细注释。
代码 https://codeforces.com/contest/2045/submission/299306882
代码备份（洛谷）
======

Input
ICPCJAKARTA
Output
9

Input
NGENG
Output
5

Input
YYY
Output
3

Input
DANGAN
Output
6

Input
AEIOUY
Output
0
 */
