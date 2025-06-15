import java.util.ArrayDeque;
import java.util.Deque;

public class Solution3578 {
    private static final int MOD = (int) (1e9 + 7);

    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        long[] f = new long[n + 1];
        f[0] = 1;
        int left = 0;
        long curSum = 1;

        Deque<Integer> maxQ = new ArrayDeque<>();
        Deque<Integer> minQ = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!maxQ.isEmpty() && nums[maxQ.peekLast()] <= nums[i]) {
                maxQ.pollLast();
            }
            maxQ.addLast(i);

            while (!minQ.isEmpty() && nums[minQ.peekLast()] >= nums[i]) {
                minQ.pollLast();
            }
            minQ.addLast(i);

            while (!maxQ.isEmpty() && !minQ.isEmpty() &&
                    nums[maxQ.peekFirst()] - nums[minQ.peekFirst()] > k) {
                curSum = (curSum - f[left] + MOD) % MOD;

                if (!maxQ.isEmpty() && maxQ.peekFirst() == left) {
                    maxQ.pollFirst();
                }
                if (!minQ.isEmpty() && minQ.peekFirst() == left) {
                    minQ.pollFirst();
                }

                left++;
            }

            f[i + 1] = curSum;
            curSum = (curSum + f[i + 1]) % MOD;
        }

        return (int) (f[n] % MOD);
    }
}
/*
3578. 统计极差最大为 K 的分割方式数
https://leetcode.cn/problems/count-partitions-with-max-min-difference-at-most-k/description/

第 453 场周赛 T3。

给你一个整数数组 nums 和一个整数 k。你的任务是将 nums 分割成一个或多个 非空 的连续子段，使得每个子段的 最大值 与 最小值 之间的差值 不超过 k。
返回在此条件下将 nums 分割的总方法数。
由于答案可能非常大，返回结果需要对 10^9 + 7 取余数。
提示：
2 <= nums.length <= 5 * 10^4
1 <= nums[i] <= 10^9
0 <= k <= 10^9

划分型 DP + 单调队列优化
https://leetcode.cn/problems/count-partitions-with-max-min-difference-at-most-k/solutions/3695716/hua-fen-xing-dp-dan-diao-dui-lie-you-hua-9rtj/
 */