package didi;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class DD2020008 {
    static Scanner scanner;
    static PrintWriter out;
    static int[] parent;
    static int[] vertexCnt;
    static int[] edgeCnt;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
        // t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        try {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            int[][] edges = new int[N][3];
            for (int i = 0; i < N; i++) {
                edges[i][0] = scanner.nextInt(); // a
                edges[i][1] = scanner.nextInt(); // b
                edges[i][2] = scanner.nextInt(); // c
            }

            // 按能力值降序排序
            Arrays.sort(edges, (e1, e2) -> Integer.compare(e2[2], e1[2]));

            parent = new int[M + 1];
            vertexCnt = new int[M + 1];
            edgeCnt = new int[M + 1];
            for (int i = 1; i <= M; i++) {
                parent[i] = i;
                vertexCnt[i] = 1;
                edgeCnt[i] = 0;
            }

            long ans = 0;
            for (int[] e : edges) {
                int a = e[0], b = e[1], c = e[2];
                int ra = find(a);
                int rb = find(b);

                if (ra != rb) {
                    // 两个不同连通分量，至少有一个未满才能合并
                    if (edgeCnt[ra] < vertexCnt[ra] || edgeCnt[rb] < vertexCnt[rb]) {
                        ans += c;
                        // 按顶点数合并，小的合到大的
                        if (vertexCnt[ra] < vertexCnt[rb]) {
                            parent[ra] = rb;
                            vertexCnt[rb] += vertexCnt[ra];
                            edgeCnt[rb] += edgeCnt[ra] + 1;
                        } else {
                            parent[rb] = ra;
                            vertexCnt[ra] += vertexCnt[rb];
                            edgeCnt[ra] += edgeCnt[rb] + 1;
                        }
                    }
                } else {
                    // 同一连通分量，未满则可以加入
                    if (edgeCnt[ra] < vertexCnt[ra]) {
                        ans += c;
                        edgeCnt[ra]++;
                    }
                }
            }

            out.println(ans);
        } catch (Exception e) {
            out.println(0);
        }
    }

    private static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}
/*
DD-2020008. 工人调度
https://leetcode.cn/problems/sRI8mk/

某工厂有 N 名工人和 M 台机器，每名工人都有一个能力值，且只懂得操作其中某两台机器。另外，每名工人最多只允许操作一台机器，且每台机器最多只允许被一名工人操作。
那么如何分配每名工人操作哪台机器(或者不操作机器)，才能让所有操作机器的工人的能力值总和最大?
格式：
输入：
- 第一行输入两个整数 N 和 M。
- 接下来 N 行，第 i 行输入三个整数 a、b 和 c，表示第 i 名工人只懂得操作第 a 台和第 b 台机器，且其能力值为 c 。
输出：
- 输出所有操作机器的工人的能力值总和的最大值。
示例：
输入：
3 3
1 2 1
1 2 2
1 2 3
输出：5
提示：
1 ≤ N，M ≤ 10^5
1 ≤ a < b ≤ M
1 ≤ c ≤ 10^9
 */