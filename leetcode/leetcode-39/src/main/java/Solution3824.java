import java.util.Arrays;

public class Solution3824 {
    public int minimumK(int[] nums) {
        int n = nums.length;
        int mx = Arrays.stream(nums).max().orElseThrow();
        int sqrtN = (int) Math.sqrt(n) + 1;
        int left = 1, right = Math.max(mx, sqrtN);
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(nums, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int[] nums, int k) {
        long limit = (long) k * k;
        long sum = 0;
        for (int num : nums) {
            sum += (num + k - 1) / k;
            if (sum > limit) {
                return false;
            }
        }
        return sum <= limit;
    }
}
/*
3824. 减小数组使其满足条件的最小 K 值
https://leetcode.cn/problems/minimum-k-to-reduce-array-within-limit/description/

第 175 场双周赛 T2。

给你一个 正 整数数组 nums。
对于一个正整数 k，定义 nonPositive(nums, k) 为使 nums 的每个元素都变为 非正数 所需的 最小 操作 次数。在一次操作中，你可以选择一个下标 i 并将 nums[i] 减少 k。
返回一个整数，表示满足 nonPositive(nums, k) <= k^2 的 k 的 最小 值。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^5

二分答案。
https://chat.deepseek.com/a/chat/s/cd1823a6-0992-47e7-a083-fd4077e5ddc7
时间复杂度 O(nlogU)。U = max(sqrt(n), max(nums))
 */