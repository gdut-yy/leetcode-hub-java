package p388;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CF388B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int k = scanner.nextInt();
        System.out.println(solve(k));
    }

    // 2^0 ~ 2^29
    private static String solve(int num) {
        // 1 ~ 92
        char[][] adj = new char[93][93];
        for (char[] row : adj) {
            Arrays.fill(row, 'N');
        }

        for (int k = 0; k < 30; k++) {
            // a1   a  -  a'
            //    / |  x  |
            // b1 - b  -  b'
            //      ?     ?
            // c1   c  -  c'
            int a = 3 * k + 3, b = a + 1, c = b + 1;
            int a1 = 3 * k, b1 = a1 + 1, c1 = b1 + 1;
            // b1-a, b1-b, a-b
            adj[b1][a] = adj[a][b1] = 'Y';
            adj[b1][b] = adj[b][b1] = 'Y';
            adj[a][b] = adj[b][a] = 'Y';

            // b 连 c 相当于加上 2^k
            if ((num >> k & 1) == 1) {
                adj[b][c] = adj[c][b] = 'Y';
            }
            if (k >= 1) {
                // a1-a, a1-b, c1-c
                adj[a1][a] = adj[a][a1] = 'Y';
                adj[a1][b] = adj[b][a1] = 'Y';
                adj[c1][c] = adj[c][c1] = 'Y';
            }
        }
        // 2-92
        adj[2][92] = adj[92][2] = 'Y';

        List<String> resList = new ArrayList<>();
        resList.add("92");
        // Consider the graph vertexes are numbered from 1 to n.
        for (int i = 1; i < 93; i++) {
            resList.add(new String(adj[i]).substring(1));
        }
        return String.join(System.lineSeparator(), resList);
    }
}
/*
B. Fox and Minimal path
https://codeforces.com/contest/388/problem/B

灵茶の试炼 2023-02-28
输入 k(1≤k≤1e9)。
构造一个节点个数不超过 1000 的简单无向图（节点编号从 1 开始），使得从节点 1 到节点 2 的最短路径的数量恰好为 k。
输出 n 以及一个 n*n 的邻接矩阵 g，如果 i 和 j 之间有边，则 g[i][j]='Y'，否则为 'N'。
注意不能有自环，即 g[i][i] 必须为 'N'。

constructive algorithms
二进制构造。
k = x1 * 2^0 + x2 * 2^1 + ... + xn * 2^n
======

input
2
output
4
NNYY
NNYY
YYNN
YYNN

input
9
output
8
NNYYYNNN
NNNNNYYY
YNNNNYYY
YNNNNYYY
YNNNNYYY
NYYYYNNN
NYYYYNNN
NYYYYNNN

input
1
output
2
NY
YN
 */
