package p2117;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CF2117F {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    static int n;
    static ArrayList<Integer>[] g;

    public static void main(String[] args) {
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static final int MOD = (int) (1e9 + 7);
    static List<Integer> a;

    private static void solve() {
        n = scanner.nextInt();
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        g[0].add(-1);
        for (int i = 0; i < n - 1; i++) {
            int v = scanner.nextInt() - 1;
            int w = scanner.nextInt() - 1;
            g[v].add(w);
            g[w].add(v);
        }

        int cnt = 0;
        for (List<Integer> to : g) {
            if (to.size() > 3) {
                cnt = 2;
                break;
            }
            if (to.size() == 3) {
                cnt++;
            }
        }
        if (cnt > 1) {
            out.println(0);
            return;
        }
        if (cnt == 0) {
            out.println(quickPow(2, n));
            return;
        }

        a = new ArrayList<>();
        dfs(0, -1);
        int x = a.get(0), y = a.get(1);
        long res;
        if (x == y) {
            res = quickPow(2, n - x * 2L + 1);
        } else {
            res = quickPow(2, n - Math.min(x, y) * 2L - 1) * 3 % MOD;
        }
        out.println(res);
    }

    static int dfs(int v, int fa) {
        int size = 1;
        for (Integer w : g[v]) {
            if (w == fa) {
                continue;
            }
            int sz = dfs(w, v);
            size += sz;
            if (g[v].size() == 3) {
                a.add(sz);
            }
        }
        return size;
    }

    // 快速幂 res = a^b % mod
    static long quickPow(long a, long b) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) != 0) res = res * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }
}
/*
F. Wildflower
https://codeforces.com/contest/2117/problem/F

灵茶の试炼 2025-07-02
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(2≤n≤2e5) 和一棵 n 个节点的无向树的 n-1 条边。节点编号从 1 开始。
根节点为 1。
请你给每个节点分配一个点权，值为 1 或者 2。
要求：所有子树的点权和互不相同。
一共有 2^n 种点权分配方案，其中有多少个合法方案？
答案模 1e9+7。

rating 1800
元素值只有 2 种。如果整棵树有至少 3 个叶子，那么根据鸽巢原理，一定有 2 个叶子的值是一样的，不符合要求。
所以至多 2 个叶子。
分类讨论：
1. 如果只有一个叶子，那么树是链，每个节点是 1 还是 2 都可以，答案为 2^n。
2. 如果有两个叶子，统计分叉处的左右子树大小 x 和 y：
2.1 如果 x=y，那么左子树可以是奇数 1,3,5,...，右子树可以是偶数 2,4,6,...，或者左子树是偶数，右子树是奇数。
分叉处到根节点这 n-2x 个点随意，方案数为 2^(n-2x) * 2 = 2^(n-2x+1)。
2.2 如果 x≠y，比如 x=2，y=4，画一画：
- 左奇右偶，有 n-2x 个点可以随便填。
- 左偶右奇，有 n-2x-1 个点可以随便填。
- 相加得方案数为 2^(n-2*min(x,y)-1) * 3。
代码 https://codeforces.com/contest/2117/submission/325222146
代码备份（Ubuntu Pastebin）
======

Input
7
2
1 2
8
1 2
2 3
3 8
2 4
4 5
5 6
6 7
10
1 2
2 3
3 4
4 5
5 6
4 7
7 8
4 9
9 10
7
1 4
4 2
3 2
3 5
2 6
6 7
7
1 2
2 3
3 4
3 5
4 6
6 7
7
5 7
4 6
1 6
1 3
2 6
6 7
5
3 4
1 2
1 3
2 5
Output
4
24
0
16
48
0
4
 */
