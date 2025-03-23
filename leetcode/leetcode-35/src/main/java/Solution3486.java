import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution3486 {
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
        dfs(0, -1, 0, 0);
        return new int[]{maxLen, minNodes};
    }

    // 本题允许窗口中的一个元素（颜色）出现两次，我们记录这个颜色在窗口中的更靠上的深度 last1
    private void dfs(int x, int fa, int topDepth, int last1) {
        int color = nums[x];
        int last2 = lastDepth.getOrDefault(color, 0);
        // 相较 3425 题，维护窗口左端点 topDepth 的逻辑变了
        int oldDepth = Math.min(last2, last1);
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
                // 相较 3425 题，额外维护 last1
                dfs(y, x, topDepth, Math.max(last1, last2));
                dis.removeLast(); // 恢复现场
            }
        }
        lastDepth.put(color, last2); // 恢复现场
    }
}
/*
3486. 最长特殊路径 II
https://leetcode.cn/problems/longest-special-path-ii/description/

第 152 场双周赛 T4。

给你一棵无向树，根节点为 0，树有 n 个节点，节点编号从 0 到 n - 1。这个树由一个长度为 n - 1 的二维数组 edges 表示，其中 edges[i] = [ui, vi, lengthi] 表示节点 ui 和 vi 之间有一条长度为 lengthi 的边。同时给你一个整数数组 nums，其中 nums[i] 表示节点 i 的值。
一条 特殊路径 定义为一个从祖先节点到子孙节点的 向下 路径，路径中所有节点值都是唯一的，最多允许有一个值出现两次。
返回一个大小为 2 的数组 result，其中 result[0] 是 最长 特殊路径的 长度 ，result[1] 是所有 最长 特殊路径中的 最少 节点数。
提示：
2 <= n <= 5 * 10^4
edges.length == n - 1
edges[i].length == 3
0 <= ui, vi < n
1 <= lengthi <= 10^3
nums.length == n
0 <= nums[i] <= 5 * 10^4
输入保证 edges 是一棵有效的树。

树上滑窗。
相似题目: 3425. 最长特殊路径
https://leetcode.cn/problems/longest-special-path/description/
rating 2929 (clist.by)
 */