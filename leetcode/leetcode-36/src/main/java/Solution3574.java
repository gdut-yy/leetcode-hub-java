public class Solution3574 {
    public long maxGCDScore(int[] nums, int k) {
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int lowbitMin = Integer.MAX_VALUE;
            int lowbitCnt = 0;
            int g = 0;
            for (int j = i; j >= 0; j--) {
                int x = nums[j];
                int lb = x & -x;
                if (lb < lowbitMin) {
                    lowbitMin = lb;
                    lowbitCnt = 1;
                } else if (lb == lowbitMin) {
                    lowbitCnt++;
                }

                g = getGCD(g, x);
                int newG = lowbitCnt <= k ? g * 2 : g;
                ans = Math.max(ans, (long) newG * (i - j + 1));
            }
        }
        return ans;
    }

    private int getGCD(int num1, int num2) {
        return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
    }
}
/*
3574. 最大子数组 GCD 分数
https://leetcode.cn/problems/maximize-subarray-gcd-score/description/

第 158 场双周赛 T3。

给你一个正整数数组 nums 和一个整数 k。
你最多可以执行 k 次操作。在每次操作中，你可以选择数组中的一个元素并将其值 翻倍 。每个元素 最多 只能翻倍一次。
连续 子数组 的 分数 定义为其所有元素的最大公约数 (GCD) 与子数组长度的 乘积 。
你的任务是返回修改后数组中选择一个连续子数组可以获得的最大 分数 。
注意：
- 子数组 是数组中连续的元素序列。
- 数组的 最大公约数 (GCD) 是能整除数组所有元素的最大整数。
提示：
1 <= n == nums.length <= 1500
1 <= nums[i] <= 10^9
1 <= k <= n

两种方法：暴力枚举 / logTrick
https://leetcode.cn/problems/maximize-subarray-gcd-score/solutions/3695642/liang-chong-xie-fa-bao-li-mei-ju-logtric-zz7e/
rating 2252 (clist.by)
 */