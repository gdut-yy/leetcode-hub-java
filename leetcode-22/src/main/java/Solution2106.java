public class Solution2106 {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        // 0 <= startPos, positioni <= 2 * 10^5
        // 预处理前缀和
        int maxLen = 200000 + 5;
        int[] fruitsNums = new int[maxLen];
        for (int[] fruit : fruits) {
            fruitsNums[fruit[0]] = fruit[1];
        }
        // 1 <= amounti <= 10^4 不会爆 int
        int[] preSum = new int[maxLen + 1];
        for (int i = 0; i < maxLen; i++) {
            preSum[i + 1] = preSum[i] + fruitsNums[i];
        }

        // 向右 a 步
        // 向左 k - 2a 步
        int max = 0;
        for (int a = 0; a <= k; a++) {
            int rightMax = startPos + a;
            rightMax = Math.min(rightMax, maxLen - 1);
            // [startPos, rightMax]
            int rightTotal = preSum[rightMax + 1] - preSum[startPos];
            int leftTotal = 0;
            if (k - 2 * a > 0) {
                int leftMax = startPos - (k - 2 * a);
                leftMax = Math.max(0, leftMax);
                // [leftMax, startPos)
                leftTotal = preSum[startPos] - preSum[leftMax];
            }
            max = Math.max(max, rightTotal + leftTotal);
        }

        // 向左 a 步
        // 向右 k - 2a 步
        for (int a = 0; a <= k; a++) {
            int leftMax = startPos - a;
            leftMax = Math.max(0, leftMax);
            // [leftMax, startPos]
            int leftTotal = preSum[startPos + 1] - preSum[leftMax];
            int rightTotal = 0;
            if (k - 2 * a > 0) {
                int rightMax = startPos + (k - 2 * a);
                rightMax = Math.min(rightMax, maxLen - 1);
                // (startPos, rightMax]
                rightTotal = preSum[rightMax + 1] - preSum[startPos + 1];
            }
            max = Math.max(max, rightTotal + leftTotal);
        }
        return max;
    }
}
/*
2106. 摘水果
https://leetcode.cn/problems/maximum-fruits-harvested-after-at-most-k-steps/

第 271 场周赛 T4。

在一个无限的 x 坐标轴上，有许多水果分布在其中某些位置。给你一个二维整数数组 fruits ，其中 fruits[i] = [positioni, amounti]
表示共有 amounti 个水果放置在 positioni 上。fruits 已经按 positioni 升序排列 ，每个 positioni 互不相同 。
另给你两个整数 startPos 和 k 。最初，你位于 startPos 。从任何位置，你可以选择 向左或者向右 走。在 x 轴上每移动 一个单位 ，
就记作 一步 。你总共可以走 最多 k 步。你每达到一个位置，都会摘掉全部的水果，水果也将从该位置消失（不会再生）。
返回你可以摘到水果的 最大总数 。

范围 10^5
时间复杂度 O(n)
前缀和 + 分别枚举向左向右步数
 */