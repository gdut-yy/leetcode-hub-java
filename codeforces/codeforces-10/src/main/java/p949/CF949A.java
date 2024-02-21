package p949;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF949A {
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.next().toCharArray();
        System.out.println(solve());
    }

    private static String solve() {
        List<List<Integer>> a = new ArrayList<>();
        int p = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '0') {
                if (p == a.size()) {
                    a.add(new ArrayList<>());
                }
                a.get(p).add(i);
                p++;
            } else {
                if (p == 0) {
                    return "-1";
                }
                p--;
                a.get(p).add(i);
            }
        }

        if (p != a.size()) {
            return "-1";
        }

        StringBuilder ans = new StringBuilder();
        ans.append(p).append(System.lineSeparator());
        for (List<Integer> r : a) {
            ans.append(r.size());
            for (Integer i : r) {
                ans.append(" ").append(i + 1);
            }
            ans.append(System.lineSeparator());
        }
        return ans.toString();
    }
}
/*
A. Zebras
https://codeforces.com/contest/949/problem/A

灵茶の试炼 2022-05-30
题目大意：
给你一个只包含 01 的字符串 s，长度不超过 2e5。
请你将 s 拆分成若干个子序列（子序列不要求连续），使得每个子序列都是长度为奇数的，从 0 开始的 01 交替串，例如 0 010 01010 等等
如果无法拆分，输出 -1；否则输出组成这些子序列的下标数组（从 1 开始）。可以输出任意一种符合要求的解。

rating 1600
https://codeforces.com/contest/949/submission/158846414
模拟。有两类 01 交替串，一类长度为奇数，一类长度为偶数。
奇数加 1 变偶数，偶数加 0 变奇数。
遍历 s：
遇到 0，我们就选一个偶数长度的交替串，末尾补上 0；如果没有偶数长度的，就新增一个 "0"；
遇到 1，我们就选一个奇数长度的交替串，末尾补上 1。
上述过程中记录下标。
遍历结束后，如果没有长度为偶数的交替串，则找到了答案。
======

input
0010100
output
3
3 1 3 4
3 2 5 6
1 7

input
111
output
-1
 */
