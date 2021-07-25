import java.util.Arrays;

public class Solution1833 {
    public int maxIceCream(int[] costs, int coins) {
        // 贪心
        Arrays.sort(costs);
        // 前缀和剪枝
        int len = costs.length;
        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + costs[i];
            if (preSum[i + 1] > coins) {
                return i;
            }
        }
        return len;
    }
}
/*
1833. 雪糕的最大数量
https://leetcode-cn.com/problems/maximum-ice-cream-bars/

第 237 场周赛 T2。
贪心法+前缀和。要想买尽可能多的雪糕，当然是从最便宜的开始买。
 */