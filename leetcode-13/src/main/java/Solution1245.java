import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1245 {
    private Map<Integer, List<Integer>> graph;
    private int ans;
    int n;
    private boolean[] visited;

    public int treeDiameter(int[][] edges) {
        // n 个点
        n = edges.length + 1;
        visited = new boolean[n];
        ans = 0;
        graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
        }

        visited[0] = true;
        dfs(0);
        return ans;
    }

    private int dfs(int x) {
        if (x > n) {
            return 0;
        }
        int maxLen = 0;
        for (int y : graph.getOrDefault(x, new ArrayList<>())) {
            if (!visited[y]) {
                visited[y] = true;
                int len = dfs(y) + 1;
                ans = Math.max(ans, maxLen + len);
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }
}
/*
$1245. 树的直径
https://leetcode-cn.com/problems/tree-diameter/

给你这棵「无向树」，请你测算并返回它的「直径」：这棵树上最长简单路径的 边数。
我们用一个由所有「边」组成的数组 edges 来表示一棵无向树，其中 edges[i] = [u, v] 表示节点 u 和 v 之间的双向边。
树上的节点都已经用 {0, 1, ..., edges.length} 中的数做了标记，每个节点上的标记都是独一无二的。
提示：
0 <= edges.length < 10^4
edges[i][0] != edges[i][1]
0 <= edges[i][j] <= edges.length
edges 会形成一棵无向树

树形 dp。
相似题目: 2246. 相邻字符不同的最长路径
https://leetcode-cn.com/problems/longest-path-with-different-adjacent-characters/
 */