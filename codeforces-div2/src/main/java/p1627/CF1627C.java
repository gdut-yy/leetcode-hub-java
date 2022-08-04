package p1627;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CF1627C {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(reader.readLine());
            int[][] nums = new int[n - 1][2];
            for (int j = 0; j < n - 1; j++) {
                String[] lines = reader.readLine().split(" ");
                nums[j][0] = Integer.parseInt(lines[0]);
                nums[j][1] = Integer.parseInt(lines[1]);
            }
            writer.write(solution(n, nums).concat(System.lineSeparator()));
        }
        writer.close();
        reader.close();
    }

    private static String solution(int n, int[][] nums) {
        // 无向图
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] num : nums) {
            int u = num[0];
            int v = num[1];

            Map<Integer, Integer> uMap = graph.getOrDefault(u, new HashMap<>());
            uMap.put(v, -1);
            graph.put(u, uMap);

            Map<Integer, Integer> vMap = graph.getOrDefault(v, new HashMap<>());
            vMap.put(u, -1);
            graph.put(v, vMap);
        }

        // 不存在三个质数，任意两个之和也是质数
        for (int i = 1; i <= n; i++) {
            if (graph.getOrDefault(i, new HashMap<>()).size() > 2) {
                return "-1";
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        // 设 (u,v) 权重为 2
        int u0 = nums[0][0];
        int v0 = nums[0][1];
        graph.get(u0).put(v0, 2);
        graph.get(v0).put(u0, 2);
        queue.add(u0);
        queue.add(v0);
        visited.add(u0);
        visited.add(v0);
        boolean is2 = true;
        while (!queue.isEmpty()) {
            is2 = !is2;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.remove();
                for (int next : graph.get(cur).keySet()) {
                    if (!visited.contains(next)) {
                        visited.add(next);
                        graph.get(cur).put(next, is2 ? 2 : 3);
                        graph.get(next).put(cur, is2 ? 2 : 3);
                        queue.add(next);
                    }
                }
            }
        }

        List<Integer> resList = new ArrayList<>();
        for (int[] num : nums) {
            int u = num[0];
            int v = num[1];
            resList.add(graph.get(u).get(v));
        }

        // List<Integer> => String
        StringBuilder stringBuilder = new StringBuilder();
        for (int num : resList) {
            stringBuilder.append(num).append(" ");
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }
}
/*
C. Not Assigning
https://codeforces.com/contest/1627/problem/C

题目大意：
给出整数 n 和 n-1 对整数，分别代表 n 个顶点和 n-1 条边，要求生成一颗 质数树，每条由一条或两条边组成的路径的权值都是质数。求按序输出 n-1 条边的权重。

可以证明：不存在三个质数，任意两个之和也是质数：除 2 外质数都是 奇数，不存在两个奇数的和也是奇数。
生成图后，按序填充 2,3 即可（其他组合也可以）
======

input
3
2
1 2
4
1 3
4 3
2 1
7
1 2
1 3
3 4
3 5
6 2
7 2


input2
1
10
9 2
5 1
3 5
10 2
3 4
6 4
8 7
8 1
6 9
 */