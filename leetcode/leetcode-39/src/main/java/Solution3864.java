public class Solution3864 {
    public long minCost(String s, int encCost, int flatCost) {
        int n = s.length();
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + (s.charAt(i) - '0');
        }
        return dfs(0, n, sum, encCost, flatCost);
    }

    // 计算子串 [l, r) 的最小费用，注意区间是左闭右开，方便计算
    private long dfs(int l, int r, int[] sum, int encCost, int flatCost) {
        // 不拆分
        int x = sum[r] - sum[l];
        long res = x > 0 ? (long) (r - l) * x * encCost : flatCost;

        // 拆分
        if ((r - l) % 2 == 0) {
            int m = (l + r) / 2;
            res = Math.min(res, dfs(l, m, sum, encCost, flatCost) + dfs(m, r, sum, encCost, flatCost));
        }

        return res;
    }
}
/*
3864. 划分二进制字符串的最小费用
https://leetcode.cn/problems/minimum-cost-to-partition-a-binary-string/description/

第 492 场周赛 T4。

给你一个二进制字符串 s 和两个整数 encCost 与 flatCost。
对于每个下标 i，s[i] = '1' 表示第 i 个元素是敏感的，而 s[i] = '0' 表示它不是敏感的。
该字符串必须被划分为 分段。最初，整个字符串形成一个单一的分段。
对于一个长度为 L 且包含 X 个敏感元素的分段:
- 如果 X = 0，费用为 flatCost。
- 如果 X > 0，费用为 L * X * encCost。
如果一个分段具有 偶数长度，你可以将其拆分为两个长度 相等 的 连续分段，此次拆分的费用是所得分段的 费用之和。
返回一个整数，表示所有有效划分中的 最小可能总费用。
提示：
1 <= s.length <= 10^5
s 仅由 '0' 和 '1' 组成。
1 <= encCost, flatCost <= 10^5

暴力分治。
https://leetcode.cn/problems/minimum-cost-to-partition-a-binary-string/solutions/3917785/bao-li-fen-zhi-ji-ke-shi-jian-fu-za-du-o-dm36/
时间复杂度 O(n)。
 */