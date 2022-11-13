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

public class Abc277_c {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int N = scanner.nextInt();
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int ai = scanner.nextInt();
            int bi = scanner.nextInt();
            adj.computeIfAbsent(ai, key -> new ArrayList<>()).add(bi);
            adj.computeIfAbsent(bi, key -> new ArrayList<>()).add(ai);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        Set<Integer> visited = new HashSet<>();
        visited.add(1);
        int max = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int u = queue.remove();
                max = Math.max(max, u);

                for (int v : adj.getOrDefault(u, new ArrayList<>())) {
                    if (!visited.contains(v)) {
                        visited.add(v);
                        queue.add(v);
                    }
                }
            }
        }
        System.out.println(max);
    }
}
/*
C - Ladder Takahashi
https://atcoder.jp/contests/abc277/tasks/abc277_c
 */