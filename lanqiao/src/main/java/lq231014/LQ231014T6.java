package lq231014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class LQ231014T6 {
    static int n, q;

    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        n = scanner.nextInt();
        q = scanner.nextInt();

        posL = new ArrayList[N];
        Arrays.setAll(posL, e -> new ArrayList<>());
        posR = new ArrayList[N];
        Arrays.setAll(posR, e -> new ArrayList<>());
        for (int i = 0; i < n; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            posL[l].add(r);
            posR[r].add(l);
        }
        query = new ArrayList[N];
        Arrays.setAll(query, e -> new ArrayList<>());
        for (int i = 0; i < q; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            query[a].add(new int[]{b, i});
        }
        System.out.println(solve());
    }

    private static final int N = (int) (2e5 + 5);
    static List<Integer>[] posL, posR;
    static List<int[]>[] query;

    private static String solve() {
        int[] ans = new int[q];

        Fenwick l2r = new Fenwick(N);
        for (int i = 1; i < N; i++) {
            for (Integer r : posL[i]) {
                l2r.add(r, 1);
            }
            for (int[] p : query[i]) {
                int b = p[0], id = p[1];
                if (b > i) {
                    ans[id] = l2r.getSum(b - 1);
                }
            }
            l2r.add(i, -posR[i].size());
        }

        Fenwick r2l = new Fenwick(N);
        for (int i = N - 1; i > 0; i--) {
            for (Integer l : posR[i]) {
                r2l.add(l, 1);
            }
            for (int[] p : query[i]) {
                int b = p[0], id = p[1];
                if (b < i) {
                    ans[id] = r2l.getSum(N) - r2l.getSum(b);
                }
            }
            r2l.add(i, -posL[i].size());
        }

        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }

    static class Fenwick {
        private final int n;
        private final int[] tree;

        public Fenwick(int n) {
            this.n = n;
            this.tree = new int[n + 1];
        }

        int lowbit(int x) {
            return x & -x;
        }

        // nums[x] add k
        void add(int x, int k) {
            while (x <= n) {
                tree[x] += k;
                x += lowbit(x);
            }
        }

        // nums [1,x] 的和
        int getSum(int x) {
            int ans = 0;
            while (x > 0) {
                ans += tree[x];
                x -= lowbit(x);
            }
            return ans;
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
奇怪的线段【算法赛】

离线 + 树状数组。
 */
