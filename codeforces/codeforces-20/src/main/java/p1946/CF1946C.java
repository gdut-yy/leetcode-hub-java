package p1946;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class CF1946C {
    static int n, k;
    static List<Integer>[] g;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            k = scanner.nextInt();
            g = new ArrayList[n];
            Arrays.setAll(g, e -> new ArrayList<>());
            for (int i = 0; i < n - 1; i++) {
                int x = scanner.nextInt() - 1;
                int y = scanner.nextInt() - 1;
                g[x].add(y);
                g[y].add(x);
            }
            System.out.println(solve());
        }
    }


    private static String solve() {
        int ans = sortSearch(n / (k + 1), low -> {
            low++;
            cnt = 0;
            if (dfs(0, -1, low) >= low) {
                cnt++;
            }
            return cnt <= k;
        });
        return String.valueOf(ans);
    }

    static int cnt;

    static int dfs(int x, int fa, int low) {
        int s = 1;
        for (Integer y : g[x]) {
            if (y != fa) {
                s += dfs(y, x, low);
            }
        }
        if (s >= low) {
            cnt++;
            return 0;
        }
        return s;
    }

    // func Search(n int, f func(int) bool) int { ... }
    static int sortSearch(int n, Function<Integer, Boolean> f) {
        int l = 0, r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (f.apply(mid)) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}
/*
C. Tree Cutting
https://codeforces.com/contest/1946/problem/C

灵茶の试炼 2024-08-14
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤1e5。
每组数据输入 n k(1≤k<n≤1e5) 和一棵 n 个节点的无向树的 n-1 条边。节点编号从 1 开始。
你需要移除这棵树的恰好 k 条边。
移除后，我们得到了 k+1 个连通块。
设 x 为最小连通块的大小（节点个数）。
输出 x 的最大值。

rating 1600
最大化最小值 -> 二分答案。
写一个树形 DP，如果子树大小 >= 二分的 mid，就断开边，计数器加一，DFS 返回 0；否则 DFS 返回子树大小。
DFS 结束后，别忘了包含 DFS 起点的这个连通块，如果其大小 >= mid，那么计数器额外加一。（也就是判断 DFS 的最终返回值是否 >= mid）
如果计数器的值 >= k+1，说明可以做到让每个连通块的大小都至少为 mid。
开区间二分下界：1，因为 x >= 1。
开区间二分上界：n/(k+1)+1，因为 x <= n/(k+1)。
https://codeforces.com/problemset/submission/1946/275176410
======

Input
6
5 1
1 2
1 3
3 4
3 5
2 1
1 2
6 1
1 2
2 3
3 4
4 5
5 6
3 1
1 2
1 3
8 2
1 2
1 3
2 4
2 5
3 6
3 7
3 8
6 2
1 2
2 3
1 4
4 5
5 6
Output
2
1
3
1
1
2
 */