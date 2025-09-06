public class SolutionP3496 {
    public int maxScore(int[] nums) {
        int n = nums.length;
        int sum = nums[0], minSingle = nums[0], minPair = Integer.MAX_VALUE; // 奇数长度剩下一个, 偶数长度剩下相邻的一对
        for (int i = 1; i < n; i++) {
            sum += nums[i];
            minSingle = Math.min(minSingle, nums[i]);
            minPair = Math.min(minPair, nums[i] + nums[i - 1]);
        }
        if (n % 2 == 1) return sum - minSingle;
        return sum - minPair;
    }
}
/*
$3496. 最大化配对删除后的得分
https://leetcode.cn/problems/maximize-score-after-pair-deletions/description/

给定一个整数数组 nums。当数组中元素超过两个时，你 必须 重复执行以下操作中的一个：
- 删除最前面的两个元素。
- 删除最后面的两个元素。
- 删除第一和最后一个元素。
对于每次操作，将移除的元素之和加到你的总分上。
返回你可以达到的 最高 分数。
提示：
1 <= nums.length <= 10^5
-10^4 <= nums[i] <= 10^4

脑筋急转弯。
奇数长度剩下一个, 偶数长度剩下相邻的一对
时间复杂度 O(n)。
 */