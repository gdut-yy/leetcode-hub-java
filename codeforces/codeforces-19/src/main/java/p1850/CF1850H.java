package p1850;

import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class CF1850H {
    static int n, m;
    static int[][] abd;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            abd = new int[m][3];
            for (int i = 0; i < m; i++) {
                abd[i][0] = scanner.nextInt();
                abd[i][1] = scanner.nextInt();
                abd[i][2] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    static Map<Integer, List<int[]>> adj;

    // https://codeforces.com/contest/1850/submission/214808565
    private static String solve() {
        adj = new HashMap<>();
        for (int[] p : abd) {
            int x = p[0] - 1, y = p[1] - 1, d = p[2];
            adj.computeIfAbsent(x, key -> new ArrayList<>()).add(new int[]{y, d});
            adj.computeIfAbsent(y, key -> new ArrayList<>()).add(new int[]{x, -d});
        }

        boolean[] vis = new boolean[n];
        long[] dist = new long[n];
        for (int i = 0; i < n; i++) {
            if (vis[i]) continue;
            vis[i] = true;
            dist[i] = 0;

            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(i);
            while (!queue.isEmpty()) {
                int x = queue.remove();
                for (int[] p : adj.getOrDefault(x, new ArrayList<>())) {
                    int y = p[0], d = p[1];
                    if (vis[y]) {
                        if (dist[y] != dist[x] + d) {
                            return "NO";
                        }
                    } else {
                        vis[y] = true;
                        dist[y] = dist[x] + d;
                        queue.add(y);
                    }
                }
            }
        }
        return "YES";
    }
}
/*
H. The Third Letter
https://codeforces.com/contest/1850/problem/H

灵茶の试炼 2025-12-17
题目大意：
为了赢得这场最艰难的战斗，米尔恰为他的军队想出了一个伟大的战略。他有 n 名士兵，并决定把他们按某种方式安排在营地里。每个士兵必须只属于一个营地，并且在 x 轴上的每个整数点(在点 ...,−2,−1,0,1,2,...)上都有一个营地。
该策略包含 m 个条件。条件 i 告诉士兵 ai 应该属于一个营地，该营地位于士兵 ai 所属营地的前方 di 米。(如果 di<0，那么 ai 的营地应该在 bi 的营地后面 -di 米。)
现在，米尔恰想知道是否存在尊重这种情况的士兵分区，他请求你的帮助！如果 n 个士兵中有一个分区满足所有 m 个条件，回答“是”，否则回答“否”。
注意，两个不同的士兵可能被安置在同一个营地。
---
对于第一个测试用例，我们可以按照以下方式将士兵划分为营地:
Soldier 1 in the camp with the coordinate x=3 .
Soldier 2 in the camp with the coordinate x=5 .
Soldier 3 in the camp with the coordinate x=9 .
Soldier 4 in the camp with the coordinate x=11 .
对于第二个测试用例，没有分区可以同时满足所有的约束。
对于第三个测试用例，不存在满足所有约束的分区，因为我们得到了关于同一对的矛盾信息。
对于第四个测试用例，为了满足唯一的条件，一个可能的分区是:
Soldier 1 in the camp with the coordinate x=10 .
Soldier 2 in the camp with the coordinate x=13 .
Soldier 3 in the camp with the coordinate x=−2023 .
Soldier 4 in the camp with the coordinate x=−2023 .

建图，判定。
======

input
4
5 3
1 2 2
2 3 4
4 2 -6
6 5
1 2 2
2 3 4
4 2 -6
5 4 4
3 5 100
2 2
1 2 5
1 2 4
4 1
1 2 3
output
YES
NO
NO
YES
 */
