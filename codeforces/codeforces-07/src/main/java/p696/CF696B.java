package p696;

import java.util.Scanner;

public class CF696B {
    static int n;
    static int[] p;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        p = new int[n];
        for (int i = 1; i < n; i++) {
            p[i] = scanner.nextInt() - 1;
        }
        System.out.println(solve());
    }

    private static String solve() {
        int[] size = new int[n];
        for (int i = n - 1; i > 0; i--) {
            size[i]++;
            size[p[i]] += size[i];
        }
        size[0]++;

        int[] depth = new int[n];
        for (int i = 0; i < n; i++) {
            depth[i] = depth[p[i]] + 1;
            System.out.printf("%.1f ", ((double) (n - size[i] + depth[i] + 1)) / 2);
        }
        return "";
    }
}
/*
B. Puzzles
https://codeforces.com/contest/696/problem/B

灵茶の试炼 2024-02-28
题目大意：
有一棵 n 个节点的树。节点编号从 1 到 n。节点 1 是根节点。
输入 n(1≤n≤1e5) 和 p[2],p[3],...p[n]，其中 p[i] 表示节点 i 的父节点 (1≤p[i]<i)。
定义 start[i] 为访问到节点 i 时的时间戳，具体计算方式如下：
初始化 time=0，从节点 1 出发，DFS 这棵树。
每递归到一个新的节点 i，先把 time 加一，然后记录 start[i]=time。
在 DFS 之前，随机打乱每个节点的子节点列表。
对于每个节点 i，输出 start[i] 的期望值。
与答案的误差不能超过 1e-6。

rating 1700
设子树 i 的大小为 size[i]。
假设节点 1 有三个儿子 2,3,4，那么 start[3] 至少是 2（先访问 1 再访问 3）。
如果在访问 3 之前，先访问子树 2，那么 3 的时间戳就是 2 + size[2]。
对于所有 [2,3,4] 的排列，有 50% 的概率 2 在 3 的左边（另外 50% 的概率 2 在 3 的右边），对于 4 也同理。
从这个角度看，start[3]，首先至少是 2，在此基础上，额外增加 (size[2] + size[4]) / 2。
由于 size[2] + size[4] = n - size[3] - 1（这里减一是把根节点去掉），
所以 start[3] 的期望值为 2 + (n - size[3] - 1) / 2 = (n - size[3] + 3) / 2。
一般地，节点 i 的时间戳期望，等于
(n - size[i] + depth[i] + 1) / 2
其中 depth[i] 为节点 i 的深度（根节点的深度是 1）。
https://codeforces.com/problemset/submission/696/247605500
======

input
7
1 2 1 1 4 4
output
1.0 4.0 5.0 3.5 4.5 5.0 5.0

input
12
1 1 2 2 4 4 3 3 1 10 8
output
1.0 5.0 5.5 6.5 7.5 8.0 8.0 7.0 7.5 6.5 7.5 8.0
 */
