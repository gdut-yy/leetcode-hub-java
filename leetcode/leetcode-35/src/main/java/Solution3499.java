public class Solution3499 {
    // T2
    public int maxActiveSectionsAfterTrade(String S) {
        char[] s = S.toCharArray();
        int n = s.length;
        int cnt1 = 0;
        for (char c : s) {
            if (c == '1') cnt1++;
        }

        int pre_0_len = -1;
        int ans = 0;
        int i = 0;
        while (i < n) {
            int st = i;
            for (i++; i < n && s[i] == s[st]; i++) {
            }
            if (s[st] == '0') {
                if (pre_0_len != -1) {
                    ans = Math.max(ans, pre_0_len + (i - st));
                }
                pre_0_len = i - st;
            }
        }
        return ans + cnt1;
    }
}
/*
3499. 操作后最大活跃区段数 I
https://leetcode.cn/problems/maximize-active-section-with-trade-i/description/

第 153 场双周赛 T2。

给你一个长度为 n 的二进制字符串 s，其中：
- '1' 表示一个 活跃 区段。
- '0' 表示一个 非活跃 区段。
你可以执行 最多一次操作 来最大化 s 中的活跃区段数量。在一次操作中，你可以：
- 将一个被 '0' 包围的连续 '1' 区块转换为全 '0'。
- 然后，将一个被 '1' 包围的连续 '0' 区块转换为全 '1'。
返回在执行最优操作后，s 中的 最大 活跃区段数。
注意：处理时需要在 s 的两侧加上 '1' ，即 t = '1' + s + '1'。这些加上的 '1' 不会影响最终的计数。
提示：
1 <= n == s.length <= 10^5
s[i] 仅包含 '0' 或 '1'

分组循环。
求最长 0-1-0 段的 0 数量 + 1 的数量。
时间复杂度 O(n)。
 */