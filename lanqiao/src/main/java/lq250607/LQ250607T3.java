package lq250607;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LQ250607T3 {
    static FastReader scanner = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        char[] s = scanner.next().toCharArray();
        int n = s.length;
        int[][] cnt = new int[4][26];
        for (int i = 0; i < n; i++) {
            cnt[i % 4][s[i] - 'a']++;
        }

        int[] x = new int[4];
        int cb = cnt[0]['b' - 'a'];
        int cl = cnt[1]['l' - 'a'];
        int cu = cnt[2]['u' - 'a'];
        int ce = cnt[3]['e' - 'a'];
        x[0] = min(cb, cl, cu, ce);

        cb = cnt[1]['b' - 'a'];
        cl = cnt[2]['l' - 'a'];
        cu = cnt[3]['u' - 'a'];
        ce = cnt[0]['e' - 'a'];
        x[1] = min(cb, cl, cu, ce);

        cb = cnt[2]['b' - 'a'];
        cl = cnt[3]['l' - 'a'];
        cu = cnt[0]['u' - 'a'];
        ce = cnt[1]['e' - 'a'];
        x[2] = min(cb, cl, cu, ce);

        cb = cnt[3]['b' - 'a'];
        cl = cnt[0]['l' - 'a'];
        cu = cnt[1]['u' - 'a'];
        ce = cnt[2]['e' - 'a'];
        x[3] = min(cb, cl, cu, ce);

        // 贪心选起点
        int ans = 0;
        int i = 0;
        int M = n - 4; // 最大起点索引
        while (i <= M) {
            int c = i % 4;
            if (x[c] > 0) {
                // 取这个起点
                ans++;
                x[c]--;
                i += 4;  // 跳过 3 个重叠位置
            } else {
                i++;
            }
        }
        out.println(ans);
    }

    static int min(int... values) {
        int mixValue = Integer.MAX_VALUE;
        for (int i : values) {
            if (i < mixValue) {
                mixValue = i;
            }
        }
        return mixValue;
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
blue密钥【算法赛】
 */