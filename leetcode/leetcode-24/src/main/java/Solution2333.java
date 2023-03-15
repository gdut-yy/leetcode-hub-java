import java.util.Arrays;

public class Solution2333 {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;

        long k = k1 + k2;

        long[] abs = new long[n + 1];
        for (int i = 0; i < n; i++) {
            abs[i + 1] = Math.abs(nums1[i] - nums2[i]);
        }
        Arrays.sort(abs);

        for (int i = n; i >= 0; i--) {
            if (abs[i] == abs[n] && i != 0) {
                continue;
            }
            // 宽
            long width = n - i;
            long maxHeight = abs[n] - abs[i];

            // 可消耗掉的高度
            long costHeight = Math.min(maxHeight, k / width);
            if (costHeight > 0) {
                // 消耗掉的总数
                k -= costHeight * width;
                for (int j = i + 1; j <= n; j++) {
                    abs[j] -= costHeight;
                }
            }
            if (abs[i + 1] > 0) {
                // 处理余数
                if (k / width < 1) {
                    for (int j = 0; j < k; j++) {
                        abs[n - j]--;
                    }
                    break;
                }

            }
        }

        long res = 0;
        for (long ab : abs) {
            res += ab * ab;
        }
        return res;
    }
}
/*
2333. 最小差值平方和
https://leetcode.cn/problems/minimum-sum-of-squared-difference/

第 82 场双周赛 T3。

给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，长度为 n 。
数组 nums1 和 nums2 的 差值平方和 定义为所有满足 0 <= i < n 的 (nums1[i] - nums2[i])2 之和。
同时给你两个正整数 k1 和 k2 。你可以将 nums1 中的任意元素 +1 或者 -1 至多 k1 次。类似的，你可以将 nums2 中的任意元素 +1 或者 -1 至多 k2 次。
请你返回修改数组 nums1 至多 k1 次且修改数组 nums2 至多 k2 次后的最小 差值平方和 。
注意：你可以将数组中的元素变成 负 整数。
提示：
n == nums1.length == nums2.length
1 <= n <= 10^5
0 <= nums1[i], nums2[i] <= 10^5
0 <= k1, k2 <= 10^9

贪心。优先处理差值绝对值较大的下标。
相似题目: 1648. 销售价值减少的颜色球
https://leetcode.cn/problems/sell-diminishing-valued-colored-balls/
 */