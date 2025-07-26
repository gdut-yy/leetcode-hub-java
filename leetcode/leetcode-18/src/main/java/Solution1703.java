import java.util.ArrayList;
import java.util.List;

public class Solution1703 {
    public int minMoves(int[] nums, int k) {
        List<Integer> p = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) p.add(i - p.size());
        }
        int m = p.size();
        int[] ps = new int[m + 1]; // p 的前缀和
        for (int i = 0; i < m; i++) {
            ps[i + 1] = ps[i] + p.get(i);
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= m - k; ++i) { // p[i] 到 p[i+k-1] 中所有数到 p[i+k/2] 的距离之和，取最小值
            ans = Math.min(ans, ps[i] + ps[i + k] - ps[i + k / 2] * 2 - p.get(i + k / 2) * (k % 2));
        }
        return ans;
    }
}
/*
1703. 得到连续 K 个 1 的最少相邻交换次数
https://leetcode.cn/problems/minimum-adjacent-swaps-for-k-consecutive-ones/description/

给你一个整数数组 nums 和一个整数 k 。 nums 仅包含 0 和 1 。每一次移动，你可以选择 相邻 两个数字并将它们交换。
请你返回使 nums 中包含 k 个 连续 1 的 最少 交换次数。
提示：
1 <= nums.length <= 10^5
nums[i] 要么是 0 ，要么是 1 。
1 <= k <= sum(nums)

转换成中位数贪心+空间优化 https://leetcode.cn/problems/minimum-adjacent-swaps-for-k-consecutive-ones/solutions/2024387/tu-jie-zhuan-huan-cheng-zhong-wei-shu-ta-iz4v/
时间复杂度 O(n)。
 */