import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution3841 {
    List<Integer>[] adj;
    int n;
    int[] parent;
    int[][] up;
    int[] depth;
    int[] in, out;
    int time;
    int[] initPrefix;
    char[] chars;
    BIT tr;

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        this.n = n;
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            adj[u].add(v);
            adj[v].add(u);
        }
        chars = s.toCharArray();

        int LOG = 17;
        parent = new int[n];
        depth = new int[n];
        in = new int[n];
        out = new int[n];
        initPrefix = new int[n];
        time = 0;

        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{0, -1, 0});
        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            int u = cur[0], p = cur[1], state = cur[2];
            if (state == 0) {
                parent[u] = p;
                depth[u] = (p == -1) ? 0 : depth[p] + 1;
                int mask = 1 << (chars[u] - 'a');
                if (p == -1) {
                    initPrefix[u] = mask;
                } else {
                    initPrefix[u] = initPrefix[p] ^ mask;
                }
                in[u] = ++time;
                stack.push(new int[]{u, p, 1});
                for (int i = adj[u].size() - 1; i >= 0; i--) {
                    int v = adj[u].get(i);
                    if (v == p) continue;
                    stack.push(new int[]{v, u, 0});
                }
            } else {
                out[u] = time;
            }
        }

        up = new int[n][LOG];
        for (int i = 0; i < n; i++) {
            up[i][0] = parent[i] == -1 ? i : parent[i];
        }
        for (int j = 1; j < LOG; j++) {
            for (int i = 0; i < n; i++) {
                up[i][j] = up[up[i][j - 1]][j - 1];
            }
        }
        tr = new BIT(n);
        List<Boolean> ans = new ArrayList<>();
        for (String q : queries) {
            String[] parts = q.split(" ");
            if (parts[0].equals("update")) {
                int u = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);
                char old = chars[u];
                if (old == c) continue;
                int delta = (1 << (old - 'a')) ^ (1 << (c - 'a'));
                chars[u] = c;
                tr.add(in[u], delta);
                if (out[u] + 1 <= n) tr.add(out[u] + 1, delta);
            } else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);
                int lca = getLCA(u, v, LOG);
                int pu = getPrefix(u);
                int pv = getPrefix(v);
                int cl = 1 << (chars[lca] - 'a');
                int mask = pu ^ pv ^ cl;
                ans.add((mask & (mask - 1)) == 0);
            }
        }
        return ans;
    }

    private int getLCA(int u, int v, int LOG) {
        if (depth[u] < depth[v]) {
            int t = u;
            u = v;
            v = t;
        }
        int diff = depth[u] - depth[v];
        for (int j = 0; j < LOG; j++) {
            if ((diff & (1 << j)) != 0) {
                u = up[u][j];
            }
        }
        if (u == v) return u;
        for (int j = LOG - 1; j >= 0; j--) {
            if (up[u][j] != up[v][j]) {
                u = up[u][j];
                v = up[v][j];
            }
        }
        return up[u][0];
    }

    private int getPrefix(int u) {
        int delta = tr.query(in[u]);
        return initPrefix[u] ^ delta;
    }

    static class BIT {
        int n;
        int[] tree;

        public BIT(int n) {
            this.n = n;
            tree = new int[n + 1];
        }

        int lb(int x) {
            return x & -x;
        }

        void add(int pos, int val) {
            for (; pos <= n; pos += lb(pos)) tree[pos] += val;
        }

        int query(int pos) {
            int ret = 0;
            for (; pos > 0; pos -= lb(pos)) ret += tree[pos];
            return ret;
        }
    }
}
/*
3841. 查询树上回文路径
https://leetcode.cn/problems/palindromic-path-queries-in-a-tree/description/

第 176 场双周赛 T4。

给你一棵包含 n 个节点的无向树，节点编号从 0 到 n - 1。树由一个长度为 n - 1 的二维数组 edges 表示，其中 edges[i] = [ui, vi] 表示节点 ui 和 vi 之间存在一条无向边。
另给你一个长度为 n 且由小写英文字母组成的字符串 s，其中 s[i] 表示分配给节点 i 的字符。
还给你一个字符串数组 queries，其中每个 queries[i] 为以下形式之一：
- "update ui c"：将节点 ui 处的字符更改为 c。正式地，更新 s[ui] = c。
- "query ui vi"：判断从 ui 到 vi 的 唯一 路径（含两端点）上的字符所组成的字符串，是否可以 重新排列 成一个 回文串 。
返回一个布尔数组 answer，如果第 i 个类型为 "query ui vi" 的查询可以重新排列成 回文串 ，则 answer[i] 为 true，否则为 false。
回文串 是指正读和反读都相同的字符串。
提示：
1 <= n == s.length <= 5 * 10^4
edges.length == n - 1
edges[i] = [ui, vi]
0 <= ui, vi <= n - 1
s 由小写英文字母组成。
输入生成的 edges 表示一棵有效的树。
1 <= queries.length <= 5 * 10^4
queries[i] = "update ui c" 或
queries[i] = "query ui vi"
0 <= ui, vi <= n - 1
c 是一个小写英文字母。

LCA + 差分树状数组。
https://chat.deepseek.com/a/chat/s/03846d17-6090-4a41-9d8f-b273c60a6862
 */