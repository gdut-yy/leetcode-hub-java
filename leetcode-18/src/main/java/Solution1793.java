import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution1793 {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;

        // step1: 求左侧第一个 "严格小于" arr[i] 的下标，如没有则为 0
        Deque<Integer> stack1 = new ArrayDeque<>();
        int[] left = new int[n];
        Arrays.fill(left, 0);
        for (int i = 0; i < n; i++) {
            while (!stack1.isEmpty() && nums[i] <= nums[stack1.peek()]) {
                stack1.pop();
            }
            if (!stack1.isEmpty()) {
                left[i] = stack1.peek() + 1;
            }
            stack1.push(i);
        }

        // step2: 求右侧第一个 "小于等于" arr[i] 的下标，如没有则为 n-1
        Deque<Integer> stack2 = new ArrayDeque<>();
        int[] right = new int[n];
        Arrays.fill(right, n - 1);
        for (int i = n - 1; i >= 0; i--) {
            // <= 为避免重复计算
            while (!stack2.isEmpty() && nums[i] < nums[stack2.peek()]) {
                stack2.pop();
            }
            if (!stack2.isEmpty()) {
                right[i] = stack2.peek() - 1;
            }
            stack2.push(i);
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            int l = left[i];
            int r = right[i];
            if (l <= k && k <= r) {
                max = Math.max(max, nums[i] * (r - l + 1));
            }
        }
        return max;
    }
}
/*
1793. 好子数组的最大分数
https://leetcode.cn/problems/maximum-score-of-a-good-subarray/

给你一个整数数组 nums （下标从 0 开始）和一个整数 k 。
一个子数组 (i, j) 的 分数 定义为 min(nums[i], nums[i+1], ..., nums[j]) * (j - i + 1) 。一个 好 子数组的两个端点下标需要满足 i <= k <= j 。
请你返回 好 子数组的最大可能 分数 。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 2 * 10^4
0 <= k < nums.length

相似题目: 907. 子数组的最小值之和
https://leetcode.cn/problems/sum-of-subarray-minimums/
1856. 子数组最小乘积的最大值
https://leetcode.cn/problems/maximum-subarray-min-product/
 */