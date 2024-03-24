package p792;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CF792C {
    static String s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.next();
        System.out.println(solve());
    }

    private static String solve() {
        List<Integer>[] pos = new ArrayList[3];
        Arrays.setAll(pos, e -> new ArrayList<>());
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int b = s.charAt(i) - '0';
            pos[b % 3].add(i);
        }

        int sum = (pos[1].size() + pos[2].size() * 2) % 3;
        if (sum == 0) {
            return s;
        }

        if (sum == 2) {
            // pos[1], pos[2] = pos[2], pos[1]
            List<Integer> tmp = new ArrayList<>(pos[1]);
            pos[1] = new ArrayList<>(pos[2]);
            pos[2] = tmp;
        }

        String ans = "";
        List<Integer> ps1 = pos[1];
        if (!ps1.isEmpty()) {
            int p = ps1.get(ps1.size() - 1);
            ans = trim0(s.substring(0, p) + s.substring(p + 1));
        }
        List<Integer> ps = pos[2];
        if (ps.size() > 1) {
            int p = ps.get(ps.size() - 2), q = ps.get(ps.size() - 1);
            String s1 = s.substring(0, p) + s.substring(p + 1, q) + s.substring(q + 1);
            s1 = trim0(s1);
            if (s1.length() > ans.length()) {
                ans = s1;
            }
        }

        if (ans.isEmpty()) {
            return "-1";
        }
        return ans;
    }

    static String trim0(String s) {
        int i = 0;
        while (i + 1 < s.length() && s.charAt(i) == '0') i++;
        return s.substring(i);
    }
}
/*
C. Divide by Three
https://codeforces.com/contest/792/problem/C

灵茶の试炼 2022-04-25
题目大意：
给你一个的正整数 s（以长度不超过 1e5 的字符串形式表示，无前导零）。
要求删掉尽可能少的数字，使得删数后的 s' 能被 3 整除且 s' 无前导零。
输出 s'。如果无法得到符合要求的 s'，输出 -1。

rating 2000
2000 分的题。难度分偏高，估计是很多人被 rejudge 了。
贪心：比如 digit_sum % 3 == 1，那么可以删除末尾一个 %3=1 的数，或者删除末尾两个 %3=2 的数。
难点在于如何优雅地实现，以及一些细节上的处理。
https://codeforces.com/contest/792/submission/121561575
======

input
1033
output
33

input
10
output
0

input
11
output
-1
 */