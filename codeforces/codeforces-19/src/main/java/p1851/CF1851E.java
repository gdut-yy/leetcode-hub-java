package p1851;

import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class CF1851E {
    static int n, k;
    static int[] c, p;
    static Map<Integer, List<Integer>> adj, rg;
    static int[] inDeg;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            k = scanner.nextInt();
            c = new int[n];
            for (int i = 0; i < n; i++) {
                c[i] = scanner.nextInt();
            }
            p = new int[k];
            for (int i = 0; i < k; i++) {
                p[i] = scanner.nextInt() - 1;
            }
            adj = new HashMap<>();
            rg = new HashMap<>();
            inDeg = new int[n];
            for (int i = 0; i < n; i++) {
                int m = scanner.nextInt();
                for (int j = 0; j < m; j++) {
                    int x = scanner.nextInt() - 1;
                    adj.computeIfAbsent(x, key -> new ArrayList<>()).add(i);
                    rg.computeIfAbsent(i, key -> new ArrayList<>()).add(x);
                    inDeg[i]++;
                }
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        Set<Integer> pSet = new HashSet<>();
        for (int x : p) {
            pSet.add(x);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (inDeg[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int x = queue.remove();
                if (pSet.contains(x)) {
                    c[x] = 0;
                }
                if (rg.containsKey(x)) {
                    long sum = 0;
                    for (Integer z : rg.get(x)) {
                        sum += c[z];
                    }
                    c[x] = (int) Math.min(c[x], sum);
                }

                for (Integer y : adj.getOrDefault(x, new ArrayList<>())) {
                    inDeg[y]--;
                    if (inDeg[y] == 0) {
                        queue.add(y);
                    }
                }
            }
        }
        return Arrays.stream(c).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
E. Nastya and Potions
https://codeforces.com/contest/1851/problem/E

题目大意：
炼金术士 Nastya 喜欢混合药剂。一共有 n 种药剂，其中 i 种药剂可以用 ci 币购买。
任何一种魔药都只能通过一种方法获得，那就是将几种魔药混合在一起。在混合过程中使用的药剂将被消耗。此外，任何药剂都不能通过一个或多个混合过程自行获得。
作为一名经验丰富的炼金术士，Nastya 拥有无限的 k 种药剂 p1,p2,...,pk，但她不知道自己接下来想要获得哪一种。为了决定，她要求你找出，对于每一个 1≤i≤n，她需要花费的最小硬币数，以获得类型 i 的药水。

拓扑排序
======

input
4
5 1
30 8 3 5 10
3
3 2 4 5
0
0
2 3 5
0
3 2
5 143 3
1 3
1 2
0
2 1 2
5 1
5 4 1 3 4
2
2 4 5
3 3 5 4
2 1 4
1 5
0
4 2
1 1 5 4
2 4
3 2 4 3
0
2 2 4
1 2
output
23 8 0 5 10
0 143 0
5 0 1 3 4
0 0 0 0

input
3
6 3
5 5 4 5 2 2
3 4 5
2 2 5
1 5
3 4 1 6
4 2 6 1 5
0
0
6 2
1 4 4 1 5 2
3 6
4 6 3 4 5
4 6 5 3 4
0
1 5
1 6
0
2 1
4 3
1
0
1 1
output
0 0 0 0 0 2
0 0 0 0 0 0
0 0
 */
