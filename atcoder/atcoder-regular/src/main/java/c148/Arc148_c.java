package c148;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Arc148_c {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int[] p = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            p[i] = scanner.nextInt();
        }
        // 预处理
        pretreatment(n, p);

        for (int i = 0; i < q; i++) {
            int m = scanner.nextInt();
            int[] v = new int[m];
            for (int j = 0; j < m; j++) {
                v[j] = scanner.nextInt();
            }
            System.out.println(solve(n, p, m, v));
        }
    }

    private static int[] child;

    private static void pretreatment(int n, int[] p) {
        child = new int[n + 1];
        for (int pi : p) {
            child[pi]++;
        }
    }

    private static String solve(int n, int[] p, int m, int[] v) {
        Set<Integer> has = new HashSet<>();
        for (int vi : v) {
            has.add(vi);
        }

        int ans = 0;
        for (Integer h : has) {
            ans += child[h];
            if (has.contains(p[h])) {
                ans--;
            } else {
                ans++;
            }
        }
        return String.valueOf(ans);
    }
}
/*
C - Lights Out on Tree
https://atcoder.jp/contests/arc148/tasks/arc148_c

灵茶の试炼 2023-02-02
题目大意：
输入 n(2≤n≤2e5) q(≤2e5)，然后输入 p2,p3,...,pn 表示一棵根为 1 的树，pi 表示点 i 的父节点。
然后输入 q 个询问，每个询问先输入 m，然后输入 m 个互不相同的特殊节点 v1,v2,...,vm。所有询问的 m 之和不超过 2e5。
每个节点都有一盏灯，其中特殊节点的灯打开，其余节点的灯关闭。
每次操作，你可以选择一棵子树，切换子树内所有灯的开/闭状态。
对每个询问，回答：要使所有灯关闭，至少需要多少次操作。

https://atcoder.jp/contests/arc148/submissions/38529258
提示 1：如果只有一盏灯 v 亮着，要使所有灯关闭，需要操作 v 和 v 的所有儿子，也就是 1 + child[v] 次，其中 child[v] 表示 v 的儿子个数。
提示 2：如果 v 的儿子已经亮着，就不用操作儿子了；同样地，如果 p[v] 已经亮着，就不用操作 v 自己了。
======

Input
6 6
1 1 2 2 5
6 1 2 3 4 5 6
3 2 5 6
1 3
3 1 2 3
3 4 5 6
4 2 3 4 5
Output
1
2
1
3
2
3
 */