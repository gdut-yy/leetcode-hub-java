package c277;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Abc277_e {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int K = scanner.nextInt();
        Map<Integer, List<Integer>> adj0 = new HashMap<>();
        Map<Integer, List<Integer>> adj1 = new HashMap<>();
        for (int i = 0; i < M; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int a = scanner.nextInt();
            if (a == 0) {
                adj0.computeIfAbsent(u, key -> new ArrayList<>()).add(v);
                adj0.computeIfAbsent(v, key -> new ArrayList<>()).add(u);
            } else {
                adj1.computeIfAbsent(u, key -> new ArrayList<>()).add(v);
                adj1.computeIfAbsent(v, key -> new ArrayList<>()).add(u);
            }
        }
        Set<Integer> kSet = new HashSet<>();
        for (int i = 0; i < K; i++) {
            int s = scanner.nextInt();
            kSet.add(s);
        }

        Queue<int[]> queue = new LinkedList<>();
        // state, id
        queue.add(new int[]{1, 1});
        boolean[][] visited = new boolean[2][N + 1];
        visited[1][1] = true;
        int step = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                int[] cur = queue.remove();
                int state = cur[0];
                int u = cur[1];
                if (u == N) {
                    System.out.println(step);
                    return;
                }

                if (state == 1) {
                    for (int v : adj1.getOrDefault(u, new ArrayList<>())) {
                        if (!visited[state][v]) {
                            visited[state][v] = true;
                            queue.add(new int[]{state, v});
                        }
                    }
                } else {
                    for (int v : adj0.getOrDefault(u, new ArrayList<>())) {
                        if (!visited[state][v]) {
                            visited[state][v] = true;
                            queue.add(new int[]{state, v});
                        }
                    }
                }

                if (kSet.contains(u)) {
                    state = 1 - state;
                    if (state == 1) {
                        for (int v : adj1.getOrDefault(u, new ArrayList<>())) {
                            if (!visited[state][v]) {
                                visited[state][v] = true;
                                queue.add(new int[]{state, v});
                            }
                        }
                    } else {
                        for (int v : adj0.getOrDefault(u, new ArrayList<>())) {
                            if (!visited[state][v]) {
                                visited[state][v] = true;
                                queue.add(new int[]{state, v});
                            }
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
/*
E - Crystal Switches
https://atcoder.jp/contests/abc277/tasks/abc277_e
 */