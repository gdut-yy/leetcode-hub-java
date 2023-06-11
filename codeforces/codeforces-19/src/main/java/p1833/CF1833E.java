package p1833;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CF1833E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve(n, a));
        }
    }

    private static Map<Integer, Set<Integer>> adj;
    private static boolean[] vis;
    private static int cntV, cntE;

    private static String solve(int n, int[] a) {
        adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = i, y = a[i] - 1;
            adj.computeIfAbsent(x, key -> new HashSet<>()).add(y);
            adj.computeIfAbsent(y, key -> new HashSet<>()).add(x);
        }
        // 满人
        int notFull = 0;
        int full = 0;
        vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                cntV = 0;
                cntE = 0;
                dfs(i);
                cntE /= 2;
                if (cntE == cntV) {
                    full++;
                } else {
                    notFull++;
                }
            }
        }
        int max = full + notFull;
        int min = full + (notFull > 0 ? 1 : 0);
        return min + " " + max;
    }

    private static void dfs(int x) {
        vis[x] = true;
        cntV++;
        Set<Integer> yList = adj.getOrDefault(x, new HashSet<>());
        cntE += yList.size();
        for (Integer y : yList) {
            if (vis[y]) continue;
            dfs(y);
        }
    }
}
/*
E. Round Dance
https://codeforces.com/contest/1833/problem/E

题目大意：
N 个人来到这个节日，决定跳几支圆舞。轮舞中至少有两个人，每个人正好有两个邻居。如果有两个人跳圆舞，那么他们两边的邻居都是一样的。
你决定要弄清楚到底有多少支舞。但是每个参加节日的人只记得一个邻居。你的任务是确定轮舞的最小和最大次数是多少。
例如，如果节日有 6 个人，他们记得的邻居的数量相等[2,1,4,3,6,5]，那么最少跳一轮舞的次数是 1:
1−2−3−4−5−6−1
and the maximum is 3 :
1−2−1
3−4−3
5−6−5

边去重。DFS 统计 "饱和连通分量" 和 "不饱和连通分量"，其中：
最小值 = "饱和连通分量" + ("不饱和连通分量" > 0 ? 1 : 0)
最大值 = "饱和连通分量" + "不饱和连通分量"
======

input
10
6
2 1 4 3 6 5
6
2 3 1 5 6 4
9
2 3 2 5 6 5 8 9 8
2
2 1
4
4 3 2 1
5
2 3 4 5 1
6
5 3 4 1 1 2
5
3 5 4 1 2
6
6 3 2 5 4 3
6
5 1 4 3 4 2
output
1 3
2 2
1 3
1 1
1 2
1 1
1 1
2 2
1 2
1 1
 */