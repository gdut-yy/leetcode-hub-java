package p1900;

import java.util.Scanner;

public class CF1900C {
    static int n;
    static char[] s;
    static int[][] g;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            s = scanner.next().toCharArray();
            g = new int[n][2];
            for (int i = 0; i < n; i++) {
                g[i][0] = scanner.nextInt();
                g[i][1] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        int ans = dfs(0);
        return String.valueOf(ans);
    }

    static int dfs(int v) {
        int l = g[v][0] - 1, r = g[v][1] - 1;
        if (l < 0 && r < 0) {
            return 0;
        }
        int res = (int) 1e9;
        if (l >= 0) {
            res = dfs(l);
            if (s[v] != 'L') {
                res++;
            }
        }
        if (r >= 0) {
            int res2 = dfs(r);
            if (s[v] != 'R') {
                res2++;
            }
            res = Math.min(res, res2);
        }
        return res;
    }
}
/*
C. Anji's Binary Tree
https://codeforces.com/contest/1900/problem/C

灵茶の试炼 2025-03-10
题目大意：
输入 T(≤5e4) 表示 T 组数据。所有数据的 n 之和 ≤3e5。
每组数据输入 n(2≤n≤3e5) 和一个长为 n 的字符串 s，只包含 U L R 三种字母。
然后输入 n 对整数 L[i] 和 R[i]，表示一棵 n 个节点的二叉树，第 i 个节点的左儿子和右儿子的节点编号分别为 L[i] 和 R[i]。
节点编号从 1 到 n。如果 L[i] = 0 表示 i 没有左儿子，如果 R[i] = 0 表示 i 没有右儿子。
每个节点 i 都有一个指令 s[i]，表示往父节点（U），左儿子（L），右儿子（R）方向移动。如果指令对应的节点不存在，则原地不动。
你可以修改 s 中的字母。
至少要修改多少次，使得我们能从根节点 1 出发，遵循节点上的指令，在移动过程中遇到叶子节点？
注意：不要求最终停留在叶子上，只要在移动过程中能遇到叶子就行。

rating 1300
树形 DP。
如果要往左儿子走，那么答案为从左儿子往下走到叶子的最小操作次数 + (当前节点 != 'L')。
如果要往右儿子走，那么答案为从右儿子往下走到叶子的最小操作次数 + (当前节点 != 'R')。
两种情况取最小值，就是从当前节点往下走到叶子的最小操作次数了。
代码 https://codeforces.com/problemset/submission/1900/309284609
代码备份（洛谷）
======

Input
5
3
LRU
2 3
0 0
0 0
3
ULR
3 2
0 0
0 0
2
LU
0 2
0 0
4
RULR
3 0
0 0
0 4
2 0
7
LLRRRLU
5 2
3 6
0 0
7 0
4 0
0 0
0 0
Output
0
1
1
3
1
 */
