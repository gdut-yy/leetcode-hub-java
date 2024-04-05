package lq231223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LQ231223T6 {
    static int n, m;
    static char[][] g;

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        FastReader scanner = new FastReader();
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            g = new char[n][m];
            for (int i = 0; i < n; i++) {
                g[i] = scanner.next().toCharArray();
            }
            System.out.println(solve());
        }
    }

    static int cnt;

    private static String solve() {
        cnt = 0;
        dfs(0, 0);
        return cnt == 1 ? "Single" : "Multiple";
    }

    static void dfs(int x, int y) {
        if (cnt > 1) return;
        if (y >= m) {
            x++;
            y = 0;
        }
        if (x >= n) {
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (g[i][j] >= '1' && g[i][j] <= '9') {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) cnt++;
            return;
        }
        if (g[x][y] == '*') {
            boolean flag = true;
            for (int i = Math.max(x - 1, 0); i <= Math.min(x + 1, n - 1); i++) {
                for (int j = Math.max(y - 1, 0); j <= Math.min(y + 1, m - 1); j++) {
                    if (g[i][j] == '0') {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                for (int i = Math.max(x - 1, 0); i <= Math.min(x + 1, n - 1); i++) {
                    for (int j = Math.max(y - 1, 0); j <= Math.min(y + 1, m - 1); j++) {
                        if (g[i][j] != '*') g[i][j]--;
                    }
                }
                dfs(x, y + 1);
                for (int i = Math.max(x - 1, 0); i <= Math.min(x + 1, n - 1); i++) {
                    for (int j = Math.max(y - 1, 0); j <= Math.min(y + 1, m - 1); j++) {
                        if (g[i][j] != '*') g[i][j]++;
                    }
                }
            }
        }
        dfs(x, y + 1);
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
扫雷【算法赛】

搜索题，需要一些剪枝技巧。
观察题面条件，只存在 * 和数字字符，并且至少存在一种解。
那么我们考虑枚举每个 * 是否是地雷，如果是地雷，那么周围的数组块的值就要减一，最后判断一下所有的数字块是否是 0 即可。
由于数据量并不小，所以我们需要剪枝，一个 * 只有周围 8 个数字块是有用的，所以我们枚举每个数字块进行判断，判断周围的点是否是地雷，如果不合法就快速退出。
 */