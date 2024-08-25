package lq240323;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LQ240323T8 {
    static int n, w;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer>[] g = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            g[i] = new ArrayList<>();
        }
        int[] a = new int[N];
        int[] b = new int[N];
        int[] sz = new int[N];
        int[][] dp = new int[N][N];
        int[] tmp = new int[N];

        n = scanner.nextInt();
        w = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE / 2;
            }
        }
        b[1] = Integer.MAX_VALUE / 2;
        for (int i = 2; i <= n; i++) {
            int fa = scanner.nextInt();
            int cost = scanner.nextInt();
            b[i] = cost;
            g[fa].add(i);
        }

        dfs(g, a, b, sz, dp, tmp, 1);

        for (int i = n; i >= 0; i--) {
            if (dp[1][i] <= w) {
                System.out.println(i);
                break;
            }
        }
    }

    static final int N = 5050;

    static void dfs(List<Integer>[] g, int[] a, int[] b, int[] sz, int[][] dp, int[] tmp, int u) {
        sz[u] = 1;
        dp[u][0] = 0;
        for (int v : g[u]) {
            dfs(g, a, b, sz, dp, tmp, v);
            for (int i = 1; i <= sz[u] + sz[v]; i++) {
                tmp[i] = Integer.MAX_VALUE;
            }
            for (int j = 0; j <= sz[u]; j++) {
                for (int k = 0; k <= sz[v]; k++) {
                    tmp[j + k] = Math.min(tmp[j + k], dp[u][j] + dp[v][k]);
                }
            }
            sz[u] += sz[v];
            for (int j = 1; j <= sz[u]; j++) {
                dp[u][j] = tmp[j];
            }
        }
        dp[u][sz[u] - 1] = Math.min(dp[u][sz[u] - 1], a[u]);
        dp[u][sz[u]] = Math.min(dp[u][sz[u]], b[u]);
    }
}
/*
取气球【算法赛】

这个问题中，每个气球都最多连着一根绳子，相当于每个气球有唯一的父亲，因此这些气球组成了一棵树，且 1 号气球为根节点。
在动态规划（DP）中，核心是状态的设计和重叠的子问题结构，观察到树本身就是一个递归的结构，因此考虑在每棵子树上进行 DP，然后将子树的结果合并起来。
对于这个问题，一个直观的想法是枚举每个节点 u 的每个子结点 v，同时枚举以 v 为根的子树所能获得的气球数量，然后将子树的结果合并到节点 u 上。
设以 x 为根的子树大小为 size，定义 f[u][j] 表示以 u 号节点为根的子树中，使用了 j 点力气可以获得的最多气球数量。
可以得到以下状态转移方程：
1、如果当前节点 u 的力气足够，即 j ≥ wi，那么可以选择戳破 u 获得收益 sz[u]-1：
dp[u][j] = max(dp[u][j], dp[u][j - wi] + sz[w])
2、对于每个子树 v，其力气不超过当前节点 u 的力气：
dp[u][j] = max(dp[u][j], dp[u][j - k] + dp[v][k])
3、最后，如果当前节点 u 的力气不小于 a[u]，则直接戳破获得收益最大：
dp[u][j] = max(dp[u][j], sz[u]-1)
然而，上述做法的时间复杂度为 O(N * w^2），无法通过本题。因此，需要考虑优化。
---
将内部循环中的状态与子树大小相关联，也许可以通过类似启发式合并的思想降低复杂度。
现在让 f[u][j] 表示以 u 号节点为根的子树中，获得了 j 个气球所需最小力气。
因为以 u 为根的子树获得的气球数量不会超过 sz[u]，所以此时我们只需枚举子树大小即可。
为了方便处理，我们将每个气球 u 上方的绳子的边权 wi 当成另一种点权，记为 b[u]，这表示我们可以花费 b[u] 的代价获得整个以 u 为根的子树。
接下来是优化后的状态转移方程：
1、如果 u 的力气足够，即 j ≥ b[u]，则戳破 u 荻得的收益最大，即 dp[u][j] = sz[u] - 1。
2、对于每个子树 v 的大小 k，进行状态转移：
dp[u][j + k] = min(dp[u][j + k], dp[u][j] + dp[v][k])
3、最后，对于 u 的力气不小于 a[u] 的情况：
dp[u][sz[u]-1] = min(dp[u][sz[u] - 1], a[u])
dp[u][sz[u]] = min(dp[u][sz[u]], b[u])
同时，为了避免出现“某一个子树中的点/边被重复选取，或是某个子树既选择了割断连向这个子树的边，又选择了子树内部的点/边”这些情况，
我们可以引入一个新的数组 tmp 来进行第一个方程的转移，然后在结束后用 tmp 更新 dp 数组。
即将第一个状态转移方程改为：
tmp[j + k] = min(tmp[j + k], dp[u][j] + dp[v][k])
dp[u][j] = tmp[j]
@小羊肖恩Yawn_Sean
 */