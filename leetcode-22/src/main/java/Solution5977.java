public class Solution5977 {
    public int minSwaps(int[] nums) {
        int len = nums.length;
        int len2 = len * 2;
        // 两倍长度数组
        int[] nums2 = new int[len * 2];
        for (int i = 0; i < len; i++) {
            nums2[i] = nums[i];
            nums2[i + len] = nums[i];
        }

        // 前缀和
        int[] preSum = new int[len2 + 1];
        for (int i = 0; i < len2; i++) {
            preSum[i + 1] = preSum[i] + nums2[i];
        }

        // 贪心
        // 1 的个数
        int k = preSum[len];
        // [left, left+sum]
        int max = 0;
        for (int i = 0; i + k <= len2; i++) {
            max = Math.max(max, preSum[i + k] - preSum[i]);
        }
        return k - max;
    }
}
/*
5977. 最少交换次数来组合所有的 1 II
https://leetcode-cn.com/problems/minimum-swaps-to-group-all-1s-together-ii/

第 275 场周赛 T2。

交换 定义为选中一个数组中的两个 互不相同 的位置并交换二者的值。
环形 数组是一个数组，可以认为 第一个 元素和 最后一个 元素 相邻 。
给你一个 二进制环形 数组 nums ，返回在 任意位置 将数组中的所有 1 聚集在一起需要的最少交换次数。

两倍长度数组模拟 环形数组。
其余做法同 1151，前缀和统计固定大小滑动窗口内 1 的个数。

相似题目: 1151. 最少交换次数来组合所有的 1
https://leetcode-cn.com/problems/minimum-swaps-to-group-all-1s-together/
 */