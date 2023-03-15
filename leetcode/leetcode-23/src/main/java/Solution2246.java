import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2246 {
    private String s;
    private Map<Integer, List<Integer>> adj;
    private int ans;

    public int longestPath(int[] parent, String s) {
        this.s = s;
        adj = new HashMap<>();
        for (int i = 1; i < parent.length; i++) {
            adj.computeIfAbsent(parent[i], key -> new ArrayList<>()).add(i);
        }
        ans = 0;

        dfs(0, -1);
        return ans + 1;
    }

    private int dfs(int x, int fa) {
        int maxLen = 0;
        for (int y : adj.getOrDefault(x, new ArrayList<>())) {
            if (y == fa) {
                continue;
            }
            int len = dfs(y, x);
            if (s.charAt(y) != s.charAt(x)) {
                ans = Math.max(ans, maxLen + len);
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen + 1;
    }
}
/*
2246. 相邻字符不同的最长路径
https://leetcode.cn/problems/longest-path-with-different-adjacent-characters/

第 289 场周赛 T4。

给你一棵 树（即一个连通、无向、无环图），根节点是节点 0 ，这棵树由编号从 0 到 n - 1 的 n 个节点组成。
用下标从 0 开始、长度为 n 的数组 parent 来表示这棵树，其中 parent[i] 是节点 i 的父节点，由于节点 0 是根节点，所以 parent[0] == -1 。
另给你一个字符串 s ，长度也是 n ，其中 s[i] 表示分配给节点 i 的字符。
请你找出路径上任意一对相邻节点都没有分配到相同字符的 最长路径 ，并返回该路径的长度。
提示：
n == parent.length == s.length
1 <= n <= 10^5
对所有 i >= 1 ，0 <= parent[i] <= n - 1 均成立
parent[0] == -1
parent 表示一棵有效的树
s 仅由小写英文字母组成

树形 DP
时间复杂度 O(n)
如果用 时间复杂度 O(n^2) 的 BFS/DFS 会 TLE
相似题目: $1245. 树的直径
https://leetcode.cn/problems/tree-diameter/
 */