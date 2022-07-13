package p1702;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class CF1702E {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(reader.readLine());
            String[] lineNs = new String[n];
            for (int j = 0; j < n; j++) {
                lineNs[j] = reader.readLine();
            }
            writer.write(solution(n, lineNs).concat(System.lineSeparator()));
        }
        writer.close();
        reader.close();
    }

    private static String solution(int n, String[] lineNs) {
        UnionFind unionFind = new UnionFind(n);
        int[] cntArr = new int[n + 1];
        for (String line : lineNs) {
            String[] lines = line.split(" ");
            int a = Integer.parseInt(lines[0]);
            int b = Integer.parseInt(lines[1]);
            if (a == b) {
                return "NO";
            }
            cntArr[a]++;
            cntArr[b]++;
            unionFind.union(a, b);
        }

        for (int i = 1; i <= n; i++) {
            if (cntArr[i] != 2) {
                return "NO";
            }
        }

        for (int i = 1; i <= n; i++) {
            int fa = unionFind.find(i);
            if (unionFind.count[fa] % 2 != 0) {
                return "NO";
            }
        }
        return "YES";
    }

    private static class UnionFind {
        // 记录每个节点的父节点
        int[] parent;
        // (可选) 连通分量
        int[] count;

        // 0 ~ n-1
        public UnionFind(int n) {
            parent = new int[n + 1];
            count = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                count[i] = 1;
            }
        }

        // 返回节点 x 的根节点
        private int find(int x) {
            int ret = x;
            while (ret != parent[ret]) {
                // 路径压缩
                parent[ret] = parent[parent[ret]];
                ret = parent[ret];
            }
            return ret;
        }

        // 将 p 和 q 连通
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP != rootQ) {
                if (rootP < rootQ) {
                    parent[rootQ] = rootP;
                    count[rootP] += count[rootQ];
                } else {
                    parent[rootP] = rootQ;
                    count[rootQ] += count[rootP];
                }
            }
        }
    }
}
/*
E. Split Into Two Sets
https://codeforces.com/contest/1702/problem/E

题目大意：
给定偶数 n 和 n 行 ai bi，代表多米诺骨牌的两个整数，问是否能将牌分成两组，每组多米诺骨牌上的数字不同。

二部图判定，先比较 1 到 n 的频次是否均为 2。如果出现奇数环，则不是二部图。
======

input
6
4
1 2
4 3
2 1
3 4
6
1 2
4 5
1 3
4 6
2 3
5 6
2
1 1
2 2
2
1 2
2 1
8
2 1
1 2
4 3
4 3
5 6
5 7
8 6
7 8
8
1 2
2 1
4 3
5 3
5 4
6 7
8 6
7 8

output
YES
NO
NO
YES
YES
NO
 */