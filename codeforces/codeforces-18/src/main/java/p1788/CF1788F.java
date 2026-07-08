package p1788;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF1788F {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static int[] fa, dis;
    static int n, q;
    static int find(int x) {
        if (fa[x] != x) {
            int rt = find(fa[x]);
            dis[x] ^= dis[fa[x]];
            fa[x] = rt;
        }
        return fa[x];
    }
    static boolean merge(int from, int to, int d) {
        int x = find(from), y = find(to);
        if (x == y) {
            return (dis[to] ^ dis[from]) == d;
        }
        dis[x] = d ^ dis[to] ^ dis[from];
        fa[x] = y;
        return true;
    }
    private static void solve() {
        n = scanner.nextInt();
        q = scanner.nextInt();
        int[][] es = new int[n - 1][2];
        int[] deg = new int[n];
        for (int i = 0; i < n - 1; i++) {
            es[i][0] = scanner.nextInt() - 1;
            es[i][1] = scanner.nextInt() - 1;
            deg[es[i][0]] ^= 1;
            deg[es[i][1]] ^= 1;
        }
        fa = new int[n];
        dis = new int[n];
        for (int i = 0; i < n; i++) fa[i] = i;
        for (int i = 0; i < q; i++) {
            int v = scanner.nextInt() - 1, w = scanner.nextInt() - 1, d = scanner.nextInt();
            if (!merge(v, w, d)) {
                out.println("No");
                return;
            }
        }
        int[] ccOddDegCnt = new int[n];
        int xor = 0;
        for (int i = 0; i < n; i++) {
            find(i);
            if (deg[i] > 0) { // 每个点权的计算次数是它在原图上的度数，想要影响所有点权的异或值，度数必须是奇数
                ccOddDegCnt[fa[i]] ^= 1; // 连通块中的奇度数点的个数
                xor ^= dis[i];
            }
        }
        for (int rt = 0; rt < n; rt++) {
            if (ccOddDegCnt[rt] > 0) { // 连通块里有奇数个奇度数点，dis[i] ^= xor 会影响答案奇数次，才能真正地影响答案
                for (int i = 0; i < n; i++) {
                    if (fa[i] == rt) {
                        dis[i] ^= xor;
                    }
                }
                break;
            }
        }
        out.println("Yes");
        StringBuilder sb = new StringBuilder();
        for (int[] e : es) {
            sb.append(dis[e[0]] ^ dis[e[1]]).append(' ');
        }
        out.println(sb);
    }
}
/*
F. XOR, Tree, and Queries
https://codeforces.com/contest/1788/problem/F

灵茶の试炼 2026-04-03
题目大意：
输入 n(2≤n≤2.5e5) q(0≤q≤2.5e5) 和一棵 n 个节点的无向树的 n-1 条边。节点编号从 1 到 n。
然后输入 q 行，每行输入 u v x(0≤x<2^30)，表示从 u 到 v 的最短路径的边权异或和为 x。u≠v。
请为这棵树的每条边分配一个 0 到 2^30 - 1 的整数边权，满足这 q 个条件。
如果有解，还要求这 n-1 个边权的异或和最小。
如果无法做到，输出 No。
否则输出 Yes，以及 n-1 个边权（按照输入顺序）。
多解输出任意解。

rating 2500
从 x 到 y 的路径异或和，等价于 (从 1 到 x 的路径异或和) ^ (从 1 到 y 的路径异或和)，其中重复走的部分会被异或抵消掉。
于是，定义 d[i] 表示从 1 到 i 的路径异或和。
约束 (u,v,x) 等价于 d[u] ^ d[v] = x。
用带权并查集处理这 q 个约束是否有矛盾。
如果没有矛盾，那么下一步就是最小化所有边权的异或和。
对于边 x-y，其边权等价于 d[x] ^ d[y]。
把所有边权的异或和记作 S。那么 S 等于什么呢？
考虑 d[i] 对 S 的贡献。
如果节点 i 的度数是偶数，那么偶数个 d[i] 的异或和为 0，没有贡献。
所以当且仅当节点 i 的度数是奇数，d[i] 才对 S 有 d[i] 的贡献。
先把 S 初始化成并查集中的（度数为奇数的）d[i] 的异或和。
我们可以修改 d[i] 吗？S 可以变成 0 吗？
前面提到，约束 (u,v,x) 等价于 d[u] ^ d[v] = x。
由于 d[u] ^ d[v] = (d[u] ^ k) ^ (d[v] ^ k) 对于任意 k 恒成立，这意味着我们可以把同一个约束连通块中的每个 d[i] 都异或同一个数。
或者说，牵一发而动全身，修改约束连通块中的一个 d[i]，这个连通块中的其余 d[j] 也要修改，才能满足约束。
如果这个约束连通块恰好有奇数个度数为奇数的节点，那么把这个连通块中的 d[i] 都异或上 S 后，这些 d[i] 的异或和的变化量，就是异或了奇数次 S，即 S，那么并查集中的（度数为奇数的）d[i] 的异或和为 S ^ S = 0。
注意只需要改一个这样的连通块。
最后，对于每条边 x-y，输出 d[x] ^ d[y]。
代码 https://codeforces.com/problemset/submission/1788/369361521
代码备份（上面打不开的同学看这个）
======

Input
4 4
1 2
2 3
3 4
1 4 3
2 4 2
1 3 1
2 3 1
Output
No

Input
6 2
1 2
2 3
3 4
2 5
5 6
1 4 2
2 6 7
Output
Yes
4 2 4 1 6

Input
6 2
1 2
2 3
3 4
2 5
5 6
1 4 3
1 6 5
Output
Yes
6 1 4 3 0
 */
