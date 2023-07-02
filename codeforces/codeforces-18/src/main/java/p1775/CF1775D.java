package p1775;

import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class CF1775D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
        int s = scanner.nextInt();
        int t = scanner.nextInt();
        System.out.println(solve(n, a, s, t));
    }

    private static String solve(int n, int[] a, int s, int t) {
        int mx = Arrays.stream(a).max().orElseThrow();

        // 埃氏筛 预处理 最小质因子
        int[] lpf = new int[mx + 1];
        for (int i = 2; i <= mx; i++) {
            if (lpf[i] == 0) {
                for (int j = i; j <= mx; j += i) {
                    if (lpf[j] == 0) {
                        lpf[j] = i;
                    }
                }
            }
        }

        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int x = a[i];
            while (x > 1) {
                int p = lpf[x];
                for (x /= p; lpf[x] == p; x /= p) {
                }
                adj.computeIfAbsent(i, key -> new ArrayList<>()).add(n + p);
                adj.computeIfAbsent(n + p, key -> new ArrayList<>()).add(i);
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(s);
        Set<Integer> vis = new HashSet<>();
        vis.add(s);

        int[] pre = new int[n + mx + 5];
        Arrays.fill(pre, -1);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int x = queue.remove();
                if (x == t) {
                    List<Integer> ans = new ArrayList<>();
                    while (pre[x] != -1) {
                        if (x <= n) ans.add(x);
                        x = pre[x];
                    }
                    ans.add(s);
                    Collections.reverse(ans);
                    return ans.size() + System.lineSeparator()
                            + ans.stream().map(String::valueOf).collect(Collectors.joining(" "));
                }

                for (Integer y : adj.getOrDefault(x, new ArrayList<>())) {
                    if (!vis.contains(y)) {
                        vis.add(y);
                        // 记录转移来源（前继节点）
                        pre[y] = x;
                        queue.add(y);
                    }
                }
            }
        }
        return "-1";
    }
}
/*
D. Friendly Spiders
https://codeforces.com/contest/1775/problem/D

题目大意：
火星是一种不寻常的蜘蛛——双蜘蛛的家园。
现在，火星科学家正在观察一个由 n 只蜘蛛组成的群落，其中第一只有四条腿。
有些蜘蛛彼此是朋友。即，如果 gcd(ai,aj)≠1，即存在某个整数 k≥2，使得 ai 和 aj 同时被 k 除除，且无余数，则第 i 个蜘蛛和第 j 个蜘蛛是朋友。这里 gcd(x,y)表示整数 x 和 y 的最大公因数(gcd)。
科学家们发现蜘蛛可以传递信息。如果两只蜘蛛是朋友，那么它们可以在一秒钟内直接传递信息。否则，蜘蛛必须将消息传递给它的朋友，而他的朋友又必须将消息传递给他的朋友，以此类推，直到消息到达接收者。
让我们来看一个例子。
假设一只有 8 条腿的蜘蛛想要向一只有 15 条腿的蜘蛛发送一条消息。他不能直接做，因为 gcd(8,15)=1。但他可以通过有六条腿的蜘蛛发送消息，因为 gcd(8,6)=2, gcd(6,15)=3。因此，消息将在两秒钟内到达。
现在，科学家们正在观察小蜘蛛是如何向小蜘蛛发送信息的。研究人员有一个假设，即蜘蛛总是以最佳方式传递信息。出于这个原因，科学家们需要一个程序来计算发送信息的最短时间，并推断出一条最佳路线。

以质因子为 中转站 建图，BFS 记录最短路径
注意，如果我们根据定义构建图，它将是很大的。这将使我们产生使它更紧凑的想法。让我们创建一个二部图，其左侧由 n 个顶点组成，顶点数为 ai。在右边，每个顶点对应一个质数，不大于左边的最大值。当且仅当 av 能被对应于顶点 u 的素数整除时，从左边部分的顶点 v 到右边部分的顶点 u 画一条边。在这个从顶点 s 到顶点 t 的图中，运行 bfs 并输出除以 2 的距离。
现在来看看如何快速地构造这样一个图。显然，数字 ai 最多有 logi 个不同的质因数。然后我们分解 av 并画出从顶点 v 到分解中每个素数的边。
相似题目: 2709. 最大公约数遍历
https://leetcode.cn/problems/greatest-common-divisor-traversal/
======

input
7
2 14 9 6 8 15 11
5 6
output
3
5 4 6

input
7
2 14 9 6 8 15 11
5 7
output
-1

input
7
2 14 9 6 8 15 11
5 5
output
1
5
 */
