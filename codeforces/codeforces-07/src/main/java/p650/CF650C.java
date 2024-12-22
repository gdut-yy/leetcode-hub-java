package p650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class CF650C {
    static int n, m;
    static int[][] a;

    public static void main(String[] args) throws IOException {
        FastReader scanner = new FastReader();
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        System.out.println(solve());
    }

    private static String solve() {
        int[][] ans = matrixRankTransform(a);
        return Arrays.stream(ans)
                .map(row -> Arrays.stream(row).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    // CF650C
    // https://codeforces.com/contest/650/submission/16573674
    static int[][] matrixRankTransform(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int nm = n * m;
        int k = 0;
        Pair[] p = new Pair[nm];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                p[k++] = new Pair(i, j, matrix[i][j]);
            }
        }
        Arrays.sort(p, Comparator.comparingInt(o -> o.v));

        int[][] a = new int[n][m];
        int[] row = new int[n + 2];
        int[] col = new int[m + 2];
        for (int i = 0; i < nm; ) {
            int st = i;
            for (i++; i < nm && p[i].v == p[st].v; i++) {
            }

            DSU ds = new DSU(i - st);
            Pair[] A = new Pair[i - st];
            Pair[] B = new Pair[i - st];

            for (k = st; k < i; k++) {
                A[k - st] = new Pair(p[k].x, p[k].y, k - st);
                B[k - st] = new Pair(p[k].x, p[k].y, k - st);
                ds.max[k - st] = Math.max(row[p[k].x], col[p[k].y]);
            }

            Arrays.sort(A, Comparator.comparingInt(o -> o.x));
            Arrays.sort(B, Comparator.comparingInt(o -> o.y));

            for (int x = 1; x < (i - st); x++) {
                if (A[x].x == A[x - 1].x) {
                    ds.union(A[x].v, A[x - 1].v);
                }
                if (B[x].y == B[x - 1].y) {
                    ds.union(B[x].v, B[x - 1].v);
                }
            }

            for (int x = st; x < i; x++) {
                int v = ds.max[ds.find(x - st)] + 1;
                a[p[x].x][p[x].y] = v;
                row[p[x].x] = Math.max(row[p[x].x], v);
                col[p[x].y] = Math.max(col[p[x].y], v);
            }
        }
        return a;
    }

    static class Pair {
        int x, y, v;

        public Pair(int x, int y, int v) {
            this.x = x;
            this.y = y;
            this.v = v;
        }
    }

    static class DSU {
        int[] fa;
        int[] max;

        public DSU(int n) {
            fa = new int[n];
            max = new int[n];
            for (int i = 0; i < n; i++) fa[i] = i;
        }

        int find(int x) {
            return x == fa[x] ? fa[x] : (fa[x] = find(fa[x]));
        }

        void union(int p, int q) {
            p = find(p);
            q = find(q);
            if (p == q) return;
            max[p] = max[q] = Math.max(max[p], max[q]);
            fa[q] = p;
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
C. Table Compression
https://codeforces.com/contest/650/problem/C

题目大意：
小 Petya 现在对数据压缩算法情有独钟。他已经学习了 gz、bz、zip 算法和许多其他算法。受新知识的启发，Petya 正在开发新的压缩算法，并将其命名为dis。
Petya 决定压缩表格。他得到了一个由 n 行和 m 列组成的表 a ，该表填充的是正整数。他希望建立一个由正整数组成的表 a' ，使得每行和每列中元素的相对顺序保持不变。也就是说，如果初始表的某一行 i 中有 ai, j < ai, k ，那么生成表中就有 a'i, j < a'i, k ；如果有 ai, j = ai, k ，那么生成表中就有 a'i, j = a'i, k 。同样，如果初始表 ai, j < ap, j 的某列 j 中出现 a'i, j < a'p, j ，那么压缩表中出现 a'i, j < a'p, j ，如果出现 ai, j = ap, j ，那么出现 a'i, j = a'p, j 。
由于大值需要更多空间来存储，因此 a' 中的最大值应尽可能小。
Petya 的理论很好，但他需要你的帮助来实现算法。

rating 2200
相似题目: 1632. 矩阵转换后的秩
https://leetcode.cn/problems/rank-transform-of-a-matrix/description/
======

Input
2 2
1 2
3 4
Output
1 2
2 3

Input
4 3
20 10 30
50 40 30
50 60 70
90 80 70
Output
2 1 3
5 4 3
5 6 7
9 8 7
 */