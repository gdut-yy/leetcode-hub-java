package p1829;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CF1829F {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[][] edges = new int[m][2];
            for (int i = 0; i < m; i++) {
                edges[i][0] = scanner.nextInt();
                edges[i][1] = scanner.nextInt();
            }
            System.out.println(solve(n, m, edges));
        }
    }

    private static String solve(int n, int m, int[][] edges) {
        int[] degree = new int[n + 1];
        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int deg : degree) {
            cntMap.put(deg, cntMap.getOrDefault(deg, 0) + 1);
        }

        // x * y = deg1
        // x * (y+1) + 1 = n
        int deg1 = cntMap.get(1);
        int x = n - deg1 - 1;
        int y = deg1 / x;
        return x + " " + y;
    }
}
/*
F. Forever Winter
https://codeforces.com/contest/1829/problem/F

题目大意：
由两个大于 1 的整数 x 和 y 生成雪花图，如下:
- 从一个中心顶点开始。
- 连接 x 个新顶点到这个中心顶点。
- 将 y 个新顶点连接到这 x 个顶点上。
例如，下面是 x=5, y=3 的雪花图。
上面的雪花图有一个中心顶点 15，然后 x=5 个顶点附在上面(3,6,7,8 和 20)，然后 y=3 个顶点附在每个顶点上。
给定一个雪花图，确定 x 和 y 的值。
对于某些大于 1 的整数 x 和 y，可以保证这个图是雪花图。

统计度为 1 的节点数量，解方程。
======

input
3
21 20
21 20
5 20
13 20
1 3
11 3
10 3
4 8
19 8
14 8
9 7
12 7
17 7
18 6
16 6
2 6
6 15
7 15
8 15
20 15
3 15
7 6
1 2
1 3
2 4
2 5
3 6
3 7
9 8
9 3
3 6
6 2
2 1
5 2
2 7
4 3
3 8
output
5 3
2 2
2 3
 */

