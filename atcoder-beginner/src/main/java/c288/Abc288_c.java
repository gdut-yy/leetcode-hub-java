package c288;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc288_c {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int res = 0;
        DSU dsu = new DSU(n);
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt() - 1;
            int b = scanner.nextInt() - 1;
            int fa = dsu.find(a);
            int fb = dsu.find(b);
            if (fa == fb) {
                res++;
            } else {
                dsu.union(a, b);
            }
        }
        System.out.println(res);
    }

    static class DSU {
        // 父节点数组/祖先数组
        int[] fa;

        // 初始化
        public DSU(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
        }

        // 查找
        int find(int x) {
            // 路径压缩
            if (x != fa[x]) {
                fa[x] = find(fa[x]);
            }
            return fa[x];
        }

        // 合并
        void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            fa[rootQ] = rootP;
        }
    }
}
/*
C - Don’t be cycle
https://atcoder.jp/contests/abc288/tasks/abc288_c

给定一个简单的无向图，有N个顶点和M条边。顶点编号为1到N，第i条边连接顶点i和顶点i。让我们删除零条或多条边来从图中删除循环。找出为此目的必须删除的边的最小数目。
 */