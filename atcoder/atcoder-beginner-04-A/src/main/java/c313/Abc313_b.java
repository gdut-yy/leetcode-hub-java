package c313;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Abc313_b {
    static int n, m;
    static int[][] ab;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        m = scanner.nextInt();
        ab = new int[m][2];
        for (int i = 0; i < m; i++) {
            ab[i][0] = scanner.nextInt();
            ab[i][1] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        // 建图
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] deg = new int[n];
        for (int[] xy : ab) {
            int u = xy[0] - 1, v = xy[1] - 1;
            adj.computeIfAbsent(u, key -> new ArrayList<>()).add(v);
            deg[v]++;
        }

        // 拓扑序需要唯一
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (deg[i] == 0) {
                queue.add(i);
            }
        }
        if (queue.size() != 1) {
            return "-1";
        }
        List<Integer> topo = new ArrayList<>();
        while (!queue.isEmpty()) {
            int sz = queue.size();
            int u = queue.remove();
            topo.add(u);
            for (int v : adj.getOrDefault(u, new ArrayList<>())) {
                deg[v]--;
                if (deg[v] == 0) {
                    queue.add(v);
                }
            }
            // 删一个只能加一个
//            if (queue.size() > sz) {
//                return "-1";
//            }
        }
        if (topo.size() != n) {
            return "-1";
        }
        return String.valueOf(topo.get(0) + 1);
    }
}
/*
B - Who is Saikyo?
https://atcoder.jp/contests/abc313/tasks/abc313_b

题目大意：
有 N 个相互竞争的程序员，编号为 1 号，2 号，…，和 N 号。
程序员之间有一种叫做优越感的关系。对于所有不同的程序员对(人 X，人 Y)，只有以下两种关系之一成立:“人 X 比人 Y 强”或“人 Y 比人 X 强”。优势是可传递的。换句话说，对于所有不同程序员的三元组(人 X，人 Y，人 Z)，它成立:
如果 X 比 Y 强，Y 比 Z 强，那么 X 就比 Z 强。
如果在除 X 之外的所有 Y 人中，X 都比 Y 强，那么 X 就是最强的程序员(在上述约束条件下，我们可以证明只有一个这样的人)。
你有 M 条关于他们优越性的信息。其中的第 i 条是“A i 比 B i 强”，你能根据这条信息确定 N 个程序员中最强的是谁吗?如果可以的话，打印出对方的电话号码。否则，也就是说，如果有多个最强的程序员，打印-1。

拓扑序唯一
======

Input 1
3 2
1 2
2 3
Output 1
1

Input 2
3 2
1 3
2 3
Output 2
-1

Input 3
6 6
1 6
6 5
6 2
2 3
4 3
4 2
Output 3
-1
 */