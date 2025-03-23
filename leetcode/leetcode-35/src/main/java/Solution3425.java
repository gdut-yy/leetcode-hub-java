import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution3425 {
    private int[] nums;
    private List<int[]>[] g;
    private List<Integer> dis;
    private Map<Integer, Integer> lastDepth;
    private int maxLen, minNodes;

    public int[] longestSpecialPath(int[][] edges, int[] nums) {
        this.nums = nums;
        int n = edges.length + 1;
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0], v = e[1], wt = e[2];
            g[u].add(new int[]{v, wt});
            g[v].add(new int[]{u, wt});
        }

        dis = new ArrayList<>();
        dis.add(0);
        lastDepth = new HashMap<>();
        maxLen = -1;
        minNodes = 0;
        dfs(0, -1, 0);
        return new int[]{maxLen, minNodes};
    }

    private void dfs(int x, int fa, int topDepth) {
        int color = nums[x];
        int oldDepth = lastDepth.getOrDefault(color, 0);
        topDepth = Math.max(topDepth, oldDepth);

        int disX = dis.getLast();
        int len = disX - dis.get(topDepth);
        int nodes = dis.size() - topDepth;
        if (len > maxLen || len == maxLen && nodes < minNodes) {
            maxLen = len;
            minNodes = nodes;
        }

        lastDepth.put(color, dis.size());
        for (int[] e : g[x]) {
            int y = e[0];
            if (y != fa) { // 避免访问父节点
                dis.add(disX + e[1]);
                dfs(y, x, topDepth);
                dis.removeLast(); // 恢复现场
            }
        }
        lastDepth.put(color, oldDepth); // 恢复现场
    }
}
/*
3425. 最长特殊路径
https://leetcode.cn/problems/longest-special-path/description/

第 148 场双周赛 T3。

给你一棵根节点为节点 0 的无向树，树中有 n 个节点，编号为 0 到 n - 1 ，这棵树通过一个长度为 n - 1 的二维数组 edges 表示，其中 edges[i] = [ui, vi, lengthi] 表示节点 ui 和 vi 之间有一条长度为 lengthi 的边。同时给你一个整数数组 nums ，其中 nums[i] 表示节点 i 的值。
特殊路径 指的是树中一条从祖先节点 往下 到后代节点且经过节点的值 互不相同 的路径。
注意 ，一条路径可以开始和结束于同一节点。
请你返回一个长度为 2 的数组 result ，其中 result[0] 是 最长 特殊路径的 长度 ，result[1] 是所有 最长特殊路径中的 最少 节点数目。
提示：
2 <= n <= 5 * 10^4
edges.length == n - 1
edges[i].length == 3
0 <= ui, vi < n
1 <= lengthi <= 10^3
nums.length == n
0 <= nums[i] <= 5 * 10^4
输入保证 edges 表示一棵合法的树。

树上滑窗。
时间复杂度 O(n)。
相似题目: 3486. 最长特殊路径 II
https://leetcode.cn/problems/longest-special-path-ii/description/
rating 2715 (clist.by)
 */