package p437;

import java.util.Scanner;

public class CF437C {
    static Scanner scanner = new Scanner(System.in);
    static int n, m;
    static int[] a;

    public static void main(String[] args) {
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int ans = 0;
        for (int i = 0; i < m; i++) {
            int v = scanner.nextInt() - 1;
            int w = scanner.nextInt() - 1;
            ans += Math.min(a[v], a[w]);
        }
        return String.valueOf(ans);
    }
}
/*
C. The Child and Toy
https://codeforces.com/contest/437/problem/C

灵茶の试炼 2024-09-02
题目大意：
输入 n(1≤n≤1000) m(0≤m≤2000)，表示一个 n 点 m 边的无向图。节点编号从 1 开始。保证图中无自环和重边。
然后输入 n 个数，表示每个节点的点权，元素范围 [0,1e5]。
然后输入 m 条边，每条边输入 x y，表示有一条无向边连接 x 和 y。
你需要一个一个地删除这 n 个节点。
删除点 v 时，把 v 的所有未删除的邻居的点权之和加入答案。
输出答案的最小值。

rating 1400
用交换法可以证明，先删点权大的更优。
横看成岭侧成峰，这等价于，对于每条边相连的两个点，把点权小的加入答案。
代码 https://codeforces.com/problemset/submission/437/277928201
======

Input
4 3
10 20 30 40
1 4
1 2
2 3
Output
40

Input
4 4
100 100 100 100
1 2
2 3
2 4
3 4
Output
400

Input
7 10
40 10 20 10 20 80 40
1 5
4 7
4 5
5 2
5 7
6 4
1 6
1 3
4 3
1 4
Output
160
 */