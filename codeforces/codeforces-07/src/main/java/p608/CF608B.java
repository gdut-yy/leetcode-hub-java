package p608;

import java.util.Scanner;

public class CF608B {
    static char[] s, t;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.next().toCharArray();
        t = scanner.next().toCharArray();
        System.out.println(solve());
    }

    private static String solve() {
        int d = t.length - s.length + 1;
        int c1 = 0;
        for (int i = 0; i < d - 1; i++) {
            if (t[i] == '1') c1++;
        }

        long ans = 0;
        for (int i = 0; i < s.length; i++) {
            c1 += t[i + d - 1] & 1;
            if (s[i] == '0') {
                ans += c1;
            } else {
                ans += d - c1;
            }
            c1 -= t[i] & 1;
        }
        return String.valueOf(ans);
    }
}
/*
B. Hamming Distance Sum
https://codeforces.com/contest/608/problem/B

灵茶の试炼 2024-05-28
题目大意：
输入长度均 ≤2e5 的字符串 s 和 t，只包含 '0' 和 '1'。并且 t 的长度大于等于 s 的长度。
定义 D(a,b) = |a[0]-b[0]| + |a[1]-b[1]| + ... + |a[n-1]-b[n-1]|。
例如 D("0011", "0110") = |0-0| + |0-1| + |1-1| + |1-0| = 0 + 1 + 0 + 1 = 2。
设 s 的长度为 n，对于 t 的所有长为 n 的连续子串 t'，计算 D(s,t')。
输出所有 D(s,t') 的和。
进阶：额外输入 k，计算 s 所有长为 k 的子串与 t 的所有长为 k 的子串的 D 之和。

rating 1500
横看成岭侧成峰，考虑贡献。
s[0] 对答案的贡献是多少？
s[1] 对答案的贡献是多少？
...
s[n-1] 对答案的贡献是多少？
设 d = m - n + 1，其中 n 和 m 分别为 s 和 t 的长度。
对于 s[0] 来说，它会与 t[0],t[1],...,t[d-1] 计算 D 值。也就是 t[0],t[1],...,t[d-1] 中的不等于 s[0] 的字符个数。
对于 s[1] 来说，它会与 t[1],t[2],...,t[d] 计算 D 值。
依此类推，问题变成一个长为 d 的定长滑窗。要统计的是窗口内的 '1' 的个数（'0' 的个数等于 d 减去 '1' 的个数）。
注意用 64 位整数。
https://codeforces.com/contest/608/submission/262940468
======

Input
01
00111
Output
3

Input
0011
0110
Output
2
 */