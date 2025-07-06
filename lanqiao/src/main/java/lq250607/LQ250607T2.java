package lq250607;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LQ250607T2 {
    static FastReader scanner = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int e = scanner.nextInt();
        int d = scanner.nextInt();

        // s->e
        int res1 = getDis(n, s, e); // 他只能顺时针向前移动

        int res2 = getDis(n, (s + d) % n, e); // 向前移动 d 格区域

        int res3 = getDis(n, ((s - d) % n + n) % n, e);  // 向后移动 d 格区域

        int ans = min(res1 % n, res2 % n, res3 % n);
        out.println(ans);
    }

    static int getDis(int n, int s, int e) {
        return (e >= s) ? e - s : (e + n - s);
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
赛飞儿之旅【算法赛】

5 2 1 0
5 2 1 2
 */