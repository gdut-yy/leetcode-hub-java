package c311;

import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Abc311_c {
    static int n;
    static int[] to;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        to = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            to[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        List<Integer> ans = new ArrayList<>();
        int start = bfs();
        ans.add(start);
        int x = to[start];
        while (x != start) {
            ans.add(x);
            x = to[x];
        }
        return ans.size() + System.lineSeparator()
                + ans.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }

    private static int bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        int[] vis = new int[n + 1];
        vis[1] = 1;
        while (!queue.isEmpty()) {
            int x = queue.remove();
            if (vis[x] == 2) {
                return x;
            }
            int y = to[x];
            if (vis[y] < 2) {
                vis[y]++;
                queue.add(y);
            }
        }
        return -1;
    }
}
/*
C - Find it!
https://atcoder.jp/contests/abc311/tasks/abc311_c

题目大意：
有一个有 N 个顶点和 N 条边的有向图。
第 i 条边从顶点 i 到顶点 ai。(约束条件保证 i != ai)
找一个有向环，同一个顶点不会出现多次。
可以证明在该问题的约束下存在解。

先找环上的一个点，再找出环。
======

Input 1
7
6 7 2 1 3 4 5
Output 1
4
7 5 3 2

Input 2
2
2 1
Output 2
2
1 2

Input 3
8
3 7 4 7 3 3 8 2
Output 3
3
2 7 8
 */