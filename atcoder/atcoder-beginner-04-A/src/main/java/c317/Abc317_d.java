package c317;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Abc317_d {
    static int n;
    static Node[] nodes;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();

        nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            if (x > y) {
                nodes[i] = new Node(0, z);
            } else {
                int cost = (y - x + 1) / 2;
                nodes[i] = new Node(cost, z);
            }
        }
        System.out.println(solve());
    }

    private static final long INF = (long) 1e12;

    private static String solve() {
        int M = 0;
        for (Node p : nodes) {
            M += p.wt;
        }
        long[] f = new long[M + 1];
        Arrays.fill(f, INF);
        f[0] = 0;
        for (int i = 0; i < n; i++) {
            int wi = nodes[i].wt;
            int vi = nodes[i].cost;
            for (int j = M; j >= wi; j--) {
                f[j] = Math.min(f[j], f[j - wi] + vi);
            }
        }

        long ans = INF;
        for (int i = (M + 1) / 2; i <= M; i++) {
            ans = Math.min(ans, f[i]);
        }
        return String.valueOf(ans);
    }

    private static class Node {
        int cost, wt;

        public Node(int cost, int wt) {
            this.cost = cost;
            this.wt = wt;
        }
    }
}
/*
D - President
https://atcoder.jp/contests/abc317/tasks/abc317_d

题目大意：
高桥和青木正在竞选。
有 N 个选区。第 i 区有 Xi+ Yi 选民，其中 Xi 支持高桥，Yi 支持青木。(Xi+Yi 总是奇数。)在每个选区，多数党赢得该选区所有的 Z 个席位。然后，谁赢得了 N 个选区的多数席位，谁就赢得了选举。(i=1∑nzi 是奇数)
至少要有多少选民从青木转向高桥才能让高桥赢得选举?

0-1 背包？
======

Input 1
1
3 8 1
Output 1
3

Input 2
2
3 6 2
1 8 5
Output 2
4

Input 3
3
3 4 2
1 2 3
7 2 6
Output 3
0

Input 4
10
1878 2089 16
1982 1769 13
2148 1601 14
2189 2362 15
2268 2279 16
2394 2841 18
2926 2971 20
3091 2146 20
3878 4685 38
4504 4617 29
Output 4
86
 */