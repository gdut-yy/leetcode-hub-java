import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SolutionP3929 {
    static final long INFINITY = Long.MAX_VALUE / 2;

    record Tuple(long score, int subarrays) {
    }

    public long minPartitionScore(int[] nums, int k) {
        int sumAll = 0;
        for (int num : nums) {
            sumAll += num;
        }
        if (k == 1) {
            return (long) sumAll * (sumAll + 1) / 2;
        }
        int n = nums.length;
        int[] prefixSums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }
        long minScore = INFINITY;
        long low = 0, high = (long) sumAll * sumAll / 4 + 1;
        while (low < high) {
            long mid = low + (high - low + 1) / 2;
            Tuple candidate = computeMinPartitionScoreAndSubarrays(n, prefixSums, mid);
            if (candidate.subarrays() >= k) {
                minScore = candidate.score();
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        minScore -= low * k;
        return minScore;
    }

    public Tuple computeMinPartitionScoreAndSubarrays(int n, int[] prefixSums, long penalty) {
        long[] dp = new long[n + 1];
        int[] subarrays = new int[n + 1];
        Arrays.fill(dp, INFINITY);
        dp[0] = 0;
        subarrays[0] = 0;
        Deque<long[]> queue = new ArrayDeque<long[]>();
        queue.offerLast(getArr(prefixSums[0], dp[0], subarrays[0]));
        for (int j = 1; j <= n; j++) {
            boolean flag1 = true;
            while (queue.size() > 1 && flag1) {
                long[] arr1 = queue.pollFirst();
                long[] arr2 = queue.peekFirst();
                long y1 = arr1[0] * prefixSums[j] + arr1[1];
                long y2 = arr2[0] * prefixSums[j] + arr2[1];
                if (y1 < y2 || y1 == y2 && arr1[2] >= arr2[2]) {
                    queue.offerFirst(arr1);
                    flag1 = false;
                }
            }
            long[] arr = queue.peekFirst();
            dp[j] = arr[0] * prefixSums[j] + arr[1] + (long) prefixSums[j] * (prefixSums[j] + 1) / 2 + penalty;
            subarrays[j] = (int) arr[2] + 1;
            long[] arr3 = getArr(prefixSums[j], dp[j], subarrays[j]);
            boolean flag2 = true;
            while (queue.size() > 1 && flag2) {
                long[] arr2 = queue.pollLast();
                long[] arr1 = queue.peekLast();
                long y1 = (arr1[0] - arr2[0]) * (arr3[1] - arr1[1]);
                long y2 = (arr1[0] - arr3[0]) * (arr2[1] - arr1[1]);
                if (y1 > y2 || y1 == y2 && arr2[2] >= arr3[2]) {
                    queue.offerLast(arr2);
                    flag2 = false;
                }
            }
            queue.offerLast(arr3);
        }
        return new Tuple(dp[n], subarrays[n]);
    }

    public long[] getArr(long prefixSum, long dp, int subarrays) {
        return new long[]{-prefixSum, dp + prefixSum * (prefixSum - 1) / 2, subarrays};
    }
}
/*
$3929. 最小分割分数 II
https://leetcode.cn/problems/minimum-partition-score-ii/description/

给你一个整数数组 nums 和一个整数 k。
你的任务是将 nums 分割成 恰好 k 个子数组，并返回所有有效分割方案中 最小可能的分数。
一个分割方案的 分数 是其所有子数组 值 的 总和。
子数组的 值 定义为 sumArr * (sumArr + 1) / 2，其中 sumArr 是该子数组元素的总和。
子数组 是数组中连续的非空元素序列。
示例 1：
输入： nums = [5,1,2,1], k = 2
输出： 25
示例 2：
输入： nums = [1,2,3,4], k = 1
输出： 55
示例 3：
输入： nums = [1,1,1], k = 3
输出： 3
提示：
1 <= nums.length <= 5 * 10^4
1 <= nums[i] <= 10^3
1 <= k <= nums.length
 */