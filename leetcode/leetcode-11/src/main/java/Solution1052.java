public class Solution1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int len = customers.length;

        int res = 0;
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            if (grumpy[i] == 1) {
                nums[i] = customers[i];
            } else {
                // 情绪稳定时的顾客总和
                res += customers[i];
            }
        }

        // 前 minutes 个
        for (int i = 0; i < minutes; i++) {
            res += nums[i];
        }
        int max = res;
        for (int i = minutes; i < len; i++) {
            res += nums[i] - nums[i - minutes];
            max = Math.max(max, res);
        }
        return max;
    }
}
/*
1052. 爱生气的书店老板
https://leetcode.cn/problems/grumpy-bookstore-owner/

有一个书店老板，他的书店开了 n 分钟。每分钟都有一些顾客进入这家商店。
给定一个长度为 n 的整数数组 customers ，其中 customers[i] 是在第 i 分钟开始时进入商店的顾客数量，所有这些顾客在第 i 分钟结束后离开。
在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。
当书店老板生气时，那一分钟的顾客就会不满意，若老板不生气则顾客是满意的。
书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 minutes 分钟不生气，但却只能使用一次。
请你返回 这一天营业下来，最多有多少客户能够感到满意 。
提示：
n == customers.length == grumpy.length
1 <= minutes <= n <= 2 * 10^4
0 <= customers[i] <= 1000
grumpy[i] == 0 or 1

grumpy[i] = 0 的部分不需要考虑，求 grumpy[i] = 1 的部分固定窗口长度的最大和即可。
 */