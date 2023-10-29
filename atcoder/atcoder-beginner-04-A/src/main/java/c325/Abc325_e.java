package c325;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Abc325_e {
    static int n;
    static int a, b, c;
    static long[][] d;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();
        d = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                d[i][j] = scanner.nextInt();
            }
        }
        System.out.println(solve());
    }

    private static String solve() {
        long[] dist_car = dijkstra_n2(0, true);
        long[] dist_train = dijkstra_n2(n - 1, false);

        long ans = Math.min(dist_car[n - 1], dist_train[0]);
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dist_car[i] + dist_train[i]);
        }
        return String.valueOf(ans);
    }

    private static final long INF = (long) 1e18;

    // 暴力 O(n^2)
    private static long[] dijkstra_n2(int source, boolean car) {
        long[] dist = new long[n];
        Arrays.fill(dist, INF);
        dist[source] = 0;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            int x = 0;
            long mind = INF;
            for (int j = 0; j < n; j++) {
                if (!vis[j] && dist[j] < mind) {
                    x = j;
                    mind = dist[x];
                }
            }
            vis[x] = true;
            for (int y = 0; y < n; y++) {
                if (x != y && d[x][y] != INF) {
                    if (car) {
                        if (dist[y] > dist[x] + d[x][y] * a) {
                            dist[y] = dist[x] + d[x][y] * a;
                        }
                    } else {
                        if (dist[y] > dist[x] + d[x][y] * b + c) {
                            dist[y] = dist[x] + d[x][y] * b + c;
                        }
                    }
                }
            }
        }
        return dist;
    }
}
/*
E - Our clients, please wait a moment
https://atcoder.jp/contests/abc325/tasks/abc325_e

题目大意：
一个国家有 N 个城市。
你将从城市 1 的办公室到城市 N 的目的地，途经零个或多个城市。
有两种交通工具:公司用车和火车。从 i 市到 j 市所需要的时间如下:
- Di,j × A 乘公司的车，和
- Di,j × B+C 分钟火车车程。
你可以从公司的汽车转乘火车，反之则不行。
你可以不花时间这样做，但只能在城市里。
从城市 1 到城市 N 最少需要多少分钟?

2^1000 ？
最短路 + 枚举转折点。
======

Input 1
4 8 5 13
0 6 2 15
6 0 3 5
2 3 0 13
15 5 13 0
Output 1
78

Input 2
3 1 1000000 1000000
0 10 1
10 0 10
1 10 0
Output 2
1

Input 3
5 954257 954213 814214
0 84251 214529 10017 373342
84251 0 91926 32336 164457
214529 91926 0 108914 57762
10017 32336 108914 0 234705
373342 164457 57762 234705 0
Output 3
168604826785
 */
