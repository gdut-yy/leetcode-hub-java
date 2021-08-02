public class Solution1953 {
    public long numberOfWeeks(int[] milestones) {
        int max = milestones[0];
        long sum = 0;
        for (int milestone : milestones) {
            max = Math.max(max, milestone);
            sum += milestone;
        }
        long diff = sum - max;
        return Math.min(sum, diff * 2 + 1);
    }
}
/*
1953. 你可以工作的最大周数
https://leetcode-cn.com/problems/maximum-number-of-weeks-for-which-you-can-work/

第 252 场周赛 T2。
找出任务数量最多的项目。观察除此之外项目的任务数量之和：
1 2 3 = 6
1 2 4 = 7
1 2 5 = 7

不难得出，答案不会超过除最多之外的和 * 2 + 1，同时显然答案也不会超过原数组各项之和。
取二者较小值即可。
 */