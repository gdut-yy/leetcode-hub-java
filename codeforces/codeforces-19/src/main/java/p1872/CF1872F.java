package p1872;

import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1872F {
    static int n;
    static int[] c;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();

            inDeg = new int[n + 1];
            g = new ArrayList[n + 1];
            Arrays.setAll(g, e -> new ArrayList<>());
            for (int i = 1; i <= n; i++) {
                int v = scanner.nextInt();
                g[i].add(v);
                inDeg[v]++;
            }

            c = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                c[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    static int[] inDeg;
    static List<Integer>[] g;
    static boolean[] vis, vis2;
    static List<Integer> ans;

    private static String solve() {
        // 拓扑排序分离出环
        vis = new boolean[n + 1];
        vis2 = new boolean[n + 1];
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (inDeg[i] == 0) {
                vis[i] = true;
                vis2[i] = true;
                queue.add(i);
            }
        }
        ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            int x = queue.remove();
            ans.add(x);

            for (Integer y : g[x]) {
                inDeg[y]--;
                if (inDeg[y] == 0) {
                    vis[y] = true;
                    vis2[y] = true;
                    queue.add(y);
                }
            }
        }

        // 环
        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                min = Integer.MAX_VALUE;
                minI = -1;
                dfs(i);
                dfs2(g[minI].get(0));
            }
        }

        return ans.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }

    private static int min, minI;

    private static void dfs(int x) {
        vis[x] = true;
        if (min > c[x]) {
            min = c[x];
            minI = x;
        }
        for (Integer y : g[x]) {
            if (!vis[y]) {
                dfs(y);
            }
        }
    }

    private static void dfs2(int x) {
        vis2[x] = true;
        ans.add(x);
        for (Integer y : g[x]) {
            if (!vis2[y]) {
                dfs2(y);
            }
        }
    }
}
/*
F. Selling a Menagerie
https://codeforces.com/contest/1872/problem/F

题目大意：
你是一个动物园的主人，里面有 n 只动物，编号从 1 到 n。然而，维护动物园是相当昂贵的，所以你决定卖掉它!
众所周知，每种动物只害怕另一种动物。更准确地说，动物 i 害怕动物 ai (ai≠i)。同样，每只动物的成本是已知的，对于动物 i，它等于 ci。
你要按照一定的顺序卖掉你所有的动物。形式上，您需要选择某种排列†p1,p2,...,pn，并首先出售动物 p1，然后出售动物 p2，依此类推，最后出售动物 pn。
当你出售动物 i 时，有两种可能的结果:
- 如果动物 ai 在动物 i 之前被出售，你就会收到卖动物 ci 的钱。
- 如果动物 ai 没有在动物 i 之前被出售，你出售动物 i 会得到 2·ci 的钱。(令人惊讶的是，现在害怕的动物更有价值)。
你的任务是选择出售动物的顺序，以使总利润最大化。
例如，如果 a=[3,4,4,1,3]， c=[3,4,5,6,7]，而您选择的排列是[4,2,5,1,3]，则:
- 第一个被出售的动物是动物 4。动物 a4=1 之前没有卖过，所以你卖了它可以得到 2⋅c4=12 的钱。
- 第二种要出售的动物是动物 2。动物 a2=4 之前被卖掉了，所以你卖了它得到 c2=4 的钱。
- 第三只要出售的动物是 5 号动物。动物 a5=3 之前没有卖过，所以你卖了它得到 2·c5=14 钱。
- 第四只要出售的动物是动物 1。动物 a1=3 之前没有卖过，所以你卖了它得到 2·c1=6 的钱。
- 第五种要出售的动物是动物 3。动物 a3=4 之前被卖掉了，所以你卖了它得到 c3=5 的钱。
在这种排列方式下，你的总利润是 12+4+14+6+5=41。注意，41 不是本例中的最大可能利润。
†长度为 n 的排列是由 n 个不同的整数组成的数组，从 1 到 n 的任意顺序。例如，[2,3,1,5,4]是一个排列，但[1,2,2]不是一个排列(2 在数组中出现两次)，[1,3,4]也不是一个排列(n=3，但 4 在数组中存在)。

拓扑排序 分离出环，然后每个环内 DFS 贪心，取最小值的下一个数作为起点。
======

input
8
3
2 3 2
6 6 1
8
2 1 4 3 6 5 8 7
1 2 1 2 2 1 2 1
5
2 1 1 1 1
9 8 1 1 1
2
2 1
1000000000 999999999
7
2 3 2 6 4 4 3
1 2 3 4 5 6 7
5
3 4 4 1 3
3 4 5 6 7
3
2 1 1
1 2 2
4
2 1 4 1
1 1 1 1
output
1 2 3
2 4 5 1 6 3 7 8
3 4 5 1 2
1 2
7 5 1 3 2 6 4
5 3 2 4 1
3 2 1
3 4 1 2
 */
