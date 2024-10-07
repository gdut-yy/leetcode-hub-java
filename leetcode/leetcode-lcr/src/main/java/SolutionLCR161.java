public class SolutionLCR161 {
    public int maxSales(int[] sales) {
        int pre = 0;
        int maxAns = sales[0];
        for (int v : sales) {
            pre = Math.max(pre + v, v);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
/*
LCR 161. 连续天数的最高销售额
https://leetcode.cn/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/

某公司每日销售额记于整数数组 sales，请返回所有 连续 一或多天销售额总和的最大值。
要求实现时间复杂度为 O(n) 的算法。
提示：
1 <= arr.length <= 10^5
-100 <= arr[i] <= 100

同: 53. 最大子数组和
https://leetcode.cn/problems/maximum-subarray/
 */