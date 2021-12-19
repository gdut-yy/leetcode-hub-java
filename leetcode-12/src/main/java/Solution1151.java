public class Solution1151 {
    public int minSwaps(int[] data) {
        int len = data.length;
        int[] preSum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + data[i];
        }

        // 贪心
        // 1 的个数
        int k = preSum[len];
        // [left, left+sum]
        int max = 0;
        for (int i = 0; i + k <= len; i++) {
            max = Math.max(max, preSum[i + k] - preSum[i]);
        }
        return k - max;
    }
}
/*
1151. 最少交换次数来组合所有的 1
https://leetcode-cn.com/problems/minimum-swaps-to-group-all-1s-together/

第 6 场双周赛 T2。

给出一个二进制数组 data，你需要通过交换位置，将数组中 任何位置 上的 1 组合到一起，并返回所有可能中所需 最少的交换次数。
提示：
1 <= data.length <= 10^5
0 <= data[i] <= 1

贪心。假设 1 的个数为 k，固定长度为 k 的滑动窗口思想找包含最多 1 的数目，k 相减即为答案。
时间复杂度 O(n)
 */