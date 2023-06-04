package c276;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Abc276_b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] ab = new int[m][2];
        for (int i = 0; i < m; i++) {
            ab[i][0] = scanner.nextInt();
            ab[i][1] = scanner.nextInt();
        }
        System.out.println(solve(n, m, ab));
    }

    private static String solve(int n, int m, int[][] ab) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : ab) {
            adj.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
        }

        String[] ans = new String[n];
        for (int x = 1; x <= n; x++) {
            if (!adj.containsKey(x)) {
                ans[x - 1] = "0";
            } else {
                List<Integer> list = adj.get(x);
                Collections.sort(list);
                ans[x - 1] = list.size() + " " + list.stream().map(String::valueOf).collect(Collectors.joining(" "));
            }
        }
        return String.join(System.lineSeparator(), ans);
    }
}
/*
B - Adjacency List
https://atcoder.jp/contests/abc276/tasks/abc276_b

题目大意：
有 N 个城市，编号为 1，…，N 和 M 条道路连接城市。
第 i 条路(1≤i≤M)连接城市 A i 和城市 B i。
如下所示打印 N 行。
- 设 di 为与城市 i 直接相连(1≤i≤N)的城市数量，依次为城市 a i,1，…，城市 a i,d i，按升序排列。
- 第 i 行(1≤i≤N)应按顺序包含 d1 +1 个整数 d1, a1,1，…，a1, d1, d1，以空格分隔。

模拟。
======

Input 1
6 6
3 6
1 3
5 6
2 5
1 2
1 6
Output 1
3 2 3 6
2 1 5
2 1 6
0
2 2 6
3 1 3 5

Input 2
5 10
1 2
1 3
1 4
1 5
2 3
2 4
2 5
3 4
3 5
4 5
Output 2
4 2 3 4 5
4 1 3 4 5
4 1 2 4 5
4 1 2 3 5
4 1 2 3 4
 */