public class Solution2483 {
    public int bestClosingTime(String customers) {
        int len = customers.length();

        char[] chars = customers.toCharArray();
        int cntY = 0;
        for (char ch : chars) {
            if (ch == 'Y') {
                cntY++;
            }
        }

        int res = 0;
        // 0 时刻关门
        int min = cntY;

        int cntY1 = 0;
        int cntN1 = 0;
        for (int i = 1; i <= len; i++) {
            char ch = chars[i - 1];
            if (ch == 'Y') {
                cntY1++;
            } else {
                cntN1++;
            }

            // 关门
            int cost = cntN1 + cntY - cntY1;
            if (cost < min) {
                res = i;
                min = cost;
            }
        }
        return res;
    }
}
/*
2483. 商店的最少代价
https://leetcode.cn/problems/minimum-penalty-for-a-shop/

第 92 场双周赛 T3。

给你一个顾客访问商店的日志，用一个下标从 0 开始且只包含字符 'N' 和 'Y' 的字符串 customers 表示：
- 如果第 i 个字符是 'Y' ，它表示第 i 小时有顾客到达。
- 如果第 i 个字符是 'N' ，它表示第 i 小时没有顾客到达。
如果商店在第 j 小时关门（0 <= j <= n），代价按如下方式计算：
- 在开门期间，如果某一个小时没有顾客到达，代价增加 1 。
- 在关门期间，如果某一个小时有顾客到达，代价增加 1 。
请你返回在确保代价 最小 的前提下，商店的 最早 关门时间。
注意，商店在第 j 小时关门表示在第 j 小时以及之后商店处于关门状态。
提示：
1 <= customers.length <= 10^5
customers 只包含字符 'Y' 和 'N' 。

枚举，枚举灭个小时关门的损失，取最小值。
时间复杂度 O(n)
 */