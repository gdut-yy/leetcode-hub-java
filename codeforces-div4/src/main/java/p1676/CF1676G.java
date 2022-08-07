package p1676;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class CF1676G {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] a = new int[n - 1];
            for (int j = 0; j < n - 1; j++) {
                a[j] = scanner.nextInt();
            }
            String s = scanner.next();

            System.out.println(solve(n, a, s));
        }
    }

    private static String solve(int n, int[] a, String s) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        // 入度数组
        int[] inDegrees = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int from = i;
            int to = a[i - 2];
            adj.computeIfAbsent(from, key -> new ArrayList<>()).add(to);
            inDegrees[to]++;
        }
        Map<Integer, Integer> memo = new HashMap<>();

        // 拓扑排序
        // 入度为 0 进队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            memo.put(i, s.charAt(i - 1) == 'W' ? 1 : -1);
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }
        int cnt = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.remove();
                int whiteBlack = memo.get(cur);
                if (whiteBlack == 0) {
                    cnt++;
                }

                for (int next : adj.getOrDefault(cur, new ArrayList<>())) {
                    inDegrees[next]--;
                    memo.put(next, memo.get(next) + whiteBlack);
                    if (inDegrees[next] == 0) {
                        queue.add(next);
                    }
                }
            }
        }
        return String.valueOf(cnt);
    }
}
/*
G. White-Black Balanced Subtrees
https://codeforces.com/contest/1676/problem/G

题目大意：
给定整数 n 和长度为 n-1 的数组 a，字符串 s，表示一棵树，a[i] = father，并且每个节点为 黑色/白色。求有黑白平衡的节点个数。

拓扑排序，自叶子到根节点。满足的计数即可。
时间复杂度 O(n)
======

input
3
7
1 1 2 3 3 5
WBBWWBW
2
1
BW
8
1 2 3 4 5 6 7
BWBWBWBW

output
2
1
4
 */