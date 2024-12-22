package p1905;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF1905C {
    static int n;
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            s = scanner.next().toCharArray();
            System.out.println(solve());
        }
    }

    private static String solve() {
        List<Integer> st = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && s[i] > s[st.getLast()]) {
                st.removeLast();
            }
            st.add(i);
        }
        int m = st.size();
        char[] t = s.clone();
        for (int i = 0; i < st.size(); i++) {
            int idx = st.get(i);
            t[idx] = s[st.get(m - 1 - i)];
        }
        if (!isSorted(t)) {
            return "-1";
        }
        for (Integer i : st) {
            if (s[i] == s[st.get(0)]) {
                m--;
            }
        }
        return String.valueOf(m);
    }


    static boolean isSorted(char[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) return false;
        }
        return true;
    }
}
/*
C. Largest Subsequence
https://codeforces.com/contest/1905/problem/C

灵茶の试炼 2024-07-30
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) 和长为 n 的字符串 s，只包含小写英文字母。
每次操作，选出 s 中的字典序最大的子序列，将其循环右移一位。
例如 s=zbca 选出子序列 zca，循环右移一位后变成 azc，此时 s 变成 abzc。
使 s 变成有序的，即 s[i] <= s[i+1]，至少要操作多少次？
如果无法做到，输出 -1。

rating 1400
单调栈+贪心。
字典序最大子序列可以用单调栈求出。
相关题目见 单调栈题单
由于字典序最大子序列是递减的，把子序列反转，如果 s 不是有序的，输出 -1。
否则，例如 bbbaa 循环右移 2 次就变成 aabbb 有序的了，所以答案为去掉和子序列首字母一样的字母后，子序列的剩余字母个数。
代码 https://codeforces.com/contest/1905/submission/272528167
======

Input
6
5
aaabc
3
acb
3
bac
4
zbca
15
czddeneeeemigec
13
cdefmopqsvxzz
Output
0
1
-1
2
6
0
 */
