package p13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF13E {
    static int n, m;
    static int mx = (int) (1e5 + 5);
    static int[] a;
    static int[] data_last;
    static int[] data_jump;

    public static void main(String[] args) throws IOException {
        // Time limit exceeded on test 6
//        Scanner scanner = new Scanner(System.in);
        FastReader scanner = new FastReader();
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        data_last = new int[n];
        data_jump = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            f(i);
        }
        StringBuilder ans = new StringBuilder();
        int last = 0;
        while (m-- > 0) {
            int op = scanner.nextInt();
            int p = scanner.nextInt() - 1;
            if (op == 0) {
                int v = scanner.nextInt();

                a[p] = v;
                for (int i = p; i >= p - p % B; i--) {
                    f(i);
                }
            } else {
                int jump = 0;
                for (; p < n; p = last + a[last]) {
                    jump += data_jump[p] + 1;
                    last = data_last[p];
                }
                String res = (last + 1) + " " + jump;
                ans.append(res).append(System.lineSeparator());
            }
        }
        System.out.println(ans);
    }

    static int B = 400;

    static void f(int i) {
        if (i + a[i] >= n || i / B != (i + a[i]) / B) {
            data_last[i] = i;
            data_jump[i] = 0;
        } else {
            data_last[i] = data_last[i + a[i]];
            data_jump[i] = data_jump[i + a[i]] + 1;
//            data_jump[i]++;
        }
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
E. Holes
https://codeforces.com/contest/13/problem/E

灵茶の试炼 2023-11-03
题目大意：
输入 n(1≤n≤1e5) m(1≤m≤1e5) 和长为 n 的数组 a(1≤a[i]≤n)，数组下标从 1 开始。
然后输入 m 个操作，输入格式如下：
"0 p v" 表示把 a[p] 改成 v。
"1 p" 表示从位置 p 开始向右跳，每次更新 p=p+a[p]，直到 p>n。输出最后一次 <=n 的位置，以及当 p>n 时跳了多少次。
(1≤p,v≤n)

rating 2700
分块，每块大小 sqrt(n)=316。（注：改成 500 可能更快一些）
把每块看成一个单独的问题，算出这一块中的每个下标 i，在跳出这个块之前，最后一次的位置 last 和跳跃次数 jump。
一开始可以倒着 O(n) 递推算出所有的 last 和 jump。
对于操作 0，用 O(sqrt(n)) 的时间更新 p 所在块的 last 和 jump
对于操作 1，用每一块的 last 和 jump 来快速跳跃，这样只需要 O(sqrt(n)) 就可以跳出数组。
注意本题有点卡常，记得把块大小设为一个常量。
代码中，我的下标是从 0 开始的，输出的时候再加一。
https://codeforces.com/problemset/submission/13/231055822
======

input
8 5
1 1 1 1 1 2 8 2
1 1
0 1 3
1 1
0 3 4
1 2
output
8 7
8 5
7 3
 */
