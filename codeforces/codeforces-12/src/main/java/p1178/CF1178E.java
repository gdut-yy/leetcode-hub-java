package p1178;

import java.util.Scanner;

public class CF1178E {
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.next().toCharArray();
        System.out.println(solve());
    }

    private static String solve() {
        int n = s.length;
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i < n / 2; i += 2) {
            if (s[i] == s[n - i] || s[i] == s[n - i - 1]) {
                ans.append(s[i]);
            } else {
                ans.append(s[i - 1]);
            }
        }

        StringBuilder output = new StringBuilder(ans);
        if (n % 4 > 0) {
            output.append(s[n / 2]);
        }
        output.append(ans.reverse());
        return output.toString();
    }
}
/*
E. Archaeology
https://codeforces.com/contest/1178/problem/E

灵茶の试炼 2022-09-30
题目大意：
输入一个长度不超过 1e6 的字符串 s，仅包含 a b c，且相邻字符不同。
你需要找到一个 s 的回文子序列 t，且 t 的长度至少是 s 长度的一半（下取整）。
输出任意一个符合要求的 t。
注意子序列不要求连续。

rating 1900
https://codeforces.com/contest/1178/submission/173928518
位运算做法 https://codeforces.com/contest/1178/submission/173928055
Python https://codeforces.com/contest/1178/submission/173920506
提示 1：根据鸽巢原理，s 的前两个字符和后两个字符中，必然有两个相同的字符，且由于 s 的相邻字符不同，这两个相同字符必然一个在前两个字符中，另一个在后两个字符中。
提示 2：去掉首尾各两个字符，按同样的方法处理剩余字符。
提示 3：如果剩余字符不足 4 个，可以任取一个字符，作为 t 的回文中心。
======

input
cacbac
output
aba

input
abc
output
a

input
cbacacacbcbababacbcb
output
cbaaacbcaaabc
 */