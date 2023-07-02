package p980;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class CF980E {
    static int n, k;

    public static void main(String[] args) throws IOException {
        // only java 8/11 AC, java 17 64bit MLE
        Reader scanner = new Reader();
        n = scanner.nextInt();
        k = scanner.nextInt();
        Arrays.fill(he, -1);
        for (int i = 0; i < n - 1; i++) {
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;
            add(x, y);
            add(y, x);
        }
        solve();
    }

    static int N = (int) (1e6), M = N * 2;
    // 链式前向星
    static int[] he = new int[N], ne = new int[M], ed = new int[M];
    //    static int[] we = new int[M];
    static int idx = 0;

    static void add(int u, int v) {
        ed[idx] = v;
        ne[idx] = he[u];
        he[u] = idx;
//        we[idx] = w;
        idx++;
    }

    // 2^20 = 1048576 > 1e6
    private static final int mx = 19;
    private static int[][] pa;
    private static int[] depth;

    private static void solve() {
        pa = new int[n][mx];
        depth = new int[n];
        dfs(n - 1, -1, 0);

        for (int i = 0; i + 1 < mx; i++) {
            for (int v = 0; v < n; v++) {
                int p = pa[v][i];
                if (p != -1) {
                    pa[v][i + 1] = pa[p][i];
                } else {
                    pa[v][i + 1] = -1;
                }
            }
        }

        boolean[] save = new boolean[n];
        save[n - 1] = true;
        for (int i = n - 2, left = n - 1 - k; i >= 0; i--) {
            if (save[i]) {
                continue;
            }
            int v = i;
            for (int j = mx - 1; j >= 0; j--) {
                int p = pa[v][j];
                if (p != -1 && !save[p]) {
                    v = p;
                }
            }
            int d = depth[i] - depth[v] + 1;
            if (d <= left) {
                left -= d;
                for (v = i; !save[v]; v = pa[v][0]) {
                    save[v] = true;
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (!save[i]) {
                ans.append(i + 1).append(" ");
            }
        }
        System.out.println(ans);
    }

    private static void dfs(int x, int fa, int d) {
        pa[x][0] = fa;
        depth[x] = d;
        for (int i = he[x]; i != -1; i = ne[i]) {
            int y = ed[i];
            if (y == fa) continue;
            dfs(y, x, d + 1);
        }
    }

    private static class Reader {
        private final int BUFFER_SIZE = 1 << 16;
        private final DataInputStream dataInputStream;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            dataInputStream = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            dataInputStream = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    } else {
                        continue;
                    }
                }
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg) {
                c = read();
            }
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg) {
                return -ret;
            }
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg) {
                c = read();
            }
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg) {
                return -ret;
            }
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg) {
                c = read();
            }
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
            if (neg) {
                return -ret;
            }
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = dataInputStream.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) {
                buffer[0] = -1;
            }
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) {
                fillBuffer();
            }
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            dataInputStream.close();
        }
    }
}
/*
E. The Number Games
https://codeforces.com/contest/980/problem/E

题目大意：
Panel 国家每年举办一次名为“数字游戏”的节目，全国每个地区将有一名选手代表。
全国有 n 个区，编号从 1 到 n，每个区都有一条路径连接到其他区。i 区选手的粉丝数等于 2^i。
今年，总统决定降低成本。他想让 k 名选手退出比赛。然而，被淘汰选手所在的地区将会非常愤怒，不允许任何人穿过他们的地区。
总统想要确保所有剩下的参赛者都来自彼此可以联系到的地区。他还希望最大限度地增加参赛选手的粉丝总数。
总统应该淘汰哪些选手?

卡内存题，，
rating 2200
树上倍增
https://codeforces.com/contest/980/submission/119702564
======

input
6 3
2 1
2 6
4 2
5 6
2 3
output
1 3 4

input
8 4
2 6
2 7
7 8
1 2
3 1
2 4
7 5
output
1 3 4 5
 */
