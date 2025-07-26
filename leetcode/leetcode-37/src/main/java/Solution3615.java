import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3615 {
    private char[] s;
    private List<Integer>[] g;
    private int[][][] memo;

    public int maxLen(int n, int[][] edges, String label) {
        s = label.toCharArray();
        if (edges.length == n * (n - 1) / 2) { // 完全图
            int[] cnt = new int[26];
            for (char ch : s) {
                cnt[ch - 'a']++;
            }
            int ans = 0, odd = 0;
            for (int c : cnt) {
                ans += c - c % 2;
                odd |= c % 2;
            }
            return ans + odd;
        }

        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] e : edges) {
            int x = e[0];
            int y = e[1];
            g[x].add(y);
            g[y].add(x);
        }

        memo = new int[n][n][1 << n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }

        int ans = 0;
        for (int x = 0; x < n; x++) {
            // 奇回文串，x 作为回文中心
            ans = Math.max(ans, dfs(x, x, 1 << x) + 1);
            if (ans == n) {
                return n;
            }
            // 偶回文串，x 和 x 的邻居 y 作为回文中心
            for (int y : g[x]) {
                // 保证 x < y，减少状态个数和计算量
                if (x < y && s[x] == s[y]) {
                    ans = Math.max(ans, dfs(x, y, 1 << x | 1 << y) + 2);
                    if (ans == n) {
                        return n;
                    }
                }
            }
        }
        return ans;
    }

    // 计算从 x 和 y 向两侧扩展，最多还能访问多少个节点（不算 x 和 y）
    private int dfs(int x, int y, int vis) {
        if (memo[x][y][vis] != -1) return memo[x][y][vis];
        int res = 0;
        for (int v : g[x]) {
            if ((vis >> v & 1) > 0) { // v 在路径中
                continue;
            }
            for (int w : g[y]) {
                if ((vis >> w & 1) == 0 && w != v && s[w] == s[v]) {
                    // 保证 v < w，减少状态个数和计算量
                    int r = dfs(Math.min(v, w), Math.max(v, w), vis | 1 << v | 1 << w);
                    res = Math.max(res, r + 2);
                }
            }
        }
        return memo[x][y][vis] = res; // 记忆化
    }
}
/*
3615. 图中的最长回文路径
https://leetcode.cn/problems/longest-palindromic-path-in-graph/description/

第 458 场周赛 T4。

给你一个整数 n 和一个包含 n 个节点的 无向图 ，节点编号从 0 到 n - 1，以及一个二维数组 edges，其中 edges[i] = [ui, vi] 表示节点 ui 和节点 vi 之间有一条边。
同时给你一个长度为 n 的字符串 label，其中 label[i] 是与节点 i 关联的字符。
你可以从任意节点开始，移动到任意相邻节点，每个节点 最多 访问一次。
返回通过访问一条路径，路径中 不包含重复 节点，所能形成的 最长回文串 的长度。
回文串 是指正着读和反着读相同的字符串。
提示:
1 <= n <= 14
n - 1 <= edges.length <= n * (n - 1) / 2
edges[i] == [ui, vi]
0 <= ui, vi <= n - 1
ui != vi
label.length == n
label 只包含小写英文字母。
不存在重复边。

中心扩展法 + 状压 DP + 优化 https://leetcode.cn/problems/longest-palindromic-path-in-graph/solutions/3722469/zhong-xin-kuo-zhan-fa-zhuang-ya-dp-by-en-ai9s/
时间复杂度：O(n^4 * 2^n)
rating 2492 (clist.by)
 */