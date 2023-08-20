package p1850;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CF1850G {
    static int n;
    static int[][] xy;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            xy = new int[n][2];
            for (int i = 0; i < n; i++) {
                xy[i][0] = scanner.nextInt();
                xy[i][1] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        List<Map<Integer, Integer>> cntMaps = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            cntMaps.add(new HashMap<>());
        }
        Map<Integer, Integer> xMap = cntMaps.get(0);
        Map<Integer, Integer> yMap = cntMaps.get(1);
        Map<Integer, Integer> xpyMap = cntMaps.get(2);
        Map<Integer, Integer> xmyMap = cntMaps.get(3);

        for (int[] p : xy) {
            int x = p[0], y = p[1];
            xMap.put(x, xMap.getOrDefault(x, 0) + 1);
            yMap.put(y, yMap.getOrDefault(y, 0) + 1);
            xpyMap.put(x + y, xpyMap.getOrDefault(x + y, 0) + 1);
            xmyMap.put(x - y, xmyMap.getOrDefault(x - y, 0) + 1);
        }

        long ans = 0;
        for (Map<Integer, Integer> cntMap : cntMaps) {
            for (Integer c : cntMap.values()) {
                ans += c * (c - 1L);
            }
        }
        return String.valueOf(ans);
    }
}
/*
G. The Morning Star
https://codeforces.com/contest/1850/problem/G

题目大意：
指南针直接指向晨星。它只能指向八个方向中的一个:四个基本方向(北、南、东、西)或某些组合(西北、东北、西南、东南)。否则，它会断裂。
在一个平面上有 n 个不同的点，它们的坐标是整数。有多少种方法可以把指南针放在一个点上，把晨星放在另一个点上，这样指南针才不会坏?

需要从 O(n^2) 优化至 O(n)
======

input
5
3
0 0
-1 -1
1 1
4
4 5
5 7
6 9
10 13
3
-1000000000 1000000000
0 0
1000000000 -1000000000
5
0 0
2 2
-1 5
-1 10
2 11
3
0 0
-1 2
1 -2
output
6
2
6
8
0
 */
