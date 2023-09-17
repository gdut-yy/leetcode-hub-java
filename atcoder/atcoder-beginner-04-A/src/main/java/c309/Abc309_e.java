package c309;

import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Abc309_e {
    static int n, m;
    static Map<Integer, List<Integer>> adj;
    static int[][] xy;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        m = scanner.nextInt();
        adj = new HashMap<>();
        for (int i = 2; i <= n; i++) {
            int p = scanner.nextInt();
            // 有向图
            adj.computeIfAbsent(p, key -> new ArrayList<>()).add(i);
        }
        xy = new int[m][2];
        for (int i = 0; i < m; i++) {
            xy[i][0] = scanner.nextInt();
            xy[i][1] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        // f[i] 表示第 i 人的保险数量
        int[] f = new int[n + 1];
        for (int[] p : xy) {
            f[p[0]] = Math.max(f[p[0]], p[1] + 1);
        }

        // 人，保险数量
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{1, f[1]});
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] tuple = queue.remove();
                int x = tuple[0], cnt = tuple[1];
                f[x] = Math.max(f[x], cnt);

                for (Integer y : adj.getOrDefault(x, new ArrayList<>())) {
                    queue.add(new int[]{y, Math.max(f[y], cnt - 1)});
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (f[i] > 0) {
                ans++;
            }
        }
        return String.valueOf(ans);
    }
}
/*
E - Family and Insurance
https://atcoder.jp/contests/abc309/tasks/abc309_e

题目大意：
有一个由人 1、人 2、…、人 n 组成的家庭。当 i≥2 时，人 i 的父母是人 pi。
他们买了 M 次保险。对于 i=1,2,...,M，第 i 个人买了第 i 份保险，这包括他和他的后代在接下来的第 i 代。
有多少人至少有一种保险?
---
第 1 代保险覆盖第 1 2 和第 4 代，因为第 1 代的后代是第 2 和第 4 代。
第二代保险覆盖第 1 2 3 4 个人，因为第 1 个人的第 1 代后裔是第 2 和第 4 个人，第 1 个人的第 2 代后裔是第 3 个人。
第三种保险适用于第 4 个人，因为第 4 个人没有第 1、2、3 个后代。
因此，四个人，人 1、人 2、人 3 和人 4，至少被一种保险所覆盖。

自顶向下 递推
======

Input 1
7 3
1 2 1 3 3 3
1 1
1 2
4 3
Output 1
4

Input 2
10 10
1 1 3 1 2 3 3 5 7
2 1
5 1
4 3
6 3
2 1
7 3
9 2
1 2
6 2
8 1
Output 2
10
 */