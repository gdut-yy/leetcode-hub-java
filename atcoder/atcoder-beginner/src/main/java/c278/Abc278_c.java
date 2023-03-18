package c278;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Abc278_c {
    public static void main(String[] args) {
        Map<Integer, Set<Integer>> adj = new HashMap<>();

        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int N = scanner.nextInt();
        int Q = scanner.nextInt();
        for (int i = 0; i < Q; i++) {
            int T = scanner.nextInt();
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            if (T == 1) {
                adj.computeIfAbsent(A, key -> new HashSet<>()).add(B);
            } else if (T == 2) {
                adj.computeIfAbsent(A, key -> new HashSet<>()).remove(B);
            } else {
                boolean bool1 = adj.getOrDefault(A, new HashSet<>()).contains(B);
                boolean bool2 = adj.getOrDefault(B, new HashSet<>()).contains(A);
                System.out.println((bool1 && bool2) ? "Yes" : "No");
            }
        }
    }
}
/*
C - FF
https://atcoder.jp/contests/abc278/tasks/abc278_c
 */