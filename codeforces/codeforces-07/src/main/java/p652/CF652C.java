package p652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CF652C {
    static int n, m;
    static int[] pos, L;

    public static void main(String[] args) {
        // Time limit exceeded on test 12
//        Scanner scanner = new Scanner(System.in);
        FastReader scanner = new FastReader();
        n = scanner.nextInt();
        m = scanner.nextInt();

        pos = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int x = scanner.nextInt();
            pos[x] = i;
        }
        L = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            x = pos[x];
            y = pos[y];
            if (x > y) {
                // x, y = y, x
                int tmp = x;
                x = y;
                y = tmp;
            }
            L[y] = Math.max(L[y], x);
        }
        System.out.println(solve());
    }

    private static String solve() {
        long ans = 0;
        int maxL = 0;
        for (int i = 1; i <= n; i++) {
            maxL = Math.max(maxL, L[i]);
            ans += i - maxL;
        }
        return String.valueOf(ans);
    }

    private static class FastReader {
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
C. Foe Pairs
https://codeforces.com/contest/652/problem/C

灵茶の试炼 2022-08-17
题目大意：
输入 n 和 m (≤3e5)，一个 1~n 的全排列 p，以及 m 个 pair，元素值均在 [1,n] 中。
称 p 的子数组 b 是合法的，当且仅当对于所有 pair (x,y)，x 和 y 至多有一个在 b 中。
输出有多少个 p 的合法子数组。
进阶：如果 p 有重复元素要怎么做？

rating 1800
https://codeforces.com/contest/652/submission/168633147
62ms 快读 https://codeforces.com/problemset/submission/652/168657078
提示 1：对 p 的每个位置 i，假设它是子数组的右端点，我们需要知道有多少个合法的左端点。
提示 2：为了做到这一点，我们需要知道 i 左侧最近的元素对的位置，怎么定义最近呢？
具体来说，设元素对为 (x,y)，其在 p 上的下标分别为 pos[x] 和 pos[y]，假设 pos[x]<pos[y]<=i，我们需要知道 pos[x] 的最大值 maxL，这样位置 i 对答案的贡献就是 i-maxL。
提示 3：如何求 maxL？
遍历 p 可以得到 pos 数组，遍历所有元素对，可以得到每个 pos[y] 位置上所对应的 pos[x] 的最大值，记作 l 数组。
从小到大遍历 l，维护 l 前缀的最大值，即为 maxL。
具体实现逻辑见代码。
由于输入量巨大，代码的耗时主要在读入上。
======

input
4 2
1 3 2 4
3 2
2 4
output
5

input
9 5
9 7 2 3 1 4 6 5 8
1 6
4 5
2 7
7 2
2 7
output
20
 */