package p1924;

import java.util.Scanner;

public class CF1924A {
    static int n, k, m;
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            k = scanner.nextInt();
            m = scanner.nextInt();
            s = scanner.next().toCharArray();
            System.out.println(solve());
        }
    }

    private static String solve() {
        int mask = 0;
        StringBuilder t = new StringBuilder();
        for (char c : s) {
            mask |= 1 << (c - 'a');
            if (mask == (1 << k) - 1) {
                t.append(c);
                mask = 0;
            }
        }
        if (t.length() >= n) {
            return "YES";
        } else {
            return "NO" + System.lineSeparator()
                    + t
                    + (char) ('a' + Integer.numberOfTrailingZeros(~mask))
                    + "a".repeat(n - 1 - t.length());
        }
    }
}
/*
A. Did We Get Everything Covered?
https://codeforces.com/contest/1924/problem/A

灵茶の试炼 2024-09-10
题目大意：
输入 T(≤1e5) 表示 T 组数据。所有数据的 n 之和 ≤1e6，m 之和 ≤1e6。
每组数据输入 n(1≤n≤26) k(1≤k≤26) m(1≤m≤1000) 和长为 m 的字符串 s，只包含前 k 个小写字母。
对于所有长为 n 的只包含前 k 个小写字母的字符串，是否都是 s 的子序列？
输出 YES 或 NO。
如果输出的是 NO，额外输出任意一个长为 n 的，只包含前 k 个小写字母的字符串，其不是 s 的子序列。
注：子序列不一定连续。

rating 1500
本题是 2350. 不可能得到的最短骰子序列 的进阶版本（输出具体方案），请先完成这题。
对于输出方案，可以在找到前 k 个字母后，把最后遇到的字母加入答案，然后重复该过程。
如果答案长度小于 n（输出 NO），首先把前 k 个字母中的没有找到的字母加入答案，然后把 n-1-len(答案) 个 'a' 加入答案。
代码实现时，由于本题只有小写字母，可以用位运算代替 bool 数组。
代码 https://codeforces.com/contest/1924/submission/280076808
======

Input
3
2 2 4
abba
2 2 3
abb
3 3 10
aabbccabab
Output
YES
NO
aa
NO
ccc
 */
