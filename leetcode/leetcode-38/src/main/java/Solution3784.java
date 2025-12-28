import java.util.Arrays;

public class Solution3784 {
    public long minCost(String s, int[] cost) {
        int n = s.length();
        long tot = 0;
        long[] costs = new long[26];
        for (int i = 0; i < n; i++) {
            tot += cost[i];
            int b = s.charAt(i) - 'a';
            costs[b] += cost[i];
        }
        return tot - Arrays.stream(costs).max().orElseThrow();
    }
}
/*
3784. 使所有字符相等的最小删除代价
https://leetcode.cn/problems/minimum-deletion-cost-to-make-all-characters-equal/description/

第 481 场周赛 T2。

给你一个长度为 n 的字符串 s 和一个整数数组 cost，其中 cost[i] 表示 删除 字符串 s 中第 i 个字符的代价。
你可以从字符串 s 中删除任意数量的字符（也可以不删除），使得最终的字符串 非空 且由 相同 字符组成。
返回实现上述目标所需的 最小 总删除代价。
提示：
n == s.length == cost.length
1 <= n <= 10^5
1 <= cost[i] <= 10^9
s 仅由小写英文字母组成。

贪心。保留数量最多的字符。
时间复杂度 O(n)。
 */