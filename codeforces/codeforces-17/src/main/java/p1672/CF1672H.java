package p1672;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class CF1672H {
    // Time limit exceeded on test 10
//    static Scanner scanner = new Scanner(System.in);
    static FastReader scanner = new FastReader();
    static int n, q;
    static char[] s;

    public static void main(String[] args) {
        n = scanner.nextInt();
        q = scanner.nextInt();
        s = scanner.next().toCharArray();
        System.out.println(solve());
    }

    private static String solve() {
        int[][] sum = new int[n][2];
        for (int i = 0; i < n - 1; i++) {
            sum[i + 1] = sum[i].clone();
            if (s[i] == s[i + 1]) {
                sum[i + 1][s[i] - '0']++;
            }
        }
        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int c0 = sum[r - 1][0] - sum[l - 1][0];
            int c1 = sum[r - 1][1] - sum[l - 1][1];
            ans[i] = Math.max(c0, c1) + 1;
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
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
H. Zigu Zagu
https://codeforces.com/contest/1672/problem/H

灵茶の试炼 2024-10-11
题目大意：
输入 n(1≤n≤2e5) q(1≤q≤2e5) 和长为 n 的 01 字符串 s。
定义交替字符串为相邻字符互不相同的字符串。
定义 f(t) 为，不断删除字符串 t 中的交替子串，使得 t 为空的最小操作次数。
例如 "11011" -> (删除 "101") "11" -> "1" -> ""，所以 f("11011") = 3。
输入 q 个询问，每个询问输入 L R (1≤L≤R≤n)。
对于每个询问，输出 s 的子串 [L,R] 的 f 值。

rating 2700
根据题意，相邻相同的字符个数，会影响答案。
比如 11 需要操作 2 次。
11...11 需要操作 3 次。省略号表示相邻不同的子串，因为 11011、1101011、110101011 等没有本质区别，用省略号表示，这样我们更能看出问题的本质。
11...11...11 需要操作 4 次。
那么，11...11...11...00 需要操作几次？
答案仍然是 4 次，因为我们可以先删除 1...0，得到 11...11...10，这样最后的 0 可以和最后一个 1 一起移除掉。
同理 11...11...11...00...00 仍然是 4 次。
但如果 00 比 11 多，答案就以 00 的个数为主了。
一般地，把 11 和 00 视作【左右括号】，或者【右左括号】，问题类似括号匹配。
如果 11 比 00 多，那么 00 都可以免费移除掉，答案是 11 的个数加一。
否则答案是 00 的个数加一。
用前缀和统计 00 和 11 的个数，便可快速回答询问。
代码 https://codeforces.com/contest/1672/submission/285182425
======

Input
5 3
11011
2 4
1 5
3 5
Output
1
3
2

Input
10 3
1001110110
1 10
2 5
5 10
Output
4
2
3
 */
