package c450;

import java.io.PrintWriter;
import java.util.Scanner;

public class Abc450_e {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static String c;

    private static void solve() {
        String s = scanner.next();
        String t = scanner.next();
        int[][] sumS = init(s);
        int[][] sumT = init(t);
        long[] sz = new long[130];
        long[][] ss = new long[130][26];
        sz[0] = s.length();
        sz[1] = t.length();
        for (int j = 0; j < 26; j++) {
            ss[0][j] = sumS[s.length()][j];
            ss[1][j] = sumT[t.length()][j];
        }
        int maxI = 1;
        for (int i = 1; sz[i] <= 1e18; i++) {
            sz[i + 1] = sz[i] + sz[i - 1];
            for (int j = 0; j < 26; j++) {
                ss[i + 1][j] = ss[i][j] + ss[i - 1][j];
            }
            maxI = i + 1;
        }
        int q = scanner.nextInt();
        for (int qi = 0; qi < q; qi++) {
            long l = scanner.nextLong();
            long r = scanner.nextLong();
            c = scanner.next();
            out.println(f(r, sumS, sumT, sz, ss, maxI) - f(l - 1, sumS, sumT, sz, ss, maxI));
        }
    }

    static int[][] init(String str) {
        int n = str.length();
        int[][] sum = new int[n + 1][26];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) sum[i + 1][j] = sum[i][j];
            sum[i + 1][str.charAt(i) - 'a']++;
        }
        return sum;
    }

    static long f(long k, int[][] sumS, int[][] sumT, long[] sz, long[][] ss, int maxI) {
        int b = c.charAt(0) - 'a';
        if (k <= sz[1]) return sumT[(int) k][b];
        int lo = 1, hi = maxI;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (sz[mid] >= k) hi = mid;
            else lo = mid + 1;
        }
        int i = lo;
        long res = 0;
        while (i > 1) {
            if (k > sz[i - 1]) {
                k -= sz[i - 1];
                res += ss[i - 1][b];
                i -= 2;
            } else {
                i--;
            }
        }
        if (i == 0) res += sumS[(int) k][b];
        else res += sumT[(int) k][b];
        return res;
    }
}
/*
E - Fibonacci String
https://atcoder.jp/contests/abc450/tasks/abc450_e

灵茶の试炼 2026-06-24
题目大意：
输入长度 ≤1e4 的字符串 X 和字符串 Y，只包含小写英文字母。
输入 q(1≤q≤1e5) 和 q 个询问，每个询问输入 L R(1≤L≤R≤1e18) 和小写字母 C。
定义 S[1] = X, S[2] = Y, S[i] = S[i-1] + S[i-2] (i≥3)。
对于每个询问，输出在 S[1e18] 中的子串 [L,R] 中的小写字母 C 的个数（下标从 1 开始）。

rating
类似斐波那契数列，|Sn| 是指数增长的，可以直接预处理 |Sn|<=1e18 的每个 |Sn| 以及 Sn 中的 'a'~'z' 的个数。
然后递归/迭代找到第 k 个字母在字符串 X 中还是字符串 Y 中。做法类似 LC1545. 找出第 N 个二进制字符串中的第 K 位。
答案为 S[1e18] 前 R 个字母中的 C 的个数，减去前 L-1 个字母中的 C 的个数。
注意特判 k <= len(Y) 的情况，因为 S[1e18] 的开头是 Y，而不是 X。
代码 https://atcoder.jp/contests/abc450/submissions/76766604
======

Input 1
a
b
6
2 7 a
1 3 b
3 7 b
1 9 c
1 1000000000000000000 b
1000000000000000000 1000000000000000000 a
Output 1
3
2
3
0
618033988749894848
1
 */
