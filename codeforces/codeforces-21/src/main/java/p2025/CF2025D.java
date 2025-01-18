package p2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CF2025D {
    static int n, m;
    static int[] a;

    public static void main(String[] args) {
        // Time limit exceeded on test 5
//        Scanner scanner = new Scanner(System.in);
        FastReader scanner = new FastReader();
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int[] f = new int[m + 1];
        int c0 = 0;
        int[][] cnt = new int[m + 1][2];
        for (int i = 0; i < n; i++) {
            int r = a[i];

            if (r < 0) {
                cnt[-r][0]++;
            } else if (r > 0) {
                cnt[r][1]++;
            }
            if (r != 0 && i < n - 1) {
                continue;
            }
            for (int j = 2; j <= c0; j++) {
                cnt[j][0] += cnt[j - 1][0];
                cnt[j][1] += cnt[j - 1][1];
            }
            for (int j = c0; j > 0; j--) {
                f[j] = Math.max(f[j], f[j - 1]) + cnt[j][0] + cnt[c0 - j][1];
            }
            f[0] += cnt[c0][1];
            c0++;
            cnt = new int[m + 1][2];
        }
        return String.valueOf(Arrays.stream(f).max().orElseThrow());
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
D. Attribute Checks
https://codeforces.com/contest/2025/problem/D

灵茶の试炼 2024-11-13
题目大意：
输入 n m(m<n≤2e6, 1≤m≤5000) 和长为 n 的数组 r(-m≤r[i]≤m)，其中恰好有 m 个 0。
一开始 x=y=0。
从左到右遍历 r：
如果 r[i]=0，你可以把 x 加一，或者把 y 加一。
如果 r[i]<0 且 x>=|r[i]|，那么得 1 分。
如果 r[i]>0 且 y>=|r[i]|，那么得 1 分。
输出最大总得分。

rating 1800
核心思想：不要一个一个地处理 r[i]，而是把两个 0 之间的数据一并处理，这样可以写一个 O(m^2) 的 DP。
关于 DP，我们需要知道目前遇到了多少个 0，以及把 x 增加了多少次（y 增加的次数可以用 0 的个数减去 x 算出）。
定义 f[i][j] 表示遇到了 i 个 0，把 x 增加 j 次时的最大总得分。
遍历到 0 时（或者到达数组末尾），计算 f[i][j]。
注意：这里的 i **不包括**当前遍历到的 0。
遍历到 0 时，设从上一个 0 到目前的 0 之间，有 cnt[k][0] 个绝对值 <= k 的负数，cnt[k][1] 个 <= k 的正数。
上一个 0 没有增加 x，那么从上一个 0 到目前的 0 之间，我们可以获得的分数为 cnt[j][0] + cnt[i-j][1]，所以有 f[i][j] = f[i-1][j] + cnt[j][0] + cnt[i-j][1]。
上一个 0 增加了 x，那么在增加之前，x 是 j-1，所以转移来源是 f[i-1][j-1]，我们有 f[i][j] = f[i-1][j-1] + cnt[j][0] + cnt[i-j][1]。
二者取最大值：f[i][j] = max(f[i-1][j],f[i-1][j-1]) + cnt[j][0] + cnt[i-j][1]。
答案为 max(f[m])。
代码实现时，第一个维度可以去掉。
代码 https://codeforces.com/contest/2025/submission/290823335
代码备份（洛谷）
======

Input
10 5
0 1 0 2 0 -3 0 -4 0 -5
Output
3

Input
3 1
1 -1 0
Output
0

Input
9 3
0 0 1 0 2 -3 -2 -2 1
Output
4
 */
