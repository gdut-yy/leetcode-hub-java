import java.util.Arrays;

public class Solution3457 {
    public long maxWeight(int[] pizzas) {
        int n = pizzas.length;
        Arrays.sort(pizzas);
        long ans = 0;
        int k = n / 4;
        int even = k / 2;
        int odd = k - even;
        int j = n - 1;
        for (int i = 0; i < k; i++) {
            if (i < odd) {
                ans += pizzas[j];
                j -= 1;
            } else {
                j -= 1;
                ans += pizzas[j];
                j -= 1;
            }
        }
        return ans;
    }
}
/*
3457. 吃披萨
https://leetcode.cn/problems/eat-pizzas/description/

第 437 场周赛 T2。

给你一个长度为 n 的整数数组 pizzas，其中 pizzas[i] 表示第 i 个披萨的重量。每天你会吃 恰好 4 个披萨。由于你的新陈代谢能力惊人，当你吃重量为 W、X、Y 和 Z 的披萨（其中 W <= X <= Y <= Z）时，你只会增加 1 个披萨的重量！体重增加规则如下：
- 在 奇数天（按 1 开始计数）你会增加 Z 的重量。
- 在 偶数天，你会增加 Y 的重量。
请你设计吃掉 所有 披萨的最优方案，并计算你可以增加的 最大 总重量。
注意：保证 n 是 4 的倍数，并且每个披萨只吃一次。
提示：
4 <= n == pizzas.length <= 2 * 10^5
1 <= pizzas[i] <= 10^5
n 是 4 的倍数。

贪心。
奇数天选最大的，偶数天只能选次大的。排序后先选完最大的，再选次大的。
用交换论证法可以证明这是最优的。
相似题目: 1561. 你可以获得的最大硬币数目
https://leetcode.cn/problems/maximum-number-of-coins-you-can-get/description/
 */