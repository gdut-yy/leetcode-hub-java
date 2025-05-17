package p1301;

import base.Unaccepted;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

@Unaccepted
public class CF1301F {
    // Time limit exceeded on test 9
//    static Scanner scanner = new Scanner(System.in);
    static Reader scanner = new Reader();

    static int n, m, k;
    static final int MAX_N = 1010, MAX_K = 45;
    static int[][] grid = new int[MAX_N][MAX_N];
    static int[][][] cost = new int[MAX_K][MAX_N][MAX_N];
    //    static ArrayList<int[]>[] cells = new ArrayList[K];
    static boolean[] done = new boolean[MAX_K];

    // 链式前向星
    static int N = MAX_K, M = MAX_N * MAX_N;
    static int[] he = new int[N], ne = new int[M], ed = new int[M], we = new int[M];
    static int idx = 0;

    static void add(int u, int v, int w) {
        ed[idx] = v;
        ne[idx] = he[u];
        he[u] = idx;
        we[idx] = w;
        idx++;
    }

    public static void main(String[] args) throws IOException {
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();

//        Arrays.setAll(cells, e -> new ArrayList<>());
        Arrays.fill(he, -1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = scanner.nextInt();
//                cells[grid[i][j]].add(new int[]{i, j});
                add(grid[i][j], i, j);
            }
        }
        System.out.println(solve());
    }

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    // https://codeforces.com/blog/entry/73877
    private static String solve() throws IOException {
        for (int i = 0; i < MAX_K; i++) {
            for (int j = 0; j < MAX_N; j++) {
                Arrays.fill(cost[i][j], -1);
            }
        }
        for (int i = 1; i <= k; i++) BFS(i);

        int q = scanner.nextInt();
        int[] ans = new int[q];
        for (int qi = 0; qi < q; qi++) {
            int r1 = scanner.nextInt() - 1;
            int c1 = scanner.nextInt() - 1;
            int r2 = scanner.nextInt() - 1;
            int c2 = scanner.nextInt() - 1;

            int res = Math.abs(r1 - r2) + Math.abs(c1 - c2);
            for (int i = 1; i <= k; i++) {
                res = Math.min(res, 1 + cost[i][r1][c1] + cost[i][r2][c2]);
            }
            ans[qi] = res;
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }

    static queue q = new queue(2 * MAX_N * MAX_N);

    static void BFS(int col) {
        q.clear();
//        Queue<Integer> q = new ArrayDeque<>();
//        for (int[] cell : cells[col]) {
//            cost[col][cell[0]][cell[1]] = 0;
//            q.add(cell[0]);
//            q.add(cell[1]);
//        }
        for (int i = he[col]; i != -1; i = ne[i]) {
            int x = ed[i], y = we[i];
            cost[col][x][y] = 0;
            q.add(x);
            q.add(y);
        }
        for (int i = 1; i <= k; i++) done[i] = false;
        int r, c, nr, nc;
        while (!q.isEmpty()) {
            r = q.poll();
            c = q.poll();
            if (!done[grid[r][c]]) {
                done[grid[r][c]] = true;
//                for (int[] cell : cells[grid[r][c]]) {
//                    nr = cell[0];
//                    nc = cell[1];
                for (int i = he[grid[r][c]]; i != -1; i = ne[i]) {
                    nr = ed[i];
                    nc = we[i];
                    if (cost[col][nr][nc] == -1) {
                        cost[col][nr][nc] = cost[col][r][c] + 1;
                        q.add(nr);
                        q.add(nc);
                    }
                }
            }
            for (int i = 0; i < 4; i++) {
                nr = r + dr[i];
                nc = c + dc[i];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && cost[col][nr][nc] == -1) {
                    cost[col][nr][nc] = cost[col][r][c] + 1;
                    q.add(nr);
                    q.add(nc);
                }
            }
        }
    }

    // 手写队列 https://codeforces.com/contest/1301/submission/71005057
    static class queue {
        int[] v;
        int l, r;

        public queue(int sz) {
            v = new int[sz + 2];
            l = r = 0;
        }

        boolean isEmpty() {
            return l == r;
        }

        void clear() {
            l = r = 0;
        }

        void add(int x) {
            v[r++] = x;
        }

        int poll() {
            return v[l++];
        }
    }

    //    static class FastReader {
//        private final BufferedReader bufferedReader;
//        private StringTokenizer stringTokenizer;
//
//        public FastReader() {
//            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        }
//
//        public String next() {
//            while (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
//                try {
//                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            return stringTokenizer.nextToken();
//        }
//
//        public int nextInt() {
//            return Integer.parseInt(next());
//        }
//
//        public long nextLong() {
//            return Long.parseLong(next());
//        }
//
//        public double nextDouble() {
//            return Double.parseDouble(next());
//        }
//
//        public String nextLine() {
//            String str = "";
//            try {
//                if (stringTokenizer.hasMoreTokens()) {
//                    str = stringTokenizer.nextToken("\n");
//                } else {
//                    str = bufferedReader.readLine();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return str;
//        }
//    }
    static class Reader {
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
F. Super Jaber
https://codeforces.com/contest/1301/problem/F

灵茶の试炼 2024-09-06
题目大意：
输入 n m(1≤n,m≤1000) k(1≤k≤min(40,nm)) 和 n 行 m 列的网格图，元素范围 [1,k]。
有 k 种颜色，格子的值表示格子的颜色。保证每种颜色至少有一个对应的格子。
然后输入 q(1≤q≤1e5) 和 q 个询问，每个询问输入起点格子行列编号 (r1,c1) 和终点格子行列编号 (r2,c2)。编号从 1 开始。
每次操作，你可以移动到上下左右的相邻格子，或者传送到任意和当前格子颜色相同的格子。
对于每个询问，输出从起点到终点的最小操作次数。

rating 2600
答案分为两种情况：
1. 不使用传送。答案为起点到终点的曼哈顿距离。
2. 使用传送。首先，有如下性质：
对于同色的格子，传送操作在整个过程中至多执行一次。考虑 A->B->...->C->D，如果 A->B 和 C->D 都是传送操作，且 ABCD 颜色都一样，那不如直接 A->D 传送更优。
基于该性质，枚举一定使用了传送操作的颜色是 1,2,3,...,k。
假如一定在颜色为 3 的格子之间使用了一次传送，那么移动过程为：
起点 -> ... -> 颜色 3 -> 颜色 3 -> ... -> 终点。
最小操作次数，等于如下三种操作次数之和：
1. 从起点到颜色 3 的最小操作次数，这等价于从颜色 3 到起点的最小操作次数。
2. 从颜色 3 传送到颜色 3，这恰好是一次操作。
3. 从颜色 3 到终点的最小操作次数。
用多源 BFS 解决【从颜色 3 到 (x,y) 的最小操作次数】。
一开始把所有颜色为 3 的格子（坐标）入队。并标记颜色 3 使用了传送。
当一个格子出队时：
1. 把上下左右的相邻格子入队，距离加一。
2. 把与该格子同色的其他格子都入队（如果这个颜色之前没有使用过传送），距离加一，同时标记该颜色使用了传送。
3. 入队之前检查，如果格子之前入队过，则不入队。
代码 https://codeforces.com/contest/1301/submission/262323520
======

Input
3 4 5
1 2 1 3
4 4 5 5
1 2 1 3
2
1 1 3 4
2 2 2 2
Output
2
0

Input
4 4 8
1 2 2 8
1 3 4 7
5 1 7 6
2 3 8 8
4
1 1 2 2
1 1 3 4
1 1 2 4
1 1 4 4
Output
2
3
3
4
 */
