import java.util.Arrays;

public class Solution3679 {
    public int minArrivalsToDiscard(int[] arrivals, int w, int m) {
        int n = arrivals.length;
        int mx = Arrays.stream(arrivals).max().orElseThrow();
        int[] cnt = new int[mx + 1];
        int ans = 0;
        boolean[] discarded = new boolean[n]; // 丢弃
        for (int i = 0; i < w; i++) {
            if (++cnt[arrivals[i]] > m) {
                ans++;
                --cnt[arrivals[i]];
                discarded[i] = true;
            }
        }
        for (int i = w; i < n; i++) {
            if (!discarded[i - w]) --cnt[arrivals[i - w]];
            if (++cnt[arrivals[i]] > m) {
                ans++;
                --cnt[arrivals[i]];
                discarded[i] = true;
            }
        }
        return ans;
    }
}
/*
3679. 使库存平衡的最少丢弃次数
https://leetcode.cn/problems/minimum-discards-to-balance-inventory/description/

第 165 场双周赛 T2。

给你两个整数 w 和 m，以及一个整数数组 arrivals，其中 arrivals[i] 表示第 i 天到达的物品类型（天数从 1 开始编号）。
物品的管理遵循以下规则：
- 每个到达的物品可以被 保留 或 丢弃 ，物品只能在到达当天被丢弃。
- 对于每一天 i，考虑天数范围为 [max(1, i - w + 1), i]（也就是直到第 i 天为止最近的 w 天）：
  - 对于 任何 这样的时间窗口，在被保留的到达物品中，每种类型最多只能出现 m 次。
  - 如果在第 i 天保留该到达物品会导致其类型在该窗口中出现次数 超过 m 次，那么该物品必须被丢弃。
返回为满足每个 w 天的窗口中每种类型最多出现 m 次，最少 需要丢弃的物品数量。
提示：
1 <= arrivals.length <= 10^5
1 <= arrivals[i] <= 10^5
1 <= w <= arrivals.length
1 <= m <= w

固定大小的 滑动窗口。
时间复杂度 O(n)
 */