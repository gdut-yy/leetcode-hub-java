package c285;

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

public class Abc285_d {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int N = scanner.nextInt();

        Set<String> seen = new HashSet<>();
        Map<String, Integer> inDegrees = new HashMap<>();
        Map<String, List<String>> adj = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String S = scanner.next();
            String T = scanner.next();
            adj.computeIfAbsent(S, key -> new ArrayList<>()).add(T);
            // 入度
            inDegrees.put(T, inDegrees.getOrDefault(T, 0) + 1);
            // 出现过的节点
            seen.add(S);
            seen.add(T);
        }

        Queue<String> queue = new LinkedList<>();
        for (String s : seen) {
            if (!inDegrees.containsKey(s)) {
                queue.add(s);
            }
        }
        List<String> topo = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String u = queue.remove();
                topo.add(u);

                for (String v : adj.getOrDefault(u, new ArrayList<>())) {
                    inDegrees.put(v, inDegrees.get(v) - 1);
                    if (inDegrees.get(v) == 0) {
                        queue.add(v);
                    }
                }
            }
        }
        if (topo.size() == seen.size()) {
            System.out.println("Yes");
            return;
        }
        System.out.println("No");
    }
}
/*
D - Change Usernames
https://atcoder.jp/contests/abc285/tasks/abc285_d

拓扑排序
 */