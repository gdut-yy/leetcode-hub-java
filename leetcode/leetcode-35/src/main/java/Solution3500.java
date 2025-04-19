public class Solution3500 {
    // O(n)
    public long minimumCost(int[] nums, int[] cost, int k) {
        int n = nums.length;
        long[] sumNums = new long[n + 1];
        long[] sumCost = new long[n + 1];
        for (int i = 0; i < n; i++) { // nums 和 cost 的前缀和
            sumNums[i + 1] = sumNums[i] + nums[i];
            sumCost[i + 1] = sumCost[i] + cost[i];
        }

        long[] f = new long[n + 1];
        for (int i = 1; i <= n; i++) { // 注意这里 i 从 1 开始，下面不用把 i 加一
            f[i] = Long.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                f[i] = Math.min(f[i], f[j] + sumNums[i] * (sumCost[i] - sumCost[j]) + k * (sumCost[n] - sumCost[j]));
            }
        }
        return f[n];
    }
}
/*
3500. 将数组分割为子数组的最小代价
https://leetcode.cn/problems/minimum-cost-to-divide-array-into-subarrays/description/

第 153 场双周赛 T3。

给你两个长度相等的整数数组 nums 和 cost，和一个整数 k。
你可以将 nums 分割成多个子数组。第 i 个子数组由元素 nums[l..r] 组成，其代价为：
- (nums[0] + nums[1] + ... + nums[r] + k * i) * (cost[l] + cost[l + 1] + ... + cost[r])。
注意，i 表示子数组的顺序：第一个子数组为 1，第二个为 2，依此类推。
返回通过任何有效划分得到的 最小 总代价。
子数组 是一个连续的 非空 元素序列。
提示：
1 <= nums.length <= 1000
cost.length == nums.length
1 <= nums[i], cost[i] <= 1000
1 <= k <= 1000

Abel 求和 + 划分型 DP / O(n) 斜率优化
https://leetcode.cn/problems/minimum-cost-to-divide-array-into-subarrays/solutions/3633352/hua-fen-xing-dp-shi-zi-bian-xing-pythonj-cwi9/
前缀和 & DP
https://leetcode.cn/problems/minimum-cost-to-divide-array-into-subarrays/solutions/3633239/qian-zhui-he-dp-by-tsreaper-7g2c/
没做出来的读者不用灰心，因为如果之前没有接触过倍率转为前（后）缀和的套路，一般很难想到这个转化。
rating 2563 (clist.by)
 */