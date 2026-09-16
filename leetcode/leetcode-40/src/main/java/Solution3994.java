public class Solution3994 {
    private static final int MOD = (int) (1e9 + 7);

    public int minAdjacentSwaps(int[] nums, int a, int b) {
        int n = nums.length;
        int[] cat = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] < a) {
                cat[i] = 0;
            } else if (nums[i] <= b) {
                cat[i] = 1;
            } else {
                cat[i] = 2;
            }
        }

        long inv = 0;
        long count1 = 0, count2 = 0;
        for (int i = 0; i < n; i++) {
            if (cat[i] == 0) {
                inv += count1 + count2;
            } else if (cat[i] == 1) {
                inv += count2;
            }
            if (cat[i] == 0) {
            } else if (cat[i] == 1) {
                count1++;
            } else {
                count2++;
            }
        }
        return (int) (inv % MOD);
    }
}
/*
3994. 划分数组的最少相邻交换次数
https://leetcode.cn/problems/minimum-adjacent-swaps-to-partition-array/description/

第 187 场双周赛 T3。

给你一个整数数组 nums 和两个整数 a 和 b，满足 a < b。
如果一个数组可以按顺序分成三个 连续 的部分，并且满足以下条件，则称其为 好数组：
- 第一部分中的每个元素都 小于 a。
- 第二部分中的每个元素都 在 闭区间 [a, b] 内。
- 第三部分中的每个元素都 大于 b。
这三个部分中的任意一个都 可以 为空。
在一次 相邻交换 中，你可以交换 nums 的两个 相邻 元素。
返回使 nums 成为好数组所需的 最少 相邻交换次数。由于答案可能非常大，请将其对 10^9 + 7 取余 后返回。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
1 <= a < b <= 10^9

计算逆序对的个数。
时间复杂度 O(n)。
 */