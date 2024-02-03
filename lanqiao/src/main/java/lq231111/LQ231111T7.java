package lq231111;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LQ231111T7 {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[MAX_N];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    static final int MAX_N = (int) (1e5 + 5);
    static int[] fib;
    static int FB;
    static List<int[]>[] g;

    private static String solve() {
        build();

        vis = new int[MAX_N][30];
        String[] ans = new String[n];
        for (int i = 1; i <= n; i++) {
            dfs(i, 0);
            ans[i - 1] = (vis[i][0] == 1) ? "Little Lan" : "Little Qiao";
        }
        return String.join(System.lineSeparator(), ans);
    }

    private static void build() {
        fib = new int[30];
        fib[0] = fib[1] = 1;
        for (int i = 2; i < 30; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        FB = 0;
        while (fib[FB + 1] <= n) {
            FB++;
        }
        g = new ArrayList[n + 1];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= FB; j++) {
                int i1 = i - fib[j];
                int i2 = i + fib[j];
                if (i1 >= 1 && a[i] < a[i1]) {
                    g[i].add(new int[]{i1, j});
                }
                if (i2 <= n && a[i] < a[i2]) {
                    g[i].add(new int[]{i2, j});
                }
            }
        }
    }

    static int[][] vis;

    // 0 -> not visited
    // 1 -> win
    // 2 -> lose
    static void dfs(int x, int last) {
        if (vis[x][last] > 0) return;
        for (int[] e : g[x]) {
            if (e[1] <= last) continue;
            dfs(e[0], e[1]);
            if (vis[e[0]][e[1]] == 2) {
                vis[x][last] = 1;
                return;
            }
        }
        vis[x][last] = 2;
    }
}
/*
斐波拉契跳跃【算法赛】

状态定义：考虑到只能从小的数字移动到大的数字，dp 数组的第一维并不适合表示当前棋子的所在位置，我们可以定义 dp(i,j) 表示当前棋子在的位置上的数的大小为 i，上一次移动距离为 j 时，先手是否必胜（1为必胜，0为必败）
状态初始化：对于任意的 k，均有 dp(n,k) = 0，这也决定了状态转移的方向是从后往前转移
状态转移：考虑到 1e5 内的斐波那契数很少，可以先预处理，同时令 dp(i,j) 中的 j 表示上一次移动棋子使用的斐波那契数为第 j 个
那么对于当前状态 dp(i,j) 我们需要枚举本次移动的距离为斐波那契数为第 k 个，其中 j+1 <= k <= m 然后判断是否可以从 i 移动到 i+k 或者 i-k，所以 dp(i,j) 就由所有的 dp(i+k,k) 和 dp(i-k,k) 来决定（k > j 且移动终点不越界）
如果可以移动，则我们需要判断下一步的走到的所有位置中对手是否存在必败，如果对手必败，则当前先手必胜；否则，后继都是必胜，则当前先手必败，即：
- 对于必胜态，一定有一个后继状态是必败的
- 对于必败态，所有后继状态是必胜的
dp[pos][j] = (!dp[pos + v[k]][k]) (pos + v[k] <= n && a[pos + v[j]] > i)
dp[pos][j] = (!dp[pos - v[k]][k]) (pos - v[k] >= 1 && a[pos - v[j]] > i)
最后，对于每一个起点 i，我们只需要判断对于 1 <= j <= m，dp(i,j) 中是否存在必胜策略即可。如果存在，则先手必胜，否则，先手必败。
 */