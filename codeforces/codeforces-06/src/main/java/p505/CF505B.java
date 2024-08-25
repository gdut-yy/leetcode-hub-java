package p505;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF505B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] abc = new int[m][3];
        for (int i = 0; i < m; i++) {
            abc[i][0] = scanner.nextInt();
            abc[i][1] = scanner.nextInt();
            abc[i][2] = scanner.nextInt();
        }
        int q = scanner.nextInt();
        int[][] uv = new int[q][2];
        for (int i = 0; i < q; i++) {
            uv[i][0] = scanner.nextInt();
            uv[i][1] = scanner.nextInt();
        }
        System.out.println(solve(n, m, abc, q, uv));
    }

    private static String solve(int n, int m, int[][] abc, int q, int[][] uv) {
        Map<Integer, DSU> dsuMap = new HashMap<>();
        for (int[] tuple : abc) {
            int x = tuple[0] - 1, y = tuple[1] - 1, color = tuple[2];
            dsuMap.computeIfAbsent(color, key -> new DSU(n)).union(x, y);
        }

        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            int x = uv[i][0] - 1, y = uv[i][1] - 1;
            int cnt = 0;
            for (DSU dsu : dsuMap.values()) {
                if (dsu.find(x) == dsu.find(y)) {
                    cnt++;
                }
            }
            ans[i] = cnt;
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }

    private static class DSU {
        int[] fa;

        public DSU(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
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
        }
    }
}
/*
B. Mr. Kitayuta's Colorful Graph
https://codeforces.com/contest/505/problem/B

灵茶の试炼 2023-05-22
题目大意：
输入 n(2≤n≤100) m(1≤m≤100) 表示一个 n 点 m 边的无向图，节点编号从 1 到 n。
然后输入 m 条边，每条边输入 v w c(1≤c≤m)，表示有条颜色为 c 的边连接 v 和 w。
然后输入 q(1≤q≤100) 和 q 个询问，每个询问输入 v w，你需要输出有多少种颜色 c 满足：从 v 到 w 存在一条路径，这条路径上的边均为颜色 c。
进阶：你能想出一个低于 O(平方) 的算法吗？
见 https://codeforces.com/contest/506/problem/D

rating 1400
https://codeforces.com/problemset/submission/505/206755341
由于数据范围比较小，用 m 个并查集统计，对每个询问遍历这 m 种颜色去统计 v 和 w 是否相连。
由于 m 比较小，并查集可以用哈希表实现。
相似题目: D. Mr. Kitayuta's Colorful Graph
https://codeforces.com/contest/506/problem/D
======

input
4 5
1 2 1
1 2 2
2 3 1
2 3 3
2 4 3
3
1 2
3 4
1 4
output
2
1
0

input
5 7
1 5 1
2 5 1
3 5 1
4 5 1
1 2 2
2 3 2
3 4 2
5
1 5
5 1
2 5
1 5
1 4
output
1
1
1
1
2
 */
