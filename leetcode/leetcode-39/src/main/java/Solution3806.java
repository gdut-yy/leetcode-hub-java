import java.util.Collections;
import java.util.PriorityQueue;

public class Solution3806 {
    public int maximumAND(int[] nums, int k, int m) {
        int ans = 0;
        for (int bit = 30; bit >= 0; bit--) {
            int candidate = ans | (1 << bit);
            if (check(nums, k, m, candidate)) {
                ans = candidate;
            }
        }
        return ans;
    }

    private boolean check(int[] nums, int k, int m, int X) {
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;
        for (int num : nums) {
            long cost = cost(num, X);
            if (pq.size() < m) {
                pq.offer(cost);
                sum += cost;
            } else {
                if (cost < pq.peek()) {
                    long top = pq.poll();
                    sum -= top;
                    pq.offer(cost);
                    sum += cost;
                }
            }
        }
        return sum <= k;
    }

    private long cost(int num, int mask) {
        long y = num | mask;
        for (int bit = 30; bit >= 0; bit--) {
            if (((mask >> bit) & 1) == 0 && ((y >> bit) & 1) == 1) {
                long newY = y - (1L << bit);
                if (newY >= num) {
                    y = newY;
                }
            }
        }
        return y - num;
    }
}
/*
3806. 增加操作后最大按位与的结果
https://leetcode.cn/problems/maximum-bitwise-and-after-increment-operations/description/

第 484 场周赛 T4。

给你一个整数数组 nums 和两个整数 k 与 m。
你 最多 可以执行 k 次操作。在每次操作中，你可以选择任意下标 i 并将 nums[i] 增加 1。
返回在执行最多 k 次操作后，任意大小为 m 的 子集 的 按位与 结果的 最大 可能值。
数组的 子集 是指从数组中选择的一组元素。
提示：
1 <= n == nums.length <= 5 * 10^4
1 <= nums[i] <= 10^9
1 <= k <= 10^9
1 <= m <= n

试填法 + 贪心。
时间复杂度 O(nlogU)
rating 2284 (clist.by)
 */