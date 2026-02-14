import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution3812 {
    public List<Integer> minimumFlips(int n, int[][] edges, String start, String target) {
        int[] need = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            need[i] = (start.charAt(i) != target.charAt(i)) ? 1 : 0;
            sum += need[i];
        }
        if (sum % 2 != 0) {
            return List.of(-1);
        }

        ArrayList<int[]>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0], b = edges[i][1];
            g[a].add(new int[]{b, i});
            g[b].add(new int[]{a, i});
        }

        int[] parent = new int[n];
        int[] parentEdgeIdx = new int[n];
        ArrayList<int[]>[] child = new ArrayList[n];
        for (int i = 0; i < n; i++) child[i] = new ArrayList<>();

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        q.offer(0);
        vis[0] = true;
        parent[0] = -1;
        parentEdgeIdx[0] = -1;
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int[] next : g[u]) {
                int v = next[0], idx = next[1];
                if (!vis[v]) {
                    vis[v] = true;
                    parent[v] = u;
                    parentEdgeIdx[v] = idx;
                    child[u].add(new int[]{v, idx});
                    q.offer(v);
                }
            }
        }

        int[] pendingChild = new int[n];
        for (int i = 0; i < n; i++) {
            pendingChild[i] = child[i].size();
        }

        Queue<Integer> leafQue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (pendingChild[i] == 0) {
                leafQue.offer(i);
            }
        }

        boolean[] selected = new boolean[edges.length];
        while (!leafQue.isEmpty()) {
            int u = leafQue.poll();
            if (parent[u] != -1) {
                if (need[u] == 1) {
                    selected[parentEdgeIdx[u]] = true;
                }
                need[parent[u]] ^= need[u];
                pendingChild[parent[u]]--;
                if (pendingChild[parent[u]] == 0) {
                    leafQue.offer(parent[u]);
                }
            }
        }

        if (need[0] != 0) {
            return List.of(-1);
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < selected.length; i++) {
            if (selected[i]) ans.add(i);
        }
        return ans;
    }
}
/*
3812. 翻转树上最少边
https://leetcode.cn/problems/minimum-edge-toggles-on-a-tree/description/

第 174 场双周赛 T4。

给你一棵包含 n 个节点的 无向树，节点编号从 0 到 n - 1。该树由长度为 n - 1 的二维整数数组 edges 表示，其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条边。
另外给你两个长度为 n 的 二进制 字符串 start 和 target。对于每个节点 x，start[x] 是其初始颜色，而 target[x] 是其目标颜色。
在一次操作中，你可以选择下标为 i 的一条边并 翻转 它的两个端点。也就是说，如果这条边是 [u, v]，那么节点 u 和 v 的颜色 各自 从 '0' 变为 '1'，或者从 '1' 变为 '0'。
返回一个边下标数组，执行这些边对应的操作可以将 start 转换为 target。在所有有效序列中找出 长度最短 的序列，以 升序 返回边下标。
如果无法将 start 转换为 target，则返回一个仅包含单个元素 -1 的数组。
提示：
2 <= n == start.length == target.length <= 10^5
edges.length == n - 1
edges[i] = [ai, bi]
0 <= ai, bi < n
start[i] 是 '0' 或 '1'。
target[i] 是 '0' 或 '1'。
输入数据保证 edges 构成一棵有效的树。

树 BFS。
https://chat.deepseek.com/a/chat/s/7ff4e6ef-cf7f-4483-ac21-38b74a7a4c08
时间复杂度 O(n)。
rating 2186 (clist.by)
 */