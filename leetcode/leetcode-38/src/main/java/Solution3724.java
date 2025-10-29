public class Solution3724 {
    public long minOperations(int[] nums1, int[] nums2) {
        int n = nums1.length;
        long sum_abs = 0;
        for (int i = 0; i < n; i++) {
            sum_abs += Math.abs(nums1[i] - nums2[i]);
        }

        long minTotal = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int a = nums1[i];
            int b = nums2[i];
            int c = nums2[n];
            int maxVal = Math.max(Math.max(a, b), c);
            int minVal = Math.min(Math.min(a, b), c);
            long cost_i = maxVal - minVal;
            long total = 1L + sum_abs - Math.abs(a - b) + cost_i;
            if (total < minTotal) {
                minTotal = total;
            }
        }
        return minTotal;
    }
}
/*
3724. 转换数组的最少操作次数
https://leetcode.cn/problems/minimum-operations-to-transform-array/description/

第 168 场双周赛 T3。

给你两个整数数组，第一个数组 nums1 长度为 n，以及第二个数组 nums2 长度为 n + 1。
你的目标是使用 最少 的操作次数将 nums1 转换为 nums2。
你可以执行以下操作 任意 次，每次选择一个下标 i：
- 将 nums1[i] 增加 1。
- 将 nums1[i] 减少 1。
- 将 nums1[i] 追加 到数组的 末尾 。
返回将 nums1 转换为 nums2 所需的 最少 操作次数。
提示:
1 <= n == nums1.length <= 10^5
nums2.length == n + 1
1 <= nums1[i], nums2[i] <= 10^5

贪心。分类讨论。
https://yuanbao.tencent.com/chat/naQivTmsDa/28e332cd-d041-4ed8-b6af-c1509cd33466
时间复杂度 O(n)。
 */