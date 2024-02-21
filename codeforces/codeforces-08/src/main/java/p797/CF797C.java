package p797;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class CF797C {
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.next().toCharArray();
        System.out.println(solve());
    }

    private static String solve() {
        StringBuilder ans = new StringBuilder();
        Deque<Integer> st = new ArrayDeque<>();
        int[] cnt = new int[26];
        for (char b : s) {
            cnt[b - 'a']++;
        }
        int nxt = 0;
        for (char b : s) {
            cnt[b - 'a']--;
            while (nxt < 25 && cnt[nxt] == 0) {
                nxt++;
            }
            st.push(b - 'a');
            while (!st.isEmpty() && st.peek() <= nxt) {
                char pop = (char) (st.pop() + 'a');
                ans.append(pop);
            }
        }
        return ans.toString();
    }
}
/*
C. Minimal string
https://codeforces.com/contest/797/problem/C

灵茶の试炼 2022-05-19
题目大意：
给你一个字符队列 s，长度不超过 1e5，由小写字母组成。
你还有一个空栈。
每次你可以执行下列操作之一，直到队列和栈均为空：
- 弹出队首字符，将其入栈。
- 弹出栈顶字符。
输出字典序最小的出栈序列。

rating 1700
https://codeforces.com/problemset/submission/797/157636876
贪心。
遍历 s，设当前下标为 i，算出 i 和 i 后面的最小字符 c，然后不断把不超过 c 的出栈，然后把 s[i] 入栈。
遍历结束后把栈清空。
======

input
cab
output
abc

input
acdb
output
abdc
 */
