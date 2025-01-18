package p109;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CF109C {
    static int n;
    static List<nb>[] g;

    record nb(int to, boolean lucky) {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 1; i < n; i++) {
            int v = scanner.nextInt() - 1;
            int w = scanner.nextInt() - 1;
            String s = scanner.next();
            boolean lucky = true;
            for (char c : s.toCharArray()) {
                if (c != '4' && c != '7') {
                    lucky = false;
                    break;
                }
            }
            g[v].add(new nb(w, lucky));
            g[w].add(new nb(v, lucky));
        }
        System.out.println(solve());
    }

    static boolean[] vis;
    static int sz;

    private static String solve() {
        vis = new boolean[n];
        sz = 0;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                sz = 0;
                dfs(i);
                ans += sz * (n - sz) * (n - sz - 1L);
            }
        }
        return String.valueOf(ans);
    }


    static void dfs(int v) {
        vis[v] = true;
        sz++;
        for (nb e : g[v]) {
            if (!e.lucky && !vis[e.to]) {
                dfs(e.to);
            }
        }
    }
}
/*
C. Lucky Tree
https://codeforces.com/contest/109/problem/C

灵茶の试炼 2024-10-17
题目大意：
输入 n(1≤n≤1e5) 和一棵树的 n-1 条边（节点编号从 1 开始），每条边包含 3 个数 x y z(1≤z≤1e9)，表示有一条边权为 z 的边连接 x 和 y。
定义幸运数为只包含 4 和 7 的数，例如 47、744、4。
输出有多少个三元组 (i,j,k)，满足 i,j,k 互不相同，且从 i 到 j 的简单路径上存在幸运边权，从 i 到 k 的简单路径上也存在幸运边权。
注意 (1,2,3) 和 (2,1,3) 是两个不同的三元组。

rating 1900
把所有幸运边断开，树就被分成了一些连通块。
枚举 i，那么 j 和 k 必须在其他连通块中。
设 i 所在连通块的大小为 sz。
那么就找到了 A(n-sz,2) = (n-sz) * (n-sz-1) 个三元组。
由于 i 所在连通块的所有点，对应的 j 和 k 都在外面，
可以直接把 sz * (n-sz) * (n-sz-1) 加入答案，然后枚举下一个连通块。
代码 https://codeforces.com/problemset/submission/109/286153916
注：本题也可以用换根 DP 做，但远不如上述解法简单。
======

Input
4
1 2 4
3 1 2
1 4 7
Output
16

Input
4
1 2 4
1 3 47
1 4 7447
Output
24
 */
