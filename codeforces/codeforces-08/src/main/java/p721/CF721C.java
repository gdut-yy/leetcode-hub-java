package p721;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF721C {
    static int n, m;
    static int maxT;
    static int[][] es;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        maxT = scanner.nextInt();
        es = new int[m][3];
        for (int i = 0; i < m; i++) {
            es[i][0] = scanner.nextInt();
            es[i][1] = scanner.nextInt();
            es[i][2] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    static final int mx = 5001;

    private static String solve() {
        int[][] f = new int[n][mx];
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], maxT + 1);
        }
        f[0][1] = 0;
        int[][] from = new int[n + 1][mx];

        // 不需要拓扑，直接跑 n-1 次就行了
        int ans = 0;
        for (int i = 1; i < n; i++) {
            for (int[] e : es) {
                int v = e[0], w = e[1], t = e[2];
                int sumT = f[i - 1][v] + t;
                if (f[i][w] > sumT) {
                    f[i][w] = sumT;
                    from[i][w] = v;
                }
            }
            if (f[i][n] <= maxT) {
                ans = i;
            }
        }

        int[] path = new int[ans + 1];
        int v = n;
        for (int i = ans; i >= 0; i--) {
            path[i] = v;
            v = from[i][v];
        }
        return (ans + 1) + System.lineSeparator()
                + Arrays.stream(path).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
C. Journey
https://codeforces.com/contest/721/problem/C

灵茶の试炼 2023-11-16
题目大意：
输入 n(2≤n≤5000) m(1≤m≤5000) maxT(1≤maxT≤1e9)。
然后输入 m 条边，每条边输入 v w t(1≤wt≤1e9)，表示有一条边权为 t 的有向边连接 v 和 w。节点编号从 1 开始。
保证输入的是一个有向无环图，并且没有重边。
求出从 1 到 n 的一条路径，要求路径长度（边权之和）不超过 maxT，在满足该条件的前提下，路径上的节点数最多。
输出两行，第一行是路径上的节点个数，第二行按顺序输出路径上的节点编号（第一个数必须是 1，最后一个数必须是 n）。
保证至少有一条满足要求的路径。

rating 1800
提示 1：把「经过了多少个点」作为额外的 DP 维度，把「最短长度」作为 DP 值。
提示 2：定义 f[i][w] 表示从 1 到 w，经过了 i+1 个点的最短长度。i 最大为 n-1。
初始值：f[0][1] = 0，其余为无穷大。
状态转移方程：f[i][w] = min(f[i-1][v]+t)，其中有向边 v->w 的边权为 t。
答案：最大的满足 f[i][n] <= maxT 的 i，再加一（注意 i 是从 0 开始的）。
提示 3：从转移方程可以看出，其实不需要建图，只需要循环 n-1 次，每次遍历这 m 条边，在遍历时计算状态转移。
这是因为 f[i][] 只依赖于 f[i-1][]，在把 f[i-1][] 算出来后，无论按照什么顺序遍历这 m 条边都是可以的。
提示 4：计算状态转移的时候，额外记录转移来源 from[i][w] = v。
从 n 出发，顺着 from 数组回到 1，就得到了具体方案。具体请看代码。
https://codeforces.com/contest/721/submission/232349094
======

input
4 3 13
1 2 5
2 3 7
2 4 8
output
3
1 2 4

input
6 6 7
1 2 2
1 3 3
3 6 3
2 4 2
4 6 2
6 5 1
output
4
1 2 4 6

input
5 5 6
1 3 3
3 5 3
1 2 2
2 4 3
4 5 2
output
3
1 3 5
 */
