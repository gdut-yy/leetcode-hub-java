package p3;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class CF3D {
    static Scanner scanner = new Scanner(System.in);
    static char[] s;

    public static void main(String[] args) {
        s = scanner.next().toCharArray();
        System.out.println(solve());
    }

    private static String solve() {
        long cnt = 0;
        long ans = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < s.length; i++) {
            char c = s[i];
            if (c == '(') {
                cnt++;
                continue;
            }
            if (c == '?') {
                s[i] = ')';
                int l = scanner.nextInt();
                int r = scanner.nextInt();
                ans += r;
                pq.add(new int[]{l - r, i});
            }
            if (cnt > 0) {
                cnt--;
                continue;
            }
            if (pq.isEmpty()) return "-1";
            cnt++;
            int[] p = pq.remove();
            ans += p[0];
            s[p[1]] = '(';
        }
        if (cnt > 0) {
            return "-1";
        }
        return ans + System.lineSeparator() + new String(s);
    }
}
/*
D. Least Cost Bracket Sequence
https://codeforces.com/contest/3/problem/D

灵茶の试炼 2024-03-01
题目大意：
输入长度 ≤5e4 的字符串 s，只包含 '(', ')' 和 '?'。
设 '?' 的个数为 m，然后输入 m 行，第 i 行两个数 L 和 R，表示修改 s 中的第 i 个 '?' 为左括号/右括号的花费分别为 L 和 R，范围 [1,1e6]。
你需要把 s 中的所有 '?' 修改成 '(' 或 ')'，使得 s 是一个合法括号字符串。
如果无法做到，输出 -1。
否则输出最小花费和修改后的字符串。

rating 2600（放在今天可能只有 2000）
反悔贪心（反悔堆）。
遍历字符串，用 cnt 维护左括号个数减右括号个数。
默认把 '?' 都改成右括号，如果发现 cnt < 0 就反悔左边 L-R 最小的 '?' 变成左括号。
如果无法反悔就输出 -1。
如果循环完了 cnt > 0 也输出 -1。
https://codeforces.com/problemset/submission/3/248296414
======

Input
(??)
1 2
2 8
Output
4
()()
 */
