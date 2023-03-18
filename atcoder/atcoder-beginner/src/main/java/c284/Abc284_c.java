package c284;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc284_c {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        DSU dsu = new DSU(N);
        for (int i = 0; i < M; i++) {
            int u = scanner.nextInt() - 1;
            int v = scanner.nextInt() - 1;
            dsu.union(u, v);
        }
        System.out.println(dsu.sz);
    }

    private static class DSU {
        int[] fa;
        int sz;

        public DSU(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
            sz = n;
        }

        int find(int x) {
            if (x != fa[x]) {
                fa[x] = find(fa[x]);
            }
            return fa[x];
        }

        void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            fa[rootQ] = rootP;
            sz--;
        }
    }
}
/*
C - Count Connected Components
https://atcoder.jp/contests/abc284/tasks/abc284_c
 */