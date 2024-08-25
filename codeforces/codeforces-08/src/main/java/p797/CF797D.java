package p797;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CF797D {
    private static int n;
    private static int[][] vlr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        vlr = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
            vlr[i][0] = scanner.nextInt();
            vlr[i][1] = scanner.nextInt();
            vlr[i][2] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static Map<Integer, Integer> cnt;
    private static int ans;

    private static String solve() {
        cnt = new HashMap<>();
        boolean[] hasFa = new boolean[n + 2];
        for (int i = 1; i <= n; i++) {
            int v = vlr[i][0], l = vlr[i][1], r = vlr[i][2];
            cnt.put(v, cnt.getOrDefault(v, 0) + 1);
            hasFa[l + 1] = true;
            hasFa[r + 1] = true;
        }

        int rt = 1;
        while (hasFa[rt + 1]) {
            rt++;
        }

        ans = n;
        dfs(rt, 0, Integer.MAX_VALUE);
        return String.valueOf(ans);
    }

    private static void dfs(int i, int l, int r) {
        if (i < 0) {
            return;
        }
        int[] o = vlr[i];
        if (l <= o[0] && o[0] <= r) {
            ans -= cnt.getOrDefault(o[0], 0);
        }
        if (l < o[0]) {
            dfs(o[1], l, Math.min(r, o[0] - 1));
        }
        if (r > o[0]) {
            dfs(o[2], Math.max(l, o[0] + 1), r);
        }
    }
}
/*
D. Broken BST
https://codeforces.com/contest/797/problem/D

灵茶の试炼 2023-01-31
题目大意：
输入 n(1≤n≤1e5) 和一棵二叉树的 n 个节点（节点按照输入顺序编号为 1 到 n）。每行输入 x l r，对应节点值 [0,1e9] 和左右儿子的编号，如果没有则为 -1。
输入保证恰好有一个节点没有父节点，即根节点。
如下是一个在二叉搜索树中查找元素的伪代码：
bool find(TreeNode t, int x) {
    if (t == null)
        return false;
    if (t.value == x)
        return true;
    if (x < t.value)
        return find(t.left, x);
    else
        return find(t.right, x);
}
find(root, x);
把二叉树的每个节点值应用上述代码，输出你会得到多少次 false。
注意节点值可能有重复的。

rating 2100
https://codeforces.com/contest/797/submission/190439455
考虑有多少个节点值可以找到。
参考 https://www.bilibili.com/video/BV14G411P7C1/ 的方法一，把合法查询范围作为递归参数传下去。
如果节点值 x 在范围内，则有 cnt[x] 个 x 可以找到。
注：用 cnt 是因为有重复的节点，这些节点值都可以找到（即使某些节点无法访问到）。
相似题目: 98. 验证二叉搜索树
https://leetcode.cn/problems/validate-binary-search-tree/
======

input
3
15 -1 -1
10 1 3
5 -1 -1
output
2

input
8
6 2 3
3 4 5
12 6 7
1 -1 8
4 -1 -1
5 -1 -1
14 -1 -1
2 -1 -1
output
1
 */
