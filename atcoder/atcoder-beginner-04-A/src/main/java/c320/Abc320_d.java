package c320;

import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Abc320_d {
    static int n, m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        m = scanner.nextInt();

        g = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt() - 1;
            int b = scanner.nextInt() - 1;
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            g.computeIfAbsent(a, key -> new ArrayList<>()).add(new long[]{b, x, y});
            g.computeIfAbsent(b, key -> new ArrayList<>()).add(new long[]{a, -x, -y});
        }
        System.out.println(solve());
    }

    static Map<Integer, List<long[]>> g;

    private static String solve() {
        String[] ans = new String[n];
        Arrays.fill(ans, "undecidable");
        ans[0] = "0 0";
        Queue<long[]> q = new ArrayDeque<>();
        q.add(new long[]{0, 0, 0});
        boolean[] vis = new boolean[n];
        vis[0] = true;
        while (!q.isEmpty()) {
            long[] p = q.remove();
            int a = (int) p[0];
            long ax = p[1], ay = p[2];

            for (long[] tuple : g.getOrDefault(a, new ArrayList<>())) {
                int b = (int) tuple[0];
                long dx = tuple[1], dy = tuple[2];

                if (ans[b].equals("undecidable")) {
                    long bx = ax + dx;
                    long by = ay + dy;
                    ans[b] = bx + " " + by;
                    if (!vis[b]) {
                        vis[b] = true;
                        q.add(new long[]{b, bx, by});
                    }
                }
            }
        }

        return String.join(System.lineSeparator(), ans);
    }
}
/*
D - Relative Position
https://atcoder.jp/contests/abc320/tasks/abc320_d

题目大意：
在一个坐标平面上有 N 个编号为 1 到 N 的人。
第一个人在原点。
给你 M 条信息，格式如下:
- 从 Ai 的角度来看，Bi 在 X 正方向上距离 Xi 个单位在 Y 正方向上距离 Yi 个单位。
确定每个人的坐标。如果一个人的坐标不能唯一确定，报告这一事实。
---
打印 N 行。如果人 i 的坐标不能唯一确定，则第 i 行应包含 "undecidable"。如果它们可以被唯一地确定为(si,ti)，则第 i 行应按此顺序包含 si 和 ti，并用空格分隔。

转换成图
======

Input 1
3 2
1 2 2 1
1 3 -1 -2
Output 1
0 0
2 1
-1 -2

Input 2
3 2
2 1 -2 -1
2 3 -3 -3
Output 2
0 0
2 1
-1 -2

Input 3
5 7
1 2 0 0
1 2 0 0
2 3 0 0
3 1 0 0
2 1 0 0
3 2 0 0
4 5 0 0
Output 3
0 0
0 0
0 0
undecidable
undecidable
 */