import java.util.Arrays;

public class Solution4014 {
    public double minPrice(int[] prices, int[] discounts) {
        int n = prices.length;
        int m = discounts.length;
        Arrays.sort(prices);
        Arrays.sort(discounts);

        long ans = 0;
        for (int i = 0; i < n; i++) {
            int d = i < m ? discounts[m - 1 - i] : 0;
            ans += (long) prices[n - 1 - i] * (100 - d);
        }
        return ans / 100.; // 只做一次浮点运算
    }
}
/*
4014. 应用折扣后的最低总价
https://leetcode.cn/problems/minimum-total-price-after-applying-discounts/description/

第 514 场周赛 T1。

给你两个整数数组 prices 和 discounts。
prices[i] 表示第 ith 件商品的价格，discounts[j] 表示一个折扣百分比。
你可以按照以下规则使用折扣：
- 每个折扣 最多 只能用于一件商品。
- 每件商品 最多 只能使用一个折扣。
- 商品也可以不使用任何折扣。
如果将 d% 的折扣应用于价格为 p 的商品，则其最终价格为 (p * (100 - d)) / 100。最终价格 不进行四舍五入 。
请以最优方式分配折扣，并返回所有商品最终价格之和的 最小值 。与实际答案的误差在 10^-5 以内的结果都将被接受。
提示：
1 <= prices.length, discounts.length <= 10^5
1 <= prices[i] <= 10^5
1 <= discounts[j] <= 100

中国时间 2026-08-09 周日 10:30
深圳。因为老碗会太难吃 吵架。
排序不等式。
时间复杂度 O(nlogn + mlogm)。
 */