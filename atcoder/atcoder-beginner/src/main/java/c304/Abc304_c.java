package c304;

import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Abc304_c {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        int[][] xy = new int[n][2];
        for (int i = 0; i < n; i++) {
            xy[i][0] = scanner.nextInt();
            xy[i][1] = scanner.nextInt();
        }
        System.out.println(solve(n, d, xy));
    }

    private static String solve(int n, int d, int[][] xy) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(xy[0]);
        // 是否被感染
        boolean[] infected = new boolean[n];
        infected[0] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] tuple = queue.remove();
                int x = tuple[0], y = tuple[1];

                for (int j = 0; j < n; j++) {
                    if (!infected[j]) {
                        int x1 = xy[j][0], y1 = xy[j][1];
                        if ((x1 - x) * (x1 - x) + (y1 - y) * (y1 - y) <= d * d) {
                            infected[j] = true;
                            queue.add(xy[j]);
                        }
                    }
                }
            }
        }

        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            ans[i] = infected[i] ? "Yes" : "No";
        }
        return String.join(System.lineSeparator(), ans);
    }
}
/*
C - Virus
https://atcoder.jp/contests/abc304/tasks/abc304_c

题目大意：
二维平面上有 N 个人，编号为 1,2，…，N，第 i 个人位于坐标(xi, yi)表示的点上。
第一个人感染了病毒。这种病毒会在距离感染者 D 的范围内传播。
这里，距离定义为欧几里得距离，即对于两点(a1, a2)和(b1, b2)，这两点之间的距离为 sqrt((a1-b1)^2 + (a2-b2)^2)
在足够的时间过去后，即当与 i 人距离 D 内的所有人都感染了该病毒时，如果 i 人被感染，则确定每个 i 人是否感染了该病毒。

BFS 模拟。
时间复杂度 O(n^2)
======

Input 1
4 5
2 -1
3 1
8 8
0 5
Output 1
Yes
Yes
No
Yes

Input 2
3 1
0 0
-1000 -1000
1000 1000
Output 2
Yes
No
No

Input 3
9 4
3 2
6 -1
1 6
6 5
-2 -3
5 3
2 -3
2 1
2 6
Output 3
Yes
No
No
Yes
Yes
Yes
Yes
Yes
No
 */