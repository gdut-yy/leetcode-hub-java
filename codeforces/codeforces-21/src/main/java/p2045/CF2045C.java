package p2045;

import java.util.Scanner;

public class CF2045C {
    static String s, t;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.next();
        t = scanner.next();
        System.out.println(solve());
    }

    private static String solve() {
        int[] pos = new int[26];
        for (int i = 0; i < t.length() - 1; i++) {
            pos[t.charAt(i) - 'a'] = i + 1;
        }
        int tar = -1;
        int mn = Integer.MAX_VALUE;
        for (int i = 1; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (pos[c] == 0) continue;
            int k = i + 1 + t.length() - pos[c];
            if (k < mn) {
                mn = k;
                tar = i;
            }
        }
        if (tar >= 0) {
            return s.substring(0, tar + 1) + t.substring(pos[s.charAt(tar) - 'a']);
        }
        return "-1";
    }
}
/*
C. Saraga
https://codeforces.com/contest/2045/problem/C

灵茶の试炼 2024-12-31
题目大意：
输入两个长度都 ≤2e5 的字符串 s 和 t，只包含小写英文字母。
输出一个最短的字符串 X，满足 X = p + q = p' + q'，其中 p 和 p' 是 s 的两个不同前缀，q 和 q' 是 t 的两个不同后缀。
例如 s = sarana，t = olahraga，那么 X = saga，因为 X = s + aga = sa + ga。
如果答案不止一个，输出其中任意一个。
如果答案不存在，输出 -1。

rating 1400
问题相当于找到一个三元组 (i,j,d)，满足 s[:i] + t[j:] = s[:i+d] + t[j+d:]。
需要最小化答案长度 i+|t|-j。
注意到，i+|t|-j 和 d 无关。由于 d 越小，s[:i] + t[j:] = s[:i+d] + t[j+d:] 越容易成立，所以取 d=1。
既然 d=1，那么换一个思维角度，改成枚举这个字母。
对于每种字母，记录其在 s 中的最左位置，和 t 中的最右位置，从中找到最短的答案。
注意记录位置时，不考虑 s[0] 和 t[len(t)-1]。
也可以遍历 t，记录每种字母的最右位置，然后遍历 s 找最短答案。这样可以做到线性。
代码 https://codeforces.com/contest/2045/submission/298178861
代码备份（洛谷）
======

Input
sarana
olahraga
Output
saga

Input
berhiber
wortelhijau
Output
berhijau

Input
icpc
icpc
Output
icpc

Input
icpc
jakarta
Output
-1
 */
