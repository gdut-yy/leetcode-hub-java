package p1842;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class CF1842D {
    static int n, m;
    static Map<Integer, List<int[]>> adj;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        m = scanner.nextInt();
        adj = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt() - 1;
            int v = scanner.nextInt() - 1;
            int w = scanner.nextInt();
            adj.computeIfAbsent(u, key -> new ArrayList<>()).add(new int[]{v, w});
            adj.computeIfAbsent(v, key -> new ArrayList<>()).add(new int[]{u, w});
        }
        System.out.println(solve());
    }

    // https://codeforces.com/problemset/submission/1842/211116388
    private static String solve() {
        PriorityQueue<long[]> q = new PriorityQueue<>(Comparator.comparingLong(o -> o[0]));
        q.add(new long[]{0, 0});

        long[] dis = new long[n];
        Arrays.fill(dis, -1);
        List<Integer> a = new ArrayList<>();
        while (!q.isEmpty()) {
            long[] tuple = q.remove();
            long d = tuple[0];
            int x = (int) tuple[1];

            if (dis[x] != -1) {
                continue;
            }
            dis[x] = d;
            a.add(x);
            if (x == n - 1) {
                break;
            }
            for (int[] p : adj.getOrDefault(x, new ArrayList<>())) {
                int y = p[0], w = p[1];
                q.add(new long[]{d + w, y});
            }
        }

        if (dis[n - 1] == -1) {
            return "inf";
        }
        StringBuilder output = new StringBuilder();
        output.append(dis[n - 1]).append(" ").append(a.size() - 1).append(System.lineSeparator());
        char[] cs = new char[n];
        Arrays.fill(cs, '0');
        for (int i = 1; i < a.size(); i++) {
            cs[a.get(i - 1)] = '1';
            output.append(new String(cs)).append(" ").append(dis[a.get(i)] - dis[a.get(i - 1)]).append(System.lineSeparator());
        }
        return output.toString();
    }
}
/*
D. Tenzing and His Animal Friends
https://codeforces.com/contest/1842/problem/D

题目大意：
Tenzing 没有动物朋友。他从 1 到 n 编号。
有一天，Tenzing 想和他的动物朋友们一起玩。为此，Tenzing 将举办几场比赛。
在一个博弈中，他将选择一个集合 S，它是{1,2,3,...,n}，选择一个整数 t。然后，他将与 S 中的动物玩游戏 t 分钟。
但也有一些限制:
1. Tenzing 很爱朋友 1，所以 1 一定是 S 的一个元素。
2. Tenzing 不喜欢朋友 n，所以 n 一定不是 S 的元素。
3. 有额外的限制。这个特殊的限制是用整数 ui, vi 和 yi 来描述的，假设 x 是 ui 和 vi 中的一个和 Tenzing 玩游戏的总时间。丹增必须保证 x 小于等于 yi。否则，就会有不快乐。
Tenzing 想知道他能和他的动物朋友们一起玩的最长时间。请找出 Tenzing 可以和他的动物朋友一起玩的最大总时间，以及如何组织达到这个最大总时间的游戏，或者报告他可以和他的动物朋友一起玩无限长的时间。另外，Tenzing 也不想主持那么多比赛，所以他最多只主持 n^2 场比赛。

性质一：要玩就一起玩，分成多个组不会更优
推论：可以从1开始增量构造集合
性质二：|tui - tvi| <= yi。其中 tx 是 x 添加到集合中的时刻。
======

input
5 4
1 3 2
1 4 2
2 3 1
2 5 1
output
4 4
10000 1
10010 1
10100 1
11110 1

input
3 0
output
inf
 */
