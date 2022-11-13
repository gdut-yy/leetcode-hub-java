package c276;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Abc276_b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < M; i++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            adj.computeIfAbsent(A, key -> new ArrayList<>()).add(B);
            adj.computeIfAbsent(B, key -> new ArrayList<>()).add(A);
        }

        for (int i = 1; i <= N; i++) {
            List<Integer> list = adj.getOrDefault(i, new ArrayList<>());
            Collections.sort(list);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(list.size());
            for (int x : list) {
                stringBuilder.append(" ").append(x);
            }
            System.out.println(stringBuilder);
        }
    }
}
/*
B - Adjacency List
https://atcoder.jp/contests/abc276/tasks/abc276_b
 */