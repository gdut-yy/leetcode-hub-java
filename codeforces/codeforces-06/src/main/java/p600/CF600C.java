package p600;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF600C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = scanner.next();
        System.out.println(solve(s));
    }

    private static String solve(String s) {
        int[] cntArr = new int[26];
        for (char ch : s.toCharArray()) {
            cntArr[ch - 'a']++;
        }

        // 奇数频次字符
        List<Integer> ps = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (cntArr[i] % 2 == 1) {
                ps.add(i);
            }
        }

        // 双指针。为了让字典序尽量小，这些计数字母也要对应匹配，譬如有 adef, f -> a, e -> d
        int l = 0, r = ps.size() - 1;
        while (l < r) {
            cntArr[ps.get(l)]++;
            cntArr[ps.get(r)]--;
            l++;
            r--;
        }

        // 构造 l + mid + r
        StringBuilder leftSB = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            String ch = String.valueOf((char) (i + 'a'));
            leftSB.append(ch.repeat(cntArr[i] / 2));
        }
        String left = leftSB.toString();
        String right = leftSB.reverse().toString();
        String mid = "";
        for (int i = 0; i < 26; i++) {
            if (cntArr[i] % 2 == 1) {
                mid = String.valueOf((char) (i + 'a'));
                break;
            }
        }
        return left + mid + right;
    }
}
/*
C. Make Palindrome
https://codeforces.com/contest/600/problem/C

灵茶の试炼 2023-02-20
题目大意：
输入字符串 s，长度不超过 2e5，由小写字母组成。
你可以修改多个 s[i]，使得修改后的 s，通过重新排列，可以得到回文串。
设最少修改 x 次。输出修改 x 次且重排后字典序最小的回文串。

constructive algorithms
https://codeforces.com/contest/600/submission/97136757
提示 1：修改出现次数为奇数的字符。
提示 2：为了让字典序尽量小，这些奇数字母也要对应匹配。设 adef 出现了奇数次，那么把 f 改成 a，e 改成 d。
提示 3：注意有奇数个奇数的情况，此时回文中心是不需要修改的。
======

input
aabc
output
abba

input
aabcd
output
abcba
 */
