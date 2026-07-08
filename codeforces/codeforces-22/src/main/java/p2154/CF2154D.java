package p2154;

import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class CF2154D {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        for (int i = 0; i < n - 1; i++) {
            int v = scanner.nextInt() - 1;
            int w = scanner.nextInt() - 1;
            g.get(v).add(w);
            g.get(w).add(v);
        }
        int[] dep = new int[n];
        Arrays.fill(dep, -1);
        dep[n - 1] = 0;
        List<Integer> orders = new ArrayList<>();
        Deque<Integer> q = new ArrayDeque<>();
        q.add(n - 1);
        orders.add(n - 1);
        while (!q.isEmpty()) {
            int v = q.poll();
            for (int w : g.get(v)) {
                if (dep[w] < 0) {
                    dep[w] = dep[v] ^ 1;
                    q.add(w);
                    orders.add(w);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        int cur = dep[0];
        for (int i = orders.size() - 1; i >= 1; i--) {
            int v = orders.get(i);
            if (dep[v] == cur) {
                ans.add(0);
                cur ^= 1;
            }
            ans.add(v + 1);
            ans.add(0);
            cur ^= 1;
        }
        out.println(ans.size());
        for (int v : ans) {
            if (v > 0) {
                out.println(2 + " " + v);
            } else {
                out.println(1);
            }
        }
    }
}
/*
D. Catshock
https://codeforces.com/contest/2154/problem/D

灵茶の试炼 2026-02-26
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(2≤n≤2e5) 和一棵 n 个节点的无向树的 n-1 条边。节点编号从 1 到 n。
有一只猫位于节点 1，你需要让猫移动到节点 n。
你可以执行两种操作，格式如下：
"1"：猫会随便移动一步，即移动到猫所处节点的随机邻居上。如果没有邻居，猫不会移动。
"2 u"：摧毁节点 u。如果猫恰好在节点 u，你会获得 WA。如果节点 u 已被摧毁，则不会发生任何事情。
要求：总操作次数 ≤ 3n，且不能连续执行第二种操作。
输出具体的操作序列，使得无论猫如何移动，在所有操作结束后，猫一定位于节点 n。可以证明，这样的操作序列一定存在。
输出格式：先输出总操作次数 k，然后输出 k 个操作。

rating 1900
核心思路：剥洋葱，先去掉叶子节点，然后去掉新产生的叶子节点，依此类推，直到剩下节点 n。这样可以把猫“赶到”节点 n。
首先从 n 开始 BFS，预处理每个节点是在奇数层还是在偶数层。
猫每移动一步，所在节点的奇偶性一定会变化，只要猫所在节点的奇偶性与要去掉的节点的奇偶性不同，就可以放心地去掉节点。
然后按照拓扑序去掉节点（注意 BFS 序的逆序就是这棵无向树的拓扑序）：
如果当前节点与猫的奇偶性不同，那么直接去掉当前节点，然后让猫移动一步（因为不能连续执行去掉节点的操作）。
如果当前节点与猫的奇偶性相同，那么先让猫移动一步，变成当前节点与猫的奇偶性不同的情况，做法同上。
代码 https://codeforces.com/problemset/submission/2154/364250857
代码备份（上面打不开的同学看这个）
======

Input
4
5
1 2
2 3
1 5
5 4
2
1 2
4
1 2
1 3
1 4
6
1 2
1 3
3 4
4 5
4 6
Output
2
2 2
1

1
1

5
2 2
1
1
2 3
1

9
2 2
1
2 1
1
2 3
1
1
2 5
1
 */
