public class SolutionP3253 {
    static int inf = (int) 1e9;

    public int minimumCost(String target, String[] words, int[] costs) {
        int n = target.length();
        int[] dp = new int[n];
        int cost = dfs(target, words, costs, 0, dp);
        return cost >= inf ? -1 : cost;
    }

    private int dfs(String target, String[] words, int[] costs, int index, int[] dp) {
        if (index == target.length()) return 0;
        if (dp[index] != 0) return dp[index];
        String remaining = target.substring(index);
        int minCost = inf;
        for (int i = 0; i < words.length; i++) {
            if (!remaining.startsWith(words[i])) continue;
            minCost = Math.min(minCost, costs[i] + dfs(target, words, costs, index + words[i].length(), dp));
        }
        return dp[index] = minCost;
    }
}
/*
$3253. 最小代价构造字符串（简单）
https://leetcode.cn/problems/construct-string-with-minimum-cost-easy/description/

给你一个字符串 target、一个字符串数组 words 以及一个整数数组 costs，这两个数组长度相同。
设想一个空字符串 s。
你可以执行以下操作任意次数（包括 零 次）：
- 选择一个在范围  [0, words.length - 1] 的索引 i。
- 将 words[i] 追加到 s。
- 该操作的成本是 costs[i]。
返回使 s 等于 target 的 最小 成本。如果不可能，返回 -1。
提示：
1 <= target.length <= 2000
1 <= words.length == costs.length <= 50
1 <= words[i].length <= target.length
target 和 words[i] 仅由小写英文字母组成。
1 <= costs[i] <= 10^5

同: 3213. 最小代价构造字符串
https://leetcode.cn/problems/construct-string-with-minimum-cost/description/
 */