package p1926;

import java.util.Scanner;

public class CF1926G {
    static int n;
    static int[] pa;
    static char[] s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            pa = new int[n + 1];
            for (int i = 2; i <= n; i++) {
                pa[i] = scanner.nextInt();
            }
            s = scanner.next().toCharArray();
            System.out.println(solve());
        }
    }

    static final int INF = (int) 1e9;

    private static String solve() {
        int[][] f = new int[n + 1][2];
        for (int i = n; i > 0; i--) {
            int[] g = f[i].clone();
            if (s[i - 1] != 'C') {
                g[s[i - 1] & 1] = INF;
            }
            f[pa[i]][0] += Math.min(g[0], g[1] + 1);
            f[pa[i]][1] += Math.min(g[1], g[0] + 1);
        }
        int ans = Math.min(f[0][0], f[0][1]);
        return String.valueOf(ans);
    }
}
/*
G. Vlad and Trouble at MIT
https://codeforces.com/contest/1926/problem/G

灵茶の试炼 2024-06-20
题目大意：
输入 T(≤1e3) 表示 T 组数据。所有数据的 n 之和 ≤1e5。
每组数据输入 n(2≤n≤1e5) 和 n-1 个数 a2,a3,...,an (1≤ai<i)，表示节点 i 和节点 ai 之间有一条无向边。
这 n-1 条无向边形成了一棵树，节点编号从 1 到 n。
然后输入长为 n 的字符串 s，只包含字母 P S C，表示节点 i 的类型是 s[i]。
最少要切断多少条边，使得类型为 P 的节点都无法到达任意类型为 S 的节点？

rating 1900
首先简单分析一下性质：
如果树上至少有一个非 C 节点，那么对于类型为 C 的节点，它要么和 S 连通，要么和 P 连通（不能都连通）。
对于其他类型的节点也是一样的，S 只能和 S 连通，不能和 P 连通；P 只能和 P 连通，不能和 S 连通。
假设 1 是树的根。
定义 f[x][0] 表示以 x 为根的子树，要使 x 和子树中的 S 连通（相当于和 P 不连通），最少需要切断的边数。如果 s[x]=P，则 f[x][0] = inf。
定义 f[x][1] 表示以 x 为根的子树，要使 x 和子树中的 P 连通（相当于和 S 不连通），最少需要切断的边数。如果 s[x]=S，则 f[x][1] = inf。
从 1 开始 DFS，跑一个树形 DP。
遍历 x 的儿子 y，如果 x 要和 S 连通，那么分类讨论：
  如果 y 也和 S 连通，则 f[x][0] += f[y][0]。
  如果 y 和 P 连通，则 f[x][0] += f[y][1] + 1，因为需要断开 x 和 y 之间的边。
二者取最小值，得
f[x][0] += min(f[y][0], f[y][1] + 1)。
同理得
f[x][1] += min(f[y][1], f[y][0] + 1)。
代码实现时，无需建树，直接从 i=n 开始倒着遍历，转移到其父节点 a[i] 上。
答案为 min(f[1][0], f[1][1])。
如果假设 1 的父节点是 0，答案也可以是 min(f[0][0], f[0][1])。
https://codeforces.com/contest/1926/submission/266315191
======

Input
3
3
1 1
CSP
4
1 2 2
PCSS
4
1 2 2
PPSS
Output
1
1
2
 */
