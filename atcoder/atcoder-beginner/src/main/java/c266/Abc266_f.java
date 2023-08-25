package c266;

import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Abc266_f {
    static int n, q;
    static int[] deg;
    static Map<Integer, List<Integer>> adj;
    static int[][] xy;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        adj = new HashMap<>();
        deg = new int[n];
        for (int i = 0; i < n; i++) {
            int v = scanner.nextInt() - 1;
            int w = scanner.nextInt() - 1;
            adj.computeIfAbsent(v, key -> new ArrayList<>()).add(w);
            adj.computeIfAbsent(w, key -> new ArrayList<>()).add(v);
            deg[v]++;
            deg[w]++;
        }
        q = scanner.nextInt();
        xy = new int[q][2];
        for (int i = 0; i < q; i++) {
            xy[i][0] = scanner.nextInt();
            xy[i][1] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    static int id;
    static int[] ids;

    private static String solve() {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (deg[i] == 1) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int v = queue.remove();
            for (Integer w : adj.getOrDefault(v, new ArrayList<>())) {
                deg[w]--;
                if (deg[w] == 1) {
                    queue.add(w);
                }
            }
        }
        id = 0;
        ids = new int[n];
        for (int i = 0; i < n; i++) {
            if (deg[i] > 1) {
                id++;
                dfs(i, -1);
            }
        }

        String[] ans = new String[q];
        for (int i = 0; i < q; i++) {
            int v = xy[i][0], w = xy[i][1];
            ans[i] = (ids[v - 1] == ids[w - 1]) ? "Yes" : "No";
        }
        return String.join(System.lineSeparator(), ans);
    }

    private static void dfs(int v, int fa) {
        ids[v] = id;
        for (Integer w : adj.getOrDefault(v, new ArrayList<>())) {
            if (w != fa && deg[w] < 2) {
                dfs(w, v);
            }
        }
    }
}
/*
F - Well-defined Path Queries on a Namori
https://atcoder.jp/contests/abc266/tasks/abc266_f

灵茶の试炼 2022-12-20
题目大意：
输入 n (3≤n≤2e5) 和 n 条边，点的编号在 [1,n] 内，表示一个没有重边和自环的无向连通图。
然后输入 q(≤2e5) 表示有 q 个询问，每个询问输入两个数 x 和 y (1≤x<y≤n)。
对于每个询问，如果 x 和 y 之间只存在唯一的简单路径，则输出 Yes，否则输出 No。

https://atcoder.jp/contests/abc266/submissions/37391833
基环树问题的套路题。
讲解见我之前写的教程 https://leetcode.cn/problems/maximum-employees-to-be-invited-to-a-meeting/solutions/1187830/nei-xiang-ji-huan-shu-tuo-bu-pai-xu-fen-c1i1b/
往下翻到「下面介绍基环树问题的通用处理方法……」处。
======

Input 1
5
1 2
2 3
1 3
1 4
2 5
3
1 2
1 4
1 5
Output 1
No
Yes
No

Input 2
10
3 5
5 7
4 8
2 9
1 2
7 9
1 6
4 10
2 5
2 10
10
1 8
6 9
8 10
6 8
3 10
3 9
1 10
5 8
1 10
7 8
Output 2
Yes
No
Yes
Yes
No
No
Yes
No
Yes
No
 */