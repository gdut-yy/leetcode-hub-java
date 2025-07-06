package p2104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CF2104E {
    //    static Scanner scanner = new Scanner(System.in);
    static FastReader scanner = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static int n, k;
    static char[] s;

    public static void main(String[] args) {
        n = scanner.nextInt();
        k = scanner.nextInt();
        s = scanner.next().toCharArray();
        solve();
        out.flush();
    }

    private static void solve() {
        int[][] nxt = new int[n + 1][26];
        for (int j = 0; j < 26; j++) {
            nxt[n][j] = n;
        }
        int mask = 0;
        int[] f = new int[n + 2];
        f[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            nxt[i] = nxt[i + 1].clone();
            nxt[i][s[i] - 'a'] = i;
            mask |= 1 << (s[i] - 'a');
            f[i] = f[i + 1];
            if (mask == (1 << k) - 1) {
                f[i]++;
                mask = 0;
            }
        }

        int q = scanner.nextInt();
        while (q-- > 0) {
            char[] t = scanner.next().toCharArray();
            int i = -1;
            for (char b : t) {
                i = nxt[i + 1][b - 'a'];
                if (i == n) {
                    break;
                }
            }
            out.println(f[i + 1]);
        }
    }

    static class FastReader {
        private final BufferedReader bufferedReader;
        private StringTokenizer stringTokenizer;

        public FastReader() {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringTokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            String str = "";
            try {
                if (stringTokenizer.hasMoreTokens()) {
                    str = stringTokenizer.nextToken("\n");
                } else {
                    str = bufferedReader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
/*
E. Unpleasant Strings
https://codeforces.com/contest/2104/problem/E

灵茶の试炼 2025-06-18
题目大意：
输入 n(1≤n≤1e6) k(1≤k≤26) 和长为 n 的字符串 s，只包含前 k 个小写英文字母。
然后输入 q(1≤q≤2e5) 和 q 个询问，每个询问输入一个字符串 t，只包含前 k 个小写英文字母。保证所有 t 的长度之和 ≤1e6。
在 t 的末尾添加若干字母（必须是前 k 个小写英文字母），使得 t 不是 s 的子序列。
输出最少添加多少个字母。

rating 1700
本题是以下两个技巧的综合：
1. 子序列自动机 https://leetcode.cn/problems/is-subsequence/solutions/2813031/jian-ji-xie-fa-pythonjavaccgojsrust-by-e-mz22/
2. 最短非子序列 https://leetcode.cn/problems/shortest-impossible-sequence-of-rolls/
找到 s 的最短前缀匹配子序列 t，计算剩余部分的最短非子序列长度，这可以提前倒序 DP 预处理。
代码 https://codeforces.com/contest/2104/submission/324427802
代码备份（Ubuntu Pastebin）
======

Input
7 3
abacaba
3
cc
bcb
b
Output
0
1
2

Input
5 1
aaaaa
6
a
aa
aaa
aaaa
aaaaa
aaaaaa
Output
5
4
3
2
1
0
 */
