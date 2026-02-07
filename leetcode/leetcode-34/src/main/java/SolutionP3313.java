import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SolutionP3313 {
    private List<Integer>[] graph;
    private int[][] dp;
    private int[] ans;

    public int[] lastMarkedNodes(int[][] edges) {
        int n = edges.length + 1;
        graph = new ArrayList[n];
        Arrays.setAll(graph, e -> new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        dp = new int[n][2]; // 编号, 深度
        // 第一次DFS：计算每个节点子树中的最深节点
        dfs1(0, -1, 0);
        ans = new int[n];
        // 第二次DFS：计算每个节点的答案
        dfs2(0, -1, 0, new int[2]);
        return ans;
    }

    private void dfs1(int u, int fa, int depth) {
        dp[u][0] = u;
        dp[u][1] = depth; // 更新当前节点的深度
        for (int v : graph[u]) {
            if (v == fa) continue;
            dfs1(v, u, depth + 1);
            // 更新当前节点的最深子树信息
            if (dp[v][1] > dp[u][1]) {
                dp[u][0] = dp[v][0];
                dp[u][1] = dp[v][1];
            }
        }
    }

    private void dfs2(int u, int fa, int depth, int[] pir) {
        int node = pir[0], d = pir[1];
        ans[u] = (dp[u][1] - depth > d) ? dp[u][0] : node;
        // 收集非父节点的子节点信息
        List<int[]> children = new ArrayList<>();
        for (int v : graph[u]) {
            if (v == fa) continue;
            children.add(dp[v]);
        }
        if (children.isEmpty()) return;
        // 计算前缀最大值
        List<int[]> pre_max = new ArrayList<>();
        pre_max.add(children.getFirst());
        for (int i = 1; i < children.size(); i++) {
            int[] pre = pre_max.get(i - 1);
            int[] cur = children.get(i);
            pre_max.add((cur[1] > pre[1]) ? cur : pre);
        }
        // 计算后缀最大值
        List<int[]> suf_max = new ArrayList<>();
        suf_max.add(children.getLast());
        for (int i = children.size() - 2; i >= 0; i--) {
            int[] nxt = suf_max.getLast();
            int[] cur = children.get(i);
            suf_max.add((cur[1] > nxt[1]) ? cur : nxt);
        }
        Collections.reverse(suf_max);
        int idx = 0;
        for (int v : graph[u]) {
            if (v == fa) continue;
            int curNode = node, curDist = pir[1] + 1;
            // 检查前缀最大值
            if (idx > 0) {
                int[] candidate = pre_max.get(idx - 1);
                int candidateDist = candidate[1] - depth + 1;
                if (candidateDist > curDist) {
                    curNode = candidate[0];
                    curDist = candidateDist;
                }
            }
            // 检查后缀最大值
            if (idx + 1 < suf_max.size()) {
                int[] candidate = suf_max.get(idx + 1);
                int candidateDist = candidate[1] - depth + 1;
                if (candidateDist > curDist) {
                    curNode = candidate[0];
                    curDist = candidateDist;
                }
            }
            dfs2(v, u, depth + 1, new int[]{curNode, curDist});
            idx++;
        }
    }
}
/*
$3313. 查找树中最后标记的节点
https://leetcode.cn/problems/find-the-last-marked-nodes-in-tree/description/

有一棵有 n 个节点，编号从 0 到 n - 1 的 无向 树。给定一个长度为 n - 1 的整数数组 edges，其中 edges[i] = [ui, vi] 表示树中的 ui 和 vi 之间有一条边。
一开始，所有 节点都 未标记。之后的每一秒，你需要标记所有 至少 有一个已标记节点相邻的未标记节点。
返回一个数组 nodes，表示在时刻 t = 0 标记了节点 i，那么树中最后标记的节点是 nodes[i]。如果对于任意节点 i 有多个 nodes[i]，你可以选择 任意 一个作为答案。
提示：
2 <= n <= 10^5
edges.length == n - 1
edges[i].length == 2
0 <= edges[i][0], edges[i][1] <= n - 1
输入保证 edges 形成一棵合法的树。

换根 DP。
https://leetcode.cn/problems/find-the-last-marked-nodes-in-tree/solutions/2959448/huan-gen-dp-by-ml_terminator-crqp/
 */