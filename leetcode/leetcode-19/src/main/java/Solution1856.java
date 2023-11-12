import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution1856 {
    private static final int MOD = (int) (1e9 + 7);

    public int maxSumMinProduct(int[] nums) {
        int n = nums.length;

        // step1: 求左侧第一个 "严格小于" arr[i] 的下标，如没有则为 0
        Deque<Integer> st = new ArrayDeque<>();
        st.push(-1); // 哨兵
        int[] posL = new int[n];
        for (int i = 0; i < n; i++) {
            while (st.size() > 1 && nums[i] <= nums[st.peek()]) st.pop();
            posL[i] = st.peek() + 1;
            st.push(i);
        }

        // step2: 求右侧第一个 "小于等于" arr[i] 的下标，如没有则为 n-1
        st.clear();
        st.push(n); // 哨兵
        int[] posR = new int[n];
        Arrays.fill(posR, n - 1);
        for (int i = n - 1; i >= 0; i--) {
            while (st.size() > 1 && nums[i] < nums[st.peek()]) st.pop();
            posR[i] = st.peek() - 1;
            st.push(i);
        }

        // 前缀和
        long[] preSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            long product = (preSum[posR[i] + 1] - preSum[posL[i]]) * nums[i];
            ans = Math.max(ans, product);
        }
        return (int) (ans % MOD);
    }
}
/*
1856. 子数组最小乘积的最大值
https://leetcode.cn/problems/maximum-subarray-min-product/

一个数组的 最小乘积 定义为这个数组中 最小值 乘以 数组的 和 。
- 比方说，数组 [3,2,5] （最小值是 2）的最小乘积为 2 * (3+2+5) = 2 * 10 = 20 。
给你一个正整数数组 nums ，请你返回 nums 任意 非空子数组 的最小乘积 的 最大值 。由于答案可能很大，请你返回答案对  10^9 + 7 取余 的结果。
请注意，最小乘积的最大值考虑的是取余操作 之前 的结果。题目保证最小乘积的最大值在 不取余 的情况下可以用 64 位有符号整数 保存。
子数组 定义为一个数组的 连续 部分。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^7

单调栈 + 贪心
时间复杂度 O(n)
相似题目: 1793. 好子数组的最大分数
https://leetcode.cn/problems/maximum-score-of-a-good-subarray/
2281. 巫师的总力量和
https://leetcode.cn/problems/sum-of-total-strength-of-wizards/
 */